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

import arrayList_Entities.List_NhaCungCap;
import connectDB.Connect;
import customEntities.Custom_ComboBox;

import entities.NhaCungCap;

import interface_Method_DAO.NhaCungCap_Method;

public class NhaCungCap_DAO implements NhaCungCap_Method 
{
	Connect con = new Connect();
	//NhaCungCap(String maNCC, String tenNCC, String diaChi, String sdtNCC, String email) 
	List_NhaCungCap listNhaCungCap_DAO=new List_NhaCungCap();
	public NhaCungCap_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/*
	 * public boolean xuatDanhSachKhachHang(DefaultTableModel dtm_KH) {
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
	public boolean xuatDanhSachNhaCungCap(DefaultTableModel dtm_NCC) {
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
	public boolean themNhaCungCap(NhaCungCap n) 
	{
		try {
			 // Kiểm tra xem email đã tồn tại trong bảng chưa
			String checkEmailQuery = "SELECT 1 FROM NhaCungCap WHERE email = ?";
	        PreparedStatement checkEmailStatement = con.con().prepareStatement(checkEmailQuery);
	        checkEmailStatement.setString(1, n.getEmail());
	        ResultSet resultSet = checkEmailStatement.executeQuery();

	        if (resultSet.next()) {
	            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	            JOptionPane.showMessageDialog(null, "Email đã tồn tại trong hệ thống.", "Lỗi",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
			
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
			/*
			String checkEmailQuery = "SELECT 1 FROM NhaCungCap WHERE email = ?";
	        PreparedStatement checkEmailStatement = con.con().prepareStatement(checkEmailQuery);
	        checkEmailStatement.setString(1, n.getEmail());
	        ResultSet resultSet = checkEmailStatement.executeQuery();

	        if (resultSet.next()) {
	            UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	            UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	            JOptionPane.showMessageDialog(null, "Email đã tồn tại trong hệ thống.", "Lỗi",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }*/
			
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
	public boolean dayComboBoxMaNCC(Custom_ComboBox cbMaNCC) {
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
	 * select tenNCC from [dbo].[NhaCungCap] 
		ORDER BY tenNCC;
	 */
	@Override
	public boolean dayComboBoxTenNCC(Custom_ComboBox cbo_TenNCC) {
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
	 * select diaChi from [dbo].[NhaCungCap] 
		ORDER BY diaChi;
	 */
	@Override
	public boolean dayComboBoxDiaChi(Custom_ComboBox cbo_DiaChi) {
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
	 * select sdtNCC from [dbo].[NhaCungCap] 
	ORDER BY sdtNCC;
	 */
	@Override
	public boolean dayComboBoxSoDienThoai(Custom_ComboBox cbo_SoDT) {
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
	public boolean dayComboBoxEmail(Custom_ComboBox cbo_Email) {
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
	public boolean timKiemTheoMaNCC(String maNCCCanTim, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		String sqlSelect="select * from [dbo].[NhaCungCap]\r\n"
				+ "where maNCC='"+maNCCCanTim+"'";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			//NhaCungCap(String maNCC, String tenNCC,  String sdtNCC, String email,String diaChi)
			while (rs.next()) 
			{
				String maNCC=rs.getString("maNCC");
				String tenNCC=rs.getString("tenNCC");
				String sdtNCC=rs.getString("sdtNCC");
				String email=rs.getString("email");
				String diaChi=rs.getString("diaChi");
				NhaCungCap n=new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
				String[] row= {n.getMaNCC(),n.getTenNCC(),n.getSdtNCC(),n.getEmail(),n.getDiaChi()};
				dtm_NCC.addRow(row);
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
	public boolean timKiemTheoTenNCC(String tenNCCCanTim, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		String sqlSelect="select*from [dbo].[NhaCungCap]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			//NhaCungCap(String maNCC, String tenNCC,  String sdtNCC, String email,String diaChi)
			while (rs.next()) 
			{
				String maNCC=rs.getString("maNCC");
				String tenNCC=rs.getString("tenNCC");
				String sdtNCC=rs.getString("sdtNCC");
				String email=rs.getString("email");
				String diaChi=rs.getString("diaChi");
				NhaCungCap n=new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
				//Them mảng động
				listNhaCungCap_DAO.themNhaCungCap(n);
				
			}
			listNhaCungCap_DAO.xuatBangTheo_Ten(tenNCCCanTim, dtm_NCC);
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
	public boolean timKiemTheoDiaChi(String diaChiCanTim, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		String sqlSelect="select*from [dbo].[NhaCungCap]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			//NhaCungCap(String maNCC, String tenNCC,  String sdtNCC, String email,String diaChi)
			while (rs.next()) 
			{
				String maNCC=rs.getString("maNCC");
				String tenNCC=rs.getString("tenNCC");
				String sdtNCC=rs.getString("sdtNCC");
				String email=rs.getString("email");
				String diaChi=rs.getString("diaChi");
				NhaCungCap n=new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
				//Them mảng động
				listNhaCungCap_DAO.themNhaCungCap(n);
				
			}
			listNhaCungCap_DAO.xuatBangTheo_DiaChi(diaChiCanTim, dtm_NCC);
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
	 * select * from [dbo].[NhaCungCap]
		where sdtNCC='02836007777'
		ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
	 */
	@Override
	public boolean timKiemTheoSoDienThoaiNCC(String sdtNCCCanTim, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		String sqlSelect="select * from [dbo].[NhaCungCap]\r\n"
				+ "		where sdtNCC='"+sdtNCCCanTim+"'\r\n"
				+ "		ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			//NhaCungCap(String maNCC, String tenNCC,  String sdtNCC, String email,String diaChi)
			while (rs.next()) 
			{
				String maNCC=rs.getString("maNCC");
				String tenNCC=rs.getString("tenNCC");
				String sdtNCC=rs.getString("sdtNCC");
				String email=rs.getString("email");
				String diaChi=rs.getString("diaChi");
				NhaCungCap n=new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
				String[] row= {n.getMaNCC(),n.getTenNCC(),n.getSdtNCC(),n.getEmail(),n.getDiaChi()};
				dtm_NCC.addRow(row);
				
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
	/*
	 * select * from [dbo].[NhaCungCap]
		where email='daikavan@iuh.com'
		ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
	 */
	@Override
	public boolean timKiemTheoEmail(String emailCanTim, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		String sqlSelect="select * from [dbo].[NhaCungCap]\r\n"
				+ "		where email='"+emailCanTim+"'\r\n"
				+ "		ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			//NhaCungCap(String maNCC, String tenNCC,  String sdtNCC, String email,String diaChi)
			while (rs.next()) 
			{
				String maNCC=rs.getString("maNCC");
				String tenNCC=rs.getString("tenNCC");
				String sdtNCC=rs.getString("sdtNCC");
				String email=rs.getString("email");
				String diaChi=rs.getString("diaChi");
				NhaCungCap n=new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
				String[] row= {n.getMaNCC(),n.getTenNCC(),n.getSdtNCC(),n.getEmail(),n.getDiaChi()};
				dtm_NCC.addRow(row);
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
	public boolean timKiemTheoTieuChiKhacMaNCC(NhaCungCap n, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		String sqlSelect="select*from [dbo].[NhaCungCap]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			//NhaCungCap(String maNCC, String tenNCC,  String sdtNCC, String email,String diaChi)
			List<NhaCungCap> listNCC=new ArrayList<>();
			while (rs.next()) 
			{
				String maNCC=rs.getString("maNCC");
				String tenNCC=rs.getString("tenNCC");
				String sdtNCC=rs.getString("sdtNCC");
				String email=rs.getString("email");
				String diaChi=rs.getString("diaChi");
				NhaCungCap nc=new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
				//Them mảng động
				listNCC.add(nc);
				
			}
			for(NhaCungCap n2: listNCC)
			{
				if(n2.getTenNCC().equalsIgnoreCase(n.getTenNCC()) &&
						n2.getSdtNCC().equalsIgnoreCase(n.getSdtNCC()) &&
							n2.getEmail().equalsIgnoreCase(n.getEmail()) &&
								n2.getDiaChi().equalsIgnoreCase(n.getDiaChi()))				
				{
					String[] row = {n2.getMaNCC(),n2.getTenNCC(),n2.getSdtNCC(),n2.getEmail(),n2.getDiaChi() };
					dtm_NCC.addRow(row);
					
				}
				
			}
			System.out.println("OK");
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
	 * select * from [dbo].[NhaCungCap]
	where maNCC='NCC10' and tenNCC='02838207153'
	ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
	 */
	
	@Override
	public boolean timKiemTheo_tenNCC_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
	    String sqlSelect = "SELECT * FROM [dbo].[NhaCungCap]\n"
	            + "WHERE tenNCC = ? AND diaChi = ?\n"
	            + "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, ncc.getTenNCC());
	        preparedStatement.setString(2, ncc.getDiaChi());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maNCC = rs.getString("maNCC");
	            String tenNCC = rs.getString("tenNCC");
	            String sdtNCC = rs.getString("sdtNCC");
	            String email = rs.getString("email");
	            String diaChi = rs.getString("diaChi");
	            NhaCungCap n = new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
	            String[] row = { n.getMaNCC(), n.getTenNCC(), n.getSdtNCC(), n.getEmail(), n.getDiaChi() };
	            dtm_NCC.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
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
	public boolean timKiemTheo_tenNCC_sdtNCC(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
	    String sqlSelect = "SELECT * FROM [dbo].[NhaCungCap]\n"
	            + "WHERE tenNCC = ? AND sdtNCC = ?\n"
	            + "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, ncc.getTenNCC());
	        preparedStatement.setString(2, ncc.getSdtNCC());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maNCC = rs.getString("maNCC");
	            String tenNCC = rs.getString("tenNCC");
	            String sdtNCC = rs.getString("sdtNCC");
	            String email = rs.getString("email");
	            String diaChi = rs.getString("diaChi");
	            NhaCungCap n = new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
	            String[] row = { n.getMaNCC(), n.getTenNCC(), n.getSdtNCC(), n.getEmail(), n.getDiaChi() };
	            dtm_NCC.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
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
	public boolean timKiemTheo_tenNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
	    String sqlSelect = "SELECT * FROM [dbo].[NhaCungCap]\n"
	            + "WHERE tenNCC = ? AND email = ?\n"
	            + "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, ncc.getTenNCC());
	        preparedStatement.setString(2, ncc.getEmail());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maNCC = rs.getString("maNCC");
	            String tenNCC = rs.getString("tenNCC");
	            String sdtNCC = rs.getString("sdtNCC");
	            String email = rs.getString("email");
	            String diaChi = rs.getString("diaChi");
	            NhaCungCap n = new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
	            String[] row = { n.getMaNCC(), n.getTenNCC(), n.getSdtNCC(), n.getEmail(), n.getDiaChi() };
	            dtm_NCC.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
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
	public boolean timKiemTheo_diaChi_sdtNCC(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
	    String sqlSelect = "SELECT * FROM [dbo].[NhaCungCap]\n"
	            + "WHERE diaChi = ? AND sdtNCC = ?\n"
	            + "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, ncc.getDiaChi());
	        preparedStatement.setString(2, ncc.getSdtNCC());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maNCC = rs.getString("maNCC");
	            String tenNCC = rs.getString("tenNCC");
	            String sdtNCC = rs.getString("sdtNCC");
	            String email = rs.getString("email");
	            String diaChi = rs.getString("diaChi");
	            NhaCungCap n = new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
	            String[] row = { n.getMaNCC(), n.getTenNCC(), n.getSdtNCC(), n.getEmail(), n.getDiaChi() };
	            dtm_NCC.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
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
	public boolean timKiemTheo_diaChi_email(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
	    String sqlSelect = "SELECT * FROM [dbo].[NhaCungCap]\n"
	            + "WHERE diaChi = ? AND email = ?\n"
	            + "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, ncc.getDiaChi());
	        preparedStatement.setString(2, ncc.getEmail());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maNCC = rs.getString("maNCC");
	            String tenNCC = rs.getString("tenNCC");
	            String sdtNCC = rs.getString("sdtNCC");
	            String email = rs.getString("email");
	            String diaChi = rs.getString("diaChi");
	            NhaCungCap n = new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
	            String[] row = { n.getMaNCC(), n.getTenNCC(), n.getSdtNCC(), n.getEmail(), n.getDiaChi() };
	            dtm_NCC.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
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
	public boolean timKiemTheo_sdtNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
	    String sqlSelect = "SELECT * FROM [dbo].[NhaCungCap]\n"
	            + "WHERE sdtNCC = ? AND email = ?\n"
	            + "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, ncc.getSdtNCC());
	        preparedStatement.setString(2, ncc.getEmail());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maNCC = rs.getString("maNCC");
	            String tenNCC = rs.getString("tenNCC");
	            String sdtNCC = rs.getString("sdtNCC");
	            String email = rs.getString("email");
	            String diaChi = rs.getString("diaChi");
	            NhaCungCap n = new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
	            String[] row = { n.getMaNCC(), n.getTenNCC(), n.getSdtNCC(), n.getEmail(), n.getDiaChi() };
	            dtm_NCC.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
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
	public boolean timKiemTheo_tenNCC_sdtNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
	    String sqlSelect = "SELECT * FROM [dbo].[NhaCungCap]\n"
	            + "WHERE tenNCC = ? AND sdtNCC = ? AND email = ?\n"
	            + "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, ncc.getTenNCC());
	        preparedStatement.setString(2, ncc.getSdtNCC());
	        preparedStatement.setString(3, ncc.getEmail());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maNCC = rs.getString("maNCC");
	            String tenNCC = rs.getString("tenNCC");
	            String sdtNCC = rs.getString("sdtNCC");
	            String email = rs.getString("email");
	            String diaChi = rs.getString("diaChi");
	            NhaCungCap n = new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
	            String[] row = { n.getMaNCC(), n.getTenNCC(), n.getSdtNCC(), n.getEmail(), n.getDiaChi() };
	            dtm_NCC.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
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
	public boolean timKiemTheo_tenNCC_sdtNCC_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
	    String sqlSelect = "SELECT * FROM [dbo].[NhaCungCap]\n"
	            + "WHERE tenNCC = ? AND sdtNCC = ? AND diaChi = ?\n"
	            + "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, ncc.getTenNCC());
	        preparedStatement.setString(2, ncc.getSdtNCC());
	        preparedStatement.setString(3, ncc.getDiaChi());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maNCC = rs.getString("maNCC");
	            String tenNCC = rs.getString("tenNCC");
	            String sdtNCC = rs.getString("sdtNCC");
	            String email = rs.getString("email");
	            String diaChi = rs.getString("diaChi");
	            NhaCungCap n = new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
	            String[] row = { n.getMaNCC(), n.getTenNCC(), n.getSdtNCC(), n.getEmail(), n.getDiaChi() };
	            dtm_NCC.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
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
	public boolean timKiemTheo_tenNCC_email_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
	    String sqlSelect = "SELECT * FROM [dbo].[NhaCungCap]\n"
	            + "WHERE tenNCC = ? AND email = ? AND diaChi = ?\n"
	            + "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, ncc.getTenNCC());
	        preparedStatement.setString(2, ncc.getEmail());
	        preparedStatement.setString(3, ncc.getDiaChi());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maNCC = rs.getString("maNCC");
	            String tenNCC = rs.getString("tenNCC");
	            String sdtNCC = rs.getString("sdtNCC");
	            String email = rs.getString("email");
	            String diaChi = rs.getString("diaChi");
	            NhaCungCap n = new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
	            String[] row = { n.getMaNCC(), n.getTenNCC(), n.getSdtNCC(), n.getEmail(), n.getDiaChi() };
	            dtm_NCC.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
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
	public boolean timKiemTheo_sdtNCC_email_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
	    String sqlSelect = "SELECT * FROM [dbo].[NhaCungCap]\n"
	            + "WHERE sdtNCC = ? AND email = ? AND diaChi = ?\n"
	            + "ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;";

	    try {
	        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setString(1, ncc.getSdtNCC());
	        preparedStatement.setString(2, ncc.getEmail());
	        preparedStatement.setString(3, ncc.getDiaChi());
	        ResultSet rs = preparedStatement.executeQuery();

	        while (rs.next()) {
	            String maNCC = rs.getString("maNCC");
	            String tenNCC = rs.getString("tenNCC");
	            String sdtNCC = rs.getString("sdtNCC");
	            String email = rs.getString("email");
	            String diaChi = rs.getString("diaChi");
	            NhaCungCap n = new NhaCungCap(maNCC, tenNCC, sdtNCC, email, diaChi);
	            String[] row = { n.getMaNCC(), n.getTenNCC(), n.getSdtNCC(), n.getEmail(), n.getDiaChi() };
	            dtm_NCC.addRow(row);
	        }

	        con.con().close();
	        preparedStatement.close();
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
	public String getMaNhaCungCap(String tenNCC) 
	{
		String sqlSelect="select TOP 1 maNCC from [dbo].[NhaCungCap]\r\n"
				+ "where tenNCC=?";
		try {
			String ma_LayVe="";
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);	
			preparedStatement.setNString(1,tenNCC);
			ResultSet rs = preparedStatement.executeQuery();					
			while (rs.next()) 
			{
				String maNCC=rs.getNString("maNCC");
				ma_LayVe+=maNCC;
			}
			
			con.con().close();
			con.stmt().close();
			return ma_LayVe;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	@Override
	public String getTenNhaCungCap(String maNCC) {
		String sqlSelect="select tenNCC from [dbo].[NhaCungCap]\r\n"
				+ "where maNCC=?";
		try {
			String ten_LayVe="";
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);	
			preparedStatement.setNString(1,maNCC);
			ResultSet rs = preparedStatement.executeQuery();					
			while (rs.next()) 
			{
				String tenNCC=rs.getNString("tenNCC");
				ten_LayVe+=tenNCC;
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
