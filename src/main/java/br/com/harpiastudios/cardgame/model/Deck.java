/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author rotch
 */
public class Deck {
    private int id;
    private String nome;
    private ArrayList<Card> cartas = new ArrayList();

    public Deck(String nome, ArrayList<Card> cards) {
        this.nome = nome;
        cartas.clear();
        cartas.addAll(List.copyOf(cards));
        Collections.shuffle(cartas);
    }
    
    public Deck(int id, String nome, ArrayList<Card> cards) {
        this.id = id;
        this.nome = nome;
        cartas.clear();
        cartas.addAll(cards);
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

    public ArrayList<Card> getCards() {
        return cartas;
    }

    public void setCards(ArrayList<Card> cartas) {
        this.cartas = cartas;
    }
    
    public Card get() {
        try {
            Card card = cartas.get(cartas.size() - 1);
            cartas.remove(card);
            return card;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ArrayList<Card> getListForHand() {
        ArrayList<Card> hand = new ArrayList();
        if (cartas.size() >= 3) {
            for (int i = 0; i < 3; i++) {
                hand.add(get());
            }
        }
        return hand;
    }

    public static Deck clone(Deck target) {
        Deck deck = new Deck(target.getNome(), target.getCards());
        return deck;
    }
}
