/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.harpiastudios.cardgame.view;

import br.com.harpiastudios.cardgame.model.Battlefield;
import br.com.harpiastudios.cardgame.model.CardField;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class BattlefieldView extends javax.swing.JDialog {

    private Battlefield battlefield;
    private ArrayList<CardField> fields = new ArrayList();

    /**
     * Creates new form Battlefield
     */
    public BattlefieldView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        LoadFields();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblDesist = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        playerHand = new javax.swing.JPanel();
        pnCardF5 = new javax.swing.JPanel();
        lblCardNameF5 = new javax.swing.JLabel();
        lblCardDescF5 = new javax.swing.JLabel();
        pnCardF4 = new javax.swing.JPanel();
        lblCardNameF4 = new javax.swing.JLabel();
        lblCardDescF4 = new javax.swing.JLabel();
        pnCardF1 = new javax.swing.JPanel();
        lblCardNameF1 = new javax.swing.JLabel();
        lblCardDescF1 = new javax.swing.JLabel();
        pnCardF3 = new javax.swing.JPanel();
        lblCardNameF3 = new javax.swing.JLabel();
        lblCardDescF3 = new javax.swing.JLabel();
        pnCardF6 = new javax.swing.JPanel();
        lblCardNameF6 = new javax.swing.JLabel();
        lblCardDescF6 = new javax.swing.JLabel();
        pnCardF2 = new javax.swing.JPanel();
        lblCardNameF2 = new javax.swing.JLabel();
        lblCardDescF2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnSkipTurn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel19 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modo: Fácil | Name vs Name | Turno: 0");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(22, 160, 133));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(236, 240, 241));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel1.setText("Vida: 10 | Defesa: 0 | Mana: 1 | Cartas: 10");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(236, 240, 241));
        jLabel2.setText("Player: Name");

        lblDesist.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblDesist.setForeground(new java.awt.Color(255, 255, 255));
        lblDesist.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblDesist.setText("DESISTIR");
        lblDesist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                lblDesistMouseReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 468, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblDesist, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(414, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                    .addComponent(lblDesist))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        jPanel2.setBackground(new java.awt.Color(44, 62, 80));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(236, 240, 241));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel3.setText("Mana: 1 | Cartas: 10");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(236, 240, 241));
        jLabel4.setText("Enemy: Name");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(640, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 17, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        playerHand.setBackground(new java.awt.Color(222, 224, 225));

        pnCardF5.setBackground(new java.awt.Color(142, 68, 173));
        pnCardF5.setPreferredSize(new java.awt.Dimension(122, 95));
        pnCardF5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnCardF5MouseReleased(evt);
            }
        });

        lblCardNameF5.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblCardNameF5.setForeground(new java.awt.Color(255, 255, 255));
        lblCardNameF5.setText("Cardname Here");
        lblCardNameF5.setFocusable(false);
        lblCardNameF5.setRequestFocusEnabled(false);

        lblCardDescF5.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCardDescF5.setForeground(new java.awt.Color(255, 255, 255));
        lblCardDescF5.setText("Descrição");
        lblCardDescF5.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblCardDescF5.setFocusable(false);
        lblCardDescF5.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblCardDescF5.setRequestFocusEnabled(false);

        javax.swing.GroupLayout pnCardF5Layout = new javax.swing.GroupLayout(pnCardF5);
        pnCardF5.setLayout(pnCardF5Layout);
        pnCardF5Layout.setHorizontalGroup(
            pnCardF5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCardF5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCardF5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCardNameF5, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                    .addComponent(lblCardDescF5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnCardF5Layout.setVerticalGroup(
            pnCardF5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCardF5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCardNameF5, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCardDescF5, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        pnCardF4.setBackground(new java.awt.Color(142, 68, 173));
        pnCardF4.setFocusable(false);
        pnCardF4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnCardF4MouseReleased(evt);
            }
        });

        lblCardNameF4.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblCardNameF4.setForeground(new java.awt.Color(255, 255, 255));
        lblCardNameF4.setText("Cardname Here");
        lblCardNameF4.setFocusable(false);
        lblCardNameF4.setRequestFocusEnabled(false);

        lblCardDescF4.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCardDescF4.setForeground(new java.awt.Color(255, 255, 255));
        lblCardDescF4.setText("Descrição");
        lblCardDescF4.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblCardDescF4.setFocusable(false);
        lblCardDescF4.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblCardDescF4.setRequestFocusEnabled(false);

        javax.swing.GroupLayout pnCardF4Layout = new javax.swing.GroupLayout(pnCardF4);
        pnCardF4.setLayout(pnCardF4Layout);
        pnCardF4Layout.setHorizontalGroup(
            pnCardF4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCardF4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCardF4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCardNameF4, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(lblCardDescF4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnCardF4Layout.setVerticalGroup(
            pnCardF4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCardF4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCardNameF4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCardDescF4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        pnCardF1.setBackground(new java.awt.Color(142, 68, 173));
        pnCardF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnCardF1MouseReleased(evt);
            }
        });

        lblCardNameF1.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblCardNameF1.setForeground(new java.awt.Color(255, 255, 255));
        lblCardNameF1.setText("Cardname Here");
        lblCardNameF1.setFocusable(false);
        lblCardNameF1.setRequestFocusEnabled(false);

        lblCardDescF1.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCardDescF1.setForeground(new java.awt.Color(255, 255, 255));
        lblCardDescF1.setText("Descrição");
        lblCardDescF1.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblCardDescF1.setFocusable(false);
        lblCardDescF1.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblCardDescF1.setRequestFocusEnabled(false);

        javax.swing.GroupLayout pnCardF1Layout = new javax.swing.GroupLayout(pnCardF1);
        pnCardF1.setLayout(pnCardF1Layout);
        pnCardF1Layout.setHorizontalGroup(
            pnCardF1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCardF1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCardF1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCardNameF1, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(lblCardDescF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnCardF1Layout.setVerticalGroup(
            pnCardF1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCardF1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCardNameF1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCardDescF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        pnCardF3.setBackground(new java.awt.Color(142, 68, 173));
        pnCardF3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnCardF3MouseReleased(evt);
            }
        });

        lblCardNameF3.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblCardNameF3.setForeground(new java.awt.Color(255, 255, 255));
        lblCardNameF3.setText("Cardname Here");
        lblCardNameF3.setFocusable(false);
        lblCardNameF3.setRequestFocusEnabled(false);

        lblCardDescF3.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCardDescF3.setForeground(new java.awt.Color(255, 255, 255));
        lblCardDescF3.setText("Descrição");
        lblCardDescF3.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblCardDescF3.setFocusable(false);
        lblCardDescF3.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblCardDescF3.setRequestFocusEnabled(false);

        javax.swing.GroupLayout pnCardF3Layout = new javax.swing.GroupLayout(pnCardF3);
        pnCardF3.setLayout(pnCardF3Layout);
        pnCardF3Layout.setHorizontalGroup(
            pnCardF3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCardF3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCardF3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCardNameF3, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addComponent(lblCardDescF3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnCardF3Layout.setVerticalGroup(
            pnCardF3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCardF3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCardNameF3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCardDescF3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        pnCardF6.setBackground(new java.awt.Color(142, 68, 173));
        pnCardF6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnCardF6MouseReleased(evt);
            }
        });

        lblCardNameF6.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblCardNameF6.setForeground(new java.awt.Color(255, 255, 255));
        lblCardNameF6.setText("Cardname Here");
        lblCardNameF6.setFocusable(false);
        lblCardNameF6.setRequestFocusEnabled(false);

        lblCardDescF6.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCardDescF6.setForeground(new java.awt.Color(255, 255, 255));
        lblCardDescF6.setText("Descrição");
        lblCardDescF6.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblCardDescF6.setFocusable(false);
        lblCardDescF6.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblCardDescF6.setRequestFocusEnabled(false);

        javax.swing.GroupLayout pnCardF6Layout = new javax.swing.GroupLayout(pnCardF6);
        pnCardF6.setLayout(pnCardF6Layout);
        pnCardF6Layout.setHorizontalGroup(
            pnCardF6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCardF6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCardF6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCardNameF6, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addComponent(lblCardDescF6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnCardF6Layout.setVerticalGroup(
            pnCardF6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCardF6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCardNameF6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCardDescF6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        pnCardF2.setBackground(new java.awt.Color(142, 68, 173));
        pnCardF2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                pnCardF2MouseReleased(evt);
            }
        });

        lblCardNameF2.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        lblCardNameF2.setForeground(new java.awt.Color(255, 255, 255));
        lblCardNameF2.setText("Cardname Here");
        lblCardNameF2.setFocusable(false);
        lblCardNameF2.setRequestFocusEnabled(false);

        lblCardDescF2.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        lblCardDescF2.setForeground(new java.awt.Color(255, 255, 255));
        lblCardDescF2.setText("Descrição");
        lblCardDescF2.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        lblCardDescF2.setFocusable(false);
        lblCardDescF2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblCardDescF2.setRequestFocusEnabled(false);

        javax.swing.GroupLayout pnCardF2Layout = new javax.swing.GroupLayout(pnCardF2);
        pnCardF2.setLayout(pnCardF2Layout);
        pnCardF2Layout.setHorizontalGroup(
            pnCardF2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCardF2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCardF2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblCardNameF2, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(lblCardDescF2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnCardF2Layout.setVerticalGroup(
            pnCardF2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCardF2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblCardNameF2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblCardDescF2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout playerHandLayout = new javax.swing.GroupLayout(playerHand);
        playerHand.setLayout(playerHandLayout);
        playerHandLayout.setHorizontalGroup(
            playerHandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, playerHandLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnCardF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCardF2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCardF3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCardF4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCardF5, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCardF6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        playerHandLayout.setVerticalGroup(
            playerHandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(playerHandLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(playerHandLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnCardF5, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(pnCardF4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnCardF1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnCardF3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnCardF6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnCardF2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Ubuntu", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(22, 160, 133));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("SEU TURNO!");

        btnSkipTurn.setBackground(new java.awt.Color(127, 140, 141));
        btnSkipTurn.setFont(new java.awt.Font("Ubuntu", 1, 12)); // NOI18N
        btnSkipTurn.setForeground(new java.awt.Color(255, 255, 255));
        btnSkipTurn.setText("PASSAR TURNO");
        btnSkipTurn.setBorder(null);
        btnSkipTurn.setBorderPainted(false);
        btnSkipTurn.setFocusPainted(false);
        btnSkipTurn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkipTurnActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Log:");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel19.setBackground(new java.awt.Color(231, 76, 60));

        jLabel18.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Vida: 0");

        jLabel19.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Enemy");

        jLabel20.setFont(new java.awt.Font("Ubuntu", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel20.setText("Defesa: 0");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(423, 423, 423)
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(240, 240, 240)
                                .addComponent(btnSkipTurn, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(playerHand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnSkipTurn, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(playerHand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblDesistMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDesistMouseReleased
        System.out.println("Você desistiu!");
    }//GEN-LAST:event_lblDesistMouseReleased

    private void btnSkipTurnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkipTurnActionPerformed
        System.out.println("Você passou o turno..");
    }//GEN-LAST:event_btnSkipTurnActionPerformed


    private void pnCardF1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnCardF1MouseReleased
        SelectField(0);
    }//GEN-LAST:event_pnCardF1MouseReleased

    private void pnCardF2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnCardF2MouseReleased
        SelectField(1);
    }//GEN-LAST:event_pnCardF2MouseReleased

    private void pnCardF3MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnCardF3MouseReleased
        SelectField(2);
    }//GEN-LAST:event_pnCardF3MouseReleased

    private void pnCardF4MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnCardF4MouseReleased
        SelectField(3);
    }//GEN-LAST:event_pnCardF4MouseReleased

    private void pnCardF5MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnCardF5MouseReleased
        SelectField(4);
    }//GEN-LAST:event_pnCardF5MouseReleased

    private void pnCardF6MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnCardF6MouseReleased
        SelectField(5);
    }//GEN-LAST:event_pnCardF6MouseReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSkipTurn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblCardDescF1;
    private javax.swing.JLabel lblCardDescF2;
    private javax.swing.JLabel lblCardDescF3;
    private javax.swing.JLabel lblCardDescF4;
    private javax.swing.JLabel lblCardDescF5;
    private javax.swing.JLabel lblCardDescF6;
    private javax.swing.JLabel lblCardNameF1;
    private javax.swing.JLabel lblCardNameF2;
    private javax.swing.JLabel lblCardNameF3;
    private javax.swing.JLabel lblCardNameF4;
    private javax.swing.JLabel lblCardNameF5;
    private javax.swing.JLabel lblCardNameF6;
    private javax.swing.JLabel lblDesist;
    private javax.swing.JPanel playerHand;
    private javax.swing.JPanel pnCardF1;
    private javax.swing.JPanel pnCardF2;
    private javax.swing.JPanel pnCardF3;
    private javax.swing.JPanel pnCardF4;
    private javax.swing.JPanel pnCardF5;
    private javax.swing.JPanel pnCardF6;
    // End of variables declaration//GEN-END:variables

    public static void main(String args[]) {
        new BattlefieldView(null, false).setVisible(true);
    }

    private void LoadFields() {
        fields.clear();
        fields.add(new CardField(lblCardNameF1, lblCardDescF1, pnCardF1));
        fields.add(new CardField(lblCardNameF2, lblCardDescF2, pnCardF2));
        fields.add(new CardField(lblCardNameF3, lblCardDescF3, pnCardF3));
        fields.add(new CardField(lblCardNameF4, lblCardDescF4, pnCardF4));
        fields.add(new CardField(lblCardNameF5, lblCardDescF5, pnCardF5));
        fields.add(new CardField(lblCardNameF6, lblCardDescF6, pnCardF6));
    }

    private void SelectField(int id) {
        CardField field = fields.get(id);
        if (!field.isSelected()) {
            fields.forEach(f -> {
                if (f.isSelected()) {
                    f.setSelected(false);
                }
            });
        }
        field.setSelected(!field.isSelected());
    }

}