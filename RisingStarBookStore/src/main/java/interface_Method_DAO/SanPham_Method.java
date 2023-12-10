package interface_Method_DAO;

import javax.swing.table.DefaultTableModel;

import customEntities.Custom_ComboBox;
import entities.SanPham;

public interface SanPham_Method 
{
	public boolean themSanPham(SanPham s,DefaultTableModel dtm_SP);
	public boolean capNhatSanPham(SanPham s,DefaultTableModel dtm_SP);
	public boolean xuatDanhSachSanPham(DefaultTableModel dtm_SP);
	public byte[] getBytesAnh(String maSP);
	//Đẩy combobox
	//SanPham(String maSP, String tenSP, String loaiSP, String tacGia, String nhaXuatBan, int namXuatBan,
	//		int soLuong,int soLuongBan ,String ngonNgu, double giaNhap, double giaBan,
	public boolean dayCombobox_maSP(Custom_ComboBox cbo_maSP);
	public boolean dayCombobox_tenSP(Custom_ComboBox cbo_tenSP);
	public boolean dayCombobox_loaiSP(Custom_ComboBox cbo_loaiSP);
	public boolean dayCombobox_tacGia(Custom_ComboBox cbo_tacGia);
	public boolean dayCombobox_nhaXuatBan(Custom_ComboBox cbo_nhaXuatBan);
	public boolean dayCombobox_namXuatBan(Custom_ComboBox cbo_namXuatBan);
	public boolean dayCombobox_soLuong(Custom_ComboBox cbo_soLuong);
	public boolean dayCombobox_soLuongBan(Custom_ComboBox cbo_soLuongBan);
	public boolean dayCombobox_ngonNgu(Custom_ComboBox cbo_ngonNgu);
	public boolean dayCombobox_giaNhap(Custom_ComboBox cbo_giaNhap);
	public boolean dayCombobox_giaBan(Custom_ComboBox cbo_giaBan);
	//Tìm kiếm
	public boolean timKiem_SanPham(SanPham s,DefaultTableModel dtm_SP);
	//xuất đơn đặt
	public boolean xuatDanhSachSanPham_DonDat(DefaultTableModel dtm_SP);
	public boolean xuatDanhSachSanPham_LapHoaDon(DefaultTableModel dtm_SP);
	public String getTenSP_TheoMa(String maSP);
	
}
