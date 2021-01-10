/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

/**
 *
 * @author rotch
 */
public class Effect {
    private boolean alvo;
    private String vida;
    private String mana;
    private String cartas;
    private String defesa;

    public Effect(boolean alvo, String vida, String mana, String cartas, String defesa) {
        this.alvo = alvo;
        this.vida = vida;
        this.mana = mana;
        this.cartas = cartas;
        this.defesa = defesa;
    }

    public boolean isAlvo() {
        return alvo;
    }

    public void setAlvo(boolean alvo) {
        this.alvo = alvo;
    }

    public String getVida() {
        return vida;
    }

    public void setVida(String vida) {
        this.vida = vida;
    }

    public String getMana() {
        return mana;
    }

    public void setMana(String mana) {
        this.mana = mana;
    }

    public String getCartas() {
        return cartas;
    }

    public void setCartas(String cartas) {
        this.cartas = cartas;
    }

    public String getDefesa() {
        return defesa;
    }

    public void setDefesa(String defesa) {
        this.defesa = defesa;
    }
}
