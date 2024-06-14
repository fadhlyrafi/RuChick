/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.ruchick;
import com.mycompany.ruchick.koneksi_database;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Muhamad Fadhly
 */
public class AdminInternalForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form MenuInternalForm
     */
    String path2 = null;
    public AdminInternalForm() {
        initComponents();
        baca_data();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
    }
    
    public void bersih_layar(){
        username.setText("");
        password.setText("");
        username.setEnabled(true);
    }
    
    public void baca_data(){
        // Buat Object pada model
        // Buat Object pada model
        DefaultTableModel data_menu = new DefaultTableModel(){
            public boolean isCellEditable(int row, int column)
            {
              return false; // This causes all cells to be not editable
            }
        };
        data_menu.addColumn("Username");
        data_menu.addColumn("Password");
        
        try {
            String SQL_tampil_data = "SELECT * FROM admins";
            // Koneksi ke database
            Connection penghubung_database = (Connection)koneksi_database.konfigurasi_database();
            // Statement Query
            Statement statement_sql = penghubung_database.createStatement();
            ResultSet hasil_sql = statement_sql.executeQuery(SQL_tampil_data);
            while (hasil_sql.next()) {
                data_menu.addRow(new Object[]{
                    hasil_sql.getString(1),
                    hasil_sql.getString(2)
                });
                tabel_menu.setModel(data_menu);
            }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_menu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        username = new javax.swing.JTextField();
        password = new javax.swing.JTextField();
        tambahButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        bersihkanButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(40, 40, 100));
        jLabel2.setText("Manajemen Admin");

        tabel_menu.setBackground(new java.awt.Color(229, 230, 236));
        tabel_menu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabel_menu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Username", "Password"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_menu.getTableHeader().setReorderingAllowed(false);
        tabel_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_menuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_menu);
        if (tabel_menu.getColumnModel().getColumnCount() > 0) {
            tabel_menu.getColumnModel().getColumn(0).setResizable(false);
            tabel_menu.getColumnModel().getColumn(0).setPreferredWidth(200);
            tabel_menu.getColumnModel().getColumn(1).setResizable(false);
            tabel_menu.getColumnModel().getColumn(1).setPreferredWidth(200);
        }

        jPanel2.setBackground(new java.awt.Color(229, 230, 236));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Username:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Password:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        username.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(username, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 80, 25));

        password.setBackground(new java.awt.Color(255, 255, 255));
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });
        jPanel2.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 240, 25));

        tambahButton.setBackground(new java.awt.Color(40, 40, 100));
        tambahButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tambahButton.setForeground(new java.awt.Color(255, 255, 255));
        tambahButton.setText("Tambah Data");
        tambahButton.setBorderPainted(false);
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });
        jPanel2.add(tambahButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 140, -1, 30));

        hapusButton.setBackground(new java.awt.Color(40, 40, 100));
        hapusButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hapusButton.setForeground(new java.awt.Color(255, 255, 255));
        hapusButton.setText("Hapus Data");
        hapusButton.setBorderPainted(false);
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });
        jPanel2.add(hapusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 140, 110, 30));

        editButton.setBackground(new java.awt.Color(40, 40, 100));
        editButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit Data");
        editButton.setBorderPainted(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        jPanel2.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 100, 30));

        bersihkanButton.setBackground(new java.awt.Color(40, 40, 100));
        bersihkanButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        bersihkanButton.setForeground(new java.awt.Color(255, 255, 255));
        bersihkanButton.setText("Bersihkan");
        bersihkanButton.setBorderPainted(false);
        bersihkanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bersihkanButtonActionPerformed(evt);
            }
        });
        jPanel2.add(bersihkanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, 100, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 823, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                .addGap(28, 28, 28)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(200, 200, 200))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        // TODO add your handling code here:
        String inputUsername = username.getText();
        String inputPassword = password.getText();
        // Cek apakah field ID kosong
        // Cek apakah semua field lainnya diisi
        if (inputPassword.isEmpty() || inputUsername.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Hentikan proses jika ada field yang kosong
        }
        try {
            JOptionPane.showMessageDialog(null, path2);
            // Query insert data
            // Query untuk menambahkan data ke menu_items menggunakan parameterized PreparedStatement
            String sql_insert = "INSERT INTO admins (username, password) VALUES (?, ?)";

            // Koneksi mySQL
            Connection penghubungdatabase = (Connection) koneksi_database.konfigurasi_database();

            // Statement Query
            PreparedStatement query_insert = penghubungdatabase.prepareStatement(sql_insert);

            // Mengatur nilai parameter
            query_insert.setString(1, inputUsername);         // Mengatur parameter pertama (name)
            query_insert.setString(2, inputPassword);        // Mengatur parameter kedua (price)                 // Mengatur parameter ketujuh (image_id)
    
            query_insert.executeUpdate();
            // Munculkan data yang sudah disimpan
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            baca_data();
            bersih_layar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan:" + e);
        }
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void tabel_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_menuMouseClicked
        // TODO add your handling code here:
        // Tabel -> baris dan kolom
        int baris = tabel_menu.rowAtPoint(evt.getPoint());
        username.setEnabled(false);

        // Asumsi kolom di tabel_menu berurutan: 0 = id, 1 = nama, 2 = harga, 3 = deskripsi, 4 = kategori, 5 = stok, 6 = unit
        // Jika urutannya berbeda, sesuaikan indeks kolom di bawah ini

        String tampil_username = tabel_menu.getValueAt(baris, 0).toString();
        username.setText(tampil_username);

        String tampil_password = tabel_menu.getValueAt(baris, 1).toString();
        password.setText(tampil_password);        
    }//GEN-LAST:event_tabel_menuMouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // Ambil data dari form
        String inputPassword = password.getText();
        String inputUsername = username.getText();  // Assuming you have an id field named id_pk

        if (inputUsername.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pilih data yang akan diupdate terlebih dahulu.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengupdate data ini?", "Konfirmasi Update", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Menyiapkan query update data
                String sql_update = "UPDATE admins SET password = ? WHERE username = ?";
                // Koneksi ke database
                Connection penghubungdatabase = (Connection) koneksi_database.konfigurasi_database();
                // Statement Query
                PreparedStatement query_update = penghubungdatabase.prepareStatement(sql_update);

                // Set parameter
                query_update.setString(1, inputPassword);
                query_update.setString(2, inputUsername);

                // Eksekusi query
                query_update.executeUpdate();

                // Menampilkan pesan sukses
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
                baca_data();
                bersih_layar();
                path2 = null;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Kesalahan siuu: " + e);
            }
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        // TODO add your handling code here:
        String inputUsername = username.getText();  // Assuming you have an id field named id_pk
    
        if (inputUsername.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus terlebih dahulu.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Query delete data
                String sql_delete = "DELETE FROM admins WHERE username = ?";

                // Koneksi mySQL
                Connection penghubungdatabase = (Connection)koneksi_database.konfigurasi_database();

                // Statement Query
                PreparedStatement query_delete = penghubungdatabase.prepareStatement(sql_delete);

                // Set parameter
                query_delete.setString(1, inputUsername);

                // Eksekusi
                query_delete.executeUpdate();

                // Munculkan data yang sudah dihapus
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                
                // Atur ulang auto increment
                baca_data();
                bersih_layar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Kesalahan: " + e);
            }
        }
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void bersihkanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bersihkanButtonActionPerformed
        // TODO add your handling code here:
        bersih_layar();
    }//GEN-LAST:event_bersihkanButtonActionPerformed

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bersihkanButton;
    private javax.swing.JButton editButton;
    private javax.swing.JButton hapusButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField password;
    private javax.swing.JTable tabel_menu;
    private javax.swing.JButton tambahButton;
    private javax.swing.JTextField username;
    // End of variables declaration//GEN-END:variables
}
