/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package JFrameQuanLyKyTucXa;

import Connector.KetNoiSQL;
import dao.QuanLyNhanVienDAO;
import dao.SinhVienDAO;
import dao.SinhVienDangKyDAO;
import dao.TaiKhoanDAO;
import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ThongTinNhanVien;
import model.ThongTinSinhVien;
import model.ThongTinSinhVienDangKy;
import model.ThongTinTaiKhoan;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;
import textfield.SearchOptinEvent;
import textfield.SearchOption;

/**
 *
 * @author PhanTien
 */
public class PhanQuyenNguoiDung extends javax.swing.JPanel {

    /**
     * Creates new form PhanQuyenNguoiDung
     */
    private String selectedEmail, selectedPhanQuyen;
    private String selectedEmailDelete;
    private DefaultTableModel Model;
    private List<ThongTinTaiKhoan> listtk;
    private List<ThongTinSinhVien> listsinhvien;
    private List<ThongTinSinhVienDangKy> listsinhviendk;
    private List<ThongTinNhanVien> listnhanvien;
    private int count;

    public PhanQuyenNguoiDung() {
        initComponents();
        this.AddComboBox();
        this.AddComboBoxDelete();
        this.ViewComboBox();

        //Tìm kiếm combobox 
        AutoCompleteDecorator.decorate(ComboBoxAdd);
        AutoCompleteDecorator.decorate(ComboBoxView);
        AutoCompleteDecorator.decorate(ComboBoxDelete);

        Model = (DefaultTableModel) tableTK.getModel();
        tableTK.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        tableTK.getTableHeader().setOpaque(false);
        tableTK.getTableHeader().setBackground(new Color(19, 90, 118));
        tableTK.getTableHeader().setForeground(new Color(225, 225, 225));
        AddSearch();

        // 
        showTableTK("tenDangNhap", "");
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
        jLabel51 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ComboBoxAdd = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        ComboBoxPhanQuyen = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        ComboBoxView = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        txtViewQuyen = new javax.swing.JLabel();
        txtViewQuyenTaiKhoan = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        ComboBoxDelete = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        ScrollPaneSV = new javax.swing.JScrollPane();
        tableTK = new javax.swing.JTable();
        txtSearch = new textfield.TextFieldSearchOption();
        jLabel8 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1060, 550));
        setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(19, 90, 118));
        jLabel51.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel51.setText("Hệ thống quản lý ký túc xá sinh viên");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(237, 50, 55));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Quản lý phân quyền người dùng");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(11, 36, 71));
        jLabel1.setText("Cấp quyền cho tài khoản :");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(11, 36, 71));
        jLabel2.setText("Email tài khoản :");

        ComboBoxAdd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBoxAdd.setForeground(new java.awt.Color(11, 36, 71));
        ComboBoxAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxAddMouseClicked(evt);
            }
        });
        ComboBoxAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxAddActionPerformed(evt);
            }
        });
        ComboBoxAdd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ComboBoxAddKeyReleased(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(11, 36, 71));
        jLabel3.setText("Tên quyền :");

        ComboBoxPhanQuyen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBoxPhanQuyen.setForeground(new java.awt.Color(11, 36, 71));
        ComboBoxPhanQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản Lý", "Nhân Viên" }));
        ComboBoxPhanQuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxPhanQuyenMouseClicked(evt);
            }
        });
        ComboBoxPhanQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxPhanQuyenActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(11, 36, 71));
        jButton1.setText("Cấp quyền");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(11, 36, 71));
        jLabel4.setText("Xem quyền theo tài khoản :");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(11, 36, 71));
        jLabel5.setText("Email tài khoản :");

        ComboBoxView.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBoxView.setForeground(new java.awt.Color(11, 36, 71));
        ComboBoxView.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxViewMouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(11, 36, 71));
        jButton2.setText("Xem quyền");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        txtViewQuyen.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtViewQuyen.setForeground(new java.awt.Color(158, 22, 20));
        txtViewQuyen.setText("Phân quyền :");

        txtViewQuyenTaiKhoan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txtViewQuyenTaiKhoan.setForeground(new java.awt.Color(158, 22, 20));
        txtViewQuyenTaiKhoan.setText("Tài khoản :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(11, 36, 71));
        jLabel6.setText("Xóa phân quyền tài khoản :");

        ComboBoxDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBoxDelete.setForeground(new java.awt.Color(11, 36, 71));
        ComboBoxDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ComboBoxDeleteMouseClicked(evt);
            }
        });
        ComboBoxDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxDeleteActionPerformed(evt);
            }
        });
        ComboBoxDelete.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                ComboBoxDeleteKeyReleased(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setForeground(new java.awt.Color(11, 36, 71));
        jButton3.setText("Xóa quyền");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(11, 36, 71));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pencil_table.png"))); // NOI18N
        jLabel7.setText("Danh sách tài khoản");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ComboBoxPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ComboBoxView, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtViewQuyenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtViewQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(30, 30, 30)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(ComboBoxAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ComboBoxDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxPhanQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxView, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtViewQuyenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtViewQuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add(jPanel1, "card2");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        ScrollPaneSV.setBackground(new java.awt.Color(255, 255, 255));
        ScrollPaneSV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ScrollPaneSVMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                ScrollPaneSVMouseExited(evt);
            }
        });

        tableTK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tableTK.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã sinh viên", "Tên sinh viên", "Tên tài khoản", "Email", "Phân quyền"
            }
        ));
        tableTK.setFocusable(false);
        tableTK.setGridColor(new java.awt.Color(255, 255, 255));
        tableTK.setRowHeight(25);
        tableTK.setSelectionBackground(new java.awt.Color(19, 90, 118));
        tableTK.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tableTK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTKMouseClicked(evt);
            }
        });
        ScrollPaneSV.setViewportView(tableTK);

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back_main.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(604, 604, 604)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(ScrollPaneSV, javax.swing.GroupLayout.PREFERRED_SIZE, 975, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(ScrollPaneSV, javax.swing.GroupLayout.PREFERRED_SIZE, 392, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(jPanel2, "card3");
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        ViewQuyen((String) ComboBoxView.getSelectedItem());
    }//GEN-LAST:event_jButton2MouseClicked

    private void ComboBoxViewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxViewMouseClicked
    }//GEN-LAST:event_ComboBoxViewMouseClicked

    private void ComboBoxAddKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxAddKeyReleased
    }//GEN-LAST:event_ComboBoxAddKeyReleased

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:        
        UpdatePhanQuyen(selectedEmail);
        this.AddComboBoxDelete();
    }//GEN-LAST:event_jButton1MouseClicked

    private void ComboBoxAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxAddMouseClicked
    }//GEN-LAST:event_ComboBoxAddMouseClicked

    private void ComboBoxPhanQuyenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxPhanQuyenMouseClicked
    }//GEN-LAST:event_ComboBoxPhanQuyenMouseClicked

    private void ComboBoxAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxAddActionPerformed
        // TODO add your handling code here:
        selectedEmail = (String) ComboBoxAdd.getSelectedItem();
    }//GEN-LAST:event_ComboBoxAddActionPerformed

    private void ComboBoxPhanQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxPhanQuyenActionPerformed
        // TODO add your handling code here:
        selectedPhanQuyen = (String) ComboBoxPhanQuyen.getSelectedItem();
    }//GEN-LAST:event_ComboBoxPhanQuyenActionPerformed

    private void ComboBoxDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ComboBoxDeleteMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxDeleteMouseClicked

    private void ComboBoxDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxDeleteActionPerformed
        // TODO add your handling code here:
        selectedEmailDelete = (String) ComboBoxDelete.getSelectedItem();
    }//GEN-LAST:event_ComboBoxDeleteActionPerformed

    private void ComboBoxDeleteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComboBoxDeleteKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxDeleteKeyReleased

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        int slquanly = new TaiKhoanDAO().SoLuongQL();
        if (slquanly == 1) {
            JOptionPane.showMessageDialog(this, "Không xóa thành công. Phải có ít nhất 1 Quản Lý");
        } else {
            XoaPhanQuyen(selectedEmailDelete);
            this.AddComboBoxDelete();
        }
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tableTKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTKMouseClicked
        // TODO add your handling code here:
        count = tableTK.getSelectedRow();
    }//GEN-LAST:event_tableTKMouseClicked

    private void ScrollPaneSVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScrollPaneSVMouseClicked

    }//GEN-LAST:event_ScrollPaneSVMouseClicked

    private void ScrollPaneSVMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ScrollPaneSVMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_ScrollPaneSVMouseExited

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        // TODO add your handling code here:
        if (txtSearch.isSelected()) {
            int option = txtSearch.getSelectedIndex();
            String textsearch = txtSearch.getText().trim();
            if (option == 0) {
                showTableSV("tenDangNhap", textsearch);
            } else if (option == 1) {
                showTableTK("email", textsearch);
            } else if (option == 2) {
                showTableTK("phanQuyen", textsearch);
            }
        }
    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        jPanel1.setVisible(true);
        jPanel2.setVisible(false);
    }//GEN-LAST:event_jLabel8MouseClicked

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
        // TODO add your handling code here:
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
    }//GEN-LAST:event_jLabel7MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxAdd;
    private javax.swing.JComboBox<String> ComboBoxDelete;
    private javax.swing.JComboBox<String> ComboBoxPhanQuyen;
    private javax.swing.JComboBox<String> ComboBoxView;
    private javax.swing.JScrollPane ScrollPaneSV;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable tableTK;
    private textfield.TextFieldSearchOption txtSearch;
    private javax.swing.JLabel txtViewQuyen;
    private javax.swing.JLabel txtViewQuyenTaiKhoan;
    // End of variables declaration//GEN-END:variables

    private void showTableTK(String where, String text) {
        listtk = new TaiKhoanDAO().getAllThongTinTKSearch(where, text);
        Model.setRowCount(0);
        for (ThongTinTaiKhoan tk : listtk) {
            boolean kiemtra = new SinhVienDAO().KiemTraEmailSV(tk.getEmail());
            boolean kiemtra2 = new SinhVienDangKyDAO().KiemTraEmailSV(tk.getEmail());
            if (kiemtra) {
                ThongTinSinhVien sv = new SinhVienDAO().getAllThongTinSVTheoemail(tk.getEmail());
                Model.addRow(new Object[]{
                    sv.getMaSV(), sv.getTenSV(), tk.getTenDangNhap(), tk.getEmail(), tk.getPhanQuyen()
                });
            } else if (kiemtra2) {
                ThongTinSinhVienDangKy sv = new SinhVienDangKyDAO().getAllThongTinSVTheoemail(tk.getEmail());
                Model.addRow(new Object[]{
                    sv.getMaSV(), sv.getTenSV(), tk.getTenDangNhap(), tk.getEmail(), tk.getPhanQuyen()
                });
            } else {
                ThongTinNhanVien sv = new QuanLyNhanVienDAO().getAllThongTinNVTheoemail(tk.getEmail());
                Model.addRow(new Object[]{
                    sv.getMaNV(), sv.getTenNV(), tk.getTenDangNhap(), tk.getEmail(), tk.getPhanQuyen()
                });

            }
        }
    }

    private void showTableSV(String where, String text) {
        listsinhvien = new SinhVienDAO().getAllThongTinSVSearch(where, text);
        Model.setRowCount(0);
        for (ThongTinSinhVien sv : listsinhvien) {
            ThongTinTaiKhoan tk = new TaiKhoanDAO().getAllThongTinTKEmail(sv.getEmail());
            Model.addRow(new Object[]{
                sv.getMaSV(), sv.getTenSV(), tk.getTenDangNhap(), tk.getEmail(), tk.getPhanQuyen()
            });
        }
        listsinhviendk = new SinhVienDangKyDAO().getAllThongTinSVSearch(where, text);
        for (ThongTinSinhVienDangKy sv : listsinhviendk) {
            ThongTinTaiKhoan tk = new TaiKhoanDAO().getAllThongTinTKEmail(sv.getEmail());
            Model.addRow(new Object[]{
                sv.getMaSV(), sv.getTenSV(), tk.getTenDangNhap(), tk.getEmail(), tk.getPhanQuyen()
            });
        }
        listnhanvien = new QuanLyNhanVienDAO().getAllThongTinNVSearch(where, text);
        for (ThongTinNhanVien sv : listnhanvien) {
            ThongTinTaiKhoan tk = new TaiKhoanDAO().getAllThongTinTKEmail(sv.getEmail());
            Model.addRow(new Object[]{
                sv.getMaNV(), sv.getTenNV(), tk.getTenDangNhap(), tk.getEmail(), tk.getPhanQuyen()
            });
        }
    }

    void AddComboBox() {
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtintaikhoan";
        ComboBoxAdd.removeAllItems();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                if (!rs.getString("phanQuyen").equals("Sinh Viên")) {
                    this.ComboBoxAdd.addItem(rs.getString("email"));
                }
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(QuanLySV.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void ViewComboBox() {
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtintaikhoan";
        ComboBoxView.removeAllItems();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.ComboBoxView.addItem(rs.getString("email"));
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(QuanLySV.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void AddComboBoxDelete() {
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtintaikhoan where phanQuyen='Quản Lý'";
        ComboBoxDelete.removeAllItems();
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.ComboBoxDelete.addItem(rs.getString("email"));
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(QuanLySV.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void ViewQuyen(String email) {
        Connection conn = KetNoiSQL.getConnection();
        String sql = "select * from thongtintaikhoan where email='" + email + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                txtViewQuyenTaiKhoan.setText("Tài khoản : " + email);
                txtViewQuyen.setText("Phân quyền : " + rs.getString("phanQuyen"));
            }
            conn.close();

        } catch (SQLException ex) {
            Logger.getLogger(QuanLySV.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    void UpdatePhanQuyen(String text) {
        Connection conn = KetNoiSQL.getConnection();
        int row = 0;
        String sql = "update thongtintaikhoan set phanQuyen=? where email=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, selectedPhanQuyen);
            ps.setString(2, text);

            row = ps.executeUpdate();
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Nhap ma chua dung");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void XoaPhanQuyen(String text) {
        Connection conn = KetNoiSQL.getConnection();
        int row = 0;
        String sql = "update thongtintaikhoan set phanQuyen=? where email=?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "USER");
            ps.setString(2, text);

            row = ps.executeUpdate();
            if (row > 0) {
                JOptionPane.showMessageDialog(this, "Cập nhật tài khoản thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Nhap ma chua dung");
            }
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    void AddSearch() {
        txtSearch.addEventOptionSelected(new SearchOptinEvent() {
            @Override
            public void optionSelected(SearchOption option, int index) {
                txtSearch.setHint("Tìm kiếm " + option.getName() + "....");
            }
        });
        txtSearch.addOption(new SearchOption("tên đăng nhập", new ImageIcon(getClass().getResource("/img/user.png"))));
        txtSearch.addOption(new SearchOption("email", new ImageIcon(getClass().getResource("/img/email.png"))));
        txtSearch.addOption(new SearchOption("phân quyền", new ImageIcon(getClass().getResource("/img/pencil.png"))));
    }
}
