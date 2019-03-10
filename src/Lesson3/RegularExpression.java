package Lesson3;
/*
1 Обязательно есть хоть 1 цифра
2 Не менее 8 символов и не более 20
3 Должны быть большие и маленькие буквы
4 Обязательно дожен быть спец символ
 */
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String userPassword = scanner.nextLine();
        System.out.println(checkPassword(userPassword));
    }

    static boolean checkPassword(String userPassword){
        Pattern p = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{8,20})");
        Matcher m = p.matcher(userPassword);
        return m.matches();
    }
}
