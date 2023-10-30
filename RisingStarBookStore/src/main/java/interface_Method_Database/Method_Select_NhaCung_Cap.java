package interface_Method_Database;

import javax.swing.table.DefaultTableModel;

import entities.NhaCungCap;

public interface Method_Select_NhaCung_Cap {
	public void timKiemTheoMaNCC(String maNCC, DefaultTableModel dtm_NCC);
	public void timKiemTheoTenNCC(String tenNCC, DefaultTableModel dtm_NCC);
	public void timKiemTheoDiaChi(String diaChi, DefaultTableModel dtm_NCC);
	public void timKiemTheoSoDienThoaiNCC(String sdtNCC, DefaultTableModel dtm_NCC);
	public void timKiemTheoEmail(String email, DefaultTableModel dtm_NCC);
	//Tìm kiếm đầy đủ điều kiện trừ maNCC
	public void timKiemTheoTieuChiKhacMaNCC(NhaCungCap ncc, DefaultTableModel dtm_NCC);
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
	public void timKiemTheo_tenNCC_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public void timKiemTheo_tenNCC_sdtNCC(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public void timKiemTheo_tenNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public void timKiemTheo_diaChi_sdtNCC(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public void timKiemTheo_diaChi_email(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public void timKiemTheo_sdtNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	/*
	 {tenNCC, sdtNCC, email}
	{tenNCC, sdtNCC, diaChi}
	{	tenNCC, email, diaChi}
	{sdtNCC, email, diaChi}
	public void timKiemTheo_maNCC_tenNCC_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	/*
	maNCC, tenNCC, sdtNCC*/
	public void timKiemTheo_tenNCC_sdtNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public void timKiemTheo_tenNCC_sdtNCC_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public void timKiemTheo_tenNCC_email_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC);
	public void timKiemTheo_sdtNCC_email_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC);
}
