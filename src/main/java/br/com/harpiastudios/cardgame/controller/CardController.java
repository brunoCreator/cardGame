/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.controller;

import br.com.harpiastudios.cardgame.model.Card;
import br.com.harpiastudios.cardgame.model.Effect;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class CardController {

    private ArrayList<Card> cards;
    private int selected = -1;

    public CardController(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public boolean cadastrar(String nome, String descricao, String custo, String vidap, String manap, String defesap, String cartasp, String vidai, String manai, String defesai, String cartasi) {
        if (!nome.isEmpty() && !descricao.isEmpty() && !custo.isEmpty() && !vidap.isEmpty() && !manap.isEmpty() && !defesap.isEmpty() && !cartasp.isEmpty()
                && !vidai.isEmpty() && !manai.isEmpty() && !defesai.isEmpty() && !cartasi.isEmpty()) {
            try {
                Effect[] effects = new Effect[]{
                    new Effect(true, vidap, manap, cartasp, defesap),
                    new Effect(false, vidai, manai, cartasi, defesai)
                };
                return cards.add(new Card(cards.size(), nome, descricao, Integer.parseInt(custo), effects));
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean alterar(String nome, String descricao, String custo, String vidap, String manap, String defesap, String cartasp, String vidai, String manai, String defesai, String cartasi) {
        if (!nome.isEmpty() && !descricao.isEmpty() && !custo.isEmpty() && !vidap.isEmpty() && !manap.isEmpty() && !defesap.isEmpty() && !cartasp.isEmpty()
                && !vidai.isEmpty() && !manai.isEmpty() && !defesai.isEmpty() && !cartasi.isEmpty()) {
            try {
                if (selected >= 0) {
                    Card card = cards.get(selected);
                    card.setNome(nome);
                    card.setDescricao(descricao);
                    card.setCusto(Integer.parseInt(custo));
                    Effect[] effects = new Effect[]{
                        new Effect(true, vidap, manap, cartasp, defesap),
                        new Effect(false, vidai, manai, cartasi, defesai)
                    };
                    card.setEfeito(effects);
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean excluir() {
        if (cards.size() > 0) {
            if (selected != -1) {
                cards.remove(selected);
                selected = -1;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void Navigate(boolean increase) {
        if (increase) {
            if (cards.size() - 1 > 0 && selected > 0) {
                selected--;
            } else if (selected == 0) {
                selected = 0;
            } else {
                selected = -1;
            }
        } else {
            if (selected < cards.size() - 1) {
                selected++;
            } else if (selected == cards.size() - 1) {
                selected = cards.size() - 1;
            } else {
                selected = -1;
            }
        }
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

    public Card getSelected() {
        return cards.get(selected);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public boolean isSelected() {
        return selected != -1;
    }
}
