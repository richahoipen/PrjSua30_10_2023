package interface_Method_DAO;

import javax.swing.table.DefaultTableModel;

import customEntities.Custom_ComboBox;
import entities.NhaCungCap;

public interface NhaCungCap_Method 
{
	public boolean xuatDanhSachNhaCungCap(DefaultTableModel dtm_NCC);
	public boolean themNhaCungCap(NhaCungCap n);
	public boolean capNhatNhaCungCap(NhaCungCap n);
	//Đẩy lên combobox
	public boolean dayComboBoxMaNCC(Custom_ComboBox cbMaNCC);
	public boolean dayComboBoxTenNCC(Custom_ComboBox cbo_TenNCC);
	public boolean dayComboBoxDiaChi(Custom_ComboBox cbo_DiaChi);
	public boolean dayComboBoxSoDienThoai(Custom_ComboBox cbo_SoDT);
	public boolean dayComboBoxEmail(Custom_ComboBox cbo_Email);
	public boolean timKiemTheoMaNCC(String maNCC, DefaultTableModel dtm_NCC);
	public boolean timKiemTheoTenNCC(String tenNCC, DefaultTableModel dtm_NCC);
	public boolean timKiemTheoDiaChi(String diaChi, DefaultTableModel dtm_NCC);
	public boolean timKiemTheoSoDienThoaiNCC(String sdtNCC, DefaultTableModel dtm_NCC);
	public boolean timKiemTheoEmail(String email, DefaultTableModel dtm_NCC);
	//Tìm kiếm đầy đủ điều kiện trừ maNCC
	public boolean timKiemTheoTieuChiKhacMaNCC(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	/*maNCC, tenNCC
	maNCC, diaChi
	maNCC, sdtNCC
	maNCC, email
	tenNCC, diaChi
	tenNCC, sdtNCC
	tenNCC, email
	diaChi, sdtNCC
	diaChi, email
	sdtNCC, email*/
	public boolean timKiemTheo_tenNCC_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public boolean timKiemTheo_tenNCC_sdtNCC(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public boolean timKiemTheo_tenNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public boolean timKiemTheo_diaChi_sdtNCC(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public boolean timKiemTheo_diaChi_email(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public boolean timKiemTheo_sdtNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	/*
	 {tenNCC, sdtNCC, email}
	{tenNCC, sdtNCC, diaChi}
	{	tenNCC, email, diaChi}
	{sdtNCC, email, diaChi}
	public boolean timKiemTheo_maNCC_tenNCC_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	/*
	maNCC, tenNCC, sdtNCC*/
	public boolean timKiemTheo_tenNCC_sdtNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public boolean timKiemTheo_tenNCC_sdtNCC_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public boolean timKiemTheo_tenNCC_email_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public boolean timKiemTheo_sdtNCC_email_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	//
	public String getMaNhaCungCap(String tenNCC);
	public String getTenNhaCungCap(String maNCC);
}
