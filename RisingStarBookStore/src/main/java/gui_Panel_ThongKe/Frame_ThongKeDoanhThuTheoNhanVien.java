package gui_Panel_ThongKe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

import customEntities.CustomIcon;
import customEntities.CustomTable;
import javax.swing.table.DefaultTableModel;
import customEntities.Custom_Button;
import customEntities.XuatFile;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.Font;

public class Frame_ThongKeDoanhThuTheoNhanVien extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField txt_SoHoaDon;
	private JTextField txt_SLSPB;
	private JTextField txt_SoKhach;
	private DefaultTableModel dtm_ChiTiet;
	private JTextField txt_LoiNhuan;
	private JTextField txt_Chi;
	private JTextField txt_Thu;
	private JTextField txt_ThoiGianBatDau;
	private JTextField txt_LoaiThoiGian;
	private JTextField txt_ThoiGianKetThuc;
	private JTextField txt_ThoiGianXuat;
	private JPanel pn_Header;
	private JPanel pn_CuaHang;
	private JLabel lbl_TenCuaHang;
	private JLabel lbl_Hotline;
	private JLabel lbl_Title_Main;
	private JPanel pn_Center;
	private JPanel pn_ThongTin;
	private JLabel lbl_LoaiThoiGian;
	private JLabel lbl_ThoiGian;
	private JLabel lbl_ThoiGianBatDau;
	private Component lbl_ThoiGianKetThuc;
	private Component lbl_LuongHoaDon;
	private Component lbl_LuongKhachHang;
	private JLabel lbl_Chi;
	private JLabel lbl_Thu;
	private Component lbl_SLSPB;
	private JLabel lbl_LoiNhuan;
	private JPanel pn_Show;
	private Panel_ThongKeDoanhThuTheoNhanVien pn_Parent;
	private JLabel lbl_ShowName;
	private JLabel lbl_ShowName_1;
	private Custom_Button btn_XuatPDF;
	private JLabel lbl_NhanVien;
	private JTextField txt_NhanVien;
	private JTextField txt_NhanVienTong;
	private JLabel lbl_NhanVienTong;
	

	/**
	 * Create the frame.
	 */
	public Frame_ThongKeDoanhThuTheoNhanVien(Panel_ThongKeDoanhThuTheoNhanVien pnParent) {
		pn_Parent = (Panel_ThongKeDoanhThuTheoNhanVien) pnParent;
		setTitle("RisingStar - THỐNG KÊ THEO NHÂN VIÊN");
		setIconImage(new CustomIcon("src/main/images/view_image/Logo.png").getImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(500, 0);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		pn_Header = new JPanel();
		contentPane.add(pn_Header, BorderLayout.NORTH);
		pn_Header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		pn_CuaHang = new JPanel();
		pn_Header.add(pn_CuaHang);
		pn_CuaHang.setLayout(new MigLayout("", "[174px][174px]", "[14px][][]"));

		lbl_TenCuaHang = new JLabel("Rising Star -  Hiệu sách tư nhân số 1");
		lbl_TenCuaHang.setHorizontalAlignment(SwingConstants.CENTER);
		pn_CuaHang.add(lbl_TenCuaHang, "cell 0 0 2 1,growx,aligny center");

		lbl_Hotline = new JLabel("Hot line: 0938.060.080 - 0938.060.080 - 09195.09193");
		lbl_Hotline.setHorizontalAlignment(SwingConstants.CENTER);
		pn_CuaHang.add(lbl_Hotline, "cell 0 1 2 1,growx,aligny center");

		lbl_Title_Main = new JLabel("THỐNG KÊ THEO NHÂN VIÊN");
		lbl_Title_Main.setFont(new Font("Tahoma", Font.BOLD, 17));
		lbl_Title_Main.setHorizontalAlignment(SwingConstants.CENTER);
		pn_CuaHang.add(lbl_Title_Main, "cell 0 2 2 1,growx");

		pn_Center = new JPanel();
		contentPane.add(pn_Center, BorderLayout.CENTER);
		pn_Center.setLayout(new BorderLayout(0, 0));

		pn_ThongTin = new JPanel();
		pn_Center.add(pn_ThongTin, BorderLayout.NORTH);
		pn_ThongTin.setLayout(new MigLayout("", "[][grow][][grow]", "[][][][][][][]"));

		lbl_LoaiThoiGian = new JLabel("Loại thời gian");
		pn_ThongTin.add(lbl_LoaiThoiGian, "cell 0 0,alignx trailing");

		txt_LoaiThoiGian = new JTextField();
		txt_LoaiThoiGian.setEditable(false);
		txt_LoaiThoiGian.setColumns(10);
		txt_LoaiThoiGian.setCaretColor(UIManager.getColor("Button.background"));
		pn_ThongTin.add(txt_LoaiThoiGian, "cell 1 0,growx");

		lbl_ThoiGian = new JLabel("Thời gian xuất");
		pn_ThongTin.add(lbl_ThoiGian, "cell 2 0,alignx trailing");

		txt_ThoiGianXuat = new JTextField();
		txt_ThoiGianXuat.setEditable(false);
		txt_ThoiGianXuat.setColumns(10);
		txt_ThoiGianXuat.setCaretColor(UIManager.getColor("Button.background"));
		pn_ThongTin.add(txt_ThoiGianXuat, "cell 3 0,growx");

		lbl_ThoiGianBatDau = new JLabel("Thời gian bắt đầu");
		pn_ThongTin.add(lbl_ThoiGianBatDau, "cell 0 1,alignx trailing");

		txt_ThoiGianBatDau = new JTextField();
		txt_ThoiGianBatDau.setEditable(false);
		txt_ThoiGianBatDau.setColumns(10);
		txt_ThoiGianBatDau.setCaretColor(UIManager.getColor("Button.background"));
		pn_ThongTin.add(txt_ThoiGianBatDau, "cell 1 1,growx");

		lbl_ThoiGianKetThuc = new JLabel("Thời gian kết thúc");
		pn_ThongTin.add(lbl_ThoiGianKetThuc, "cell 2 1,alignx trailing");

		txt_ThoiGianKetThuc = new JTextField();
		txt_ThoiGianKetThuc.setEditable(false);
		txt_ThoiGianKetThuc.setColumns(10);
		txt_ThoiGianKetThuc.setCaretColor(UIManager.getColor("Button.background"));
		pn_ThongTin.add(txt_ThoiGianKetThuc, "cell 3 1,growx");

		lbl_LuongHoaDon = new JLabel("Số hóa đơn");
		pn_ThongTin.add(lbl_LuongHoaDon, "cell 0 2,alignx trailing");

		txt_SoHoaDon = new JTextField();
		txt_SoHoaDon.setEditable(false);
		txt_SoHoaDon.setCaretColor(txt_SoHoaDon.getBackground());
		pn_ThongTin.add(txt_SoHoaDon, "cell 1 2,growx");
		txt_SoHoaDon.setColumns(10);

		lbl_Thu = new JLabel("Thu");
		pn_ThongTin.add(lbl_Thu, "cell 2 2,alignx trailing");

		txt_Thu = new JTextField();
		txt_Thu.setEditable(false);
		txt_Thu.setColumns(10);
		txt_Thu.setCaretColor(UIManager.getColor("Button.background"));
		pn_ThongTin.add(txt_Thu, "cell 3 2,growx");

		lbl_LuongKhachHang = new JLabel("Lượng khách");
		pn_ThongTin.add(lbl_LuongKhachHang, "cell 0 3,alignx trailing");

		txt_SoKhach = new JTextField();
		txt_SoKhach.setEditable(false);
		txt_SoKhach.setCaretColor(txt_SoKhach.getBackground());
		txt_SoKhach.setColumns(10);
		pn_ThongTin.add(txt_SoKhach, "cell 1 3,growx");

		lbl_Chi = new JLabel("Chi");
		pn_ThongTin.add(lbl_Chi, "cell 2 3,alignx trailing");

		txt_Chi = new JTextField();
		txt_Chi.setEditable(false);
		txt_Chi.setColumns(10);
		txt_Chi.setCaretColor(UIManager.getColor("Button.background"));
		pn_ThongTin.add(txt_Chi, "cell 3 3,growx");

		lbl_SLSPB = new JLabel("Lượng sản phẩm bán được");
		pn_ThongTin.add(lbl_SLSPB, "cell 0 4,alignx trailing");

		txt_SLSPB = new JTextField();
		txt_SLSPB.setEditable(false);
		txt_SLSPB.setCaretColor(txt_SLSPB.getBackground());
		txt_SLSPB.setColumns(10);
		pn_ThongTin.add(txt_SLSPB, "cell 1 4,growx");

		lbl_LoiNhuan = new JLabel("Lợi nhuận");
		pn_ThongTin.add(lbl_LoiNhuan, "cell 2 4,alignx trailing");

		txt_LoiNhuan = new JTextField();
		txt_LoiNhuan.setEditable(false);
		txt_LoiNhuan.setColumns(10);
		txt_LoiNhuan.setCaretColor(UIManager.getColor("Button.background"));
		pn_ThongTin.add(txt_LoiNhuan, "cell 3 4,growx");
		
		btn_XuatPDF = new Custom_Button();
		btn_XuatPDF.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		btn_XuatPDF.setText("Xuất pdf");
		btn_XuatPDF.setPreferredSize(new Dimension(100, 40));
		btn_XuatPDF.addActionListener(this);
		
		lbl_NhanVien = new JLabel("Số lượng nhân viên");
		pn_ThongTin.add(lbl_NhanVien, "cell 0 5,alignx trailing");
		
		txt_NhanVien = new JTextField();
		txt_NhanVien.setText((String) null);
		txt_NhanVien.setEditable(false);
		txt_NhanVien.setColumns(10);
		txt_NhanVien.setCaretColor(UIManager.getColor("Button.background"));
		pn_ThongTin.add(txt_NhanVien, "cell 1 5,growx");
		
		lbl_NhanVienTong = new JLabel("Tổng nhân viên hiện có");
		pn_ThongTin.add(lbl_NhanVienTong, "cell 2 5,alignx trailing");
		
		txt_NhanVienTong = new JTextField();
		txt_NhanVienTong.setText((String) null);
		txt_NhanVienTong.setEditable(false);
		txt_NhanVienTong.setColumns(10);
		txt_NhanVienTong.setCaretColor(UIManager.getColor("Button.background"));
		pn_ThongTin.add(txt_NhanVienTong, "cell 3 5,growx");
		pn_ThongTin.add(btn_XuatPDF, "cell 0 6");
		lbl_ShowName = new JLabel("Biểu đồ");
		lbl_ShowName.setFont(new Font("Tahoma", Font.BOLD, 14));
		pn_Center.add(lbl_ShowName, BorderLayout.SOUTH);
		lbl_ShowName.setHorizontalAlignment(SwingConstants.CENTER);

		pn_Show = new JPanel();
		pn_Show = pn_Parent.tinhBieuDo();
		contentPane.add(pn_Show, BorderLayout.SOUTH);
		setSize(1280,700);
		setComponent();
	}
	private void setComponent() {
		String loaiThoiGian = pn_Parent.getCbo_LoaiThoiGian().getSelectedItem().toString();
		switch (loaiThoiGian) {
    	case "By day":
    		loaiThoiGian = "Theo ngày";
    		break;
    	case "By week":
    		loaiThoiGian = "Theo tuần";
    		break;
    	case "By month":
    		loaiThoiGian = "Theo tháng";
    		break;
    	case "By quarter":
    		loaiThoiGian = "Theo quý";
    		break;
    	case "By year":
    		loaiThoiGian = "Theo năm";
    		break;
		}
		String loc = "";
	    if (pn_Parent.getCbo_Loc().getSelectedItem()==null||pn_Parent.getCbo_Loc().getSelectedItem().equals("All employees")){
	    	loc = "Tất cả nhân viên";
	    }
	    if (loc.equals("Tất cả nhân viên")) {
	    	System.out.println("a");
	    	lbl_NhanVien.setText("Lượng nhân viên theo thời gian");
	    	txt_NhanVien.setText(pn_Parent.getTxt_Read_NVLoc().getText());
	    	lbl_ShowName.setText("Biểu đồ thống kê doanh thu - chi - lợi theo top 10 nhân viên");
	    }
	    else {
	    	lbl_NhanVien.setText("Mã nhân viên");
	    	txt_NhanVien.setText(loc);
	    	lbl_ShowName.setText("Biểu đồ thống kê doanh thu - chi - lợi theo nhân viên");
	    }
	    txt_NhanVienTong.setText(pn_Parent.getTxt_Read_NVTong().getText());
		txt_LoaiThoiGian.setText(loaiThoiGian);
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
		txt_ThoiGianXuat.setText(now.format(formatter1));
		SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
		txt_ThoiGianBatDau.setText(formatter2.format(pn_Parent.getDcr_NgayBatDau().getDate()));
		txt_ThoiGianKetThuc.setText(formatter2.format(pn_Parent.getDcr_NgayKetThuc().getDate()));
		
		txt_SoHoaDon.setText(pn_Parent.getTxt_read_SoLuongHoaDon().getText());
		txt_SoKhach.setText(pn_Parent.getTxt_read_SoLuongKhach().getText());
		txt_SLSPB.setText(pn_Parent.getTxt_read_SoLuongSanPhamBanDuoc().getText());
		
		txt_Thu.setText(pn_Parent.getTxt_read_DoanhThu().getText());
		txt_Chi.setText(pn_Parent.getTxt_read_Chi().getText());
		txt_LoiNhuan.setText(pn_Parent.getTxt_read_LoiNhuan().getText());
		//pn_ThongTin.setPreferredSize(new Dimension(600,200));
		pn_Show.setPreferredSize(new Dimension(1280,300));
		
		pn_Show.add(new JLabel("a"));
		pn_Show.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o.equals(btn_XuatPDF)) {
			btn_XuatPDF.setVisible(false);
			XuatFile.saveToPDF(this, "Thống kê doanh thu theo nhân viên");
			btn_XuatPDF.setVisible(true);
		}
	}

}
