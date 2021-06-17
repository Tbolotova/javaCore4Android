package lesson10HW;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static String[] initialWordsArr = {"apple", "apricot", "banana", "blueberry", "blueberry", "grape", "grapefruit", "lemon", "orange", "mango", "melon", "pear", "pineapple", "raspberry", "strawberry", "watermelon", "orange", "apple"};
    public static PhoneBook phoneBook = new PhoneBook();

    public static void main(String[] args) {
        //task 1: Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
        // Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
        selectUniqueWords(initialWordsArr);

        //task 2: Посчитать, сколько раз встречается каждое слово
        countNumberOfMentions("apple", initialWordsArr);

        //task 3 (class PhoneBook):
        /* Написать простой класс Телефонный Справочник, который хранит в себе список фамилий
        и телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи,
        а с помощью метода get() искать номер телефона по фамилии. Следует учесть, что под одной фамилией
        может быть несколько телефонов (несколько номеров у одного человека), тогда при запросе такой фамилии
        должны выводиться все телефоны. Нет смысла хранить для одного человека несколько одинаковых номеров. */

        //добавляем номера для двух людей (для одного добавляем три номера, причем два из них - одинаковые)
        phoneBook.add("Ivanov", "+79159191919");
        phoneBook.add("Ivanov", "+74951919191");
        phoneBook.add("Ivanov", "+74951919191");
        phoneBook.add("Petrov", "+79100494949");
        //выводим номера
        phoneBook.get("Petrov");
        phoneBook.get("Ivanov");
    }

    public static void selectUniqueWords (String[] initialWordsArr) {
        HashSet<String> fruitSet = new HashSet<>();
        Collections.addAll(fruitSet, initialWordsArr);
        System.out.println(fruitSet);

        // Эта строчка просто чтобы была очевидна разница между изначальным массивом и обработанным
        System.out.println("Удалены дубликаты: " + (initialWordsArr.length - fruitSet.size()));
    }

    public static void countNumberOfMentions(String wordToCount, String [] initialWordsArr) {
        HashMap<String, Integer> fruitMap = new HashMap<>();
        for (String s : initialWordsArr) {
            if (fruitMap.containsKey(s)) {
                fruitMap.put(s, fruitMap.get(s) + 1);
            } else {
                fruitMap.put(s, 1);
            }
        }
        System.out.printf("Слово %s встречается %d раз(а).\n", wordToCount, fruitMap.get(wordToCount));
    }
}
