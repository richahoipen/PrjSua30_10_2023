package gui_Panel;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import customEntities.CustomIcon;
import customEntities.Custom_Button;
import gui_Dialog.Message;
import gui_Frame_Running.Frame_Chinh;



public class Panel_Setting extends javax.swing.JPanel {
	private JPanel pnNguoiDung;
	private JLabel lblAvatar,lblChucVu,lblHoTen,lbl_Title_NguoiDung;
	private Custom_Button btnDangXuat;
	private JPanel pnCaiDatNgonNgu;
	private JLabel lbl_Title_CaiDatNgonNgu;
	private JPanel pnCaiDatGiaoDien;
	private JLabel lbl_Title_CaiDatGiaoDien_1;
	private JRadioButton rdbtnTiengViet,rdbtnTiengAnh,rdbtnTrangSang,rdbtnCheDoToi,rdbtnTuoiTre;
	
	private JLabel lblLWhiteBright;
	private JLabel lblDark;
	private JLabel lblYoung;
	private ButtonGroup btngNgonNgu;
	private ButtonGroup btngPhongCach;
    // End of variables declaration//GEN-END:variables
    public Panel_Setting() {
        initComponents();
        setOpaque(false);
        
        pnNguoiDung = new JPanel();
        pnNguoiDung.setBorder(new LineBorder(new Color(0, 0, 0)));
        pnNguoiDung.setBackground(new Color(255, 255, 255));
        
        pnCaiDatNgonNgu = new JPanel();
        pnCaiDatNgonNgu.setBorder(new LineBorder(new Color(0, 0, 0)));
        pnCaiDatNgonNgu.setBackground(new Color(255, 255, 255));
        
        pnCaiDatGiaoDien = new JPanel();
        pnCaiDatGiaoDien.setBorder(new LineBorder(new Color(0, 0, 0)));
        pnCaiDatGiaoDien.setBackground(Color.WHITE);
        
        lbl_Title_CaiDatGiaoDien_1 = new JLabel("Cài đặt giao diện");
        lbl_Title_CaiDatGiaoDien_1.setVerticalAlignment(SwingConstants.TOP);
        lbl_Title_CaiDatGiaoDien_1.setForeground(SystemColor.activeCaption);
        lbl_Title_CaiDatGiaoDien_1.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        rdbtnTrangSang = new JRadioButton("Trắng sáng");
        rdbtnTrangSang.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        rdbtnCheDoToi = new JRadioButton("Chế độ tối");
        rdbtnCheDoToi.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        rdbtnTuoiTre = new JRadioButton("Tươi trẻ");
        rdbtnTuoiTre.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        lblLWhiteBright = new JLabel();
        lblLWhiteBright.setIcon(new CustomIcon("src/main/images/view_image/WhiteBright.png",105,68));
        lblDark = new JLabel();
        lblDark.setIcon(new CustomIcon("src/main/images/view_image/Dark.png",105,68));
        lblYoung = new JLabel();
        lblYoung.setIcon(new CustomIcon("src/main/images/view_image/Young.png",105,68));
        GroupLayout gl_pnCaiDatGiaoDien = new GroupLayout(pnCaiDatGiaoDien);
        gl_pnCaiDatGiaoDien.setHorizontalGroup(
        	gl_pnCaiDatGiaoDien.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnCaiDatGiaoDien.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pnCaiDatGiaoDien.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(gl_pnCaiDatGiaoDien.createSequentialGroup()
        					.addGroup(gl_pnCaiDatGiaoDien.createParallelGroup(Alignment.LEADING)
        						.addComponent(rdbtnTrangSang)
        						.addComponent(lblLWhiteBright, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(gl_pnCaiDatGiaoDien.createParallelGroup(Alignment.LEADING)
        						.addComponent(rdbtnCheDoToi, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblDark, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_pnCaiDatGiaoDien.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblYoung, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        						.addComponent(rdbtnTuoiTre, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(lbl_Title_CaiDatGiaoDien_1, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
        			.addGap(322))
        );
        gl_pnCaiDatGiaoDien.setVerticalGroup(
        	gl_pnCaiDatGiaoDien.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnCaiDatGiaoDien.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lbl_Title_CaiDatGiaoDien_1, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pnCaiDatGiaoDien.createParallelGroup(Alignment.TRAILING, false)
        				.addGroup(Alignment.LEADING, gl_pnCaiDatGiaoDien.createSequentialGroup()
        					.addComponent(rdbtnTuoiTre, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblYoung, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addGroup(Alignment.LEADING, gl_pnCaiDatGiaoDien.createSequentialGroup()
        					.addComponent(rdbtnCheDoToi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblDark, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addGroup(gl_pnCaiDatGiaoDien.createSequentialGroup()
        					.addComponent(rdbtnTrangSang)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblLWhiteBright, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
        			.addGap(11))
        );
        gl_pnCaiDatGiaoDien.linkSize(SwingConstants.VERTICAL, new Component[] {rdbtnTrangSang, rdbtnCheDoToi, rdbtnTuoiTre});
        gl_pnCaiDatGiaoDien.linkSize(SwingConstants.HORIZONTAL, new Component[] {rdbtnTrangSang, rdbtnCheDoToi, rdbtnTuoiTre, lblLWhiteBright, lblDark, lblYoung});
        pnCaiDatGiaoDien.setLayout(gl_pnCaiDatGiaoDien);
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(pnCaiDatGiaoDien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(pnCaiDatNgonNgu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE)
        				.addComponent(pnNguoiDung, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 653, Short.MAX_VALUE))
        			.addContainerGap())
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(pnNguoiDung, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(pnCaiDatNgonNgu, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(pnCaiDatGiaoDien, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
        			.addGap(14))
        );
        
        lbl_Title_CaiDatNgonNgu = new JLabel("Cài đặt ngôn ngữ:");
        lbl_Title_CaiDatNgonNgu.setVerticalAlignment(SwingConstants.TOP);
        lbl_Title_CaiDatNgonNgu.setForeground(SystemColor.activeCaption);
        lbl_Title_CaiDatNgonNgu.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        rdbtnTiengViet = new JRadioButton("Tiếng Việt");
        rdbtnTiengViet.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        rdbtnTiengAnh = new JRadioButton("Tiếng Anh");
        rdbtnTiengAnh.setFont(new Font("SansSerif", Font.PLAIN, 14));
        btngNgonNgu = new ButtonGroup();
        btngNgonNgu.add(rdbtnTiengViet);
        btngNgonNgu.add(rdbtnTiengAnh)
        ;
        btngPhongCach = new ButtonGroup();
        btngPhongCach.add(rdbtnTrangSang);
        btngPhongCach.add(rdbtnCheDoToi);
        btngPhongCach.add(rdbtnTuoiTre);
        
        pnCaiDatNgonNgu.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        pnCaiDatNgonNgu.add(lbl_Title_CaiDatNgonNgu);
        pnCaiDatNgonNgu.add(rdbtnTiengViet);
        pnCaiDatNgonNgu.add(rdbtnTiengAnh);
        
        lblAvatar = new JLabel();
        lblAvatar.setIcon(new CustomIcon("src/main/images/view_image/Employee.png"));
        
        lblChucVu = new JLabel("Người quản lý");
        lblChucVu.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        lblHoTen = new JLabel("Lương Quốc Thái");
        lblHoTen.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        btnDangXuat = new Custom_Button();
        btnDangXuat.setText("Đăng xuất");
        btnDangXuat.setIcon(new CustomIcon("src/main/images/view_image/Logout.png",18,18));

        
        lbl_Title_NguoiDung = new JLabel("Người dùng");
        lbl_Title_NguoiDung.setVerticalAlignment(SwingConstants.TOP);
        lbl_Title_NguoiDung.setForeground(SystemColor.activeCaption);
        lbl_Title_NguoiDung.setFont(new Font("SansSerif", Font.BOLD, 12));
        GroupLayout gl_pnNguoiDung = new GroupLayout(pnNguoiDung);
        gl_pnNguoiDung.setHorizontalGroup(
        	gl_pnNguoiDung.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnNguoiDung.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pnNguoiDung.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lblAvatar, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(lbl_Title_NguoiDung, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pnNguoiDung.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pnNguoiDung.createParallelGroup(Alignment.TRAILING)
        					.addComponent(btnDangXuat, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lblHoTen, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
        				.addComponent(lblChucVu))
        			.addContainerGap(457, Short.MAX_VALUE))
        );
        gl_pnNguoiDung.setVerticalGroup(
        	gl_pnNguoiDung.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_pnNguoiDung.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(lbl_Title_NguoiDung, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pnNguoiDung.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pnNguoiDung.createSequentialGroup()
        					.addComponent(lblChucVu)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblHoTen, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnDangXuat, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        				.addComponent(lblAvatar, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE))
        			.addGap(11))
        );
        pnNguoiDung.setLayout(gl_pnNguoiDung);
        setLayout(groupLayout);
    }



    private void showMessage(String message) {
        Message obj = new Message(Frame_Chinh.getFrames()[0], true);
        obj.showMessage(message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        
    }// </editor-fold>//GEN-END:initComponents
}

