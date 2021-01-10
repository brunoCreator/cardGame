/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author rotch
 */
public class Deck {
    private int id;
    private String nome;
    private Stack<Card> cards;

    public Deck(int id, String nome, Stack<Card> cards) {
        this.id = id;
        this.nome = nome;
        this.cards = cards;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Stack<Card> getCards() {
        return cards;
    }

    public void setCards(Stack<Card> cards) {
        this.cards = cards;
    }
}
