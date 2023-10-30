package dataBase_DAO;

import java.awt.Font;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import connectDB.Connect;
import customEntities.Custom_ComboBox;
import entities.KhachHang;
import entities.NhaCungCap;
import interface_Method_Database.Method_NhaCungCap;
import list_Array_DAO.KhachHang_DAO;
import list_Array_DAO.NhaCungCap_DAO;

public class DataBase_NhaCungCap_DAO implements Method_NhaCungCap
{
	Connect con = new Connect();
	//NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdtNCC, String email) 
	NhaCungCap_DAO listNhaCungCap_DAO=new NhaCungCap_DAO();
	public DataBase_NhaCungCap_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * public void xuatDanhSachKhachHang(DefaultTableModel dtm_KH) {
		String sqlSelect = "SELECT *\r\n" + "FROM KhachHang\r\n"
				+ "ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			while (rs.next()) {
				String maKH = rs.getString("maKH");
				String tenKH = rs.getString("tenKH");
				String sdt = rs.getString("sdt");
				boolean gioiTinh = rs.getBoolean("gioiTinh");
				String diaChi = rs.getString("diaChi");
				KhachHang k = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
				String[] row = { maKH, tenKH, sdt, k.traVeGioiTinh(), diaChi };
				dtm_KH.addRow(row);
			}
			con.con().close();
			con.stmt().close();
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	 */
	@Override
	public void xuatDanhSachNhaCungCap(DefaultTableModel dtm_NCC) {
		String sqlSelect = "select*from NhaCungCap\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			//NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdtNCC, String email) 
			while (rs.next()) {
				String maNCC=rs.getString("maNCC");
				String tenNCC=rs.getString("tenNCC");
				String diaChi=rs.getString("diaChi");
				String sdtNCC=rs.getString("sdtNCC");
				String email=rs.getString("email");
				NhaCungCap n=new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
				String[] row = {n.getMaNCC(), n.getTenNCC(),n.getSdtNCC(),n.getEmail(),n.getDiaChi()};
				dtm_NCC.addRow(row);
			}
			con.con().close();
			con.stmt().close();
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}	
	}
	@Override
	public boolean themNhaCungCap(NhaCungCap n) 
	{
		try {
			String sqlInsert = "DECLARE @NextIndex INT;\r\n"
					+ "SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT)), 0) + 1 FROM NhaCungCap;\r\n"
					+ "DECLARE @NewMaNCC VARCHAR(20);\r\n"
					+ "SET @NewMaNCC = 'NCC' + CAST(@NextIndex AS VARCHAR);\r\n"
					+ "INSERT [dbo].[NhaCungCap] ([diaChi], [email], [maNCC], [sdtNCC], [tenNCC]) \r\n"
					+ "VALUES (N'"+n.getDiaChi()+"', N'"+n.getEmail()+"', @NewMaNCC, N'"+n.getSdtNCC()+"', N'"+n.getTenNCC()+"');";
			con.stmt().executeUpdate(sqlInsert);
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Đã thêm dữ liệu nhà cung cấp thành công.", "Thông báo",
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
	public boolean capNhatNhaCungCap(NhaCungCap n) 
	{
		
		String sqlUpdate="UPDATE [dbo].[NhaCungCap] SET tenNCC= ? , sdtNCC= ? ,email= ? ,diaChi= ? WHERE maNCC= ? ";
		try {
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlUpdate);		    
		    // Gán giá trị cho các tham số
		    preparedStatement.setString(1, n.getTenNCC());
		    preparedStatement.setString(2,n.getSdtNCC());
		    preparedStatement.setString(3, n.getEmail()); // Giới tính, ví dụ: 1 cho nam, 0 cho nữ
		    preparedStatement.setString(4, n.getDiaChi());
		    preparedStatement.setString(5,n.getMaNCC());
		    
		    // Thực hiện câu lệnh UPDATE
		    preparedStatement.executeUpdate();
		    
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, "Cập nhật dữ liệu nhà cung cấp thành công.", "Thông báo",
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
	public void dayComboBoxMaNCC(Custom_ComboBox cbMaNCC) {
		String sqlSelectMaNCC = "select maNCC from [dbo].[NhaCungCap] \r\n"
				+ "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelectMaNCC);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String maNCC = rs.getString("maNCC");
				cbMaNCC.addItem(maNCC);
				// stringList.add(maKH);
				cbMaNCC.getMyVector().add(maNCC);
			}
			// String[] maKHArray = stringList.toArray(new String[0]);
			// cbMaKH.setMyVector(maKHArray);
			con.con().close();
			con.stmt().close();
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	/*
	 * select tenNCC from [dbo].[NhaCungCap] 
		ORDER BY tenNCC;
	 */
	@Override
	public void dayComboBoxTenNCC(Custom_ComboBox cbo_TenNCC) {
		String sqlSelectTenNCC = "select tenNCC from [dbo].[NhaCungCap] \r\n"
				+ "ORDER BY tenNCC;";
		try {
			ResultSet rs = con.resultSet(sqlSelectTenNCC);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String tenNCC = rs.getString("tenNCC");
				cbo_TenNCC.addItem(tenNCC);
				// stringList.add(maKH);
				cbo_TenNCC.getMyVector().add(tenNCC);
			}
			// String[] maKHArray = stringList.toArray(new String[0]);
			// cbMaKH.setMyVector(maKHArray);
			con.con().close();
			con.stmt().close();
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	/*
	 * select diaChi from [dbo].[NhaCungCap] 
		ORDER BY diaChi;
	 */
	@Override
	public void dayComboBoxDiaChi(Custom_ComboBox cbo_DiaChi) {
		String sqlSelectDiaChi = "select diaChi from [dbo].[NhaCungCap] \r\n"
				+ "		ORDER BY diaChi;";
		try {
			ResultSet rs = con.resultSet(sqlSelectDiaChi);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String diaChi = rs.getString("diaChi");
				cbo_DiaChi.addItem(diaChi);
				// stringList.add(maKH);
				cbo_DiaChi.getMyVector().add(diaChi);
			}
			// String[] maKHArray = stringList.toArray(new String[0]);
			// cbMaKH.setMyVector(maKHArray);
			con.con().close();
			con.stmt().close();
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	/*
	 * select sdtNCC from [dbo].[NhaCungCap] 
	ORDER BY sdtNCC;
	 */
	@Override
	public void dayComboBoxSoDienThoai(Custom_ComboBox cbo_SoDT) {
		// TODO Auto-generated method stub
		String sqlSelectSDT="select sdtNCC from [dbo].[NhaCungCap] \r\n"
				+ "	ORDER BY sdtNCC;";
		try {
			ResultSet rs = con.resultSet(sqlSelectSDT);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String sdtNCC = rs.getString("sdtNCC");
				cbo_SoDT.addItem(sdtNCC);
				// stringList.add(maKH);
				cbo_SoDT.getMyVector().add(sdtNCC);
			}
			// String[] maKHArray = stringList.toArray(new String[0]);
			// cbMaKH.setMyVector(maKHArray);
			con.con().close();
			con.stmt().close();
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public void dayComboBoxEmail(Custom_ComboBox cbo_Email) {
		// TODO Auto-generated method stub
		String sqlSelectEmail="select email from [dbo].[NhaCungCap] \r\n"
				+ "ORDER BY email;";
		try {
			ResultSet rs = con.resultSet(sqlSelectEmail);
			// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
			// diaChi)
			// ArrayList<String> stringList = new ArrayList<>();
			while (rs.next()) {
				String email = rs.getString("email");
				cbo_Email.addItem(email);
				// stringList.add(maKH);
				cbo_Email.getMyVector().add(email);
			}
			// String[] maKHArray = stringList.toArray(new String[0]);
			// cbMaKH.setMyVector(maKHArray);
			con.con().close();
			con.stmt().close();
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	/*
	 * select * from [dbo].[NhaCungCap]
		where maNCC='NCC5'
	 */
	
	
}
