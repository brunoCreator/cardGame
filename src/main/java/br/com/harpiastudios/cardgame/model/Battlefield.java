/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

import br.com.harpiastudios.cardgame.enumerator.TargetEnum;
import br.com.harpiastudios.cardgame.enumerator.TurnEnum;
import br.com.harpiastudios.cardgame.view.BattlefieldView;
import java.util.ArrayList;

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

    public Battlefield(Player player, Enemy enemy, BattlefieldView view) {
        this.player = player;
        this.enemy = enemy;
        this.view = view;
        fields = view.getFields();
        int index = 0;
        for(Card card : player.getHand()) {
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
        if(turn == TurnEnum.PLAYER ) {
            turn = TurnEnum.ENEMY;
            view.getTaLog().setText(log + "\n" + "(" + String.valueOf(turnCount) + ")" + " O jogador pulou o turno.");
        }else{
            view.getTaLog().setText(log + "\n" + "(" + String.valueOf(turnCount) + ")" + " O inimigo pulou o turno.");
            turn = TurnEnum.PLAYER;
        }
        turnCount++;
        view.Update();
    }
    
    public boolean hasFieldSelected() {
        boolean result = false;
        for(CardField f : fields) {
            if(f.isSelected()) result = true;
        }
        return result;
    }
    
    public int ApplyEffect(String input, int total, TargetEnum target) {
        String[] items;

        items = input.split("((?<=([\\+\\-\\*\\^\\@\\#v]))|(?=([\\+\\-\\*\\^\\@\\#v])))");

        /*
        if(items[0].matches("\\d+([.]\\d+)*")){
            total = Integer.parseInt(items[0]);
        }*/
        for (int i = 0; i < items.length; i++) {
            System.out.println(items[i]);
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
        return total;
    }

    public String getBattlefieldTitle() {
        String result = "Modo: %mode | %player vs %enemy | Turno: %turn"
        .replace("%mode", enemy.getDificuldade().toString())
        .replace("%player", player.getNome())
        .replace("%enemy", enemy.getNome())
        .replace("%turn", String.valueOf(turnCount));
        return result;
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
