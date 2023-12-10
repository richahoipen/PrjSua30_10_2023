package dataBase_BUS;

import java.sql.Date;

import javax.swing.table.DefaultTableModel;

import customEntities.Custom_ComboBox;
import dataBase_DAO.DonDatHang_DAO;
import entities.DonDatHang;
import entities.KhachHang;
import interface_Method_DAO.DonDatHang_Method;
import interface_Method_DAO.ICombobox_TimKiem_DonDat;

public class DonDatHang_BUS implements DonDatHang_Method, ICombobox_TimKiem_DonDat
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
	public boolean xuat_DonDat_ChuaThanhToan(String maNV, DefaultTableModel dtm_DD,String maKH) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.xuat_DonDat_ChuaThanhToan(maNV, dtm_DD,maKH);
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
	@Override
	public boolean dayComboBox_MaDD(Custom_ComboBox cbo_MaDD) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.dayComboBox_MaDD(cbo_MaDD);
	}
	@Override
	public boolean dayComboBox_HoTenKhachHang(Custom_ComboBox cbo_HoTenKhachHang) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.dayComboBox_HoTenKhachHang(cbo_HoTenKhachHang);
	}
	@Override
	public boolean dayComboBox_SoDienThoai(Custom_ComboBox cbo_SoDienThoai) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.dayComboBox_SoDienThoai(cbo_SoDienThoai);
	}
	@Override
	public boolean dayComboBox_HoTenNhanVien(Custom_ComboBox cbo_HoTenNhanVien) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.dayComboBox_HoTenNhanVien(cbo_HoTenNhanVien);
	}
	@Override
	public boolean dayComboBox_TongTien(Custom_ComboBox cbo_TongTien) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.dayComboBox_TongTien(cbo_TongTien);
	}
	@Override
	public boolean xuat_DonDatHang_TimKiem(DefaultTableModel dtm_DD) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.xuat_DonDatHang_TimKiem(dtm_DD);
	}
	@Override
	public Date getNgayDat(String maDDH) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.getNgayDat(maDDH);
	}
	@Override
	public boolean tim_DonDatHang(DonDatHang d, String tenNV, KhachHang k, int ngay, int thang, int nam,
			DefaultTableModel dtm_DD) {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.tim_DonDatHang(d, tenNV, k, ngay, thang, nam, dtm_DD);
	}
	@Override
	public String get_MaDDH_MoiNhat() {
		// TODO Auto-generated method stub
		return sqlDonDatHang_DAO.get_MaDDH_MoiNhat();
	}
	
	
}
