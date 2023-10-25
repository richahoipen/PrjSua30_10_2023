package gui_Panel;

import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.toedter.calendar.JDateChooser;

import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import customEntities.CustomFunction;
import customEntities.CustomIcon;
import customEntities.Custom_Table;
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
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;

public class Panel_TimKiemDonDat extends JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_TK_HD,pn_Table_DSNV;
	private JLabel lbl_Title_TK_DD,lbl_Title_DSDD;
	private JLabel lbl_MaDD,lbl_HoTenNhanVien,lbl_TongTien,lbl_NgayDat,lbl_HoTenKhachHang,lbl_SoDienThoaiKhach;
	private Custom_ComboBox cbo_MaDD,cbo_TongTien;
	private Custom_ComboBox cbo_HoTenNhanVien,cbo_HoTenKhachHang,cbo_Ngay,cbo_Thang,cbo_Nam,cbo_SoDienThoai;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_Button btn_TimKiem,btn_XoaTrang;
	private Custom_Table tbl_DSHD,tbl_DSCTHD;
	private DefaultTableModel dtm_SP;
	private JScrollPane scr_DSCTHD,scr_DSHD;
    // End of variables declaration//GEN-END:variables
    public Panel_TimKiemDonDat() {
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
    	lbl_Title_TK_DD = new JLabel("Tìm kiếm đơn đặt");
    	lbl_Title_TK_DD.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_TK_DD.setForeground(new Color(0, 0, 255));
		lbl_Title_TK_DD.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_TK_DD.setBounds(30,100,2500,50);
		
    	pn_TK_HD = new JPanel();
		pn_TK_HD.setIgnoreRepaint(true);
		pn_TK_HD.setBackground(Color.white);
		pn_TK_HD.setBorder(new LineBorder(Custom_ColorPicker.lightgrey_D9D9D9, 3));
		
		lbl_MaDD = new JLabel("Mã đơn đặt:");
		lbl_MaDD.setForeground(Color.black);
		lbl_MaDD.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_HoTenNhanVien = new JLabel("Họ tên nhân viên:");
		lbl_HoTenNhanVien.setForeground(Color.black);
		lbl_HoTenNhanVien.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_TongTien = new JLabel("Tổng tiền:");
		lbl_TongTien.setForeground(Color.black);
		lbl_TongTien.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_NgayDat = new JLabel("Ngày đặt:");
		lbl_NgayDat.setForeground(Color.black);
		lbl_NgayDat.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_HoTenKhachHang = new JLabel("Họ tên khách hàng:");
		lbl_HoTenKhachHang.setForeground(Color.black);
		lbl_HoTenKhachHang.setFont(new Font("Inter", Font.PLAIN, 14));
		
		lbl_SoDienThoaiKhach = new JLabel("Số điện thoại khách:");
		lbl_SoDienThoaiKhach.setForeground(Color.black);
		lbl_SoDienThoaiKhach.setFont(new Font("Inter", Font.PLAIN, 14));
		
		cbo_MaDD = new Custom_ComboBox();
		cbo_MaDD.setForeground(Color.black);
		cbo_MaDD.setBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_MaDD.setOpaque(true);
		cbo_MaDD.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_HoTenNhanVien = new Custom_ComboBox();
		cbo_HoTenNhanVien.setForeground(Color.black);
		cbo_HoTenNhanVien.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
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
		
		cbo_TongTien = new Custom_ComboBox();
		cbo_TongTien.setForeground(Color.black);
		cbo_TongTien.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_TongTien.setColor_Foreground(Color.black);
		cbo_TongTien.setColor_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_TongTien.setColor_Hightlight(Custom_ColorPicker.lightgrey_D9D9D9);
		cbo_TongTien.setColor_Over(Custom_ColorPicker.snowwhite_F2F0EB);
		cbo_TongTien.redraw_Custom_Combobox();
		cbo_TongTien.setRadius(0);
		
		cbo_HoTenKhachHang = new Custom_ComboBox();
		cbo_HoTenKhachHang.setForeground(Color.black);
		cbo_HoTenKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		cbo_SoDienThoai = new Custom_ComboBox();
		cbo_SoDienThoai.setForeground(Color.black);
		cbo_SoDienThoai.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		
		lbl_Title_DSDD = new JLabel("Danh sách đơn đặt");
		lbl_Title_DSDD.setForeground(Color.BLUE);
		lbl_Title_DSDD.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		dtm_SP = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Loại sản phẩm","Ngôn ngữ","Nhà cung cấp","Nhà xuất bản","Năm xuất bản","Tác giả","Số lượng còn","Số lượng bán","Giá Nhập","Giá Bán"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_SP.addRow(new String[] {"SP0001","199 Đề Và Bài Văn Hay 9","Sách kham khảo","Tiếng Việt","Dn Tư Nhân Thương Mại Toàn Phúc","NXB Đại Học Quốc Gia Hà Nội","2018","	Phạm Ngọc Thắm","455","65","44.000đ","50.000đ"});
		}
		
		tbl_DSHD = new Custom_Table();
		tbl_DSHD.setModel(dtm_SP);
		//tbl_DSHD.setFont(new Font("Times New Roman", Font.PLAIN, 5));
		
		tbl_DSCTHD = new Custom_Table();
		tbl_DSCTHD.setModel(dtm_SP);

		//tbl_DSCTHD.setFont(new Font("Times New Roman", Font.PLAIN, 5));
		JScrollPane scr_DSHD = new JScrollPane(tbl_DSHD);
		
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
		
		JLabel lbl_Title_DSCDD = new JLabel("Danh sách chi tiết đơn đặt");
		lbl_Title_DSCDD.setForeground(Color.BLUE);
		lbl_Title_DSCDD.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		
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
									.addComponent(lbl_Title_DSDD)
									.addComponent(scr_DSHD, GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
									.addComponent(lbl_Title_DSCDD, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
								.addComponent(pn_TK_HD, GroupLayout.PREFERRED_SIZE, 994, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_Title_TK_DD)))))
					.addGap(0))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lbl_Title_TK_DD)
					.addGap(1)
					.addComponent(pn_TK_HD, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_DSDD)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSHD, GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
					.addGap(11)
					.addComponent(lbl_Title_DSCDD, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSCTHD, GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
					.addContainerGap())
		);
        this.setLayout(layout);
        
        
        
        GroupLayout gl_pn_TK_HD = new GroupLayout(pn_TK_HD);
        gl_pn_TK_HD.setHorizontalGroup(
        	gl_pn_TK_HD.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_pn_TK_HD.createSequentialGroup()
        			.addGroup(gl_pn_TK_HD.createParallelGroup(Alignment.TRAILING)
        				.addGroup(gl_pn_TK_HD.createSequentialGroup()
        					.addGap(349)
        					.addComponent(lbl_NgayDat, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_pn_TK_HD.createSequentialGroup()
        					.addGap(45)
        					.addGroup(gl_pn_TK_HD.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(lbl_MaDD, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lbl_HoTenNhanVien, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        					.addGap(6)
        					.addGroup(gl_pn_TK_HD.createParallelGroup(Alignment.LEADING)
        						.addComponent(cbo_MaDD, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
        						.addComponent(cbo_HoTenNhanVien, GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lbl_TongTien)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_TK_HD.createParallelGroup(Alignment.LEADING)
        				.addComponent(cbo_TongTien, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
        				.addGroup(gl_pn_TK_HD.createSequentialGroup()
        					.addComponent(cbo_Ngay, GroupLayout.PREFERRED_SIZE, 66, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(cbo_Thang, GroupLayout.PREFERRED_SIZE, 67, Short.MAX_VALUE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(cbo_Nam, GroupLayout.PREFERRED_SIZE, 68, Short.MAX_VALUE)))
        			.addGap(34)
        			.addGroup(gl_pn_TK_HD.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(lbl_SoDienThoaiKhach, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addComponent(lbl_HoTenKhachHang, GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_TK_HD.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_TK_HD.createSequentialGroup()
        					.addGroup(gl_pn_TK_HD.createParallelGroup(Alignment.LEADING)
        						.addComponent(cbo_SoDienThoai, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
        						.addComponent(cbo_HoTenKhachHang, GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
        					.addGap(0))
        				.addGroup(gl_pn_TK_HD.createSequentialGroup()
        					.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(18)
        					.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)))
        			.addGap(18))
        );
        gl_pn_TK_HD.setVerticalGroup(
        	gl_pn_TK_HD.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_pn_TK_HD.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_pn_TK_HD.createParallelGroup(Alignment.LEADING)
        				.addComponent(cbo_MaDD, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_Ngay, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_Thang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbo_Nam, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbl_MaDD)
        				.addGroup(gl_pn_TK_HD.createParallelGroup(Alignment.BASELINE)
        					.addComponent(lbl_HoTenKhachHang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addComponent(cbo_HoTenKhachHang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        				.addComponent(lbl_NgayDat, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(gl_pn_TK_HD.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_pn_TK_HD.createSequentialGroup()
        					.addGroup(gl_pn_TK_HD.createParallelGroup(Alignment.LEADING)
        						.addComponent(cbo_TongTien, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_TongTien, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(cbo_HoTenNhanVien, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbl_HoTenNhanVien)
        						.addComponent(cbo_SoDienThoai, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(gl_pn_TK_HD.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btn_TimKiem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(lbl_SoDienThoaiKhach, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap())
        );
        gl_pn_TK_HD.linkSize(SwingConstants.VERTICAL, new Component[] {cbo_MaDD, cbo_HoTenNhanVien, cbo_Ngay, cbo_Thang, cbo_Nam, cbo_TongTien, cbo_HoTenKhachHang, cbo_SoDienThoai});
        gl_pn_TK_HD.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_TongTien, lbl_NgayDat, lbl_HoTenKhachHang, lbl_SoDienThoaiKhach});
        gl_pn_TK_HD.linkSize(SwingConstants.VERTICAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        gl_pn_TK_HD.linkSize(SwingConstants.HORIZONTAL, new Component[] {btn_TimKiem, btn_XoaTrang});
        pn_TK_HD.setLayout(gl_pn_TK_HD);
    }// </editor-fold>//GEN-END:initComponents
}
