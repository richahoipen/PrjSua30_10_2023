package interface_Method_DAO;

import javax.swing.table.DefaultTableModel;

import entities.SanPham;

public interface SanPham_Method 
{
	public boolean themSanPham(SanPham s,DefaultTableModel dtm_SP);
	public boolean capNhatSanPham(SanPham s,DefaultTableModel dtm_SP);
	public boolean xuatDanhSachSanPham(DefaultTableModel dtm_SP);
	public byte[] getBytesAnh(String maSP);
	//Đẩy combobox
	
}
