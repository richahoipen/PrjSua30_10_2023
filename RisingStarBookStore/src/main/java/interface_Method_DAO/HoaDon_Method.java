package interface_Method_DAO;




import javax.swing.table.DefaultTableModel;

import entities.HoaDon;

public interface HoaDon_Method {
	public boolean themHoaDon(HoaDon h, String maNV,String maKH);
	public boolean xuat_DanhSach_HoaDon(DefaultTableModel dtm_HD);
	public String getMaHD_MoiNhat();
	public boolean capNhat_CTHoaDon(String maHD);
	public boolean capNhatSoLuong(String maSP,int soLuong);
	public boolean capNhatDonDatHang(String maDDH);
	public String get_MaHD_MoiNhat();
	public HoaDon get_HoaDon(String maHD);
}
