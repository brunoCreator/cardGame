/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

import br.com.harpiastudios.cardgame.enumerator.DifficultyEnum;
import br.com.harpiastudios.cardgame.enumerator.TargetEnum;
import br.com.harpiastudios.cardgame.enumerator.TurnEnum;
import br.com.harpiastudios.cardgame.view.BattlefieldView;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Diego
 */
public class Battlefield {

    private final BattlefieldView view;
    private TurnEnum turn = TurnEnum.PLAYER;
    private int turnCount = 0;
    private final Player player;
    private final Enemy enemy;
    private ArrayList<CardField> fields = new ArrayList();
    private Random rand = new Random();

    public Battlefield(Player player, Enemy enemy, BattlefieldView view) {
        this.player = player;
        this.enemy = enemy;
        this.view = view;
        fields = view.getFields();
        int index = 0;
        for (Card card : player.getHand()) {
            System.out.println(card.getNome());
            fields.get(index).setCarta(card);
            fields.get(index).Update();
            index++;
        }
    }

    public TurnEnum getTurn() {
        return turn;
    }

    public void SkipTurn() {
        String log = view.getTaLog().getText();
        if (turn == TurnEnum.PLAYER) {
            view.getTaLog().setText(log + "\n" + "Turno: " + String.valueOf(turnCount) + " |" + " O jogador pulou o turno.");
            AddTurn(true);
        } else {
            view.getTaLog().setText(log + "\n" + "Turno: " + String.valueOf(turnCount) + " |" + " O inimigo pulou o turno.");
            AddTurn(true);
        }
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

    public void AddTurn(boolean isSkip) {
        enemy.increaseMana(1);
        player.increaseMana(1);
        if (turn == TurnEnum.PLAYER) {
            turn = TurnEnum.ENEMY;
            turnCount++;
            view.Update();
            if (isSkip) {
                Buy(true);
                try {
                    Thread.sleep(1000);
                    enemy.getHand().forEach(card -> {
                        if (enemy.getMana() >= card.getCusto()) {
                            Attack(true);
                        } else {
                            SkipTurn();
                        }
                    });
                } catch (InterruptedException ex) {
                    SkipTurn();
                }
            }
        }

        if (turn == TurnEnum.ENEMY) {
            turn = TurnEnum.PLAYER;
            turnCount++;
            view.Update();
            Buy(false);
        }
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
        }
    }

    public void Attack(boolean isEnemy) {
        String log = view.getTaLog().getText();
        if (!isEnemy) {
            Card card = getSelectedField().getCarta();
            view.getTaLog().setText(log + "\n" + "Turno: " + String.valueOf(turnCount) + " |" + " O jogador atacou usando a carta: " + card.getNome() + ".");
            player.getHand().remove(card);
            getSelectedField().setCarta(null);
            player.decreaseMana(card.getCusto());
            for (Effect effect : card.getEfeito()) {
                if (!effect.isAlvo()) {
                    int mana = ApplyEffect(effect.getMana(), player.getMana(), TargetEnum.PLAYER);
                    System.out.println("Mana: " + mana);
                    player.setMana(mana);
                    int vida = ApplyEffect(effect.getVida(), player.getVida(), TargetEnum.PLAYER);
                    System.out.println("Vida: " + mana);
                    player.setVida(vida);
                    player.setDefesa(ApplyEffect(effect.getDefesa(), player.getDefesa(), TargetEnum.PLAYER));
                    int cartas = ApplyEffect(effect.getCartas(), player.getHand().size(), TargetEnum.PLAYER);
                    if (player.getHand().size() > cartas) {
                        for (int i = 0; i < cartas; i++) {
                            player.getCemitery().add(player.getFromHand());
                        }
                    } else {
                        for (int i = 0; i < cartas; i++) {
                            if (player.getHand().size() + 1 < 6) {
                                player.getHand().add(player.getDeck().getCards().get(rand.nextInt(player.getDeck().getCards().size() - 1)));
                            }
                        }
                    }
                } else {
                    enemy.setMana(ApplyEffect(effect.getMana(), enemy.getMana(), TargetEnum.ENEMY));
                    enemy.setVida(ApplyEffect(effect.getVida(), enemy.getVida(), TargetEnum.ENEMY));
                    enemy.setDefesa(ApplyEffect(effect.getDefesa(), enemy.getDefesa(), TargetEnum.ENEMY));
                    int cartas = ApplyEffect(effect.getCartas(), enemy.getHand().size(), TargetEnum.ENEMY);
                    if (enemy.getHand().size() > cartas) {
                        for (int i = 0; i < cartas; i++) {
                            enemy.getCemitery().add(enemy.getFromHand());
                        }
                    } else {
                        for (int i = 0; i < cartas; i++) {
                            if (enemy.getHand().size() + 1 < 6) {
                                enemy.getHand().add(enemy.getDeck().getCards().get(rand.nextInt(enemy.getDeck().getCards().size() - 1)));
                            }
                        }
                    }
                }
            }
            view.Update();
            AddTurn(false);
        } else {
            Card card = enemy.getRandomFromHand();
            view.getTaLog().setText(log + "\n" + "Turno: " + String.valueOf(turnCount) + " |" + " O inimigo atacou usando a carta: " + card.getNome() + ".");
            enemy.getHand().remove(card);
            enemy.decreaseMana(card.getCusto());
            for (Effect effect : card.getEfeito()) {
                if (effect.isAlvo()) {
                    int mana = ApplyEffect(effect.getMana(), player.getMana(), TargetEnum.PLAYER);
                    System.out.println("Mana: " + mana);
                    player.setMana(mana);
                    int vida = ApplyEffect(effect.getVida(), player.getVida(), TargetEnum.PLAYER);
                    System.out.println("Vida: " + mana);
                    player.setVida(vida);
                    player.setDefesa(ApplyEffect(effect.getDefesa(), player.getDefesa(), TargetEnum.PLAYER));
                    int cartas = ApplyEffect(effect.getCartas(), player.getHand().size(), TargetEnum.PLAYER);
                    if (player.getHand().size() > cartas) {
                        for (int i = 0; i < cartas; i++) {
                            player.getCemitery().add(player.getFromHand());
                        }
                    } else {
                        for (int i = 0; i < cartas; i++) {
                            if (player.getHand().size() + 1 < 6) {
                                player.getHand().add(player.getDeck().getCards().get(rand.nextInt(player.getDeck().getCards().size() - 1)));
                            }
                        }
                    }
                } else {
                    enemy.setMana(ApplyEffect(effect.getMana(), enemy.getMana(), TargetEnum.ENEMY));
                    enemy.setVida(ApplyEffect(effect.getVida(), enemy.getVida(), TargetEnum.ENEMY));
                    enemy.setDefesa(ApplyEffect(effect.getDefesa(), enemy.getDefesa(), TargetEnum.ENEMY));
                    int cartas = ApplyEffect(effect.getCartas(), enemy.getHand().size(), TargetEnum.ENEMY);
                    if (enemy.getHand().size() > cartas) {
                        for (int i = 0; i < cartas; i++) {
                            enemy.getCemitery().add(enemy.getFromHand());
                        }
                    } else {
                        for (int i = 0; i < cartas; i++) {
                            if (enemy.getHand().size() + 1 < 6) {
                                int rand = enemy.getDeck().getCards().size() - 1;
                                if(rand > 0) {
                                    enemy.getHand().add(enemy.getDeck().getCards().get(this.rand.nextInt(rand)));
                                }
                            }
                        }
                    }
                }
            }
            AddTurn(false);
            view.Update();
        }
        int index = 0;
        fields.forEach(f -> {
            f.setEnabled(false);
        });
        for (Card c : player.getHand()) {
            fields.get(index).setCarta(c);
            fields.get(index).Update();
            index++;
        }
        view.Update();
    }

    public int ApplyEffect(String input, float total, TargetEnum target) {
        String[] items;
        items = input.split("((?<=([\\+\\-\\*\\^\\@\\#v]))|(?=([\\+\\-\\*\\^\\@\\#v])))");

        /*
        if(items[0].matches("\\d+([.]\\d+)*")){
            total = Integer.parseInt(items[0]);
        }*/
        for (int i = 0; i < items.length; i++) {
            if (items[i].equals("+")) {
                if (i - 1 >= 0 && i + 1 <= items.length) {
                    total += Float.parseFloat(items[i + 1]);
                }
            } else if (items[i].equals("-")) {
                if (i - 1 >= 0 && i + 1 <= items.length) {
                    total -= Float.parseFloat(items[i + 1]);
                }
            } else if (items[i].equals("*")) {
                if (i - 1 >= 0 && i + 1 <= items.length) {
                    total *= Float.parseFloat(items[i + 1]);
                }
            } else if (items[i].equals("v")) {//vida
                if (i - 1 >= 0 && i + 1 <= items.length) {
                    if (target == TargetEnum.PLAYER) {
                        total += player.getVida();
                    } else {
                        total += enemy.getVida();
                    }
                }
            } else if (items[i].equals("^")) {//defesa
                if (i - 1 >= 0 && i + 1 <= items.length) {
                    if (target == TargetEnum.PLAYER) {
                        total += player.getDefesa();
                    } else {
                        total += enemy.getDefesa();
                    }
                }
            } else if (items[i].equals("@")) {//mana
                if (i - 1 >= 0 && i + 1 <= items.length) {
                    if (target == TargetEnum.PLAYER) {
                        total += player.getMana();
                    } else {
                        total += enemy.getMana();
                    }
                }
            } else if (items[i].equals("#")) {//carta
                if (i - 1 >= 0 && i + 1 <= items.length) {
                    if (target == TargetEnum.PLAYER) {
                        //total += cartas;
                    } else {
                        //total += ecartas;
                    }
                }
            }
        }
        return (int) total;
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
