package gui_Panel_NhanVien;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
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
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.awt.event.ActionEvent;

public class Frame_HoaDonXuat extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txt_SoHoaDon;
	private JTextField txt_NhanVien;
	private JTextField txt_KhachHang;
	private JTextField txt_SoDienThoai;
	private JTextField txt_ThoiGianThanhToan;
	private JTextField txt_TongCong;
	private JTextField txt_TienKhachDua;
	private JTextField txt_TienThua;
	private Custom_Button btn_XuatPDF;
	private DefaultTableModel dtm_ChiTiet;
	private String maHD;
	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame_HoaDonXuat frame = new Frame_HoaDonXuat();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame_HoaDonXuat() {
		setTitle("Thanh toán hóa đơn");
		setIconImage(new CustomIcon("src/main/images/view_image/Logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setLocation(500,0);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel pn_Header = new JPanel();
		contentPane.add(pn_Header, BorderLayout.NORTH);
		pn_Header.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel pn_CuaHang = new JPanel();
		pn_Header.add(pn_CuaHang);
		pn_CuaHang.setLayout(new MigLayout("", "[174px][174px]", "[14px][][]"));
		
		JLabel lbl_TenCuaHang = new JLabel("Rising Star -  Hiệu sách tư nhân số 1");
		lbl_TenCuaHang.setHorizontalAlignment(SwingConstants.CENTER);
		pn_CuaHang.add(lbl_TenCuaHang, "cell 0 0 2 1,growx,aligny center");
		
		JLabel lbl_Hotline = new JLabel("Hot line: 0938.060.080 - 0938.060.080 - 09195.09193");
		lbl_Hotline.setHorizontalAlignment(SwingConstants.CENTER);
		pn_CuaHang.add(lbl_Hotline, "cell 0 1 2 1,growx,aligny center");
		
		JLabel lbl_TenCuaHang_1_1 = new JLabel("HÓA ĐƠN THANH TOÁN");
		lbl_TenCuaHang_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		pn_CuaHang.add(lbl_TenCuaHang_1_1, "cell 0 2 2 1,growx");
		
		JPanel pn_Center = new JPanel();
		contentPane.add(pn_Center, BorderLayout.CENTER);
		pn_Center.setLayout(new BorderLayout(0, 0));
		
		JPanel pn_ThongTin = new JPanel();
		pn_Center.add(pn_ThongTin, BorderLayout.NORTH);
		pn_ThongTin.setLayout(new MigLayout("", "[][][][][grow]", "[][][][][]"));
		
		JLabel lbl_SoHoaDon = new JLabel("Số hóa đơn");
		pn_ThongTin.add(lbl_SoHoaDon, "cell 1 0,alignx leading");
		
		txt_SoHoaDon = new JTextField();
		txt_SoHoaDon.setEditable(false);
		txt_SoHoaDon.setCaretColor(txt_SoHoaDon.getBackground());
		pn_ThongTin.add(txt_SoHoaDon, "cell 3 0 2 1,growx");
		txt_SoHoaDon.setColumns(10);

		JLabel lbl_NhanVien = new JLabel("Nhân viên");
		pn_ThongTin.add(lbl_NhanVien, "flowy,cell 1 1,alignx leading");

		txt_NhanVien = new JTextField();
		txt_NhanVien.setEditable(false);
		txt_NhanVien.setCaretColor(txt_NhanVien.getBackground());
		txt_NhanVien.setColumns(10);
		pn_ThongTin.add(txt_NhanVien, "cell 3 1 2 1,growx");

		JLabel lbl_KhachHang = new JLabel("Khách hàng");
		pn_ThongTin.add(lbl_KhachHang, "cell 1 2,alignx leading");

		txt_KhachHang = new JTextField();
		txt_KhachHang.setEditable(false);
		txt_KhachHang.setCaretColor(txt_KhachHang.getBackground());
		txt_KhachHang.setColumns(10);
		pn_ThongTin.add(txt_KhachHang, "cell 3 2 2 1,growx");

		JLabel lbl_SDT = new JLabel("Số điện thoại khách hàng");
		pn_ThongTin.add(lbl_SDT, "flowy,cell 1 3,alignx leading");

		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setEditable(false);
		txt_SoDienThoai.setCaretColor(txt_SoDienThoai.getBackground());
		txt_SoDienThoai.setColumns(10);
		pn_ThongTin.add(txt_SoDienThoai, "cell 3 3 2 1,growx");

		JLabel lbl_ThoiGianThanhToan = new JLabel("Thời gian thanh toán");
		pn_ThongTin.add(lbl_ThoiGianThanhToan, "cell 1 4,alignx leading");

		txt_ThoiGianThanhToan = new JTextField();
		txt_ThoiGianThanhToan.setEditable(false);
		txt_ThoiGianThanhToan.setCaretColor(txt_ThoiGianThanhToan.getBackground());
		txt_ThoiGianThanhToan.setColumns(10);
		pn_ThongTin.add(txt_ThoiGianThanhToan, "cell 3 4 2 1,growx");

		JPanel pn_ThanhToan = new JPanel();
		pn_Center.add(pn_ThanhToan, BorderLayout.SOUTH);
		pn_ThanhToan.setLayout(new MigLayout("", "[53px][][][][][grow]", "[14px][][]"));

		JLabel lbl_TongCong = new JLabel("Tổng cộng");
		pn_ThanhToan.add(lbl_TongCong, "cell 4 0,alignx trailing");

		txt_TongCong = new JTextField();
		txt_TongCong.setEditable(false);
		txt_TongCong.setCaretColor(txt_TongCong.getBackground());
		txt_TongCong.setColumns(10);
		pn_ThanhToan.add(txt_TongCong, "cell 5 0,growx");

		btn_XuatPDF = new Custom_Button();
		btn_XuatPDF.addActionListener(this);
		btn_XuatPDF.setPreferredSize(new Dimension(100,40));
		btn_XuatPDF.setText("Xuất pdf");
		pn_ThanhToan.add(btn_XuatPDF, "cell 0 0 3 3,growx,aligny top");

		JLabel lbl_TienKhachDua = new JLabel("Tiền khách đưa");
		pn_ThanhToan.add(lbl_TienKhachDua, "cell 4 1,alignx trailing");

		txt_TienKhachDua = new JTextField();
		txt_TienKhachDua.setEditable(false);
		txt_TienKhachDua.setCaretColor(txt_TienKhachDua.getBackground());
		txt_TienKhachDua.setColumns(10);
		pn_ThanhToan.add(txt_TienKhachDua, "cell 5 1,growx");

		JLabel lbl_TienKhachDua_1 = new JLabel("Tiền thừa");
		pn_ThanhToan.add(lbl_TienKhachDua_1, "cell 4 2,alignx trailing");

		txt_TienThua = new JTextField();
		txt_TienThua.setEditable(false);
		txt_TienThua.setCaretColor(txt_TienThua.getBackground());
		txt_TienThua.setColumns(10);
		pn_ThanhToan.add(txt_TienThua, "cell 5 2,growx");

		
		JScrollPane scr_ChiTiet = new JScrollPane();
		pn_Center.add(scr_ChiTiet, BorderLayout.CENTER);
		
		CustomTable customTable = new CustomTable();
		customTable.setModel(dtm_ChiTiet = new DefaultTableModel(
			new String[] {
				"STT", "Tên sản phẩm", "Giá", "Số lượng", "Thành tiền"
			}
		,0));
		
		/*
		for (int i = 1; i <= 20; i++) {
		    dtm_ChiTiet.addRow(new Object[] {
		        i, // Số thứ tự
		        "Sản phẩm " + i, // Tên sản phẩm
		        i * 10000, // Giá
		        i, // Số lượng
		        i * i * 10000 // Thành tiền
		    });
		}*/
		scr_ChiTiet.setViewportView(customTable);
		JPanel pn_KyTen = new JPanel();
		pn_KyTen.setPreferredSize(new Dimension(pn_KyTen.getPreferredSize().width, 100));
		contentPane.add(pn_KyTen, BorderLayout.SOUTH);
		pn_KyTen.setLayout(new MigLayout("", "[grow, fill][grow, fill]", ""));

        // Thêm các JLabel vào JPanel
		JLabel lbl_KyTenKhachHang = new JLabel("Khách hàng");
		lbl_KyTenKhachHang.setHorizontalAlignment(SwingConstants.CENTER);
		pn_KyTen.add(lbl_KyTenKhachHang, "align center");
		JLabel lbl_KyTenNhanVien = new JLabel("Nhân viên");
		lbl_KyTenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		pn_KyTen.add(lbl_KyTenNhanVien, "align center");
		setSize(customTable.getPreferredSize().width+400, customTable.getPreferredSize().height+400);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		if(o == btn_XuatPDF) {
			btn_XuatPDF.setVisible(false);
			XuatFile.saveToPDF(this, "Hóa đơn mới");
		}
	}

}
