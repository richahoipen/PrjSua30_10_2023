package interface_Method_DAO;

import java.time.LocalDate;
import java.util.ArrayList;

import entities.NhanVien;
import entities.SanPham;
public interface ThongKe_Method {
	//Ngày
	public int getLuong_HoaDon_TheoNgay(LocalDate ngay);
	public int getLuong_Khach_TheoNgay(LocalDate ngay);
	public int getLuong_SanPham_TheoNgay(LocalDate ngay);
	public double getLuong_TongTien_TheoNgay(LocalDate ngay);
	public double getTongTien_Nhap_SanPham();
	//Tuần
	public int getLuong_HoaDon_Theo_Tuan(int tuan, int nam);
	public int getLuong_Khach_Theo_Tuan(int tuan, int nam);
	public int getLuong_SanPham_Theo_Tuan(int tuan, int nam);
	public double getLuong_TongTien_Theo_Tuan(int tuan, int nam);
	//
	public ArrayList<NhanVien> getListNhanVien();
	//Theo NV
	public int getLuong_HoaDon_TheoNV(String maNV);
	public int getLuong_Khach_TheoNV(String maNV);
	public int getLuong_SanPham_TheoNV(String maNV);
	public double getLuong_TongTien_TheoNV(String maNV);
	//theo ngay và NhanVien
	public int getLuong_HoaDon_Theo_Ngay_NV(LocalDate ngay,String maNV);
	public int getLuong_Khach_Theo_Ngay_NV(LocalDate ngay,String maNV);
	public int getLuong_SanPham_Theo_Ngay_NV(LocalDate ngay,String maNV);
	public double getLuong_TongTien_Theo_Ngay_NV(LocalDate ngay,String maNV);
	//Theo tuan và NhanVien
	public int getLuong_HoaDon_Theo_Tuan_NV(int tuan, int nam,String maNV);
	public int getLuong_Khach_Theo_Tuan_NV(int tuan, int nam,String maNV);
	public int getLuong_SanPham_Theo_Tuan_NV(int tuan, int nam,String maNV);
	public double getLuong_TongTien_Theo_Tuan_NV(int tuan, int nam,String maNV);
	//Sản Phẩm
	public ArrayList<SanPham> getListSanPham();
	public double getTongTien_HoaDon_Theo_MaSP(String maSP);
}
