package interface_Method_ArrayList;

import javax.swing.table.DefaultTableModel;

import entities.KhachHang;



public interface Method_ArrayList_KhachHang 
{
	public boolean themKH(KhachHang k);
	public KhachHang timKiemKhachHang(String maKH);
	public boolean xoaKhachHang(String maKHCanXoa);
	public void xuatBangTheo_DiaChi(String diaChi,DefaultTableModel dtm_KH);
	public void xuatBangTheo_Ten(String ten,DefaultTableModel dtm_KH);
	//public void xuatBangtimKiemTheo_TieuChiKhacMaKH(KhachHang k, DefaultTableModel dtm_KH);
}
