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
import customEntities.Custom_ComboBox;

import entities.DonDatHang;
import entities.KhachHang;
import interface_Method_DAO.DonDatHang_Method;
import interface_Method_DAO.ICombobox_TimKiem_DonDat;

public class DonDatHang_DAO implements DonDatHang_Method, ICombobox_TimKiem_DonDat
{
	private Connect con = new Connect();
	//private KhachHang_BUS sqlKhachHang_BUS=new KhachHang_BUS();
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
	//Hết 15 ngày sẽ ko xuất
	@Override
	public boolean xuat_DonDat_ChuaThanhToan(String maNV, DefaultTableModel dtm_DD,String maKH) {
		String sqlSelect = "SELECT * FROM [dbo].[DonDatHang] WHERE maNV = ? AND daLapHoaDon = ? AND maKH= ? "	
				+ "AND DATEDIFF(day, ngayDat, GETDATE()) <= 15 "
				+ "ORDER BY CAST(SUBSTRING(maDDH, 4, LEN(maKH)) AS INT) ASC;";
		try {
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        preparedStatement.setNString(1, maNV);
	        preparedStatement.setBoolean(2, false);
	        preparedStatement.setNString(3,maKH);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				String maDDH=rs.getString("maDDH");
				Date ngayDat=rs.getDate("ngayDat");
				//String maKHang=rs.getNString("maKH");
				DonDatHang d=new DonDatHang();
				d.setNgayDat(ngayDat);
				String[] row= {maDDH,d.getNgayDatToString(),d.getNgayHetHanToString(),Double.toString(getTongTien_DonDatHang(maDDH))};
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
	/*
	 * String sqlSelect="select soLuong from [dbo].[SanPham]\r\n"
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
	 */
	@Override
	public boolean dayComboBox_MaDD(Custom_ComboBox cbo_MaDD) {
		String sqlSelect="SELECT\r\n"
				+ "    DDH.maDDH\r\n"
				+ "FROM\r\n"
				+ "    DonDatHang DDH\r\n"
				+ "JOIN\r\n"
				+ "    KhachHang KH ON DDH.maKH = KH.maKH\r\n"
				+ "JOIN\r\n"
				+ "    NhanVien NV ON DDH.maNV = NV.maNV\r\n"
				+ "ORDER BY CAST(SUBSTRING(maDDH, 4, LEN(maDDH)) AS INT) ASC;";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			while (rs.next()) {
				String maDDH=rs.getString("maDDH");
				cbo_MaDD.addItem(maDDH);
				// stringList.add(maKH);
				cbo_MaDD.getMyVector().add(maDDH);
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
		String sqlSelect="SELECT\r\n"
				+ "    KH.tenKH\r\n"
				+ "FROM\r\n"
				+ "    DonDatHang DDH\r\n"
				+ "JOIN\r\n"
				+ "    KhachHang KH ON DDH.maKH = KH.maKH\r\n"
				+ "JOIN\r\n"
				+ "    NhanVien NV ON DDH.maNV = NV.maNV\r\n"
				+ "ORDER BY CAST(SUBSTRING(maDDH, 4, LEN(maDDH)) AS INT) ASC;";
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
		String sqlSelect="SELECT\r\n"
				+ "    KH.sdt\r\n"
				+ "FROM\r\n"
				+ "    DonDatHang DDH\r\n"
				+ "JOIN\r\n"
				+ "    KhachHang KH ON DDH.maKH = KH.maKH\r\n"
				+ "JOIN\r\n"
				+ "    NhanVien NV ON DDH.maNV = NV.maNV\r\n"
				+ "ORDER BY CAST(SUBSTRING(maDDH, 4, LEN(maDDH)) AS INT) ASC;";
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
		String sqlSelect="SELECT\r\n"
				+ "    NV.tenNV\r\n"
				+ "FROM\r\n"
				+ "    DonDatHang DDH\r\n"
				+ "JOIN\r\n"
				+ "    KhachHang KH ON DDH.maKH = KH.maKH\r\n"
				+ "JOIN\r\n"
				+ "    NhanVien NV ON DDH.maNV = NV.maNV\r\n"
				+ "ORDER BY CAST(SUBSTRING(maDDH, 4, LEN(maDDH)) AS INT) ASC;";
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
	/*
	 * SELECT SUM(thanhTien) AS tongTien
		FROM CTDonDatHang
		GROUP BY maDDH;
	 */
	@Override
	public boolean dayComboBox_TongTien(Custom_ComboBox cbo_TongTien) {
		String sqlSelect="SELECT SUM(thanhTien) AS tongTien\r\n"
				+ "		FROM CTDonDatHang\r\n"
				+ "		GROUP BY maDDH "
				+ "ORDER BY CAST(SUBSTRING(maDDH, 4, LEN(maDDH)) AS INT) ASC;";
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
	@Override
	public boolean xuat_DonDatHang_TimKiem(DefaultTableModel dtm_DD) {
		String sqlSelect = "SELECT\r\n"
				+ "    DDH.maDDH,\r\n"
				+ "    KH.tenKH,\r\n"
				+ "    KH.sdt,\r\n"
				+ "    DDH.ngayDat,\r\n"
				+ "    NV.tenNV\r\n"
				+ "FROM\r\n"
				+ "    DonDatHang DDH\r\n"
				+ "JOIN\r\n"
				+ "    KhachHang KH ON DDH.maKH = KH.maKH\r\n"
				+ "JOIN\r\n"
				+ "    NhanVien NV ON DDH.maNV = NV.maNV "
				+ "ORDER BY CAST(SUBSTRING(maDDH, 4, LEN(maDDH)) AS INT) ASC;";
		try {
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        //preparedStatement.setNString(1, maNV);
	        
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				String maDDH=rs.getString("maDDH");
				String tenKH=rs.getNString("tenKH");
				String sdt=rs.getNString("sdt");
				Date ngayDat=rs.getDate("ngayDat");
				String tenNV=rs.getNString("tenNV");
				DonDatHang d=new DonDatHang();
				d.setNgayDat(ngayDat);
				String[] row= {maDDH,tenKH,sdt,d.getNgayDatToString(),tenNV,Double.toString(getTongTien_DonDatHang(maDDH))};
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
	public Date getNgayDat(String maDDH) {
		String sqlSelect = "SELECT\r\n"
				+ "    DDH.ngayDat\r\n"
				+ "FROM\r\n"
				+ "    DonDatHang DDH\r\n"
				+ "JOIN\r\n"
				+ "    KhachHang KH ON DDH.maKH = KH.maKH\r\n"
				+ "JOIN\r\n"
				+ "    NhanVien NV ON DDH.maNV = NV.maNV\r\n"
				+ "\r\n"
				+ "where maDDH='"+maDDH+"';";
		Date ngayDat_Return=null;
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String
			// diaChi, Date ngaySinh, String chucVu,
			// String cMND, String caLam)
			
			while (rs.next()) {			
				Date ngayDat=rs.getDate("ngayDat");
				ngayDat_Return=ngayDat;
			}
			
			con.con().close();
			con.stmt().close();
			rs.close();
			return ngayDat_Return;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
			
		}
	}
	@Override
	public boolean tim_DonDatHang(DonDatHang d, String tenNV, KhachHang k, int ngay, int thang, int nam,
			DefaultTableModel dtm_DD) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String get_MaDDH_MoiNhat() {
		String sqlSelect = "SELECT TOP 1 maDDH\r\n"
				+ "FROM [dbo].[DonDatHang]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maDDH, 4, LEN(maDDH)) AS INT) DESC;";		
	    try {
	    	String maDDH_LayVe="";
	    	//PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        //ResultSet rs = preparedStatement.executeQuery();
	    	ResultSet rs = con.resultSet(sqlSelect);
	        while (rs.next()) {
	            String maDDH=rs.getString("maDDH");
	            maDDH_LayVe+=maDDH;
	        }
	        System.out.println("mã hóa đơn mới nhất: "+maDDH_LayVe);
	        con.con().close();
	        //preparedStatement.close();
	        rs.close();
	        return maDDH_LayVe;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return null;
	    }
	}
}
