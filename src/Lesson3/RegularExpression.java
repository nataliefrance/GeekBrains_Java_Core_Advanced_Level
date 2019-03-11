package Lesson3;
/*
1 Обязательно есть хоть 1 цифра
2 Не менее 8 символов и не более 20
3 Должны быть большие и маленькие буквы
4 Обязательно дожен быть спец символ
 */

import javafx.css.Match;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegularExpression {
    public static void main(String[] args) {
        System.out.println("Введите пароль:");
        Scanner scanner = new Scanner(System.in);
        String userPassword = scanner.nextLine();
        try {
            checkPassword(userPassword);
        } catch (WrongPasswordException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    //Проверка пароля разбита на несколько выражений
    static void checkPassword(String userPassword) throws WrongPasswordException {
        Pattern p = Pattern.compile("^.{8,20}$");
        Matcher m = p.matcher(userPassword);
        if (m.matches()) {
            Pattern p1 = Pattern.compile("^.*\\d+.*$");
            Matcher m1 = p1.matcher(userPassword);
            if (m1.matches()) {
                Pattern p2 = Pattern.compile("^.*[a-z]+.*$");
                Matcher m2 = p2.matcher(userPassword);
                if (m2.matches()) {
                    Pattern p3 = Pattern.compile("^.*[A-Z]+.*$");
                    Matcher m3 = p3.matcher(userPassword);
                    if (m3.matches()) {
                        Pattern p4 = Pattern.compile("^.*[@#$%!]+.*$");
                        Matcher m4 = p4.matcher((userPassword));
                        if (m4.matches()) {
                            System.out.println("Пароль успешно прошёл валидацию.");
                        } else throw new WrongPasswordException("Пароль должен содержать хотя бы один специальный символ");
                    } else throw new WrongPasswordException("Пароль должен содержать хотя бы одну заглавную букву");
                } else throw new WrongPasswordException("Пароль должен содержать хотя бы одну строчную букву");
            } else throw new WrongPasswordException("Пароль должен содержать хотя бы одну цифру");
        } else throw new WrongPasswordException("Пароль слишком короткий");
    }

    //Всё выражение в одну строку
//    public static void checkPassword(String userPassword) throws WrongPasswordException {
//        Pattern p = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{8,20})");
//        Matcher m = p.matcher(userPassword);
//        if (m.matches()) {
//            System.out.println("Пароль прошёл валидацию.");
//        } else throw new WrongPasswordException("Пароль не прошёл валидацию.");
//    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException(String message) {
        super(message);
    }
}
