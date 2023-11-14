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
	
}
