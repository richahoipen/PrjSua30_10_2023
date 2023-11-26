package test_Others;

import java.sql.Time;
import java.util.Date;

public class Demo_Time {
    public static void main(String[] args) {
        // Lấy giờ hiện tại sử dụng java.util.Date
        Date currentDate = new Date();
        Time currentTime = new Time(currentDate.getTime());

        System.out.println("Current Time: " + currentTime);
    }
}
