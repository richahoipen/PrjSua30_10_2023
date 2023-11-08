package test_ChinhQuy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IDNumberValidator {

	public static boolean validateIDNumber(String name) {
		String pattern = "\\d{12}";


		Pattern regex = Pattern.compile(pattern);
		Matcher matcher = regex.matcher(name);

		return matcher.matches();

	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Nhập (hoặc gõ 'exit' để thoát): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            boolean isValid = validateIDNumber(input);
            if (isValid) {
                System.out.println("Hợp lệ!");
            } else {
                System.out.println("Không hợp lệ. Vui lòng thử lại.");
            }
        }

        System.out.println("Kết thúc chương trình.");

	}

}
