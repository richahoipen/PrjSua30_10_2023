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
import customEntities.ScrollBarCustom;
import customEntities.Custom_Table;
import gui_Dialog.Message;
import gui_Frame_Running.*;

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
	private JLabel lbl_Title_DSSP;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private Custom_Table tbl_DSCTDD;
	private DefaultTableModel dtm_SP;
	private JScrollPane scr_DSSP,scr_DSDD;
	private JLabel lbl_Title_CTDD;
	private JLabel lbl_Title_DatHang;
	private Custom_Button btnTimKhachHang,btnDatHang;
	private Custom_ComboBox cbo_TraKhachHang;
	private JPanel pnLapDatHang;
	private JLabel lbl_TimKhachHang;
	private JLabel lbl_HoTenKhachHang;
	private JLabel lbl_GioiTinh;
	private JLabel lbl_SoDienThoai;
	private JLabel lbl_TongTien;
	private JLabel lbl_txt_HoTenKhachHang;
	private JLabel lbl_txt_GioiTinh;
	private JLabel lbl_txt_SoDienThoai;
	private JLabel lbl_txt_TongTien;
	private JScrollPane scr_DSCTDD;
	private Custom_Table tbl_DSSP;
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
		
		tbl_DSCTDD = new Custom_Table();
		tbl_DSCTDD.setModel(dtm_SP);
		
		scr_DSSP = new JScrollPane(tbl_DSCTDD);
		
		lbl_Title_DSSP = new JLabel("Danh sách sản phẩm");
		lbl_Title_DSSP.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_DSSP.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lbl_Title_CTDD = new JLabel("Chi tiết đơn đặt");
		lbl_Title_CTDD.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_CTDD.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lbl_Title_DatHang = new JLabel("Đặt hàng");
		lbl_Title_DatHang.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_DatHang.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_DatHang.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		pnLapDatHang = new JPanel();
		pnLapDatHang.setBackground(Color.WHITE);
		
		tbl_DSSP= new Custom_Table();
		tbl_DSSP.setModel(dtm_SP);
		scr_DSCTDD = new JScrollPane(tbl_DSSP);
		
		
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(pnLapDatHang, GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE))
						.addGroup(layout.createSequentialGroup()
							.addGap(10)
							.addComponent(lbl_Title_CTDD, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addComponent(scr_DSSP, GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)
								.addComponent(lbl_Title_DatHang, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbl_Title_DSSP, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createSequentialGroup()
							.addContainerGap()
							.addComponent(scr_DSCTDD, GroupLayout.DEFAULT_SIZE, 875, Short.MAX_VALUE)))
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
					.addComponent(lbl_Title_DSSP, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSSP, GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_CTDD, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSCTDD, GroupLayout.DEFAULT_SIZE, 242, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		lbl_TimKhachHang = new JLabel("Tìm khách hàng:");
		lbl_TimKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		lbl_HoTenKhachHang = new JLabel("Họ tên khách hàng:");
		lbl_HoTenKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		lbl_GioiTinh = new JLabel("Giới tính:");
		lbl_GioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		lbl_SoDienThoai = new JLabel("Số điện thoại:");
		lbl_SoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		lbl_TongTien = new JLabel("Tổng tiền:");
		lbl_TongTien.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		cbo_TraKhachHang = new Custom_ComboBox();
		
		btnTimKhachHang = new Custom_Button();
		btnTimKhachHang.setText("Tìm");
		btnTimKhachHang.setFont(new Font("Dialog", Font.BOLD, 12));
		
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
									.addComponent(lbl_TimKhachHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
									.addComponent(btnTimKhachHang, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
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
							.addComponent(lbl_TimKhachHang)
							.addComponent(cbo_TraKhachHang, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addComponent(btnTimKhachHang, GroupLayout.PREFERRED_SIZE, 18, GroupLayout.PREFERRED_SIZE))
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
		gl_pnLapDatHang.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_TimKhachHang, lbl_HoTenKhachHang, lbl_GioiTinh, lbl_SoDienThoai, lbl_TongTien});
		gl_pnLapDatHang.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_txt_TongTien, cbo_TraKhachHang, btnTimKhachHang, lbl_txt_HoTenKhachHang, lbl_txt_GioiTinh, lbl_txt_SoDienThoai});
		pnLapDatHang.setLayout(gl_pnLapDatHang);
        this.setLayout(layout);
        
        
    }// </editor-fold>//GEN-END:initComponents
}
