package gui_Panel_HoaDon;

import com.raven.model.SettingModel;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.toedter.calendar.JDateChooser;

import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import customEntities.Custom_Function;
import customEntities.Custom_ImageIcon;
import customEntities.Custom_JLabel;
import dataBase_BUS.CTDonDatHang_BUS;
import dataBase_BUS.CTHoaDon_BUS;
import dataBase_BUS.DonDatHang_BUS;
import dataBase_BUS.HoaDon_BUS;
import customEntities.CustomTable;
import gui_Dialog.Message;
import gui_Frame_Running.Frame_Chinh;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
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
import java.time.DateTimeException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Panel_TimKiemHoaDon extends JPanel implements ActionListener, MouseListener
{
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_QL_NV,pn_Table_DSNV;
	private Custom_JLabel picture_Logo;
	private JLabel lbl_Title_TK_HD,lbl_Title_DSHD,lbl_Title_DSCTHD;
	private JLabel lbl_MaHD,lbl_HoTenNhanVien,lbl_TongTien,lbl_NgayLap,lbl_HoTenKhachHang,lbl_SoDienThoaiKhach;
	private Custom_ComboBox cbo_MaHD,cbo_TenKH;
	private Custom_ComboBox cbo_TenNV,cbo_TongTien,cbo_Ngay,cbo_Thang,cbo_Nam,cbo_SoDienThoai;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_Button btn_TimKiem,btn_XoaTrang;
	private CustomTable tbl_DSHD,tbl_DSCTHD;
	private DefaultTableModel dtm_HD,dtm_CTHD;
	private JScrollPane scr_DSCTHD,scr_DSHD;
	private SettingModel settingModel;
	private HoaDon_BUS sqlHoaDon_BUS=new HoaDon_BUS();
	private CTHoaDon_BUS sqlCTHoaDon_BUS=new CTHoaDon_BUS();
    // End of variables declaration//GEN-END:variables
    public Panel_TimKiemHoaDon() {
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
    	lbl_Title_TK_HD = new JLabel("Tìm kiếm hóa đơn");
    	lbl_Title_TK_HD.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_TK_HD.setForeground(new Color(0, 0, 255));
		lbl_Title_TK_HD.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_TK_HD.setBounds(30,100,2500,50);
		
    	pn_QL_NV = new JPanel();
		pn_QL_NV.setIgnoreRepaint(true);
		pn_QL_NV.setBackground(Color.white);
		pn_QL_NV.setBorder(new LineBorder(Custom_ColorPicker.lightgrey_D9D9D9, 3));
		
		lbl_MaHD = new JLabel("Mã hóa đơn:");
		lbl_MaHD.setForeground(Color.black);
		lbl_MaHD.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_HoTenNhanVien = new JLabel("Họ tên nhân viên:");
		lbl_HoTenNhanVien.setForeground(Color.black);
		lbl_HoTenNhanVien.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_TongTien = new JLabel("Tổng tiền:");
		lbl_TongTien.setForeground(Color.black);
		lbl_TongTien.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_NgayLap = new JLabel("Ngày lập:");
		lbl_NgayLap.setForeground(Color.black);
		lbl_NgayLap.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_HoTenKhachHang = new JLabel("Họ tên khách hàng:");
		lbl_HoTenKhachHang.setForeground(Color.black);
		lbl_HoTenKhachHang.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_SoDienThoaiKhach = new JLabel("Số điện thoại khách:");
		lbl_SoDienThoaiKhach.setForeground(Color.black);
		lbl_SoDienThoaiKhach.setFont(new Font("Inter", Font.PLAIN, 14));
		
		cbo_MaHD = new Custom_ComboBox();
		cbo_MaHD.setForeground(Color.black);
		cbo_MaHD.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_MaHD.setOpaque(true);
		cbo_MaHD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_TenNV = new Custom_ComboBox();
		cbo_TenNV.setForeground(Color.black);
		cbo_TenNV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		String[] string_NgayTrongThang = new String[31];
		for (int i = 0; i < 31; i++) {
			string_NgayTrongThang[i] = String.format("%02d",i+1);
		}
		
		cbo_Ngay = new Custom_ComboBox(string_NgayTrongThang);
		cbo_Ngay.setForeground(Color.black);
		cbo_Ngay.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_Ngay.setColor_Foreground(Color.black);
		cbo_Ngay.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Ngay.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Ngay.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_Ngay.setArrowButton_IsVisible(false);
		cbo_Ngay.redraw_Custom_Combobox();
		cbo_Ngay.setRadius(0);
		
		String[] string_ThangTrongNam = new String[12];
		for (int i = 0; i < 12; i++) {
			string_ThangTrongNam[i] = String.format("%02d",i+1);
		}
		cbo_Thang = new Custom_ComboBox(string_ThangTrongNam);
		cbo_Thang.setForeground(Color.black);
		cbo_Thang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_Thang.setColor_Foreground(Color.black);
		cbo_Thang.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Thang.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Thang.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_Thang.setArrowButton_IsVisible(false);
		cbo_Thang.redraw_Custom_Combobox();
		cbo_Thang.setRadius(0);
		
		String[] string_Nam = new String[1500];
		LocalDate ngayHienTai = LocalDate.now(); 
		int namHienTai = ngayHienTai.getYear();
		for (int i = 0; i < 1500; i++) {
			string_Nam[i] = String.format("%04d",namHienTai-i);
		}
		
		cbo_Nam = new Custom_ComboBox(string_Nam);
		cbo_Nam.setForeground(Color.black);
		cbo_Nam.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_Nam.setColor_Foreground(Color.black);
		cbo_Nam.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Nam.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_Nam.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_Nam.setArrowButton_IsVisible(false);
		cbo_Nam.redraw_Custom_Combobox();
		cbo_Nam.setRadius(0);
		
		cbo_TenKH = new Custom_ComboBox();
		cbo_TenKH.setForeground(Color.black);
		cbo_TenKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_TenKH.setColor_Foreground(Color.black);
		cbo_TenKH.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_TenKH.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_TenKH.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_TenKH.redraw_Custom_Combobox();
		cbo_TenKH.setRadius(0);
		
		cbo_TongTien = new Custom_ComboBox();
		cbo_TongTien.setForeground(Color.black);
		cbo_TongTien.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_SoDienThoai = new Custom_ComboBox();
		cbo_SoDienThoai.setForeground(Color.black);
		cbo_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_Title_DSHD = new JLabel("Danh sách hóa đơn");
		lbl_Title_DSHD.setForeground(Color.BLUE);
		lbl_Title_DSHD.setFont(new Font("SansSerif", Font.BOLD, 12));
		dtm_HD = new DefaultTableModel(new String[] {"Mã hóa đơn","Họ tên nhân viên","Họ tên khách hàng","SĐT khách","Ngày lập","Tổng tiền"},0);
		
		tbl_DSHD = new CustomTable();
		tbl_DSHD.setModel(dtm_HD);
		JScrollPane scr_DSHD = new JScrollPane(tbl_DSHD);
		TableColumnModel columnModel = tbl_DSHD.getColumnModel();
		dtm_CTHD = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Đơn giá","Số lượng mua","Thành tiền"},0);
		
		tbl_DSCTHD = new CustomTable();
		tbl_DSCTHD.setModel(dtm_CTHD);
		JScrollPane scr_DSCTHD = new JScrollPane(tbl_DSCTHD);
		
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
		
		lbl_Title_DSCTHD = new JLabel("Danh sách chi tiết hóa đơn");
		lbl_Title_DSCTHD.setForeground(Color.BLUE);
		lbl_Title_DSCTHD.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scr_DSCTHD, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 995, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
							.addGap(1)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createParallelGroup(Alignment.LEADING)
									.addComponent(lbl_Title_DSHD)
									.addComponent(scr_DSHD, GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
									.addComponent(lbl_Title_DSCTHD, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
								.addComponent(pn_QL_NV, GroupLayout.PREFERRED_SIZE, 994, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_Title_TK_HD)))))
					.addGap(0))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lbl_Title_TK_HD)
					.addGap(1)
					.addComponent(pn_QL_NV, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_DSHD)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSHD, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(lbl_Title_DSCTHD, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSCTHD, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
					.addContainerGap())
		);
        this.setLayout(layout);
        
        
        
        GroupLayout gl_pn_QL_NV = new GroupLayout(pn_QL_NV);
        gl_pn_QL_NV.setHorizontalGroup(
        	gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_pn_QL_NV.createSequentialGroup()
        			.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_pn_QL_NV.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_QL_NV.createSequentialGroup()
        					.addGap(45)
        					.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(lbl_MaHD, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lbl_HoTenNhanVien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(6)
        					.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        						.addGroup(gl_pn_QL_NV.createSequentialGroup()
        							.addComponent(cbo_MaHD, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED))
        						.addComponent(cbo_TenNV, GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE))
        					.addGap(4)
        					.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(lbl_NgayLap, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
        						.addGroup(gl_pn_QL_NV.createSequentialGroup()
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(lbl_TongTien)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        						.addComponent(cbo_TenKH, GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
        						.addGroup(gl_pn_QL_NV.createSequentialGroup()
        							.addComponent(cbo_Ngay, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(cbo_Thang, GroupLayout.PREFERRED_SIZE, 51, Short.MAX_VALUE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(cbo_Nam, GroupLayout.PREFERRED_SIZE, 52, Short.MAX_VALUE)))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbl_HoTenKhachHang, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_SoDienThoaiKhach, GroupLayout.PREFERRED_SIZE, 125, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.TRAILING)
        						.addComponent(cbo_TongTien, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
        						.addComponent(cbo_SoDienThoai, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
        			.addGap(18))
        );
        gl_pn_QL_NV.setVerticalGroup(
        	gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_QL_NV.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        				.addComponent(cbo_MaHD, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_NgayLap, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_Ngay, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_Thang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_Nam, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_TongTien, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_MaHD)
        				.addComponent(lbl_HoTenKhachHang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.LEADING)
        					.addComponent(cbo_TenKH, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addComponent(lbl_TongTien, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addComponent(cbo_TenNV, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addComponent(cbo_SoDienThoai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        				.addComponent(lbl_HoTenNhanVien)
        				.addComponent(lbl_SoDienThoaiKhach, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_QL_NV.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(38, Short.MAX_VALUE))
        );
        gl_pn_QL_NV.linkSize(SwingConstants.VERTICAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        gl_pn_QL_NV.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_TongTien, lbl_NgayLap, lbl_HoTenKhachHang, lbl_SoDienThoaiKhach});
        gl_pn_QL_NV.linkSize(SwingConstants.VERTICAL, new Component[] {cbo_MaHD, cbo_TenNV, cbo_Ngay, cbo_Thang, cbo_Nam, cbo_TenKH, cbo_TongTien, cbo_SoDienThoai});
        gl_pn_QL_NV.linkSize(SwingConstants.HORIZONTAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        pn_QL_NV.setLayout(gl_pn_QL_NV);
        setting();
        addAction();
        settingTable();
    }// </editor-fold>//GEN-END:initComponents
    private void addAction()
    {
    	btn_XoaTrang.addActionListener(this);
    	btn_TimKiem.addActionListener(this);
    	tbl_DSHD.addMouseListener(this);
    	resetTable_HD();
    }
    private void addComboBox()
    {
    	
    }
    private void resetTable_HD()
    {
    	dtm_HD.setRowCount(0);
    	sqlHoaDon_BUS.xuat_DanhSach_HoaDon(dtm_HD);
    }
    private void xoaTrang()
    {	
    	
    	cbo_TenNV.setSelectedItem(null);
    	cbo_MaHD.setSelectedItem(null);
    	cbo_TenKH.setSelectedItem(null);
    	//cbo_TenNVNhanVien.setSelectedItem("");
    	cbo_SoDienThoai.setSelectedItem(null);
    	cbo_TongTien.setSelectedItem(null);
    	cbo_Ngay.setSelectedItem(null);
    	cbo_Thang.setSelectedItem(null);
    	cbo_Nam.setSelectedItem(null);
    	dtm_CTHD.setRowCount(0);
    	
    }
    private void setting() {
    	settingModel = new SettingModel();
    	try {
			settingModel.readFrom();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	settingLanguage();
    }
    private void settingTable() {
		if(settingModel.getNgonNgu().equals("English"))
			for (int i = 0; i < tbl_DSHD.getRowCount(); i++) {
				if(tbl_DSHD.getModel().getValueAt(i, 3).toString().equals("Nam"))
					tbl_DSHD.getModel().setValueAt("Male",i, 3);
				if(tbl_DSHD.getModel().getValueAt(i, 3).toString().equals("Nữ"))
					tbl_DSHD.getModel().setValueAt("Female",i, 3);
			}
	}
	private void settingLanguage() {
		// TODO Auto-generated method stub
    	if(settingModel.getNgonNgu().equals("Vietnamese")) {
    		lbl_Title_TK_HD.setText("Tìm kiếm hóa đơn");
    		lbl_MaHD.setText("Mã hóa đơn");
    		lbl_HoTenNhanVien.setText("Họ tên nhân viên");
    		lbl_HoTenKhachHang.setText("Họ tên khách hàng");
    		lbl_NgayLap.setText("Ngày lập");
    		lbl_TongTien.setText("Tổng tiền");
    		lbl_SoDienThoaiKhach.setText("SĐT khách");
    		btn_XoaTrang.setText("Xóa trắng");
    		btn_TimKiem.setText("Tìm kiếm");
    		lbl_Title_DSHD.setText("Danh sách hóa đơn");
    		tbl_DSHD.getColumnModel().getColumn(0).setHeaderValue("Mã hóa đơn");
    		tbl_DSHD.getColumnModel().getColumn(1).setHeaderValue("Họ tên nhân viên");
    		tbl_DSHD.getColumnModel().getColumn(2).setHeaderValue("Họ tên khách hàng");
    		tbl_DSHD.getColumnModel().getColumn(3).setHeaderValue("SĐT khách");
    		tbl_DSHD.getColumnModel().getColumn(4).setHeaderValue("Ngày lập");
    		tbl_DSHD.getColumnModel().getColumn(5).setHeaderValue("Tổng tiền");
    		lbl_Title_DSCTHD.setText("Danh sách chi tiết hóa đơn");
    		tbl_DSCTHD.getColumnModel().getColumn(0).setHeaderValue("Mã sản phẩm");
    		tbl_DSCTHD.getColumnModel().getColumn(1).setHeaderValue("Tên sản phẩm");
    		tbl_DSCTHD.getColumnModel().getColumn(2).setHeaderValue("Đơn giá");
    		tbl_DSCTHD.getColumnModel().getColumn(3).setHeaderValue("Số lượng mua");
    		tbl_DSCTHD.getColumnModel().getColumn(4).setHeaderValue("Thành tiền");
    	}
    	if(settingModel.getNgonNgu().equals("English")) {
    		lbl_Title_TK_HD.setText("Bill searching");
    		lbl_MaHD.setText("Bill number");
    		lbl_HoTenNhanVien.setText("Employee full name");
    		lbl_HoTenKhachHang.setText("Customer full name");
    		lbl_NgayLap.setText("Invoice date");
    		lbl_TongTien.setText("Total due");
    		lbl_SoDienThoaiKhach.setText("Customer phone");
    		btn_XoaTrang.setText("Refresh");
    		btn_TimKiem.setText("Search");
    		lbl_Title_DSHD.setText("Bills list");
    		tbl_DSHD.getColumnModel().getColumn(0).setHeaderValue("Bill number");
    		tbl_DSHD.getColumnModel().getColumn(1).setHeaderValue("Employee full name");
    		tbl_DSHD.getColumnModel().getColumn(2).setHeaderValue("Customer full name");
    		tbl_DSHD.getColumnModel().getColumn(3).setHeaderValue("Customer phone");
    		tbl_DSHD.getColumnModel().getColumn(4).setHeaderValue("Invoice date");
    		tbl_DSHD.getColumnModel().getColumn(5).setHeaderValue("Total due");
    		lbl_Title_DSCTHD.setText("Bills detail list");
    		tbl_DSCTHD.getColumnModel().getColumn(0).setHeaderValue("Product number");
    		tbl_DSCTHD.getColumnModel().getColumn(1).setHeaderValue("Product name");
    		tbl_DSCTHD.getColumnModel().getColumn(2).setHeaderValue("Price");
    		tbl_DSCTHD.getColumnModel().getColumn(3).setHeaderValue("Quantity");
    		tbl_DSCTHD.getColumnModel().getColumn(4).setHeaderValue("Amount");
    	}	
    }



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btn_XoaTrang))
		{
			xoaTrang();
		}
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row=tbl_DSHD.getSelectedRow();
		String maHD=tbl_DSHD.getValueAt(row, 0).toString();
		String tenNV=tbl_DSHD.getValueAt(row, 1).toString();
		String tenKH=tbl_DSHD.getValueAt(row, 2).toString();
		String sdt=tbl_DSHD.getValueAt(row, 3).toString();
		String tongTien=tbl_DSHD.getValueAt(row, 5).toString();
		//
		try
		{
			dtm_CTHD.setRowCount(0);
			sqlCTHoaDon_BUS.xuat_CTHoaDon_TheoMa(maHD, dtm_CTHD);
		}catch(DateTimeException dx)
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
			JOptionPane.showMessageDialog(null, dx.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
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
}
