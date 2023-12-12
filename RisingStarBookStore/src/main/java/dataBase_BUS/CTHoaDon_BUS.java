package dataBase_BUS;




import javax.swing.table.DefaultTableModel;

import customEntities.Custom_ComboBox;
import dataBase_DAO.CTHoaDon_DAO;
import entities.CTDonDatHang;
import interface_Method_DAO.CTHoaDon_Method;
import interface_Method_DAO.ICombobox_TimKiem_HoaDon;

public class CTHoaDon_BUS implements CTHoaDon_Method, ICombobox_TimKiem_HoaDon
{

	private CTHoaDon_DAO sqlHoaDon_DAO = new CTHoaDon_DAO();
	public CTHoaDon_BUS() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean xuat_CTHoaDon_TheoMa(String maHD_CanXuat,DefaultTableModel dtm_CTHD) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.xuat_CTHoaDon_TheoMa(maHD_CanXuat,dtm_CTHD);
	}
	@Override
	public boolean them_CTHoaDon_TheoMaHD(CTDonDatHang cTDonDatHang, String maHD) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.them_CTHoaDon_TheoMaHD(cTDonDatHang, maHD);
	}
	@Override
	public boolean dayComboBox_MaHD(Custom_ComboBox cbo_MaHD) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.dayComboBox_MaHD(cbo_MaHD);
	}
	@Override
	public boolean dayComboBox_HoTenKhachHang(Custom_ComboBox cbo_HoTenKhachHang) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.dayComboBox_HoTenKhachHang(cbo_HoTenKhachHang);
	}
	@Override
	public boolean dayComboBox_SoDienThoai(Custom_ComboBox cbo_SoDienThoai) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.dayComboBox_SoDienThoai(cbo_SoDienThoai);
	}
	@Override
	public boolean dayComboBox_HoTenNhanVien(Custom_ComboBox cbo_HoTenNhanVien) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.dayComboBox_HoTenNhanVien(cbo_HoTenNhanVien);
	}
	@Override
	public boolean dayComboBox_TongTien(Custom_ComboBox cbo_TongTien) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.dayComboBox_TongTien(cbo_TongTien);
	}
	
}
