package dataBase_BUS;


import javax.swing.table.DefaultTableModel;

import dataBase_DAO.CTDonDatHang_DAO;
import entities.CTDonDatHang;
import entities.SanPham;
import interface_Method_DAO.CTDonDatHang_Method;

public class CTDonDatHang_BUS implements CTDonDatHang_Method {

	private CTDonDatHang_DAO sqlCTDonDatHang_DAO = new CTDonDatHang_DAO();

	public CTDonDatHang_BUS() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean themCTDonDatHang(SanPham s,CTDonDatHang c) {
		return sqlCTDonDatHang_DAO.themCTDonDatHang(s, c);
	}
	@Override
	public boolean xuat_GioHang(DefaultTableModel dtm_CTDD) {
		// TODO Auto-generated method stub
		return sqlCTDonDatHang_DAO.xuat_GioHang(dtm_CTDD);
	}
	@Override
	public boolean xoaCTDonDatHang(SanPham s) {
		// TODO Auto-generated method stub
		return sqlCTDonDatHang_DAO.xoaCTDonDatHang(s);
	}

	@Override
	public String getHoTen_KhachHang(String sdt) {
		return sqlCTDonDatHang_DAO.getHoTen_KhachHang(sdt);
	}

	@Override
	public String getSDT_KhachHang(String sdt) {
		// TODO Auto-generated method stub
		return sqlCTDonDatHang_DAO.getSDT_KhachHang(sdt);
	}

	@Override
	public boolean getGioiTinh_KhachHang(String sdt) {
		// TODO Auto-generated method stub
		return sqlCTDonDatHang_DAO.getGioiTinh_KhachHang(sdt);
	}

	@Override
	public double tinhTongTien_GioHang() {
		// TODO Auto-generated method stub
		return sqlCTDonDatHang_DAO.tinhTongTien_GioHang() ;
	}

	

	

}
