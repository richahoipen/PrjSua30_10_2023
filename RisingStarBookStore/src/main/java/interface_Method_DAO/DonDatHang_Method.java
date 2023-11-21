package interface_Method_DAO;

import javax.swing.table.DefaultTableModel;

import entities.DonDatHang;
import entities.KhachHang;


public interface DonDatHang_Method {
	public boolean themDonDatHang(DonDatHang d,String maKH,String maNV);
	public String getMaKH(KhachHang k);
	public boolean xuat_DonDat_ChuaThanhToan(String maNV,DefaultTableModel dtm_DD);
	public String getTenKH(String maDDH);
	public String getSDT_KH(String maDDH);
	public boolean getGioiTinh_KH(String maDDH);
	public double getTongTien_DonDatHang(String maDDH);
}
