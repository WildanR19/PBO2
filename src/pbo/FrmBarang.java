/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pbo;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Wildan
 */
public class FrmBarang extends javax.swing.JFrame {
    
    
    koneksi k;
    Statement statement;
    ResultSet resultSet;
    int pil;
    /**
     * Creates new form FrmBarang
     */
    public FrmBarang() {
        initComponents();
        k = new koneksi();
        tampilIcon();
        tampilTabel();
    }
    
    private void tampilIcon(){
       btnTambah.setIcon(new ImageIcon("./gambar/Add_16x16.png"));
       btnKoreksi.setIcon(new ImageIcon("./gambar/Edit_16x16.png"));
       btnHapus.setIcon(new ImageIcon("./gambar/Delete_16x16.png"));
       btnSimpan.setIcon(new ImageIcon("./gambar/Save_16x16.png"));
       btnBatal.setIcon(new ImageIcon("./gambar/Cancel_16x16.png"));
       btnKeluar.setIcon(new ImageIcon("./gambar/LogOut_16x16.png"));
    }
    
        private void simpanData(){
        String sql_insert = "insert into barang values ('"+mKodeBarang.getText()+"','"+mNamaBarang.getText()+"','"+mHargaBeli.getText()+"','"+mHargaJual.getText()
        +"','"+mStokBarang.getText()+"','"+mStokMinBarang.getText()+"')";
            try {
                statement.executeUpdate(sql_insert);
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                }
    }
        
        private void koreksiData(){
        String sql_edit = "update barang set NamaBarang='"+mNamaBarang.getText()+
        "', "
                + "HargaBeliBarang='"+mHargaBeli.getText()+"',HargaJualBarang='"+mHargaJual.getText()+

        "', "
                + "StokBarang='"+ mStokBarang.getText()+"',StokMinBarang='"+mStokMinBarang.getText()+
        "' "
                + "where KodeBarang='"+mKodeBarang.getText()+"'";
       try {
        statement.executeUpdate(sql_edit);
           } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
           }
    }
            private void hapusData(){
        String sql_delete = "delete from barang where KodeBarang= '"+mKodeBarang.getText()+"'";
        try {
            statement.executeUpdate(sql_delete);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    private void setTombol(boolean xTambah,boolean xKoreksi, boolean xHapus, boolean xSimpan, boolean xBatal, boolean xKeluar){
        btnTambah.setEnabled(xTambah);
        btnKoreksi.setEnabled(xKoreksi);
        btnHapus.setEnabled(xHapus);
        btnSimpan.setEnabled(xSimpan);
        btnBatal.setEnabled(xBatal);
        btnKeluar.setEnabled(xKeluar);
    }
    
   private void setEdit(boolean yKode,boolean yNama,boolean yAlamat,boolean yKota, boolean yTelp,boolean yEmail){
        mKodeBarang.setEnabled(yKode);
        mNamaBarang.setEnabled(yNama);
        mHargaBeli.setEnabled(yAlamat);
        mHargaJual.setEnabled(yKota);
        mStokBarang.setEnabled(yTelp);
        mStokMinBarang.setEnabled(yEmail);
}
   
   

   
    
    private void tampilTabel(){
        Object header[]={"Kode","Nama Barang","Harga Beli","Harga Jual","Stok Barang","Stok Minimal"};
            DefaultTableModel modelBarang = new DefaultTableModel(null,header){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
            tabelBarang.setModel(modelBarang);
            int baris = tabelBarang.getRowCount();
            for (int i = 0 ; i < baris; i++){
                modelBarang.removeRow(i);
            }
            String sql_select = "select * from barang";
            try {
                statement = k.con.createStatement();
                resultSet = statement.executeQuery(sql_select);
                
                while(resultSet.next()){
                    String kode = resultSet.getString(1);
                    String nama = resultSet.getString(2);
                    String alamat = resultSet.getString(3);
                    String kota = resultSet.getString(4);
                    String telp = resultSet.getString(5);
                    String email = resultSet.getString(6);
                    String kolom[] = {kode,nama,alamat,kota,telp,email};
                    modelBarang.addRow(kolom);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
    }
    
    private void bersih(){
        mKodeBarang.setText(null);
        mNamaBarang.setText(null);
        mHargaBeli.setText(null);
        mHargaJual.setText(null);
        mStokBarang.setText(null);
        mStokMinBarang.setText(null);
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        mKodeBarang = new javax.swing.JTextField();
        mNamaBarang = new javax.swing.JTextField();
        mHargaJual = new javax.swing.JTextField();
        mHargaBeli = new javax.swing.JTextField();
        mStokBarang = new javax.swing.JTextField();
        mStokMinBarang = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelBarang = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnKoreksi = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Kode");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Harga Beli");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Harga Jual");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Stok Barang");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Stok Min");

        mKodeBarang.setEnabled(false);
        mKodeBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKodeBarangActionPerformed(evt);
            }
        });

        mNamaBarang.setEnabled(false);
        mNamaBarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNamaBarangActionPerformed(evt);
            }
        });

        mHargaJual.setEnabled(false);

        mHargaBeli.setEnabled(false);

        mStokBarang.setEnabled(false);

        mStokMinBarang.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mStokMinBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mStokBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(mKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(mNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(mHargaBeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(mHargaJual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5))
                    .addComponent(mStokBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(mStokMinBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tabelBarang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama Barang", "Harga Beli", "Harga Jual", "Stok Barang", "Stok Minimal"
            }
        ));
        tabelBarang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelBarangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelBarang);

        btnTambah.setText("Tambah");
        btnTambah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnKoreksi.setText("Koreksi");
        btnKoreksi.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnKoreksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKoreksiActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnSimpan.setEnabled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnBatal.setEnabled(false);
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1236, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnKoreksi, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKoreksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mNamaBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNamaBarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mNamaBarangActionPerformed

    private void mKodeBarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mKodeBarangActionPerformed
        // TODO add your handling code here:
        if(mKodeBarang.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kode Barang masih kosong...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
            mKodeBarang.requestFocus();
        }
        else {
            if (pil == 1){
                String sql_select = "select * from barang where KodeBarang = '"+mKodeBarang.getText()+"'";
                try {
                    statement = k.con.createStatement();
                    resultSet = statement.executeQuery(sql_select);
                    int baris = 0;
                    while (resultSet.next()){
                        baris = resultSet.getRow();
                    }
                    if ( baris ==0) {
                        setEdit(false,true,true,true,true,true);
                        btnSimpan.setEnabled(true);
                        mNamaBarang.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Barang sudah ada...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
                        mKodeBarang.requestFocus();
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
            //Akhir Button Tambah
            if (pil == 2){
                String sql_select = "select * from barang where KodeBarang='"+mKodeBarang.getText()+"'";
                try {
                    statement = k.con.createStatement();
                    resultSet = statement.executeQuery(sql_select);
                    if (resultSet.next()){
                        mNamaBarang.setText(resultSet.getString(2));
                        mHargaBeli.setText(resultSet.getString(3));
                        mHargaJual.setText(resultSet.getString(4));
                        mStokBarang.setText(resultSet.getString(5));
                        mStokMinBarang.setText(resultSet.getString(6));
                        setEdit(false, true, true, true, true, true);
                        btnSimpan.setEnabled(true);
                        mNamaBarang.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Barang tidak diketemukan...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
                        mKodeBarang.requestFocus();
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
            if (pil == 3){
                String sql_select = "select * from barang where KodeBarang='"+mKodeBarang.getText()+"'";
                try {
                    statement = k.con.createStatement();
                    resultSet = statement.executeQuery(sql_select);
                    if (resultSet.next()){
                        mNamaBarang.setText(resultSet.getString(2));
                        mHargaBeli.setText(resultSet.getString(3));
                        mHargaJual.setText(resultSet.getString(4));
                        mStokBarang.setText(resultSet.getString(5));
                        mStokMinBarang.setText(resultSet.getString(6));
                        setEdit(false, false, false, false, false,false);
                        int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?", "Penghapusan Data", JOptionPane.YES_NO_OPTION);
                        if (opsi == JOptionPane.YES_OPTION){
                            hapusData();
                        }
                            tampilTabel();
                            setTombol(true,true,true,false,false,true);
                            setEdit(false,false,false,false,false,false);
                            bersih();
                            pil = 5;
                            btnTambah.requestFocus();
                    }   else {
                        JOptionPane.showMessageDialog(null, "Kode Barang tidak diketemukan...", "Kesalahan",JOptionPane.ERROR_MESSAGE); mKodeBarang.requestFocus();
                    }      
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_mKodeBarangActionPerformed

    private void tabelBarangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelBarangMouseClicked
        // TODO add your handling code here:
        if (pil == 2 || pil == 3){
            mKodeBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(),0).toString());
            mNamaBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(),1).toString());
            mHargaBeli.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(),2).toString());
            mHargaJual.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(),3).toString());
            mStokBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(),4).toString());
            mStokMinBarang.setText(tabelBarang.getValueAt(tabelBarang.getSelectedRow(),5).toString());
        }
        if (pil == 2) {
            setEdit(false,true,true,true,true,true);
            btnSimpan.setEnabled(true);
            mNamaBarang.requestFocus();
        }
        if (pil == 3) {
            mKodeBarang.setEnabled(false);
            int opsi = JOptionPane.showConfirmDialog(null, "Benarkah anda ingin menghapus data ini ?", "Penghapusan Data", JOptionPane.YES_NO_OPTION);
            if ( opsi == JOptionPane.YES_OPTION){
                hapusData();
            }
            tampilTabel();
            setTombol(true,true,true,false,false,true);
            setEdit(false,false,false,false,false,false);
            bersih();
            pil = 5;
            btnTambah.requestFocus();
        }
    }//GEN-LAST:event_tabelBarangMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        pil = 1 ;
        setTombol(false,false,false,false,true,false);
        setEdit(true,false,false,false,false,false);
        mKodeBarang.requestFocus();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKoreksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKoreksiActionPerformed
        // TODO add your handling code here:
        pil = 2 ;
        setTombol(false,false,false,false,true,false);
        setEdit(true,false,false,false,false,false);
        mKodeBarang.requestFocus();
    }//GEN-LAST:event_btnKoreksiActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        pil = 3;
        setTombol(false,false,false,false,true,false);
        setEdit(true,false,false,false,false,false);
        mKodeBarang.requestFocus();
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        if (pil == 1 ){
            simpanData();
        } else if (pil == 2){
            koreksiData();
        }
        tampilTabel();
        pil = 4;
        setTombol(true,true,true,false,false,true);
        setEdit(false,false,false,false,false,false);
        bersih();
        btnTambah.requestFocus();
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBatalActionPerformed
        // TODO add your handling code here:
        pil = 5;
        setTombol(true,true,true,false,false,true);
        setEdit(false,false,false,false,false,false);
        bersih();
        btnTambah.requestFocus();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBatal;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnKoreksi;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnTambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField mHargaBeli;
    private javax.swing.JTextField mHargaJual;
    private javax.swing.JTextField mKodeBarang;
    private javax.swing.JTextField mNamaBarang;
    private javax.swing.JTextField mStokBarang;
    private javax.swing.JTextField mStokMinBarang;
    private javax.swing.JTable tabelBarang;
    // End of variables declaration//GEN-END:variables
}
