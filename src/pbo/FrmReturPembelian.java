/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Wildan
 */
public class FrmReturPembelian extends javax.swing.JFrame {

    koneksi k;
    Statement statement;
    ResultSet resultSet;
    String tanggal;
    public FrmReturPembelian() {
        initComponents();
        k = new koneksi();
        tampilIcon();
        tampilTabel();
        bacaPembelian();
    }
    
    private void tampilIcon(){
        btnBaru.setIcon(new ImageIcon("./gambar/Add_16x16.png"));
        btnSimpan.setIcon(new ImageIcon("./gambar/Save_16x16.png"));
        btnBatal.setIcon(new ImageIcon("./gambar/Cancel_16x16.png"));
        btnKeluar.setIcon(new ImageIcon("./gambar/LogOut_16x16.png"));
        btnTambah.setIcon(new ImageIcon("./gambar/Add_16x16.png"));
        btnHapus.setIcon(new ImageIcon("./gambar/Delete_16x16.png"));
    }
    
    private void tampilTabel(){
    Object header[]={"Kode Retur Pembelian","Kode Barang","Harga Barang","Jumlah Retur Pembelian"};
    DefaultTableModel modelBarang = new DefaultTableModel(null, header){
    @Override
    // Membuat jTable read only
    public boolean isCellEditable(int row, int column){
        return false;
    }
    };
        tabelReturPembelian.setModel(modelBarang);
    }
    
    private void bersih(){
        mKodeReturPembelian.setText(null);
        sTglReturPembelian.setValue(new Date());
        cKodePembelian.setSelectedIndex(0);
        mKodeBarang.setText(null);
    }
    
    private void setTombol(boolean xBaru, boolean xSimpan, boolean xTambah, boolean xBatal, boolean xHapus, boolean xKeluar){
    btnBaru.setEnabled(xBaru);
    btnSimpan.setEnabled(xSimpan);
    btnTambah.setEnabled(xTambah);
    btnBatal.setEnabled(xBatal);
    btnHapus.setEnabled(xHapus);
    btnKeluar.setEnabled(xKeluar);
    }
    
    private void setEdit(boolean yKodeRetur,boolean yTglRetur,boolean yKodePembelian, boolean yKodeBarang, boolean yHargaBarang, boolean yJmlBarang ){
        mKodeReturPembelian.setEnabled(yKodeRetur);
        sTglReturPembelian.setEnabled(yTglRetur);
        cKodePembelian.setEnabled(yKodePembelian);
        mKodeBarang.setEnabled(yKodeBarang);
        mHargaBarang.setEnabled(yHargaBarang);
        mJmlBarang.setEnabled(yJmlBarang);
    }
    
    private void bacaPembelian(){
        String sql_select = "select * from dpembelian";
        try {
            statement = k.con.createStatement();
            resultSet = statement.executeQuery(sql_select);
            resultSet.beforeFirst();
            while(resultSet.next()){
                cKodePembelian.addItem(resultSet.getString(1));
            }
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void bersihTabel(){
    DefaultTableModel modelBarang = (DefaultTableModel)tabelReturPembelian.getModel();
    int brs = modelBarang.getRowCount();
    if (brs>0){
    for (int i = brs-1; i >=0; i--) {
    modelBarang.removeRow(i);
        }
        }
    }
    
    private void format_tanggal(){
    String DATE_FORMAT = "yyyy-MM-dd";
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);
    Calendar c1 = Calendar.getInstance();
    int year=c1.get(Calendar.YEAR);
    int month=c1.get(Calendar.MONTH)+1;
    int day=c1.get(Calendar.DAY_OF_MONTH);
    tanggal=Integer.toString(year)+"-"+Integer.toString(month)+"-"+Integer.toString(day);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        mKodeReturPembelian = new javax.swing.JTextField();
        mKodeBarang = new javax.swing.JTextField();
        sTglReturPembelian = new javax.swing.JSpinner();
        cKodePembelian = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        mHargaBarang = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        mJmlBarang = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelReturPembelian = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnBaru = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Kode Retur Pembelian");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tanggal Retur Pembelian");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Kode Pembelian");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Kode Barang");

        mKodeReturPembelian.setEnabled(false);
        mKodeReturPembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKodeReturPembelianActionPerformed(evt);
            }
        });

        mKodeBarang.setEnabled(false);

        sTglReturPembelian.setModel(new javax.swing.SpinnerDateModel());
        sTglReturPembelian.setEditor(new javax.swing.JSpinner.DateEditor(sTglReturPembelian, "dd-MMMM-yyyy"));
        sTglReturPembelian.setEnabled(false);

        cKodePembelian.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih --" }));
        cKodePembelian.setEnabled(false);
        cKodePembelian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cKodePembelianActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Harga Barang");

        mHargaBarang.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Jumlah Barang");

        mJmlBarang.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mKodeReturPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sTglReturPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 448, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(mKodeBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(cKodePembelian, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mHargaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
                    .addComponent(mJmlBarang))
                .addGap(25, 25, 25))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(mKodeReturPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cKodePembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(sTglReturPembelian, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(mKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(mHargaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(mJmlBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tabelReturPembelian.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode Retur Pembelian", "Kode Barang", "Harga Barang", "Jumlah Retur Beli Barang"
            }
        ));
        jScrollPane1.setViewportView(tabelReturPembelian);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnBaru.setText("Transaksi Baru");
        btnBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBaruActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.setEnabled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.setEnabled(false);
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.setEnabled(false);
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.setEnabled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBaru)
                    .addComponent(btnSimpan)
                    .addComponent(btnKeluar)
                    .addComponent(btnTambah)
                    .addComponent(btnBatal)
                    .addComponent(btnHapus))
                .addContainerGap(91, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBaruActionPerformed
        // TODO add your handling code here:
        setTombol(false, false, true, true, false, false);
        setEdit(true,false,false,false,false,false);
        mKodeReturPembelian.requestFocus();
    }//GEN-LAST:event_btnBaruActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        format_tanggal();
        String sql_insert = "insert into returpembelian values ('"+mKodeReturPembelian.getText()+"','"+cKodePembelian.getSelectedItem()+"','"+tanggal+"')";
        try{
            statement.executeUpdate(sql_insert);
            DefaultTableModel modelReturPembelian = (DefaultTableModel)tabelReturPembelian.getModel();
            int brs = modelReturPembelian.getRowCount();
            for(int i=0; i<brs;i++){
                String xkd = (String)tabelReturPembelian.getValueAt(i,1);
                int xhrg = Integer.parseInt(tabelReturPembelian.getValueAt(i,2).toString());
                int xjml = Integer.parseInt(tabelReturPembelian.getValueAt(i,3).toString());
                String zsql = "insert into dreturpembelian values ('"+mKodeReturPembelian.getText()+"','"+xkd+"','"+xhrg+"','"+xjml+"')";
                statement.executeUpdate(zsql);
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        setTombol(true, false, false, false, false, true);
        setEdit(false,false,false,false,false,false);
        bersihTabel();
        bersih();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        setTombol(true, false, false, false, false, true);
        setEdit(false,false,false,false,false,false);
        bersihTabel();
        bersih();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void mKodeReturPembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mKodeReturPembelianActionPerformed
        // TODO add your handling code here:
        if(mKodeReturPembelian.getText().isEmpty()){
            JOptionPane.showMessageDialog(null,"Kode Retur Pembelian Masih Kosong ... ","Kesalahan ",JOptionPane.ERROR_MESSAGE);
            mKodeReturPembelian.requestFocus();
        } else {
            String sql_select = "select * from returpembelian where kodereturpembelian='"+mKodeReturPembelian.getText()+"'";
            try {
                statement = k.con.createStatement();
                resultSet = statement.executeQuery(sql_select);
                int baris = 0;
                while (resultSet.next()){
                    baris = resultSet.getRow();
                }
                if (baris==0){
                    setEdit(false,true,true,false,false,false);
                    sTglReturPembelian.requestFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Kode Retur Pembelian sudah ada  ... ","Kesalahan ",JOptionPane.ERROR_MESSAGE);
                    mKodeReturPembelian.requestFocus();
                }
            }catch ( Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_mKodeReturPembelianActionPerformed

    private void cKodePembelianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cKodePembelianActionPerformed
        // TODO add your handling code here:
        if (cKodePembelian.getSelectedItem()=="-- Pilih --"){
            mKodeBarang.setText(null);
            mHargaBarang.setText(null);
            mJmlBarang.setText(null);
            cKodePembelian.setSelectedIndex(0);
            cKodePembelian.requestFocus();
        } else {
            String sql_select = "select * from dpembelian where kodepembelian='"+cKodePembelian.getSelectedItem()+"'";
            try {
            statement = k.con.createStatement();
            resultSet = statement.executeQuery(sql_select);
            resultSet.beforeFirst();
            while(resultSet.next()){
                mKodeBarang.setText(resultSet.getString(2));
                mHargaBarang.setText(resultSet.getString(3));
                mJmlBarang.setText(resultSet.getString(4));
                }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }//GEN-LAST:event_cKodePembelianActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelBarang = (DefaultTableModel)tabelReturPembelian.getModel();
        String[]data = new String[4];
        data[0] = mKodeReturPembelian.getText();
        data[1] = mKodeBarang.getText();
        data[2] = mHargaBarang.getText();
        data[3] = mJmlBarang.getText();
        modelBarang.addRow(data);
        mKodeReturPembelian.setText(null);
        mKodeBarang.setText(null);
        mHargaBarang.setText(null);
        mJmlBarang.setText(null);
        setTombol(true, true, false, true, true, true);
        setEdit(false, false, false, false, false, false);
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        try {
        DefaultTableModel tableModel = (DefaultTableModel)tabelReturPembelian.getModel();
        int x = tabelReturPembelian.getSelectedRow();
        tableModel.removeRow(x);
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(this, "Tabel Belum Dipilih", "Kesalahan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(FrmReturPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmReturPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmReturPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmReturPembelian.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmReturPembelian().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBaru;
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JComboBox<String> cKodePembelian;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mHargaBarang;
    private javax.swing.JTextField mJmlBarang;
    private javax.swing.JTextField mKodeBarang;
    private javax.swing.JTextField mKodeReturPembelian;
    private javax.swing.JSpinner sTglReturPembelian;
    private javax.swing.JTable tabelReturPembelian;
    // End of variables declaration//GEN-END:variables
}
