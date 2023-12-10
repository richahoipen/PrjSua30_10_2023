package gui_Panel_NhanVien;

import com.oracle.javafx.scenebuilder.kit.util.control.paintpicker.colorpicker.ColorPicker;
import com.raven.model.SettingModel;
import com.toedter.calendar.JDateChooser;

import customEntities.CustomFunction;
import customEntities.CustomIcon;
import customEntities.CustomTable;
import customEntities.Custom_Button;
import customEntities.Custom_ColorPicker;
import customEntities.Custom_ComboBox;
import customEntities.ScrollBarCustom;
import dataBase_BUS.CTDonDatHang_BUS;
import dataBase_BUS.DonDatHang_BUS;
import dataBase_BUS.KhachHang_BUS;
import dataBase_BUS.SanPham_BUS;
import entities.CTDonDatHang;
import entities.DonDatHang;
import entities.KhachHang;
import entities.SanPham;
import gui_Frame_Running.Frame_Chinh;
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

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.FlowLayout;

public class Panel_DatHang extends JPanel implements ActionListener, MouseListener
{
	// Variables declaration - do not modify//GEN-BEGIN:variables
	private JPanel pn_Table_DSNV;
	private JLabel lbl_Title_DSSP;
	private JFormattedTextField ftf_NgaySinh;
	private BufferedImage bfi_ChonNgay;
	private CustomTable tbl_DSCTDD;
	private DefaultTableModel dtm_SP,dtm_CTDD;
	private JScrollPane scr_DSSP,scr_DSDD;
	private JLabel lbl_Title_CTDD;
	private JLabel lbl_Title_DatHang;
	private Custom_Button btnTimKhachHang,btnDatHang,btnLoaiSP,btnThemSP,btnXoaTrang;
	private Custom_ComboBox cbo_TraKhachHang;
	private JPanel pnLapDatHang;
	private JLabel lbl_TraSDT;
	private JLabel lbl_HoTenKhachHang;
	private JLabel lbl_GioiTinh;
	private JLabel lbl_SoDienThoai;
	private JLabel lbl_TongTien;
	private JTextField lbl_txt_HoTenKhachHang;
	private JTextField lbl_txt_GioiTinh;
	private JTextField lbl_txt_SoDienThoai;
	private JTextField lbl_txt_TongTien;
	private JLabel lbl_SoLuong;
	private JScrollPane scr_DSCTDD;
	private CustomTable tbl_DSSP;
	private JPanel pnControl;
	private JSpinner spinner;
	private KhachHang_BUS sqlKhachHang_BUS=new KhachHang_BUS();
	private SanPham_BUS sqlSanPham_BUS=new SanPham_BUS();
	private CTDonDatHang_BUS sqlCTDonDatHang_BUS=new CTDonDatHang_BUS();
	private DonDatHang_BUS sqlDonDatHang_BUS=new DonDatHang_BUS();
	private SettingModel settingModel;
    // End of variables declaration//GEN-END:variables
	private String maNV;
    public Panel_DatHang(String maNV) {
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
		
		tbl_DSSP = new CustomTable();
		tbl_DSSP.setModel(dtm_SP);
		
		TableColumnModel columnModel = tbl_DSSP.getColumnModel();

        // Thiết lập chiều rộng cột cụ thể (ví dụ: cột 1 có chiều rộng 150px)
		int[] columnWidths = {50,100,100,80};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
		
		scr_DSSP = new JScrollPane(tbl_DSSP);
		
		lbl_Title_DSSP = new JLabel(" sản phẩm");
		lbl_Title_DSSP.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_DSSP.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lbl_Title_CTDD = new JLabel("Giỏ hàng");
		lbl_Title_CTDD.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_CTDD.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		lbl_Title_DatHang = new JLabel("Đặt hàng");
		lbl_Title_DatHang.setVerticalAlignment(SwingConstants.TOP);
		lbl_Title_DatHang.setForeground(Custom_ColorPicker.darkblue_4F709C);
		lbl_Title_DatHang.setFont(new Font("SansSerif", Font.BOLD, 12));
		
		pnLapDatHang = new JPanel();
		pnLapDatHang.setBackground(Color.WHITE);
		
		tbl_DSCTDD= new CustomTable();
		tbl_DSCTDD.setModel(dtm_CTDD);
		scr_DSCTDD = new JScrollPane(tbl_DSCTDD);
		
		TableColumnModel columnModel2 = tbl_DSCTDD.getColumnModel();

        // Thiết lập chiều rộng cột cụ thể (ví dụ: cột 1 có chiều rộng 150px)
		int[] columnWidths2 = {50,100,100,50};
        for (int i = 0; i < columnWidths2.length; i++) {
            TableColumn column = columnModel2.getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
		
		pnControl = new JPanel();
		pnControl.setBackground(Color.WHITE);
		
		
		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.TRAILING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(scr_DSCTDD, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
						.addComponent(scr_DSSP, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
						.addComponent(lbl_Title_DatHang, GroupLayout.PREFERRED_SIZE, 102, GroupLayout.PREFERRED_SIZE)
						.addComponent(pnLapDatHang, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
						.addComponent(lbl_Title_DSSP, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createSequentialGroup()
							.addComponent(lbl_Title_CTDD, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 129, Short.MAX_VALUE)
							.addComponent(pnControl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(lbl_Title_DatHang, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(pnLapDatHang, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lbl_Title_DSSP, GroupLayout.PREFERRED_SIZE, 16, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSSP, GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbl_Title_CTDD)
						.addComponent(pnControl, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scr_DSCTDD, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addContainerGap())
		);
		
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
		
		cbo_TraKhachHang = new Custom_ComboBox();
		
		btnTimKhachHang = new Custom_Button();
		btnTimKhachHang.setText("Tìm");
		btnTimKhachHang.setFont(new Font("Dialog", Font.BOLD, 12));
		
		lbl_txt_HoTenKhachHang = new JTextField("");
		lbl_txt_HoTenKhachHang.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbl_txt_HoTenKhachHang.setBackground(Custom_ColorPicker.snowwhite_F2F0EB);
		lbl_txt_HoTenKhachHang.setOpaque(true);
		
		lbl_txt_GioiTinh = new JTextField("");
		lbl_txt_GioiTinh.setOpaque(true);
		lbl_txt_GioiTinh.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbl_txt_GioiTinh.setBackground(new Color(242, 240, 235));
		
		lbl_txt_SoDienThoai = new JTextField("");
		lbl_txt_SoDienThoai.setOpaque(true);
		lbl_txt_SoDienThoai.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbl_txt_SoDienThoai.setBackground(new Color(242, 240, 235));
		
		lbl_txt_TongTien = new JTextField("");
		lbl_txt_TongTien.setOpaque(true);
		lbl_txt_TongTien.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lbl_txt_TongTien.setBackground(new Color(242, 240, 235));
		
		btnDatHang = new Custom_Button();
		btnDatHang.setText("Đặt hàng");
		btnDatHang.setFont(new Font("Dialog", Font.BOLD, 12));
		
		btnXoaTrang = new Custom_Button();
		btnXoaTrang.setText("Xóa trắng");
		btnXoaTrang.setFont(new Font("Dialog", Font.BOLD, 12));
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
									.addComponent(lbl_TraSDT, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lbl_GioiTinh, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(lbl_SoDienThoai, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(lbl_TongTien, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.LEADING)
								.addComponent(lbl_txt_TongTien, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
								.addComponent(lbl_txt_SoDienThoai, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
								.addComponent(lbl_txt_GioiTinh, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)
								.addGroup(gl_pnLapDatHang.createSequentialGroup()
									.addComponent(cbo_TraKhachHang, GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
									.addGap(13)
									.addComponent(btnTimKhachHang, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
								.addComponent(lbl_txt_HoTenKhachHang, GroupLayout.DEFAULT_SIZE, 632, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_pnLapDatHang.createSequentialGroup()
							.addComponent(btnXoaTrang, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnDatHang, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_pnLapDatHang.setVerticalGroup(
			gl_pnLapDatHang.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnLapDatHang.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.BASELINE)
							.addComponent(lbl_TraSDT)
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
					.addGroup(gl_pnLapDatHang.createParallelGroup(Alignment.LEADING)
						.addComponent(btnDatHang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXoaTrang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(53, Short.MAX_VALUE))
		);
		gl_pnLapDatHang.linkSize(SwingConstants.VERTICAL, new Component[] {cbo_TraKhachHang, btnTimKhachHang, lbl_txt_HoTenKhachHang, lbl_txt_GioiTinh, lbl_txt_SoDienThoai, lbl_txt_TongTien});
		gl_pnLapDatHang.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_TraSDT, lbl_HoTenKhachHang, lbl_GioiTinh, lbl_SoDienThoai, lbl_TongTien});
		pnLapDatHang.setLayout(gl_pnLapDatHang);
        this.setLayout(layout);
        addAction();
        setting();
        setEditableToFalseTextfield();
    }// </editor-fold>//GEN-END:initComponents
    private void addAction()
    {
    	btnDatHang.addActionListener(this);
    	btnXoaTrang.addActionListener(this);
    	btnThemSP.addActionListener(this);
    	btnTimKhachHang.addActionListener(this);
    	btnLoaiSP.addActionListener(this);
    	cbo_TraKhachHang.addActionListener(this);
    	tbl_DSCTDD.addMouseListener(this);
    	tbl_DSSP.addMouseListener(this);
    	addCombobox();
    	resetTable();
    	resetTable_GioHang();
    }
    private void addCombobox()
    {
    	cbo_TraKhachHang.addItem("");
    	sqlKhachHang_BUS.dayComboBoxSDT(cbo_TraKhachHang);
    }
    private void resetTable()
    {
    	dtm_SP.setRowCount(0);
    	sqlSanPham_BUS.xuatDanhSachSanPham_LapHoaDon(dtm_SP);
    }
    private void resetTable_GioHang()
    {
    	dtm_CTDD.setRowCount(0);
    	sqlCTDonDatHang_BUS.xuat_GioHang(dtm_CTDD);
    	lbl_txt_TongTien.setText(Double.toString(sqlCTDonDatHang_BUS.tinhTongTien_GioHang()));
    }
    private void resetSearch()
    {
    	lbl_txt_GioiTinh.setText("");
    	lbl_txt_HoTenKhachHang.setText("");
    	lbl_txt_SoDienThoai.setText("");
    	cbo_TraKhachHang.setSelectedItem("");
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
    	String sdt=(String) cbo_TraKhachHang.getSelectedItem();
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
    		lbl_txt_HoTenKhachHang.setText(sqlCTDonDatHang_BUS.getHoTen_KhachHang(sdt));
    		lbl_txt_SoDienThoai.setText(sqlCTDonDatHang_BUS.getSDT_KhachHang(sdt));
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
    	}
    }
    private void them_SP()
    {
    	int row=tbl_DSSP.getSelectedRow();
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
				//public CTDonDatHang(double donGia, int soLuong, double thanhTien) 
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
		            resetTable();
		            resetTable_GioHang();
		            spinner.setValue(0);
		            lbl_txt_TongTien.setText(Double.toString(sqlCTDonDatHang_BUS.tinhTongTien_GioHang())); 
				} catch (NumberFormatException e) {
					UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
					UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
					JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
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
				JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);			}
		}	
    }
    private void xoa_SP()
    {
    	int row=tbl_DSCTDD.getSelectedRow();
    	if(row!=-1)
		{
    		String maSP=tbl_DSCTDD.getValueAt(row, 0).toString();
    		SanPham s=new SanPham();
    		s.setMaSP(maSP);
    		sqlCTDonDatHang_BUS.xoaCTDonDatHang(s);
    		resetTable_GioHang();
		}
		else
		{
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        String canhBao = null,loaiCanhBao = null;
			if (settingModel.getNgonNgu().equals("Vietnamese")) {
				canhBao = "Vui lòng chọn sản phẩm loại bỏ.";
				loaiCanhBao = "Lỗi";
			}
			if (settingModel.getNgonNgu().equals("English")) {
				canhBao = "Please select the product to be removed.";
				loaiCanhBao = "Error";
			}
	        JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.INFORMATION_MESSAGE);
		}
    }
    private boolean gioiTinh_Boolean(String gioiTinh)
    {
    	if(gioiTinh.equalsIgnoreCase("Nam"))
    		return true;
    	return false;
    }
    private void datHang()
    {
    	String tenKH=lbl_txt_HoTenKhachHang.getText();
    	if(tenKH.trim().equals(""))
    	{
    		UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
	        String canhBao = null,loaiCanhBao = null;
			if (settingModel.getNgonNgu().equals("Vietnamese")) {
				canhBao = "Vui lòng tra khách hàng để đặt hàng.";
				loaiCanhBao = "Lỗi";
			}
			if (settingModel.getNgonNgu().equals("English")) {
				canhBao = "Please look up customer to place an order.";
				loaiCanhBao = "Error";
			}
	        JOptionPane.showMessageDialog(null, canhBao, loaiCanhBao, JOptionPane.ERROR_MESSAGE);
    	}
    	else
    	{
    		/*
    		 * String maDDH="DDH50";
					String maNV="NV1";
					String tenKH="Văn Đại";
					String sdt="0923646567";
					String ngayDat="11/12/2023";
					String ngayHetHan="26/12/2023";
					Date currentDate = new Date();
			        Time currentTime = new Time(currentDate.getTime());
			        ArrayList<CTDonDatHang> listCTDonDatHang =new ArrayList<CTDonDatHang>();
			        listCTDonDatHang.add(new CTDonDatHang(200000, 12, 13142, "SP1"));
					Frame_DonDatXuat frame = new Frame_DonDatXuat(maDDH, maNV, tenKH, sdt, ngayDat, ngayHetHan, currentTime,listCTDonDatHang);
					frame.setVisible(true);
    		 */
    		try
    		{
    			//String tenKH=lbl_txt_HoTenKhachHang.getText();
    			String sdt=lbl_txt_SoDienThoai.getText();
        		String gioiTinh=lbl_txt_GioiTinh.getText();
        		int rowCount = dtm_CTDD.getRowCount();
	       		ArrayList<CTDonDatHang> listCTDonDatHang =new ArrayList<CTDonDatHang>();
        		//Giờ hiện tại
	       		Date currentDate = new Date();
		        Time currentTime = new Time(currentDate.getTime());
        		
        		KhachHang k=new KhachHang();
        		k.setTenKH(tenKH);
        		k.setGioiTinh(gioiTinh_Boolean(gioiTinh));
        		k.setSdt(sdt);
        		Date ngayHienTai=new Date();
            	java.sql.Date sqlNgayHienTai = new java.sql.Date(ngayHienTai.getTime());
            	DonDatHang d=new DonDatHang();
            	d.setNgayDat(sqlNgayHienTai);
            	//
            	for (int row = 0; row < rowCount; row++)
       	     	{
       	    	 	String maSP=dtm_CTDD.getValueAt(row, 0).toString();
                    String donGia=dtm_CTDD.getValueAt(row, 2).toString();
                    String soLuongMua=dtm_CTDD.getValueAt(row, 3).toString();
                    String thanhTien=dtm_CTDD.getValueAt(row, 4).toString();
                    CTDonDatHang c=new CTDonDatHang(Double.parseDouble(donGia),Integer.parseInt(soLuongMua),Double.parseDouble(thanhTien),maSP);
                    listCTDonDatHang.add(c);
       	     	}
            	//System.out.println(sqlDonDatHang_BUS.getMaKH(k));
            	sqlDonDatHang_BUS.themDonDatHang(d,sqlDonDatHang_BUS.getMaKH(k),maNV);
            	System.out.println(sqlDonDatHang_BUS.get_MaDDH_MoiNhat());
            	resetTable_GioHang();
            	resetSearch();  
            	//Khai báo row
            	Frame_DonDatXuat frame = new Frame_DonDatXuat(sqlDonDatHang_BUS.get_MaDDH_MoiNhat(), maNV, tenKH, sdt, d.getNgayDatToString(),d.getNgayHetHanToString(), currentTime,listCTDonDatHang);
				frame.setVisible(true);
        		//Duyệt bảng
            	
    		}catch(Exception e)
    		{
    			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
    	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
    	        JOptionPane.showMessageDialog(null,e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    		}
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

	private boolean isTableEmpty(CustomTable tbl_DSCTDD) {
        return tbl_DSCTDD.getModel().getRowCount() == 0;
    }
	private void checkText()
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
		lbl_txt_TongTien.setText("0.0");
		cbo_TraKhachHang.setSelectedItem("");
		addCombobox();
		resetTable_GioHang();
		resetTable();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnTimKhachHang))
		{
			tim_KhachHang();
			String tenKH=lbl_txt_HoTenKhachHang.getText();
			String gioiTinh=lbl_txt_GioiTinh.getText();
			//String sdt=(String) cbo_TraKhachHang.getSelectedItem();
			if(tenKH.equalsIgnoreCase("") && !gioiTinh.equalsIgnoreCase(""))
			{
				checkText();
				xoaTrang();
			}	
		}
		if(o.equals(btnThemSP))
		{
			them_SP();
		}
		if(o.equals(btnLoaiSP))
		{
			xoa_SP();
		}
		if(o.equals(btnDatHang))
		{
			if(!isTableEmpty(tbl_DSCTDD))
			{
				datHang();
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
		if(o.equals(btnXoaTrang))
		{
			lbl_txt_HoTenKhachHang.setText("");
			lbl_txt_SoDienThoai.setText("");
			lbl_txt_GioiTinh.setText("");
			lbl_txt_TongTien.setText("0.0");
			cbo_TraKhachHang.setSelectedItem("");
			addCombobox();
			resetTable_GioHang();
			resetTable();
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
    	//settingTable();
    }
	private void settingLanguage() {
		// TODO Auto-generated method stub
    	if(settingModel.getNgonNgu().equals("Vietnamese")) {
    		lbl_Title_DatHang.setText("Danh sách đơn đặt chưa thanh toán");
    		lbl_TraSDT.setText("Tra SĐT khách");
    		lbl_HoTenKhachHang.setText("Họ tên khách");
    		lbl_GioiTinh.setText("Giới tính");
    		lbl_SoDienThoai.setText("Số điện thoại");
    		lbl_TongTien.setText("Tổng tiền");
    		btnTimKhachHang.setText("Tra");
    		btnXoaTrang.setText("Xóa trắng");
    		btnDatHang.setText("Đặt hàng");
    		lbl_Title_DSSP.setText("Chọn sản phẩm");
    		tbl_DSSP.getColumnModel().getColumn(0).setHeaderValue("Mã sản phẩm");
    		tbl_DSSP.getColumnModel().getColumn(1).setHeaderValue("Tên sản phẩm");
    		tbl_DSSP.getColumnModel().getColumn(2).setHeaderValue("Số lượng còn");
    		tbl_DSSP.getColumnModel().getColumn(3).setHeaderValue("Đơn giá");
    		lbl_Title_CTDD.setText("Giỏ hàng");
    		tbl_DSCTDD.getColumnModel().getColumn(0).setHeaderValue("Mã sản phẩm");
    		tbl_DSCTDD.getColumnModel().getColumn(1).setHeaderValue("Tên sản phẩm");
    		tbl_DSCTDD.getColumnModel().getColumn(2).setHeaderValue("Đơn giá");
    		tbl_DSCTDD.getColumnModel().getColumn(3).setHeaderValue("Số lượng đặt");
    		tbl_DSCTDD.getColumnModel().getColumn(4).setHeaderValue("Thành tiền");
    		btnLoaiSP.setText("Loại bỏ khỏi giỏ");
    		lbl_SoLuong.setText("Số lượng");
    		btnThemSP.setText("Thêm vào giỏ");
    	}
    	if(settingModel.getNgonNgu().equals("English")) {
    		lbl_Title_DatHang.setText("List of orders");
    		lbl_TraSDT.setText("C.P.Number");
    		lbl_HoTenKhachHang.setText("Customer name");
    		lbl_GioiTinh.setText("Sex");
    		lbl_SoDienThoai.setText("Customer P.Number");
    		lbl_TongTien.setText("Total due");
    		btnTimKhachHang.setText("Search");
    		btnXoaTrang.setText("Refresh");
    		btnDatHang.setText("Make order");
    		lbl_Title_DSSP.setText("Product selection");
    		tbl_DSSP.getColumnModel().getColumn(0).setHeaderValue("Product number");
    		tbl_DSSP.getColumnModel().getColumn(1).setHeaderValue("Product name");
    		tbl_DSSP.getColumnModel().getColumn(2).setHeaderValue("Quantity remaining");
    		tbl_DSSP.getColumnModel().getColumn(3).setHeaderValue("Price");
    		lbl_Title_CTDD.setText("Cart");
    		tbl_DSCTDD.getColumnModel().getColumn(0).setHeaderValue("Product number");
    		tbl_DSCTDD.getColumnModel().getColumn(1).setHeaderValue("Product name");
    		tbl_DSCTDD.getColumnModel().getColumn(2).setHeaderValue("Price");
    		tbl_DSCTDD.getColumnModel().getColumn(3).setHeaderValue("Quantity selected");
    		tbl_DSCTDD.getColumnModel().getColumn(4).setHeaderValue("Amount");
    		btnLoaiSP.setText("Remove from cart");
    		lbl_SoLuong.setText("Quantity");
    		btnThemSP.setText("Add to cart");
    	}	
	}
	private void setEditableToFalseTextfield() {
		for (Component component : pnLapDatHang.getComponents()) {
	        if (component instanceof JTextField) {
	        	((JTextField)component).setEditable(false);
	        	((JTextField)component).setCaretColor(component.getBackground());
	        }
	    }
	}
}
