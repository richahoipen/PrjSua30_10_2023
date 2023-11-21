package dataBase_BUS;

import javax.swing.table.DefaultTableModel;

import customEntities.Custom_ComboBox;
import dataBase_DAO.KhachHang_DAO;
import entities.KhachHang;
import interface_Method_DAO.KhachHang_Method;

public class KhachHang_BUS implements KhachHang_Method
{
	private KhachHang_DAO dataBase_KhachHang_DAO=new KhachHang_DAO();
	public KhachHang_BUS() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean xuatDanhSachKhachHang(DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.xuatDanhSachKhachHang(dtm_KH);
	}

	@Override
	public boolean themKhachHang(KhachHang k) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.themKhachHang(k);
	}

	@Override
	public boolean capNhatKhachHang(KhachHang k) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.capNhatKhachHang(k);
	}

	@Override
	public boolean dayComboBoxMaKH(Custom_ComboBox cbMaKH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.dayComboBoxMaKH(cbMaKH);
	}

	@Override
	public boolean dayComboBoxTenKH(Custom_ComboBox cbo_HoTen) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.dayComboBoxTenKH(cbo_HoTen);
	}

	@Override
	public boolean dayComboBoxSDT(Custom_ComboBox cbo_SoDienThoai) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.dayComboBoxSDT(cbo_SoDienThoai);
	}

	@Override
	public boolean dayComboBoxDiaChi(Custom_ComboBox cbo_DiaChi) {
	    // TODO Auto-generated method stub
	    return dataBase_KhachHang_DAO.dayComboBoxDiaChi(cbo_DiaChi);
	}


	@Override
	public boolean timKiemTheoMaKH(String maKHCanTruyVan, DefaultTableModel dtm_KH) {
	    // TODO Auto-generated method stub
	    return dataBase_KhachHang_DAO.timKiemTheoMaKH(maKHCanTruyVan, dtm_KH);
	}


	@Override
	public boolean timKiemTheoGioiTinh(String gioiTinhCanTruyVan, DefaultTableModel dtm_KH) {
	    // TODO Auto-generated method stub
	    return dataBase_KhachHang_DAO.timKiemTheoGioiTinh(gioiTinhCanTruyVan, dtm_KH);
	}


	@Override
	public boolean timKiemTheoDiaChi(String diaChiCanTruyVan, DefaultTableModel dtm_KH) {
	    // TODO Auto-generated method stub
	    return dataBase_KhachHang_DAO.timKiemTheoDiaChi(diaChiCanTruyVan, dtm_KH);
	}


	@Override
	public boolean timKiemTheoTen(String tenCanTruyVan, DefaultTableModel dtm_KH) {
	    // TODO Auto-generated method stub
	    return dataBase_KhachHang_DAO.timKiemTheoTen(tenCanTruyVan, dtm_KH);
	}


	@Override
	public boolean timKiemTheoSDT(String sdtTruyVan, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.timKiemTheoSDT(sdtTruyVan,  dtm_KH);
	}

	@Override
	public boolean timKiemTheoTieuChiKhacMaKH(KhachHang k, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.timKiemTheoTieuChiKhacMaKH(k, dtm_KH);
	}

	@Override
	public boolean timKiemTheo_tenKH_sdt(KhachHang k, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.timKiemTheo_tenKH_sdt(k, dtm_KH);
	}

	@Override
	public boolean timKiemTheo_tenKH_diaChi(KhachHang k, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.timKiemTheo_tenKH_diaChi(k, dtm_KH);
	}

	@Override
	public boolean timKiemTheo_tenKH_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.timKiemTheo_tenKH_gioiTinh(k, dtm_KH);
	}

	@Override
	public boolean timKiemTheo_sdt_diaChi(KhachHang k, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.timKiemTheo_sdt_diaChi(k, dtm_KH);
	}

	@Override
	public boolean timKiemTheo_sdt_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.timKiemTheo_sdt_gioiTinh(k, dtm_KH);
	}

	@Override
	public boolean timKiemTheo_diaChi_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.timKiemTheo_diaChi_gioiTinh(k, dtm_KH);
	}

	@Override
	public boolean timKiemTheo_tenKH_sdt_diaChi(KhachHang k, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.timKiemTheo_tenKH_sdt_diaChi(k, dtm_KH);
	}

	@Override
	public boolean timKiemTheo_tenKH_sdt_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.timKiemTheo_tenKH_sdt_gioiTinh(k, dtm_KH);
	}

	@Override
	public boolean timKiemTheo_tenKH_diaChi_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.timKiemTheo_tenKH_diaChi_gioiTinh(k, dtm_KH);
	}

	@Override
	public boolean timKiemTheo_sdt_diaChi_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.timKiemTheo_sdt_diaChi_gioiTinh(k, dtm_KH);
	}

	@Override
	public String getTenKhachHang_TheoMa(String maKH) {
		// TODO Auto-generated method stub
		return dataBase_KhachHang_DAO.getTenKhachHang_TheoMa(maKH);
	}
	
}
