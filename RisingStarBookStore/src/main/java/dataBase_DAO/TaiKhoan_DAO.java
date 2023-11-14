package dataBase_DAO;

import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import connectDB.Connect;
import entities.TaiKhoan;
import interface_Method_DAO.TaiKhoan_Method;

public class TaiKhoan_DAO implements TaiKhoan_Method
{
	Connect con = new Connect();
	
	public TaiKhoan_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public ArrayList<TaiKhoan> getTaiKhoan(String chucVu) 
	{
		ArrayList<TaiKhoan> listTaiKhoan=new ArrayList<TaiKhoan>();
		String sqlSelect = "SELECT TaiKhoan.maNV ,TaiKhoan.matKhau \r\n"
				+ "FROM [dbo].[TaiKhoan]  \r\n"
				+ "INNER JOIN [dbo].[NhanVien] ON TaiKhoan.maNV = NhanVien.maNV\r\n"
				+ "WHERE NhanVien.chucVu = N'"+chucVu+"';";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			
			while (rs.next()) {			
				String maNV = rs.getNString("maNV");
				String matKhau = rs.getString("matKhau");
				TaiKhoan t=new TaiKhoan(matKhau);
				t.setMaCuaNV(maNV);
				listTaiKhoan.add(t);
			}
			con.con().close();
			con.stmt().close();
			rs.close();
			return listTaiKhoan;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
			
		}
	}

	
	
}
