package dataBase_BUS;

import javax.swing.table.DefaultTableModel;

import dataBase_DAO.SanPham_DAO;
import entities.SanPham;
import interface_Method_DAO.SanPham_Method;

public class SanPham_BUS implements SanPham_Method
{
	private SanPham_DAO sqlSanPham_DAO=new SanPham_DAO();
	@Override
	public boolean themSanPham(SanPham s, DefaultTableModel dtm_SP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.themSanPham(s, dtm_SP);
	}

	@Override
	public boolean capNhatSanPham(SanPham s, DefaultTableModel dtm_SP) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xuatDanhSachSanPham(DefaultTableModel dtm_SP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.xuatDanhSachSanPham(dtm_SP);
	}

	@Override
	public byte[] getBytesAnh(String maSP) {
		// TODO Auto-generated method stub
		return sqlSanPham_DAO.getBytesAnh(maSP);
	}

}
