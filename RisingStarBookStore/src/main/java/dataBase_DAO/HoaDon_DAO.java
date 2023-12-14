package dataBase_DAO;

import java.awt.Font;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import connectDB.Connect;
import entities.HoaDon;
import entities.HoaDon_TimKiem;
import entities.KhachHang;
import interface_Method_DAO.HoaDon_Method;

public class HoaDon_DAO implements HoaDon_Method
{
	private Connect con = new Connect();

	public HoaDon_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}
	//SỬA LẠI GẤP
	@Override
	public boolean themHoaDon(HoaDon h, String maNV, String maKH) {
		String sqlInsert_HoaDon = "DECLARE @NextIndex INT;\r\n"
				+ "SELECT @NextIndex = ISNULL(MAX(CAST(SUBSTRING(maHD,3, LEN(maHD)) AS INT)), 0) + 1 FROM HoaDon;\r\n"
				+ "DECLARE @NewMaHD VARCHAR(20);\r\n"
				+ "SET  @NewMaHD = 'HD' + CAST(@NextIndex AS VARCHAR);\r\n"
				+ "insert into [dbo].[HoaDon]([maHD],[ngayLap],[gioLap],[tienKhachDua],[tongTien],[maNV],[maKH])\r\n"
				+ "values (@NewMaHD,?,?,?,?,?,?)";
		/*String sqlInsert_CTHoaDon="DECLARE @NewSTT INT;\r\n"
				+ "SET @NewSTT = ISNULL((SELECT MAX(sTT) FROM [dbo].[CTHoaDon]), 0) + 1;\r\n"
				+ "insert into [dbo].[CTHoaDon]([sTT],[maSP],[donGia],[soLuong],[thanhTien])\r\n"
				+ "values (@NewSTT,?,?,?,?)";*/
		try {
			//PreparedStatement preparedStatement_Insert_CTHoaDon = con.con().prepareStatement(sqlInsert_CTHoaDon);
			
			PreparedStatement preparedStatement_Insert_HoaDon = con.con().prepareStatement(sqlInsert_HoaDon);
			preparedStatement_Insert_HoaDon.setDate(1, h.getNgayLap());
			preparedStatement_Insert_HoaDon.setTime(2, h.getGioLap());
			preparedStatement_Insert_HoaDon.setDouble(3, h.getTienKhachDua());
			preparedStatement_Insert_HoaDon.setDouble(4, h.getTongTien());
			preparedStatement_Insert_HoaDon.setNString(5,maNV);
			preparedStatement_Insert_HoaDon.setNString(6,maKH);
			//preparedStatement_Insert.setNString(1,maKH);
			//Thực thi câu lệnh
			preparedStatement_Insert_HoaDon.executeUpdate();
			//Truy vấn CTHoaDon
			/*
			for(CTDonDatHang c: listCTDonDatHang)
			{
				
				preparedStatement_Insert_CTHoaDon.setNString(1, c.getMaSP());
				preparedStatement_Insert_CTHoaDon.setDouble(2, c.getDonGia());
				preparedStatement_Insert_CTHoaDon.setInt(3, c.getSoLuong());
				preparedStatement_Insert_CTHoaDon.setDouble(4, c.getThanhTien());
				preparedStatement_Insert_CTHoaDon.executeUpdate();
				System.out.println("Lập CTHD");
			}
			System.out.println("Lập hóa đơn thành công");*/
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null,"Lập hóa đơn thành công.\nMake bill success.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			con.con().close();
			preparedStatement_Insert_HoaDon.close();
			
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
	public boolean capNhatSoLuong(String maSP,int soLuong) 
	{
		String sql_Update="update [dbo].[SanPham]\r\n"
				+ "set soLuong=soLuong-?,\r\n"
				+ "soLuongBan=soLuongBan+?\r\n"
				+ "where maSP=?";
		try {
			PreparedStatement preparedStatement_Update = con.con().prepareStatement(sql_Update);
			//preparedStatement_Update.setNString(1,maHD);
			preparedStatement_Update.setInt(1, soLuong);
			preparedStatement_Update.setInt(2, soLuong);
			preparedStatement_Update.setNString(3, maSP);
			
			preparedStatement_Update.executeUpdate();
			con.con().close();
			con.stmt().close();
			preparedStatement_Update.close();
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
	 * update [dbo].[DonDatHang]
		set daLapHoaDon=?
		where maDDH=?
	 */
	@Override
	public boolean capNhatDonDatHang(String maDDH) {
		String sql_Update="update [dbo].[DonDatHang]\r\n"
				+ "set daLapHoaDon=?\r\n"
				+ "where maDDH=?";
		try {
			PreparedStatement preparedStatement_Update = con.con().prepareStatement(sql_Update);
			//preparedStatement_Update.setNString(1,maHD);
			preparedStatement_Update.setBoolean(1, true);
			preparedStatement_Update.setNString(2, maDDH);
			
			preparedStatement_Update.executeUpdate();
			con.con().close();
			con.stmt().close();
			preparedStatement_Update.close();
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
	public String getMaHD_MoiNhat() {
		// TODO Auto-generated method stub
		String sqlSelect = "SELECT maHD\r\n"
				+ "FROM [dbo].[HoaDon] \r\n"
				+ "WHERE maHD = (\r\n"
				+ "    SELECT TOP 1 maHD\r\n"
				+ "    FROM [dbo].[HoaDon]\r\n"
				+ "    ORDER BY CAST(SUBSTRING(maNV, 3, LEN(maHD)) AS INT) DESC\r\n"
				+ ");";
		String maHD_LayVe="";
		try {
			ResultSet rs = con.resultSet(sqlSelect);
				
			while (rs.next()) {			
				String maHD = rs.getString("maHD");
				maHD_LayVe+=maHD;
			}
			con.con().close();
			con.stmt().close();
			rs.close();
			return maHD_LayVe;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
					
		}
	}
	/*
	 * update [dbo].[CTHoaDon]
		set maHD=? where maHD is null
	 */
	//KHÔNG XÀI
	@Override
	public boolean capNhat_CTHoaDon(String maHD) 
	{
		String sqlInsert_Update="update [dbo].[CTHoaDon]\r\n"
				+ "set maHD=? where maHD is null";
		try {
			PreparedStatement preparedStatement_Update = con.con().prepareStatement(sqlInsert_Update);
			preparedStatement_Update.setNString(1,maHD);
			
			preparedStatement_Update.executeUpdate();
			con.con().close();
			preparedStatement_Update.close();
			
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
	public HoaDon get_HoaDon(String maHD_canTim) {
		String sqlSelect = "select * from [dbo].[HoaDon]\r\n"
				+ "where maHD=N'"+maHD_canTim+"';";
		HoaDon h=null;
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			//public HoaDon(String maHD, Date ngayLap,Time gioLap,double tongTien,double tienKhachDua)
			while (rs.next()) {			
				String maHD=rs.getNString("maHD");
				Date ngayLap=rs.getDate("ngayLap");
				Time gioLap=rs.getTime("gioLap");
				double tongTien=rs.getDouble("tongTien");
				double tienKhachDua=rs.getDouble("tienKhachDua");
				HoaDon h1=new HoaDon(maHD, ngayLap, gioLap, tongTien, tienKhachDua);
				h=h1;
			}
			con.con().close();
			con.stmt().close();
			rs.close();
			return h;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
			
		}
	}
	/*
	 * SELECT TOP 1 maHD
FROM [dbo].[HoaDon]
ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maKH)) AS INT) DESC;
	 */
	@Override
	public String get_MaHD_MoiNhat() {
		String sqlSelect = "SELECT TOP 1 maHD\r\n"
				+ "FROM [dbo].[HoaDon]\r\n"
				+ "ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) DESC;";		
	    try {
	    	String maHD_LayVe="";
	    	//PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        //ResultSet rs = preparedStatement.executeQuery();
	    	ResultSet rs = con.resultSet(sqlSelect);
	        while (rs.next()) {
	            String maHD=rs.getNString("maHD");
	            maHD_LayVe+=maHD;
	        }
	        System.out.println("mã hóa đơn mới nhất:"+maHD_LayVe);
	        con.con().close();
	        //preparedStatement.close();
	        rs.close();
	        return maHD_LayVe;
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	        return null;
	    }
	}
	/*
	 * SELECT HoaDon.maHD, HoaDon.ngayLap, HoaDon.tongTien,
       KhachHang.tenKH, KhachHang.sdt,
       NhanVien.tenNV
		FROM HoaDon
		JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV
		JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH
		ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) ASC;
	 */
	@Override
	public boolean xuat_DanhSach_HoaDon(DefaultTableModel dtm_HD) {
		String sqlSelect ="SELECT HoaDon.maHD, HoaDon.ngayLap, HoaDon.tongTien,\r\n"
				+ "       KhachHang.tenKH, KhachHang.sdt,\r\n"
				+ "       NhanVien.tenNV\r\n"
				+ "		FROM HoaDon\r\n"
				+ "		JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "		JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "		ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) ASC;";
		try {
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        //preparedStatement.setNString(1, maNV);
	        
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				String maHD=rs.getNString("maHD");
				String tenNV=rs.getNString("tenNV");
				String tenKH=rs.getNString("tenKH");
				String sdt=rs.getNString("sdt");
				Date ngayLap=rs.getDate("ngayLap");
				double tongTien=rs.getDouble("tongTien");	
				HoaDon h=new HoaDon();
				h.setNgayLap(ngayLap);
				String[] row= {maHD,tenNV,tenKH,sdt,h.getNgayLapToString(),Double.toString(tongTien)};
				dtm_HD.addRow(row);
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
	public Date getNgayLap(String maHD) {
		String sqlSelect = "SELECT HoaDon.ngayLap\r\n"
				+ "FROM HoaDon\r\n"
				+ "JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "where maHD=N'"+maHD+"';";
		Date ngayLap_Return=null;
		try {
			ResultSet rs = con.resultSet(sqlSelect);
			// NhanVien(String maNV, String tenNV, String sdt, String gioiTinh, String
			// diaChi, Date ngaySinh, String chucVu,
			// String cMND, String caLam)
			
			while (rs.next()) {			
				Date ngayLap=rs.getDate("ngayLap");
				ngayLap_Return=ngayLap;
			}
			
			con.con().close();
			con.stmt().close();
			rs.close();
			return ngayLap_Return;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
			
		}
	}
	@Override
	public boolean tim_HoaDon(HoaDon h_CanTim, String tenNV_CanTim, KhachHang k, int ngay, int thang, int nam,
			DefaultTableModel dtm_HD) {
		/*
		String sqlSelect="SELECT HoaDon.maHD, HoaDon.ngayLap, HoaDon.tongTien,\r\n"
				+ "       KhachHang.tenKH, KhachHang.sdt,\r\n"
				+ "       NhanVien.tenNV\r\n"
				+ "FROM HoaDon\r\n"
				+ "JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "WHERE\r\n"
				+ "    HoaDon.maHD=? or\r\n"
				+ "	NhanVien.tenNV=? or\r\n"
				+ "	KhachHang.tenKH=? or\r\n"
				+ "	KhachHang.sdt=? or\r\n"
				+ "	HoaDon.tongTien=? or\r\n"
				+ "	DAY(HoaDon.ngayLap)=? or\r\n"
				+ "	MONTH(HoaDon.ngayLap)=? or\r\n"
				+ "	YEAR(HoaDon.ngayLap)=? \r\n"			
				+ "ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) ASC;";
				
		try {
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        //preparedStatement.setNString(1, maNV);
			preparedStatement.setNString(1, h_CanTim.getMaHD());
			preparedStatement.setNString(2, tenNV_CanTim);
			preparedStatement.setNString(3, k.getTenKH());
			preparedStatement.setNString(4, k.getSdt());
			preparedStatement.setDouble(5, h_CanTim.getTongTien());
			preparedStatement.setInt(6, ngay);
			preparedStatement.setInt(7, thang);
			preparedStatement.setInt(8, nam);
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				String maHD=rs.getNString("maHD");
				String tenNV=rs.getNString("tenNV");
				String tenKH=rs.getNString("tenKH");
				String sdt=rs.getNString("sdt");
				Date ngayLap=rs.getDate("ngayLap");
				double tongTien=rs.getDouble("tongTien");	
				HoaDon h=new HoaDon();
				h.setNgayLap(ngayLap);
				String[] row= {maHD,tenNV,tenKH,sdt,h.getNgayLapToString(),Double.toString(tongTien)};
				dtm_HD.addRow(row);
			}	
			System.out.println("Tìm kiếm hóa đơn thành công.");
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
		}*/
		return true;
	}
	@Override
	public ArrayList<HoaDon_TimKiem> listHoaDon_TimKiem() {
		String sqlSelect ="SELECT HoaDon.maHD, HoaDon.ngayLap, HoaDon.tongTien,\r\n"
				+ "       KhachHang.tenKH, KhachHang.sdt,\r\n"
				+ "       NhanVien.tenNV\r\n"
				+ "		FROM HoaDon\r\n"
				+ "		JOIN NhanVien ON HoaDon.maNV = NhanVien.maNV\r\n"
				+ "		JOIN KhachHang ON HoaDon.maKH = KhachHang.maKH\r\n"
				+ "		ORDER BY CAST(SUBSTRING(maHD, 3, LEN(maHD)) AS INT) ASC;";
		ArrayList<HoaDon_TimKiem> listHD=new ArrayList<HoaDon_TimKiem>();
		try {
			PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
	        //preparedStatement.setNString(1, maNV);
	        
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next())
			{
				String maHD=rs.getNString("maHD");
				String tenNV=rs.getNString("tenNV");
				String tenKH=rs.getNString("tenKH");
				String sdt=rs.getNString("sdt");
				Date ngayLap=rs.getDate("ngayLap");
				double tongTien=rs.getDouble("tongTien");	
				HoaDon_TimKiem h=new HoaDon_TimKiem(maHD, tenKH, tenNV, ngayLap, tongTien, sdt);
				listHD.add(h);
			}	
			con.con().close();
			con.stmt().close();
			rs.close();
			return listHD;
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 25));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 25));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}
	
	
}
