package gui_Panel;

import com.oracle.javafx.scenebuilder.kit.util.control.paintpicker.colorpicker.ColorPicker;
import com.raven.swing.icon.GoogleMaterialDesignIcons;
import com.raven.swing.icon.IconFontSwing;
import com.toedter.calendar.JDateChooser;

import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import customEntities.Custom_Function;
import customEntities.Custom_ImageIcon;
import customEntities.Custom_JLabel;
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
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;

public class Panel_LapHoaDon extends JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_Table_DSNV;
	private Custom_JLabel picture_Logo;
	private JLabel lbl_Title_DS_DD,lbl_Title_DSCTHD;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_Table tbl_DSHD,tbl_DSCTHD;
	private DefaultTableModel dtm_SP;
	private JScrollPane scr_DSCTHD,scr_DSHD;
	private JLabel lbl_Title_TraSanPham;
	private JLabel lblTra;
	private JLabel lblHinhAnh;
	private JLabel lblTenSanPham;
	private JLabel lblSoLuongBan;
	private JLabel lblGia;
	private JRadioButton rdbtnInHoaDon;
	private JLabel lbl_Title_LapHoaDon;
	private Custom_Button btnThem,btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnXoaTrang,btnQuaTrai,btnQuaPhai,btnXoaKyTu,btnTraCuuSanPham,btnTraKhachHang,btnLapHoaDon;
	private Custom_ComboBox cbo_TraCuuSanPham,cbo_TraKhachHang;
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
	private JPanel pnPhimSo;
	private JPanel pnTraSanPham;
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
		
		tbl_DSHD = new Custom_Table(dtm_SP);
		tbl_DSHD.setColor_StripeBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSHD.setColor_Header_Foreground(Color.BLACK);
		//tbl_DSHD.setFont(new Font("Times New Roman", Font.PLAIN, 5));
		tbl_DSHD.setColor_Header_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSHD.setColor_Border(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSHD.align(2,new int[] {6,8,9,10,11});
		tbl_DSHD.redrawn_Custom_Table();
		
		tbl_DSCTHD = new Custom_Table(dtm_SP);
		tbl_DSCTHD.setColor_StripeBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSCTHD.setColor_Header_Foreground(Color.BLACK);
		//tbl_DSCTHD.setFont(new Font("Times New Roman", Font.PLAIN, 5));
		tbl_DSCTHD.setColor_Header_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSCTHD.setColor_Border(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSCTHD.align(2,new int[] {6,8,9,10,11});
		tbl_DSCTHD.redrawn_Custom_Table();
		JScrollPane scr_DSHD = new JScrollPane(tbl_DSHD);
		
		JScrollPane scr_DSCTHD = new JScrollPane(tbl_DSCTHD);
		
		lbl_Title_DSCTHD = new JLabel("Danh sách chi tiết hóa đơn");
		lbl_Title_DSCTHD.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_DSCTHD.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lbl_Title_TraSanPham = new JLabel("Tra sản phẩm");
		lbl_Title_TraSanPham.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_TraSanPham.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		pnTraSanPham = new JPanel();
		pnTraSanPham.setBackground(new Color(255, 255, 255));
		
		lbl_Title_LapHoaDon = new JLabel("Lập hóa đơn");
		lbl_Title_LapHoaDon.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_LapHoaDon.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_LapHoaDon.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		pnLapHoaDon = new JPanel();
		pnLapHoaDon.setBackground(Color.WHITE);
		
		
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(pnTraSanPham, GroupLayout.DEFAULT_SIZE, 948, Short.MAX_VALUE)
						.addComponent(lbl_Title_TraSanPham, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_Title_DSCTHD, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_Title_DS_DD)
								.addComponent(scr_DSHD, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
								.addComponent(scr_DSCTHD, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(pnLapHoaDon, GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
								.addComponent(lbl_Title_LapHoaDon, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lbl_Title_LapHoaDon, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(pnLapHoaDon, GroupLayout.PREFERRED_SIZE, 449, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(lbl_Title_DS_DD)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scr_DSHD, GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lbl_Title_DSCTHD, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scr_DSCTHD, GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_TraSanPham, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnTraSanPham, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
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
		
		pnPhimSo = new JPanel();
		pnPhimSo.setBackground(Custom_ColorPicker.darkblue_4F709C);
		
		rdbtnInHoaDon = new JRadioButton("In hóa đơn");
		
		btnLapHoaDon = new Custom_Button();
		btnLapHoaDon.setText("Lập hóa đơn");
		btnLapHoaDon.setFont(new Font("Dialog", Font.BOLD, 12));
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
								.addComponent(lbl_txt_TienThoi, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
								.addComponent(txt_SoTienKhachTra, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
								.addComponent(lbl_txt_TongTien, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
								.addComponent(lbl_txt_SoDienThoai, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
								.addComponent(lbl_txt_GioiTinh, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
								.addGroup(gl_pnLapHoaDon.createSequentialGroup()
									.addComponent(cbo_TraKhachHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(13)
									.addComponent(btnTraKhachHang, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addComponent(lbl_txt_HoTenKhachHang, GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_pnLapHoaDon.createSequentialGroup()
							.addComponent(rdbtnInHoaDon)
							.addGap(9)
							.addComponent(btnLapHoaDon, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addGap(6))
						.addGroup(gl_pnLapHoaDon.createSequentialGroup()
							.addComponent(pnPhimSo, GroupLayout.DEFAULT_SIZE, 324, Short.MAX_VALUE)
							.addContainerGap())))
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
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnPhimSo, GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnLapHoaDon.createSequentialGroup()
							.addGap(4)
							.addComponent(btnLapHoaDon, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnLapHoaDon.createSequentialGroup()
							.addGap(7)
							.addComponent(rdbtnInHoaDon, GroupLayout.PREFERRED_SIZE, 28, GroupLayout.PREFERRED_SIZE)))
					.addGap(86))
		);
		gl_pnLapHoaDon.linkSize(SwingConstants.VERTICAL, new Component[] {cbo_TraKhachHang, btnTraKhachHang, lbl_txt_HoTenKhachHang, lbl_txt_GioiTinh, lbl_txt_SoDienThoai, lbl_txt_TongTien, txt_SoTienKhachTra, lbl_txt_TienThoi});
		gl_pnLapHoaDon.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_TraKhachHang, lbl_HoTenKhachHang, lbl_GioiTinh, lbl_SoDienThoai, lbl_TongTien, lbl_TienKhachTra, lbl_TienThoi});
		GridBagLayout gbl_pnPhimSo = new GridBagLayout();
		gbl_pnPhimSo.columnWidths = new int[]{81, 81, 81, 81, 0};
		gbl_pnPhimSo.rowHeights = new int[]{29, 29, 29, 29, 0};
		gbl_pnPhimSo.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_pnPhimSo.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		pnPhimSo.setLayout(gbl_pnPhimSo);
		
		btnXoaTrang = new Custom_Button();
		btnXoaTrang.setText("C");
		GridBagConstraints gbc_btnXoaTrang = new GridBagConstraints();
		gbc_btnXoaTrang.fill = GridBagConstraints.BOTH;
		gbc_btnXoaTrang.insets = new Insets(0, 0, 5, 5);
		gbc_btnXoaTrang.gridx = 0;
		gbc_btnXoaTrang.gridy = 0;
		pnPhimSo.add(btnXoaTrang, gbc_btnXoaTrang);
		
		btnQuaTrai = new Custom_Button();
		btnQuaTrai.setText("<-");
		GridBagConstraints gbc_btnQuaTrai = new GridBagConstraints();
		gbc_btnQuaTrai.fill = GridBagConstraints.BOTH;
		gbc_btnQuaTrai.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuaTrai.gridx = 1;
		gbc_btnQuaTrai.gridy = 0;
		pnPhimSo.add(btnQuaTrai, gbc_btnQuaTrai);
		
		btnQuaPhai = new Custom_Button();
		btnQuaPhai.setText("->");
		GridBagConstraints gbc_btnQuaPhai = new GridBagConstraints();
		gbc_btnQuaPhai.fill = GridBagConstraints.BOTH;
		gbc_btnQuaPhai.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuaPhai.gridx = 2;
		gbc_btnQuaPhai.gridy = 0;
		pnPhimSo.add(btnQuaPhai, gbc_btnQuaPhai);
		
		btnXoaKyTu = new Custom_Button();
		btnXoaKyTu.setText("BackSpace");
		GridBagConstraints gbc_btnXoaKyTu = new GridBagConstraints();
		gbc_btnXoaKyTu.fill = GridBagConstraints.BOTH;
		gbc_btnXoaKyTu.insets = new Insets(0, 0, 5, 0);
		gbc_btnXoaKyTu.gridx = 3;
		gbc_btnXoaKyTu.gridy = 0;
		pnPhimSo.add(btnXoaKyTu, gbc_btnXoaKyTu);
		
		btn7 = new Custom_Button();
		btn7.setText("7");
		GridBagConstraints gbc_btn7 = new GridBagConstraints();
		gbc_btn7.fill = GridBagConstraints.BOTH;
		gbc_btn7.insets = new Insets(0, 0, 5, 5);
		gbc_btn7.gridx = 0;
		gbc_btn7.gridy = 1;
		pnPhimSo.add(btn7, gbc_btn7);
		
		btn8 = new Custom_Button();
		btn8.setText("8");
		GridBagConstraints gbc_btn8 = new GridBagConstraints();
		gbc_btn8.fill = GridBagConstraints.BOTH;
		gbc_btn8.insets = new Insets(0, 0, 5, 5);
		gbc_btn8.gridx = 1;
		gbc_btn8.gridy = 1;
		pnPhimSo.add(btn8, gbc_btn8);
		
		btn9 = new Custom_Button();
		btn9.setText("9");
		GridBagConstraints gbc_btn9 = new GridBagConstraints();
		gbc_btn9.fill = GridBagConstraints.BOTH;
		gbc_btn9.insets = new Insets(0, 0, 5, 5);
		gbc_btn9.gridx = 2;
		gbc_btn9.gridy = 1;
		pnPhimSo.add(btn9, gbc_btn9);
		
		btn0 = new Custom_Button();
		btn0.setText("0");
		GridBagConstraints gbc_btn0 = new GridBagConstraints();
		gbc_btn0.gridheight = 3;
		gbc_btn0.fill = GridBagConstraints.BOTH;
		gbc_btn0.insets = new Insets(0, 0, 5, 0);
		gbc_btn0.gridx = 3;
		gbc_btn0.gridy = 1;
		pnPhimSo.add(btn0, gbc_btn0);
		
		btn4 = new Custom_Button();
		btn4.setText("4");
		GridBagConstraints gbc_btn4 = new GridBagConstraints();
		gbc_btn4.fill = GridBagConstraints.BOTH;
		gbc_btn4.insets = new Insets(0, 0, 5, 5);
		gbc_btn4.gridx = 0;
		gbc_btn4.gridy = 2;
		pnPhimSo.add(btn4, gbc_btn4);
		
		btn5 = new Custom_Button();
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn5.setText("5");
		GridBagConstraints gbc_btn5 = new GridBagConstraints();
		gbc_btn5.fill = GridBagConstraints.BOTH;
		gbc_btn5.insets = new Insets(0, 0, 5, 5);
		gbc_btn5.gridx = 1;
		gbc_btn5.gridy = 2;
		pnPhimSo.add(btn5, gbc_btn5);
		
		btn6 = new Custom_Button();
		btn6.setText("6");
		GridBagConstraints gbc_btn6 = new GridBagConstraints();
		gbc_btn6.fill = GridBagConstraints.BOTH;
		gbc_btn6.insets = new Insets(0, 0, 5, 5);
		gbc_btn6.gridx = 2;
		gbc_btn6.gridy = 2;
		pnPhimSo.add(btn6, gbc_btn6);
		
		btn1 = new Custom_Button();
		btn1.setText("1");
		GridBagConstraints gbc_btn1 = new GridBagConstraints();
		gbc_btn1.fill = GridBagConstraints.BOTH;
		gbc_btn1.insets = new Insets(0, 0, 0, 5);
		gbc_btn1.gridx = 0;
		gbc_btn1.gridy = 3;
		pnPhimSo.add(btn1, gbc_btn1);
		
		btn2 = new Custom_Button();
		btn2.setText("2");
		GridBagConstraints gbc_btn2 = new GridBagConstraints();
		gbc_btn2.fill = GridBagConstraints.BOTH;
		gbc_btn2.insets = new Insets(0, 0, 0, 5);
		gbc_btn2.gridx = 1;
		gbc_btn2.gridy = 3;
		pnPhimSo.add(btn2, gbc_btn2);
		
		btn3 = new Custom_Button();
		btn3.setText("3");
		GridBagConstraints gbc_btn3 = new GridBagConstraints();
		gbc_btn3.fill = GridBagConstraints.BOTH;
		gbc_btn3.insets = new Insets(0, 0, 0, 5);
		gbc_btn3.gridx = 2;
		gbc_btn3.gridy = 3;
		pnPhimSo.add(btn3, gbc_btn3);
		pnLapHoaDon.setLayout(gl_pnLapHoaDon);
		
		lblTra = new JLabel("Tra cứu sản phẩm");
		lblTra.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		btnTraCuuSanPham = new Custom_Button();
		btnTraCuuSanPham.setText("Tra");
		btnTraCuuSanPham.setFont(new Font("Dialog", Font.BOLD, 12));
		
		btnThem = new Custom_Button();
		btnThem.setText("Thêm");
		btnThem.setFont(new Font("Dialog", Font.BOLD, 12));
		
		cbo_TraCuuSanPham = new Custom_ComboBox();
		cbo_TraCuuSanPham.setOpaque(true);
		cbo_TraCuuSanPham.setForeground(Color.BLACK);
		cbo_TraCuuSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		cbo_TraCuuSanPham.setBackground(new Color(217, 217, 217));
		
		lblHinhAnh = new JLabel();
		lblHinhAnh.setBackground(Color.LIGHT_GRAY);
		lblHinhAnh.setOpaque(true);
		
		lblTenSanPham = new JLabel("Bộ Tranh Tương Tác Cô Tiên Xanh - Nhà Hàng Pizza");
		lblTenSanPham.setFont(new Font("SansSerif", Font.BOLD, 14));
		
		lblSoLuongBan = new JLabel("Đã bán: 5");
		lblSoLuongBan.setHorizontalAlignment(SwingConstants.LEFT);
		lblSoLuongBan.setFont(new Font("SansSerif", Font.PLAIN, 14));
		
		lblGia = new JLabel("20.000đ");
		lblGia.setForeground(Color.RED);
		lblGia.setHorizontalAlignment(SwingConstants.LEFT);
		lblGia.setFont(new Font("SansSerif", Font.BOLD, 14));
		GroupLayout gl_pnTraSanPham = new GroupLayout(pnTraSanPham);
		gl_pnTraSanPham.setHorizontalGroup(
			gl_pnTraSanPham.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnTraSanPham.createSequentialGroup()
					.addGroup(gl_pnTraSanPham.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnTraSanPham.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnTraSanPham.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblHinhAnh, GroupLayout.PREFERRED_SIZE, 116, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTra))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnTraSanPham.createParallelGroup(Alignment.LEADING)
								.addComponent(lblGia, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSoLuongBan, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblTenSanPham, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)))
						.addGroup(gl_pnTraSanPham.createSequentialGroup()
							.addGap(132)
							.addComponent(cbo_TraCuuSanPham, GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnTraCuuSanPham, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
					.addGap(10))
		);
		gl_pnTraSanPham.setVerticalGroup(
			gl_pnTraSanPham.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnTraSanPham.createSequentialGroup()
					.addGroup(gl_pnTraSanPham.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_pnTraSanPham.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnTraSanPham.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnTraSanPham.createParallelGroup(Alignment.TRAILING)
									.addComponent(cbo_TraCuuSanPham, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addGroup(gl_pnTraSanPham.createSequentialGroup()
										.addComponent(lblTra)
										.addGap(8)))
								.addGroup(gl_pnTraSanPham.createParallelGroup(Alignment.BASELINE)
									.addComponent(btnTraCuuSanPham, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
									.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
							.addGap(18)
							.addComponent(lblTenSanPham, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(lblSoLuongBan, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblGia, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_pnTraSanPham.createSequentialGroup()
							.addGap(59)
							.addComponent(lblHinhAnh, GroupLayout.PREFERRED_SIZE, 112, GroupLayout.PREFERRED_SIZE)))
					.addGap(11))
		);
		pnTraSanPham.setLayout(gl_pnTraSanPham);
        this.setLayout(layout);
        
        
    }// </editor-fold>//GEN-END:initComponents
}
