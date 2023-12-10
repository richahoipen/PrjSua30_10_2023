package dataBase_DAO;

import java.awt.Font;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import connectDB.Connect;

import entities.CTDonDatHang;
import entities.DonDatHang;
import interface_Method_DAO.CTHoaDon_Method;

public class CTHoaDon_DAO implements CTHoaDon_Method {

	private Connect con = new Connect();
	//private HoaDon_BUS sqlHoaDon_BUS = new HoaDon_BUS();

	public CTHoaDon_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * select * from [CTHoaDon]
		where maHD=N'HD35'
		ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;
	 */
	@Override
	public boolean xuat_CTHoaDon_TheoMa(String maHD_CanXuat,DefaultTableModel dtm_CTHD) {
		String sqlSelect = "SELECT CTHoaDon.*, SanPham.tenSP\r\n"
				+ "FROM CTHoaDon\r\n"
				+ "JOIN SanPham ON CTHoaDon.maSP = SanPham.maSP\r\n"
				+ "WHERE CTHoaDon.maHD = ?\r\n"
				+ "ORDER BY CAST(SUBSTRING(CTHoaDon.maSP, 3, LEN(CTHoaDon.maSP)) AS INT) ASC;";
		try {
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setNString(1, maHD_CanXuat);
	        
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				String maSP=rs.getNString("maSP");
				String tenSP=rs.getNString("tenSP");
				double donGia=rs.getDouble("donGia");
				int soLuong=rs.getInt("soLuong");
				double thanhTien=rs.getDouble("thanhTien");			
				String[] row= {maSP,tenSP,Double.toString(donGia),Integer.toString(soLuong),Double.toString(thanhTien)};
				dtm_CTHD.addRow(row);
			}	
			con.con().close();
			con.stmt().close();
			rs.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

	/*
	 * DECLARE @NewSTT INT; SET @NewSTT = ISNULL((SELECT MAX(sTT) FROM
	 * [dbo].[CTDonDatHang]), 0) + 1; insert into
	 * [dbo].[CTHoaDon]([sTT],[maSP],[donGia],[soLuong],[thanhTien],[maHD]) values
	 * (@NewSTT,?,?,?,?,?)
	 */
	@Override
	public boolean them_CTHoaDon_TheoMaHD(CTDonDatHang c, String maHD) {
		String sqlInsert_CTHoaDon = "DECLARE @NewSTT INT;\r\n"
				+ "SELECT @NewSTT = COUNT(*) + 1\r\n"
				+ "FROM [dbo].[CTHoaDon];\r\n"
				+ "INSERT INTO [dbo].[CTHoaDon] ([sTT], [maSP], [donGia], [soLuong], [thanhTien], [maHD])\r\n"
				+ "VALUES (@NewSTT,?,?,?,?,?);\r\n"
				+ "";
		try {
			// PreparedStatement = con.con().prepareStatement(sqlInsert_CTHoaDon);

			PreparedStatement preparedStatement_Insert_CTHoaDon=con.con().prepareStatement(sqlInsert_CTHoaDon);
			preparedStatement_Insert_CTHoaDon.setNString(1, c.getMaSP());
			preparedStatement_Insert_CTHoaDon.setDouble(2, c.getDonGia());
			preparedStatement_Insert_CTHoaDon.setInt(3, c.getSoLuong());
			preparedStatement_Insert_CTHoaDon.setDouble(4, c.getThanhTien());
			preparedStatement_Insert_CTHoaDon.setNString(5, maHD);
			preparedStatement_Insert_CTHoaDon.executeUpdate();
			System.out.println("Lập CTHD");
			
			con.con().close();
			preparedStatement_Insert_CTHoaDon.close();

			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}

}
