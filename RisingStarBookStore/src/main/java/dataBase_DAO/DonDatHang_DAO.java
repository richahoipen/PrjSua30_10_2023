package dataBase_DAO;

import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import connectDB.Connect;
import entities.DonDatHang;
import entities.KhachHang;
import interface_Method_DAO.DonDatHang_Method;

public class DonDatHang_DAO implements DonDatHang_Method
{
	private Connect con = new Connect();
	public DonDatHang_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean themDonDatHang(DonDatHang d, String maKH, String maNV) {
		String sqlInsert = "DECLARE @NextIndex INT;\r\n"
				+ "SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maDDH, 4, LEN(maDDH)) AS INT)), 0) + 1 FROM DonDatHang;\r\n"
				+ "DECLARE @NewMaDDH VARCHAR(20);\r\n"
				+ "SET  @NewMaDDH = 'DDH' + CAST(@NextIndex AS VARCHAR);\r\n"
				+ "insert into [dbo].[DonDatHang]([maDDH],[maKH],[maNV],[ngayDat],[daLapHoaDon])\r\n"
				+ "values (@NewMaDDH,?,?,?,?)\r\n"
				+ "update [dbo].[CTDonDatHang]\r\n"
				+ "set maDDH=@NewMaDDH\r\n"
				+ "where maDDH is null";
		try {
			
			
			PreparedStatement preparedStatement_Insert = con.con().prepareStatement(sqlInsert);
			preparedStatement_Insert.setNString(1,maKH);
			preparedStatement_Insert.setNString(2,maNV);
			preparedStatement_Insert.setDate(3,d.getNgayDat());
			preparedStatement_Insert.setBoolean(4, false);
			preparedStatement_Insert.executeUpdate();
			
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null,"Đặt hàng thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			con.con().close();
			preparedStatement_Insert.close();
			
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	@Override
	public String getMaKH(KhachHang k) {
		String sqlSelect = "select TOP 1 maKH from [dbo].[KhachHang]\r\n"
				+ "where tenKH=?\r\n"
				+ "and sdt=?\r\n"
				+ "and gioiTinh=?";

	    try {
	        String maKH_LayVe="";
	    	PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, k.getTenKH());
	        preparedStatement.setString(2, k.getSdt());
	        preparedStatement.setBoolean(3, k.isGioiTinh());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maKH=rs.getNString("maKH");
	            maKH_LayVe+=maKH;
	        }
	        
	        con.con().close();
	        preparedStatement.close();
	        return maKH_LayVe;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return null;
	    }
	}
	
	
}
