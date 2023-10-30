package dataBase_BUS;

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
import entities.KhachHang;
import entities.NhaCungCap;
import interface_Method_Database.Method_Select_NhaCung_Cap;
import list_Array_DAO.KhachHang_DAO;
import list_Array_DAO.NhaCungCap_DAO;

public class DataBase_NhaCungCap_BUS implements Method_Select_NhaCung_Cap
{
	private Connect con = new Connect();
	NhaCungCap_DAO listNhaCungCap_DAO=new NhaCungCap_DAO();
	public DataBase_NhaCungCap_BUS() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public void timKiemTheoMaNCC(String maNCCCanTim, DefaultTableModel dtm_NCC) {
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
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}
	@Override
	public void timKiemTheoTenNCC(String tenNCCCanTim, DefaultTableModel dtm_NCC) {
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
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public void timKiemTheoDiaChi(String diaChiCanTim, DefaultTableModel dtm_NCC) {
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
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	/*
	 * select * from [dbo].[NhaCungCap]
		where sdtNCC='02836007777'
		ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
	 */
	@Override
	public void timKiemTheoSoDienThoaiNCC(String sdtNCCCanTim, DefaultTableModel dtm_NCC) {
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
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	/*
	 * select * from [dbo].[NhaCungCap]
		where email='daikavan@iuh.com'
		ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
	 */
	@Override
	public void timKiemTheoEmail(String emailCanTim, DefaultTableModel dtm_NCC) {
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
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	@Override
	public void timKiemTheoTieuChiKhacMaNCC(NhaCungCap n, DefaultTableModel dtm_NCC) {
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
		} catch (SQLException e) {
			e.printStackTrace();
			UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
			UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	/*
	 * select * from [dbo].[NhaCungCap]
	where maNCC='NCC10' and tenNCC='02838207153'
	ORDER BY CAST(SUBSTRING(maNCC, 4, LEN(maNCC)) AS INT) ASC;
	 */
	
	@Override
	public void timKiemTheo_tenNCC_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	@Override
	public void timKiemTheo_tenNCC_sdtNCC(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	@Override
	public void timKiemTheo_tenNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	@Override
	public void timKiemTheo_diaChi_sdtNCC(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	@Override
	public void timKiemTheo_diaChi_email(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	@Override
	public void timKiemTheo_sdtNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}
	@Override
	public void timKiemTheo_tenNCC_sdtNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	@Override
	public void timKiemTheo_tenNCC_sdtNCC_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	@Override
	public void timKiemTheo_tenNCC_email_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}

	@Override
	public void timKiemTheo_sdtNCC_email_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
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
	    } catch (SQLException e) {
	        e.printStackTrace();
	        UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
	        UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
	    }
	}


}
