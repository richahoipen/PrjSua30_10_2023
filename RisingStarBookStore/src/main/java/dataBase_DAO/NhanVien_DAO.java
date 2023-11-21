package dataBase_DAO;

import java.awt.Font;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import arrayList_Entities.List_NhanVien;
import connectDB.Connect;
import customEntities.Custom_ComboBox;

import entities.NhanVien;
import entities.TaiKhoan;
import interface_Method_DAO.NhanVien_Method;

public class NhanVien_DAO implements NhanVien_Method {
	Connect con = new Connect();
	// NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdtNCC, String
	// email)
	List_NhanVien list_NhanVien = new List_NhanVien();

	public NhanVien_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	@Override
	public boolean themNhanVien(NhanVien n, TaiKhoan t) {
		try {
			// Kiểm tra xem email đã tồn tại trong bảng chưa
			String checkQuery = "SELECT 1 FROM NhanVien WHERE cMND= ?";
			PreparedStatement checkStatement = con.con().prepareStatement(checkQuery);
			checkStatement.setString(1, n.getcMND());
			ResultSet resultSet = checkStatement.executeQuery();

			if (resultSet.next()) {
				UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
				UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
				JOptionPane.showMessageDialog(null, "Căn cước công dân đã tồn tại trong hệ thống.", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}

			String sqlInsert = "DECLARE @NextIndex INT;\r\n"
					+ "SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT)), 0) + 1 FROM NhanVien;\r\n"
					+ "DECLARE @NewMaNV VARCHAR(20);\r\n" + "SET @NewMaNV = 'NV' + CAST(@NextIndex AS VARCHAR);\r\n"
					+ "INSERT [dbo].[NhanVien] ([maNV],[tenNV],[sdt],[gioiTinh],[diaChi],[ngaySinh],[chucVu],[cMND],[caLam]) \r\n"
					+ "VALUES (@NewMaNV," + "N'" + n.getTenNV() + "'," + "N'" + n.getSdt() + "'," + "N'"
					+ n.getGioiTinh() + "'," + "N'" + n.getDiaChi() + "'," + "N'" + n.getNgaySinh() + "'," + "N'"
					+ n.getChucVu() + "'," + "N'" + n.getcMND() + "'," + "N'" + n.getCaLam() + "');"
					+ "INSERT [dbo].[TaiKhoan]([maNV],[matKhau] )\r\n" + "VALUES (@NewMaNV,'" + t.getMatKhau() + "')";
			con.stmt().executeUpdate(sqlInsert);
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Đã thêm dữ liệu nhân viên thành công.", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}*/
	@Override
	public boolean themNhanVien(NhanVien n, TaiKhoan t)
	{
		try {
			// Kiểm tra xem email đã tồn tại trong bảng chưa
			String checkQuery = "SELECT 1 FROM NhanVien WHERE cMND= ?";
			PreparedStatement checkStatement = con.con().prepareStatement(checkQuery);
			checkStatement.setString(1, n.getcMND());
			ResultSet resultSet = checkStatement.executeQuery();

			if (resultSet.next()) {
				UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
				UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
				JOptionPane.showMessageDialog(null, "Căn cước công dân đã tồn tại trong hệ thống.", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
				return false;
			}

			String sqlInsert = "DECLARE @NextIndex INT;\r\n"
					+ "SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT)), 0) + 1 FROM NhanVien;\r\n"
					+ "DECLARE @NewMaNV VARCHAR(20);\r\n"
					+ "SET @NewMaNV = 'NV' + CAST(@NextIndex AS VARCHAR);\r\n"
					+ "INSERT [dbo].[NhanVien] ([maNV],[tenNV],[sdt],[gioiTinh],[diaChi],[ngaySinh],[chucVu],[cMND],[caLam]) \r\n"
					+ "VALUES (@NewMaNV,?,?,?,?,?,?,?,?)\r\n"
					+ "INSERT [dbo].[TaiKhoan]([maNV],[matKhau] )\r\n"
					+ "VALUES (@NewMaNV,?)";
			PreparedStatement preparedStatement_Insert = con.con().prepareStatement(sqlInsert);
			preparedStatement_Insert.setNString(1, n.getTenNV());
			preparedStatement_Insert.setNString(2, n.getSdt());
			preparedStatement_Insert.setNString(3, n.getGioiTinh());
			preparedStatement_Insert.setNString(4, n.getDiaChi());
			preparedStatement_Insert.setDate(5, n.getNgaySinh());
			preparedStatement_Insert.setNString(6, n.getChucVu());
			preparedStatement_Insert.setNString(7, n.getcMND());
			preparedStatement_Insert.setNString(8, n.getCaLam());
			preparedStatement_Insert.setString(9, t.getMatKhau());
			preparedStatement_Insert.executeUpdate();
			
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Đã thêm dữ liệu nhân viên thành công.", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			con.con().close();
			preparedStatement_Insert.close();
			resultSet.close();
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
	 * UPDATE [dbo].[NhanVien]
		set tenNV=?, 1
		sdt=?,2
		gioiTinh=?, 3
		diaChi=?, 4
		ngaySinh=?, 5
		chucVu=?, 6
		cMND=?, 7
		caLam=? 8
		where maNV=?; 9
		UPDATE [dbo].[TaiKhoan]
		set matKhau=? 10
		where maNV=?;11
	 */
	/*
	 * PreparedStatement preparedStatement_NhanVien = con.con().prepareStatement(sqlUpdate_NhanVien);		
			PreparedStatement preparedStatement_TaiKhoan = con.con().prepareStatement(sqlUpdate_TaiKhoan);		
		    // Gán giá trị cho các tham số
			//NhanVien
		    preparedStatement_NhanVien.setNString(1, n.getTenNV());
		    preparedStatement_NhanVien.setNString(2,n.getSdt());
		    preparedStatement_NhanVien.setNString(3, n.getGioiTinh()); 
		    preparedStatement_NhanVien.setNString(4, n.getDiaChi());
		    preparedStatement_NhanVien.setDate(5,n.getNgaySinh());
		    preparedStatement_NhanVien.setNString(6,n.getChucVu());
		    preparedStatement_NhanVien.setNString(7,n.getcMND());
		    preparedStatement_NhanVien.setNString(8,n.getCaLam());
		    preparedStatement_NhanVien.setNString(9, n.getMaNV());
		    //TaiKhoan
		    preparedStatement_TaiKhoan.setString(1, t.getMatKhau());
		    preparedStatement_TaiKhoan.setNString(2, n.getMaNV());
		    
		    // Thực hiện câu lệnh UPDATE
		    preparedStatement_NhanVien.executeUpdate();
		    preparedStatement_TaiKhoan.executeUpdate();
	 */
	public boolean capNhatNhanVien(NhanVien n, TaiKhoan t) {
		
		// Kiểm tra xem email đã tồn tại trong bảng chưa
		
		
		String sqlUpdate_NhanVien="UPDATE [dbo].[NhanVien]\r\n"
				+ "SET tenNV=?, \r\n"
				+ "sdt=?,\r\n"
				+ "gioiTinh=?,\r\n"
				+ "diaChi=?,\r\n"
				+ "ngaySinh=?,\r\n"
				+ "chucVu=?,\r\n"
				+ "cMND=?,\r\n"
				+ "caLam=?\r\n"
				+ "WHERE maNV=?";
		String sqlUpdate_TaiKhoan="UPDATE [dbo].[TaiKhoan]\r\n"
				+ "SET matKhau=?\r\n"
				+ "WHERE maNV=?";
		try {
			/*
			String checkQuery = "SELECT 1 FROM NhanVien WHERE cMND= ?";
			PreparedStatement checkStatement = con.con().prepareStatement(checkQuery);
			checkStatement.setString(1, n.getcMND());
			ResultSet resultSet = checkStatement.executeQuery();

			if (resultSet.next()) {
				UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
				UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
				JOptionPane.showMessageDialog(null, "Căn cước công dân đã tồn tại trong hệ thống.", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
				return false;
			}*/
			
			PreparedStatement preparedStatement_NhanVien = con.con().prepareStatement(sqlUpdate_NhanVien);		
			PreparedStatement preparedStatement_TaiKhoan = con.con().prepareStatement(sqlUpdate_TaiKhoan);		
		    // Gán giá trị cho các tham số
			//NhanVien
		    preparedStatement_NhanVien.setNString(1, n.getTenNV());
		    preparedStatement_NhanVien.setNString(2,n.getSdt());
		    preparedStatement_NhanVien.setNString(3, n.getGioiTinh()); 
		    preparedStatement_NhanVien.setNString(4, n.getDiaChi());
		    preparedStatement_NhanVien.setDate(5,n.getNgaySinh());
		    preparedStatement_NhanVien.setNString(6,n.getChucVu());
		    preparedStatement_NhanVien.setNString(7,n.getcMND());
		    preparedStatement_NhanVien.setNString(8,n.getCaLam());
		    preparedStatement_NhanVien.setNString(9, n.getMaNV());
		    //TaiKhoan
		    preparedStatement_TaiKhoan.setString(1, t.getMatKhau());
		    preparedStatement_TaiKhoan.setNString(2, n.getMaNV());
		    
		    // Thực hiện câu lệnh UPDATE
		    preparedStatement_NhanVien.executeUpdate();
		    preparedStatement_TaiKhoan.executeUpdate();
			System.out.println("Thành công");
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Cập nhật dữ liệu nhân viên thành công.", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			
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
	public boolean xuatDanhSachNhanVien(DefaultTableModel dtm_NV) {
		// TODO Auto-generated method stub
		String sqlSelect = "select*from [dbo].[NhanVien]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String
			// diaChi, Date ngaySinh, String chucVu,
			// String cMND, String caLam)
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
				String[] row = { n.getMaNV(), n.getTenNV(), n.getSdt(), n.getGioiTinh(), n.getDiaChi(),
						n.getNgaySinhToString(), n.getChucVu(), n.getcMND(), n.getCaLam() };
				dtm_NV.addRow(row);
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
	public String getMatKhau(String maNV) {

		// TODO Auto-generated method stub
		String sqlSelect = "select*from [dbo].[TaiKhoan] where maNV='"+maNV+"'";
		String matKhauLayVe="";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String
			// diaChi, Date ngaySinh, String chucVu,
			// String cMND, String caLam)
			while (rs.next()) {			
				String matKhau = rs.getString("matKhau");
				matKhauLayVe+=matKhau;
			}
			con.con().close();
			con.stmt().close();
			rs.close();
			return matKhauLayVe;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
			
		}
	}

	@Override
	public Date getNgaySinh(String maNV) {
		String sqlSelect = "select*from [dbo].[NhanVien] where maNV='"+maNV+"'";
		Date ngaySinh_Return=null;
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String
			// diaChi, Date ngaySinh, String chucVu,
			// String cMND, String caLam)
			
			while (rs.next()) {			
				Date ngaySinh=rs.getDate("ngaySinh");
				 ngaySinh_Return=ngaySinh;
			}
			
			con.con().close();
			con.stmt().close();
			rs.close();
			return ngaySinh_Return;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
			
		}
	}
	//Đẩy dữ liệu lên combobox
	@Override
	public boolean dayComboBoxMaNV(Custom_ComboBox cbMaNV) {
		String sqlSelectTenMaNV = "select maNV from [dbo].[NhanVien]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelectTenMaNV);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String maNV = rs.getString("maNV");
				cbMaNV.addItem(maNV);
				// stringList.add(maKH);
				cbMaNV.getMyVector().add(maNV);
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
	public boolean dayComboBoxTenNV(Custom_ComboBox cbo_HoTen) {
		String sqlSelectTenMaNV = "select tenNV from [dbo].[NhanVien]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelectTenMaNV);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String tenNV = rs.getString("tenNV");
				cbo_HoTen.addItem(tenNV);
				// stringList.add(maKH);
				cbo_HoTen.getMyVector().add(tenNV);
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
	public boolean dayComboBoxCCCD(Custom_ComboBox cbCCCD) {
		String sqlSelectCCCD = "select cMND from [dbo].[NhanVien]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelectCCCD);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String cCCD = rs.getString("cMND");
				cbCCCD.addItem(cCCD);
				// stringList.add(maKH);
				cbCCCD.getMyVector().add(cCCD);
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
	public boolean dayComboBoxSDT(Custom_ComboBox cbo_sdt) {
		String sqlSelectSDT = "select sdt from [dbo].[NhanVien]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelectSDT);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String sdt = rs.getString("sdt");
				cbo_sdt.addItem(sdt);
				// stringList.add(maKH);
				cbo_sdt.getMyVector().add(sdt);
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
	/*
	 * select diaChi from [dbo].[NhanVien]
	ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;
	 */
	@Override
	public boolean dayComboBoxDiaChi(Custom_ComboBox cbo_diaChi) {
		String sqlSelectSDT = "select diaChi from [dbo].[NhanVien]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelectSDT);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String diaChi = rs.getString("diaChi");
				 cbo_diaChi.addItem(diaChi);
				// stringList.add(maKH);
				 cbo_diaChi.getMyVector().add(diaChi);
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
	public boolean dayComboBoxGioiTinh(Custom_ComboBox cbo_GioiTinh) {
		cbo_GioiTinh.addItem("Nam");
		cbo_GioiTinh.getMyVector().add("Nam");
		cbo_GioiTinh.addItem("Nữ");
		cbo_GioiTinh.getMyVector().add("Nữ");
		return true;
	}
	@Override
	public boolean dayComboNgaySinh(Custom_ComboBox cbo_Ngay, Custom_ComboBox cbo_Thang, Custom_ComboBox cbo_Nam) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean dayComboChucVu(Custom_ComboBox cbo_ChucVu) {
		cbo_ChucVu.addItem("Nhân viên");
		cbo_ChucVu.getMyVector().add("Nhân viên");
		cbo_ChucVu.addItem("Nhân viên quản lí");
		cbo_ChucVu.getMyVector().add("Nhân viên quản lí");
		return false;
	}
	@Override
	public boolean dayComboBoxCaLam(Custom_ComboBox cbo_CaLam) {
		// TODO Auto-generated method stub
		cbo_CaLam.addItem("Sáng");
		cbo_CaLam.getMyVector().add("Sáng");
		cbo_CaLam.addItem("Chiều");
		cbo_CaLam.getMyVector().add("Chiều");
		cbo_CaLam.addItem("Tối");
		return false;
	}
	/*
	 * select*from [dbo].[NhanVien]
		where maNV='NV1'
		ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;
	 */
	@Override
	public boolean timKiemTheo_maNV(String maNV_CanTim, DefaultTableModel dtm_NV) {
		String sqlSelect="select*from [dbo].[NhanVien]\r\n"
				+ "where maNV='"+maNV_CanTim+"'\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)					
			while (rs.next()) 
			{
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
				String[] row = { n.getMaNV(), n.getTenNV(), n.getSdt(), n.getGioiTinh(), n.getDiaChi(),
						n.getNgaySinhToString(), n.getChucVu(), n.getcMND(), n.getCaLam() };
				dtm_NV.addRow(row);
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
	public boolean timKiemTheo_tenNV(String tenNV_CanTim, DefaultTableModel dtm_NV) {
		String sqlSelect="select*from [dbo].[NhanVien]\r\n"
				+ "where tenNV=?\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {

			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);	
			preparedStatement.setNString(1, tenNV_CanTim);
			ResultSet rs = preparedStatement.executeQuery();
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)					
			while (rs.next()) 
			{
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
				String[] row = { n.getMaNV(), n.getTenNV(), n.getSdt(), n.getGioiTinh(), n.getDiaChi(),
						n.getNgaySinhToString(), n.getChucVu(), n.getcMND(), n.getCaLam() };
				dtm_NV.addRow(row);
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
	public boolean timKiemTheo_sdt(String sdt_CanTim, DefaultTableModel dtm_NV) {
		String sqlSelect="select*from [dbo].[NhanVien]\r\n"
				+ "where sdt=?\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {

			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);	
			preparedStatement.setNString(1, sdt_CanTim);
			ResultSet rs = preparedStatement.executeQuery();
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)					
			while (rs.next()) 
			{
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
				String[] row = { n.getMaNV(), n.getTenNV(), n.getSdt(), n.getGioiTinh(), n.getDiaChi(),
						n.getNgaySinhToString(), n.getChucVu(), n.getcMND(), n.getCaLam() };
				dtm_NV.addRow(row);
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
	public boolean timKiemTheo_gioiTinh(String gioiTinh_CanTim, DefaultTableModel dtm_NV) {
		String sqlSelect="select*from [dbo].[NhanVien]\r\n"
				+ "where gioiTinh=?\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {

			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);	
			preparedStatement.setNString(1, gioiTinh_CanTim);
			ResultSet rs = preparedStatement.executeQuery();
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)					
			while (rs.next()) 
			{
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
				String[] row = { n.getMaNV(), n.getTenNV(), n.getSdt(), n.getGioiTinh(), n.getDiaChi(),
						n.getNgaySinhToString(), n.getChucVu(), n.getcMND(), n.getCaLam() };
				dtm_NV.addRow(row);
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
	public boolean timKiemTheo_chucVu(String chucVu_CanTim, DefaultTableModel dtm_NV) {
		String sqlSelect="select*from [dbo].[NhanVien]\r\n"
				+ "where chucVu=?\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {

			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);	
			preparedStatement.setNString(1, chucVu_CanTim);
			ResultSet rs = preparedStatement.executeQuery();
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)					
			while (rs.next()) 
			{
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
				String[] row = { n.getMaNV(), n.getTenNV(), n.getSdt(), n.getGioiTinh(), n.getDiaChi(),
						n.getNgaySinhToString(), n.getChucVu(), n.getcMND(), n.getCaLam() };
				dtm_NV.addRow(row);
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
	public boolean timKiemTheo_cCCD(String cCCD_CanTim, DefaultTableModel dtm_NV) {
		String sqlSelect="select*from [dbo].[NhanVien]\r\n"
				+ "where cMND=?\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {

			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);	
			preparedStatement.setNString(1, cCCD_CanTim);
			ResultSet rs = preparedStatement.executeQuery();
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)					
			while (rs.next()) 
			{
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
				String[] row = { n.getMaNV(), n.getTenNV(), n.getSdt(), n.getGioiTinh(), n.getDiaChi(),
						n.getNgaySinhToString(), n.getChucVu(), n.getcMND(), n.getCaLam() };
				dtm_NV.addRow(row);
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
	public boolean timKiemTheo_caLam(String caLam_CanTim, DefaultTableModel dtm_NV) {
		String sqlSelect="select*from [dbo].[NhanVien]\r\n"
				+ "where caLam=?\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {

			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);	
			preparedStatement.setNString(1, caLam_CanTim);
			ResultSet rs = preparedStatement.executeQuery();
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)					
			while (rs.next()) 
			{
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
				String[] row = { n.getMaNV(), n.getTenNV(), n.getSdt(), n.getGioiTinh(), n.getDiaChi(),
						n.getNgaySinhToString(), n.getChucVu(), n.getcMND(), n.getCaLam() };
				dtm_NV.addRow(row);
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
	public boolean timKiemTheo_ngaySinh(int ngay, DefaultTableModel dtm_NV) {
		String sqlSelect="SELECT *\r\n"
				+ "FROM NhanVien\r\n"
				+ "WHERE DAY(ngaySinh) = ?\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {

			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);	
			preparedStatement.setInt(1, ngay);
			ResultSet rs = preparedStatement.executeQuery();
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)					
			while (rs.next()) 
			{
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
				String[] row = { n.getMaNV(), n.getTenNV(), n.getSdt(), n.getGioiTinh(), n.getDiaChi(),
						n.getNgaySinhToString(), n.getChucVu(), n.getcMND(), n.getCaLam() };
				dtm_NV.addRow(row);
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
	public boolean timKiemTheo_thangSinh(int thang, DefaultTableModel dtm_NV) {
		String sqlSelect="SELECT *\r\n"
				+ "FROM NhanVien\r\n"
				+ "WHERE MONTH(ngaySinh) = ?\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {

			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);	
			preparedStatement.setInt(1, thang);
			ResultSet rs = preparedStatement.executeQuery();
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)					
			while (rs.next()) 
			{
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
				String[] row = { n.getMaNV(), n.getTenNV(), n.getSdt(), n.getGioiTinh(), n.getDiaChi(),
						n.getNgaySinhToString(), n.getChucVu(), n.getcMND(), n.getCaLam() };
				dtm_NV.addRow(row);
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
	public boolean timKiemTheo_namSinh(int nam, DefaultTableModel dtm_NV) {
		String sqlSelect="SELECT *\r\n"
				+ "FROM NhanVien\r\n"
				+ "WHERE YEAR(ngaySinh) = ?\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {

			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);	
			preparedStatement.setInt(1, nam);
			ResultSet rs = preparedStatement.executeQuery();
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)					
			while (rs.next()) 
			{
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
				String[] row = { n.getMaNV(), n.getTenNV(), n.getSdt(), n.getGioiTinh(), n.getDiaChi(),
						n.getNgaySinhToString(), n.getChucVu(), n.getcMND(), n.getCaLam() };
				dtm_NV.addRow(row);
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
	public boolean timKiemTheo_diaChi(String diaChi_CanTim, DefaultTableModel dtm_NV) {
		String sqlSelect="SELECT *\r\n"
				+ "FROM NhanVien\r\n"
				+ "WHERE diaChi = ?\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maNV)) AS INT) ASC;";
		try {

			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);	
			preparedStatement.setNString(1, diaChi_CanTim);
			ResultSet rs = preparedStatement.executeQuery();
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)					
			while (rs.next()) 
			{
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
				String[] row = { n.getMaNV(), n.getTenNV(), n.getSdt(), n.getGioiTinh(), n.getDiaChi(),
						n.getNgaySinhToString(), n.getChucVu(), n.getcMND(), n.getCaLam() };
				dtm_NV.addRow(row);
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
	public String getTenNV(String maNV_CanTim) {
		String sqlSelect="select tenNV\r\n"
				+ "FROM [dbo].[NhanVien]\r\n"
				+ "where maNV=?;";
		try {
			String ten_LayVe="";
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);	
			preparedStatement.setNString(1,maNV_CanTim);
			ResultSet rs = preparedStatement.executeQuery();
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String diaChi, Date ngaySinh, String chucVu,String cMND, String caLam)					
			while (rs.next()) 
			{
				String tenNV=rs.getNString("tenNV");
				ten_LayVe+=tenNV;
			}
			
			con.con().close();
			con.stmt().close();
			return ten_LayVe;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
}
