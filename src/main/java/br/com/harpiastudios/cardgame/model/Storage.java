/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

import br.com.harpiastudios.cardgame.controller.SaveController;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class Storage {
    private User usuario;
    ArrayList<Card> cards = new  ArrayList<>();
    ArrayList<Deck> decks = new  ArrayList<>();

    public Storage() {
        usuario = new User("John", "admin", "admin");
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    public ArrayList<Deck> getDecks() {
        return decks;
    }

    public void setDecks(ArrayList<Deck> decks) {
        this.decks = decks;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }
    
    public void Save() {
        SaveController save = new SaveController();
        save.Save(this);
    }
}
