package interface_Method_DAO;

import javax.swing.table.DefaultTableModel;

import customEntities.Custom_ComboBox;
import entities.KhachHang;

public interface KhachHang_Method 
{
	public boolean xuatDanhSachKhachHang(DefaultTableModel dtm_KH);
	public boolean themKhachHang(KhachHang k);
	public boolean capNhatKhachHang(KhachHang k);
	public boolean dayComboBoxMaKH(Custom_ComboBox cbMaKH);
	public boolean dayComboBoxTenKH(Custom_ComboBox cbo_HoTen) ;
	public boolean dayComboBoxSDT(Custom_ComboBox cbo_SoDienThoai);
	public boolean dayComboBoxDiaChi(Custom_ComboBox cbo_DiaChi) ;
	public boolean timKiemTheoMaKH(String maKHCanTruyVan, DefaultTableModel dtm_KH);
	public boolean timKiemTheoGioiTinh(String gioiTinhCanTruyVan, DefaultTableModel dtm_KH);
	public boolean timKiemTheoDiaChi(String diaChiCanTruyVan, DefaultTableModel dtm_KH);
	public boolean timKiemTheoTen(String tenCanTruyVan, DefaultTableModel dtm_KH);
	public boolean timKiemTheoSDT(String sdtTruyVan, DefaultTableModel dtm_KH);
	public boolean timKiemTheoTieuChiKhacMaKH(KhachHang k, DefaultTableModel dtm_KH);
	
	/*
	 * Lấy tenKH và sdt.
	Lấy tenKH và diaChi.
	Lấy tenKH và gioiTinh.
	Lấy sdt và diaChi.
	Lấy sdt và gioiTinh.
	Lấy diaChi và gioiTinh.
	 */	
	public boolean timKiemTheo_tenKH_sdt(KhachHang k,DefaultTableModel dtm_KH);
	public boolean timKiemTheo_tenKH_diaChi(KhachHang k,DefaultTableModel dtm_KH);
	public boolean timKiemTheo_tenKH_gioiTinh(KhachHang k,DefaultTableModel dtm_KH);
	public boolean timKiemTheo_sdt_diaChi(KhachHang k,DefaultTableModel dtm_KH);
	public boolean timKiemTheo_sdt_gioiTinh(KhachHang k,DefaultTableModel dtm_KH);
	public boolean timKiemTheo_diaChi_gioiTinh(KhachHang k,DefaultTableModel dtm_KH);
	/*
	 * Lấy tenKH, sdt, và diaChi.
		Lấy tenKH, sdt, và gioiTinh.
		Lấy tenKH, diaChi, và gioiTinh.
		Lấy sdt, diaChi, và gioiTinh.
	 */
	
	public boolean timKiemTheo_tenKH_sdt_diaChi(KhachHang k,DefaultTableModel dtm_KH);
	public boolean timKiemTheo_tenKH_sdt_gioiTinh(KhachHang k,DefaultTableModel dtm_KH);
	public boolean timKiemTheo_tenKH_diaChi_gioiTinh(KhachHang k,DefaultTableModel dtm_KH);
	public boolean timKiemTheo_sdt_diaChi_gioiTinh(KhachHang k,DefaultTableModel dtm_KH);
}
