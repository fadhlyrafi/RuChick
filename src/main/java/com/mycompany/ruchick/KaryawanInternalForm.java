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
public class KaryawanInternalForm extends javax.swing.JInternalFrame {

    /**
     * Creates new form MenuInternalForm
     */
    String path2 = null;
    public KaryawanInternalForm() {
        initComponents();
        baca_data();
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        BasicInternalFrameUI ui = (BasicInternalFrameUI) this.getUI();
        ui.setNorthPane(null);
    }
    
    public void bersih_layar(){
        id.setText("");
        nama.setText("");
        gaji.setText("");
        jenisKelamin.setSelectedIndex(0);
        keterangan.setText("");
        tambahButton.setEnabled(true);
        editButton.setEnabled(false);
        hapusButton.setEnabled(false);
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
        data_menu.addColumn("ID Karyawan");
        data_menu.addColumn("Nama");
        data_menu.addColumn("Jenis Kelamin");
        data_menu.addColumn("Gaji");
        data_menu.addColumn("Keterangan");
        
        
        try {
            String SQL_tampil_data = "SELECT * FROM employees";
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
                    hasil_sql.getString(5)
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
        id = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        gaji = new javax.swing.JTextField();
        keterangan = new javax.swing.JTextField();
        jenisKelamin = new javax.swing.JComboBox<>();
        tambahButton = new javax.swing.JButton();
        hapusButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        bersihkanButton = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(40, 40, 100));
        jLabel2.setText("Manajemen Karyawan");

        tabel_menu.setBackground(new java.awt.Color(229, 230, 236));
        tabel_menu.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tabel_menu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID Karyawan", "Nama", "Jenis Kelamin", "Gaji", "Keterangan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
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
            tabel_menu.getColumnModel().getColumn(0).setPreferredWidth(150);
            tabel_menu.getColumnModel().getColumn(1).setResizable(false);
            tabel_menu.getColumnModel().getColumn(1).setPreferredWidth(200);
            tabel_menu.getColumnModel().getColumn(2).setResizable(false);
            tabel_menu.getColumnModel().getColumn(2).setPreferredWidth(200);
            tabel_menu.getColumnModel().getColumn(3).setResizable(false);
            tabel_menu.getColumnModel().getColumn(3).setPreferredWidth(1000);
            tabel_menu.getColumnModel().getColumn(4).setResizable(false);
            tabel_menu.getColumnModel().getColumn(4).setPreferredWidth(160);
        }

        jPanel2.setBackground(new java.awt.Color(229, 230, 236));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.lightGray));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("ID Karyawan:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nama:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Jenis Kelamin:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Gaji:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Keterangan:");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        id.setEditable(false);
        id.setBackground(new java.awt.Color(255, 255, 255));
        id.setEnabled(false);
        jPanel2.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 70, 25));

        nama.setEditable(false);
        nama.setBackground(new java.awt.Color(255, 255, 255));
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });
        jPanel2.add(nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 240, 25));

        gaji.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(gaji, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 140, 240, 25));

        keterangan.setBackground(new java.awt.Color(255, 255, 255));
        keterangan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keteranganActionPerformed(evt);
            }
        });
        jPanel2.add(keterangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 180, 190, 25));

        jenisKelamin.setBackground(new java.awt.Color(255, 255, 255));
        jenisKelamin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Laki-laki", "Perempuan" }));
        jenisKelamin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jenisKelaminActionPerformed(evt);
            }
        });
        jPanel2.add(jenisKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 100, 140, -1));

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
        jPanel2.add(tambahButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 300, -1, 30));

        hapusButton.setBackground(new java.awt.Color(40, 40, 100));
        hapusButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        hapusButton.setForeground(new java.awt.Color(255, 255, 255));
        hapusButton.setText("Hapus Data");
        hapusButton.setBorderPainted(false);
        hapusButton.setEnabled(false);
        hapusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusButtonActionPerformed(evt);
            }
        });
        jPanel2.add(hapusButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 110, 30));

        editButton.setBackground(new java.awt.Color(40, 40, 100));
        editButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(255, 255, 255));
        editButton.setText("Edit Data");
        editButton.setBorderPainted(false);
        editButton.setEnabled(false);
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });
        jPanel2.add(editButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, 100, 30));

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
        jPanel2.add(bersihkanButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 300, 100, 30));

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
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)
                .addGap(25, 25, 25))
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

    private void keteranganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keteranganActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_keteranganActionPerformed

    private void tambahButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahButtonActionPerformed
        // TODO add your handling code here:
        String inputID = id.getText();
        String inputNama = nama.getText();
        String inputKeterangan = keterangan.getText();
        String inputGajiStr = gaji.getText();
        String inputJenisKelamin = jenisKelamin.getSelectedItem().toString();
        // Cek apakah field ID kosong
        if (!inputID.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Data dengan ID tersebut sudah ada, bersihkan input terlebih dahulu!", "Kesalahan", JOptionPane.ERROR_MESSAGE);
            bersih_layar();
            return; // Hentikan proses jika ID tidak kosong
        }

        // Cek apakah semua field lainnya diisi
        if (inputNama.isEmpty() ||  inputGajiStr.isEmpty() || 
            inputJenisKelamin.isEmpty() || inputNama.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; // Hentikan proses jika ada field yang kosong
        }
        int inputGaji = Integer.parseInt(inputGajiStr);
        try {
            // Query insert data
            // Query untuk menambahkan data ke menu_items menggunakan parameterized PreparedStatement
            String sql_insert = "INSERT INTO employees (name, jenis_kelamin, gaji, keterangan) VALUES (?, ?, ?, ?)";

            // Koneksi mySQL
            Connection penghubungdatabase = (Connection) koneksi_database.konfigurasi_database();

            // Statement Query
            PreparedStatement query_insert = penghubungdatabase.prepareStatement(sql_insert);

            // Mengatur nilai parameter
            query_insert.setString(1, inputNama);         // Mengatur parameter pertama (name)
            query_insert.setString(2, inputJenisKelamin);        // Mengatur parameter kedua (price)
            query_insert.setInt(3, inputGaji);    // Mengatur parameter ketiga (description)
            query_insert.setString(4, inputKeterangan);     // Mengatur parameter keempat (category)
    
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
        // Disable Button
        editButton.setEnabled(true);
        hapusButton.setEnabled(true);
        tambahButton.setEnabled(false);
        
        // Tabel -> baris dan kolom
        int baris = tabel_menu.rowAtPoint(evt.getPoint());

        // Asumsi kolom di tabel_menu berurutan: 0 = id, 1 = nama, 2 = harga, 3 = deskripsi, 4 = kategori, 5 = stok, 6 = unit
        // Jika urutannya berbeda, sesuaikan indeks kolom di bawah ini

        String tampil_id = tabel_menu.getValueAt(baris, 0).toString();
        id.setText(tampil_id);
        
        String tampil_jk = tabel_menu.getValueAt(baris, 1).toString();
        jenisKelamin.setSelectedItem(tampil_jk);

        String tampil_nama = tabel_menu.getValueAt(baris, 2).toString();
        nama.setText(tampil_nama);
        
        String tampil_deskripsi = tabel_menu.getValueAt(baris, 3).toString();
        gaji.setText(tampil_deskripsi);

        String keterangan_tampil = tabel_menu.getValueAt(baris, 4).toString();
        keterangan.setText(keterangan_tampil);
    }//GEN-LAST:event_tabel_menuMouseClicked

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        // Ambil data dari form
        String inputNama = nama.getText();
        int inputGaji = Integer.parseInt(gaji.getText());
        String inputJenisKelamin = jenisKelamin.getSelectedItem().toString();
        String inputKeterangan = keterangan.getText();
        String inputId = id.getText();  // Assuming you have an id field named id_pk

        if (inputId.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pilih data yang akan diupdate terlebih dahulu.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mengupdate data ini?", "Konfirmasi Update", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Menyiapkan query update data
                String sql_update = "UPDATE employees SET name = ?, jenis_kelamin = ?, gaji = ?, keterangan = ? WHERE employee_id = ?";
                // Koneksi ke database
                Connection penghubungdatabase = (Connection) koneksi_database.konfigurasi_database();
                // Statement Query
                PreparedStatement query_update = penghubungdatabase.prepareStatement(sql_update);

                // Set parameter
                query_update.setString(1, inputNama);
                query_update.setString(2, inputNama);
                query_update.setString(3, inputJenisKelamin);
                query_update.setInt(4, inputGaji);
                query_update.setString(5, inputKeterangan);
                // Eksekusi query
                query_update.executeUpdate();

                // Menampilkan pesan sukses
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate");
                baca_data();
                bersih_layar();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Kesalahan siuu: " + e);
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
                String sql_delete = "DELETE FROM employees WHERE employee_id = ?";

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
                
                // Atur ulang auto increment
                String sql_reset_ai = "ALTER TABLE employees AUTO_INCREMENT = 1";
                PreparedStatement query_reset_ai = penghubungdatabase.prepareStatement(sql_reset_ai);
                query_reset_ai.executeUpdate();

                String sql_set_ai = "ALTER TABLE employees CHANGE employees employees INT(11) NOT NULL AUTO_INCREMENT;";
                PreparedStatement query_set_ai = penghubungdatabase.prepareStatement(sql_set_ai);
                query_set_ai.executeUpdate();
                
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

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void jenisKelaminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jenisKelaminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jenisKelaminActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bersihkanButton;
    private javax.swing.JButton editButton;
    private javax.swing.JTextField gaji;
    private javax.swing.JButton hapusButton;
    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jenisKelamin;
    private javax.swing.JTextField keterangan;
    private javax.swing.JTextField nama;
    private javax.swing.JTable tabel_menu;
    private javax.swing.JButton tambahButton;
    // End of variables declaration//GEN-END:variables
}
