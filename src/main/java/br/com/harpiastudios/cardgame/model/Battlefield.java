/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

import br.com.harpiastudios.cardgame.enumerator.DifficultyEnum;
import br.com.harpiastudios.cardgame.enumerator.TargetEnum;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Battlefield {
    private int turn = 0;
    private Player player;
    private Enemy enemy;
    private ArrayList<CardField> fields = new ArrayList();

    public Battlefield(Player player, Enemy enemy, DifficultyEnum difficulty) {
        this.player = player;
        this.enemy = enemy;
    }

    public void SkipTurn() {
        turn++;
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
        .replace("%modo", enemy.getDificuldade().toString())
        .replace("%player", player.getNome())
        .replace("%enemy", enemy.getNome())
        .replace("%turn", String.valueOf(turn));
        return result;
    }
    
    public int getTurn() {
        return turn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }
}
