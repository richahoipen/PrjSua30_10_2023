package dataBase_BUS;

import java.sql.Date;

import javax.swing.table.DefaultTableModel;

import customEntities.Custom_ComboBox;
import dataBase_DAO.NhanVien_DAO;
import entities.NhanVien;
import entities.TaiKhoan;
import interface_Method_DAO.NhanVien_Method;

public class NhanVien_BUS implements NhanVien_Method
{
	private NhanVien_DAO sqlNhanVien_DAO=new NhanVien_DAO();
	@Override
	public boolean themNhanVien(NhanVien n,TaiKhoan t) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.themNhanVien(n,t);
	}

	@Override
	public boolean capNhatNhanVien(NhanVien n,TaiKhoan t) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.capNhatNhanVien(n, t);
	}

	@Override
	public boolean xuatDanhSachNhanVien(DefaultTableModel dtm_NV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.xuatDanhSachNhanVien(dtm_NV);
	}

	@Override
	public boolean dayComboBoxMaNV(Custom_ComboBox cbMaNV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.dayComboBoxMaNV(cbMaNV);
	}

	@Override
	public boolean dayComboBoxTenNV(Custom_ComboBox cbo_HoTen) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.dayComboBoxTenNV(cbo_HoTen);
	}

	@Override
	public boolean dayComboBoxCCCD(Custom_ComboBox cbCCCD) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.dayComboBoxCCCD(cbCCCD);
	}

	@Override
	public boolean dayComboBoxSDT(Custom_ComboBox cbo_sdt) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.dayComboBoxSDT(cbo_sdt);
	}

	@Override
	public boolean dayComboBoxDiaChi(Custom_ComboBox cbo_diaChi) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.dayComboBoxDiaChi(cbo_diaChi);
	}

	@Override
	public String getMatKhau(String maNV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.getMatKhau(maNV);
	}

	@Override
	public Date getNgaySinh(String maNV) {
		return sqlNhanVien_DAO.getNgaySinh(maNV);
	}
	//Day combobox
	@Override
	public boolean dayComboBoxGioiTinh(Custom_ComboBox cbo_GioiTinh) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.dayComboBoxGioiTinh(cbo_GioiTinh);
	}

	@Override
	public boolean dayComboNgaySinh(Custom_ComboBox cbo_Ngay, Custom_ComboBox cbo_Thang, Custom_ComboBox cbo_Nam) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean dayComboChucVu(Custom_ComboBox cbo_ChucVu) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.dayComboChucVu(cbo_ChucVu);
	}

	@Override
	public boolean dayComboBoxCaLam(Custom_ComboBox cbo_CaLam) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.dayComboBoxCaLam(cbo_CaLam);
	}

	@Override
	public boolean timKiemTheo_maNV(String maNV, DefaultTableModel dtm_NV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.timKiemTheo_maNV(maNV, dtm_NV);
	}

	@Override
	public boolean timKiemTheo_tenNV(String tenNV, DefaultTableModel dtm_NV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.timKiemTheo_tenNV(tenNV, dtm_NV);
	}

	@Override
	public boolean timKiemTheo_sdt(String sdt, DefaultTableModel dtm_NV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.timKiemTheo_sdt(sdt, dtm_NV);
	}

	@Override
	public boolean timKiemTheo_gioiTinh(String gioiTinh, DefaultTableModel dtm_NV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.timKiemTheo_gioiTinh(gioiTinh, dtm_NV);
	}

	@Override
	public boolean timKiemTheo_chucVu(String chucVu, DefaultTableModel dtm_NV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.timKiemTheo_chucVu(chucVu, dtm_NV);
	}

	@Override
	public boolean timKiemTheo_cCCD(String cCCD, DefaultTableModel dtm_NV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.timKiemTheo_cCCD(cCCD, dtm_NV);
	}

	@Override
	public boolean timKiemTheo_caLam(String caLam, DefaultTableModel dtm_NV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.timKiemTheo_caLam(caLam, dtm_NV);
	}

	@Override
	public boolean timKiemTheo_ngaySinh(int ngay, DefaultTableModel dtm_NV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.timKiemTheo_ngaySinh(ngay, dtm_NV);
	}

	@Override
	public boolean timKiemTheo_thangSinh(int thang, DefaultTableModel dtm_NV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.timKiemTheo_thangSinh(thang, dtm_NV);
	}

	@Override
	public boolean timKiemTheo_namSinh(int nam, DefaultTableModel dtm_NV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.timKiemTheo_namSinh(nam, dtm_NV);
	}

	@Override
	public boolean timKiemTheo_diaChi(String diaChi, DefaultTableModel dtm_NV) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.timKiemTheo_diaChi(diaChi, dtm_NV);
	}

	public NhanVien_BUS() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getTenNV(String maNV_CanTim) {
		// TODO Auto-generated method stub
		return sqlNhanVien_DAO.getTenNV(maNV_CanTim);
	}
	
}
