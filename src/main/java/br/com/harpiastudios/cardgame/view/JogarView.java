/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.view;

import br.com.harpiastudios.cardgame.model.Box;
import br.com.harpiastudios.cardgame.model.Deck;
import br.com.harpiastudios.cardgame.model.Storage;

/**
 *
 * @author rotch
 */
public class JogarView extends javax.swing.JPanel {

    BattlefieldView fild;
    Storage storage;
    public JogarView(Storage storage) {
        initComponents();
        this.storage = storage;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        cbPlayerDeck = new javax.swing.JComboBox<>();
        jButton6 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        cbDifficulty = new javax.swing.JComboBox<>();
        jButton7 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        cbEnemyDeck = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(69, 73, 84));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Seu deck:");

        cbPlayerDeck.setBackground(new java.awt.Color(34, 35, 40));
        cbPlayerDeck.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        cbPlayerDeck.setBorder(null);

        jButton6.setBackground(new java.awt.Color(34, 35, 40));
        jButton6.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("BATALHAR");
        jButton6.setBorder(null);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Dificuldade");

        cbDifficulty.setBackground(new java.awt.Color(34, 35, 40));
        cbDifficulty.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        cbDifficulty.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Facil", "Normal", "Dificil" }));
        cbDifficulty.setBorder(null);

        jButton7.setBackground(new java.awt.Color(34, 35, 40));
        jButton7.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("voltar");
        jButton7.setBorder(null);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Deck inimigo:");

        cbEnemyDeck.setBackground(new java.awt.Color(34, 35, 40));
        cbEnemyDeck.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        cbEnemyDeck.setBorder(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(426, 426, 426)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbEnemyDeck, 0, 101, Short.MAX_VALUE)
                            .addComponent(cbPlayerDeck, 0, 101, Short.MAX_VALUE)
                            .addComponent(cbDifficulty, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(477, 477, 477)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(389, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbPlayerDeck, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbEnemyDeck, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbDifficulty, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 264, Short.MAX_VALUE)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        cbPlayerDeck.getAccessibleContext().setAccessibleName("");
        cbPlayerDeck.getAccessibleContext().setAccessibleDescription("");
    }// </editor-fold>//GEN-END:initComponents

    public void Update(){
        cbPlayerDeck.removeAllItems();
        for (Deck s : storage.getDecks()) {
            cbPlayerDeck.addItem(new Box((int) s.getId(), s.getNome()));
        }
        cbEnemyDeck.removeAllItems();
        for (Deck s : storage.getDecks()) {
            cbEnemyDeck.addItem(new Box((int) s.getId(), s.getNome()));
        }
    }
    
    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        Box playerDeck = (Box) cbPlayerDeck.getSelectedItem();
        Box enemyDeck = (Box) cbEnemyDeck.getSelectedItem();
        
        String df = cbDifficulty.getSelectedItem().toString();
        Deck[] ds = {
            storage.getDecks().get(playerDeck.getKey()),
            storage.getDecks().get(enemyDeck.getKey())
        };
        
        BattlefieldView view = new BattlefieldView(null, true, ds, df, storage.getUsuario());
        view.setVisible(true);
        System.out.println(playerDeck.getKey());
    }//GEN-LAST:event_jButton6ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbDifficulty;
    private javax.swing.JComboBox<Box> cbEnemyDeck;
    private javax.swing.JComboBox<Box> cbPlayerDeck;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
