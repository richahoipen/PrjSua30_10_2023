package interface_Method_DAO;

import java.util.ArrayList;

import entities.TaiKhoan;

public interface TaiKhoan_Method {
	public ArrayList<TaiKhoan> getTaiKhoan(String chucVu);
	public boolean capNhat_MatKhau(String maNV,String matKhau);
}
