package gui_Panel_NhanVien;



import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;

import customEntities.Custom_JLabel;
import dataBase_BUS.NhanVien_BUS;
import entities.NhanVien;
import customEntities.CustomTable;
import gui_Dialog.Message;
import gui_Frame_Running.Frame_Chinh;

import java.awt.Color;
import java.awt.Font;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import com.raven.model.SettingModel;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Panel_TimKiemNhanVien extends JPanel implements ActionListener, MouseListener
{
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_lbl_MatKhau_NV,pn_Table_DSNV;
	private Custom_JLabel picture_Logo;
	private JLabel lbl_Title_TK_NV,lbl_Title_DSNV;
	private JLabel lbl_MaNV,lbl_HoTen,lbl_MatKhau,lbl_ChucVu,lbl_GioiTinh,lbl_NgaySinh,lbl_DiaChi,lbl_CaLam,lbl_CCCD,lbl_SoDienThoai;
	private Custom_ComboBox cbo_MaNV,cbo_ChucVu,cbo_GioiTinh,cbo_CaLam;
	private JLabel lbl_txt_Malbl_MatKhauhau;
	private Custom_ComboBox cbo_HoTen,cbo_DiaChi,cbo_CCCD,cbo_Ngay,cbo_Thang,cbo_Nam,cbo_SoDienThoai;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_Button btn_TimKiem,btn_XoaTrang;
	private JScrollPane scr_DSNV;
	private CustomTable tbl_DSNV;
	private DefaultTableModel dtm_NV;
	private NhanVien_BUS sqlNhanVien_BUS=new NhanVien_BUS();
	private SettingModel settingModel;
    // End of variables declaration//GEN-END:variables
    public Panel_TimKiemNhanVien() {
        initComponents();
        setOpaque(false);
    }



    private void showMessage(String message) {
        Message obj = new Message(Frame_Chinh.getFrames()[0], true);
        obj.showMessage(message);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
    	lbl_Title_TK_NV = new JLabel("Tìm kiếm nhân viên");
    	lbl_Title_TK_NV.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_TK_NV.setForeground(new Color(0, 0, 255));
		lbl_Title_TK_NV.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_TK_NV.setBounds(30,100,2500,50);
		
    	pn_lbl_MatKhau_NV = new JPanel();
		pn_lbl_MatKhau_NV.setIgnoreRepaint(true);
		pn_lbl_MatKhau_NV.setBackground(Color.white);
		pn_lbl_MatKhau_NV.setBorder(new LineBorder(Custom_ColorPicker.lightgrey_D9D9D9, 3));
		
		lbl_MaNV = new JLabel("Mã nhân viên:");
		lbl_MaNV.setForeground(Color.black);
		lbl_MaNV.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_HoTen = new JLabel("Họ tên:");
		lbl_HoTen.setForeground(Color.black);
		lbl_HoTen.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_MatKhau = new JLabel("Mật khẩu:");
		lbl_MatKhau.setForeground(Color.black);
		lbl_MatKhau.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_ChucVu = new JLabel("Chức vụ:");
		lbl_ChucVu.setForeground(Color.black);
		lbl_ChucVu.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setForeground(Color.black);
		lbl_GioiTinh.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_NgaySinh = new JLabel("Ngày sinh:");
		lbl_NgaySinh.setForeground(Color.black);
		lbl_NgaySinh.setFont(new Font("Inter", Font.PLAIN, 14));

		lbl_DiaChi = new JLabel("Địa chỉ:");
		lbl_DiaChi.setForeground(Color.black);
		lbl_DiaChi.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_CaLam = new JLabel("Ca làm:");
		lbl_CaLam.setForeground(Color.black);
		lbl_CaLam.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_CCCD = new JLabel("CCCD:");
		lbl_CCCD.setForeground(Color.black);
		lbl_CCCD.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setForeground(Color.black);
		lbl_SoDienThoai.setFont(new Font("Inter", Font.PLAIN, 14));
		
		cbo_MaNV = new Custom_ComboBox();
		cbo_MaNV.setForeground(Color.black);
		cbo_MaNV.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_MaNV.setOpaque(true);
		cbo_MaNV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_HoTen = new Custom_ComboBox();
		cbo_HoTen.setForeground(Color.black);
		cbo_HoTen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_txt_Malbl_MatKhauhau = new JLabel();
		lbl_txt_Malbl_MatKhauhau.setForeground(Color.black);
		lbl_txt_Malbl_MatKhauhau.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lbl_txt_Malbl_MatKhauhau.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		lbl_txt_Malbl_MatKhauhau.setOpaque(true);
		
		cbo_ChucVu = new Custom_ComboBox();
		cbo_ChucVu.setForeground(Color.black);
		cbo_ChucVu.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_ChucVu.setColor_Foreground(Color.black);
		cbo_ChucVu.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_ChucVu.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_ChucVu.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_ChucVu.redraw_Custom_Combobox();
		
		//String[] string_NgayTrongThang = new String[31];
		//for (int i = 0; i < 31; i++) {
		//	string_NgayTrongThang[i] = String.format("%d",i+1);
		//}
		
		cbo_Ngay = new Custom_ComboBox();
		cbo_Ngay.addItem("");
		for (int i = 0; i < 31; i++) 
		{
			cbo_Ngay.addItem(Integer.toString(i+1));
		}
		cbo_Ngay.setForeground(Color.black);
		cbo_Ngay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_Ngay.setColor_Foreground(Color.black);
		cbo_Ngay.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Ngay.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Ngay.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_Ngay.setArrowButton_IsVisible(false);
		cbo_Ngay.redraw_Custom_Combobox();
		cbo_Ngay.setRadius(0);
		/*
		String[] string_ThangTrongNam = new String[12];
		for (int i = 0; i < 12; i++) {
			string_ThangTrongNam[i] = String.format("%d",i+1);
		}*/
		cbo_Thang = new Custom_ComboBox();
		cbo_Thang.addItem("");
		for (int i = 0; i < 12; i++) 
		{
			cbo_Thang.addItem(Integer.toString(i+1));
		}
		cbo_Thang.setForeground(Color.black);
		cbo_Thang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_Thang.setColor_Foreground(Color.black);
		cbo_Thang.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Thang.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Thang.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_Thang.setArrowButton_IsVisible(false);
		cbo_Thang.redraw_Custom_Combobox();
		cbo_Thang.setRadius(0);
		/*
		String[] string_Nam = new String[1500];
		LocalDate ngayHienTai = LocalDate.now(); 
		int namHienTai = ngayHienTai.getYear();
		for (int i = 0; i < 1500; i++) {
			string_Nam[i] = String.format("%04d",namHienTai-i);
		}*/
		LocalDate ngayHienTai = LocalDate.now(); 
		int namHienTai = ngayHienTai.getYear();
		cbo_Nam = new Custom_ComboBox();
		cbo_Nam.addItem("");
		for (int i = 0; i <1500; i++) 
		{
			cbo_Nam.addItem(Integer.toString(namHienTai-i));
		}
		cbo_Nam.setForeground(Color.black);
		cbo_Nam.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_Nam.setColor_Foreground(Color.black);
		cbo_Nam.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Nam.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Nam.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_Nam.setArrowButton_IsVisible(false);
		cbo_Nam.redraw_Custom_Combobox();
		cbo_Nam.setRadius(0);
		
		cbo_GioiTinh = new Custom_ComboBox();
		cbo_GioiTinh.setForeground(Color.black);
		cbo_GioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_GioiTinh.setColor_Foreground(Color.black);
		cbo_GioiTinh.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_GioiTinh.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_GioiTinh.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_GioiTinh.redraw_Custom_Combobox();
		cbo_GioiTinh.setRadius(0);
		
		
		cbo_CaLam = new Custom_ComboBox();
		cbo_CaLam.setForeground(Color.black);
		cbo_CaLam.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_CCCD = new Custom_ComboBox();
		cbo_CCCD.setForeground(Color.black);
		cbo_CCCD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_SoDienThoai = new Custom_ComboBox();
		cbo_SoDienThoai.setForeground(Color.black);
		cbo_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_DiaChi = new Custom_ComboBox();
		cbo_DiaChi.setForeground(Color.black);
		cbo_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_Title_DSNV = new JLabel("Danh sách nhân viên");
		lbl_Title_DSNV.setForeground(Color.BLUE);
		lbl_Title_DSNV.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		dtm_NV = new DefaultTableModel(new String[] {"Mã nhân viên","Tên nhân viên","Số điện thoại","Giới tính","Địa chỉ","Ngày sinh","Chức vụ","Căn cước công dân","Ca làm"},0);
		/*
		dtm_NV = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Loại sản phẩm","Ngôn ngữ","Nhà cung cấp","Nhà xuất bản","Năm xuất bản","Tác giả","Số lượng còn","Số lượng bán","Giá Nhập","Giá Bán"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_NV.addRow(new String[] {"SP0001","199 Đề Và Bài Văn Hay 9","Sách kham khảo","Tiếng Việt","Dn Tư Nhân Thương Mại Toàn Phúc","NXB Đại Học Quốc Gia Hà Nội","2018","	Phạm Ngọc Thắm","455","65","44.000đ","50.000đ"});
		}*/
		tbl_DSNV = new CustomTable();
		tbl_DSNV.setModel(dtm_NV);
		JScrollPane scr_DSNV = new JScrollPane(tbl_DSNV);
		TableColumnModel columnModel = tbl_DSNV.getColumnModel();

        // Thiết lập chiều rộng cột cụ thể (ví dụ: cột 1 có chiều rộng 150px)
		int[] columnWidths = {20,100,20,20,350,30,30,50,10};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
		
		btn_TimKiem = new Custom_Button();
		btn_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_TimKiem.setText("Tìm kiếm");
		btn_TimKiem.setFont(new Font("Inner", Font.BOLD, 12));
		btn_TimKiem.setBuffered_Icon("src/main/images/view_image/Search.png");
		btn_TimKiem.resizeIcon(14, 14);
		btn_TimKiem.setOver(true);
		btn_TimKiem.setColor_Foreground(Color.black);
		btn_TimKiem.setColor_Hightlight(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_TimKiem.setColor_Background(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_TimKiem.setColor_Over(Custom_ColorPicker.lightgrey_D9D9D9);
		btn_TimKiem.setColor_Click(Color.black);
		btn_TimKiem.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		
		btn_XoaTrang = new Custom_Button();
		btn_XoaTrang.setText("Xóa trắng");
		btn_XoaTrang.setFont(new Font("Inner", Font.BOLD, 12));
		btn_XoaTrang.setBuffered_Icon("src/main/images/view_image/Refresh.png");
		btn_XoaTrang.resizeIcon(14, 14);
		btn_XoaTrang.setOver(true);
		btn_XoaTrang.setColor_Foreground(Color.black);
		btn_XoaTrang.setColor_Hightlight(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_XoaTrang.setColor_Background(Custom_ColorPicker.snowwhite_F2F0EB);
		btn_XoaTrang.setColor_Over(Custom_ColorPicker.lightgrey_D9D9D9);
		btn_XoaTrang.setColor_Click(Color.black);
		btn_XoaTrang.setColor_Clicked_Background(Custom_ColorPicker.lime_BFFF00);
		
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.CENTER)
				.addGroup(layout.createSequentialGroup()
					.addGap(1)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_Title_TK_NV))
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_Title_DSNV))
						.addComponent(scr_DSNV, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE)
						.addGroup(layout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pn_lbl_MatKhau_NV, GroupLayout.PREFERRED_SIZE, 790, Short.MAX_VALUE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lbl_Title_TK_NV)
					.addGap(1)
					.addComponent(pn_lbl_MatKhau_NV, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_DSNV)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSNV, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
		);
        this.setLayout(layout);
        
        
        
        GroupLayout gl_pn_lbl_MatKhau_NV = new GroupLayout(pn_lbl_MatKhau_NV);
        gl_pn_lbl_MatKhau_NV.setHorizontalGroup(
        	gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        			.addGap(59)
        			.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lbl_ChucVu, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        				.addComponent(lbl_HoTen, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        				.addComponent(lbl_MaNV, GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
        				.addComponent(lbl_MatKhau, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        			.addGap(6)
        			.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        					.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        							.addComponent(cbo_MaNV, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addComponent(cbo_HoTen, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
        						.addComponent(lbl_txt_Malbl_MatKhauhau, GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE))
        					.addGap(4))
        				.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        					.addComponent(cbo_ChucVu, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lbl_NgaySinh, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_CaLam)
        				.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_GioiTinh))
        				.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_DiaChi)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        					.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING)
        						.addComponent(cbo_CaLam, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        						.addComponent(cbo_GioiTinh, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
        						.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        							.addComponent(cbo_Ngay, GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(cbo_Thang, GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(cbo_Nam, GroupLayout.PREFERRED_SIZE, 43, Short.MAX_VALUE)))
        					.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.TRAILING)
        						.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        							.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING, false)
        								.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        									.addGap(11)
        									.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
        								.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addComponent(lbl_CCCD, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)))
        							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING)
        								.addComponent(cbo_CCCD, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        								.addComponent(cbo_SoDienThoai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        						.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
        				.addComponent(cbo_DiaChi, GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE))
        			.addGap(18))
        );
        gl_pn_lbl_MatKhau_NV.setVerticalGroup(
        	gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_MaNV)
        				.addComponent(cbo_MaNV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_NgaySinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_Ngay, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_Thang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_Nam, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_CCCD, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_CCCD, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING)
        				.addComponent(cbo_SoDienThoai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_GioiTinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_GioiTinh, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_HoTen, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_HoTen))
        			.addGap(8)
        			.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING)
        				.addComponent(lbl_DiaChi)
        				.addComponent(cbo_DiaChi, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_MatKhau)
        				.addComponent(lbl_txt_Malbl_MatKhauhau, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        					.addGap(6)
        					.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbl_ChucVu)
        						.addComponent(cbo_ChucVu, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_CaLam)
        						.addComponent(cbo_CaLam, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(gl_pn_lbl_MatKhau_NV.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_pn_lbl_MatKhau_NV.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(28, Short.MAX_VALUE))
        );
        gl_pn_lbl_MatKhau_NV.linkSize(SwingConstants.VERTICAL, new Component[] {cbo_MaNV, cbo_HoTen, lbl_txt_Malbl_MatKhauhau, cbo_ChucVu, cbo_Ngay, cbo_Thang, cbo_Nam, cbo_GioiTinh, cbo_CaLam, cbo_CCCD, cbo_SoDienThoai, cbo_DiaChi});
        gl_pn_lbl_MatKhau_NV.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_GioiTinh, lbl_NgaySinh, lbl_DiaChi, lbl_CaLam, lbl_CCCD, lbl_SoDienThoai});
        gl_pn_lbl_MatKhau_NV.linkSize(SwingConstants.VERTICAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        gl_pn_lbl_MatKhau_NV.linkSize(SwingConstants.HORIZONTAL, new Component[] {lbl_GioiTinh, lbl_DiaChi, lbl_CaLam, lbl_CCCD, lbl_SoDienThoai});
        gl_pn_lbl_MatKhau_NV.linkSize(SwingConstants.HORIZONTAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        pn_lbl_MatKhau_NV.setLayout(gl_pn_lbl_MatKhau_NV);
        addAction();
        setting();
    }// </editor-fold>//GEN-END:initComponents
    private void addAction()
    {
    	btn_TimKiem.addActionListener(this);
    	btn_XoaTrang.addActionListener(this);
    	cbo_CaLam.addActionListener(this);
    	cbo_CCCD.addActionListener(this);
    	cbo_ChucVu.addActionListener(this);
    	cbo_DiaChi.addActionListener(this);
    	cbo_GioiTinh.addActionListener(this);
    	cbo_HoTen.addActionListener(this);
    	cbo_MaNV.addActionListener(this);
    	cbo_Nam.addActionListener(this);
    	cbo_Ngay.addActionListener(this);
    	cbo_SoDienThoai.addActionListener(this);
    	cbo_Thang.addActionListener(this);
    	tbl_DSNV.addMouseListener(this);
    	addCombobox();
    	resetTable();
    	//checkTable();
    }
    private void checkTable()
    {
    	if(isTableEmpty(tbl_DSNV))
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
            String canhBao = null,loaiCanhBao = null;
    		if (settingModel.getNgonNgu().equals("Vietnamese")) {
    			canhBao = "Không thể tìm thấy.";
    			loaiCanhBao = "Cảnh báo";
    		}
    		if (settingModel.getNgonNgu().equals("English")) {
    			canhBao = "Can't find.";
    			loaiCanhBao = "Warning";
    		}
            JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.WARNING_MESSAGE);
    	}
    }
    private boolean isTableEmpty(CustomTable tbl_DSNV) {
        return tbl_DSNV.getModel().getRowCount() == 0;
    }
    private void resetTable()
    {
    	dtm_NV.setRowCount(0);
    	sqlNhanVien_BUS.xuatDanhSachNhanVien(dtm_NV);
    }
    private void addCombobox()
    {
    	cbo_MaNV.addItem("");
    	sqlNhanVien_BUS.dayComboBoxMaNV(cbo_MaNV);
    	cbo_HoTen.addItem("");
    	sqlNhanVien_BUS.dayComboBoxTenNV(cbo_HoTen);
    	cbo_CCCD.addItem("");
    	sqlNhanVien_BUS.dayComboBoxCCCD(cbo_CCCD);
    	cbo_SoDienThoai.addItem("");
    	sqlNhanVien_BUS.dayComboBoxSDT(cbo_SoDienThoai);
    	cbo_DiaChi.addItem("");
    	sqlNhanVien_BUS.dayComboBoxDiaChi(cbo_DiaChi);
    	cbo_GioiTinh.addItem("");
    	//sqlNhanVien_BUS.dayComboBoxGioiTinh(cbo_GioiTinh);
    	//LocalDate ngayHienTai=LocalDate.now();   	
    	cbo_Ngay.setSelectedItem("");
    	cbo_Thang.setSelectedItem("");
    	cbo_Nam.setSelectedItem("");
    	cbo_CaLam.addItem("");
    	//sqlNhanVien_BUS.dayComboBoxCaLam(cbo_CaLam);
    	cbo_ChucVu.addItem("");
    	//sqlNhanVien_BUS.dayComboChucVu(cbo_ChucVu);
    	
    }
    private void xoaTrang()
    {
    	
    	cbo_Ngay.setSelectedItem("");
    	cbo_Thang.setSelectedItem("");
    	cbo_Nam.setSelectedItem("");
    	String chon="";
    	cbo_MaNV.setSelectedItem(chon);
    	cbo_HoTen.setSelectedItem(chon);
    	cbo_CCCD.setSelectedItem(chon);
    	cbo_ChucVu.setSelectedItem(chon);
    	cbo_CaLam.setSelectedItem(chon);
    	cbo_GioiTinh.setSelectedItem(chon);
    	cbo_DiaChi.setSelectedItem(chon);
    	cbo_SoDienThoai.setSelectedItem(chon);
    	lbl_txt_Malbl_MatKhauhau.setText("");
    	resetTable();
    	
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=tbl_DSNV.getSelectedRow();
		String maNV=tbl_DSNV.getValueAt(row, 0).toString();
		String tenNV=tbl_DSNV.getValueAt(row, 1).toString();
		String sdt=tbl_DSNV.getValueAt(row, 2).toString();
		String gioiTinh=tbl_DSNV.getValueAt(row, 3).toString();
		String diaChi=tbl_DSNV.getValueAt(row, 4).toString();
		String chucVu=tbl_DSNV.getValueAt(row, 6).toString();
		String cCCD=tbl_DSNV.getValueAt(row, 7).toString();
		String caLam=tbl_DSNV.getValueAt(row, 8).toString();
		cbo_MaNV.setSelectedItem(maNV);
		cbo_HoTen.setSelectedItem(tenNV);
		cbo_SoDienThoai.setSelectedItem(sdt);
		cbo_GioiTinh.setSelectedItem(gioiTinh);
		cbo_DiaChi.setSelectedItem(diaChi);
		cbo_ChucVu.setSelectedItem(chucVu);
		cbo_CCCD.setSelectedItem(cCCD);
		cbo_CaLam.setSelectedItem(caLam);
		String malbl_MatKhauhau=sqlNhanVien_BUS.getMatKhau(maNV);
		lbl_txt_Malbl_MatKhauhau.setText(malbl_MatKhauhau);
		Date ngaySinh=sqlNhanVien_BUS.getNgaySinh(maNV);
		java.sql.Date sqlDateNgaySinh = new java.sql.Date(ngaySinh.getTime());
		NhanVien n=new NhanVien();
		n.setNgaySinh(sqlDateNgaySinh);
		LocalDate ngaySinh_LocalDate=n.getNgaySinhLocalDate();
		cbo_Ngay.setSelectedItem(ngaySinh_LocalDate.getDayOfMonth());
		cbo_Thang.setSelectedItem(ngaySinh_LocalDate.getMonthValue());
		cbo_Nam.setSelectedItem(ngaySinh_LocalDate.getYear());
	}
	/*
	private boolean checkComboboxNULL()
	{
		
			String maNV= cbo_MaNV.getSelectedItem().toString();
			String tenNV= cbo_HoTen.getSelectedItem().toString();
			String sdt= cbo_SoDienThoai.getSelectedItem().toString();
			String gioiTinh= cbo_GioiTinh.getSelectedItem().toString();
			String diaChi= cbo_DiaChi.getSelectedItem().toString();
			String ngay= cbo_Ngay.getSelectedItem().toString();
			String thang= cbo_Thang.getSelectedItem().toString();
			String nam= cbo_Nam.getSelectedItem().toString();
			String chucVu= cbo_ChucVu.getSelectedItem().toString();
			String cCCCD=cbo_CCCD.getSelectedItem().toString();
			String caLam= cbo_CaLam.getSelectedItem().toString();
		
		
		if(maNV!=null && tenNV!=null && sdt!=null && gioiTinh!=null 
				&& diaChi!=null && ngay!=null && thang!=null && nam!=null && chucVu!=null && cCCCD!=null && caLam!=null)
		{
			return true;
		}
		else
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
            String canhBao = null,loaiCanhBao = null;
    		if (settingModel.getNgonNgu().equals("Vietnamese")) {
    			canhBao = "Dữ liệu tìm kiếm không được rỗng.";
    			loaiCanhBao = "Lỗi";
    		}
    		if (settingModel.getNgonNgu().equals("English")) {
    			canhBao = "Search data cannot be empty.";
    			loaiCanhBao = "Error";
    		}
            JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
            return false;
		}
	}*/
	private void changNULL(String maNV,String tenNV, String sdt, 
			String gioiTinh,String diaChi, String ngay,String thang,String nam,String chucVu,String cCCD,String caLam)
	{
		if(Objects.isNull(maNV))
		{
			maNV="";
		}
		if(Objects.isNull(tenNV))
		{
			tenNV="";
		}
		if(Objects.isNull(sdt))
		{
			sdt="";
		}
		if(Objects.isNull(gioiTinh))
		{
			gioiTinh="";
		}
		if(Objects.isNull(diaChi))
		{
			diaChi="";
		}
		LocalDate now=LocalDate.now();
		if(Objects.isNull(ngay))
		{
			ngay=Integer.toString(now.getDayOfMonth());
		}
		if(Objects.isNull(thang))
		{
			thang=Integer.toString(now.getMonthValue());
		}
		if(Objects.isNull(nam))
		{
			nam=Integer.toString(now.getYear());
		}
		if(Objects.isNull(chucVu))
		{
			chucVu="";
		}
		if(Objects.isNull(cCCD))
		{
			cCCD="";
		}
		if(Objects.isNull(caLam))
		{
			caLam="";
		}
		
	}
	private void timKiem()
	{
		String maNV=(String) cbo_MaNV.getSelectedItem();
		String tenNV=(String)  cbo_HoTen.getSelectedItem();
		String sdt=(String) cbo_SoDienThoai.getSelectedItem();
		String gioiTinh=(String) cbo_GioiTinh.getSelectedItem();
		String diaChi=(String) cbo_DiaChi.getSelectedItem();
		String ngay=(String) cbo_Ngay.getSelectedItem();
		String thang=(String) cbo_Thang.getSelectedItem();
		String nam=(String) cbo_Nam.getSelectedItem();
		String chucVu=(String) cbo_ChucVu.getSelectedItem();
		String cCCCD=(String) cbo_CCCD.getSelectedItem();
		String caLam=(String) cbo_CaLam.getSelectedItem();
		changNULL(maNV, tenNV, sdt, gioiTinh, diaChi, ngay, thang, nam, chucVu, cCCCD, caLam);
		String chon="";
		if(maNV.equalsIgnoreCase(chon) && tenNV.equalsIgnoreCase(chon) && sdt.equalsIgnoreCase(chon) && gioiTinh.equalsIgnoreCase(chon) &&
				diaChi.equalsIgnoreCase(chon)  && chucVu.equalsIgnoreCase(chon) && cCCCD.equalsIgnoreCase(chon) && caLam.equalsIgnoreCase(chon)&&
				ngay.equalsIgnoreCase(chon)&&thang.equalsIgnoreCase(chon) && nam.equalsIgnoreCase(chon))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        String canhBao = null,loaiCanhBao = null;
    		if (settingModel.getNgonNgu().equals("Vietnamese")) {
    			canhBao = "Vui lòng chọn thông tin để tìm kiếm.";
    			loaiCanhBao = "Lỗi";
    		}
    		if (settingModel.getNgonNgu().equals("English")) {
    			canhBao = "Please select information to search.";
    			loaiCanhBao = "Error";
    		}
			JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
		}
		if(!maNV.equalsIgnoreCase(chon) )
		{
			dtm_NV.setRowCount(0);
			sqlNhanVien_BUS.timKiemTheo_maNV(maNV, dtm_NV);
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
			//JOptionPane.showMessageDialog(null, "Tìm kiếm theo mã nhân viên.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
		if(maNV.equalsIgnoreCase(chon) && !tenNV.equalsIgnoreCase(chon) && sdt.equalsIgnoreCase(chon) && gioiTinh.equalsIgnoreCase(chon) &&
				diaChi.equalsIgnoreCase(chon)  && chucVu.equalsIgnoreCase(chon) && cCCCD.equalsIgnoreCase(chon) && caLam.equalsIgnoreCase(chon)&&
				ngay.equalsIgnoreCase(chon)&&thang.equalsIgnoreCase(chon) && nam.equalsIgnoreCase(chon))
		{
			dtm_NV.setRowCount(0);
			sqlNhanVien_BUS.timKiemTheo_tenNV(tenNV, dtm_NV);
		}
		if(maNV.equalsIgnoreCase(chon) && tenNV.equalsIgnoreCase(chon) && !sdt.equalsIgnoreCase(chon) && gioiTinh.equalsIgnoreCase(chon) &&
				diaChi.equalsIgnoreCase(chon)  && chucVu.equalsIgnoreCase(chon) && cCCCD.equalsIgnoreCase(chon) && caLam.equalsIgnoreCase(chon)&&
				ngay.equalsIgnoreCase(chon)&&thang.equalsIgnoreCase(chon) && nam.equalsIgnoreCase(chon))
		{
			dtm_NV.setRowCount(0);
			sqlNhanVien_BUS.timKiemTheo_sdt(sdt, dtm_NV);
		}
		if(maNV.equalsIgnoreCase(chon) && tenNV.equalsIgnoreCase(chon) && sdt.equalsIgnoreCase(chon) && !gioiTinh.equalsIgnoreCase(chon) &&
				diaChi.equalsIgnoreCase(chon)  && chucVu.equalsIgnoreCase(chon) && cCCCD.equalsIgnoreCase(chon) && caLam.equalsIgnoreCase(chon)&&
				ngay.equalsIgnoreCase(chon)&&thang.equalsIgnoreCase(chon) && nam.equalsIgnoreCase(chon))
		{
			dtm_NV.setRowCount(0);
			sqlNhanVien_BUS.timKiemTheo_gioiTinh(gioiTinh, dtm_NV);
		}
		if(maNV.equalsIgnoreCase(chon) && tenNV.equalsIgnoreCase(chon) && sdt.equalsIgnoreCase(chon) && gioiTinh.equalsIgnoreCase(chon) &&
				diaChi.equalsIgnoreCase(chon)  && !chucVu.equalsIgnoreCase(chon) && cCCCD.equalsIgnoreCase(chon) && caLam.equalsIgnoreCase(chon)&&
				ngay.equalsIgnoreCase(chon)&&thang.equalsIgnoreCase(chon) && nam.equalsIgnoreCase(chon))
		{
			dtm_NV.setRowCount(0);
			sqlNhanVien_BUS.timKiemTheo_chucVu(chucVu, dtm_NV);
		}
		if(maNV.equalsIgnoreCase(chon) && tenNV.equalsIgnoreCase(chon) && sdt.equalsIgnoreCase(chon) && gioiTinh.equalsIgnoreCase(chon) &&
				diaChi.equalsIgnoreCase(chon)  && chucVu.equalsIgnoreCase(chon) && !cCCCD.equalsIgnoreCase(chon) && caLam.equalsIgnoreCase(chon)&&
				ngay.equalsIgnoreCase(chon)&&thang.equalsIgnoreCase(chon) && nam.equalsIgnoreCase(chon))
		{
			dtm_NV.setRowCount(0);
			sqlNhanVien_BUS.timKiemTheo_cCCD(cCCCD, dtm_NV);
		}
		if(maNV.equalsIgnoreCase(chon) && tenNV.equalsIgnoreCase(chon) && sdt.equalsIgnoreCase(chon) && gioiTinh.equalsIgnoreCase(chon) &&
				diaChi.equalsIgnoreCase(chon)  && chucVu.equalsIgnoreCase(chon) && cCCCD.equalsIgnoreCase(chon) && !caLam.equalsIgnoreCase(chon)&&
				ngay.equalsIgnoreCase(chon)&&thang.equalsIgnoreCase(chon) && nam.equalsIgnoreCase(chon))
		{
			dtm_NV.setRowCount(0);
			sqlNhanVien_BUS.timKiemTheo_caLam(caLam, dtm_NV);
		}
		if(maNV.equalsIgnoreCase(chon) && tenNV.equalsIgnoreCase(chon) && sdt.equalsIgnoreCase(chon) && gioiTinh.equalsIgnoreCase(chon) &&
				diaChi.equalsIgnoreCase(chon)  && chucVu.equalsIgnoreCase(chon) && cCCCD.equalsIgnoreCase(chon) && caLam.equalsIgnoreCase(chon)&&
				!ngay.equalsIgnoreCase(chon)&&thang.equalsIgnoreCase(chon) && nam.equalsIgnoreCase(chon))
		{
			int ngay_Int=Integer.parseInt(ngay);
			dtm_NV.setRowCount(0);
			sqlNhanVien_BUS.timKiemTheo_ngaySinh(ngay_Int, dtm_NV);
		}
		if(maNV.equalsIgnoreCase(chon) && tenNV.equalsIgnoreCase(chon) && sdt.equalsIgnoreCase(chon) && gioiTinh.equalsIgnoreCase(chon) &&
				diaChi.equalsIgnoreCase(chon)  && chucVu.equalsIgnoreCase(chon) && cCCCD.equalsIgnoreCase(chon) && caLam.equalsIgnoreCase(chon)&&
				ngay.equalsIgnoreCase(chon)&&!thang.equalsIgnoreCase(chon) && nam.equalsIgnoreCase(chon))
		{
			int thang_Int=Integer.parseInt(thang);
			dtm_NV.setRowCount(0);
			sqlNhanVien_BUS.timKiemTheo_thangSinh(thang_Int, dtm_NV);
		}
		if(maNV.equalsIgnoreCase(chon) && tenNV.equalsIgnoreCase(chon) && sdt.equalsIgnoreCase(chon) && gioiTinh.equalsIgnoreCase(chon) &&
				diaChi.equalsIgnoreCase(chon)  && chucVu.equalsIgnoreCase(chon) && cCCCD.equalsIgnoreCase(chon) && caLam.equalsIgnoreCase(chon)&&
				ngay.equalsIgnoreCase(chon)&&thang.equalsIgnoreCase(chon) && !nam.equalsIgnoreCase(chon))
		{
			int nam_Int=Integer.parseInt(nam);
			dtm_NV.setRowCount(0);
			sqlNhanVien_BUS.timKiemTheo_namSinh(nam_Int, dtm_NV);
		}
		if(maNV.equalsIgnoreCase(chon) && tenNV.equalsIgnoreCase(chon) && sdt.equalsIgnoreCase(chon) && gioiTinh.equalsIgnoreCase(chon) &&
				!diaChi.equalsIgnoreCase(chon)  && chucVu.equalsIgnoreCase(chon) && cCCCD.equalsIgnoreCase(chon) && caLam.equalsIgnoreCase(chon)&&
				ngay.equalsIgnoreCase(chon)&&thang.equalsIgnoreCase(chon) && nam.equalsIgnoreCase(chon))
		{
			dtm_NV.setRowCount(0);
			sqlNhanVien_BUS.timKiemTheo_diaChi(diaChi, dtm_NV);
		}
		boolean hasTwoNonChonStrings = false;
		int nonChonCount = 0;

		String[] stringsToCheck = {maNV, tenNV, sdt, gioiTinh, diaChi, ngay, thang, nam, chucVu, cCCCD, caLam};

		for (String str : stringsToCheck) {
		    if (!str.equals("")) {
		        nonChonCount++;
		        if (nonChonCount >= 2) {
		            hasTwoNonChonStrings = true;
		            break;
		        }
		    }
		}
		if(hasTwoNonChonStrings)
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
            String canhBao = null,loaiCanhBao = null;
    		if (settingModel.getNgonNgu().equals("Vietnamese")) {
    			canhBao = "Không thể tìm kiếm Nhân viên thông qua 2 hoặc nhiều thuộc tính.";
    			loaiCanhBao = "Lỗi";
    		}
    		if (settingModel.getNgonNgu().equals("English")) {
    			canhBao = "Unable to search for Employee via 2 or more attributes.";
    			loaiCanhBao = "Error";
    		}
            JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
		}
		settingTable();
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btn_XoaTrang))
		{
			xoaTrang();
			settingTable();
		}
		if(o.equals(btn_TimKiem))
		{			
			timKiem();
			checkTable();
		}
	}
	private void settingLanguage() {
		// TODO Auto-generated method stub
			if(settingModel.getNgonNgu().equals("Vietnamese")) {
				lbl_Title_TK_NV.setText("Tìm kiếm nhân viên");
				lbl_MaNV.setText("Mã nhân viên");
				lbl_HoTen.setText("Họ tên");
				lbl_MatKhau.setText("Mật khẩu");
				lbl_ChucVu.setText("Chức vụ");
				lbl_NgaySinh.setText("Ngày sinh");
				lbl_DiaChi.setText("Địa chỉ");
				lbl_ChucVu.setText("Chức vụ");
				lbl_CaLam.setText("Ca làm");
				lbl_CCCD.setText("CCCD");
				lbl_SoDienThoai.setText("Số điện thoại");
				btn_XoaTrang.setText("Xóa trắng");
				btn_TimKiem.setText("Tìm kiếm");
				lbl_Title_DSNV.setText("Danh sách nhân viên");
				tbl_DSNV.getColumnModel().getColumn(0).setHeaderValue("Mã nhân viên");
				tbl_DSNV.getColumnModel().getColumn(1).setHeaderValue("Tên nhân viên");
				tbl_DSNV.getColumnModel().getColumn(2).setHeaderValue("Số điện thoại");
				tbl_DSNV.getColumnModel().getColumn(3).setHeaderValue("Giới tính");
				tbl_DSNV.getColumnModel().getColumn(4).setHeaderValue("Địa chỉ");
				tbl_DSNV.getColumnModel().getColumn(5).setHeaderValue("Ngày sinh");
				tbl_DSNV.getColumnModel().getColumn(6).setHeaderValue("Chức vụ");
				tbl_DSNV.getColumnModel().getColumn(7).setHeaderValue("CCCD");
				tbl_DSNV.getColumnModel().getColumn(8).setHeaderValue("Ca làm");
			}
			if(settingModel.getNgonNgu().equals("English")) {
				lbl_Title_TK_NV.setText("Employee searching");
				lbl_MaNV.setText("Employee number");
				lbl_HoTen.setText("Full name");
				lbl_MatKhau.setText("Password");
				lbl_ChucVu.setText("Position");
				lbl_NgaySinh.setText("Birthday");
				lbl_DiaChi.setText("Address");
				lbl_GioiTinh.setText("Sex");
				lbl_CaLam.setText("Shift");
				lbl_CCCD.setText("C.I.");
				lbl_SoDienThoai.setText("Phone number");
				btn_XoaTrang.setText("Refresh");
				btn_TimKiem.setText("Search");
				lbl_Title_DSNV.setText("Employee list");
				tbl_DSNV.getColumnModel().getColumn(0).setHeaderValue("Employee number");
				tbl_DSNV.getColumnModel().getColumn(1).setHeaderValue("Full name");
				tbl_DSNV.getColumnModel().getColumn(2).setHeaderValue("Phone number");
				tbl_DSNV.getColumnModel().getColumn(3).setHeaderValue("Sex");
				tbl_DSNV.getColumnModel().getColumn(4).setHeaderValue("Address");
				tbl_DSNV.getColumnModel().getColumn(5).setHeaderValue("Birthday");
				tbl_DSNV.getColumnModel().getColumn(6).setHeaderValue("Position");
				tbl_DSNV.getColumnModel().getColumn(7).setHeaderValue("C.I.");
				tbl_DSNV.getColumnModel().getColumn(8).setHeaderValue("Shift");
			}	
		}
		private void setting() {
	    	settingModel = new SettingModel();
	    	try {
				settingModel.readFrom();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	//settingButton();
	    	settingLanguage();
	    	settingCombobox();
	    	settingTable();
	    }
		private void settingCombobox() {
	    	if(settingModel.getNgonNgu().equals("Vietnamese")) {
				cbo_GioiTinh.addItem("Nam");
				cbo_GioiTinh.addItem("Nữ");
				cbo_GioiTinh.getMyVector().add("Nam");
				cbo_GioiTinh.getMyVector().add("Nữ");
				cbo_CaLam.addItem("Sáng");
				cbo_CaLam.addItem("Chiều");
				cbo_CaLam.addItem("Tối");
				cbo_CaLam.getMyVector().add("Sáng");
				cbo_CaLam.getMyVector().add("Chiều");
				cbo_CaLam.getMyVector().add("Tối");
				cbo_ChucVu.addItem("Nhân viên");
				cbo_ChucVu.addItem("Nhân viên quản lí");
				cbo_ChucVu.getMyVector().add("Nhân viên");
				cbo_ChucVu.getMyVector().add("Nhân viên quản lí");
			}
	    	if(settingModel.getNgonNgu().equals("English")) {
	    		cbo_GioiTinh.addItem("Male");
	    		cbo_GioiTinh.addItem("Female");
	    		cbo_GioiTinh.getMyVector().add("Male");
	    		cbo_GioiTinh.getMyVector().add("Female");
	    		cbo_CaLam.addItem("Morning");
				cbo_CaLam.addItem("Afternoon");
				cbo_CaLam.addItem("Night");
				cbo_CaLam.getMyVector().add("Morning");
				cbo_CaLam.getMyVector().add("Afternoon");
				cbo_CaLam.getMyVector().add("Night");
				cbo_ChucVu.addItem("Sale employee");
				cbo_ChucVu.addItem("Manager");
				cbo_ChucVu.getMyVector().add("Sale employee");
				cbo_ChucVu.getMyVector().add("Manager");
	    	}
		}
		private void settingTable() {
			if(settingModel.getNgonNgu().equals("English"))
				for (int i = 0; i < tbl_DSNV.getRowCount(); i++) {
					if(tbl_DSNV.getModel().getValueAt(i, 3).toString().equals("Nam"))
						tbl_DSNV.getModel().setValueAt("Male",i, 3);
					if(tbl_DSNV.getModel().getValueAt(i, 3).toString().equals("Nữ"))
						tbl_DSNV.getModel().setValueAt("Female",i, 3);
					if(tbl_DSNV.getModel().getValueAt(i, 6).toString().equals("Nhân viên"))
						tbl_DSNV.getModel().setValueAt("Sale employee",i, 6);
					if(tbl_DSNV.getModel().getValueAt(i, 6).toString().equals("Nhân viên quản lí"))
						tbl_DSNV.getModel().setValueAt("Manager",i, 6);
					if(tbl_DSNV.getModel().getValueAt(i, 8).toString().equals("Sáng"))
						tbl_DSNV.getModel().setValueAt("Morning",i, 8);
					if(tbl_DSNV.getModel().getValueAt(i, 8).toString().equals("Chiều"))
						tbl_DSNV.getModel().setValueAt("Afternoon",i, 8);
					if(tbl_DSNV.getModel().getValueAt(i, 8).toString().equals("Tối"))
						tbl_DSNV.getModel().setValueAt("Night",i, 8);
				}
		}
}
