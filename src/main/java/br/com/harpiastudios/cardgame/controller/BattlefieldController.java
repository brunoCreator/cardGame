/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.controller;

import br.com.harpiastudios.cardgame.enumerator.DifficultyEnum;
import br.com.harpiastudios.cardgame.enumerator.TargetEnum;
import br.com.harpiastudios.cardgame.enumerator.TurnEnum;
import br.com.harpiastudios.cardgame.model.Card;
import br.com.harpiastudios.cardgame.model.CardField;
import br.com.harpiastudios.cardgame.model.Effect;
import br.com.harpiastudios.cardgame.model.Enemy;
import br.com.harpiastudios.cardgame.model.Player;
import br.com.harpiastudios.cardgame.view.BattlefieldView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Diego
 */
public class BattlefieldController {

    private final BattlefieldView view;
    private TurnEnum turn = TurnEnum.PLAYER;
    private int turnCount = 0;
    private final Player player;
    private final Enemy enemy;
    private ArrayList<CardField> fields = new ArrayList();
    private Random rand = new Random();

    public BattlefieldController(Player player, Enemy enemy, BattlefieldView view) {
        this.player = player;
        this.enemy = enemy;
        this.view = view;
        fields = view.getFields();
        UpdatePlayerHand();
    }

    public void IncreaseTurn() {
        enemy.setMana((int) ((2 * (turnCount + 1)) / 1.5));
        player.setMana((int) ((2 * (turnCount + 1)) / 1.5));
        turnCount++;
        view.Update();
    }

    public void SkipTurn() {
        String log = view.getTaLog().getText();
        if (turn == TurnEnum.PLAYER) {
            view.getTaLog().setText(log + "\n" + "Turno: " + String.valueOf(turnCount) + " |" + " O jogador passou o turno.");
            turn = TurnEnum.ENEMY;
            IncreaseTurn();
            Buy(true);
            EnemyAttack();
        } else {
            view.getTaLog().setText(log + "\n" + "Turno: " + String.valueOf(turnCount) + " |" + " O inimigo passou o turno.");
            turn = TurnEnum.PLAYER;
            IncreaseTurn();
            Buy(false);
            int index = 0;
            fields.forEach(f -> {
                f.setEnabled(false);
            });
            for (Card c : player.getHand()) {
                fields.get(index).setCarta(c);
                fields.get(index).Update();
                index++;
            }
        }
    }

    public TurnEnum getTurn() {
        return turn;
    }

    public CardField getSelectedField() {
        for (CardField f : fields) {
            if (f.isSelected()) {
                return f;
            }
        }
        return null;
    }

    public boolean hasFieldSelected() {
        boolean result = false;
        for (CardField f : fields) {
            if (f.isSelected()) {
                result = true;
            }
        }
        return result;
    }

    public void Buy(boolean isEnemy) {
        String log = view.getTaLog().getText();
        if (enemy.getHand().size() < 6 && isEnemy && enemy.getDeck().getCards().size() > 0) {
            view.getTaLog().setText(log + "\n" + "Turno: " + String.valueOf(turnCount) + " |" + " O inimigo comprou uma carta.");
            enemy.getHand().add(enemy.getDeck().get());
        }
        if (player.getHand().size() < 6 && !isEnemy && player.getDeck().getCards().size() > 0) {
            Card card = player.getDeck().get();
            view.getTaLog().setText(log + "\n" + "Turno: " + String.valueOf(turnCount) + " |" + " O jogador (você) comprou uma carta: " + card.getNome() + ".");
            player.getHand().add(card);
            int index = 0;
            fields.forEach(f -> {
                f.setEnabled(false);
            });
            for (Card c : player.getHand()) {
                fields.get(index).setCarta(c);
                fields.get(index).Update();
                index++;
            }
        }
    }

    public void Attack(boolean isEnemy) {
        String log = view.getTaLog().getText();
        if (!isEnemy) {
            Card card = getSelectedField().getCarta();
            view.getTaLog().setText(log + "\n" + "Turno: " + String.valueOf(turnCount) + " |" + " O jogador usou/atacou:  " + card.getNome().toUpperCase() + ".");
            getSelectedField().setCarta(null);
            player.decreaseMana(card.getCusto());
            for (Effect effect : card.getEfeito()) {
                if (effect.isAlvo()) {
                    int mana = ApplyEffect(effect.getMana(), player.getMana(), TargetEnum.PLAYER);
                    player.setMana(mana);
                    int vida = ApplyEffect(effect.getVida(), player.getVida(), TargetEnum.PLAYER);
                    player.setVida(vida);
                    player.setDefesa(ApplyEffect(effect.getDefesa(), player.getDefesa(), TargetEnum.PLAYER));
                    int cartas = ApplyEffect(effect.getCartas(), player.getHand().size(), TargetEnum.PLAYER) - player.getHand().size();
                    if (cartas > 0) {
                        for (int i = 0; i < cartas; i++) {
                            if (player.getHand().size() + 1 <= 6) {
                                if (player.getDeck().getCards().size() > 0) {
                                    Card c = player.getDeck().getCards().get(player.getDeck().getCards().size() - 1);
                                    player.getHand().add(c);
                                    player.getDeck().getCards().remove(c);
                                }
                            }
                        }
                    } else if (cartas < 0) {
                        for (int i = 0; i < (cartas * -1); i++) {
                            player.getCemitery().add(player.getRandomDiferentOf(card));
                        }
                    }
                } else {
                    enemy.setMana(ApplyEffect(effect.getMana(), enemy.getMana(), TargetEnum.ENEMY));
                    enemy.setVida(ApplyEffect(effect.getVida(), enemy.getVida(), TargetEnum.ENEMY));
                    enemy.setDefesa(ApplyEffect(effect.getDefesa(), enemy.getDefesa(), TargetEnum.ENEMY));
                    int cartas = ApplyEffect(effect.getCartas(), enemy.getHand().size(), TargetEnum.ENEMY) - enemy.getHand().size();
                    if (cartas > 0) {
                        for (int i = 0; i < cartas; i++) {
                            if (enemy.getHand().size() + 1 <= 6) {
                                if (enemy.getDeck().getCards().size() > 0) {
                                    Card c = enemy.getDeck().getCards().get(enemy.getDeck().getCards().size() - 1);
                                    enemy.getHand().add(c);
                                    enemy.getDeck().getCards().remove(c);
                                }
                            }
                        }
                    } else if (cartas < 0) {
                        for (int i = 0; i < (cartas * -1); i++) {
                            enemy.getCemitery().add(enemy.getRandomDiferentOf(card));
                        }
                    }
                }
            }
            player.getHand().remove(card);
        }
        UpdatePlayerHand();
        view.Update();
        VerifyWinner();
    }

    private void EnemyAttack() {
        try {
            ArrayList<Card> hand = enemy.getHand();
            Collections.shuffle(hand);
            for (int j = 0; j < hand.size(); j++) {
                Thread.sleep((int) 450 * j);
                Card card = hand.get(j);
                String log = view.getTaLog().getText();
                if (enemy.getMana() >= card.getCusto()) {
                    view.getTaLog().setText(log + "\n" + "Turno: " + String.valueOf(turnCount) + " |" + " O inimigo usou/atacou: " + card.getNome().toUpperCase() + ".");
                    enemy.decreaseMana(card.getCusto());
                    for (Effect effect : card.getEfeito()) {
                        if (!effect.isAlvo()) {
                            int mana = ApplyEffect(effect.getMana(), player.getMana(), TargetEnum.PLAYER);
                            player.setMana(mana);
                            int vida = ApplyEffect(effect.getVida(), player.getVida(), TargetEnum.PLAYER);
                            player.setVida(vida);
                            player.setDefesa(ApplyEffect(effect.getDefesa(), player.getDefesa(), TargetEnum.PLAYER));
                            int cartas = ApplyEffect(effect.getCartas(), player.getHand().size(), TargetEnum.PLAYER) - player.getHand().size();
                            if (cartas > 0) {
                                for (int i = 0; i < cartas; i++) {
                                    if (player.getHand().size() + 1 <= 6) {
                                        if (player.getDeck().getCards().size() > 0) {
                                            Card c = player.getDeck().getCards().get(player.getDeck().getCards().size() - 1);
                                            player.getHand().add(c);
                                            player.getDeck().getCards().remove(c);
                                        }
                                    }
                                }
                            } else if (cartas < 0) {
                                for (int i = 0; i < (cartas * -1); i++) {
                                    player.getCemitery().add(player.getRandomDiferentOf(card));
                                }
                            }
                            UpdatePlayerHand();
                        } else {
                            enemy.setMana(ApplyEffect(effect.getMana(), enemy.getMana(), TargetEnum.ENEMY));
                            enemy.setVida(ApplyEffect(effect.getVida(), enemy.getVida(), TargetEnum.ENEMY));
                            enemy.setDefesa(ApplyEffect(effect.getDefesa(), enemy.getDefesa(), TargetEnum.ENEMY));
                            int cartas = ApplyEffect(effect.getCartas(), enemy.getHand().size(), TargetEnum.ENEMY) - enemy.getHand().size();
                            if (cartas > 0) {
                                for (int i = 0; i < cartas; i++) {
                                    if (enemy.getHand().size() + 1 <= 6) {
                                        if (enemy.getDeck().getCards().size() > 0) {
                                            Card c = enemy.getDeck().getCards().get(enemy.getDeck().getCards().size() - 1);
                                            enemy.getHand().add(c);
                                            enemy.getDeck().getCards().remove(c);
                                        }
                                    }
                                }
                            } else if (cartas < 0) {
                                for (int i = 0; i < (cartas * -1); i++) {
                                    enemy.getCemitery().add(enemy.getRandomDiferentOf(card));
                                }
                            }
                            UpdatePlayerHand();
                        }
                    }
                    enemy.getHand().remove(card);
                }
            }
            SkipTurn();
        } catch (InterruptedException ex) {
            Logger.getLogger(BattlefieldController.class.getName()).log(Level.SEVERE, null, ex);
        }
        VerifyWinner();
    }

    public int ApplyEffect(String input, float total, TargetEnum target) {
        String[] items;
        int num = 0;

        items = input.split("((?<=([\\+\\-\\*\\^\\@\\#v]))|(?=([\\+\\-\\*\\^\\@\\#v])))");

        if (items[0].matches("\\d+([.]\\d+)*")) {
            total += Integer.parseInt(items[0]);
        } else if (items[0].equals("v")) {//vida
            if (target == TargetEnum.PLAYER) {
                total += player.getVida();
            } else {
                total += enemy.getVida();
            }
        } else if (items[0].equals("^")) {//defesa
            if (target == TargetEnum.PLAYER) {
                total += player.getDefesa();
            } else {
                total += enemy.getDefesa();
            }
        } else if (items[0].equals("@")) {//mana
            if (target == TargetEnum.PLAYER) {
                total += player.getMana();
            } else {
                total += enemy.getMana();
            }
        } else if (items[0].equals("#")) {//carta
            if (target == TargetEnum.PLAYER) {
                total += player.getHand().size();
            } else {
                total += enemy.getHand().size();
            }
        }

        for (int i = 0; i < items.length; i++) {
            num = -1;
            if (i + 1 < items.length) {
                if (items[i + 1].matches("\\d+([.]\\d+)*")) {
                    num = Integer.parseInt(items[i + 1]);
                } else if (items[0].equals("v")) {//vida
                    if (target == TargetEnum.PLAYER) {
                        total += player.getVida();
                    } else {
                        total += enemy.getVida();
                    }
                } else if (items[0].equals("^")) {//defesa
                    if (target == TargetEnum.PLAYER) {
                        total += player.getDefesa();
                    } else {
                        total += enemy.getDefesa();
                    }
                } else if (items[0].equals("@")) {//mana
                    if (target == TargetEnum.PLAYER) {
                        total += player.getMana();
                    } else {
                        total += enemy.getMana();
                    }
                } else if (items[0].equals("#")) {//carta
                    if (target == TargetEnum.PLAYER) {
                        total += player.getHand().size();
                    } else {
                        total += enemy.getHand().size();
                    }
                }
                if (num != -1) {
                    if (items[i].equals("+")) {
                        total += num;
                    } else if (items[i].equals("-")) {
                        total -= num;
                    } else if (items[i].equals("*")) {
                        total *= num;
                    } else if (items[i].equals("/")) {
                        total /= num;
                    }
                }
            }
        }
        return (int) total;
    }

    public void UpdatePlayerHand() {
        int index = 0;
        fields.forEach(f -> {
            f.setEnabled(false);
        });
        for (Card c : player.getHand()) {
            fields.get(index).setCarta(c);
            fields.get(index).Update();
            index++;
        }
    }

    private int danoIfNotHasLife = 1;

    public void VerifyWinner() {
        String log = view.getTaLog().getText();
        if (enemy.getCardsCount() <= 0) {
            enemy.decreaseVida(danoIfNotHasLife);
            danoIfNotHasLife++;
            view.Update();
        }
        if (enemy.getVida() <= 0 && player.getVida() > 0) {
            view.getTaLog().setText(log + "\n" + "Turno: " + String.valueOf(turnCount) + " | " + "Parabéns, você venceu a partida!");
            JOptionPane.showMessageDialog(null, "Parabéns, você venceu a partida!");
            view.dispose();
        } else if (enemy.getVida() > 0 && player.getVida() <= 0) {
            view.getTaLog().setText(log + "\n " + "Turno: " + String.valueOf(turnCount) + " | " + "Que falta de sorte hein! Você perdeu esta partida.");
            JOptionPane.showMessageDialog(null, "Que falta de sorte hein! Você perdeu esta partida.");
            view.dispose();
        } else if (enemy.getVida() <= 0 && player.getVida() <= 0) {
            view.getTaLog().setText(log + "\n " + "Turno: " + String.valueOf(turnCount) + " | " + "Ops. Parece que houve um empate!");
            JOptionPane.showMessageDialog(null, "Ops. Parece que houve um empate!");
            view.dispose();
        }
    }

    public String getBattlefieldTitle() {
        String result = "Modo: %mode | %player vs %enemy | Turno: %turn"
                .replace("%mode", enemy.getDificuldade().toString())
                .replace("%player", player.getNome())
                .replace("%enemy", enemy.getNome())
                .replace("%turn", String.valueOf(turnCount));
        return result;
    }

    public static DifficultyEnum getDifficultyByString(String df) {
        switch (df.toLowerCase()) {
            case "normal":
                return DifficultyEnum.MEDIUM;
            case "dificil":
                return DifficultyEnum.HARD;
            default:
                return DifficultyEnum.EASY;
        }
    }

    public int getTurnCount() {
        return turnCount;
    }

    public void setTurnCount(int turnCount) {
        this.turnCount = turnCount;
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
