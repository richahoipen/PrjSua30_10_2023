package gui_Panel_Setting;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import com.raven.model.ModelMenu;
import com.raven.model.SettingModel;

import customEntities.CustomIcon;
import customEntities.Custom_Button;
import dataBase_BUS.NhanVien_BUS;
import gui_DangNhap.Frame_DangNhap;
import gui_Dialog.Message;
import gui_Frame_Running.Frame_Chinh;



public class Panel_Setting extends javax.swing.JPanel implements ActionListener{
	private JPanel pnNguoiDung;
	private JLabel lblAvatar,lblChucVu,lblHoTen,lbl_Title_NguoiDung;
	private Custom_Button btnDangXuat;
	private Custom_Button btnLuuCaiDat;
	private Custom_Button btnDoiMatKhau;
	private JPanel pnCaiDatNgonNgu;
	private JLabel lbl_Title_CaiDatNgonNgu;
	private JPanel pnCaiDatGiaoDien;
	private JLabel lbl_Title_CaiDatGiaoDien;
	private JRadioButton rdbtnTiengViet,rdbtnTiengAnh,rdbtnTrangSang,rdbtnCheDoToi;
	private JLabel lblLWhiteBright;
	private JLabel lblDark;
	private ButtonGroup btngNgonNgu;
	private ButtonGroup btngPhongCach;
	private Frame_Chinh frame_Chinh;
	private String maNV, chucVu;
	public String getChucVu() {
		return chucVu;
	}
	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}
	private SettingModel settingModel;
	//sqlNhanVien_BUS.getTenNV(maNV)
	private NhanVien_BUS sqlNhanVien_BUS=new NhanVien_BUS();
    // End of variables declaration//GEN-END:variables
    public Panel_Setting(Frame_Chinh frame,String maNV,String chucVu) {
    	//set Ten
    	setmaNV(maNV);
    	setChucVu(chucVu);
    	frame_Chinh = frame;
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
        
        lbl_Title_CaiDatGiaoDien = new JLabel();
        lbl_Title_CaiDatGiaoDien.setVerticalAlignment(SwingConstants.TOP);
        lbl_Title_CaiDatGiaoDien.setForeground(SystemColor.activeCaption);
        lbl_Title_CaiDatGiaoDien.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        rdbtnTrangSang = new JRadioButton();
        rdbtnTrangSang.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        rdbtnCheDoToi = new JRadioButton();
        rdbtnCheDoToi.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        lblLWhiteBright = new JLabel();
        lblLWhiteBright.setIcon(new CustomIcon("src/main/images/view_image/WhiteBright.png",105,68));
        lblDark = new JLabel();
        lblDark.setIcon(new CustomIcon("src/main/images/view_image/Dark.png",105,68));
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
        						.addComponent(lblDark, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(lbl_Title_CaiDatGiaoDien, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE))
        			.addGap(544))
        );
        gl_pnCaiDatGiaoDien.setVerticalGroup(
        	gl_pnCaiDatGiaoDien.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pnCaiDatGiaoDien.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lbl_Title_CaiDatGiaoDien, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pnCaiDatGiaoDien.createParallelGroup(Alignment.LEADING, false)
        				.addGroup(gl_pnCaiDatGiaoDien.createSequentialGroup()
        					.addComponent(rdbtnCheDoToi, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblDark, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        				.addGroup(gl_pnCaiDatGiaoDien.createSequentialGroup()
        					.addComponent(rdbtnTrangSang)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblLWhiteBright, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)))
        			.addGap(11))
        );
        gl_pnCaiDatGiaoDien.linkSize(SwingConstants.VERTICAL, new Component[] {rdbtnCheDoToi, rdbtnTrangSang});
        gl_pnCaiDatGiaoDien.linkSize(SwingConstants.HORIZONTAL, new Component[] {rdbtnCheDoToi, lblLWhiteBright, lblDark, rdbtnTrangSang});
        pnCaiDatGiaoDien.setLayout(gl_pnCaiDatGiaoDien);
        GroupLayout groupLayout = new GroupLayout(this);
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        				.addComponent(pnCaiDatGiaoDien, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(pnCaiDatNgonNgu, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE)
        				.addComponent(pnNguoiDung, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 665, Short.MAX_VALUE))
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
        			.addComponent(pnCaiDatGiaoDien, GroupLayout.PREFERRED_SIZE, 182, Short.MAX_VALUE)
        			.addContainerGap())
        );
        
        lbl_Title_CaiDatNgonNgu = new JLabel();
        lbl_Title_CaiDatNgonNgu.setVerticalAlignment(SwingConstants.TOP);
        lbl_Title_CaiDatNgonNgu.setForeground(SystemColor.activeCaption);
        lbl_Title_CaiDatNgonNgu.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        rdbtnTiengViet = new JRadioButton();
        rdbtnTiengViet.setText("Tiếng việt");
        rdbtnTiengViet.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        rdbtnTiengAnh = new JRadioButton("Tiếng Anh");
        rdbtnTiengAnh.setFont(new Font("SansSerif", Font.PLAIN, 14));
        rdbtnTiengAnh.addActionListener(this);
        btngNgonNgu = new ButtonGroup();
        btngNgonNgu.add(rdbtnTiengViet);
        btngNgonNgu.add(rdbtnTiengAnh)
        ;
        btngPhongCach = new ButtonGroup();
        btngPhongCach.add(rdbtnTrangSang);
        btngPhongCach.add(rdbtnCheDoToi);
        
        pnCaiDatNgonNgu.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
        pnCaiDatNgonNgu.add(lbl_Title_CaiDatNgonNgu);
        pnCaiDatNgonNgu.add(rdbtnTiengViet);
        pnCaiDatNgonNgu.add(rdbtnTiengAnh);
        
        lblAvatar = new JLabel();
        lblAvatar.setIcon(new CustomIcon("src/main/images/view_image/Employee.png"));
        
        lblChucVu = new JLabel();
        lblChucVu.setFont(new Font("SansSerif", Font.BOLD, 14));
        
        lblHoTen = new JLabel(sqlNhanVien_BUS.getTenNV(maNV));
        lblHoTen.setFont(new Font("SansSerif", Font.PLAIN, 12));
        
        btnDangXuat = new Custom_Button();
        btnDangXuat.setIcon(new CustomIcon("src/main/images/view_image/Logout.png",18,18));

        
        lbl_Title_NguoiDung = new JLabel();
        lbl_Title_NguoiDung.setVerticalAlignment(SwingConstants.TOP);
        lbl_Title_NguoiDung.setForeground(SystemColor.activeCaption);
        lbl_Title_NguoiDung.setFont(new Font("SansSerif", Font.BOLD, 12));
        
        btnDoiMatKhau = new Custom_Button();
        
        
        btnLuuCaiDat = new Custom_Button();
        btnLuuCaiDat.addActionListener(this);
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
        				.addGroup(gl_pnNguoiDung.createSequentialGroup()
        					.addGroup(gl_pnNguoiDung.createParallelGroup(Alignment.TRAILING)
        						.addComponent(btnDangXuat, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblHoTen, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnDoiMatKhau, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, 323, Short.MAX_VALUE)
        					.addComponent(btnLuuCaiDat, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
        				.addComponent(lblChucVu))
        			.addContainerGap())
        );
        gl_pnNguoiDung.setVerticalGroup(
        	gl_pnNguoiDung.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_pnNguoiDung.createSequentialGroup()
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(lbl_Title_NguoiDung, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pnNguoiDung.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblAvatar, GroupLayout.PREFERRED_SIZE, 74, GroupLayout.PREFERRED_SIZE)
        				.addGroup(gl_pnNguoiDung.createSequentialGroup()
        					.addComponent(lblChucVu)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblHoTen, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_pnNguoiDung.createParallelGroup(Alignment.LEADING)
        						.addComponent(btnDangXuat, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnLuuCaiDat, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnDoiMatKhau, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))))
        			.addGap(11))
        );
        pnNguoiDung.setLayout(gl_pnNguoiDung);
        setLayout(groupLayout);
        setting();
        addAction();
    }
    private void addAction()
    {
    	btnDangXuat.addActionListener(this);
    	btnDoiMatKhau.addActionListener(this);
    }
    private void dangXuat()
    {
    	int response = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không ?\nDo you want to logout ?", "Ask", JOptionPane.YES_NO_OPTION);

        if (response == JOptionPane.YES_OPTION) {
            // Xử lý khi người dùng chọn "Yes"
        	frame_Chinh.setVisible(false);
        	EventQueue.invokeLater(new Runnable() {
    			public void run() {
    				try {
    					Frame_DangNhap frame = new Frame_DangNhap();
    					frame.setVisible(true);
    					
    				} catch (Exception e) {
    					e.printStackTrace();
    				}
    			}
    		});
            
        } else {
            // Xử lý khi người dùng chọn "No" hoặc đóng hộp thoại
            System.out.println("Không lưu thay đổi.");
        }
    }
    private void showMessage(String message) {
        Message obj = new Message(Frame_Chinh.getFrames()[0], true);
        obj.showMessage(message);
    }
    private void settingLanguage() {
		// TODO Auto-generated method stub
    	if(settingModel.getNgonNgu().equals("Vietnamese")) {
    		lbl_Title_NguoiDung.setText("Người dùng");
    		lbl_Title_CaiDatNgonNgu.setText("Cài đặt ngôn ngữ");
    		lblChucVu.setText(chucVu);
    		btnDangXuat.setText("Đăng xuất");
    		btnDoiMatKhau.setText("Đổi mật khẩu");
    		btnLuuCaiDat.setText("Lưu cài đặt");
    		rdbtnTiengViet.setText("Tiếng việt");
    		rdbtnTiengAnh.setText("Tiếng anh");
    		lbl_Title_CaiDatGiaoDien.setText("Cài đặt giao diện");
    		rdbtnTrangSang.setText("Trắng sáng");
    		rdbtnCheDoToi.setText("Chế độ tối");
    	}
    	if(settingModel.getNgonNgu().equals("English")) {
    		lbl_Title_NguoiDung.setText("User");
    		lbl_Title_CaiDatNgonNgu.setText("Language setting");
    		lblChucVu.setText("Employee");
    		btnDangXuat.setText("Log out");
    		btnDoiMatKhau.setText("Change password");
    		btnLuuCaiDat.setText("Save setting");
    		rdbtnTiengViet.setText("Vietnamese");
    		rdbtnTiengAnh.setText("English");
    		lbl_Title_CaiDatGiaoDien.setText("UI setting");
    		rdbtnTrangSang.setText("White bright");
    		rdbtnCheDoToi.setText("Dark mode");
    	}	
    }
	
    private void settingButton() {
    	if(settingModel.getNgonNgu().equals("Vietnamese")) {
    		rdbtnTiengViet.setSelected(true);
    	}
    	if(settingModel.getNgonNgu().equals("English")) {
    		rdbtnTiengAnh.setSelected(true);
    	}
    	if(settingModel.getPhongCach().equals("Whitebright")) {
    		rdbtnTrangSang.setSelected(true);
    	}
    	if(settingModel.getPhongCach().equals("Darkmode")) {
    		rdbtnCheDoToi.setSelected(true);
    	}
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void setting() {
    	settingModel = new SettingModel();
    	try {
			settingModel.readFrom();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	settingButton();
    	settingLanguage();
    }// </editor-fold>//GEN-END:initComponents
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btnDangXuat))
		{
			dangXuat();
		}
		if(o.equals(btnDoiMatKhau))
		{
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {		
						Frame_DoiMatKhau frame = new Frame_DoiMatKhau(maNV,chucVu);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		if (!o.equals(btnLuuCaiDat)) return;
		if(rdbtnTiengAnh.isSelected()) {
			settingModel.setNgonNgu("English");
		}
		if(rdbtnTiengViet.isSelected()) {
			settingModel.setNgonNgu("Vietnamese");
		}
		if(rdbtnTrangSang.isSelected()) {
			settingModel.setPhongCach("Whitebright");
		}
		if(rdbtnCheDoToi.isSelected()) {
			settingModel.setPhongCach("Darkmode");
		}
		try {
			settingModel.writeTo() ;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String maNV = frame_Chinh.getMaNV();
		String chucVu = frame_Chinh.getChucVu();
		frame_Chinh.dispose();
		frame_Chinh = new Frame_Chinh(maNV,chucVu);
		frame_Chinh.setSettingModel(settingModel);
		frame_Chinh.setVisible(true);
		
		
	}
	public String getmaNV() {
		return maNV;
	}
	public void setmaNV(String maNV) {
		this.maNV = maNV;
	}
}

