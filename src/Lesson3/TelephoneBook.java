package Lesson3;

// Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи.
// С помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TelephoneBook {
    private HashMap<String, ArrayList<String>> phoneMap = new HashMap<>();

    public static void main(String[] args) {
        TelephoneBook book = new TelephoneBook();
        book.add("Simpson", "89117894545", "89117896565");
        book.add("Parker", "89254561313", "89651231112", "89087771122");
        book.add("Stark", "89114544411");
        book.add("Pines", "89255551525", "89255556545", "89256332337");

        book.get("Parker");
        book.get("stark");
    }

    private void add(String surname, String... phoneNumbers){
        ArrayList<String> listOfNumbers = new ArrayList<>(Arrays.asList(phoneNumbers));
        phoneMap.put(surname, listOfNumbers);
    }

    private void get(String surname){
        for (Map.Entry<String, ArrayList<String>> map : phoneMap.entrySet()) {
            if(map.getKey().equalsIgnoreCase(surname)) {
                System.out.println("Фамилия: " + map.getKey() + ". Телефонный(е) номер(а): " + map.getValue());
            }
        }
    }

}
