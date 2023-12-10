package dataBase_BUS;




import javax.swing.table.DefaultTableModel;

import dataBase_DAO.CTHoaDon_DAO;
import entities.CTDonDatHang;
import interface_Method_DAO.CTHoaDon_Method;

public class CTHoaDon_BUS implements CTHoaDon_Method
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
	
}
