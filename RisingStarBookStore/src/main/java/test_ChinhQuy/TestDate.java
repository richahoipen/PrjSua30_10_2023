package test_ChinhQuy;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class TestDate {

	/*
	 * public LocalDate getNgaySinhLocalDate()
	{
		return ngaySinh.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}
	 */
	public static void main(String[] args) {
		Date ngayNay=new Date();
		LocalDate ngayNayLDate=ngayNay.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		System.out.println(ngayNayLDate);

	}

}
