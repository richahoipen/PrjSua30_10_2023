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
import entities.NhanVien;
import entities.SanPham;
import interface_Method_DAO.SanPham_Method;

public class SanPham_DAO implements SanPham_Method
{
	Connect con = new Connect();
	
	public SanPham_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean themSanPham(SanPham s, DefaultTableModel dtm_SP) {
		try {
			// Kiểm tra xem email đã tồn tại trong bảng chưa
			//SanPham(String maSP, String tenSP, String loaiSP, String tacGia, String nhaXuatBan, int namXuatBan,
			//int soLuong, String ngonNgu, double giaNhap, double giaBan,byte[] hinhAnh)
			String sqlInsert = "DECLARE @NextIndex INT;\r\n"
					+ "SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT)), 0) + 1 FROM SanPham;\r\n"
					+ "DECLARE @NewMaSP VARCHAR(20);\r\n"
					+ "SET @NewMaSP = 'SP' + CAST(@NextIndex AS VARCHAR);\r\n"
					+ "INSERT [dbo].[SanPham] ([maSP],[tenSP],[loaiSP],[tacGia],[nhaXuatBan],[namXuatBan],[soLuong],[ngonNgu],[giaNhap],[giaBan],[hinhAnh],[maNCC]) \r\n"
					+ "VALUES (@NewMaSP,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement preparedStatement_Insert = con.con().prepareStatement(sqlInsert);
			preparedStatement_Insert.setNString(1,s.getTenSP());
			preparedStatement_Insert.setNString(2,s.getLoaiSP());
			preparedStatement_Insert.setNString(3,s.getTacGia());
			preparedStatement_Insert.setNString(4,s.getNhaXuatBan());
			preparedStatement_Insert.setInt(5,s.getNamXuatBan());
			preparedStatement_Insert.setInt(6,s.getSoLuong());
			preparedStatement_Insert.setNString(7, s.getNgonNgu());
			preparedStatement_Insert.setDouble(8,s.getGiaNhap());
			preparedStatement_Insert.setDouble(9,s.getGiaBan());
			preparedStatement_Insert.setBytes(10, s.getHinhAnh());
			preparedStatement_Insert.setNString(11, s.getMaNhaCungCap());
			preparedStatement_Insert.executeUpdate();
			
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Đã thêm dữ liệu sản phẩm thành công.", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
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
	public boolean capNhatSanPham(SanPham s, DefaultTableModel dtm_SP) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean xuatDanhSachSanPham(DefaultTableModel dtm_SP) {
		String sqlSelect ="select*from [dbo].[SanPham]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			//SanPham(String maSP, String tenSP, String loaiSP, String tacGia, String nhaXuatBan, int namXuatBan,
			//int soLuong, String ngonNgu, double giaNhap, double giaBan,byte[] hinhAnh)
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
				String nhaCungCap=rs.getNString("maNCC");
				SanPham s=new SanPham(maSP, tenSP, loaiSP, tacGia, nhaXuatBan, namXuatBan, soLuong, soLuongBan,ngonNgu, giaNhap, giaBan, dataAnh);
				s.setMaNhaCungCap(nhaCungCap);
				String[] row = {s.getMaSP(),s.getTenSP(),s.getLoaiSP(),s.getNgonNgu(),s.getMaNhaCungCap(),s.getNhaXuatBan(),Integer.toString(s.getNamXuatBan()),
						s.getTacGia(),Integer.toString(s.getSoLuong()),Integer.toString(s.getSoLuongBan()),Double.toString(s.getGiaNhap()),Double.toString(s.getGiaBan())};		
				dtm_SP.addRow(row);
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
	public byte[] getBytesAnh(String maSP) {
		String sqlSelect ="select hinhAnh from [dbo].[SanPham]\r\n"
				+ "where maSP='"+maSP+"'";
		byte[] data=null;
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			//SanPham(String maSP, String tenSP, String loaiSP, String tacGia, String nhaXuatBan, int namXuatBan,
			//int soLuong, String ngonNgu, double giaNhap, double giaBan,byte[] hinhAnh)
			while (rs.next()) 
			{
				byte[] hinhAnh=rs.getBytes("hinhAnh");
				data=hinhAnh;
			}
			con.con().close();
			con.stmt().close();
			rs.close();
			return data;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
}
