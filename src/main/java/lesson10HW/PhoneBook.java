package lesson10HW;

import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {
    private static HashMap<String, HashSet<String>> phoneBook = new HashMap<>();

    public void add(String lastName, String phoneNumber) {
        HashSet<String> personsPhones = new HashSet<>();
        if (phoneBook.containsKey(lastName)) {
            personsPhones = phoneBook.get(lastName);
            personsPhones.add(phoneNumber);
        } else {
            personsPhones.add(phoneNumber);
            phoneBook.put(lastName, personsPhones);
        }
    }

    public void get(String lastName) {
        System.out.println(lastName + ": " + phoneBook.get(lastName));
    }
}
