package interface_Method_DAO;


import javax.swing.table.DefaultTableModel;


import entities.CTDonDatHang;


public interface CTHoaDon_Method {
	public boolean them_CTHoaDon_TheoMaHD(CTDonDatHang cTDonDatHang,String maHD);
	public boolean xuat_CTHoaDon_TheoMa(String maHD,DefaultTableModel dtm_CTHD);
}
