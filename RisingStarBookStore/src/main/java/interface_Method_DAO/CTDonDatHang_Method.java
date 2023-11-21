package interface_Method_DAO;

import javax.swing.table.DefaultTableModel;

import entities.CTDonDatHang;
import entities.SanPham;

public interface CTDonDatHang_Method {
	public boolean themCTDonDatHang(SanPham s,CTDonDatHang c);
	public boolean xoaCTDonDatHang(SanPham s);
	//Tra Tìm kiếm Khách Hàng
	public String getHoTen_KhachHang(String sdt);
	public String getSDT_KhachHang(String sdt);
	public boolean getGioiTinh_KhachHang(String sdt);
	public boolean xuat_GioHang(DefaultTableModel dtm_CTDD);
	public double tinhTongTien_GioHang();
	//Xuất chi tiết đơn đặt
	public boolean xuat_CTDDH_TheoDonDat(String maDDH,DefaultTableModel dtm_CTDDH);
	//Các đơn đã đặt
	public boolean themCTDonDatHang_Voi_DonDaDat(SanPham s,CTDonDatHang c,String maDDH);
	public boolean xoaCTDonDatHang_Voi_DonDaDat(SanPham s,String maDDH);
}
