/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;
import POJO.DBA_AUDIT_POLICIES;
import DAO.FGAAuditTrail_DAO;
import POJO.ColumnNameTable_POJO;
import POJO.Table_POJO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class FGA_GUI extends javax.swing.JFrame {
    Vector tblData = new Vector();
    Vector tblTitle = new Vector();
    DefaultTableModel tblModel;         
    public static String tenTable;
//    String s1[] = {"NHANVIEN", "HOCSINH", "DIEMDANH", "DANGKYKHAUPHANAN", "CONGNO"};
//    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<>(s1);
    
    static ArrayList<DBA_AUDIT_POLICIES> dap = FGAAuditTrail_DAO.LayThongTinChinhSachFGA();

    /**
     * Creates new form FGA_GUI
     */
    public FGA_GUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        
//        cbm_objName.setModel(model);
        loadComboBoxLayTable();
                
        bangGiamSat();
        laydulieuFGA(dap);
        
        txt_quyen.setText(Login_GUI.chucvu_User);
        txt_quyen.setHorizontalAlignment(SwingConstants.CENTER);
    }

//    private FGA_GUI() {
//    }
    public void bangGiamSat() {
        tblTitle.add("Object_schema");
        tblTitle.add("Object_name");
        tblTitle.add("Policy_owner");
        tblTitle.add("Policy_name");
        tblTitle.add("Policy_type");
        tblTitle.add("Policy_column");  
        tblTitle.add("SEL");
        tblTitle.add("INS");
        tblTitle.add("UPD");
        tblTitle.add("DEL");
    }
    public void laydulieuFGA(ArrayList<DBA_AUDIT_POLICIES> dap) {
        tblData.removeAllElements();
        for (DBA_AUDIT_POLICIES b : dap) {
            Vector v = new Vector();
            v.add(b.getOBJECT_SCHEMA());
            v.add(b.getOBJECT_NAME());
            v.add(b.getPOLICY_OWNER());
            v.add(b.getPOLICY_NAME());
            v.add(b.getPOLICY_TEXT());
            v.add(b.getPOLICY_COLUMN());
            v.add(b.getSEL());
            v.add(b.getINS());
            v.add(b.getUPD());
            v.add(b.getDEL());
            tblData.add(v);
        }
        tb_FGANhanVien.setModel(new DefaultTableModel(tblData, tblTitle));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_policyName = new javax.swing.JTextField();
        cbm_objName = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btn_xayDungChinhSach = new javax.swing.JButton();
        btn_xoaChinhSach = new javax.swing.JButton();
        btn_troVe = new javax.swing.JButton();
        btn_taiLai = new javax.swing.JButton();
        rdb_select = new javax.swing.JRadioButton();
        rdb_update = new javax.swing.JRadioButton();
        rdb_delete = new javax.swing.JRadioButton();
        rdb_insert = new javax.swing.JRadioButton();
        txt_quyen = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        cbo_cotTable = new javax.swing.JComboBox<>();
        txt_nguoidung = new javax.swing.JLabel();
        txt_audit_condition = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_FGANhanVien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Tên bảng :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Tên chính sách :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Giám sát trên cột:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Hành động cần ghi lại:");

        btn_xayDungChinhSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_xayDungChinhSach.setText("Xây dựng chính sách");
        btn_xayDungChinhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xayDungChinhSachActionPerformed(evt);
            }
        });

        btn_xoaChinhSach.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_xoaChinhSach.setText("Xóa chính sách");
        btn_xoaChinhSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_xoaChinhSachActionPerformed(evt);
            }
        });

        btn_troVe.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_troVe.setText("Trở về");
        btn_troVe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_troVeActionPerformed(evt);
            }
        });

        btn_taiLai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_taiLai.setText("Tải lại");
        btn_taiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLaiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdb_select);
        rdb_select.setText("Xem");

        buttonGroup1.add(rdb_update);
        rdb_update.setText("Sửa");

        buttonGroup1.add(rdb_delete);
        rdb_delete.setText("Xóa");

        buttonGroup1.add(rdb_insert);
        rdb_insert.setText("Thêm");

        txt_quyen.setEditable(false);
        txt_quyen.setBackground(new java.awt.Color(255, 255, 255));
        txt_quyen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_quyen.setEnabled(false);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("Bảng ghi chi tiết");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txt_nguoidung.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nguoidung.setText("Người dùng bị giám sát:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_taiLai)
                        .addGap(18, 18, 18)
                        .addComponent(btn_troVe))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1)
                            .addComponent(txt_nguoidung))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rdb_select, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rdb_update, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rdb_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rdb_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(78, 78, 78))
                            .addComponent(txt_policyName)
                            .addComponent(cbm_objName, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbo_cotTable, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_audit_condition))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(213, 213, 213)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_quyen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btn_xayDungChinhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_xoaChinhSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(225, 225, 225)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbm_objName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_policyName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbo_cotTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nguoidung)
                            .addComponent(txt_audit_condition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rdb_select)
                            .addComponent(rdb_insert)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdb_update)
                            .addComponent(rdb_delete)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txt_quyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_xayDungChinhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn_xoaChinhSach, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_troVe)
                    .addComponent(btn_taiLai))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Các chính sách đã được tạo"));

        tb_FGANhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_fga(evt);
            }
        });
        jScrollPane1.setViewportView(tb_FGANhanVien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 889, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    
    public void loadComboBoxLayTable() {
        ArrayList<Table_POJO> dsdt = FGAAuditTrail_DAO.LayTable();
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (Table_POJO dt : dsdt) {
            model.addElement(dt.getTABLE_NAME());
        }
        cbm_objName.setModel(model);
        cbm_objName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBox cb = (JComboBox) evt.getSource();
                tenTable = (String) cb.getSelectedItem();
                loadComboBoxCotTable(tenTable);
            }
        });
    }
    public void loadComboBoxCotTable(String tenTable) {
        ArrayList<ColumnNameTable_POJO> dsc = FGAAuditTrail_DAO.LayCotTheoTable(tenTable);
        DefaultComboBoxModel model = new DefaultComboBoxModel();
        for (ColumnNameTable_POJO dt : dsc) {
            model.addElement(dt.getColumn_Name());
        }
        cbo_cotTable.setModel(model);
        cbo_cotTable.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JComboBox cb = (JComboBox) evt.getSource();
            }
        });
    }
    private void btn_troVeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_troVeActionPerformed
        // TODO add your handling code here:
        Managanent_GUI qlnv = new Managanent_GUI();
        qlnv.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_troVeActionPerformed

    private void btn_taiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLaiActionPerformed
        // TODO add your handling code here:
        FGAAuditTrail_DAO.LayThongTinChinhSachFGA();
        dap = FGAAuditTrail_DAO.LayThongTinChinhSachFGA(); // Cập nhật danh sách dsnv
        laydulieuFGA(dap);
    }//GEN-LAST:event_btn_taiLaiActionPerformed

    private void btn_xayDungChinhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xayDungChinhSachActionPerformed
        // TODO add your handling code here:
        String object_name = cbm_objName.getSelectedItem().toString();
        String policy_name = txt_policyName.getText().trim();
        String audit_column = cbo_cotTable.getSelectedItem().toString();
        String audit_condition = txt_audit_condition.getText().trim();
        String statementType = "";

        if (rdb_select.isSelected()) {
            statementType = "SELECT";
        } else if (rdb_insert.isSelected()) {
            statementType = "INSERT";
        } else if (rdb_update.isSelected()) {
            statementType = "UPDATE";
        } else if (rdb_delete.isSelected()) {
            statementType = "DELETE";
        }

        if (!statementType.isEmpty()) {
            String sql = String.format("{CALL NV001.ADD_FGA_POLICY('NV001', '%s', '%s', '%s', '%s', '%s')}", object_name, policy_name, audit_column, statementType, audit_condition);

            if (FGAAuditTrail_DAO.ThucHienChucNang(sql) > 0) {
                JOptionPane.showMessageDialog(rootPane, "Thành công");
            }
        }
    }//GEN-LAST:event_btn_xayDungChinhSachActionPerformed

    private void btn_xoaChinhSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_xoaChinhSachActionPerformed
        // TODO add your handling code here:
        String object_name = cbm_objName.getSelectedItem().toString();
        String policy_name = txt_policyName.getText().trim();
        
        String sql = "{CALL NV001.DROP_FGA_POLICY('NV001', '"+object_name+"', '"+policy_name+"')}";         
        if(FGAAuditTrail_DAO.ThucHienChucNang(sql) > 0 ){    
            JOptionPane.showMessageDialog(rootPane, "Thành công");
        }
    }//GEN-LAST:event_btn_xoaChinhSachActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        BangGhiNhanVienFGA_GUI bgNV = new BangGhiNhanVienFGA_GUI();
        bgNV.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tb_fga(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_fga
        // TODO add your handling code here:
        int i = tb_FGANhanVien.getSelectedRow();
        String tenbang = tb_FGANhanVien.getValueAt(i, 1).toString();
        String tenchinhsach = tb_FGANhanVien.getValueAt(i, 3).toString().trim();

        cbm_objName.setSelectedItem(tenbang);
        txt_policyName.setText(tenchinhsach);
    }//GEN-LAST:event_tb_fga

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
            java.util.logging.Logger.getLogger(FGA_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FGA_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FGA_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FGA_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FGA_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_taiLai;
    private javax.swing.JButton btn_troVe;
    private javax.swing.JButton btn_xayDungChinhSach;
    private javax.swing.JButton btn_xoaChinhSach;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbm_objName;
    private javax.swing.JComboBox<String> cbo_cotTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdb_delete;
    private javax.swing.JRadioButton rdb_insert;
    private javax.swing.JRadioButton rdb_select;
    private javax.swing.JRadioButton rdb_update;
    private javax.swing.JTable tb_FGANhanVien;
    private javax.swing.JTextField txt_audit_condition;
    private javax.swing.JLabel txt_nguoidung;
    private javax.swing.JTextField txt_policyName;
    private javax.swing.JTextField txt_quyen;
    // End of variables declaration//GEN-END:variables
}
