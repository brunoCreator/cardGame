/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author rotch
 */
public class Card {
    private int id;
    private String nome;
    private String descricao;
    private int custo;
    private Effect efeito;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getCusto() {
        return custo;
    }

    public void setCusto(int custo) {
        this.custo = custo;
    }

    public Effect getEfeito() {
        return efeito;
    }

    public void setEfeito(Effect efeito) {
        this.efeito = efeito;
    }

    public Card(int id, String nome, String descricao, int custo, Effect efeito) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.custo = custo;
        this.efeito = efeito;
    }

    
}
