/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package com.mycompany.ruchick;
import com.mycompany.ruchick.koneksi_database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.plaf.basic.BasicInternalFrameUI;

/**
 *
 * @author Muhamad Fadhly
 */
public class MenuInternalForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form MenuInternalForm
     */
    public MenuInternalForm() {
        initComponents();
        baca_data();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
    }
    
    public void bersih_layar(){
        id.setText("");
        nama.setText("");
        harga.setText("");
        deskripsi.setText("");
        kategori.setText("");
        stok.setText("");
        unit.setText("");
    }
    
    public void baca_data(){
        // Buat Object pada model
        // Buat Object pada model
        DefaultTableModel data_menu = new DefaultTableModel();
        data_menu.addColumn("ID Menu");
        data_menu.addColumn("Nama");
        data_menu.addColumn("Harga");
        data_menu.addColumn("Deskripsi");
        data_menu.addColumn("Kategori");
        data_menu.addColumn("Stok");
        data_menu.addColumn("Unit");
        
        try {
            String SQL_tampil_data = "SELECT * FROM menu_items";
            // Koneksi ke database
            Connection penghubung_database = (Connection)koneksi_database.konfigurasi_database();
            // Statement Query
            Statement statement_sql = penghubung_database.createStatement();
            ResultSet hasil_sql = statement_sql.executeQuery(SQL_tampil_data);
            while (hasil_sql.next()) {
                data_menu.addRow(new Object[]{
                    hasil_sql.getString(1),
                    hasil_sql.getString(2),
                    hasil_sql.getString(3),
                    hasil_sql.getString(4),
                    hasil_sql.getString(5),
                    hasil_sql.getString(6),
                    hasil_sql.getString(7)
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        deskripsi = new javax.swing.JTextField();
        kategori = new javax.swing.JTextField();
        stok = new javax.swing.JTextField();
        unit = new javax.swing.JTextField();
        tambahButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        hapusButton1 = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(40, 40, 100));
        jLabel2.setText("Menu Management");

        tabel_menu.setBackground(new java.awt.Color(255, 255, 255));
        tabel_menu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Menu", "Nama", "Harga", "Deskripsi", "Kategori", "Stok", "Unit"
            }
        ));
        tabel_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_menuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_menu);
        if (tabel_menu.getColumnModel().getColumnCount() > 0) {
            tabel_menu.getColumnModel().getColumn(0).setPreferredWidth(150);
            tabel_menu.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabel_menu.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabel_menu.getColumnModel().getColumn(3).setPreferredWidth(1000);
            tabel_menu.getColumnModel().getColumn(4).setPreferredWidth(160);
        }

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("ID Menu:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 11, -1, -1));

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nama:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 39, -1, -1));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Harga:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 67, -1, -1));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Deskripsi:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 95, -1, -1));

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Kategori:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(8, 123, -1, -1));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Stok:");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, -1, -1));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Unit:");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        id.setEditable(false);
        id.setBackground(new java.awt.Color(255, 255, 255));
        id.setEnabled(false);
        jPanel2.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 8, 70, -1));

        nama.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 36, 240, -1));

        harga.setBackground(new java.awt.Color(255, 255, 255));
        harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hargaActionPerformed(evt);
            }
        });
        jPanel2.add(harga, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 64, 120, -1));

        deskripsi.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(deskripsi, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 92, 440, -1));

        kategori.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(kategori, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 120, 240, -1));

        stok.setBackground(new java.awt.Color(255, 255, 255));
        stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stokActionPerformed(evt);
            }
        });
        jPanel2.add(stok, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 148, 70, -1));

        unit.setBackground(new java.awt.Color(255, 255, 255));
        unit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitActionPerformed(evt);
            }
        });
        jPanel2.add(unit, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 176, 70, -1));

        tambahButton.setBackground(new java.awt.Color(51, 102, 255));
        tambahButton.setForeground(new java.awt.Color(255, 255, 255));
        tambahButton.setText("Tambah Data");
        tambahButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahButtonActionPerformed(evt);
            }
        });
        jPanel2.add(tambahButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, -1, -1));

        hapusButton.setBackground(new java.awt.Color(255, 51, 51));
        hapusButton.setForeground(new java.awt.Color(255, 255, 255));
        hapusButton.setText("Bersihkan");
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });
        jPanel2.add(hapusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 100, -1));

        editButton.setBackground(new java.awt.Color(51, 153, 255));
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit Data");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        jPanel2.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, 100, -1));

        hapusButton1.setBackground(new java.awt.Color(255, 51, 51));
        hapusButton1.setForeground(new java.awt.Color(255, 255, 255));
        hapusButton1.setText("Hapus Data");
        hapusButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(hapusButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 90, 100, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE))
                .addContainerGap(325, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
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

    private void stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_stokActionPerformed

    private void unitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitActionPerformed

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        // TODO add your handling code here:
        String inputNama = nama.getText();
        int inputHarga = Integer.parseInt(harga.getText());
        String inputDeskripsi = deskripsi.getText();
        String inputKategori = kategori.getText();
        int inputStok = Integer.parseInt(stok.getText());
        String inputUnit = unit.getText();
        try {
            // Query insert data
            String sql_insert = "INSERT INTO menu_items (name, price, description, category, stock, units) VALUES ('" + inputNama + "', '" + inputHarga + "', '" + inputDeskripsi + "', '" + inputKategori + "', '" + inputStok + "', '" + inputUnit + "')";
            // Koneksi mySQL
            Connection penghubungdatabase = (Connection)koneksi_database.konfigurasi_database();
            // Statement Query
            PreparedStatement query_insert = penghubungdatabase.prepareStatement(sql_insert);
            // Eksekusi
            query_insert.execute();
            // Munculkan data yang sudah disimpan
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            baca_data();
            bersih_layar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Kesalahan:" + e);
        }
    }//GEN-LAST:event_tambahButtonActionPerformed

    private void hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hargaActionPerformed

    private void tabel_menuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_menuMouseClicked
        // TODO add your handling code here:
        // Tabel -> baris dan kolom
        int baris = tabel_menu.rowAtPoint(evt.getPoint());

        // Asumsi kolom di tabel_menu berurutan: 0 = id, 1 = nama, 2 = harga, 3 = deskripsi, 4 = kategori, 5 = stok, 6 = unit
        // Jika urutannya berbeda, sesuaikan indeks kolom di bawah ini

        String tampil_id = tabel_menu.getValueAt(baris, 0).toString();
        id.setText(tampil_id);

        String tampil_nama = tabel_menu.getValueAt(baris, 1).toString();
        nama.setText(tampil_nama);

        String tampil_harga = tabel_menu.getValueAt(baris, 2).toString();
        harga.setText(tampil_harga);

        String tampil_deskripsi = tabel_menu.getValueAt(baris, 3).toString();
        deskripsi.setText(tampil_deskripsi);

        String tampil_kategori = tabel_menu.getValueAt(baris, 4).toString();
        kategori.setText(tampil_kategori);

        String tampil_stok = tabel_menu.getValueAt(baris, 5).toString();
        stok.setText(tampil_stok);

        String tampil_unit = tabel_menu.getValueAt(baris, 6).toString();
        unit.setText(tampil_unit);
    }//GEN-LAST:event_tabel_menuMouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String inputNama = nama.getText();
        int inputHarga = Integer.parseInt(harga.getText());
        String inputDeskripsi = deskripsi.getText();
        String inputKategori = kategori.getText();
        int inputStok = Integer.parseInt(stok.getText());
        String inputUnit = unit.getText();
        String inputId = id.getText();  // Assuming you have an id field named id_pk

        if (inputId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pilih data yang akan diupdate terlebih dahulu.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengupdate data ini?", "Konfirmasi Update", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Query update data
                String sql_update = "UPDATE menu_items SET name = ?, price = ?, description = ?, category = ?, stock = ?, units = ? WHERE menu_item_id = ?";
                // Koneksi mySQL
                Connection penghubungdatabase = (Connection)koneksi_database.konfigurasi_database();
                // Statement Query
                PreparedStatement query_update = penghubungdatabase.prepareStatement(sql_update);
                // Set parameters
                query_update.setString(1, inputNama);
                query_update.setInt(2, inputHarga);
                query_update.setString(3, inputDeskripsi);
                query_update.setString(4, inputKategori);
                query_update.setInt(5, inputStok);
                query_update.setString(6, inputUnit);
                query_update.setString(7, inputId);

                // Eksekusi
                query_update.executeUpdate();

                // Munculkan data yang sudah diupdate
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
                baca_data();
                bersih_layar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Kesalahan: " + e);
            }
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void hapusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButtonActionPerformed
        // TODO add your handling code here:
        String inputId = id.getText();  // Assuming you have an id field named id_pk
    
        if (inputId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pilih data yang akan dihapus terlebih dahulu.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Query delete data
                String sql_delete = "DELETE FROM menu_items WHERE menu_item_id = ?";

                // Koneksi mySQL
                Connection penghubungdatabase = (Connection)koneksi_database.konfigurasi_database();

                // Statement Query
                PreparedStatement query_delete = penghubungdatabase.prepareStatement(sql_delete);

                // Set parameter
                query_delete.setString(1, inputId);

                // Eksekusi
                query_delete.executeUpdate();

                // Munculkan data yang sudah dihapus
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
                baca_data();
                bersih_layar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Kesalahan: " + e);
            }
        }
    }//GEN-LAST:event_hapusButtonActionPerformed

    private void hapusButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hapusButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField deskripsi;
    private javax.swing.JButton editButton;
    private javax.swing.JButton hapusButton;
    private javax.swing.JButton hapusButton1;
    private javax.swing.JTextField harga;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField kategori;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField stok;
    private javax.swing.JTable tabel_menu;
    private javax.swing.JButton tambahButton;
    private javax.swing.JTextField unit;
    // End of variables declaration//GEN-END:variables
}