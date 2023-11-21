package dataBase_BUS;

import javax.swing.table.DefaultTableModel;

import dataBase_DAO.DonDatHang_DAO;
import entities.DonDatHang;
import entities.KhachHang;
import interface_Method_DAO.DonDatHang_Method;

public class DonDatHang_BUS implements DonDatHang_Method
{

	private DonDatHang_DAO sqlDonDatHang_DAO= new DonDatHang_DAO();
	public DonDatHang_BUS() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean themDonDatHang(DonDatHang d, String maKH, String maNV) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.themDonDatHang(d, maKH, maNV);
	}
	@Override
	public String getMaKH(KhachHang k) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.getMaKH(k);
	}
	@Override
	public boolean xuat_DonDat_ChuaThanhToan(String maNV, DefaultTableModel dtm_DD) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.xuat_DonDat_ChuaThanhToan(maNV, dtm_DD);
	}
	@Override
	public String getTenKH(String maDDH) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.getTenKH(maDDH);
	}
	@Override
	public String getSDT_KH(String maDDH) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.getSDT_KH(maDDH);
	}
	@Override
	public boolean getGioiTinh_KH(String maDDH) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.getGioiTinh_KH(maDDH);
	}
	@Override
	public double getTongTien_DonDatHang(String maDDH) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.getTongTien_DonDatHang(maDDH);
	}
	
	
}
