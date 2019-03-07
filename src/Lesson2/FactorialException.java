package Lesson2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FactorialException extends Exception {
    private int num;

    public int getNum() {
        return num;
    }

    public FactorialException(String msg, int num) {
        super(msg);
        this.num = num;
    }
}

class Factorial {
    public static int getFactorial(int num) throws FactorialException {
        int res = 1;
        if(num < 1) throw new FactorialException("Число не может быть меньше 1", num);
        for (int i = 0; i <=num ; i++) {
            res *= i;
        }
        return res;
    }
}

class MainExc {
    public static void main(String[] args) throws IOException {
        try {
            int res = Factorial.getFactorial(-10);
        } catch (FactorialException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


        try {
            FileInputStream fileInputStream = new FileInputStream("1.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try (FileInputStream fileInputStream = new FileInputStream("1.txt")) {

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
