package dataBase_DAO;

import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import connectDB.Connect;
import dataBase_BUS.KhachHang_BUS;
import entities.DonDatHang;
import entities.KhachHang;
import interface_Method_DAO.DonDatHang_Method;

public class DonDatHang_DAO implements DonDatHang_Method
{
	private Connect con = new Connect();
	private KhachHang_BUS sqlKhachHang_BUS=new KhachHang_BUS();
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
	@Override
	public boolean xuat_DonDat_ChuaThanhToan(String maNV, DefaultTableModel dtm_DD) {
		String sqlSelect = "SELECT * FROM [dbo].[DonDatHang] WHERE maNV = ? AND daLapHoaDon = ?";
		try {
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setNString(1, maNV);
	        preparedStatement.setBoolean(2, false);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				String maDDH=rs.getString("maDDH");
				Date ngayDat=rs.getDate("ngayDat");
				String maKH=rs.getNString("maKH");
				DonDatHang d=new DonDatHang();
				d.setNgayDat(ngayDat);
				String[] row= {maDDH,sqlKhachHang_BUS.getTenKhachHang_TheoMa(maKH),d.getNgayDatToString()};
				dtm_DD.addRow(row);
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
	@Override
	public String getTenKH(String maDDH) {
		// TODO Auto-generated method stub
		String sqlSelect = "SELECT KhachHang.tenKH, KhachHang.sdt,KhachHang.gioiTinh\r\n"
				+ "FROM [dbo].[KhachHang]\r\n"
				+ "INNER JOIN [dbo].[DonDatHang] ON KhachHang.maKH = DonDatHang.maKH\r\n"
				+ "where maDDH=N'"+maDDH+"'";
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
	public String getSDT_KH(String maDDH) {
		String sqlSelect = "SELECT KhachHang.tenKH, KhachHang.sdt,KhachHang.gioiTinh\r\n"
				+ "FROM [dbo].[KhachHang]\r\n"
				+ "INNER JOIN [dbo].[DonDatHang] ON KhachHang.maKH = DonDatHang.maKH\r\n"
				+ "where maDDH=N'"+maDDH+"'";
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
	public boolean getGioiTinh_KH(String maDDH) {
		String sqlSelect = "SELECT KhachHang.tenKH, KhachHang.sdt,KhachHang.gioiTinh\r\n"
				+ "FROM [dbo].[KhachHang]\r\n"
				+ "INNER JOIN [dbo].[DonDatHang] ON KhachHang.maKH = DonDatHang.maKH\r\n"
				+ "where maDDH=N'"+maDDH+"'";
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
	/*
	 * SELECT SUM(thanhTien) AS Tong
		FROM CTDonDatHang
		where maDDH=N'DDH1' 
	 */
	@Override
	public double getTongTien_DonDatHang(String maDDH) {
		String sqlSelect = "SELECT SUM(thanhTien) AS tongTien\r\n"
				+ "FROM [dbo].[CTDonDatHang]\r\n"
				+ "where maDDH=N'"+maDDH+"';";
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
	
	
}
