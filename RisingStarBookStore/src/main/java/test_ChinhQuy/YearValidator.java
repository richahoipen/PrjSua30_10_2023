package test_ChinhQuy;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
public class YearValidator {

	public static void main(String[] args) {
        String yearString = "2100";
        
        if (isYear(yearString)) {
            System.out.println("Chuỗi đại diện cho một năm.");
        } else {
            System.out.println("Chuỗi không đại diện cho một năm.");
        }
    }
    
    public static boolean isYear(String str) {
        // Sử dụng biểu thức chính quy để kiểm tra chuỗi
        // ^: Bắt đầu chuỗi
        // (19|20)\\d\\d: Một năm bắt đầu bằng 19 hoặc 20 và sau đó hai chữ số
        // $: Kết thúc chuỗi
        String regex = "^(19|20)\\d\\d$";
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        
        return matcher.matches();
    }
}






