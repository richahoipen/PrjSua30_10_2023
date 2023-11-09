package test_Others;

import java.sql.Date;
import java.time.LocalDate;

public class CheckDate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate localDate = LocalDate.of(2023, 11, 8);

        // Chuyển LocalDate thành java.sql.Date
        Date sqlDate = Date.valueOf(localDate);

        System.out.println("LocalDate: " + localDate);
        System.out.println("java.sql.Date: " + sqlDate);
	}

}
