package gui_Panel_NhanVien;

import com.oracle.javafx.scenebuilder.kit.util.control.paintpicker.colorpicker.ColorPicker;
import com.toedter.calendar.JDateChooser;

import customEntities.CustomFunction;
import customEntities.CustomIcon;
import customEntities.CustomTable;
import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import dataBase_BUS.CTDonDatHang_BUS;
import dataBase_BUS.DonDatHang_BUS;
import dataBase_BUS.KhachHang_BUS;
import dataBase_BUS.SanPham_BUS;
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
	private Custom_Button btnTraKhachHang,btnLapHoaDon,btnInHoaDon;
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
	private String maNV;
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
		
		dtm_SP = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Loại sản phẩm","Ngôn ngữ","Nhà xuất bản","Năm XB","Tác giả","Giá Bán"},0);
		
		dtm_CTDD = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Đơn giá","Số lượng mua","Thành tiền"},0);
		
		dtm_DD = new DefaultTableModel(new String[] {"Mã đơn đặt","Tên khách hàng","Ngày đặt"},0);
		
		tbl_DSSP = new CustomTable();
		tbl_DSSP.setModel(dtm_SP);
			
		tbl_DSDD = new CustomTable();
		tbl_DSDD.setModel(dtm_DD);
		
		tbl_DSCTDD = new CustomTable();
		tbl_DSCTDD.setModel(dtm_CTDD);
		
		TableColumnModel columnModel = tbl_DSSP.getColumnModel();

        // Thiết lập chiều rộng cột cụ thể (ví dụ: cột 1 có chiều rộng 150px)
		int[] columnWidths = {50,100,100,80,150,50,100,50};
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
		
		btnInHoaDon = new Custom_Button();
		btnInHoaDon.setText("In hóa đơn");
		btnInHoaDon.setFont(new Font("Dialog", Font.BOLD, 12));
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
						.addComponent(btnInHoaDon, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addGap(86))
		);
		gl_pnLapHoaDon.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_TraSDT, lbl_HoTenKhachHang, lbl_GioiTinh, lbl_SoDienThoai, lbl_TongTien, lbl_TienKhachTra, lbl_TienThoi});
		gl_pnLapHoaDon.linkSize(SwingConstants.VERTICAL, new Component[] {cbo_TraSDT, btnTraKhachHang, lbl_txt_HoTenKhachHang, lbl_txt_GioiTinh, lbl_txt_SoDienThoai, lbl_txt_TongTien, txt_SoTienKhachTra, lbl_txt_TienThoi});
		pnLapHoaDon.setLayout(gl_pnLapHoaDon);
        this.setLayout(layout);
        addAction();
        
    }// </editor-fold>//GEN-END:initComponents
    private void addAction()
    {
    	btnLapHoaDon.addActionListener(this);
    	btnLoaiSP.addActionListener(this);
    	btnThemSP.addActionListener(this);
    	btnTraKhachHang.addActionListener(this);
    	btnInHoaDon.addActionListener(this);
    	cbo_TraSDT.addActionListener(this);
    	tbl_DSDD.addMouseListener(this);
    	tbl_DSSP.addMouseListener(this);
    	resetTable_DSSP();
    	addCombobox();
    	
    }
    private void resetTable_DSSP()
    {
    	dtm_SP.setRowCount(0);
    	sqlSanPham_BUS.xuatDanhSachSanPham_DonDat(dtm_SP);
    }
    private void resetTable_DSDD()
    {
    	
    }
    private void addCombobox()
    {
    	cbo_TraSDT.addItem("Chọn");
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
    	if((checkComboboxNULL(sdt)==false)|| sdt.equalsIgnoreCase("Chọn"))
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Vui lòng chọn số điện thoại để tra.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
    	}
    	else
    	{
    		lbl_txt_HoTenKhachHang.setText(sqlCTDonDatHang_BUS.getHoTen_KhachHang(sdt));
    		lbl_txt_SoDienThoai.setText(sqlCTDonDatHang_BUS.getSDT_KhachHang(sdt));
    		lbl_txt_GioiTinh.setText(gioiTinh_String(sdt));
    	}
    }
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		if(o.equals(btnTraKhachHang))
		{
			tim_KhachHang();
		}
		
	}
}
