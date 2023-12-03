package dataBase_BUS;


import javax.swing.table.DefaultTableModel;

import dataBase_DAO.CTHoaDon_DAO;
import interface_Method_DAO.CTHoaDon_Method;

public class CTHoaDon_BUS implements CTHoaDon_Method
{

	private CTHoaDon_DAO sqlHoaDon_DAO = new CTHoaDon_DAO();
	public CTHoaDon_BUS() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean xuat_CTHoaDon_TheoMa(DefaultTableModel dtm_CTHD) {
		// TODO Auto-generated method stub
		return sqlHoaDon_DAO.xuat_CTHoaDon_TheoMa(dtm_CTHD);
	}
	
}
