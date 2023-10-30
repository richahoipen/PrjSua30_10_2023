package interface_Method_Database;

import javax.swing.table.DefaultTableModel;

import customEntities.Custom_ComboBox;

import entities.NhaCungCap;

public interface Method_NhaCungCap {
	//NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdtNCC, String email) 
	public void xuatDanhSachNhaCungCap(DefaultTableModel dtm_NCC);
	public boolean themNhaCungCap(NhaCungCap n);
	public boolean capNhatNhaCungCap(NhaCungCap n);
	//Đẩy lên combobox
	public void dayComboBoxMaNCC(Custom_ComboBox cbMaNCC);
	public void dayComboBoxTenNCC(Custom_ComboBox cbo_TenNCC);
	public void dayComboBoxDiaChi(Custom_ComboBox cbo_DiaChi);
	public void dayComboBoxSoDienThoai(Custom_ComboBox cbo_SoDT);
	public void dayComboBoxEmail(Custom_ComboBox cbo_Email);
	//Chức năng tìm kiếm theo nhiều tiêu chí
	//tìm kiếm 1 tiêu chí
	
}
