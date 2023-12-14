package dataBase_DAO;

import java.awt.Font;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import connectDB.Connect;
import customEntities.Custom_ComboBox;
import entities.CTDonDatHang;

import interface_Method_DAO.CTHoaDon_Method;
import interface_Method_DAO.ICombobox_TimKiem_HoaDon;

public class CTHoaDon_DAO implements CTHoaDon_Method, ICombobox_TimKiem_HoaDon
{

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
	/*
	 * 
	 */
	@Override
	public boolean dayComboBox_MaHD(Custom_ComboBox cbo_MaHD) {
		String sqlSelect ="SELECT HoaDon.maHD\r\n"				
				+ "		FROM HoaDon\r\n"
				+ "		JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "		JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "		ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			while (rs.next()) {
				String maHD=rs.getString("maHD");
				cbo_MaHD.addItem(maHD);
				// stringList.add(maKH);
				cbo_MaHD.getMyVector().add(maHD);
			}
			// String[] maKHArray = stringList.toArray(new String[0]);
			// cbMaKH.setMyVector(maKHArray);
			con.con().close();
			con.stmt().close();
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
	public boolean dayComboBox_HoTenKhachHang(Custom_ComboBox cbo_HoTenKhachHang) {
		String sqlSelect ="SELECT KhachHang.tenKH\r\n"				
				+ "		FROM HoaDon\r\n"
				+ "		JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "		JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "		ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			while (rs.next()) {
				String tenKH=rs.getString("tenKH");
				cbo_HoTenKhachHang.addItem(tenKH);
				// stringList.add(maKH);
				cbo_HoTenKhachHang.getMyVector().add(tenKH);
			}
			// String[] maKHArray = stringList.toArray(new String[0]);
			// cbMaKH.setMyVector(maKHArray);
			con.con().close();
			con.stmt().close();
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
	public boolean dayComboBox_SoDienThoai(Custom_ComboBox cbo_SoDienThoai) {
		String sqlSelect ="SELECT KhachHang.sdt\r\n"				
				+ "		FROM HoaDon\r\n"
				+ "		JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "		JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "		ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			while (rs.next()) {
				String sdt=rs.getString("sdt");
				cbo_SoDienThoai.addItem(sdt);
				// stringList.add(maKH);
				cbo_SoDienThoai.getMyVector().add(sdt);
			}
			// String[] maKHArray = stringList.toArray(new String[0]);
			// cbMaKH.setMyVector(maKHArray);
			con.con().close();
			con.stmt().close();
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
	public boolean dayComboBox_HoTenNhanVien(Custom_ComboBox cbo_HoTenNhanVien) {
		String sqlSelect ="SELECT NhanVien.tenNV\r\n"				
				+ "		FROM HoaDon\r\n"
				+ "		JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "		JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "		ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			while (rs.next()) {
				String tenNV=rs.getString("tenNV");
				cbo_HoTenNhanVien.addItem(tenNV);
				// stringList.add(maKH);
				cbo_HoTenNhanVien.getMyVector().add(tenNV);
			}
			// String[] maKHArray = stringList.toArray(new String[0]);
			// cbMaKH.setMyVector(maKHArray);
			con.con().close();
			con.stmt().close();
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
	public boolean dayComboBox_TongTien(Custom_ComboBox cbo_TongTien) {
		String sqlSelect ="SELECT HoaDon.tongTien\r\n"				
				+ "		FROM HoaDon\r\n"
				+ "		JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "		JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "		ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			while (rs.next()) {
				double tongTien=rs.getDouble("tongTien");
				cbo_TongTien.addItem(Double.toString(tongTien));
				// stringList.add(maKH);
				cbo_TongTien.getMyVector().add(Double.toString(tongTien));
			}
			// String[] maKHArray = stringList.toArray(new String[0]);
			// cbMaKH.setMyVector(maKHArray);
			con.con().close();
			con.stmt().close();
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
