package dataBase_DAO;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

import java.awt.Font;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connectDB.Connect;
import entities.NhanVien;
import entities.SanPham;
import interface_Method_DAO.ThongKe_Method;

public class XuLi_ThongKe_DAO implements ThongKe_Method
{
	Connect con = new Connect();
	
	public XuLi_ThongKe_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Date ngay_Date(LocalDate ngay)
	{
		return Date.valueOf(ngay);
	}
	@Override
	public int getLuong_HoaDon_TheoNgay(LocalDate ngay) {
		String sqlSelect = "SELECT COUNT(*) AS tongHD\r\n"
				+ "FROM [dbo].[HoaDon]\r\n"
				+ "WHERE ngayLap = ?;";
		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setDate(1, ngay_Date(ngay));
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("tongHD");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	/*
	 * SELECT COUNT(DISTINCT maKH) AS soLuongKhach
		FROM [dbo].[HoaDon]
		WHERE ngayLap = '2023-12-12';
	 */
	@Override
	public int getLuong_Khach_TheoNgay(LocalDate ngay) {
		String sqlSelect = "SELECT COUNT(DISTINCT maKH) AS soLuongKhach\r\n"
				+ "		FROM [dbo].[HoaDon]\r\n"
				+ "		WHERE ngayLap = ?;";
		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setDate(1, ngay_Date(ngay));
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("soLuongKhach");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	/*
		 * SELECT
	    HD.maHD,
	    CTHD.sTT,
	    SUM(CTHD.soLuong) AS soLuongSP
	FROM
	    [dbo].[HoaDon] HD
	JOIN
	    [dbo].[CTHoaDon] CTHD ON HD.maHD = CTHD.maHD
	WHERE
	    CONVERT(date, HD.ngayLap) = '2023-12-12' -- Replace '2023-11-01' with your desired date condition
	GROUP BY
	    HD.maHD, CTHD.sTT;
	 */
	@Override
	public int getLuong_SanPham_TheoNgay(LocalDate ngay) {
		String sqlSelect = "SELECT\r\n"
				+ "    HD.maHD,\r\n"
				+ "    CTHD.sTT,\r\n"
				+ "    SUM(CTHD.soLuong) AS soLuongSP\r\n"
				+ "FROM\r\n"
				+ "    [dbo].[HoaDon] HD\r\n"
				+ "JOIN\r\n"
				+ "    [dbo].[CTHoaDon] CTHD ON HD.maHD = CTHD.maHD\r\n"
				+ "WHERE\r\n"
				+ "    CONVERT(date, HD.ngayLap) = ?\r\n"
				+ "GROUP BY\r\n"
				+ "    HD.maHD, CTHD.sTT;";
		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setDate(1, ngay_Date(ngay));
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("soLuongSP");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}

	@Override
	public double getLuong_TongTien_TheoNgay(LocalDate ngay) {
		String sqlSelect = "SELECT\r\n"
				+ "    HD.maHD,\r\n"
				+ "    SUM(HD.tongTien) AS tongTien\r\n"
				+ "FROM\r\n"
				+ "    [dbo].[HoaDon] HD\r\n"
				+ "WHERE\r\n"
				+ "    CONVERT(date, HD.ngayLap) = ?\r\n"
				+ "GROUP BY\r\n"
				+ "    HD.maHD;";
		double sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setDate(1, ngay_Date(ngay));
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            double tongTien=rs.getDouble("tongTien");
	            sum+=tongTien;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}

	@Override
	public double getTongTien_Nhap_SanPham() {
		String sqlSelect = "SELECT SUM(giaNhap) AS tongGiaNhap\r\n"
				+ "FROM [dbo].[SanPham];\r\n"
				+ "";
		double sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        //preparedStatement.setDate(1, ngay_Date(ngay));
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            double tongTien=rs.getDouble("tongGiaNhap");
	            sum+=tongTien;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	//Theo tuần
	@Override
	public int getLuong_HoaDon_Theo_Tuan(int tuan, int nam) {
		String sqlSelect = "SELECT COUNT(*) AS tongHD\r\n"
				+ "FROM [dbo].[HoaDon]\r\n"
				+ "WHERE DATEPART(ISO_WEEK, ngayLap) = ?\r\n"
				+ "  AND YEAR(ngayLap) = ?;";
		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setInt(1, tuan);
	        preparedStatement.setInt(2, nam);
	        
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("tongHD");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public int getLuong_Khach_Theo_Tuan(int tuan, int nam) {
		String sqlSelect = "SELECT COUNT(DISTINCT maKH) AS soLuongKhach\r\n"
				+ "		FROM [dbo].[HoaDon]\r\n"
				+ "WHERE DATEPART(ISO_WEEK, ngayLap) = ?\r\n"
				+ "  AND YEAR(ngayLap) = ?;";
		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setInt(1, tuan);
	        preparedStatement.setInt(2, nam);
	        
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("soLuongKhach");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public int getLuong_SanPham_Theo_Tuan(int tuan, int nam) {
		String sqlSelect = "SELECT\r\n"
		        + "    HD.maHD,\r\n"
		        + "    CTHD.sTT,\r\n"
		        + "    SUM(CTHD.soLuong) AS soLuongSP\r\n"
		        + "FROM\r\n"
		        + "    [dbo].[HoaDon] HD\r\n"
		        + "JOIN\r\n"
		        + "    [dbo].[CTHoaDon] CTHD ON HD.maHD = CTHD.maHD\r\n"
		        + "WHERE DATEPART(ISO_WEEK, HD.ngayLap) = ?\r\n"
		        + "  AND YEAR(HD.ngayLap) = ?\r\n"
		        + "GROUP BY\r\n"
		        + "    HD.maHD, CTHD.sTT;";


		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setInt(1, tuan);
	        preparedStatement.setInt(2, nam);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("soLuongSP");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public double getLuong_TongTien_Theo_Tuan(int tuan, int nam) {
	    String sqlSelect = "SELECT\r\n"
	            + "    HD.maHD,\r\n"
	            + "    SUM(HD.tongTien) AS tongTien\r\n"
	            + "FROM\r\n"
	            + "    [dbo].[HoaDon] HD\r\n"
	            + "WHERE DATEPART(ISO_WEEK, HD.ngayLap) = ?\r\n"
	            + "  AND YEAR(HD.ngayLap) = ?\r\n"  // Thêm khoảng trắng ở đây
	            + "GROUP BY\r\n"
	            + "    HD.maHD;";
	    double sum = 0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setInt(1, tuan);
	        preparedStatement.setInt(2, nam);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            double tongTien = rs.getDouble("tongTien");
	            sum += tongTien;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public ArrayList<NhanVien> getListNhanVien() {
		ArrayList<NhanVien> listNV=new ArrayList<NhanVien>();
		String sqlSelect = "select*from [dbo].[NhanVien]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			
			while (rs.next()) {			
				String maNV = rs.getNString("maNV");
				String tenNV = rs.getNString("tenNV");
				String sdt = rs.getNString("sdt");
				String gioiTinh = rs.getNString("gioiTinh");
				String diaChi = rs.getNString("diaChi");
				Date ngaySinh = rs.getDate("ngaySinh");
				String chucVu = rs.getNString("chucVu");
				String cMND = rs.getNString("cMND");
				String caLam = rs.getNString("caLam");
				NhanVien n = new NhanVien(maNV, tenNV, sdt, gioiTinh, diaChi, ngaySinh, chucVu, cMND, caLam);
				listNV.add(n);
			}
			con.con().close();
			con.stmt().close();
			rs.close();
			return listNV;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
			
		}
	}
	@Override
	public int getLuong_HoaDon_TheoNV(String maNV) {
		String sqlSelect = "SELECT COUNT(*) AS tongHD\r\n"
				+ "FROM [dbo].[HoaDon]\r\n"
				+ "WHERE maNV = ?;";
		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setNString(1, maNV);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("tongHD");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public int getLuong_Khach_TheoNV(String maNV) {
		String sqlSelect = "SELECT COUNT(DISTINCT maKH) AS soLuongKhach\r\n"
				+ "		FROM [dbo].[HoaDon]\r\n"
				+ "		WHERE maNV = ?;";
		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setNString(1, maNV);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("soLuongKhach");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public int getLuong_SanPham_TheoNV(String maNV) {
		String sqlSelect = "SELECT\r\n"
		        + "    HD.maHD,\r\n"
		        + "    CTHD.sTT,\r\n"
		        + "    SUM(CTHD.soLuong) AS soLuongSP\r\n"
		        + "FROM\r\n"
		        + "    [dbo].[HoaDon] HD\r\n"
		        + "JOIN\r\n"
		        + "    [dbo].[CTHoaDon] CTHD ON HD.maHD = CTHD.maHD\r\n"
		        + "JOIN\r\n"  // Thêm phần JOIN giữa HoaDon và NhanVien
		        + "    [dbo].[NhanVien] NV ON HD.maNV = NV.maNV\r\n"
		        + "WHERE\r\n"
		        + "    NV.maNV = ?\r\n"
		        + "GROUP BY\r\n"
		        + "    HD.maHD, CTHD.sTT;";

		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setNString(1, maNV);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("soLuongSP");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public double getLuong_TongTien_TheoNV(String maNV) {
		String sqlSelect = "SELECT\r\n"
		        + "    HD.maHD,\r\n"
		        + "    CTHD.sTT,\r\n"
		        + "    SUM(HD.tongTien) AS tongTien\r\n"
		        + "FROM\r\n"
		        + "    [dbo].[HoaDon] HD\r\n"
		        + "JOIN\r\n"
		        + "    [dbo].[CTHoaDon] CTHD ON HD.maHD = CTHD.maHD\r\n"
		        + "JOIN\r\n"
		        + "    [dbo].[NhanVien] NV ON HD.maNV = NV.maNV\r\n"  // Thêm phần JOIN giữa HoaDon và NhanVien
		        + "WHERE\r\n"
		        + "    NV.maNV = ?\r\n"
		        + "GROUP BY\r\n"
		        + "    HD.maHD, CTHD.sTT;";

		double sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setNString(1, maNV);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            double tongTien=rs.getDouble("tongTien");
	            sum+=tongTien;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public int getLuong_HoaDon_Theo_Ngay_NV(LocalDate ngay, String maNV) {
		String sqlSelect = "SELECT COUNT(*) AS tongHD\r\n"
				+ "FROM [dbo].[HoaDon]\r\n"
				+ "WHERE maNV = ? and ngayLap=?;";
		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setNString(1, maNV);
	        preparedStatement.setDate(2,ngay_Date(ngay));
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("tongHD");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public int getLuong_Khach_Theo_Ngay_NV(LocalDate ngay, String maNV) {
		String sqlSelect = "SELECT COUNT(DISTINCT maKH) AS soLuongKhach\r\n"
				+ "		FROM [dbo].[HoaDon]\r\n"
				+ "		WHERE ngayLap = ? and maNV=?;";
		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setDate(1, ngay_Date(ngay));
	        preparedStatement.setNString(2, maNV);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("soLuongKhach");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public int getLuong_SanPham_Theo_Ngay_NV(LocalDate ngay, String maNV) {
		String sqlSelect = "SELECT\r\n"
				+ "    HD.maHD,\r\n"
				+ "    CTHD.sTT,\r\n"
				+ "    SUM(CTHD.soLuong) AS soLuongSP\r\n"
				+ "FROM\r\n"
				+ "    [dbo].[HoaDon] HD\r\n"
				+ "JOIN\r\n"
				+ "    [dbo].[CTHoaDon] CTHD ON HD.maHD = CTHD.maHD\r\n"
				+ "WHERE\r\n"
				+ "    CONVERT(date, HD.ngayLap) = ? and maNV=?\r\n"
				+ "GROUP BY\r\n"
				+ "    HD.maHD, CTHD.sTT;";
		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setDate(1, ngay_Date(ngay));
	        preparedStatement.setNString(2,maNV);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("soLuongSP");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public double getLuong_TongTien_Theo_Ngay_NV(LocalDate ngay, String maNV) {
		String sqlSelect = "SELECT\r\n"
				+ "    HD.maHD,\r\n"
				+ "    SUM(HD.tongTien) AS tongTien\r\n"
				+ "FROM\r\n"
				+ "    [dbo].[HoaDon] HD\r\n"
				+ "WHERE\r\n"
				+ "    CONVERT(date, HD.ngayLap) = ? and maNV=?\r\n"
				+ "GROUP BY\r\n"
				+ "    HD.maHD;";
		double sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setDate(1, ngay_Date(ngay));
	        preparedStatement.setNString(2, maNV);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            double tongTien=rs.getDouble("tongTien");
	            sum+=tongTien;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public int getLuong_HoaDon_Theo_Tuan_NV(int tuan, int nam, String maNV) {
		String sqlSelect = "SELECT COUNT(*) AS tongHD\r\n"
				+ "FROM [dbo].[HoaDon]\r\n"
				+ "WHERE DATEPART(ISO_WEEK, ngayLap) = ?\r\n"
				+ "  AND YEAR(ngayLap) = ? and maNV=?;";
		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setInt(1, tuan);
	        preparedStatement.setInt(2, nam);
	        preparedStatement.setNString(3, maNV);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("tongHD");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public int getLuong_Khach_Theo_Tuan_NV(int tuan, int nam, String maNV) {
		String sqlSelect = "SELECT COUNT(DISTINCT maKH) AS soLuongKhach\r\n"
				+ "		FROM [dbo].[HoaDon]\r\n"
				+ "WHERE DATEPART(ISO_WEEK, ngayLap) = ?\r\n"
				+ "  AND YEAR(ngayLap) = ? and maNV=?;";
		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setInt(1, tuan);
	        preparedStatement.setInt(2, nam);
	        preparedStatement.setNString(3, maNV);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("soLuongKhach");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public int getLuong_SanPham_Theo_Tuan_NV(int tuan, int nam, String maNV) {
		String sqlSelect = "SELECT\r\n"
		        + "    HD.maHD,\r\n"
		        + "    CTHD.sTT,\r\n"
		        + "    SUM(CTHD.soLuong) AS soLuongSP\r\n"
		        + "FROM\r\n"
		        + "    [dbo].[HoaDon] HD\r\n"
		        + "JOIN\r\n"
		        + "    [dbo].[CTHoaDon] CTHD ON HD.maHD = CTHD.maHD\r\n"
		        + "JOIN\r\n"
		        + "    [dbo].[NhanVien] NV ON HD.maNV = NV.maNV\r\n"
		        + "WHERE DATEPART(ISO_WEEK, HD.ngayLap) = ?\r\n"
		        + "  AND YEAR(HD.ngayLap) = ? and NV.maNV=?\r\n"
		        + "GROUP BY\r\n"
		        + "    HD.maHD, CTHD.sTT;";


		int sum=0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setInt(1, tuan);
	        preparedStatement.setInt(2, nam);
	        preparedStatement.setNString(3,maNV);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            int soLuong=rs.getInt("soLuongSP");
	            sum+=soLuong;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public double getLuong_TongTien_Theo_Tuan_NV(int tuan, int nam, String maNV) {
		String sqlSelect = "SELECT\r\n"
	            + "    HD.maHD,\r\n"
	            + "    SUM(HD.tongTien) AS tongTien\r\n"
	            + "FROM\r\n"
	            + "    [dbo].[HoaDon] HD\r\n"
	            + "WHERE DATEPART(ISO_WEEK, HD.ngayLap) = ?\r\n"
	            + "  AND YEAR(HD.ngayLap) = ? and maNV=?\r\n"  // Thêm khoảng trắng ở đây
	            + "GROUP BY\r\n"
	            + "    HD.maHD;";
	    double sum = 0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setInt(1, tuan);
	        preparedStatement.setInt(2, nam);
	        preparedStatement.setNString(3,maNV);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            double tongTien = rs.getDouble("tongTien");
	            sum += tongTien;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}
	@Override
	public ArrayList<SanPham> getListSanPham() {
		ArrayList<SanPham> listSP=new ArrayList<SanPham>();
		String sqlSelect = "select*from [dbo].[SanPham]\r\n"
				+ "where soLuong > 0 ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC; ";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			
			while (rs.next()) {			
				String maSP=rs.getString("maSP");
				String tenSP=rs.getNString("tenSP");
				String loaiSP=rs.getNString("loaiSP");
				String tacGia=rs.getNString("tacGia");
				String nhaXuatBan=rs.getNString("nhaXuatBan");
				int namXuatBan=rs.getInt("namXuatBan");
				int soLuong=rs.getInt("soLuong");
				int soLuongBan=rs.getInt("soLuongBan");
				String ngonNgu=rs.getNString("ngonNgu");
				double giaNhap=rs.getDouble("giaNhap");
				double giaBan=rs.getDouble("giaBan");
				byte[] dataAnh=rs.getBytes("hinhAnh");
				//String nhaCungCap=rs.getNString("maNCC");
				SanPham s=new SanPham(maSP, tenSP, loaiSP, tacGia, nhaXuatBan, namXuatBan, soLuong, soLuongBan,ngonNgu, giaNhap, giaBan, dataAnh);
				listSP.add(s);
			}
			con.con().close();
			con.stmt().close();
			rs.close();
			return listSP;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
			
		}
	}
	@Override
	public double getTongTien_HoaDon_Theo_MaSP(String maSP) {
		String sqlSelect = "SELECT SUM(CT.thanhTien) AS tongThanhTien\r\n"
				+ "FROM SanPham SP\r\n"
				+ "JOIN CTHoaDon CT ON SP.maSP = CT.maSP\r\n"
				+ "WHERE SP.maSP = ?;\r\n"
				+ "";
	    double sum = 0;
	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        
	        preparedStatement.setNString(1,maSP);
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            double tongTien = rs.getDouble("tongThanhTien");
	            sum += tongTien;
	        }
	        con.con().close();
	        preparedStatement.close();
	        return sum;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return 0;
	    }
	}


	
}
