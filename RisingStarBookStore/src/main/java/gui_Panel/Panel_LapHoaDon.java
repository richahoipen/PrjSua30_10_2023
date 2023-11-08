package gui_Panel;

import com.oracle.javafx.scenebuilder.kit.util.control.paintpicker.colorpicker.ColorPicker;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.toedter.calendar.JDateChooser;

import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import customEntities.CustomFunction;
import customEntities.CustomIcon;
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

import org.hibernate.type.CustomType;

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
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;

public class Panel_LapHoaDon extends JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_Table_DSNV;
	private JLabel lbl_Title_DS_DD,lbl_Title_DSCTHD;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private CustomTable tbl_DSHD,tbl_DSCTHD,tbl_DSSP;
	private DefaultTableModel dtm_SP;
	private JScrollPane scr_DSCTHD;
	private JLabel lbl_Title_DanhSachSanPham;
	private JLabel lbl_Title_LapHoaDon;
	private Custom_Button btnTraKhachHang,btnLapHoaDon;
	private Custom_ComboBox cbo_TraKhachHang;
	private JPanel pnLapHoaDon;
	private JLabel lbl_TraKhachHang;
	private JLabel lbl_HoTenKhachHang;
	private JLabel lbl_GioiTinh;
	private JLabel lbl_SoDienThoai;
	private JLabel lbl_TongTien;
	private JLabel lbl_TienKhachTra;
	private JLabel lbl_TienThoi;
	private JLabel lbl_txt_HoTenKhachHang;
	private JLabel lbl_txt_GioiTinh;
	private JLabel lbl_txt_SoDienThoai;
	private JLabel lbl_txt_TongTien;
	private JTextField txt_SoTienKhachTra;
	private JLabel lbl_txt_TienThoi;
	private JScrollPane scr_DSHD;
	private JLabel lbl_Title_DSHD;
    // End of variables declaration//GEN-END:variables
    public Panel_LapHoaDon() {
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
    	lbl_Title_DS_DD = new JLabel("Danh sách đơn đặt chưa thanh toán");
    	lbl_Title_DS_DD.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_DS_DD.setForeground(new Color(0, 0, 255));
		lbl_Title_DS_DD.setFont(new Font("SansSerif", Font.BOLD, 12));
		lbl_Title_DS_DD.setBounds(30,100,2500,50);
		lbl_Title_DS_DD.setForeground(Custom_ColorPicker.darkblue_4F709C);
		
		String[] string_NgayTrongThang = new String[31];
		for (int i = 0; i < 31; i++) {
			string_NgayTrongThang[i] = String.format("%02d",i+1);
		}
		
		String[] string_ThangTrongNam = new String[12];
		for (int i = 0; i < 12; i++) {
			string_ThangTrongNam[i] = String.format("%02d",i+1);
		}
		
		String[] string_Nam = new String[1500];
		LocalDate ngayHienTai = LocalDate.now(); 
		int namHienTai = ngayHienTai.getYear();
		for (int i = 0; i < 1500; i++) {
			string_Nam[i] = String.format("%04d",namHienTai-i);
		}
		
		dtm_SP = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Loại sản phẩm","Ngôn ngữ","Nhà cung cấp","Nhà xuất bản","Năm xuất bản","Tác giả","Số lượng còn","Số lượng bán","Giá Nhập","Giá Bán"},0);
		for (int i = 0; i < 1000; i++) {
			dtm_SP.addRow(new String[] {"SP0001","199 Đề Và Bài Văn Hay 9","Sách kham khảo","Tiếng Việt","Dn Tư Nhân Thương Mại Toàn Phúc","NXB Đại Học Quốc Gia Hà Nội","2018","	Phạm Ngọc Thắm","455","65","44.000đ","50.000đ"});
		}
		
		tbl_DSHD = new CustomTable();
		tbl_DSHD.setModel(dtm_SP);
		tbl_DSCTHD = new CustomTable();
		tbl_DSCTHD.setModel(dtm_SP);
		JScrollPane scr_DSDD = new JScrollPane(tbl_DSHD);
		
		JScrollPane scr_DSCTHD = new JScrollPane(tbl_DSCTHD);
		
		lbl_Title_DSCTHD = new JLabel("Danh sách chi tiết hóa đơn");
		lbl_Title_DSCTHD.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_DSCTHD.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lbl_Title_DanhSachSanPham = new JLabel("Danh sách sản phẩm");
		lbl_Title_DanhSachSanPham.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_DanhSachSanPham.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lbl_Title_LapHoaDon = new JLabel("Lập hóa đơn");
		lbl_Title_LapHoaDon.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_LapHoaDon.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_LapHoaDon.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		pnLapHoaDon = new JPanel();
		pnLapHoaDon.setBackground(Color.WHITE);
		
		tbl_DSSP = new CustomTable();
		tbl_DSSP.setModel(dtm_SP);
		JScrollPane scr_DSSP = new JScrollPane(tbl_DSSP);
		
		scr_DSHD = new JScrollPane((Component) null);
		
		lbl_Title_DSHD = new JLabel("Danh sách hóa đơn");
		lbl_Title_DSHD.setForeground(new Color(79, 112, 156));
		lbl_Title_DSHD.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(scr_DSDD, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
								.addComponent(scr_DSCTHD, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
								.addComponent(scr_DSSP, GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
								.addGroup(layout.createSequentialGroup()
									.addGroup(layout.createParallelGroup(Alignment.LEADING)
										.addComponent(lbl_Title_DS_DD)
										.addComponent(lbl_Title_DanhSachSanPham, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
									.addPreferredGap(ComponentPlacement.RELATED, 147, Short.MAX_VALUE)))
							.addGap(10))
						.addGroup(layout.createSequentialGroup()
							.addComponent(lbl_Title_DSCTHD, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addGap(184)))
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(scr_DSHD, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
						.addComponent(lbl_Title_LapHoaDon, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnLapHoaDon, GroupLayout.DEFAULT_SIZE, 406, Short.MAX_VALUE)
						.addComponent(lbl_Title_DSHD, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbl_Title_LapHoaDon, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnLapHoaDon, 0, 0, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
							.addGap(12)
							.addComponent(lbl_Title_DS_DD)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scr_DSDD, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_Title_DanhSachSanPham, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scr_DSSP, GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_Title_DSCTHD, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_Title_DSHD, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scr_DSHD, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
						.addComponent(scr_DSCTHD, GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		lbl_TraKhachHang = new JLabel("Tra khách hàng:");
		lbl_TraKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		lbl_HoTenKhachHang = new JLabel("Họ tên khách hàng:");
		lbl_HoTenKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		lbl_TongTien = new JLabel("Tổng tiền:");
		lbl_TongTien.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		lbl_TienKhachTra = new JLabel("Tiền khách trả:");
		lbl_TienKhachTra.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		lbl_TienThoi = new JLabel("Tiền thối:");
		lbl_TienThoi.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		cbo_TraKhachHang = new Custom_ComboBox();
		
		btnTraKhachHang = new Custom_Button();
		btnTraKhachHang.setText("Tra");
		btnTraKhachHang.setFont(new Font("Dialog", Font.BOLD, 12));
		
		lbl_txt_HoTenKhachHang = new JLabel("");
		lbl_txt_HoTenKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbl_txt_HoTenKhachHang.setBackground(Custom_ColorPicker.snowwhite_F2F0EB);
		lbl_txt_HoTenKhachHang.setOpaque(true);
		
		lbl_txt_GioiTinh = new JLabel("");
		lbl_txt_GioiTinh.setOpaque(true);
		lbl_txt_GioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbl_txt_GioiTinh.setBackground(new Color(242, 240, 235));
		
		lbl_txt_SoDienThoai = new JLabel("");
		lbl_txt_SoDienThoai.setOpaque(true);
		lbl_txt_SoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbl_txt_SoDienThoai.setBackground(new Color(242, 240, 235));
		
		lbl_txt_TongTien = new JLabel("");
		lbl_txt_TongTien.setOpaque(true);
		lbl_txt_TongTien.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbl_txt_TongTien.setBackground(new Color(242, 240, 235));
		
		txt_SoTienKhachTra = new JTextField("");
		txt_SoTienKhachTra.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		lbl_txt_TienThoi = new JLabel("");
		lbl_txt_TienThoi.setOpaque(true);
		lbl_txt_TienThoi.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbl_txt_TienThoi.setBackground(new Color(242, 240, 235));
		
		btnLapHoaDon = new Custom_Button();
		btnLapHoaDon.setText("Lập hóa đơn");
		btnLapHoaDon.setFont(new Font("Dialog", Font.BOLD, 12));
		
		Custom_Button btnInHoaDon = new Custom_Button();
		btnInHoaDon.setText("In hóa đơn");
		btnInHoaDon.setFont(new Font("Dialog", Font.BOLD, 12));
		GroupLayout gl_pnLapHoaDon = new GroupLayout(pnLapHoaDon);
		gl_pnLapHoaDon.setHorizontalGroup(
			gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLapHoaDon.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnLapHoaDon.createSequentialGroup()
							.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lbl_HoTenKhachHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lbl_TraKhachHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lbl_GioiTinh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lbl_SoDienThoai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lbl_TongTien, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_TienKhachTra, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_TienThoi, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_txt_TienThoi, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
								.addComponent(txt_SoTienKhachTra, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
								.addComponent(lbl_txt_TongTien, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
								.addComponent(lbl_txt_SoDienThoai, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
								.addComponent(lbl_txt_GioiTinh, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
								.addGroup(gl_pnLapHoaDon.createSequentialGroup()
									.addComponent(cbo_TraKhachHang, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
									.addGap(13)
									.addComponent(btnTraKhachHang, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addComponent(lbl_txt_HoTenKhachHang, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_pnLapHoaDon.createSequentialGroup()
							.addComponent(btnInHoaDon, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnLapHoaDon, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(6))))
		);
		gl_pnLapHoaDon.setVerticalGroup(
			gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLapHoaDon.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.BASELINE)
							.addComponent(lbl_TraKhachHang)
							.addComponent(cbo_TraKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnTraKhachHang, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lbl_txt_HoTenKhachHang, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_HoTenKhachHang, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_GioiTinh, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_txt_GioiTinh, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_txt_SoDienThoai, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_TongTien, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_txt_TongTien, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_TienKhachTra, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(txt_SoTienKhachTra, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_TienThoi, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_txt_TienThoi, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLapHoaDon, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInHoaDon, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(86))
		);
		gl_pnLapHoaDon.linkSize(SwingConstants.VERTICAL, new Component[] {cbo_TraKhachHang, btnTraKhachHang, lbl_txt_HoTenKhachHang, lbl_txt_GioiTinh, lbl_txt_SoDienThoai, lbl_txt_TongTien, txt_SoTienKhachTra, lbl_txt_TienThoi});
		gl_pnLapHoaDon.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_TraKhachHang, lbl_HoTenKhachHang, lbl_GioiTinh, lbl_SoDienThoai, lbl_TongTien, lbl_TienKhachTra, lbl_TienThoi});
		pnLapHoaDon.setLayout(gl_pnLapHoaDon);
        this.setLayout(layout);
        
        
    }// </editor-fold>//GEN-END:initComponents
}
