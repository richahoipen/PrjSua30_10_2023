package test_ChinhQuy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberDemicalValidator {

	public static boolean validateName(String name) {
		String pattern = "^\\d+(\\.\\d+)?$";


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

            boolean isValid = validateName(input);
            if (isValid) {
                System.out.println("Hợp lệ!");
            } else {
                System.out.println("Không hợp lệ. Vui lòng thử lại.");
            }
        }

        System.out.println("Kết thúc chương trình.");

	}

}
