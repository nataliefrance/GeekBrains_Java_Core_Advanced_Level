package Lesson3;
// Создать массив с набором слов (10-20 слов, среди которых должны встречаться повторяющиеся).
// Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
// Посчитать, сколько раз встречается каждое слово.

import java.util.HashMap;
import java.util.Map;

public class WordsArray {
    public static void main(String[] args) {

        String[] array = new String[20];

        for (int i = 0; i < array.length; i++) {
            array[i] = "Слово" + i;
        }

        array[5] = "Слово2";
        array[6] = "Слово3";
        array[7] = "Слово3";
        array[8] = "Слово4";
        array[9] = "Слово4";
        array[10] = "Слово4";

        HashMap<String, Integer> map = countWords(array);

        for (Map.Entry<String, Integer> s : map.entrySet()) {
            System.out.println(s.getKey() + " встречается в списке " + s.getValue() + " раз(а)");
        }

    }

    private static HashMap<String, Integer> countWords(String[] array) {
        HashMap<String, Integer> result = new HashMap<>();

        for (String word : array) {
            int count = 0;
            for (String s : array) {
                if (s.equals(word)) {
                    count++;
                }
            }
            result.put(word, count);
        }
        return result;
    }
}
