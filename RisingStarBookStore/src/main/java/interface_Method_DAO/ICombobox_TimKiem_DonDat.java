package interface_Method_DAO;

import customEntities.Custom_ComboBox;

public interface ICombobox_TimKiem_DonDat {
	/*
	 * cbo_HoTenKhachHang.setSelectedItem("Chọn");
    	cbo_MaDD.setSelectedItem("Chọn");
    	cbo_HoTenNhanVien.setSelectedItem("Chọn");
    	cbo_SoDienThoai.setSelectedItem("Chọn");
    	cbo_TongTien.setSelectedItem("Chọn");
	 */
	public boolean dayComboBox_MaDD(Custom_ComboBox cbo_MaDD);
	public boolean dayComboBox_HoTenKhachHang(Custom_ComboBox cbo_HoTenKhachHang);
	public boolean dayComboBox_SoDienThoai(Custom_ComboBox cbo_SoDienThoai);
	public boolean dayComboBox_HoTenNhanVien(Custom_ComboBox cbo_HoTenNhanVien);
	public boolean dayComboBox_TongTien(Custom_ComboBox cbo_TongTien);
}
