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
public class FrmKonsumen extends javax.swing.JFrame {
    
    
    koneksi k;
    Statement statement;
    ResultSet resultSet;
    int pil;
    /**
     * Creates new form FrmKonsumen
     */
    public FrmKonsumen() {
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
        String sql_insert = "insert into konsumen values ('"+mKodeKonsumen.getText()+"','"+mNamaKonsumen.getText()+"','"+mAlamatKonsumen.getText()+"','"+mKotaKonsumen.getText()
        +"','"+mTelpKonsumen.getText()+"','"+mEmailKonsumen.getText()+"')";
            try {
                statement.executeUpdate(sql_insert);
                } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                }
    }
        
        private void koreksiData(){
        String sql_edit = "update konsumen set NamaKonsumen='"+mNamaKonsumen.getText()+
        "', "
                + "AlamatKonsumen='"+mAlamatKonsumen.getText()+"',KotaKonsumen='"+mKotaKonsumen.getText()+

        "', "
                + "Telpkonsumen='"+ mTelpKonsumen.getText()+"',EmailKonsumen='"+mEmailKonsumen.getText()+
        "' "
                + "where KodeKonsumen='"+mKodeKonsumen.getText()+"'";
       try {
        statement.executeUpdate(sql_edit);
           } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
           }
    }
            private void hapusData(){
        String sql_delete = "delete from konsumen where KodeKonsumen= '"+mKodeKonsumen.getText()+"'";
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
        mKodeKonsumen.setEnabled(yKode);
        mNamaKonsumen.setEnabled(yNama);
        mAlamatKonsumen.setEnabled(yAlamat);
        mKotaKonsumen.setEnabled(yKota);
        mTelpKonsumen.setEnabled(yTelp);
        mEmailKonsumen.setEnabled(yEmail);
}
   
   

   
    
    private void tampilTabel(){
        Object header[]={"Kode","Nama","Alamat","Kota","Telp","e-Mail"};
            DefaultTableModel modelKonsumen = new DefaultTableModel(null,header){
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
            };
            tabelKonsumen.setModel(modelKonsumen);
            int baris = tabelKonsumen.getRowCount();
            for (int i = 0 ; i < baris; i++){
                modelKonsumen.removeRow(i);
            }
            String sql_select = "select * from konsumen";
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
                    modelKonsumen.addRow(kolom);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,e.getMessage());
            }
    }
    
    private void bersih(){
        mKodeKonsumen.setText(null);
        mNamaKonsumen.setText(null);
        mAlamatKonsumen.setText(null);
        mKotaKonsumen.setText(null);
        mTelpKonsumen.setText(null);
        mEmailKonsumen.setText(null);
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
        mKodeKonsumen = new javax.swing.JTextField();
        mNamaKonsumen = new javax.swing.JTextField();
        mKotaKonsumen = new javax.swing.JTextField();
        mAlamatKonsumen = new javax.swing.JTextField();
        mTelpKonsumen = new javax.swing.JTextField();
        mEmailKonsumen = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKonsumen = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        btnTambah = new javax.swing.JButton();
        btnKoreksi = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnSimpan = new javax.swing.JButton();
        btnBatal = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Kode");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Nama");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Alamat");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Kota");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Telp");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("e-Mail");

        mKodeKonsumen.setEnabled(false);
        mKodeKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mKodeKonsumenActionPerformed(evt);
            }
        });

        mNamaKonsumen.setEnabled(false);
        mNamaKonsumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mNamaKonsumenActionPerformed(evt);
            }
        });

        mKotaKonsumen.setEnabled(false);

        mAlamatKonsumen.setEnabled(false);

        mTelpKonsumen.setEnabled(false);

        mEmailKonsumen.setEnabled(false);

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
                    .addComponent(jLabel4))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mKotaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mAlamatKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(mKodeKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mNamaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(56, 56, 56)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(mTelpKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(34, 34, 34)
                                .addComponent(mEmailKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(mEmailKonsumen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(mKodeKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(mNamaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(mTelpKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(mAlamatKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(mKotaKonsumen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        tabelKonsumen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Kode", "Nama", "Alamat", "Kota", "Telp", "e-Mail"
            }
        ));
        tabelKonsumen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKonsumenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKonsumen);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(btnTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKoreksi, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBatal, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 648, Short.MAX_VALUE)
                .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnKoreksi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBatal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mNamaKonsumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mNamaKonsumenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mNamaKonsumenActionPerformed

    private void mKodeKonsumenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mKodeKonsumenActionPerformed
        // TODO add your handling code here:
        if(mKodeKonsumen.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Kode Konsumen masih kosong...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
            mKodeKonsumen.requestFocus();
        }
        else {
            if (pil == 1){
                String sql_select = "select * from konsumen where KodeKonsumen = '"+mKodeKonsumen.getText()+"'";
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
                        mNamaKonsumen.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Konsumen sudah ada...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
                        mKodeKonsumen.requestFocus();
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
            //Akhir Button Tambah
            if (pil == 2){
                String sql_select = "select * from konsumen where KodeKonsumen='"+mKodeKonsumen.getText()+"'";
                try {
                    statement = k.con.createStatement();
                    resultSet = statement.executeQuery(sql_select);
                    if (resultSet.next()){
                        mNamaKonsumen.setText(resultSet.getString(2));
                        mAlamatKonsumen.setText(resultSet.getString(3));
                        mKotaKonsumen.setText(resultSet.getString(4));
                        mTelpKonsumen.setText(resultSet.getString(5));
                        mEmailKonsumen.setText(resultSet.getString(6));
                        setEdit(false, true, true, true, true, true);
                        btnSimpan.setEnabled(true);
                        mNamaKonsumen.requestFocus();
                    } else {
                        JOptionPane.showMessageDialog(null, "Kode Konsumen tidak diketemukan...", "Kesalahan",JOptionPane.ERROR_MESSAGE);
                        mKodeKonsumen.requestFocus();
                    }
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null,e.getMessage());
                }
            }
            if (pil == 3){
                String sql_select = "select * from konsumen where KodeKonsumen='"+mKodeKonsumen.getText()+"'";
                try {
                    statement = k.con.createStatement();
                    resultSet = statement.executeQuery(sql_select);
                    if (resultSet.next()){
                        mNamaKonsumen.setText(resultSet.getString(2));
                        mAlamatKonsumen.setText(resultSet.getString(3));
                        mKotaKonsumen.setText(resultSet.getString(4));
                        mTelpKonsumen.setText(resultSet.getString(5));
                        mEmailKonsumen.setText(resultSet.getString(6));
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
                        JOptionPane.showMessageDialog(null, "Kode Konsumen tidak diketemukan...", "Kesalahan",JOptionPane.ERROR_MESSAGE); mKodeKonsumen.requestFocus();
                    }      
                } catch (Exception e){
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            }
        }
    }//GEN-LAST:event_mKodeKonsumenActionPerformed

    private void tabelKonsumenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKonsumenMouseClicked
        // TODO add your handling code here:
        if (pil == 2 || pil == 3){
            mKodeKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(),0).toString());
            mNamaKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(),1).toString());
            mAlamatKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(),2).toString());
            mKotaKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(),3).toString());
            mTelpKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(),4).toString());
            mEmailKonsumen.setText(tabelKonsumen.getValueAt(tabelKonsumen.getSelectedRow(),5).toString());
        }
        if (pil == 2) {
            setEdit(false,true,true,true,true,true);
            btnSimpan.setEnabled(true);
            mNamaKonsumen.requestFocus();
        }
        if (pil == 3) {
            mKodeKonsumen.setEnabled(false);
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
    }//GEN-LAST:event_tabelKonsumenMouseClicked

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        pil = 1 ;
        setTombol(false,false,false,false,true,false);
        setEdit(true,false,false,false,false,false);
        mKodeKonsumen.requestFocus();
    }//GEN-LAST:event_btnTambahActionPerformed

    private void btnKoreksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKoreksiActionPerformed
        // TODO add your handling code here:
        pil = 2 ;
        setTombol(false,false,false,false,true,false);
        setEdit(true,false,false,false,false,false);
        mKodeKonsumen.requestFocus();
    }//GEN-LAST:event_btnKoreksiActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
        pil = 3;
        setTombol(false,false,false,false,true,false);
        setEdit(true,false,false,false,false,false);
        mKodeKonsumen.requestFocus();
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
            java.util.logging.Logger.getLogger(FrmKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmKonsumen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmKonsumen().setVisible(true);
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
    private javax.swing.JTextField mAlamatKonsumen;
    private javax.swing.JTextField mEmailKonsumen;
    private javax.swing.JTextField mKodeKonsumen;
    private javax.swing.JTextField mKotaKonsumen;
    private javax.swing.JTextField mNamaKonsumen;
    private javax.swing.JTextField mTelpKonsumen;
    private javax.swing.JTable tabelKonsumen;
    // End of variables declaration//GEN-END:variables
}
