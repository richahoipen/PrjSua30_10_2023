package interface_Method_DAO;

import java.sql.Date;

import javax.swing.table.DefaultTableModel;

import customEntities.Custom_ComboBox;
import entities.NhanVien;
import entities.TaiKhoan;

public interface NhanVien_Method 
{
	public boolean themNhanVien(NhanVien n,TaiKhoan t);
	public boolean capNhatNhanVien(NhanVien n,TaiKhoan t);
	public boolean xuatDanhSachNhanVien(DefaultTableModel dtm_NV);
	public String getMatKhau(String maNV);
	public Date getNgaySinh(String maNV);
	//day combobox
	public boolean dayComboBoxMaNV(Custom_ComboBox cbMaNV);
	public boolean dayComboBoxTenNV(Custom_ComboBox cbo_HoTen) ;
	public boolean dayComboBoxSDT(Custom_ComboBox cbo_sdt);	
	public boolean dayComboBoxGioiTinh(Custom_ComboBox cbo_GioiTinh);
	public boolean dayComboBoxDiaChi(Custom_ComboBox cbo_diaChi);
	public boolean dayComboNgaySinh(Custom_ComboBox cbo_Ngay,Custom_ComboBox cbo_Thang,Custom_ComboBox cbo_Nam);
	public boolean dayComboChucVu(Custom_ComboBox cbo_ChucVu);
	public boolean dayComboBoxCCCD(Custom_ComboBox cbo_CCCD);
	public boolean dayComboBoxCaLam(Custom_ComboBox cbo_CaLam);
	//Tìm kiếm theo từng 1 thuộc tính
	public boolean timKiemTheo_maNV(String maNV,DefaultTableModel dtm_NV);
	public boolean timKiemTheo_tenNV(String tenNV,DefaultTableModel dtm_NV);
	public boolean timKiemTheo_sdt(String sdt,DefaultTableModel dtm_NV);
	public boolean timKiemTheo_gioiTinh(String gioiTinh,DefaultTableModel dtm_NV);
	//public boolean timKiemTheo_NgaySinh(String ngay,String thang,String nam,DefaultTableModel dtm_NV);
	public boolean timKiemTheo_chucVu(String chucVu,DefaultTableModel dtm_NV);
	public boolean timKiemTheo_cCCD(String cCCD,DefaultTableModel dtm_NV);
	public boolean timKiemTheo_caLam(String caLam,DefaultTableModel dtm_NV);
	public boolean timKiemTheo_ngaySinh(int ngay,DefaultTableModel dtm_NV);
	public boolean timKiemTheo_thangSinh(int thang,DefaultTableModel dtm_NV);
	public boolean timKiemTheo_namSinh(int nam,DefaultTableModel dtm_NV);
	//tìm kiếm theo 2 thuộc tính
	
}
