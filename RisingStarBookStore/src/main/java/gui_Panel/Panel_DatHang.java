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

public class Panel_DatHang extends JPanel {
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_Table_DSNV;
	private Custom_JLabel picture_Logo;
	private JLabel lbl_Title_DSCTDD;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_Table tbl_DSCTDD;
	private DefaultTableModel dtm_SP;
	private JScrollPane scr_DSCTHD,scr_DSHD;
	private JLabel lbl_Title_TraSanPham;
	private JLabel lblTra;
	private JLabel lblHinhAnh;
	private JLabel lblTenSanPham;
	private JLabel lblSoLuongBan;
	private JLabel lblGia;
	private JLabel lbl_Title_DatHang;
	private Custom_Button btnThem,btnTraCuuSanPham,btnTraKhachHang,btnDatHang;
	private Custom_ComboBox cbo_TraCuuSanPham,cbo_TraKhachHang;
	private JPanel pnLapDatHang;
	private JLabel lbl_TraKhachHang;
	private JLabel lbl_HoTenKhachHang;
	private JLabel lbl_GioiTinh;
	private JLabel lbl_SoDienThoai;
	private JLabel lbl_TongTien;
	private JLabel lbl_txt_HoTenKhachHang;
	private JLabel lbl_txt_GioiTinh;
	private JLabel lbl_txt_SoDienThoai;
	private JLabel lbl_txt_TongTien;
	private JPanel pnTraSanPham;
    // End of variables declaration//GEN-END:variables
    public Panel_DatHang() {
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
		
		tbl_DSCTDD = new Custom_Table(dtm_SP);
		tbl_DSCTDD.setColor_StripeBackground(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSCTDD.setColor_Header_Foreground(Color.BLACK);
		//tbl_DSCTHD.setFont(new Font("Times New Roman", Font.PLAIN, 5));
		tbl_DSCTDD.setColor_Header_Background(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSCTDD.setColor_Border(Custom_ColorPicker.lightgrey_D9D9D9);
		tbl_DSCTDD.align(2,new int[] {6,8,9,10,11});
		tbl_DSCTDD.redrawn_Custom_Table();
		
		JScrollPane scr_DSCTDD = new JScrollPane(tbl_DSCTDD);
		
		lbl_Title_DSCTDD = new JLabel("Danh sách chi tiết đơn đặt");
		lbl_Title_DSCTDD.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_DSCTDD.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lbl_Title_TraSanPham = new JLabel("Tra sản phẩm");
		lbl_Title_TraSanPham.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_TraSanPham.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		pnTraSanPham = new JPanel();
		pnTraSanPham.setBackground(new Color(255, 255, 255));
		
		lbl_Title_DatHang = new JLabel("Đặt hàng");
		lbl_Title_DatHang.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_DatHang.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_DatHang.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		pnLapDatHang = new JPanel();
		pnLapDatHang.setBackground(Color.WHITE);
		
		
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(pnLapDatHang, GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
							.addGap(10)
							.addComponent(lbl_Title_TraSanPham, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(scr_DSCTDD, GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
								.addComponent(lbl_Title_DatHang, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_Title_DSCTDD, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.LEADING, layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(pnTraSanPham, GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(lbl_Title_DatHang, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnLapDatHang, GroupLayout.PREFERRED_SIZE, 243, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_DSCTDD, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSCTDD, GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
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
		
		btnDatHang = new Custom_Button();
		btnDatHang.setText("Đặt hàng");
		btnDatHang.setFont(new Font("Dialog", Font.BOLD, 12));
		GroupLayout gl_pnLapDatHang = new GroupLayout(pnLapDatHang);
		gl_pnLapDatHang.setHorizontalGroup(
			gl_pnLapDatHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLapDatHang.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnLapDatHang.createSequentialGroup()
							.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.LEADING, false)
									.addComponent(lbl_HoTenKhachHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lbl_TraKhachHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lbl_GioiTinh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lbl_SoDienThoai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lbl_TongTien, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_txt_TongTien, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
								.addComponent(lbl_txt_SoDienThoai, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
								.addComponent(lbl_txt_GioiTinh, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
								.addGroup(gl_pnLapDatHang.createSequentialGroup()
									.addComponent(cbo_TraKhachHang, GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE)
									.addGap(13)
									.addComponent(btnTraKhachHang, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addComponent(lbl_txt_HoTenKhachHang, GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)))
						.addComponent(btnDatHang, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_pnLapDatHang.setVerticalGroup(
			gl_pnLapDatHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLapDatHang.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.BASELINE)
							.addComponent(lbl_TraKhachHang)
							.addComponent(cbo_TraKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnTraKhachHang, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lbl_txt_HoTenKhachHang, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_HoTenKhachHang, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_GioiTinh, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_txt_GioiTinh, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbl_SoDienThoai, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_txt_SoDienThoai, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_TongTien, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbl_txt_TongTien, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnDatHang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(336, Short.MAX_VALUE))
		);
		gl_pnLapDatHang.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_TraKhachHang, lbl_HoTenKhachHang, lbl_GioiTinh, lbl_SoDienThoai, lbl_TongTien});
		gl_pnLapDatHang.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_txt_TongTien, cbo_TraKhachHang, btnTraKhachHang, lbl_txt_HoTenKhachHang, lbl_txt_GioiTinh, lbl_txt_SoDienThoai});
		pnLapDatHang.setLayout(gl_pnLapDatHang);
		
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
