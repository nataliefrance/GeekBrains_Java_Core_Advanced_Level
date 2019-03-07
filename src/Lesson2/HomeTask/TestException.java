package Lesson2.HomeTask;

public class TestException {
    public static void main(String[] args) {

        String[][] correctArray = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
        };

        String[][] smallArray = {
                {"1", "2", "3", "4"},
                {"1", "2", "3"},
                {"1", "2", "3", "4"},
        };

        String[][] arrayWithLetters = {
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "a", "3", "4"},
                {"1", "2", "3", "4"},
        };

        TestException test = new TestException();

        try {
            test.doIt(correctArray);
            test.doIt(smallArray);
            test.doIt(arrayWithLetters);
        } catch (MySizeArrayException | MyArrayDataException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    void doIt(String[][] array) throws MySizeArrayException, MyArrayDataException {
        int correctSize = 4;
        for (int i = 0; i < array.length; i++) {
            if (array.length != correctSize || array[i].length != correctSize) {
                throw new MySizeArrayException("Неверная длина массива.");
            }
        }

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (isNumber(array[i][j])) {
                    int a = Integer.parseInt(array[i][j]);
                    sum += a;
                } else throw new MyArrayDataException("Элемент массива " + "[" + i + "] [" + j + "] не является числом.");
            }
        }
        System.out.println("Сумма элементов массива равна " + sum + ".");
    }

    boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public class MySizeArrayException extends Exception {
        MySizeArrayException(String message) {
            super(message);
        }
    }

    public class MyArrayDataException extends Exception {
        MyArrayDataException(String message) {
            super(message);
        }
    }


}
