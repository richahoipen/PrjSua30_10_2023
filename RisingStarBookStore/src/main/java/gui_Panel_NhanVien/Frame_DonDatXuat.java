package gui_Panel_NhanVien;

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
import javax.swing.JTable;

import customEntities.CustomIcon;
import customEntities.CustomTable;
import javax.swing.table.DefaultTableModel;
import customEntities.Custom_Button;
import customEntities.XuatFile;
import dataBase_BUS.HoaDon_BUS;
import dataBase_BUS.NhanVien_BUS;
import dataBase_BUS.SanPham_BUS;
import entities.CTDonDatHang;
import entities.HoaDon;
import gui_Panel_NhanVien.Panel_LapHoaDon;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;

public class Frame_DonDatXuat extends JFrame implements ActionListener{

	private JPanel contentPane;
	private JTextField txt_SoDonDat;
	private JTextField txt_NhanVien;
	private JTextField txt_KhachHang;
	private JTextField txt_SoDienThoai;
	private JTextField txt_ThoiGianThanhToan;
	private JTextField txt_TongCong;
	private Custom_Button btn_GuiSMS;
	private DefaultTableModel dtm_ChiTiet;
	private Panel_LapHoaDon pn_Parent;
	private Container tbl_ChiTiet;
	//private JScrollPane scr_ChiTiet=new JScrollPane();
	private Container pn_Center;
	private Container pn_ThanhToan;
	private Component lbl_TongCong;
	private Container pn_ThongTin;
	private JLabel lbl_ThoiGianDat;
	private JLabel lbl_SDT;
	private JLabel lbl_KhachHang;
	private JLabel lbl_NhanVien;
	private JLabel lbl_SoHoaDon;
	private JPanel pn_Header;
	private JPanel pn_CuaHang;
	private JLabel lbl_TenCuaHang;
	private JLabel lbl_Hotline;
	private JLabel lbl_TenPhieu;
	//private HoaDon hoaDon;
	private JLabel lbl_NgayHetHan;
	private JTextField txt_NgayHetHan;
	private HoaDon_BUS sqlHoaDon_BUS=new HoaDon_BUS();
	private NhanVien_BUS sqlNhanVien_BUS=new NhanVien_BUS();
	private SanPham_BUS sqlSanPham_BUS=new SanPham_BUS();
	private String maDDH, maNV, tenKH, sdt,ngayDat,ngayHetHan;
	private Time gioDat;
	private ArrayList<CTDonDatHang> listCTDonDatHang;
	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getMaDDH() {
		return maDDH;
	}

	public void setMaDDH(String maDDH) {
		this.maDDH = maDDH;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getNgayDat() {
		return ngayDat;
	}

	public void setNgayDat(String ngayDat) {
		this.ngayDat = ngayDat;
	}

	public String getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(String ngayHetHan) {
		this.ngayHetHan = ngayHetHan;
	}

	public Time getGioDat() {
		return gioDat;
	}

	public void setGioDat(Time gioDat) {
		this.gioDat = gioDat;
	}

	//private String maNV, 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String maDDH="DDH50";
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
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Frame_DonDatXuat(String maDDH,String maNV,String tenKH, String sdt,String ngayDat,String ngayHetHan,Time gioDat,ArrayList<CTDonDatHang> listCTDonDatHang) 
	{
		//set thuộc tính
		setMaDDH(maDDH);
		setMaNV(maNV);
		setTenKH(tenKH);
		setSdt(sdt);
		setNgayDat(ngayDat);
		setNgayHetHan(ngayHetHan);
		setGioDat(gioDat);
		setListCTDonDatHang(listCTDonDatHang);
		//this.pn_Parent = lapHoaDon;
		//this.hoaDon = hoaDon;
		setTitle("Đơn đặt");
		setIconImage(new CustomIcon("src/main/images/view_image/Logo.png").getImage());
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocation(500,0);
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
		
		lbl_TenPhieu = new JLabel("THÔNG TIN ĐẶT HÀNG");
		lbl_TenPhieu.setHorizontalAlignment(SwingConstants.CENTER);
		pn_CuaHang.add(lbl_TenPhieu, "cell 0 2 2 1,growx");
		
		pn_Center = new JPanel();
		contentPane.add(pn_Center, BorderLayout.CENTER);
		pn_Center.setLayout(new BorderLayout(0, 0));
		
		pn_ThongTin = new JPanel();
		pn_Center.add(pn_ThongTin, BorderLayout.NORTH);
		pn_ThongTin.setLayout(new MigLayout("", "[][][][][grow]", "[][][][][][]"));
		
		lbl_SoHoaDon = new JLabel("Số đơn đặt");
		pn_ThongTin.add(lbl_SoHoaDon, "cell 1 0,alignx leading");
		
		txt_SoDonDat = new JTextField();
		txt_SoDonDat.setEditable(false);
		txt_SoDonDat.setCaretColor(txt_SoDonDat.getBackground());
		pn_ThongTin.add(txt_SoDonDat, "cell 3 0 2 1,growx");
		txt_SoDonDat.setColumns(10);

		lbl_NhanVien = new JLabel("Nhân viên");
		pn_ThongTin.add(lbl_NhanVien, "flowy,cell 1 1,alignx leading");

		txt_NhanVien = new JTextField();
		txt_NhanVien.setEditable(false);
		txt_NhanVien.setCaretColor(txt_NhanVien.getBackground());
		txt_NhanVien.setColumns(10);
		pn_ThongTin.add(txt_NhanVien, "cell 3 1 2 1,growx");

		lbl_KhachHang = new JLabel("Khách hàng");
		pn_ThongTin.add(lbl_KhachHang, "cell 1 2,alignx leading");

		txt_KhachHang = new JTextField();
		txt_KhachHang.setEditable(false);
		txt_KhachHang.setCaretColor(txt_KhachHang.getBackground());
		txt_KhachHang.setColumns(10);
		pn_ThongTin.add(txt_KhachHang, "cell 3 2 2 1,growx");

		lbl_SDT = new JLabel("Số điện thoại khách hàng");
		pn_ThongTin.add(lbl_SDT, "flowy,cell 1 3,alignx leading");

		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setEditable(false);
		txt_SoDienThoai.setCaretColor(txt_SoDienThoai.getBackground());
		txt_SoDienThoai.setColumns(10);
		pn_ThongTin.add(txt_SoDienThoai, "cell 3 3 2 1,growx");

		lbl_ThoiGianDat = new JLabel("Thời gian đặt");
		pn_ThongTin.add(lbl_ThoiGianDat, "cell 1 4,alignx leading");

		txt_ThoiGianThanhToan = new JTextField();
		txt_ThoiGianThanhToan.setEditable(false);
		txt_ThoiGianThanhToan.setCaretColor(txt_ThoiGianThanhToan.getBackground());
		txt_ThoiGianThanhToan.setColumns(10);
		pn_ThongTin.add(txt_ThoiGianThanhToan, "cell 3 4 2 1,growx");
		
		lbl_NgayHetHan = new JLabel("Ngày hết hạn");
		pn_ThongTin.add(lbl_NgayHetHan, "cell 1 5");
		
		txt_NgayHetHan = new JTextField();
		//txt_NgayHetHan.setText("15:40:17 04/12/2023");
		txt_NgayHetHan.setEditable(false);
		txt_NgayHetHan.setColumns(10);
		txt_NgayHetHan.setCaretColor(UIManager.getColor("Button.background"));
		pn_ThongTin.add(txt_NgayHetHan, "cell 3 5 2 1,growx");
		
		JScrollPane scr_ChiTiet = new JScrollPane();
		pn_Center.add(scr_ChiTiet, BorderLayout.CENTER);
		
		
		
		CustomTable customTable = new CustomTable();
		customTable.setPreferredSize(new Dimension(300,700));
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

		pn_ThanhToan = new JPanel();
		pn_Center.add(pn_ThanhToan, BorderLayout.SOUTH);
		pn_ThanhToan.setLayout(new MigLayout("", "[53px][][][][][grow]", "[14px][][]"));

		lbl_TongCong = new JLabel("Tổng cộng");
		pn_ThanhToan.add(lbl_TongCong, "cell 4 0,alignx trailing");

		txt_TongCong = new JTextField();
		txt_TongCong.setEditable(false);
		txt_TongCong.setCaretColor(txt_TongCong.getBackground());
		txt_TongCong.setColumns(10);
		pn_ThanhToan.add(txt_TongCong, "cell 5 0,growx");

		btn_GuiSMS = new Custom_Button();
		btn_GuiSMS.setColor_Border(Color.CYAN);
		btn_GuiSMS.addActionListener(this);
		btn_GuiSMS.setPreferredSize(new Dimension(100,40));
		btn_GuiSMS.setText("Gửi SMS");
		btn_GuiSMS.setBorder(BorderFactory.createLineBorder(Color.CYAN));
		pn_ThanhToan.add(btn_GuiSMS, "cell 0 0 3 2,growx,aligny top");

		
		
		setSize(555, 682);
		//setComponent();
		addActions();
		addComponents();
		addTable();
	}
	private void addTable()
	{
		int i=1;
		double tongTien=0;
		for(CTDonDatHang c:listCTDonDatHang)
		{
			String[] row= {Integer.toString(i), sqlSanPham_BUS.getTenSP_TheoMa(c.getMaSP()),Double.toString(c.getDonGia()),Integer.toString(c.getSoLuong()),Double.toString(c.getThanhTien())};
			dtm_ChiTiet.addRow(row);
			tongTien+=c.getThanhTien();
			i++;
		}
		txt_TongCong.setText(Double.toString(tongTien));
	}
	private void addComponents()
	{
		txt_SoDonDat.setText(maDDH);
		txt_NhanVien.setText(sqlNhanVien_BUS.getTenNV(getMaNV()));
		txt_KhachHang.setText(tenKH);
		txt_SoDienThoai.setText(sdt);
		txt_ThoiGianThanhToan.setText("Ngày đặt: "+ngayDat+", giờ đặt: "+gioDat);
		txt_NgayHetHan.setText(ngayHetHan);
	}
	private void addActions()
	{
		btn_GuiSMS.addActionListener(this);
	}
	/*
	private void setComponent() {
		//Số hóa đơn nhật lo
		txt_SoDonDat.setText(pn_Parent.getLbl_txt_SoDienThoai().getText());
		txt_NhanVien.setText(hoaDon.getNhanVien().getTenNV());
		txt_KhachHang.setText(pn_Parent.getLbl_txt_HoTenKhachHang().getText());
		txt_SoDienThoai.setText(pn_Parent.getLbl_txt_SoDienThoai().getText());
		DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
		txt_ThoiGianThanhToan.setText(now.format(formatter1));
		txt_TongCong.setText(pn_Parent.getLbl_txt_TongTien().getText());
		tbl_ChiTiet = pn_Parent.getTbl_DSCTDD();
		scr_ChiTiet.setViewportView(tbl_ChiTiet);
		scr_ChiTiet.repaint();
	}*/
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object o = e.getSource();
		//String sdt=txt_SoDienThoai.getText();
		if(o == btn_GuiSMS) 
		{
			btn_GuiSMS.setVisible(false);

			String content = "";
				// Tạo nội dung thông báo
			content = "Xin chào " + txt_KhachHang.getText() + ",\n" +
				          "Đơn hàng của bạn với số đơn đặt " + txt_SoDonDat.getText() + " đã được đặt thành công.\n" +
				          "Thời gian thanh toán: " + txt_ThoiGianThanhToan.getText() + "\n" +
				          "Hãy lưu ý ngày hết hạn: " + txt_NgayHetHan.getText() + "\n" +
				          "Tổng cộng: " + txt_TongCong.getText() + "\n" +
				          "Cảm ơn bạn đã mua hàng từ chúng tôi!";

				// Gửi thông báo
				MessageSMS.sendMessage(content);
			btn_GuiSMS.setVisible(true);
		}
	}

	public ArrayList<CTDonDatHang> getListCTDonDatHang() {
		return listCTDonDatHang;
	}

	public void setListCTDonDatHang(ArrayList<CTDonDatHang> listCTDonDatHang) {
		this.listCTDonDatHang = listCTDonDatHang;
	}

}
