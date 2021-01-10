/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

import br.com.harpiastudios.cardgame.enumerator.DifficultyEnum;

/**
 *
 * @author Diego
 */
public class Enemy extends Player {
    protected DifficultyEnum dificuldade = DifficultyEnum.EASY;
    protected String historia = "";

    public Enemy(String nome, String historia, Deck deck, DifficultyEnum dificuldade) {
        super(nome, deck);
        this.dificuldade = dificuldade;
        this.historia = historia;
    }
    
    public DifficultyEnum getDificuldade() {
        return dificuldade;
    }

    public void setDificuldade(DifficultyEnum dificuldade) {
        this.dificuldade = dificuldade;
    }

    public String getHistoria() {
        return historia;
    }

    public void setHistoria(String historia) {
        this.historia = historia;
    }
}