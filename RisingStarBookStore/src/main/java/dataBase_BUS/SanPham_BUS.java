package dataBase_BUS;

import javax.swing.table.DefaultTableModel;

import customEntities.Custom_ComboBox;
import dataBase_DAO.SanPham_DAO;
import entities.SanPham;
import interface_Method_DAO.SanPham_Method;

public class SanPham_BUS implements SanPham_Method
{
	private SanPham_DAO sqlSanPham_DAO=new SanPham_DAO();
	@Override
	public boolean themSanPham(SanPham s, DefaultTableModel dtm_SP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.themSanPham(s, dtm_SP);
	}

	@Override
	public boolean capNhatSanPham(SanPham s, DefaultTableModel dtm_SP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.capNhatSanPham(s, dtm_SP);
	}

	@Override
	public boolean xuatDanhSachSanPham(DefaultTableModel dtm_SP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.xuatDanhSachSanPham(dtm_SP);
	}

	@Override
	public byte[] getBytesAnh(String maSP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.getBytesAnh(maSP);
	}

	@Override
	public boolean dayCombobox_maSP(Custom_ComboBox cbo_maSP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.dayCombobox_maSP(cbo_maSP);
	}

	@Override
	public boolean dayCombobox_tenSP(Custom_ComboBox cbo_tenSP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.dayCombobox_tenSP(cbo_tenSP);
	}

	@Override
	public boolean dayCombobox_loaiSP(Custom_ComboBox cbo_loaiSP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.dayCombobox_loaiSP(cbo_loaiSP);
	}

	@Override
	public boolean dayCombobox_tacGia(Custom_ComboBox cbo_tacGia) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.dayCombobox_tacGia(cbo_tacGia);
	}

	@Override
	public boolean dayCombobox_nhaXuatBan(Custom_ComboBox cbo_nhaXuatBan) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.dayCombobox_nhaXuatBan(cbo_nhaXuatBan);
	}

	@Override
	public boolean dayCombobox_namXuatBan(Custom_ComboBox cbo_namXuatBan) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.dayCombobox_namXuatBan(cbo_namXuatBan);
	}

	@Override
	public boolean dayCombobox_soLuong(Custom_ComboBox cbo_soLuong) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.dayCombobox_soLuong(cbo_soLuong);
	}

	@Override
	public boolean dayCombobox_soLuongBan(Custom_ComboBox cbo_soLuongBan) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.dayCombobox_soLuongBan(cbo_soLuongBan);
	}

	@Override
	public boolean dayCombobox_ngonNgu(Custom_ComboBox cbo_ngonNgu) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.dayCombobox_ngonNgu(cbo_ngonNgu);
	}

	@Override
	public boolean dayCombobox_giaNhap(Custom_ComboBox cbo_giaNhap) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.dayCombobox_giaNhap(cbo_giaNhap);
	}

	@Override
	public boolean dayCombobox_giaBan(Custom_ComboBox cbo_giaBan) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.dayCombobox_giaNhap(cbo_giaBan);
	}

	@Override
	public boolean timKiem_SanPham(SanPham s, DefaultTableModel dtm_SP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.timKiem_SanPham(s, dtm_SP);
	}

	public SanPham_BUS() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean xuatDanhSachSanPham_DonDat(DefaultTableModel dtm_SP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.xuatDanhSachSanPham_DonDat(dtm_SP);
	}

	@Override
	public boolean xuatDanhSachSanPham_LapHoaDon(DefaultTableModel dtm_SP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.xuatDanhSachSanPham_LapHoaDon(dtm_SP);
	}

	@Override
	public String getTenSP_TheoMa(String maSP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.getTenSP_TheoMa(maSP);
	}
	

}
