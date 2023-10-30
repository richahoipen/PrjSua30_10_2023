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
import interface_Method_Database.Method_Select_KhachHang;
import list_Array_DAO.KhachHang_DAO;

public class DataBase_KhachHang_BUS implements Method_Select_KhachHang
{
	private Connect con = new Connect();
	KhachHang_DAO listKhachHang_DAO=new KhachHang_DAO();
	public DataBase_KhachHang_BUS() {
		super();
		// TODO Auto-generated constructor stub
	}
	//TÌM KIẾM 1 Tiêu Chí
		public void timKiemTheoMaKH(String maKHCanTruyVan, DefaultTableModel dtm_KH) {
			String sqlSelect = "SELECT *\r\n" + "FROM KhachHang\r\n" + "WHERE maKH='" + maKHCanTruyVan + "';";
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

		private int chuyenGioiTinhThanhInt(String gioiTinh) {
			if (gioiTinh.equalsIgnoreCase("Nam"))
				return 1;
			if (gioiTinh.equalsIgnoreCase("Nữ"))
				return 0;
			return -1;
		}

		public void timKiemTheoGioiTinh(String gioiTinhCanTruyVan, DefaultTableModel dtm_KH) {
			String sqlSelect = "SELECT *\r\n" + "FROM KhachHang\r\n" + "WHERE gioiTinh="
					+ chuyenGioiTinhThanhInt(gioiTinhCanTruyVan) + "\r\n"
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
		//Tìm Kiếm theo địa chỉ
		public void timKiemTheoDiaChi(String diaChiCanTruyVan, DefaultTableModel dtm_KH) 
		{
			//Lấy hết data KhachHang
			String sqlSelect = "select * from [dbo].[KhachHang]\r\n"
					+ "ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";
			try {
				//List<KhachHang> listKhachHang_DAO=new ArrayList<>();
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
					listKhachHang_DAO.themKH(k);
				}
				listKhachHang_DAO.xuatBangTheo_DiaChi(diaChiCanTruyVan, dtm_KH);
				
				con.con().close();
				con.stmt().close();
			} catch (SQLException e) {
				e.printStackTrace();
				UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
				UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		public void timKiemTheoTen(String tenCanTruyVan, DefaultTableModel dtm_KH) {
			String sqlSelect = "select * from [dbo].[KhachHang]\r\n"
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
					//Thêm vào mảng động
					listKhachHang_DAO.themKH(k);
				}
				listKhachHang_DAO.xuatBangTheo_Ten(tenCanTruyVan, dtm_KH);
				con.con().close();
				con.stmt().close();
			} catch (SQLException e) {
				e.printStackTrace();
				UIManager.put("OptionPane.messageFont", new Font("Arial", Font.BOLD, 30));
				UIManager.put("OptionPane.buttonFont", new Font("Arial", Font.PLAIN, 28));
				JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		public void timKiemTheoSDT(String sdtTruyVan, DefaultTableModel dtm_KH) {
			String sqlSelect = "SELECT *\r\n" + "FROM KhachHang\r\n" + "WHERE sdt='" + sdtTruyVan + "'\r\n"
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
		//Tìm kiếm khách hàng khác maKH
		public void timKiemTheoTieuChiKhacMaKH(KhachHang k, DefaultTableModel dtm_KH) {
			String sqlSelect = "select * from [dbo].[KhachHang]\r\n"
					+ "ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";
			try {
				ResultSet rs = con.resultSet(sqlSelect);
				List<KhachHang> listKH=new ArrayList<>();
				// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
				// diaChi)
				while (rs.next()) {
					String maKH = rs.getString("maKH");
					String tenKH = rs.getString("tenKH");
					String sdt = rs.getString("sdt");
					boolean gioiTinh = rs.getBoolean("gioiTinh");
					String diaChi = rs.getString("diaChi");
					KhachHang khachHang = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
					//String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
					listKH.add(khachHang);
				}
				for(KhachHang kh:listKH)
				{
					if(kh.getTenKH().equalsIgnoreCase(k.getTenKH())&&
							kh.getSdt().equalsIgnoreCase(k.getSdt())&&
								kh.isGioiTinh()==k.isGioiTinh()
									&& kh.getDiaChi().equalsIgnoreCase(k.getDiaChi()))
							
					{
						String[] row = { kh.getMaKH(),kh.getTenKH(),kh.getSdt(), kh.traVeGioiTinh(), kh.getDiaChi()};
						dtm_KH.addRow(row);
					}
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
		 * SELECT * FROM KhachHang WHERE tenKH='Van Minh' AND sdt='0976646635';
		 * TÌM CHI TIẾT CỤ THỂ
		 */
		@Override
		public void timKiemTheo_tenKH_sdt(KhachHang k, DefaultTableModel dtm_KH) 
		{
			String sqlSelect="select * from [dbo].[KhachHang]\r\n"
					+ "ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";
			try {
				ResultSet rs = con.resultSet(sqlSelect);
				List<KhachHang> listKH=new ArrayList<>();
				// KhachHang(String maKH, String tenKH, String sdt, boolean gioiTinh, String
				// diaChi)
				while (rs.next()) {
					String maKH = rs.getString("maKH");
					String tenKH = rs.getString("tenKH");
					String sdt = rs.getString("sdt");
					boolean gioiTinh = rs.getBoolean("gioiTinh");
					String diaChi = rs.getString("diaChi");
					KhachHang khachHang = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
					listKH.add(khachHang);
				}
				for(KhachHang kh:listKH)
				{
					if(kh.getTenKH().equalsIgnoreCase(k.getTenKH())&&
							kh.getSdt().equalsIgnoreCase(k.getSdt()))
							
					{
						String[] row = { kh.getMaKH(),kh.getTenKH(),kh.getSdt(), kh.traVeGioiTinh(), kh.getDiaChi()};
						dtm_KH.addRow(row);
					}
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
		 * SELECT *
		FROM KhachHang
		WHERE 
		tenKH='Van Minh'
		AND diaChi='1 Os street';
		 */
		@Override
		public void timKiemTheo_tenKH_diaChi(KhachHang k, DefaultTableModel dtm_KH) {
		    String sqlSelect = "SELECT * FROM KhachHang WHERE tenKH = ? AND diaChi = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

		    try {
		        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
		        preparedStatement.setString(1, k.getTenKH());
		        preparedStatement.setString(2, k.getDiaChi());
		        ResultSet rs = preparedStatement.executeQuery();

		        while (rs.next()) {
		            String maKH = rs.getString("maKH");
		            String tenKH = rs.getString("tenKH");
		            String sdt = rs.getString("sdt");
		            boolean gioiTinh = rs.getBoolean("gioiTinh");
		            String diaChi = rs.getString("diaChi");
		            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
		            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
		            dtm_KH.addRow(row);
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

		/*
		 * SELECT *
		FROM KhachHang
		WHERE 
		tenKH='Van Minh'
		AND gioiTinh=1;
		 */
		@Override
		public void timKiemTheo_tenKH_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
		    String sqlSelect = "SELECT * FROM KhachHang WHERE tenKH = ? AND gioiTinh = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

		    try {
		        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
		        preparedStatement.setString(1, k.getTenKH());
		        preparedStatement.setBoolean(2, k.isGioiTinh());
		        ResultSet rs = preparedStatement.executeQuery();

		        while (rs.next()) {
		            String maKH = rs.getString("maKH");
		            String tenKH = rs.getString("tenKH");
		            String sdt = rs.getString("sdt");
		            boolean gioiTinh = rs.getBoolean("gioiTinh");
		            String diaChi = rs.getString("diaChi");
		            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
		            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
		            dtm_KH.addRow(row);
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


		/*Theo sdt và diaChi
		 * 
		 */
		@Override
		public void timKiemTheo_sdt_diaChi(KhachHang k, DefaultTableModel dtm_KH) {
		    String sqlSelect = "SELECT * FROM KhachHang WHERE sdt = ? AND diaChi = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

		    try {
		        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
		        preparedStatement.setString(1, k.getSdt());
		        preparedStatement.setString(2, k.getDiaChi());
		        ResultSet rs = preparedStatement.executeQuery();

		        while (rs.next()) {
		            String maKH = rs.getString("maKH");
		            String tenKH = rs.getString("tenKH");
		            String sdt = rs.getString("sdt");
		            boolean gioiTinh = rs.getBoolean("gioiTinh");
		            String diaChi = rs.getString("diaChi");
		            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
		            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
		            dtm_KH.addRow(row);
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
		public void timKiemTheo_sdt_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
		    String sqlSelect = "SELECT * FROM KhachHang WHERE sdt = ? AND gioiTinh = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

		    try {
		        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
		        preparedStatement.setString(1, k.getSdt());
		        preparedStatement.setBoolean(2, k.isGioiTinh());
		        ResultSet rs = preparedStatement.executeQuery();

		        while (rs.next()) {
		            String maKH = rs.getString("maKH");
		            String tenKH = rs.getString("tenKH");
		            String sdt = rs.getString("sdt");
		            boolean gioiTinh = rs.getBoolean("gioiTinh");
		            String diaChi = rs.getString("diaChi");
		            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
		            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
		            dtm_KH.addRow(row);
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

		//Tìm kiếm theo địa chỉ giới tính
		@Override
		public void timKiemTheo_diaChi_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
		    String sqlSelect = "SELECT * FROM KhachHang WHERE diaChi = ? AND gioiTinh = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

		    try {
		        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
		        preparedStatement.setString(1, k.getDiaChi());
		        preparedStatement.setBoolean(2, k.isGioiTinh());
		        ResultSet rs = preparedStatement.executeQuery();

		        while (rs.next()) {
		            String maKH = rs.getString("maKH");
		            String tenKH = rs.getString("tenKH");
		            String sdt = rs.getString("sdt");
		            boolean gioiTinh = rs.getBoolean("gioiTinh");
		            String diaChi = rs.getString("diaChi");
		            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
		            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
		            dtm_KH.addRow(row);
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
		public void timKiemTheo_tenKH_sdt_diaChi(KhachHang k, DefaultTableModel dtm_KH) {
		    String sqlSelect = "SELECT * FROM KhachHang WHERE tenKH = ? AND sdt = ? AND diaChi = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

		    try {
		        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
		        preparedStatement.setString(1, k.getTenKH());
		        preparedStatement.setString(2, k.getSdt());
		        preparedStatement.setString(3, k.getDiaChi());
		        ResultSet rs = preparedStatement.executeQuery();

		        while (rs.next()) {
		            String maKH = rs.getString("maKH");
		            String tenKH = rs.getString("tenKH");
		            String sdt = rs.getString("sdt");
		            boolean gioiTinh = rs.getBoolean("gioiTinh");
		            String diaChi = rs.getString("diaChi");
		            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
		            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
		            dtm_KH.addRow(row);
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
		public void timKiemTheo_tenKH_sdt_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
		    String sqlSelect = "SELECT * FROM KhachHang WHERE tenKH = ? AND sdt = ? AND gioiTinh = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

		    try {
		        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
		        preparedStatement.setString(1, k.getTenKH());
		        preparedStatement.setString(2, k.getSdt());
		        preparedStatement.setBoolean(3, k.isGioiTinh());
		        ResultSet rs = preparedStatement.executeQuery();

		        while (rs.next()) {
		            String maKH = rs.getString("maKH");
		            String tenKH = rs.getString("tenKH");
		            String sdt = rs.getString("sdt");
		            boolean gioiTinh = rs.getBoolean("gioiTinh");
		            String diaChi = rs.getString("diaChi");
		            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
		            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
		            dtm_KH.addRow(row);
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
		public void timKiemTheo_tenKH_diaChi_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
		    String sqlSelect = "SELECT * FROM KhachHang WHERE tenKH = ? AND diaChi = ? AND gioiTinh = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

		    try {
		        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
		        preparedStatement.setString(1, k.getTenKH());
		        preparedStatement.setString(2, k.getDiaChi());
		        preparedStatement.setBoolean(3, k.isGioiTinh());
		        ResultSet rs = preparedStatement.executeQuery();

		        while (rs.next()) {
		            String maKH = rs.getString("maKH");
		            String tenKH = rs.getString("tenKH");
		            String sdt = rs.getString("sdt");
		            boolean gioiTinh = rs.getBoolean("gioiTinh");
		            String diaChi = rs.getString("diaChi");
		            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
		            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
		            dtm_KH.addRow(row);
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
		public void timKiemTheo_sdt_diaChi_gioiTinh(KhachHang k, DefaultTableModel dtm_KH) {
		    String sqlSelect = "SELECT * FROM KhachHang WHERE sdt = ? AND diaChi = ? AND gioiTinh = ? ORDER BY CAST(SUBSTRING(maKH, 3, LEN(maKH)) AS INT) ASC;";

		    try {
		        PreparedStatement preparedStatement = con.con().prepareStatement(sqlSelect);
		        preparedStatement.setString(1, k.getSdt());
		        preparedStatement.setString(2, k.getDiaChi());
		        preparedStatement.setBoolean(3, k.isGioiTinh());
		        ResultSet rs = preparedStatement.executeQuery();

		        while (rs.next()) {
		            String maKH = rs.getString("maKH");
		            String tenKH = rs.getString("tenKH");
		            String sdt = rs.getString("sdt");
		            boolean gioiTinh = rs.getBoolean("gioiTinh");
		            String diaChi = rs.getString("diaChi");
		            KhachHang kh = new KhachHang(maKH, tenKH, sdt, gioiTinh, diaChi);
		            String[] row = { maKH, tenKH, sdt, kh.traVeGioiTinh(), diaChi };
		            dtm_KH.addRow(row);
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
