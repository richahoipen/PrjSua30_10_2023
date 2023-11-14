package dataBase_BUS;

import java.util.ArrayList;

import dataBase_DAO.TaiKhoan_DAO;
import entities.TaiKhoan;
import interface_Method_DAO.TaiKhoan_Method;

public class TaiKhoan_BUS implements TaiKhoan_Method
{
	private TaiKhoan_DAO sqlTaiKhoan_DAO=new TaiKhoan_DAO();

	@Override
	public ArrayList<TaiKhoan> getTaiKhoan(String chucVu) {
		
		return sqlTaiKhoan_DAO.getTaiKhoan(chucVu);
	}

	
}
