package dataBase_DAO;

import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import connectDB.Connect;
//import dataBase_BUS.KhachHang_BUS;
import entities.CTDonDatHang;
import entities.SanPham;
import interface_Method_DAO.CTDonDatHang_Method;

public class CTDonDatHang_DAO implements CTDonDatHang_Method {
	private Connect con = new Connect();
	//private KhachHang_BUS sqlKhachHang_BUS=new KhachHang_BUS();
	public CTDonDatHang_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * insert into [dbo].[CTDonDatHang] ([maSP],[donGia],[soLuong],[thanhTien])
	value (?,?,?,?)
	 */
	@Override
	public boolean themCTDonDatHang(SanPham s, CTDonDatHang c) {
		String sqlInsert ="DECLARE @NewSTT INT;\r\n"
				+ "SET @NewSTT = ISNULL((SELECT MAX(sTT) FROM [dbo].[CTDonDatHang]), 0) + 1;\r\n"
				+ "insert into [dbo].[CTDonDatHang] ([sTT],[maSP],[donGia],[soLuong],[thanhTien])\r\n"
				+ "values (@NewSTT,?,?,?,?)";
		try {
			String checkSDTQuery = "SELECT 1\r\n"
					+ "FROM [dbo].[CTDonDatHang]\r\n"
					+ "where maDDH is null and maSP=?";
	        PreparedStatement checkSDTStatement = con.con().prepareStatement(checkSDTQuery);
	        checkSDTStatement.setNString(1, s.getMaSP());
	        ResultSet resultSet = checkSDTStatement.executeQuery();

	        if (resultSet.next()) {
	            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	            JOptionPane.showMessageDialog(null, "Sản phẩm đã có sẵn trong giỏ.", "Thông báo",
	                    JOptionPane.INFORMATION_MESSAGE);
	            return false;
	        }
			
			PreparedStatement preparedStatement_Insert = con.con().prepareStatement(sqlInsert);
			preparedStatement_Insert.setNString(1, s.getMaSP());
			preparedStatement_Insert.setDouble(2, c.getDonGia());
			preparedStatement_Insert.setInt(3, c.getSoLuong());
			preparedStatement_Insert.setDouble(4, c.getDonGia()*c.getSoLuong());
			preparedStatement_Insert.executeUpdate();
			con.con().close();
			preparedStatement_Insert.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Sản phẩm đã có sẵn trong giỏ.", "Error", JOptionPane.WARNING_MESSAGE);
			return false;
		}
	}


	@Override
	public boolean xuat_GioHang(DefaultTableModel dtm_CTDD) {
		String sqlSelect = "SELECT SanPham.maSP, SanPham.tenSP, CTDonDatHang.donGia, CTDonDatHang.soLuong, CTDonDatHang.thanhTien\r\n"
				+ "FROM [dbo].[SanPham]\r\n"
				+ "INNER JOIN [dbo].[CTDonDatHang] ON SanPham.maSP = CTDonDatHang.maSP "
				+ "where maDDH is NULL;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			while(rs.next())
			{
				String maSP=rs.getString("maSP");
				String tenSP=rs.getNString("tenSP");
				double donGia=rs.getDouble("donGia");
				int soLuong=rs.getInt("soLuong");
				double thanhTien=rs.getDouble("thanhTien");
				String[] row= {maSP,tenSP,Double.toString(donGia),Integer.toString(soLuong),Double.toString(thanhTien)};
				dtm_CTDD.addRow(row);
			}	
			con.con().close();
			con.stmt().close();
			rs.close();
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
	public boolean xoaCTDonDatHang(SanPham s) {
		String sqlDelete = "DELETE FROM [dbo].[CTDonDatHang]\r\n"
				+ "where maSP=? and maDDH is null";
		try {
			
			
			PreparedStatement preparedStatement_Delete = con.con().prepareStatement(sqlDelete);
			preparedStatement_Delete.setString(1, s.getMaSP());		
			preparedStatement_Delete.executeUpdate();
			con.con().close();
			preparedStatement_Delete.close();	
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
	public String getHoTen_KhachHang(String sdt) {
		// TODO Auto-generated method stub
		String sqlSelect = "SELECT TOP 1 tenKH\r\n"
				+ "FROM [dbo].[KhachHang]\r\n"
				+ "WHERE sdt = N'"+sdt+"';";
		String hoTen_LayVe = "";
		try {
			ResultSet rs = con.resultSet(sqlSelect);

			while (rs.next()) {
				String tenKH = rs.getNString("tenKH");
				hoTen_LayVe += tenKH;
			}
			con.con().close();
			con.stmt().close();
			rs.close();
			return hoTen_LayVe;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;

		}
	}

	@Override
	public String getSDT_KhachHang(String sdt_CanTim) {
		String sqlSelect = "SELECT TOP 1 sdt\r\n"
				+ "FROM [dbo].[KhachHang]\r\n"
				+ "WHERE sdt = N'"+sdt_CanTim+"';";
		String sdt_LayVe = "";
		try {
			ResultSet rs = con.resultSet(sqlSelect);

			while (rs.next()) {
				String sdt = rs.getNString("sdt");
				sdt_LayVe += sdt;
			}
			con.con().close();
			con.stmt().close();
			rs.close();
			return sdt_LayVe;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;

		}
	}

	@Override
	public boolean getGioiTinh_KhachHang(String sdt) {
		String sqlSelect = "SELECT TOP 1 gioiTinh\r\n"
				+ "FROM [dbo].[KhachHang]\r\n"
				+ "WHERE sdt = N'"+sdt+"';";
		boolean gioiTinh_LayVe=false;
		try {
			ResultSet rs = con.resultSet(sqlSelect);

			while (rs.next()) {
				boolean gioiTinh=rs.getBoolean("gioiTinh");
				gioiTinh_LayVe=gioiTinh;
			}
			con.con().close();
			con.stmt().close();
			rs.close();
			return gioiTinh_LayVe;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;

		}
	}
	@Override
	public double tinhTongTien_GioHang() {
		String sqlSelect = "SELECT SUM(thanhTien) AS tongTien\r\n"
				+ "FROM [dbo].[CTDonDatHang]\r\n"
				+ "where maDDH is NULL;";
		double tongTien_LayVe=0;
		try {
			ResultSet rs = con.resultSet(sqlSelect);

			while (rs.next()) {
				double tongTien=rs.getDouble("tongTien");
				tongTien_LayVe+=tongTien;
			}
			con.con().close();
			con.stmt().close();
			rs.close();
			return tongTien_LayVe;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return 0;

		}
	}
	@Override
	public boolean xuat_CTDDH_TheoDonDat(String maDDH, DefaultTableModel dtm_CTDDH) {
		String sqlSelect = "SELECT SanPham.maSP, SanPham.tenSP, CTDonDatHang.donGia, CTDonDatHang.soLuong, CTDonDatHang.thanhTien\r\n"
				+ "FROM [dbo].[SanPham]\r\n"
				+ "INNER JOIN [dbo].[CTDonDatHang] ON SanPham.maSP = CTDonDatHang.maSP "
				+ "where maDDH=?;";
		try {
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setNString(1,maDDH);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				String maSP=rs.getString("maSP");
				String tenSP=rs.getNString("tenSP");
				double donGia=rs.getDouble("donGia");
				int soLuong=rs.getInt("soLuong");
				double thanhTien=rs.getDouble("thanhTien");
				String[] row= {maSP,tenSP,Double.toString(donGia),Integer.toString(soLuong),Double.toString(thanhTien)};
				dtm_CTDDH.addRow(row);
			}	
			con.con().close();
			con.stmt().close();
			rs.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
	/*
	 * DECLARE @NewSTT INT;
		SET @NewSTT = ISNULL((SELECT MAX(sTT) FROM [dbo].[CTDonDatHang]), 0) + 1;
		insert into [dbo].[CTDonDatHang] ([sTT],[maSP],[donGia],[soLuong],[thanhTien],[maDDH])
		values (@NewSTT,?,?,?,?,?)
	 */
	@Override
	public boolean themCTDonDatHang_Voi_DonDaDat(SanPham s, CTDonDatHang c,String maDDH) {
		String sqlInsert ="DECLARE @NewSTT INT;\r\n"
				+ "SET @NewSTT = ISNULL((SELECT MAX(sTT) FROM [dbo].[CTDonDatHang]), 0) + 1;\r\n"
				+ "insert into [dbo].[CTDonDatHang] ([sTT],[maSP],[donGia],[soLuong],[thanhTien],[maDDH])\r\n"
				+ "values (@NewSTT,?,?,?,?,?)";
		try {
			String checkQuery = "SELECT 1\r\n"
					+ "FROM [dbo].[CTDonDatHang]\r\n"
					+ "where maDDH=? and maSP=?";
	        PreparedStatement checkStatement = con.con().prepareStatement(checkQuery);
	        checkStatement.setNString(1, maDDH);
	        checkStatement.setNString(2, s.getMaSP());
	        ResultSet resultSet = checkStatement.executeQuery();

	        if (resultSet.next()) {
	            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	            JOptionPane.showMessageDialog(null, "Sản phẩm đã có sẵn trong giỏ.", "Thông báo",
	                    JOptionPane.INFORMATION_MESSAGE);
	            return false;
	        }
			
			PreparedStatement preparedStatement_Insert = con.con().prepareStatement(sqlInsert);
			preparedStatement_Insert.setNString(1, s.getMaSP());
			preparedStatement_Insert.setDouble(2, c.getDonGia());
			preparedStatement_Insert.setInt(3, c.getSoLuong());
			preparedStatement_Insert.setDouble(4, c.getDonGia()*c.getSoLuong());
			preparedStatement_Insert.setNString(5, maDDH);
			preparedStatement_Insert.executeUpdate();
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
	public boolean xoaCTDonDatHang_Voi_DonDaDat(SanPham s, String maDDH) {
		String sqlDelete = "delete from [dbo].[CTDonDatHang]\r\n"
				+ "where maDDH=? and  maSP=?";
		try {

			PreparedStatement preparedStatement_Delete = con.con().prepareStatement(sqlDelete);
			preparedStatement_Delete.setString(1, maDDH);		
			preparedStatement_Delete.setNString(2, s.getMaSP());	
			preparedStatement_Delete.executeUpdate();
			
			con.con().close();
			preparedStatement_Delete.close();	
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
