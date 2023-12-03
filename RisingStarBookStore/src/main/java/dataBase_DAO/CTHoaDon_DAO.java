package dataBase_DAO;

import javax.swing.table.DefaultTableModel;

import connectDB.Connect;
import interface_Method_DAO.CTHoaDon_Method;

public class CTHoaDon_DAO implements CTHoaDon_Method
{

	private Connect con = new Connect();
	public CTHoaDon_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean xuat_CTHoaDon_TheoMa(DefaultTableModel dtm_CTHD) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
