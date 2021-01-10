/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Player {
    protected String nome;
    protected float vida = 20;
    protected float defesa = 10;
    protected float mana = 1;
    protected Deck deck;
    protected ArrayList<Card> hand = new ArrayList();

    public Player(String nome, Deck deck) {
        this.nome = nome;
        this.deck = deck;
        hand = deck.getListForHand();
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getVida() {
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public float getDefesa() {
        return defesa;
    }

    public void setDefesa(float defesa) {
        this.defesa = defesa;
    }

    public float getMana() {
        return mana;
    }

    public void setMana(float mana) {
        this.mana = mana;
    }
    
    public void increaseMana(float value) {
        this.mana += value;
    }
    
    public void decreaseMana(float value) {
        this.mana -= value;
    }
    
    public void increaseVida(float value) {
        this.vida += value;
    }
    
    public void decreaseVida(float value) {
        this.vida -= value;
    }
    
    public void increaseDefesa(float value) {
        this.defesa += value;
    }
    
    public void decreaseDefesa(float value) {
        this.defesa -= value;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
}
