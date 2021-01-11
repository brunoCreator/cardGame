/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

import java.util.ArrayList;
import java.util.Random;

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
    protected ArrayList<Card> cemitery = new ArrayList();

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
        if(vida < 0) vida = 0;
        return vida;
    }

    public void setVida(float vida) {
        this.vida = vida;
    }

    public float getDefesa() {
        if(defesa < 0) defesa = 0;
        return defesa;
    }

    public void setDefesa(float defesa) {
        this.defesa = defesa;
    }

    public float getMana() {
        if(mana < 0) mana = 0;
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
    
    public Card getFromHand() {
        Card res = hand.get(hand.size()-1);
        hand.remove(res);
        return res;
    }
    
    private Random rand = new Random();
    public Card getRandomFromHand() {
        Card res = hand.get(rand.nextInt(hand.size()-1));
        hand.remove(res);
        return res;
    }
    
    public int getCardsCount() {
        return hand.size() + deck.getCards().size();
    }

    public ArrayList<Card> getCemitery() {
        return cemitery;
    }

    public void setCemitery(ArrayList<Card> cemitery) {
        this.cemitery = cemitery;
    }

    public Deck getDeck() {
        return deck;
    }
}
