/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

import br.com.harpiastudios.cardgame.enumerator.DifficultyEnum;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Battlefield {
    private Player player;
    private Enemy enemy;
    private ArrayList<CardField> fields = new ArrayList();

    public Battlefield(Player player, Enemy enemy, DifficultyEnum difficulty) {
        this.player = player;
        this.enemy = enemy;
    }

    private int calculo(String input, int total, boolean alvo) {
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
                    if (alvo) {
                        total += player.getVida();
                    } else {
                        total += enemy.getVida();
                    }
                }
            } else if (items[i].equals("^")) {//defesa
                if (i - 1 >= 0 && i + 1 <= items.length) {
                    if (alvo) {
                        total += player.getDefesa();
                    } else {
                        total += enemy.getDefesa();
                    }
                }
            } else if (items[i].equals("@")) {//mana
                if (i - 1 >= 0 && i + 1 <= items.length) {
                    if (alvo) {
                        total += player.getMana();
                    } else {
                        total += enemy.getMana();
                    }
                }
            } else if (items[i].equals("#")) {//carta
                if (i - 1 >= 0 && i + 1 <= items.length) {
                    if (alvo) {
                        total += cartas;
                    } else {
                        total += ecartas;
                    }
                }
            }
        }
        return total;
    }
}
