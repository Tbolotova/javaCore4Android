package lesson11HW;

import lesson11HW.Fruits.Apple;
import lesson11HW.Fruits.Orange;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static String[] stringArr = {"apple", "apricot", "banana", "blueberry", "grape"};

    public static void main(String[] args) {
        //task 1: Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
        switchPlaces("apple", "blueberry", stringArr);

        //task 2: Написать метод, который преобразует массив в ArrayList
        ArrayList<String> stringArrList;
        stringArrList = toArrayList(stringArr);
        System.out.println("После преобразования в Arraylist: " + stringArrList);

        //task 3. Фрукты и коробки
        //вынесла всё в отдельный метод, чтобы не усложнять main
        fruitsAndBoxes();

    }

    public static void switchPlaces(String firstElement, String secondElement, String[] stringArr) {
        // это можно сделать циклом, но так короче и понятнее
        int firstElementPosition = Arrays.asList(stringArr).indexOf(firstElement);
        int secondElementPosition = Arrays.asList(stringArr).indexOf(secondElement);

        stringArr[firstElementPosition] = secondElement;
        stringArr[secondElementPosition] = firstElement;

        //вывести в консоль
        System.out.println("Итоговый массив после перемены мест: ");
        for (String s : stringArr) {
            if (!s.equals(stringArr[stringArr.length - 1])) {
                System.out.print(s + ", ");
            } else {
                System.out.println(s);
            }
        }
    }

    public static ArrayList<String> toArrayList(String[] stringArr) {
        ArrayList<String> stringArrayList = new ArrayList<>();
        Collections.addAll(stringArrayList, stringArr);
        return stringArrayList;
    }

    public static void fruitsAndBoxes(){

        //создаем яблоки, апельсины и коробки для них
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();
        Apple apple4 = new Apple();
        Box<Apple> appleBox1 = new Box<>();
        Box<Apple> appleBox2 = new Box<>();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();
        Orange orange3 = new Orange();
        Box<Orange> orangeBox1 = new Box<>();
        Box<Orange> orangeBox2 = new Box<>();

        //наполним коробки
        appleBox1.addFruit(apple1);
        appleBox1.addFruit(apple2);
        appleBox1.addFruit(apple3);
        appleBox2.addFruit(apple4);
        orangeBox1.addFruit(orange1);
        orangeBox1.addFruit(orange2);
        orangeBox2.addFruit(orange3);

        //сравним вес коробок
        System.out.println("appleBox1 == appleBox2: " + appleBox1.compare(appleBox2));
        System.out.println("appleBox1 == orangeBox1: " + appleBox1.compare(orangeBox1));

        //пересыпем яблоки из первой коробки во вторую
        System.out.println("В первой коробке " + appleBox1.getWeight() + " apples");
        System.out.println("Во второй коробке " + appleBox2.getWeight() + " apples");

        appleBox1.transfer(appleBox2);
        System.out.println("Переложили из первой коробки во вторую, во второй коробке "
                + appleBox2.getWeight() + " apples, в первой коробке " + appleBox1.getWeight());

        //appleBox2.transfer(orangeBox1); //нельзя положить яблоки в коробку с апельсинами
    }

}
