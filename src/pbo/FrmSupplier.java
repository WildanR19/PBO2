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
public class FrmSupplier extends javax.swing.JFrame {
    
    koneksi k;
    Statement statement;
    ResultSet resultSet;
    int pil;
    
    public FrmSupplier() {
        initComponents();
        k = new koneksi();
        tampilIcon();
        tampilTabel();
    }

    private void simpanData(){
        String sql_insert = "insert into supplier values ('"+txtKodeSupplier.getText()+"','"+txtNamaSupplier.getText()+"','"+txtAlamatSupplier.getText()+"','"+txtKotaSupplier.getText()
        +"','"+txtTelpSupplier.getText()+"','"+txtHpSupplier.getText()+"')";
            try {
                statement.executeUpdate(sql_insert);
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                }
    }
    
     private void koreksiData(){
        String sql_edit = "update supplier set NamaSupplier='"+txtNamaSupplier.getText()+
        "', "
                + "AlamatSupplier='"+txtAlamatSupplier.getText()+"',KotaSupplier='"+txtKotaSupplier.getText()+

        "', "
                + "TelpSupplier='"+ txtTelpSupplier.getText()+"',HpSupplier='"+txtHpSupplier.getText()+
        "' "
                + "where KodeSupplier='"+txtKodeSupplier.getText()+"'";
       try {
        statement.executeUpdate(sql_edit);
           } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
           }
    }
    
    private void hapusData(){
        String sql_delete = "delete from supplier where KodeSupplier= '"+txtKodeSupplier.getText()+"'";
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
        txtKodeSupplier.setEnabled(yKode);
        txtNamaSupplier.setEnabled(yNama);
        txtAlamatSupplier.setEnabled(yAlamat);
        txtKotaSupplier.setEnabled(yKota);
        txtTelpSupplier.setEnabled(yTelp);
        txtHpSupplier.setEnabled(yEmail);
    }
   private void tampilIcon(){
    btnTambah.setIcon(new ImageIcon("./gambar/Add_16x16.png"));
    btnKoreksi.setIcon(new ImageIcon("./gambar/Edit_16x16.png"));
    btnHapus.setIcon(new ImageIcon("./gambar/Delete_16x16.png")); 
    btnSimpan.setIcon(new ImageIcon("./gambar/Save_16x16.png"));
    btnBatal.setIcon(new ImageIcon("./gambar/Cancel_16x16.png"));
    btnKeluar.setIcon(new ImageIcon("./gambar/LogOut_16x16.png"));
}
     
     
    private void tampilTabel(){
        Object header[]={"Kode","Nama Supplier","Alamat Supplier","Kota Supplier","Telp Supplier","Hp Supplier"};
            DefaultTableModel modelSupplier = new DefaultTableModel(null,header){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
            tblSupplier.setModel(modelSupplier);
            int baris = tblSupplier.getRowCount();
            for (int i = 0 ; i < baris; i++){
                modelSupplier.removeRow(i);
            }
            String sql_select = "select * from supplier";
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
                    modelSupplier.addRow(kolom);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
    }
    
    private void bersih(){
        txtKodeSupplier.setText(null);
        txtNamaSupplier.setText(null);
        txtAlamatSupplier.setText(null);
        txtKotaSupplier.setText(null);
        txtTelpSupplier.setText(null);
        txtHpSupplier.setText(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtKodeSupplier = new javax.swing.JTextField();
        txtNamaSupplier = new javax.swing.JTextField();
        txtAlamatSupplier = new javax.swing.JTextField();
        txtKotaSupplier = new javax.swing.JTextField();
        txtTelpSupplier = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtHpSupplier = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSupplier = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnKoreksi = new javax.swing.JButton();
        btnTambah = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel1.setText("Kode Supplier ");

        jLabel2.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel2.setText("Nama Supplier");

        jLabel3.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel3.setText("Alamat Supplier");

        jLabel4.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel4.setText("Kota Supplier");

        jLabel5.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel5.setText("Hp Supplier");

        txtKodeSupplier.setEnabled(false);
        txtKodeSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKodeSupplierActionPerformed(evt);
            }
        });

        txtNamaSupplier.setEnabled(false);

        txtAlamatSupplier.setEnabled(false);

        txtKotaSupplier.setEnabled(false);

        txtTelpSupplier.setEnabled(false);

        jLabel6.setFont(new java.awt.Font("Lucida Sans", 0, 18)); // NOI18N
        jLabel6.setText("Telp Supplier");

        txtHpSupplier.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtKotaSupplier)
                            .addComponent(txtNamaSupplier)
                            .addComponent(txtAlamatSupplier)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtTelpSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtHpSupplier, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))))
                .addContainerGap(771, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtKodeSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNamaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAlamatSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtKotaSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTelpSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtHpSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tblSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama Supplier", "Alamat Supplier", "Kota Supplier", "Telp Supplier", "Hp Supplier"
            }
        ));
        tblSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupplierMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSupplier);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnKoreksi.setText("Koreksi");
        btnKoreksi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnKoreksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKoreksiActionPerformed(evt);
            }
        });

        btnTambah.setText("Tambah");
        btnTambah.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnSimpan.setText("Simpan");
        btnSimpan.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSimpan.setEnabled(false);
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnBatal.setText("Batal");
        btnBatal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnBatal.setEnabled(false);
        btnBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBatalActionPerformed(evt);
            }
        });

        btnKeluar.setText("Keluar");
        btnKeluar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnKoreksi, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 456, Short.MAX_VALUE)
                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKoreksi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        pil = 1 ;
        setTombol(false,false,false,false,true,false);
        setEdit(true,false,false,false,false,false);
        txtKodeSupplier.requestFocus();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKoreksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKoreksiActionPerformed
        // TODO add your handling code here:
        pil = 2 ;
        setTombol(false,false,false,false,true,false);
        setEdit(true,false,false,false,false,false);
        txtKodeSupplier.requestFocus();
    }//GEN-LAST:event_btnKoreksiActionPerformed

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
        btnTambah.requestFocus();
    }//GEN-LAST:event_btnBatalActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void txtKodeSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKodeSupplierActionPerformed
        // TODO add your handling code here:
        if(txtKodeSupplier.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kode Supplier masih kosong...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
            txtKodeSupplier.requestFocus();
        }
        else {
            if (pil == 1){
                String sql_select = "select * from supplier where KodeSupplier = '"+txtKodeSupplier.getText()+"'";
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
                        txtNamaSupplier.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Supplier sudah ada...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
                        txtKodeSupplier.requestFocus();
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
            //Akhir Button Tambah
            if (pil == 2){
                String sql_select = "select * from supplier where KodeSupplier='"+txtKodeSupplier.getText()+"'";
                try {
                    statement = k.con.createStatement();
                    resultSet = statement.executeQuery(sql_select);
                    if (resultSet.next()){
                        txtNamaSupplier.setText(resultSet.getString(2));
                        txtAlamatSupplier.setText(resultSet.getString(3));
                        txtKotaSupplier.setText(resultSet.getString(4));
                        txtTelpSupplier.setText(resultSet.getString(5));
                        txtHpSupplier.setText(resultSet.getString(6));
                        setEdit(false, true, true, true, true, true);
                        btnSimpan.setEnabled(true);
                        txtNamaSupplier.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Supplier tidak diketemukan...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
                        txtKodeSupplier.requestFocus();
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
            if (pil == 3){
                String sql_select = "select * from supplier where KodeSupplier='"+txtKodeSupplier.getText()+"'";
                try {
                    statement = k.con.createStatement();
                    resultSet = statement.executeQuery(sql_select);
                    if (resultSet.next()){
                        txtNamaSupplier.setText(resultSet.getString(2));
                        txtAlamatSupplier.setText(resultSet.getString(3));
                        txtKotaSupplier.setText(resultSet.getString(4));
                        txtTelpSupplier.setText(resultSet.getString(5));
                        txtHpSupplier.setText(resultSet.getString(6));
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
                        JOptionPane.showMessageDialog(null, "Kode Supplier tidak diketemukan...", "Kesalahan",JOptionPane.ERROR_MESSAGE); txtKodeSupplier.requestFocus();
                    }      
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_txtKodeSupplierActionPerformed

    private void tblSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplierMouseClicked
        // TODO add your handling code here:
        if (pil == 2 || pil == 3){
            txtKodeSupplier.setText(tblSupplier.getValueAt(tblSupplier.getSelectedRow(),0).toString());
            txtNamaSupplier.setText(tblSupplier.getValueAt(tblSupplier.getSelectedRow(),1).toString());
            txtAlamatSupplier.setText(tblSupplier.getValueAt(tblSupplier.getSelectedRow(),2).toString());
            txtKotaSupplier.setText(tblSupplier.getValueAt(tblSupplier.getSelectedRow(),3).toString());
            txtTelpSupplier.setText(tblSupplier.getValueAt(tblSupplier.getSelectedRow(),4).toString());
            txtHpSupplier.setText(tblSupplier.getValueAt(tblSupplier.getSelectedRow(),5).toString());
        }
        if (pil == 2) {
            setEdit(false,true,true,true,true,true);
            btnSimpan.setEnabled(true);
            txtNamaSupplier.requestFocus();
        }
        if (pil == 3) {
            txtKodeSupplier.setEnabled(false);
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
    }//GEN-LAST:event_tblSupplierMouseClicked

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        pil = 3;
        setTombol(false,false,false,false,true,false);
        setEdit(true,false,false,false,false,false);
        txtKodeSupplier.requestFocus();
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
            java.util.logging.Logger.getLogger(FrmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmSupplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmSupplier().setVisible(true);
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblSupplier;
    private javax.swing.JTextField txtAlamatSupplier;
    private javax.swing.JTextField txtHpSupplier;
    private javax.swing.JTextField txtKodeSupplier;
    private javax.swing.JTextField txtKotaSupplier;
    private javax.swing.JTextField txtNamaSupplier;
    private javax.swing.JTextField txtTelpSupplier;
    // End of variables declaration//GEN-END:variables
}
