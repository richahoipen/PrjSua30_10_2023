package arrayList_Entities;

import java.util.ArrayList;

import entities.NhanVien;
import interface_Method_ArrayList.Method_ArrayList_NhanVien;

public class List_NhanVien implements Method_ArrayList_NhanVien
{
	private ArrayList<NhanVien> listNhanVien;
	
	public List_NhanVien() {
		super();
		// TODO Auto-generated constructor stub
		setListNhanVien(new ArrayList<NhanVien>());
	}

	@Override
	public boolean themNV(NhanVien n) {
		if(!listNhanVien.contains(n))
		{
			listNhanVien.add(n);
			return true;
		}
		return false;
	}

	@Override
	public NhanVien timKiemNhanVien(String maNV) {
		for(NhanVien n: listNhanVien)
		{
			if(n.getMaNV().equalsIgnoreCase(maNV))
				return n;
		}
		return null;
	}

	@Override
	public boolean xoaNV(String maNV) {
		NhanVien n= timKiemNhanVien(maNV);
		if(n!=null)
		{
			listNhanVien.remove(n);
			return false;
		}
		return false;
	}

	public ArrayList<NhanVien> getListNhanVien() {
		return listNhanVien;
	}

	public void setListNhanVien(ArrayList<NhanVien> listNhanVien) {
		this.listNhanVien = listNhanVien;
	}

}
