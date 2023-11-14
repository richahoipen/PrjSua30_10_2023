package dataBase_BUS;

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
	
	
}
