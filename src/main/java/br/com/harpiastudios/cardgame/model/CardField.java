/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author Diego
 */
public class CardField {

    private JLabel nome;
    private JLabel descricao;
    private JPanel content;
    private boolean selected = false;

    private Card carta;

    public CardField(JLabel nome, JLabel descricao, JPanel content) {
        this.nome = nome;
        this.descricao = descricao;
        this.content = content;
        Update();
    }

    public void Update() {
        if (carta != null) {
            nome.setText(carta.getNome());
            descricao.setText(carta.getDescricao());
            setEnabled(true);
        }else{
            setEnabled(false);
        }
    }

    public void setEnabled(boolean value) {
        content.setVisible(value);
    }

    public JLabel getNome() {
        return nome;
    }

    public void setNome(JLabel nome) {
        this.nome = nome;
    }

    public JLabel getDescricao() {
        return descricao;
    }

    public void setDescricao(JLabel descricao) {
        this.descricao = descricao;
    }

    public JPanel getContent() {
        return content;
    }

    public void setContent(JPanel content) {
        this.content = content;
    }

    public Card getCarta() {
        return carta;
    }

    public void setCarta(Card carta) {
        this.carta = carta;
    }

    public void setSelected(boolean value) {
        if (value) {
            content.setBorder(new LineBorder(Color.decode("#d484f5"), 2));
        } else {
            content.setBorder(null);
        }
        selected = value;
    }

    public boolean isSelected() {
        return selected;
    }
}
