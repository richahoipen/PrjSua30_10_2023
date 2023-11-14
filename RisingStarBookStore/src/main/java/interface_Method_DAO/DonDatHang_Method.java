package interface_Method_DAO;

import entities.DonDatHang;
import entities.KhachHang;


public interface DonDatHang_Method {
	public boolean themDonDatHang(DonDatHang d,String maKH,String maNV);
	public String getMaKH(KhachHang k);
}
