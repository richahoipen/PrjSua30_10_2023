package interface_Method_DAO;

import java.sql.Date;

import javax.swing.table.DefaultTableModel;

import entities.DonDatHang;
import entities.KhachHang;


public interface DonDatHang_Method {
	public boolean themDonDatHang(DonDatHang d,String maKH,String maNV);
	public String getMaKH(KhachHang k);
	public boolean xuat_DonDat_ChuaThanhToan(String maNV,DefaultTableModel dtm_DD,String maKH);
	public String getTenKH(String maDDH);
	public String getSDT_KH(String maDDH);
	public boolean getGioiTinh_KH(String maDDH);
	public double getTongTien_DonDatHang(String maDDH);
	public boolean xuat_DonDatHang_TimKiem(DefaultTableModel dtm_DD);
	public Date getNgayDat(String maDDH);
	//public
	public String get_MaDDH_MoiNhat();
	//public DonDatHang(String maDDH, Date ngayDat,boolean daLapHoaDon)
	public boolean tim_DonDatHang(DonDatHang d,String tenNV,KhachHang k,int ngay,int thang,int nam,DefaultTableModel dtm_DD);
	
}
