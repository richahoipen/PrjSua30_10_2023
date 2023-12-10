package gui_Panel_NhanVien;

import com.lowagie.text.Table;
import com.oracle.javafx.scenebuilder.kit.util.control.paintpicker.colorpicker.ColorPicker;
import com.raven.model.SettingModel;
import com.toedter.calendar.JDateChooser;

import customEntities.CustomFunction;
import customEntities.CustomIcon;
import customEntities.CustomTable;
import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import dataBase_BUS.CTDonDatHang_BUS;
import dataBase_BUS.CTHoaDon_BUS;
import dataBase_BUS.DonDatHang_BUS;
import dataBase_BUS.HoaDon_BUS;
import dataBase_BUS.KhachHang_BUS;
import dataBase_BUS.SanPham_BUS;
import entities.CTDonDatHang;
import entities.HoaDon;
import entities.KhachHang;
import entities.SanPham;
import gui_Frame_Running.*;
import gui_Dialog.Message;
import icon.GoogleMaterialDesignIcons;
import icon.IconFontSwing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.hibernate.type.CustomType;

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
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;

public class Panel_LapHoaDon extends JPanel implements ActionListener, MouseListener
{
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_Table_DSNV;
	private JLabel lbl_Title_DS_DD,lbl_Title_GioHang;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private CustomTable tbl_DSDD,tbl_DSCTDD,tbl_DSSP;
	private DefaultTableModel dtm_SP,dtm_CTDD,dtm_DD;
	private JScrollPane scr_DSSP,scr_DSDD,scr_DSCTDD;
	private JLabel lbl_Title_ChonSanPham;
	private JLabel lbl_Title_LapHoaDon;
	private Custom_Button btnTraKhachHang,btnLapHoaDon,btn_XoaTrang;
	private Custom_ComboBox cbo_TraSDT;
	private JPanel pnLapHoaDon;
	private JLabel lbl_TraSDT;
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
	private JPanel pnControl;
	private Custom_Button btnLoaiSP;
	private JLabel lbl_SoLuong;
	private JSpinner spinner;
	private Custom_Button btnThemSP;
	private KhachHang_BUS sqlKhachHang_BUS=new KhachHang_BUS();
	private SanPham_BUS sqlSanPham_BUS=new SanPham_BUS();
	private CTDonDatHang_BUS sqlCTDonDatHang_BUS=new CTDonDatHang_BUS();
	private DonDatHang_BUS sqlDonDatHang_BUS=new DonDatHang_BUS();
	private HoaDon_BUS sqlHoaDon_BUS=new HoaDon_BUS();
	private CTHoaDon_BUS sqlCTHoaDon_BUS=new CTHoaDon_BUS();
	private String maNV;
	private SettingModel settingModel;
	//private DD_BUS sqlSanPham_BUS=new SanPham_BUS();
    // End of variables declaration//GEN-END:variables
    public Panel_LapHoaDon(String maNV) {
        this.maNV=maNV;
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
		
		dtm_SP = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Số lượng còn","Giá Bán"},0);
		
		dtm_CTDD = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Đơn giá","Số lượng mua","Thành tiền"},0);
		
		dtm_DD = new DefaultTableModel(new String[] {"Mã đơn đặt","Ngày đặt","Ngày hết hạn","Tổng tiền"},0);
		
		tbl_DSSP = new CustomTable();
		tbl_DSSP.setModel(dtm_SP);
			
		tbl_DSDD = new CustomTable();
		tbl_DSDD.setModel(dtm_DD);
		
		tbl_DSCTDD = new CustomTable();
		tbl_DSCTDD.setModel(dtm_CTDD);
		
		TableColumnModel columnModel = tbl_DSSP.getColumnModel();

        // Thiết lập chiều rộng cột cụ thể (ví dụ: cột 1 có chiều rộng 150px)
		int[] columnWidths = {80,100,100,80};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
		
		JScrollPane scr_DSSP = new JScrollPane(tbl_DSSP);
		
		JScrollPane scr_DSDD = new JScrollPane(tbl_DSDD);
		
		JScrollPane scr_DSCTDD = new JScrollPane(tbl_DSCTDD);
		
		lbl_Title_GioHang = new JLabel("Giỏ hàng");
		lbl_Title_GioHang.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_GioHang.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lbl_Title_ChonSanPham = new JLabel("Chọn sản phẩm");
		lbl_Title_ChonSanPham.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_ChonSanPham.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lbl_Title_LapHoaDon = new JLabel("Lập hóa đơn");
		lbl_Title_LapHoaDon.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_LapHoaDon.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_LapHoaDon.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		pnLapHoaDon = new JPanel();
		pnLapHoaDon.setBackground(Color.WHITE);
		
		
		
		pnControl = new JPanel();
		pnControl.setBackground(Color.WHITE);
		
		btnLoaiSP = new Custom_Button();
		btnLoaiSP.setText("Loại bỏ khỏi giỏ");
		btnLoaiSP.setFont(new Font("Dialog", Font.BOLD, 12));
		
		lbl_SoLuong = new JLabel("Số lượng:");
		lbl_SoLuong.setForeground(Color.BLACK);
		lbl_SoLuong.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		spinner = new JSpinner();
		
		btnThemSP = new Custom_Button();
		btnThemSP.setText("Thêm vào giỏ");
		btnThemSP.setFont(new Font("Dialog", Font.BOLD, 12));
		GroupLayout gl_pnControl = new GroupLayout(pnControl);
		gl_pnControl.setHorizontalGroup(
			gl_pnControl.createParallelGroup(Alignment.LEADING)
				.addGap(0, 382, Short.MAX_VALUE)
				.addGroup(gl_pnControl.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(btnLoaiSP, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addGap(5)
					.addComponent(lbl_SoLuong)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(spinner, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnThemSP, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_pnControl.setVerticalGroup(
			gl_pnControl.createParallelGroup(Alignment.LEADING)
				.addGap(0, 45, Short.MAX_VALUE)
				.addGroup(gl_pnControl.createSequentialGroup()
					.addGroup(gl_pnControl.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnControl.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_pnControl.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnThemSP, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
								.addComponent(btnLoaiSP, GroupLayout.DEFAULT_SIZE, 23, Short.MAX_VALUE)
								.addGroup(gl_pnControl.createSequentialGroup()
									.addGap(3)
									.addComponent(lbl_SoLuong, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGap(4))))
						.addGroup(gl_pnControl.createSequentialGroup()
							.addGap(12)
							.addComponent(spinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnControl.linkSize(SwingConstants.HORIZONTAL, new Component[] {btnLoaiSP, btnThemSP});
		pnControl.setLayout(gl_pnControl);
		
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(scr_DSCTDD, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 945, Short.MAX_VALUE)
						.addComponent(lbl_Title_GioHang, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addGroup(layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(scr_DSDD, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
								.addComponent(scr_DSSP, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
								.addGroup(Alignment.LEADING, layout.createSequentialGroup()
									.addComponent(lbl_Title_DS_DD)
									.addGap(328))
								.addComponent(lbl_Title_ChonSanPham, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lbl_Title_LapHoaDon, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnControl, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE)
								.addComponent(pnLapHoaDon, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 408, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createParallelGroup(Alignment.BASELINE)
							.addComponent(lbl_Title_DS_DD)
							.addComponent(lbl_Title_LapHoaDon, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addGap(25)
							.addGroup(layout.createParallelGroup(Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
									.addComponent(pnLapHoaDon, GroupLayout.PREFERRED_SIZE, 345, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(pnControl, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
									.addComponent(scr_DSDD, GroupLayout.DEFAULT_SIZE, 128, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lbl_Title_ChonSanPham, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(scr_DSSP, 0, 240, Short.MAX_VALUE)))))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_GioHang, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSCTDD, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		lbl_TraSDT = new JLabel("Tra SĐT khách");
		lbl_TraSDT.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
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
		
		cbo_TraSDT = new Custom_ComboBox();
		
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
		
		btn_XoaTrang = new Custom_Button();
		btn_XoaTrang.setText("In hóa đơn");
		btn_XoaTrang.setFont(new Font("Dialog", Font.BOLD, 12));
		GroupLayout gl_pnLapHoaDon = new GroupLayout(pnLapHoaDon);
		gl_pnLapHoaDon.setHorizontalGroup(
			gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLapHoaDon.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnLapHoaDon.createSequentialGroup()
							.addGap(31)
							.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING)
									.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lbl_HoTenKhachHang, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lbl_GioiTinh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lbl_SoDienThoai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addComponent(lbl_TongTien, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
									.addComponent(lbl_TienKhachTra, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
									.addComponent(lbl_TienThoi, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
								.addComponent(lbl_TraSDT, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_txt_TienThoi, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
								.addComponent(txt_SoTienKhachTra, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
								.addComponent(lbl_txt_TongTien, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
								.addComponent(lbl_txt_SoDienThoai, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
								.addComponent(lbl_txt_GioiTinh, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
								.addGroup(gl_pnLapHoaDon.createSequentialGroup()
									.addComponent(cbo_TraSDT, GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
									.addGap(13)
									.addComponent(btnTraKhachHang, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addComponent(lbl_txt_HoTenKhachHang, GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE))
							.addContainerGap())
						.addGroup(gl_pnLapHoaDon.createSequentialGroup()
							.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
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
							.addComponent(cbo_TraSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lbl_TraSDT))
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
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_pnLapHoaDon.createParallelGroup(Alignment.LEADING)
						.addComponent(btnLapHoaDon, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_XoaTrang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(86))
		);
		gl_pnLapHoaDon.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_TraSDT, lbl_HoTenKhachHang, lbl_GioiTinh, lbl_SoDienThoai, lbl_TongTien, lbl_TienKhachTra, lbl_TienThoi});
		gl_pnLapHoaDon.linkSize(SwingConstants.VERTICAL, new Component[] {cbo_TraSDT, btnTraKhachHang, lbl_txt_HoTenKhachHang, lbl_txt_GioiTinh, lbl_txt_SoDienThoai, lbl_txt_TongTien, txt_SoTienKhachTra, lbl_txt_TienThoi});
		pnLapHoaDon.setLayout(gl_pnLapHoaDon);
        this.setLayout(layout);
        addAction();
        setting();
        
    }// </editor-fold>//GEN-END:initComponents
    private void addAction()
    {
    	btnLapHoaDon.addActionListener(this);
    	btnLoaiSP.addActionListener(this);
    	btnThemSP.addActionListener(this);
    	btnTraKhachHang.addActionListener(this);
    	btn_XoaTrang.addActionListener(this);
    	cbo_TraSDT.addActionListener(this);
    	tbl_DSDD.addMouseListener(this);
    	tbl_DSSP.addMouseListener(this);
    	//tbl_DSCTDD.addMouseListener(this);
    	resetTable_DSSP();
    	resetTable_DSDD();
    	resetTable_GioHang();
    	addCombobox();
    	
    }
    private void resetTable_DSSP()
    {
    	dtm_SP.setRowCount(0);
    	sqlSanPham_BUS.xuatDanhSachSanPham_LapHoaDon(dtm_SP);
    }
    private boolean gioiTinh_Boolean(String gioiTinh)
    {
    	if(gioiTinh.equalsIgnoreCase("Nam"))
    		return true;
    	return false;
    }
    private void resetTable_DSDD()
    {
    	
    	String tenKH=lbl_txt_HoTenKhachHang.getText();
    	String sdt=lbl_txt_SoDienThoai.getText();
    	String gioiTinh=lbl_txt_GioiTinh.getText();
    	dtm_DD.setRowCount(0);
    	KhachHang k=new KhachHang();
    	k.setTenKH(tenKH);
    	k.setSdt(sdt);
    	k.setGioiTinh(gioiTinh_Boolean(gioiTinh));
    	sqlDonDatHang_BUS.xuat_DonDat_ChuaThanhToan(maNV, dtm_DD,sqlDonDatHang_BUS.getMaKH(k));
    }
    private void addCombobox()
    {
    	cbo_TraSDT.addItem("");
    	//dayComboBoxSDT
    	sqlKhachHang_BUS.dayComboBoxSDT(cbo_TraSDT);
    	
    }
    private boolean checkComboboxNULL(String sdt)
    {  	
    	if(sdt!=null)
    		return true;
    	return false;
    		
    }
    private String gioiTinh_String(String sdt)
    {
    	if(sqlCTDonDatHang_BUS.getGioiTinh_KhachHang(sdt))
    		return "Nam";
    	return "Nữ";
    }
    private void tim_KhachHang()
    {
    	String sdt=(String) cbo_TraSDT.getSelectedItem();
    	if((checkComboboxNULL(sdt)==false)|| sdt.equalsIgnoreCase(""))
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			String canhBao = null,loaiCanhBao = null;
			if (settingModel.getNgonNgu().equals("Vietnamese")) {
				canhBao = "Vui lòng chọn số điện thoại để tra.";
				loaiCanhBao = "Lỗi";
			}
			if (settingModel.getNgonNgu().equals("English")) {
				canhBao = "Please select a phone number to look up.";
				loaiCanhBao = "Error";
			}
			JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
    	}
    	else
    	{
    		if (settingModel.getNgonNgu().equals("Vietnamese")) {
    			if(gioiTinh_String(sdt).equals("Nam")) {
					lbl_txt_GioiTinh.setText("Nam");
				}
				if(gioiTinh_String(sdt).equals("Nữ")) {
					lbl_txt_GioiTinh.setText("Nữ");
				}
			}
			if (settingModel.getNgonNgu().equals("English")) {
				if(gioiTinh_String(sdt).equals("Nam")) {
					lbl_txt_GioiTinh.setText("Male");
				}
				if(gioiTinh_String(sdt).equals("Nữ")) {
					lbl_txt_GioiTinh.setText("Female");
				}
			}
			lbl_txt_HoTenKhachHang.setText(sqlCTDonDatHang_BUS.getHoTen_KhachHang(sdt));
    		lbl_txt_SoDienThoai.setText(sqlCTDonDatHang_BUS.getSDT_KhachHang(sdt));
    		lbl_txt_GioiTinh.setText(gioiTinh_String(sdt));
    	}
    }
    private void resetTable_GioHang()
    {
    	dtm_CTDD.setRowCount(0);
    	sqlCTDonDatHang_BUS.xuat_GioHang(dtm_CTDD);
    	lbl_txt_TongTien.setText(Double.toString(sqlCTDonDatHang_BUS.tinhTongTien_GioHang()));
    }
    private void themSP()
    {
    	int row=tbl_DSSP.getSelectedRow();
    	int row_dd=tbl_DSDD.getSelectedRow();
    	int soLuong=(Integer) spinner.getValue();
		if(soLuong<=0)
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        String canhBao = null,loaiCanhBao = null;
			if (settingModel.getNgonNgu().equals("Vietnamese")) {
				canhBao = "Vui lòng chọn số lượng phải lớn hơn 0.";
				loaiCanhBao = "Lỗi";
			}
			if (settingModel.getNgonNgu().equals("English")) {
				canhBao = "Please choose a quantity that must be greater than 0";
				loaiCanhBao = "Error";
			}
	        JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
	        spinner.setValue(0);
		}
		else
		{
			
			if(row!=-1)
			{
				if(row_dd!=-1)
				{
					//public CTDonDatHang(double donGia, int soLuong, double thanhTien) 
		    		String maSP=tbl_DSSP.getValueAt(row, 0).toString();
					String giaBan=tbl_DSSP.getValueAt(row, 3).toString();
					String maDDH=tbl_DSDD.getValueAt(row_dd, 0).toString();
					try {
			            double giaBan_Double=Double.parseDouble(giaBan);
			            SanPham s=new SanPham();
			            s.setMaSP(maSP);
			            CTDonDatHang ct=new CTDonDatHang();
			            ct.setDonGia(giaBan_Double);
			            ct.setSoLuong(soLuong);
			            sqlCTDonDatHang_BUS.themCTDonDatHang_Voi_DonDaDat(s, ct, maDDH);
			            dtm_CTDD.setRowCount(0);
			    		sqlCTDonDatHang_BUS.xuat_CTDDH_TheoDonDat(maDDH, dtm_CTDD);	
			            //resetTable_GioHang();
			            spinner.setValue(0);
			            lbl_txt_TongTien.setText(Double.toString(sqlCTDonDatHang_BUS.tinhTongTien_GioHang())); 
					} catch (NumberFormatException e) {
						UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
						UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
						JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}else
				{
					String maSP=tbl_DSSP.getValueAt(row, 0).toString();
					String giaBan=tbl_DSSP.getValueAt(row, 3).toString();
					
					try {
			            double giaBan_Double=Double.parseDouble(giaBan);
			            SanPham s=new SanPham();
			            s.setMaSP(maSP);
			            CTDonDatHang ct=new CTDonDatHang();
			            ct.setDonGia(giaBan_Double);
			            ct.setSoLuong(soLuong);
			            sqlCTDonDatHang_BUS.themCTDonDatHang(s, ct);
			            //System.out.println("Thêm giỏ hàng thành công");
			            resetTable_DSSP();
			            resetTable_GioHang();
			            spinner.setValue(0);
			            lbl_txt_TongTien.setText(Double.toString(sqlCTDonDatHang_BUS.tinhTongTien_GioHang())); 
					} catch (NumberFormatException e) {
						UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
						UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
						JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
					}
				}
			}
			else
			{
				UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
		        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
		        String canhBao = null,loaiCanhBao = null;
				if (settingModel.getNgonNgu().equals("Vietnamese")) {
					canhBao = "Vui lòng chọn sản phẩm để thêm vào giỏ.";
					loaiCanhBao = "Lỗi";
				}
				if (settingModel.getNgonNgu().equals("English")) {
					canhBao = "Please select a product to add to your cart";
					loaiCanhBao = "Error";
				}
		        JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
			}
		}
    }
    private String gioiTinh_String_maDDH(String maDDH)
    {
    	if(sqlDonDatHang_BUS.getGioiTinh_KH(maDDH))
    		return "Nam";
    	return "Nữ";
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		int row=tbl_DSDD.getSelectedRow();
		String maDDH=tbl_DSDD.getValueAt(row, 0).toString();
		try
		{
			dtm_CTDD.setRowCount(0);
			sqlCTDonDatHang_BUS.xuat_CTDDH_TheoDonDat(maDDH, dtm_CTDD);	
			lbl_txt_HoTenKhachHang.setText(sqlDonDatHang_BUS.getTenKH(maDDH));
			lbl_txt_SoDienThoai.setText(sqlDonDatHang_BUS.getSDT_KH(maDDH));
			if (settingModel.getNgonNgu().equals("Vietnamese")) {
    			if(gioiTinh_String(gioiTinh_String_maDDH(maDDH)).equals("Nam")) {
					lbl_txt_GioiTinh.setText("Nam");
				}
				if(gioiTinh_String(gioiTinh_String_maDDH(maDDH)).equals("Nữ")) {
					lbl_txt_GioiTinh.setText("Nữ");
				}
			}
			if (settingModel.getNgonNgu().equals("English")) {
				if(gioiTinh_String(gioiTinh_String_maDDH(maDDH)).equals("Nam")) {
					lbl_txt_GioiTinh.setText("Male");
				}
				if(gioiTinh_String(gioiTinh_String_maDDH(maDDH)).equals("Nữ")) {
					lbl_txt_GioiTinh.setText("Female");
				}
			}
			cbo_TraSDT.setSelectedItem(sqlDonDatHang_BUS.getSDT_KH(maDDH));
			lbl_txt_TongTien.setText(Double.toString(sqlDonDatHang_BUS.getTongTien_DonDatHang(maDDH)));
		}catch(Exception ex)
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
			JOptionPane.showMessageDialog(null, ex.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	private void xoa_SP()
    {
    	int row=tbl_DSCTDD.getSelectedRow();
    	int row_dd=tbl_DSDD.getSelectedRow();
    	if(row!=-1)
		{
    		if(row_dd!=-1)
    		{
    			String maSP=tbl_DSCTDD.getValueAt(row, 0).toString();
				String maDDH=tbl_DSDD.getValueAt(row_dd, 0).toString();
        		SanPham s=new SanPham();
        		s.setMaSP(maSP);
        		sqlCTDonDatHang_BUS.xoaCTDonDatHang_Voi_DonDaDat(s, maDDH);		
        		dtm_CTDD.setRowCount(0);
	    		sqlCTDonDatHang_BUS.xuat_CTDDH_TheoDonDat(maDDH, dtm_CTDD);	
    		}
    		else
    		{
    			String maSP=tbl_DSCTDD.getValueAt(row, 0).toString();
    			SanPham s=new SanPham();
        		s.setMaSP(maSP);
        		sqlCTDonDatHang_BUS.xoaCTDonDatHang(s);
        		resetTable_GioHang();
    		}
		}
		else
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        String canhBao = null,loaiCanhBao = null;
			if (settingModel.getNgonNgu().equals("Vietnamese")) {
				canhBao = "Vui lòng chọn sản phẩm để loại bỏ khỏi giỏ.";
				loaiCanhBao = "Lỗi";
			}
			if (settingModel.getNgonNgu().equals("English")) {
				canhBao = "Please select products to remove from cart.";
				loaiCanhBao = "Error";
			}
	        JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
		}
    }
	private boolean checkText()
	{
		String tenKH=lbl_txt_HoTenKhachHang.getText();
		String tienKhachDua=txt_SoTienKhachTra.getText();
		
		if(tenKH.trim().equals(""))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        String canhBao = null,loaiCanhBao = null;
			if (settingModel.getNgonNgu().equals("Vietnamese")) {
				canhBao = "Thông tin khách hàng không được trống.";
				loaiCanhBao = "Lỗi";
			}
			if (settingModel.getNgonNgu().equals("English")) {
				canhBao = "Customer information cannot be empty.";
				loaiCanhBao = "Error";
			}
	        JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
	        return false;
		}
		if(tienKhachDua.trim().equals(""))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        String canhBao = null,loaiCanhBao = null;
			if (settingModel.getNgonNgu().equals("Vietnamese")) {
				canhBao = "Tiền khách đưa không được trống.";
				loaiCanhBao = "Lỗi";
			}
			if (settingModel.getNgonNgu().equals("English")) {
				canhBao = "Change cannot be empty.";
				loaiCanhBao = "Error";
			}
	        JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
	        txt_SoTienKhachTra.requestFocus();
	        return false;
		}
		if(!tienKhachDua.matches("^\\d+(\\.\\d+)?$"))
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        String canhBao = null,loaiCanhBao = null;
			if (settingModel.getNgonNgu().equals("Vietnamese")) {
				canhBao = "Tiền khách đưa phải là số";
				loaiCanhBao = "Lỗi";
			}
			if (settingModel.getNgonNgu().equals("English")) {
				canhBao = "Cash must be number";
				loaiCanhBao = "Error";
			}
	        JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
	        txt_SoTienKhachTra.requestFocus();
	        return false;
		}
		try {
	           String tongTien=lbl_txt_TongTien.getText();
	           double tongTien_Double=Double.parseDouble(tongTien);
	           double tienKhachDua_Double=Double.parseDouble(tienKhachDua);
	           if(tienKhachDua_Double<tongTien_Double)
	           {
	        	   UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
			   	   UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
				   	String canhBao = null,loaiCanhBao = null;
					if (settingModel.getNgonNgu().equals("Vietnamese")) {
						canhBao = "Tiền khách đưa nhỏ hơn tổng tiền.";
						loaiCanhBao = "Lỗi";
					}
					if (settingModel.getNgonNgu().equals("English")) {
						canhBao = "Cash is smaller than the total due.";
						loaiCanhBao = "Error";
					}
			   	   JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
			   	   txt_SoTienKhachTra.requestFocus();
			   	   return false;
	           }
		} catch(NumberFormatException e) {
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
		}
		return true;
	}
	private boolean lapHoaDon()
	{
		if(checkText())
		{
			int row_dd=tbl_DSDD.getSelectedRow();
			if(row_dd!=-1)
			{
				try {
					String maDDH=tbl_DSDD.getValueAt(row_dd, 0).toString();
					//Khai báo thành tiền
					String tienKhachDua=txt_SoTienKhachTra.getText();
					String tongTien=lbl_txt_TongTien.getText();
					double tienKhanhDua_Double=Double.parseDouble(tienKhachDua);
					double tongTien_Double=Double.parseDouble(tongTien);
					
					//Tạo dòng và cột cho giỏ hàng
					//int rowCount = dtm_CTDD.getRowCount();
					//ArrayList<CTDonDatHang> listCTDonDatHang=new ArrayList<>();
					//public HoaDon(String maHD, Date ngayLap,Time gioLap,double tongTien,double tienKhachDua)
					HoaDon h=new HoaDon();
					Date ngayHienTai=new Date();
					java.sql.Date sqlNgayHienTai = new java.sql.Date(ngayHienTai.getTime());
					h.setNgayLap(sqlNgayHienTai);
					h.setGioLap(new Time(ngayHienTai.getTime()));
					h.setTienKhachDua(tienKhanhDua_Double);
					h.setTongTien(tongTien_Double);
		            //Khai báo
					String tenKH=lbl_txt_HoTenKhachHang.getText();
					String sdt=lbl_txt_SoDienThoai.getText();
					String gioiTinh=lbl_txt_GioiTinh.getText();
					//Khai báo
			        KhachHang k=new KhachHang();
			        k.setTenKH(tenKH);
			        k.setSdt(sdt);
			        k.setGioiTinh(gioiTinh_Boolean(gioiTinh));
			        String maKH=sqlDonDatHang_BUS.getMaKH(k);
			        /*
			        for (int row = 0; row < rowCount; row++) {
		                String maSP=dtm_CTDD.getValueAt(row, 0).toString();
		                String donGia=dtm_CTDD.getValueAt(row, 2).toString();
		                String soLuongMua=dtm_CTDD.getValueAt(row, 3).toString();
		                String thanhTien=dtm_CTDD.getValueAt(row, 4).toString();
		                //CTDonDatHang(double donGia, int soLuong, double thanhTien, String maSP)
		                CTDonDatHang c=new CTDonDatHang(Double.parseDouble(donGia),Integer.parseInt(soLuongMua),Double.parseDouble(thanhTien),maSP);
		                //listCTDonDatHang.add(c);
		                sqlCTHoaDon_BUS.them_CTHoaDon_TheoMaHD(c, sqlHoaDon_BUS.getMaHD_MoiNhat());
		            }*/
			        //tính tiền thống
			        double tienThoi=tienKhanhDua_Double-tongTien_Double;
			        sqlHoaDon_BUS.themHoaDon(h, maNV, maKH);	        
			        lbl_txt_TienThoi.setText(Double.toString(tienThoi));
			        sqlHoaDon_BUS.capNhatDonDatHang(maDDH);
			        return true;
			        /*
			        for (int row = 0; row < rowCount; row++)
			        {
			        	String maSP=dtm_CTDD.getValueAt(row, 0).toString();
			        	String soLuongMua=dtm_CTDD.getValueAt(row, 3).toString();
			        	sqlHoaDon_BUS.capNhatSoLuong(maSP, Integer.parseInt(soLuongMua));
			        }	 */          
				} catch(NumberFormatException e) {
					UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
					UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
					JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
					return false;
				}catch(Exception e)
				{
					UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
					UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
					JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}else
			{
				try {

					//Khai báo thành tiền
					String tienKhachDua=txt_SoTienKhachTra.getText();
					String tongTien=lbl_txt_TongTien.getText();
					double tienKhanhDua_Double=Double.parseDouble(tienKhachDua);
					double tongTien_Double=Double.parseDouble(tongTien);
					
					//Tạo dòng và cột cho giỏ hàng
					
					//ArrayList<CTDonDatHang> listCTDonDatHang=new ArrayList<CTDonDatHang>();
					//public HoaDon(String maHD, Date ngayLap,Time gioLap,double tongTien,double tienKhachDua)
					HoaDon h=new HoaDon();
					//Khai báo Date
					Date ngayHienTai=new Date();
					java.sql.Date sqlNgayHienTai = new java.sql.Date(ngayHienTai.getTime());
					h.setNgayLap(sqlNgayHienTai);
					h.setGioLap(new Time(ngayHienTai.getTime()));
					h.setTienKhachDua(tienKhanhDua_Double);
					h.setTongTien(tongTien_Double);
		            //Khai báo
					String tenKH=lbl_txt_HoTenKhachHang.getText();
					String sdt=lbl_txt_SoDienThoai.getText();
					String gioiTinh=lbl_txt_GioiTinh.getText();
					//Khai báo
			        KhachHang k=new KhachHang();
			        k.setTenKH(tenKH);
			        k.setSdt(sdt);
			        k.setGioiTinh(gioiTinh_Boolean(gioiTinh));
			        String maKH=sqlDonDatHang_BUS.getMaKH(k);
			        //System.out.println(sqlHoaDon_BUS.getMaHD_MoiNhat());
			        
			        //tính tiền thối
			        double tienThoi=tienKhanhDua_Double-tongTien_Double;
			        sqlHoaDon_BUS.themHoaDon(h, maNV, maKH);	        
			        lbl_txt_TienThoi.setText(Double.toString(tienThoi));
			        //sqlHoaDon_BUS.capNhatDonDatHang(maDDH);
			       
			        /*
			        for (int row = 0; row < rowCount; row++) {
		                String maSP=dtm_CTDD.getValueAt(row, 0).toString();
		                String donGia=dtm_CTDD.getValueAt(row, 2).toString();
		                String soLuongMua=dtm_CTDD.getValueAt(row, 3).toString();
		                String thanhTien=dtm_CTDD.getValueAt(row, 4).toString();
		                //CTDonDatHang(double donGia, int soLuong, double thanhTien, String maSP)
		                
		            }*/
			        return true;
				} catch(NumberFormatException e) {
					UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
					UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
					JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
					return false;
				}catch(Exception e)
				{
					UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
					UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
					JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
					return false;
				}
			}
			
		}
		return false;
	}
	private void capNhatCT_HoaDon_Va_SoLuong_XuatHoaDon()
	{
		 int rowCount = dtm_CTDD.getRowCount();
		 System.out.println(sqlHoaDon_BUS.get_MaHD_MoiNhat());
		 ArrayList<CTDonDatHang> listCTDonDatHang =new ArrayList<CTDonDatHang>();
		
	     for (int row = 0; row < rowCount; row++)
	     {
	    	 String maSP=dtm_CTDD.getValueAt(row, 0).toString();
             String donGia=dtm_CTDD.getValueAt(row, 2).toString();
             String soLuongMua=dtm_CTDD.getValueAt(row, 3).toString();
             String thanhTien=dtm_CTDD.getValueAt(row, 4).toString();
             sqlHoaDon_BUS.capNhatSoLuong(maSP, Integer.parseInt(soLuongMua));
             CTDonDatHang c=new CTDonDatHang(Double.parseDouble(donGia),Integer.parseInt(soLuongMua),Double.parseDouble(thanhTien),maSP);
             listCTDonDatHang.add(c);
             //tongTien+=Double.parseDouble(thanhTien);
             sqlCTHoaDon_BUS.them_CTHoaDon_TheoMaHD(c, sqlHoaDon_BUS.get_MaHD_MoiNhat());
             SanPham s=new SanPham();
             s.setMaSP(maSP);
             sqlCTDonDatHang_BUS.xoaCTDonDatHang(s);
             
	     }
	     resetTable_GioHang();
	     EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Date currentDate = new Date();
					    Time currentTime = new Time(currentDate.getTime());
						Frame_HoaDonXuat frame = new Frame_HoaDonXuat(sqlHoaDon_BUS.get_MaHD_MoiNhat(), maNV, 
								lbl_txt_HoTenKhachHang.getText(), lbl_txt_SoDienThoai.getText(), LocalDate.now(), 
								currentTime,Double.parseDouble(txt_SoTienKhachTra.getText()),listCTDonDatHang);
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
						System.out.println(e.getMessage());
					}
				}
		});
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
	private boolean isTableEmpty(CustomTable tbl_DSCTDD) {
        return tbl_DSCTDD.getModel().getRowCount() == 0;
    }
	private void checkText_Find()
	{
		
		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	    UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	    String canhBao = null,loaiCanhBao = null;
		if (settingModel.getNgonNgu().equals("Vietnamese")) {
			canhBao = "Không tìm thấy khách hàng.";
			loaiCanhBao = "Cảnh báo";
		}
		if (settingModel.getNgonNgu().equals("English")) {
			canhBao = "Can't find customer.";
			loaiCanhBao = "Warning";
		}
	    JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.WARNING_MESSAGE);
		
	}
	private void xoaTrang()
	{
		lbl_txt_HoTenKhachHang.setText("");
		lbl_txt_SoDienThoai.setText("");
		lbl_txt_GioiTinh.setText("");
		txt_SoTienKhachTra.setText("");
		addCombobox();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnTraKhachHang))
		{
			tim_KhachHang();
			resetTable_DSDD();
			String tenKH=lbl_txt_HoTenKhachHang.getText();
			String gioiTinh=lbl_txt_GioiTinh.getText();
			//String sdt=(String) cbo_TraKhachHang.getSelectedItem();
			if(tenKH.equalsIgnoreCase("") && !gioiTinh.equalsIgnoreCase(""))
			{
				checkText_Find();
				xoaTrang();
			}
		}
		if(o.equals(btnThemSP))
		{
			themSP();
			/*
			if(!isTableEmpty(tbl_DSCTDD))
			{
				themSP();
			}
			else
			{
				
				UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
		        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
		        String canhBao = null,loaiCanhBao = null;
				if (settingModel.getNgonNgu().equals("Vietnamese")) {
					canhBao = "Giỏ hàng không được trống.";
					loaiCanhBao = "Lỗi";
				}
				if (settingModel.getNgonNgu().equals("English")) {
					canhBao = "The cart cannot be empty.";
					loaiCanhBao = "Error";
				}
		        JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
			}*/
		}
		if(o.equals(btnLoaiSP))
		{
			xoa_SP();
		}
		if(o.equals(btnLapHoaDon))
		{
			if(!isTableEmpty(tbl_DSCTDD))
			{
				if(lapHoaDon())
					capNhatCT_HoaDon_Va_SoLuong_XuatHoaDon();	
			}
			else
			{
				UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
		        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
		        String canhBao = null,loaiCanhBao = null;
				if (settingModel.getNgonNgu().equals("Vietnamese")) {
					canhBao = "Giỏ hàng không được trống.";
					loaiCanhBao = "Lỗi";
				}
				if (settingModel.getNgonNgu().equals("English")) {
					canhBao = "Cart cannot be emty";
					loaiCanhBao = "Error";
				}
		        JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
			}
		}
		if(o.equals(btn_XoaTrang))
		{
			xoaTrang();
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
    	//settingCombobox();
    	settingTable();
    }
	private void settingTable() {
		
	}
	private void settingLanguage() {
		// TODO Auto-generated method stub
    	if(settingModel.getNgonNgu().equals("Vietnamese")) {
    		lbl_Title_DS_DD.setText("Danh sách đơn đặt chưa thanh toán");
    		tbl_DSDD.getColumnModel().getColumn(0).setHeaderValue("Mã đơn đặt");
    		tbl_DSDD.getColumnModel().getColumn(1).setHeaderValue("Ngày đặt");
    		tbl_DSDD.getColumnModel().getColumn(2).setHeaderValue("Ngày hết hạn");
    		tbl_DSDD.getColumnModel().getColumn(3).setHeaderValue("Tổng tiền");
    		lbl_Title_ChonSanPham.setText("Chọn sản phẩm");
    		tbl_DSSP.getColumnModel().getColumn(0).setHeaderValue("Mã sản phẩm");
    		tbl_DSSP.getColumnModel().getColumn(1).setHeaderValue("Tên sản phẩm");
    		tbl_DSSP.getColumnModel().getColumn(2).setHeaderValue("Số lượng còn");
    		tbl_DSSP.getColumnModel().getColumn(3).setHeaderValue("Đơn giá");
    		lbl_Title_GioHang.setText("Giỏ hàng");
    		tbl_DSCTDD.getColumnModel().getColumn(0).setHeaderValue("Mã sản phẩm");
    		tbl_DSCTDD.getColumnModel().getColumn(1).setHeaderValue("Tên sản phẩm");
    		tbl_DSCTDD.getColumnModel().getColumn(2).setHeaderValue("Đơn giá");
    		tbl_DSCTDD.getColumnModel().getColumn(3).setHeaderValue("Số lượng mua");
    		tbl_DSCTDD.getColumnModel().getColumn(4).setHeaderValue("Thành tiền");
    		lbl_Title_LapHoaDon.setText("Lập hóa đơn");
    		lbl_TraSDT.setText("Tra SĐT Khách");
    		btnTraKhachHang.setText("Tra");
    		lbl_HoTenKhachHang.setText("Họ tên khách");
    		lbl_GioiTinh.setText("Giới tính");
    		lbl_SoDienThoai.setText("Số điện thoại");
    		lbl_TongTien.setText("Tổng tiền");
    		lbl_TienKhachTra.setText("Tiền khách trả");
    		lbl_TienThoi.setText("Tiền thối");
    		btn_XoaTrang.setText("Xóa trắng");
    		btnLapHoaDon.setText("Lập hóa đơn");
    		btnLoaiSP.setText("Loại bỏ khỏi giỏ");
    		lbl_SoLuong.setText("Số lượng");
    		btnThemSP.setText("Thêm vào giỏ");
    	}
    	if(settingModel.getNgonNgu().equals("English")) {
    		lbl_Title_DS_DD.setText("Incomplete Orders");
    		tbl_DSDD.getColumnModel().getColumn(0).setHeaderValue("Order number");
    		tbl_DSDD.getColumnModel().getColumn(1).setHeaderValue("Order date");
    		tbl_DSDD.getColumnModel().getColumn(2).setHeaderValue("Expire date");
    		tbl_DSDD.getColumnModel().getColumn(3).setHeaderValue("Total due");
    		lbl_Title_ChonSanPham.setText("Product selection");
    		tbl_DSSP.getColumnModel().getColumn(0).setHeaderValue("Product number");
    		tbl_DSSP.getColumnModel().getColumn(1).setHeaderValue("Product name");
    		tbl_DSSP.getColumnModel().getColumn(2).setHeaderValue("Quantity remaining");
    		tbl_DSSP.getColumnModel().getColumn(3).setHeaderValue("Price");
    		lbl_Title_GioHang.setText("Cart");
    		tbl_DSCTDD.getColumnModel().getColumn(0).setHeaderValue("Product number");
    		tbl_DSCTDD.getColumnModel().getColumn(1).setHeaderValue("Product name");
    		tbl_DSCTDD.getColumnModel().getColumn(2).setHeaderValue("Price");
    		tbl_DSCTDD.getColumnModel().getColumn(3).setHeaderValue("Quantity selected");
    		tbl_DSCTDD.getColumnModel().getColumn(4).setHeaderValue("Amount");
    		lbl_Title_LapHoaDon.setText("Make invoice");
    		lbl_TraSDT.setText("C.P.Number");
    		btnTraKhachHang.setText("Search");
    		lbl_HoTenKhachHang.setText("Customer full name");
    		lbl_GioiTinh.setText("Sex");
    		lbl_SoDienThoai.setText("Phone number");
    		lbl_TongTien.setText("Total due");
    		lbl_TienKhachTra.setText("Cash");
    		lbl_TienThoi.setText("Change");
    		btn_XoaTrang.setText("Refresh");
    		btnLapHoaDon.setText("Make invoice");
    		btnLoaiSP.setText("Remove from cart");
    		lbl_SoLuong.setText("Quantity");
    		btnThemSP.setText("Add to cart");
    	}	
	}
}
