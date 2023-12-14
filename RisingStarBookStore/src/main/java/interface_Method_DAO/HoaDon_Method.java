package interface_Method_DAO;




import java.sql.Date;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


import entities.HoaDon;
import entities.HoaDon_TimKiem;
import entities.KhachHang;

public interface HoaDon_Method {
	public boolean themHoaDon(HoaDon h, String maNV,String maKH);
	public boolean xuat_DanhSach_HoaDon(DefaultTableModel dtm_HD);
	public String getMaHD_MoiNhat();
	public boolean capNhat_CTHoaDon(String maHD);
	public boolean capNhatSoLuong(String maSP,int soLuong);
	public boolean capNhatDonDatHang(String maDDH);
	public String get_MaHD_MoiNhat();
	public HoaDon get_HoaDon(String maHD);
	public Date getNgayLap(String maHD);
	public boolean tim_HoaDon(HoaDon h,String tenNV,KhachHang k,int ngay,int thang,int nam,DefaultTableModel dtm_HD);
	public ArrayList<HoaDon_TimKiem> listHoaDon_TimKiem();
}
