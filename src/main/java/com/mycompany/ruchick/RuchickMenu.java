/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ruchick;

import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.awt.GridLayout;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class RuchickMenu extends javax.swing.JFrame {

    /**
     * Creates new form RuchickMenu
     */
    public static int id_order;
    private MenuPelangganInternalForm menuPelangganInternalForm;
    Color DefaultColor, ClickedColor, FontColor;
    public RuchickMenu(int id_order) {
        initComponents();
        setExtendedState(javax.swing.JFrame.MAXIMIZED_BOTH); // Fullscreen
        DefaultColor = new Color(139,146,178);
        ClickedColor = new Color(242,242,242);
        FontColor = new Color(40,40,100);
        MenuPelangganInternalForm menuPanelSemua = new MenuPelangganInternalForm("", id_order, this);
        jDesktopPanel.removeAll();
        jDesktopPanel.add(menuPanelSemua).setVisible(true);
        this.id_order = id_order;
        baca_data_order();
    }
    
    public void baca_data_order(){
        // Buat variabel untuk menampilkan total belanja
        int total = 0;
        // Buat Object pada model
        DefaultTableModel data_menu = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column)
            {
              return false; // This causes all cells to be not editable
            }
        };
        data_menu.addColumn("Item");
        data_menu.addColumn("Qty");
        data_menu.addColumn("Harga");
        try {
            String SQL_tampil_data = "SELECT m.name AS item, od.quantityOrdered AS qty, m.price AS harga FROM order_details od JOIN menu_items m ON m.menu_item_id = od.menu_item_id WHERE od.order_id = " + id_order;
            // Koneksi ke database
            Connection penghubung_database = (Connection)koneksi_database.konfigurasi_database();
            // Statement Query
            Statement statement_sql = penghubung_database.createStatement();
            ResultSet hasil_sql = statement_sql.executeQuery(SQL_tampil_data);
            while (hasil_sql.next()) {
                data_menu.addRow(new Object[]{
                    hasil_sql.getString(1),
                    hasil_sql.getInt(2),
                    hasil_sql.getInt(3)
                });
                CartTable.setModel(data_menu);
                total = total + hasil_sql.getInt(2)*hasil_sql.getInt(3);
            }
            String totalHargaText = "Rp " + total;
            totalHarga.setText(totalHargaText);
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        AllMenuButton = new javax.swing.JButton();
        FoodsButton = new javax.swing.JButton();
        btn_paket = new javax.swing.JButton();
        DrinksButton = new javax.swing.JButton();
        jPanel = new javax.swing.JPanel();
        jDesktopPanel = new javax.swing.JPanel();
        kategori = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        CartTable = new javax.swing.JTable();
        SearchItemField = new javax.swing.JTextField();
        SearchItemButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        PesanButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        BatalPesanButton = new javax.swing.JButton();
        totalHarga = new javax.swing.JLabel();
        AdditionalButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(139, 146, 178));

        jPanel3.setBackground(new java.awt.Color(40, 40, 100));

        AllMenuButton.setBackground(new java.awt.Color(242, 242, 242));
        AllMenuButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AllMenuButton.setForeground(new java.awt.Color(40, 40, 100));
        AllMenuButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/AllMenu.png"))); // NOI18N
        AllMenuButton.setText("Semua Menu");
        AllMenuButton.setBorder(null);
        AllMenuButton.setBorderPainted(false);
        AllMenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AllMenuButtonActionPerformed(evt);
            }
        });

        FoodsButton.setBackground(new java.awt.Color(139, 146, 178));
        FoodsButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        FoodsButton.setForeground(new java.awt.Color(255, 255, 255));
        FoodsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FriedChicken.png"))); // NOI18N
        FoodsButton.setText("Makanan");
        FoodsButton.setBorder(null);
        FoodsButton.setBorderPainted(false);
        FoodsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FoodsButtonActionPerformed(evt);
            }
        });

        btn_paket.setBackground(new java.awt.Color(139, 146, 178));
        btn_paket.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_paket.setForeground(new java.awt.Color(255, 255, 255));
        btn_paket.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FoodBar.png"))); // NOI18N
        btn_paket.setText("Paket");
        btn_paket.setBorder(null);
        btn_paket.setBorderPainted(false);
        btn_paket.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_paketActionPerformed(evt);
            }
        });

        DrinksButton.setBackground(new java.awt.Color(139, 146, 178));
        DrinksButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        DrinksButton.setForeground(new java.awt.Color(255, 255, 255));
        DrinksButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Food.png"))); // NOI18N
        DrinksButton.setText("Minuman");
        DrinksButton.setBorder(null);
        DrinksButton.setBorderPainted(false);
        DrinksButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DrinksButtonActionPerformed(evt);
            }
        });

        jPanel.setBackground(new java.awt.Color(229, 230, 236));

        jDesktopPanel.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jDesktopPanelLayout = new javax.swing.GroupLayout(jDesktopPanel);
        jDesktopPanel.setLayout(jDesktopPanelLayout);
        jDesktopPanelLayout.setHorizontalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jDesktopPanelLayout.setVerticalGroup(
            jDesktopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        kategori.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        kategori.setForeground(new java.awt.Color(40, 40, 100));
        kategori.setText("Semua Menu");

        CartTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        CartTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item", "Qty", "Harga"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CartTable.setAlignmentX(1.0F);
        CartTable.setAlignmentY(1.0F);
        CartTable.setGridColor(new java.awt.Color(255, 255, 255));
        CartTable.setRowSelectionAllowed(false);
        CartTable.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(CartTable);
        if (CartTable.getColumnModel().getColumnCount() > 0) {
            CartTable.getColumnModel().getColumn(0).setResizable(false);
        }

        SearchItemField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        SearchItemField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchItemFieldActionPerformed(evt);
            }
        });

        SearchItemButton.setBackground(new java.awt.Color(40, 40, 100));
        SearchItemButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        SearchItemButton.setForeground(new java.awt.Color(255, 255, 255));
        SearchItemButton.setText("Cari");
        SearchItemButton.setBorderPainted(false);
        SearchItemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchItemButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Total harga:");

        PesanButton.setBackground(new java.awt.Color(40, 40, 100));
        PesanButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PesanButton.setForeground(new java.awt.Color(255, 255, 255));
        PesanButton.setText("Pesan");
        PesanButton.setBorderPainted(false);
        PesanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesanButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setText("Keranjang Anda");

        BatalPesanButton.setBackground(new java.awt.Color(40, 40, 100));
        BatalPesanButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BatalPesanButton.setForeground(new java.awt.Color(255, 255, 255));
        BatalPesanButton.setText("Batal Memesan");
        BatalPesanButton.setBorderPainted(false);
        BatalPesanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatalPesanButtonActionPerformed(evt);
            }
        });

        totalHarga.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalHarga.setForeground(new java.awt.Color(0, 0, 0));
        totalHarga.setText(" ");

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(kategori)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 172, Short.MAX_VALUE)
                        .addComponent(SearchItemField, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(SearchItemButton))
                    .addComponent(jDesktopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52)
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addGap(0, 7, Short.MAX_VALUE)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                                .addComponent(BatalPesanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(PesanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(totalHarga)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(34, 34, 34))
        );
        jPanelLayout.setVerticalGroup(
            jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLayout.createSequentialGroup()
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kategori)
                            .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(SearchItemField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SearchItemButton)))
                        .addGap(35, 35, 35))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addGap(26, 26, 26)))
                .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(totalHarga))
                        .addGap(36, 36, 36)
                        .addGroup(jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PesanButton)
                            .addComponent(BatalPesanButton)))
                    .addComponent(jDesktopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(124, Short.MAX_VALUE))
        );

        AdditionalButton.setBackground(new java.awt.Color(139, 146, 178));
        AdditionalButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        AdditionalButton.setForeground(new java.awt.Color(255, 255, 255));
        AdditionalButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/FrenchFries.png"))); // NOI18N
        AdditionalButton.setText("Additional");
        AdditionalButton.setBorder(null);
        AdditionalButton.setBorderPainted(false);
        AdditionalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdditionalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(AllMenuButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(FoodsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DrinksButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_paket, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AdditionalButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(AllMenuButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FoodsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DrinksButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AdditionalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_paket, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("RuChick Menu");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 225, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoruchick.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(138, 146, 178));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Close.png"))); // NOI18N
        jButton1.setBorder(null);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 998, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(15, 15, 15))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void DrinksButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DrinksButtonActionPerformed
        // TODO add your handling code here:
        AllMenuButton.setBackground(DefaultColor);
        AllMenuButton.setForeground(Color.white);
        FoodsButton.setBackground(DefaultColor);
        FoodsButton.setForeground(Color.white);
        DrinksButton.setBackground(ClickedColor);
        DrinksButton.setForeground(FontColor);
        AdditionalButton.setBackground(DefaultColor);
        AdditionalButton.setForeground(Color.white);
        btn_paket.setBackground(DefaultColor);
        btn_paket.setForeground(Color.white);
        kategori.setText("Minuman");
        MenuPelangganInternalForm menuPanelDrinks = new MenuPelangganInternalForm("minuman", id_order, this);
        jDesktopPanel.removeAll();
        jDesktopPanel.add(menuPanelDrinks).setVisible(true);

    }//GEN-LAST:event_DrinksButtonActionPerformed

    private void AllMenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AllMenuButtonActionPerformed
        // TODO add your handling code here:
        AllMenuButton.setBackground(ClickedColor);
        AllMenuButton.setForeground(FontColor);
        FoodsButton.setBackground(DefaultColor);
        FoodsButton.setForeground(Color.white);
        DrinksButton.setBackground(DefaultColor);
        DrinksButton.setForeground(Color.white);
        AdditionalButton.setBackground(DefaultColor);
        AdditionalButton.setForeground(Color.white);
        btn_paket.setBackground(DefaultColor);
        btn_paket.setForeground(Color.white);
        kategori.setText("Semua Menu");
        MenuPelangganInternalForm menuPanelSemua = new MenuPelangganInternalForm("", id_order, this);
        jDesktopPanel.removeAll();
        jDesktopPanel.add(menuPanelSemua).setVisible(true);
    }//GEN-LAST:event_AllMenuButtonActionPerformed

    private void FoodsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FoodsButtonActionPerformed
        // TODO add your handling code here:
        AllMenuButton.setBackground(DefaultColor);
        AllMenuButton.setForeground(Color.white);
        FoodsButton.setBackground(ClickedColor);
        FoodsButton.setForeground(FontColor);
        DrinksButton.setBackground(DefaultColor);
        DrinksButton.setForeground(Color.white);
        AdditionalButton.setBackground(DefaultColor);
        AdditionalButton.setForeground(Color.white);
        btn_paket.setBackground(DefaultColor);
        btn_paket.setForeground(Color.white);
        kategori.setText("Makanan");
        MenuPelangganInternalForm menuPanelFoods = new MenuPelangganInternalForm("makanan", id_order, this);
        jDesktopPanel.removeAll();
        jDesktopPanel.add(menuPanelFoods).setVisible(true);
    }//GEN-LAST:event_FoodsButtonActionPerformed

    private void btn_paketActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_paketActionPerformed
        // TODO add your handling code here:
        AllMenuButton.setBackground(DefaultColor);
        AllMenuButton.setForeground(Color.white);
        FoodsButton.setBackground(DefaultColor);
        FoodsButton.setForeground(Color.white);
        DrinksButton.setBackground(DefaultColor);
        DrinksButton.setForeground(Color.white);
        AdditionalButton.setBackground(DefaultColor);
        AdditionalButton.setForeground(Color.white);
        btn_paket.setBackground(ClickedColor);
        btn_paket.setForeground(FontColor);
        kategori.setText("Paket RuChick");
        MenuPelangganInternalForm menuPanelPacket = new MenuPelangganInternalForm("paket", id_order, this);
        jDesktopPanel.removeAll();
        jDesktopPanel.add(menuPanelPacket).setVisible(true);
    }//GEN-LAST:event_btn_paketActionPerformed

    private void AdditionalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdditionalButtonActionPerformed
        // TODO add your handling code here:
        AllMenuButton.setBackground(DefaultColor);
        AllMenuButton.setForeground(Color.white);
        FoodsButton.setBackground(DefaultColor);
        FoodsButton.setForeground(Color.white);
        DrinksButton.setBackground(DefaultColor);
        DrinksButton.setForeground(Color.white);
        btn_paket.setBackground(DefaultColor);
        btn_paket.setForeground(Color.white);
        AdditionalButton.setBackground(ClickedColor);
        AdditionalButton.setForeground(FontColor);
        kategori.setText("Additionals");
        MenuPelangganInternalForm menuPanelAdditional = new MenuPelangganInternalForm("additional", id_order, this);
        jDesktopPanel.removeAll();
        jDesktopPanel.add(menuPanelAdditional).setVisible(true);
    }//GEN-LAST:event_AdditionalButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menutup aplikasi?", "Konfirmasi Penutupan", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void PesanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesanButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PesanButtonActionPerformed

    private void SearchItemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchItemButtonActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_SearchItemButtonActionPerformed

    private void BatalPesanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatalPesanButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BatalPesanButtonActionPerformed

    private void SearchItemFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchItemFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SearchItemFieldActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RuchickMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RuchickMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RuchickMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RuchickMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RuchickMenu(id_order).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdditionalButton;
    private javax.swing.JButton AllMenuButton;
    private javax.swing.JButton BatalPesanButton;
    private javax.swing.JTable CartTable;
    private javax.swing.JButton DrinksButton;
    private javax.swing.JButton FoodsButton;
    private javax.swing.JButton PesanButton;
    private javax.swing.JButton SearchItemButton;
    private javax.swing.JTextField SearchItemField;
    private javax.swing.JButton btn_paket;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jDesktopPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel kategori;
    private javax.swing.JLabel totalHarga;
    // End of variables declaration//GEN-END:variables
}
