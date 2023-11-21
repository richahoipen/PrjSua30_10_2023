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
import dataBase_BUS.NhaCungCap_BUS;
import entities.SanPham;
import interface_Method_DAO.SanPham_Method;

public class SanPham_DAO implements SanPham_Method
{
	Connect con = new Connect();
	
	public SanPham_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	private NhaCungCap_BUS sqlNhaCungCap_BUS=new NhaCungCap_BUS();
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
	/*
	 * UPDATE [dbo].[SanPham]
		set 
		tenSP=?,
		loaiSP=?,
		nhaXuanBan=?,
		namXuatBan=?,
		soLuong=?,
		giaNhap=?,
		giaBan=?,
		hinhAnh=?
		where maSP=?
	 */
	@Override
	public boolean capNhatSanPham(SanPham s, DefaultTableModel dtm_SP) {
		String sqlUpdate ="UPDATE [dbo].[SanPham]\r\n"
				+ "set \r\n"
				+ "tenSP=?,\r\n"
				+ "loaiSP=?,\r\n"
				+ "tacGia=?,\r\n"
				+ "nhaXuatBan=?,\r\n"
				+ "namXuatBan=?,\r\n"
				+ "soLuong=?,\r\n"
				+ "ngonNgu=?,\r\n"
				+ "giaNhap=?,\r\n"
				+ "giaBan=?,\r\n"
				+ "hinhAnh=?,\r\n"
				+ "maNCC=?\r\n"
				+ "where maSP=?";
		try {
			// Kiểm tra xem email đã tồn tại trong bảng chưa
			//SanPham(String maSP, String tenSP, String loaiSP, String tacGia, String nhaXuatBan, int namXuatBan,
			//int soLuong, String ngonNgu, double giaNhap, double giaBan,byte[] hinhAnh)		
			PreparedStatement preparedStatement_Insert = con.con().prepareStatement(sqlUpdate);
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
			preparedStatement_Insert.setString(12, s.getMaSP());
			preparedStatement_Insert.executeUpdate();
			
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Đã cập nhật dữ liệu sản phẩm thành công.", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			con.con().close();
			preparedStatement_Insert.close();
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
				String[] row = {s.getMaSP(),s.getTenSP(),s.getLoaiSP(),s.getNgonNgu(),sqlNhaCungCap_BUS.getTenNhaCungCap(s.getMaNhaCungCap()),s.getNhaXuatBan(),Integer.toString(s.getNamXuatBan()),
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
	/*
	 * select maSP from [dbo].[SanPham]
		ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;
	 */
	@Override
	public boolean dayCombobox_maSP(Custom_ComboBox cbo_maSP) {
		String sqlSelect="select maSP from [dbo].[SanPham]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String maSP = rs.getString("maSP");
				cbo_maSP.addItem(maSP);
				// stringList.add(maKH);
				cbo_maSP.getMyVector().add(maSP);
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
	public boolean dayCombobox_tenSP(Custom_ComboBox cbo_tenSP) {
		String sqlSelect="select tenSP from [dbo].[SanPham]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String tenSP = rs.getString("tenSP");
				cbo_tenSP.addItem(tenSP);
				// stringList.add(maKH);
				cbo_tenSP.getMyVector().add(tenSP);
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
	public boolean dayCombobox_loaiSP(Custom_ComboBox cbo_loaiSP) {
		String sqlSelect="select loaiSP from [dbo].[SanPham]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String loaiSP = rs.getString("loaiSP");
				cbo_loaiSP.addItem(loaiSP);
				// stringList.add(maKH);
				cbo_loaiSP.getMyVector().add(loaiSP);
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
	public boolean dayCombobox_tacGia(Custom_ComboBox cbo_tacGia) {
		String sqlSelect="select tacGia from [dbo].[SanPham]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String tacGia = rs.getString("tacGia");
				cbo_tacGia.addItem(tacGia);
				// stringList.add(maKH);
				cbo_tacGia.getMyVector().add(tacGia);
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
	public boolean dayCombobox_nhaXuatBan(Custom_ComboBox cbo_nhaXuatBan) {
		String sqlSelect="select nhaXuatBan from [dbo].[SanPham]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String nhaXuatBan = rs.getString("nhaXuatBan");
				cbo_nhaXuatBan.addItem(nhaXuatBan);
				// stringList.add(maKH);
				cbo_nhaXuatBan.getMyVector().add(nhaXuatBan);
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
	public boolean dayCombobox_namXuatBan(Custom_ComboBox cbo_namXuatBan) {
		String sqlSelect="select namXuatBan from [dbo].[SanPham]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				int namXuatBan = rs.getInt("namXuatBan");
				cbo_namXuatBan.addItem(Integer.toString(namXuatBan));
				// stringList.add(maKH);
				cbo_namXuatBan.getMyVector().add(Integer.toString(namXuatBan));
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
	public boolean dayCombobox_soLuong(Custom_ComboBox cbo_soLuong) {
		String sqlSelect="select soLuong from [dbo].[SanPham]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				int soLuong = rs.getInt("soLuong");
				cbo_soLuong.addItem(Integer.toString(soLuong));
				// stringList.add(maKH);
				cbo_soLuong.getMyVector().add(Integer.toString(soLuong));
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
	public boolean dayCombobox_soLuongBan(Custom_ComboBox cbo_soLuongBan) {
		String sqlSelect="SELECT soLuongBan\r\n"
				+ "FROM [dbo].[SanPham]\r\n"
				+ "WHERE soLuongBan IS NOT NULL\r\n"
				+ "ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				int soLuongBan = rs.getInt("soLuongBan");
				cbo_soLuongBan.addItem(Integer.toString(soLuongBan));
				// stringList.add(maKH);
				cbo_soLuongBan.getMyVector().add(Integer.toString(soLuongBan));
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
	public boolean dayCombobox_ngonNgu(Custom_ComboBox cbo_ngonNgu) {
		String sqlSelect="select ngonNgu from [dbo].[SanPham]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String ngonNgu = rs.getString("ngonNgu");
				cbo_ngonNgu.addItem(ngonNgu);
				// stringList.add(maKH);
				cbo_ngonNgu.getMyVector().add(ngonNgu);
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
	public boolean dayCombobox_giaNhap(Custom_ComboBox cbo_giaNhap) {
		String sqlSelect="select giaNhap from [dbo].[SanPham]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				double giaNhap = rs.getDouble("giaNhap");
				cbo_giaNhap.addItem(Double.toString(giaNhap));
				// stringList.add(maKH);
				cbo_giaNhap.getMyVector().add(Double.toString(giaNhap));
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
	public boolean dayCombobox_giaBan(Custom_ComboBox cbo_giaBan) {
		String sqlSelect="select giaBan from [dbo].[SanPham]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				double giaBan = rs.getDouble("giaBan");
				cbo_giaBan.addItem(Double.toString(giaBan));
				// stringList.add(maKH);
				cbo_giaBan.getMyVector().add(Double.toString(giaBan));
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
	public boolean timKiem_SanPham(SanPham s_Tim, DefaultTableModel dtm_SP) {
		String sqlSelect="select * from  [dbo].[SanPham]\r\n"
				+ "where maSP=? or\r\n"
				+ "tenSP=? or\r\n"
				+ "loaiSP= ? or \r\n"
				+ "tacGia=? or\r\n"
				+ "nhaXuatBan=? or\r\n"
				+ "namXuatBan=? or \r\n"
				+ "soLuong=? or \r\n"
				+ "soLuongBan=? or \r\n"
				+ "ngonNgu=? or\r\n"
				+ "giaNhap=? or \r\n"
				+ "giaBan=? or \r\n"
				+ "maNCC=? \r\n"
				+ "ORDER BY CAST(SUBSTRING(maSP, 3, LEN(maSP)) AS INT) ASC;";
		try {

			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
			preparedStatement.setString(1, s_Tim.getMaSP());
			preparedStatement.setNString(2,s_Tim.getTenSP());
			preparedStatement.setNString(3,s_Tim.getLoaiSP());
			preparedStatement.setNString(4,s_Tim.getTacGia());
			preparedStatement.setNString(5,s_Tim.getNhaXuatBan());
			preparedStatement.setInt(6,s_Tim.getNamXuatBan());
			preparedStatement.setInt(7,s_Tim.getSoLuong());
			preparedStatement.setInt(8,s_Tim.getSoLuongBan());
			preparedStatement.setNString(9, s_Tim.getNgonNgu());
			preparedStatement.setDouble(10,s_Tim.getGiaNhap());
			preparedStatement.setDouble(11,s_Tim.getGiaBan());
			preparedStatement.setNString(12, s_Tim.getMaNhaCungCap());
			
			
			ResultSet rs = preparedStatement.executeQuery();
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)					
			while (rs.next()) 
			{
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
				String[] row = {s.getMaSP(),s.getTenSP(),s.getLoaiSP(),s.getNgonNgu(),sqlNhaCungCap_BUS.getTenNhaCungCap(s.getMaNhaCungCap()),s.getNhaXuatBan(),Integer.toString(s.getNamXuatBan()),
						s.getTacGia(),Integer.toString(s.getSoLuong()),Integer.toString(s.getSoLuongBan()),Double.toString(s.getGiaNhap()),Double.toString(s.getGiaBan())};		
				dtm_SP.addRow(row);
			}
			
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
	public boolean xuatDanhSachSanPham_DonDat(DefaultTableModel dtm_SP) {
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
				String[] row = {s.getMaSP(),s.getTenSP(),s.getLoaiSP(),s.getNgonNgu(),s.getNhaXuatBan(),Integer.toString(s.getNamXuatBan()),
						s.getTacGia(),Double.toString(s.getGiaBan())};		
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

	
	
}
