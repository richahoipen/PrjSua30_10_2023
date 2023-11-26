package gui_Panel_NhanVien;

import com.oracle.javafx.scenebuilder.kit.util.control.paintpicker.colorpicker.ColorPicker;
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
import java.time.LocalDate;
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
	private Custom_Button btnTimKhachHang,btnDatHang,btnLoaiSP,btnThemSP;
	private Custom_ComboBox cbo_TraKhachHang;
	private JPanel pnLapDatHang;
	private JLabel lbl_TraSDT;
	private JLabel lbl_HoTenKhachHang;
	private JLabel lbl_GioiTinh;
	private JLabel lbl_SoDienThoai;
	private JLabel lbl_TongTien;
	private JLabel lbl_txt_HoTenKhachHang;
	private JLabel lbl_txt_GioiTinh;
	private JLabel lbl_txt_SoDienThoai;
	private JLabel lbl_txt_TongTien;
	private JScrollPane scr_DSCTDD;
	private CustomTable tbl_DSSP;
	private JPanel pnControl;
	private JSpinner spinner;
	private KhachHang_BUS sqlKhachHang_BUS=new KhachHang_BUS();
	private SanPham_BUS sqlSanPham_BUS=new SanPham_BUS();
	private CTDonDatHang_BUS sqlCTDonDatHang_BUS=new CTDonDatHang_BUS();
	private DonDatHang_BUS sqlDonDatHang_BUS=new DonDatHang_BUS();
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
		
		dtm_SP = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Loại sản phẩm","Ngôn ngữ","Nhà xuất bản","Năm xuất bản","Tác giả","Giá Bán","SL còn"},0);
		
		dtm_CTDD = new DefaultTableModel(new String[] {"Mã sản phẩm","Tên sản phẩm","Đơn giá","Số lượng mua","Thành tiền"},0);
		
		tbl_DSSP = new CustomTable();
		tbl_DSSP.setModel(dtm_SP);
		
		TableColumnModel columnModel = tbl_DSSP.getColumnModel();

        // Thiết lập chiều rộng cột cụ thể (ví dụ: cột 1 có chiều rộng 150px)
		int[] columnWidths = {50,100,100,80,150,50,100,50,50};
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = columnModel.getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }
		
		scr_DSSP = new JScrollPane(tbl_DSSP);
		
		lbl_Title_DSSP = new JLabel("Chọn sản phẩm");
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
		int[] columnWidths2 = {50,100,100,50,150};
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
		
		JLabel lbl_SoLuong = new JLabel("Số lượng:");
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
									.addComponent(lbl_TraSDT, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
					.addComponent(btnDatHang, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(336, Short.MAX_VALUE))
		);
		gl_pnLapDatHang.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_TraSDT, lbl_HoTenKhachHang, lbl_GioiTinh, lbl_SoDienThoai, lbl_TongTien});
		gl_pnLapDatHang.linkSize(SwingConstants.VERTICAL, new Component[] {lbl_txt_TongTien, cbo_TraKhachHang, btnTimKhachHang, lbl_txt_HoTenKhachHang, lbl_txt_GioiTinh, lbl_txt_SoDienThoai});
		pnLapDatHang.setLayout(gl_pnLapDatHang);
        this.setLayout(layout);
        addAction();
        
    }// </editor-fold>//GEN-END:initComponents
    private void addAction()
    {
    	btnDatHang.addActionListener(this);
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
    	sqlSanPham_BUS.xuatDanhSachSanPham_DonDat(dtm_SP);
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
			JOptionPane.showMessageDialog(null, "Vui lòng chọn số điện thoại để tra.", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
    	}
    	else
    	{
    		lbl_txt_HoTenKhachHang.setText(sqlCTDonDatHang_BUS.getHoTen_KhachHang(sdt));
    		lbl_txt_SoDienThoai.setText(sqlCTDonDatHang_BUS.getSDT_KhachHang(sdt));
    		lbl_txt_GioiTinh.setText(gioiTinh_String(sdt));
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
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn số lượng phải lớn hơn 0.", "Cảnh báo.", JOptionPane.WARNING_MESSAGE);
	        spinner.setValue(0);
	        
		}
		else
		{
			
			if(row!=-1)
			{
				//public CTDonDatHang(double donGia, int soLuong, double thanhTien) 
	    		String maSP=tbl_DSSP.getValueAt(row, 0).toString();
				String giaBan=tbl_DSSP.getValueAt(row, 7).toString();
				String soLuongCon=tbl_DSSP.getValueAt(row, 8).toString();
				int soLuongCon_Int=Integer.parseInt(soLuongCon);
				if(soLuong>soLuongCon_Int)
				{
					UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
			        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
			        JOptionPane.showMessageDialog(null, "Số lượng đã chọn lớn hơn số lượng còn.", "Cảnh báo.", JOptionPane.WARNING_MESSAGE);
			        spinner.setValue(0);
				}
				else
				{
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
			}
			else
			{
				UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
		        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
		        JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm đề thêm vào giỏ.", "Thông báo.", JOptionPane.INFORMATION_MESSAGE);
			}
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
	        JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm loại bỏ.", "Thông báo.", JOptionPane.INFORMATION_MESSAGE);
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
	        JOptionPane.showMessageDialog(null, "Vui lòng tìm khách hàng để đặt hàng.", "Cảnh báo.", JOptionPane.WARNING_MESSAGE);
    	}
    	else
    	{
    		try
    		{
    			String sdt=lbl_txt_SoDienThoai.getText();
        		String gioiTinh=lbl_txt_GioiTinh.getText();
        		KhachHang k=new KhachHang();
        		k.setTenKH(tenKH);
        		k.setGioiTinh(gioiTinh_Boolean(gioiTinh));
        		k.setSdt(sdt);
        		Date ngayHienTai=new Date();
            	java.sql.Date sqlNgayHienTai = new java.sql.Date(ngayHienTai.getTime());
            	DonDatHang d=new DonDatHang();
            	d.setNgayDat(sqlNgayHienTai);
            	//System.out.println(sqlDonDatHang_BUS.getMaKH(k));
            	sqlDonDatHang_BUS.themDonDatHang(d,sqlDonDatHang_BUS.getMaKH(k),maNV);
            	resetTable_GioHang();
            	resetSearch();
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o=e.getSource();
		if(o.equals(btnTimKhachHang))
		{
			tim_KhachHang();
			
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
		        JOptionPane.showMessageDialog(null, "Giỏ hàng không được trống.", "Cảnh báo.", JOptionPane.WARNING_MESSAGE);
			}
		}
	}
}
