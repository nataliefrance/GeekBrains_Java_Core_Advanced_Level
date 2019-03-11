package Lesson3;

// Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров.
// В этот телефонный справочник с помощью метода add() можно добавлять записи.
// С помощью метода get() искать номер телефона по фамилии.
// Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
// тогда при запросе такой фамилии должны выводиться все телефоны.

import java.util.*;

public class TelephoneBook {
    //Реализация ДЗ с HashSet
    private HashMap<String, HashSet> phoneMap;

    public TelephoneBook() {
        this.phoneMap = new HashMap<>();
    }

    public static void main(String[] args) {
        TelephoneBook book = new TelephoneBook();
        book.add("Simpson", "89117894545");
        book.add("Simpson", "89117896565");
        book.add("Parker", "89254561313");
        book.add("Stark", "89114544411");
        book.add("Stark", "89255556545");
        book.add("Stark", "89256332337");
        book.add("Pines", "89255551525");

        book.get("Parker");
        book.get("Stark");
    }

    private void add(String name, String phoneNumber){
        HashSet<String> hashSet = phoneMap.getOrDefault(name, new HashSet());
        hashSet.add(phoneNumber);
        phoneMap.put(name, hashSet);
    }

    private void get(String name){
        if (phoneMap.containsKey(name)){
            System.out.println("Фамилия: " + name + ". Телефонный(е) номер(а): " + phoneMap.get(name));
        } else {
            System.out.println("Такой фамилии нет.");
        }
    }


    //Реализация ДЗ с ArrayList
    /*private HashMap<String, ArrayList<String>> phoneMap = new HashMap<>();

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
    }*/

}
