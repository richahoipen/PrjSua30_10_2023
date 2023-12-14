package dataBase_BUS;



import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import dataBase_DAO.HoaDon_DAO;

import entities.HoaDon;
import entities.HoaDon_TimKiem;
import entities.KhachHang;
import interface_Method_DAO.HoaDon_Method;

public class HoaDon_BUS implements HoaDon_Method
{
	private HoaDon_DAO sqlHoaDon_DAO=new HoaDon_DAO();

	public HoaDon_BUS() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean themHoaDon(HoaDon h, String maNV, String maKH) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.themHoaDon(h, maNV, maKH);
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

	@Override
	public HoaDon get_HoaDon(String maHD) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.get_HoaDon(maHD);
	}

	@Override
	public String get_MaHD_MoiNhat() {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.get_MaHD_MoiNhat();
	}

	@Override
	public boolean xuat_DanhSach_HoaDon(DefaultTableModel dtm_HD) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.xuat_DanhSach_HoaDon(dtm_HD);
	}

	@Override
	public Date getNgayLap(String maHD) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.getNgayLap(maHD);
	}

	@Override
	public boolean tim_HoaDon(HoaDon h, String tenNV, KhachHang k, int ngay, int thang, int nam,
			DefaultTableModel dtm_HD) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.tim_HoaDon(h, tenNV, k, ngay, thang, nam, dtm_HD);
	}

	@Override
	public ArrayList<HoaDon_TimKiem> listHoaDon_TimKiem() {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.listHoaDon_TimKiem();
	}
	
}
