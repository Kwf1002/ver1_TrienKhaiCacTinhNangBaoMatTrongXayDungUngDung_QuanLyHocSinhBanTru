/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import DAO.NhanVien_DAO;
import POJO.DBA_ROLE_PRIVS;
import POJO.NhanVien_POJO;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Admin
 */
public class PhanNhomQuyen_GUI extends javax.swing.JFrame {
    Vector tblData = new Vector();
    Vector tblTitle = new Vector();
    Vector tblData2 = new Vector();
    Vector tblTitle2 = new Vector();
    
    DefaultTableModel tblModel;
    DefaultTableModel tblModel2;
    
    static ArrayList<DBA_ROLE_PRIVS> dsg = NhanVien_DAO.LayThongTinQuyen();
    static ArrayList<NhanVien_POJO> dsnv = NhanVien_DAO.LayThongTinNhanVien();
    private String layQuyenNV;

    /**
     * Creates new form frm_PhanNhomQuyen
     */
    public PhanNhomQuyen_GUI() {
        initComponents();
        this.setLocationRelativeTo(null);
        setTitle("Decentralization");
        
        bangNhanVien();
        laydulieuNV(dsnv);
        
        bangQuyenNhanVien();
        laydulieuQuyenNV(dsg);
        
        txt_quyen.setText(Login_GUI.chucvu_User);
        txt_quyen.setHorizontalAlignment(SwingConstants.CENTER);
    }

//    private PhanNhomQuyen_GUI() {
//    }
    public void bangNhanVien() {
        tblTitle.add("MANV");
        tblTitle.add("TENNV");
        tblTitle.add("GIOITINH");
        tblTitle.add("NGAYSINH");
        tblTitle.add("CHUCVU");
        tblTitle.add("DIACHI");
        tblTitle.add("EMAIL");
        tblTitle.add("SODT");
        tblTitle.add("TRINHDO");
        tblTitle.add("CHUYENMON");
        tblTitle.add("NOIDAOTAO");
        tblTitle.add("NAMTOTNGHIEP");
        tblTitle.add("HINHANH");
    }
    public void laydulieuNV(ArrayList<NhanVien_POJO> dsnv) {
        tblData.removeAllElements();
        for (NhanVien_POJO b : dsnv) {
            Vector v = new Vector();
            v.add(b.getMANV());
            v.add(b.getTENNV());
            v.add(b.getGIOITINH());
            v.add(b.getNGAYSINH());
            v.add(b.getCHUCVU());
            v.add(b.getDIACHI());
            v.add(b.getEMAIL());
            v.add(b.getSODT());
            v.add(b.getTRINHDO());
            v.add(b.getCHUYENMON());
            v.add(b.getNOIDAOTAO());
            v.add(b.getNAMTOTNGHIEP());
            v.add(b.getHINHANH());
            tblData.add(v);
        }
        tb_nhanVien.setModel(new DefaultTableModel(tblData, tblTitle));
    }
    public void bangQuyenNhanVien() {
        tblTitle2.add("GRANTEE");
        tblTitle2.add("GRANTED_ROLE");
        tblTitle2.add("ADMIN_OPTION");
        tblTitle2.add("DELEGATE_OPTION");
        tblTitle2.add("DEFAULT_ROLE");
        tblTitle2.add("COMMON");
    }
    public void laydulieuQuyenNV(ArrayList<DBA_ROLE_PRIVS> dsg) {
        tblData2.removeAllElements();
        for (DBA_ROLE_PRIVS b : dsg) {
            Vector v = new Vector();
            v.add(b.getGRANTEE());
            v.add(b.getGRANTED_ROLE());
            v.add(b.getADMIN_OPTION());
            v.add(b.getDELEGATE_OPTION());
            v.add(b.getDEFAULT_ROLE());
            v.add(b.getCOMMON());
            tblData2.add(v);
        }
        tb_quyen.setModel(new DefaultTableModel(tblData2, tblTitle2));
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        btnTroLai = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_quyen = new javax.swing.JTable();
        txt_username = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        btn_thuHoi = new javax.swing.JButton();
        btn_capQuyen = new javax.swing.JButton();
        rda_nhanvienthungan = new javax.swing.JRadioButton();
        rda_quantrihethong = new javax.swing.JRadioButton();
        rda_giaovien = new javax.swing.JRadioButton();
        rda_quanly = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btn_taiLai = new javax.swing.JButton();
        txt_quyen = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb_nhanVien = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setText("Phân Nhóm Quyền Trong Nghiệp Vụ");

        btnTroLai.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnTroLai.setText("Trở lại");
        btnTroLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTroLaiActionPerformed(evt);
            }
        });

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Quyền", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14))); // NOI18N

        jScrollPane1.setViewportView(tb_quyen);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 869, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Role", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 2, 14))); // NOI18N

        btn_thuHoi.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_thuHoi.setText("Thu Hồi");
        btn_thuHoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_thuHoiActionPerformed(evt);
            }
        });

        btn_capQuyen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_capQuyen.setText("Cấp Quyền");
        btn_capQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_capQuyenActionPerformed(evt);
            }
        });

        rda_nhanvienthungan.setText("Role Nhân Viên Thu Ngân");

        rda_quantrihethong.setText("Role Quản Trị Hệ Thống");

        rda_giaovien.setText("Role Giáo Viên");

        rda_quanly.setText("Role Quản Lý");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rda_giaovien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rda_quanly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_capQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(rda_quantrihethong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(rda_nhanvienthungan, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btn_thuHoi, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(rda_quanly)
                .addGap(18, 18, 18)
                .addComponent(rda_giaovien)
                .addGap(20, 20, 20)
                .addComponent(rda_nhanvienthungan)
                .addGap(20, 20, 20)
                .addComponent(rda_quantrihethong)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btn_capQuyen)
                .addGap(18, 18, 18)
                .addComponent(btn_thuHoi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("User Name:");

        btn_taiLai.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_taiLai.setText("Tải lại");
        btn_taiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_taiLaiActionPerformed(evt);
            }
        });

        txt_quyen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_quyen.setEnabled(false);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin Nhân Viên"));

        tb_nhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_nhanVienMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tb_nhanVien);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
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
                        .addComponent(btnTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(308, 308, 308)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_quyen, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(81, 81, 81)
                                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btn_taiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTroLai, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_quyen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(10, 10, 10)
                        .addComponent(btn_taiLai)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTroLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTroLaiActionPerformed
        //Managanent_GUI qlnv = new frm_QLNhanVien(layQuyenNV);
        Managanent_GUI qlnv = new Managanent_GUI();
        qlnv.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnTroLaiActionPerformed

    private void btn_thuHoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_thuHoiActionPerformed
        // TODO add your handling code here:      
        String manv = txt_username.getText().trim();
        if (rda_quantrihethong.isSelected() || rda_nhanvienthungan.isSelected() || rda_quanly.isSelected() || rda_giaovien.isSelected()) {
            String role = "";
            if (rda_quantrihethong.isSelected()) {
                role = "QT";
            } else if (rda_nhanvienthungan.isSelected()) {
                role = "TN";
            } else if (rda_quanly.isSelected()) {
                role = "QL";
            } else if (rda_giaovien.isSelected()) {
                role = "GV";
            }
            String sql = "{CALL NV001.THNQ('" + role + "','" + manv + "')}";
            int result = NhanVien_DAO.ThemXoaSuaNhanVien(sql);
            if (result == 1) {
                JOptionPane.showMessageDialog(this, "Thu hồi quyền thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                System.out.println("Lỗi khi thực hiện: " + result);
            }
        }
    }//GEN-LAST:event_btn_thuHoiActionPerformed

    private void tb_nhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_nhanVienMouseClicked
        // TODO add your handling code here:
        int i = tb_nhanVien.getSelectedRow();
        String manv = tb_nhanVien.getValueAt(i, 0).toString().trim();
        txt_username.setText(manv);
    }//GEN-LAST:event_tb_nhanVienMouseClicked

    private void btn_capQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_capQuyenActionPerformed
        // TODO add your handling code here:
        String manv = txt_username.getText().trim();
    
        if (rda_quantrihethong.isSelected() || rda_nhanvienthungan.isSelected() || rda_quanly.isSelected() || rda_giaovien.isSelected()) {
            String role = "";
            if (rda_quantrihethong.isSelected()) {
                role = "QT";
            } else if (rda_nhanvienthungan.isSelected()) {
                role = "TN";
            } else if (rda_quanly.isSelected()) {
                role = "QL";
            } else if (rda_giaovien.isSelected()) {
                role = "GV";
            }

            String sql = "{CALL NV001.CNQ('" + role + "','" + manv + "')}";
            if (NhanVien_DAO.ThemXoaSuaNhanVien(sql) == 1) {
                //JOptionPane.showMessageDialog(this, "Thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(this, "Cấp quyền cho user thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }
            
        }
    }//GEN-LAST:event_btn_capQuyenActionPerformed

    private void btn_taiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_taiLaiActionPerformed
        // TODO add your handling code here:
            NhanVien_DAO.LayThongTinNhanVien();
            dsnv = NhanVien_DAO.LayThongTinNhanVien();
            laydulieuNV(dsnv);
            
            NhanVien_DAO.LayThongTinQuyen();
            dsg = NhanVien_DAO.LayThongTinQuyen();
            laydulieuQuyenNV(dsg);
    }//GEN-LAST:event_btn_taiLaiActionPerformed

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
            java.util.logging.Logger.getLogger(PhanNhomQuyen_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhanNhomQuyen_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhanNhomQuyen_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhanNhomQuyen_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhanNhomQuyen_GUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTroLai;
    private javax.swing.JButton btn_capQuyen;
    private javax.swing.JButton btn_taiLai;
    private javax.swing.JButton btn_thuHoi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JRadioButton rda_giaovien;
    private javax.swing.JRadioButton rda_nhanvienthungan;
    private javax.swing.JRadioButton rda_quanly;
    private javax.swing.JRadioButton rda_quantrihethong;
    private javax.swing.JTable tb_nhanVien;
    private javax.swing.JTable tb_quyen;
    private javax.swing.JTextField txt_quyen;
    private javax.swing.JTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
