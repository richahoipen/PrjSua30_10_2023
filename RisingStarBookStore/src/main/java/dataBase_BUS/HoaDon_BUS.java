package dataBase_BUS;

import java.util.ArrayList;

import dataBase_DAO.HoaDon_DAO;
import entities.CTDonDatHang;
import entities.HoaDon;
import interface_Method_DAO.HoaDon_Method;

public class HoaDon_BUS implements HoaDon_Method
{
	private HoaDon_DAO sqlHoaDon_DAO=new HoaDon_DAO();

	public HoaDon_BUS() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean themHoaDon(HoaDon h, String maNV, String maKH,ArrayList<CTDonDatHang> listCTDonDatHang) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.themHoaDon(h, maNV, maKH,listCTDonDatHang);
	}

	@Override
	public boolean capNhatSoLuong(String maSP,int soLuong) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.capNhatSoLuong(maSP,soLuong);
	}

	@Override
	public boolean capNhatDonDatHang(String maDDH) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.capNhatDonDatHang(maDDH);
	}

	@Override
	public String getMaHD_MoiNhat() {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.getMaHD_MoiNhat();
	}

	@Override
	public boolean capNhat_CTHoaDon(String maHD) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.capNhat_CTHoaDon(maHD);
	}
	
}
