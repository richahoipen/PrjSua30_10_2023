package interface_Method_DAO;

import java.util.ArrayList;

import entities.CTDonDatHang;
import entities.HoaDon;

public interface HoaDon_Method {
	public boolean themHoaDon(HoaDon h, String maNV,String maKH,ArrayList<CTDonDatHang> listCTDonDatHang);
	public String getMaHD_MoiNhat();
	public boolean capNhat_CTHoaDon(String maHD);
	public boolean capNhatSoLuong(String maSP,int soLuong);
	public boolean capNhatDonDatHang(String maDDH);
	public HoaDon get_HoaDon(String maHD);
}
