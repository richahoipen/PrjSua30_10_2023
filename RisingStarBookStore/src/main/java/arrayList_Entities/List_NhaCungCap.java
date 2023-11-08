package arrayList_Entities;

import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


import entities.NhaCungCap;
import interface_Method_ArrayList.Method_ArrayList_NhaCungCap;

public class List_NhaCungCap implements Method_ArrayList_NhaCungCap
{
	private ArrayList<NhaCungCap> listNhaCungCap;

	public ArrayList<NhaCungCap> getListNhaCungCap() {
		return listNhaCungCap;
	}

	public void setListNhaCungCap(ArrayList<NhaCungCap> listNhaCungCap) {
		this.listNhaCungCap = listNhaCungCap;
	}

	public List_NhaCungCap() {
		super();
		// TODO Auto-generated constructor stub
		setListNhaCungCap(new ArrayList<NhaCungCap>());
	}
	public boolean themNhaCungCap(NhaCungCap n)
	{
		if(!listNhaCungCap.contains(n))
		{
			listNhaCungCap.add(n);
			return true;
		}
		return false;
	}
	public NhaCungCap timKiemNhaCungCap(String maNCC)
	{
		for(NhaCungCap n: listNhaCungCap)
		{
			if(n.getMaNCC().equalsIgnoreCase(maNCC))
			{
				return n;
			}
		}
		return null;
	}
	public boolean xoaNhaCungCap(String maNCC)
	{
		NhaCungCap n=timKiemNhaCungCap(maNCC);
		if(n!=null)
		{
			listNhaCungCap.remove(n);
			return true;
		}
		return false;
	}

	@Override
	public void xuatBangTheo_DiaChi(String diaChi, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		for(NhaCungCap n: listNhaCungCap)
		{
			if(n.getDiaChi().equalsIgnoreCase(diaChi))
			{
				String[] row = {n.getMaNCC(),n.getTenNCC(),n.getSdtNCC(),n.getEmail(),n.getDiaChi() };
				dtm_NCC.addRow(row);
			}
		}
	}

	@Override
	public void xuatBangTheo_Ten(String tenNCC, DefaultTableModel dtm_NCC) {
		// TODO Auto-generated method stub
		for(NhaCungCap n: listNhaCungCap)
		{
			if(n.getTenNCC().equalsIgnoreCase(tenNCC))
			{
				String[] row = {n.getMaNCC(),n.getTenNCC(),n.getSdtNCC(),n.getEmail(),n.getDiaChi() };
				dtm_NCC.addRow(row);
			}
		}
	}

	
	
}
