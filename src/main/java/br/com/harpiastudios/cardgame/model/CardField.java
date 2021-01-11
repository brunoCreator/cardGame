/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.model;

import java.awt.Color;
import java.awt.Dimension;
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
    private JLabel custo;
    private JPanel content;
    private boolean selected = false;

    private Card carta;

    public CardField(JLabel nome, JLabel descricao, JPanel content, JLabel custo) {
        this.nome = nome;
        this.descricao = descricao;
        this.content = content;
        this.custo = custo;
        Update();
    }

    public void Update() {
        if (carta != null) {
            nome.setText(carta.getNome().toUpperCase());
            descricao.setText("<html>" + carta.getDescricao() + "</html>");
            int maxWidth = 140;
            Dimension size = descricao.getPreferredSize();
            if (size.width > maxWidth) {
                int lineCount = (int) Math.ceil(((double) size.width) / maxWidth);
                lineCount += 1;
                size.width = maxWidth;
                size.height *= lineCount;
                descricao.setPreferredSize(size);
            }
            custo.setText("Custo: " + carta.getCusto());
            setEnabled(true);
        } else {
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
