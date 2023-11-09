package test_Others;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomString {

	public static void main(String[] args) {
		// Tạo một mảng chuỗi bất kì
        List<String> stringArray = new ArrayList<>();
        stringArray.add("Chuỗi 1");
        stringArray.add("Chuỗi 2");
        stringArray.add("Chuỗi 3");
        stringArray.add("Chuỗi 4");
        stringArray.add("Chuỗi 5");

        // Sử dụng lớp Random để chọn hai chuỗi ngẫu nhiên từ mảng
        Random random = new Random();
        int arraySize = stringArray.size();

        if (arraySize >= 2) {
            int index1 = random.nextInt(arraySize);
            int index2;
            do {
                index2 = random.nextInt(arraySize);
            } while (index2 == index1);

            String selectedString1 = stringArray.get(index1);
            String selectedString2 = stringArray.get(index2);

            System.out.println(selectedString1+" "+selectedString2);
            
        } else {
            System.out.println("Mảng không đủ lớn để lấy 2 chuỗi.");
        }

	}

}
