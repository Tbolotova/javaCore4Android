package lesson07HW;

import java.util.Scanner;

public class Main {

    public static Cat[] catArr = new Cat[10];
    public static Scanner sc = new Scanner(System.in);
    public static int amountToAdd = -1;

    public static void main(String[] args) {
        createCats();
        Plate plate = new Plate(100);
        feedCats(plate);
        catState();
        sc.close();
    }

    public static void createCats() {
        for (int i = 0; i < catArr.length; i++) {
            catArr[i] = new Cat("Cat" + (i + 1) , 3 * (i + 1));
        }
    }

    public static void feedCats(Plate plate) {
        for (Cat cat : catArr) {
            if (!cat.isFull()) {
                cat.eat(plate);
            }
            while (!cat.isFull()) {
                System.out.printf("Коту %s не хватает еды. В тарелке осалось %d еды, а коту нужно %d.\n", cat.getName(), plate.getFood(), cat.getAppetite());
                addFood(plate);
                cat.eat(plate);
            }
        }
    }

    public static void catState() {
        for (Cat cat : catArr) {
            String catState = cat.isFull() ? "сыт" : "голоден";
            System.out.printf("Кот %s %s.\n", cat.getName(), catState);
        }
    }

    public static void addFood(Plate plate) {
        do {
            System.out.println("Введите количество еды, которое хотите добавить в тарелку. Введите 0, если не хотите больше кормить котов.");
            amountToAdd = sc.nextInt();
            if (amountToAdd < 0) {
                System.err.println("Некорректное количество.");
            }
        } while (amountToAdd < 0);

        if (amountToAdd == 0) {
            System.out.println("Кормление завершено.");
            System.exit(0);
        } else {
            plate.addFood(amountToAdd);
        }
    }
}
