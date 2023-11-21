package dataBase_BUS;




import javax.swing.table.DefaultTableModel;



import customEntities.Custom_ComboBox;
import dataBase_DAO.NhaCungCap_DAO;
import entities.NhaCungCap;
import interface_Method_DAO.NhaCungCap_Method;


public class NhaCungCap_BUS implements NhaCungCap_Method 
{
	private NhaCungCap_DAO dataBase_NhaCungCap_DAO=new NhaCungCap_DAO();
	
	public NhaCungCap_BUS() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean xuatDanhSachNhaCungCap(DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.xuatDanhSachNhaCungCap(dtm_NCC);
	}

	@Override
	public boolean themNhaCungCap(NhaCungCap n) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.themNhaCungCap(n);
	}

	@Override
	public boolean capNhatNhaCungCap(NhaCungCap n) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.capNhatNhaCungCap(n);
	}

	@Override
	public boolean dayComboBoxMaNCC(Custom_ComboBox cbMaNCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.dayComboBoxMaNCC(cbMaNCC);
	}

	@Override
	public boolean dayComboBoxTenNCC(Custom_ComboBox cbo_TenNCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.dayComboBoxTenNCC(cbo_TenNCC);
	}

	@Override
	public boolean dayComboBoxDiaChi(Custom_ComboBox cbo_DiaChi) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.dayComboBoxDiaChi(cbo_DiaChi);
	}

	@Override
	public boolean dayComboBoxSoDienThoai(Custom_ComboBox cbo_SoDT) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.dayComboBoxSoDienThoai(cbo_SoDT);
	}

	@Override
	public boolean dayComboBoxEmail(Custom_ComboBox cbo_Email) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.dayComboBoxEmail(cbo_Email);
	}

	@Override
	public boolean timKiemTheoMaNCC(String maNCC, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheoMaNCC(maNCC, dtm_NCC);
	}

	@Override
	public boolean timKiemTheoTenNCC(String tenNCC, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheoTenNCC(tenNCC, dtm_NCC);
	}

	@Override
	public boolean timKiemTheoDiaChi(String diaChi, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheoDiaChi(diaChi, dtm_NCC);
	}

	@Override
	public boolean timKiemTheoSoDienThoaiNCC(String sdtNCC, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheoSoDienThoaiNCC(sdtNCC, dtm_NCC);
	}

	@Override
	public boolean timKiemTheoEmail(String email, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheoEmail(email, dtm_NCC);
	}

	@Override
	public boolean timKiemTheoTieuChiKhacMaNCC(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheoTieuChiKhacMaNCC(ncc, dtm_NCC);
	}

	@Override
	public boolean timKiemTheo_tenNCC_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheo_tenNCC_diaChi(ncc, dtm_NCC);
	}

	@Override
	public boolean timKiemTheo_tenNCC_sdtNCC(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheo_tenNCC_sdtNCC(ncc, dtm_NCC);
	}

	@Override
	public boolean timKiemTheo_tenNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheo_tenNCC_email(ncc, dtm_NCC);
	}

	@Override
	public boolean timKiemTheo_diaChi_sdtNCC(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheo_diaChi_sdtNCC(ncc, dtm_NCC);
	}

	@Override
	public boolean timKiemTheo_diaChi_email(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheo_diaChi_email(ncc, dtm_NCC);
	}

	@Override
	public boolean timKiemTheo_sdtNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheo_sdtNCC_email(ncc, dtm_NCC);
	}

	@Override
	public boolean timKiemTheo_tenNCC_sdtNCC_email(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheo_tenNCC_sdtNCC_email(ncc, dtm_NCC);
	}

	@Override
	public boolean timKiemTheo_tenNCC_sdtNCC_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheo_tenNCC_sdtNCC_diaChi(ncc, dtm_NCC);
	}

	@Override
	public boolean timKiemTheo_tenNCC_email_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheo_tenNCC_email_diaChi(ncc, dtm_NCC);
	}

	@Override
	public boolean timKiemTheo_sdtNCC_email_diaChi(NhaCungCap ncc, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.timKiemTheo_sdtNCC_email_diaChi(ncc, dtm_NCC);
	}

	@Override
	public String getMaNhaCungCap(String tenNCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.getMaNhaCungCap(tenNCC);
	}

	@Override
	public String getTenNhaCungCap(String maNCC) {
		// TODO Auto-generated method stub
		return dataBase_NhaCungCap_DAO.getTenNhaCungCap(maNCC);
	}
	


}
