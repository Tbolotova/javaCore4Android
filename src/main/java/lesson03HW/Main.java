package lesson03HW;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        guessNumberGame();
        guessWordGame();
    }

    //task 1
    public static void guessNumberGame() {
        boolean repeat = true;
        System.out.println("Начнем игру \"Угадай число\"!");
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        while (repeat) {
            int numberToGuess = random.nextInt(9);
            boolean win = false;
            for (int i = 0; i < 3; i++) {
                System.out.println("Ведите число от 0 до 9:");
                int guess = sc.nextInt();
                if (guess == numberToGuess) {
                    win = true;
                    break;
                } else {
                    String compare = guess < numberToGuess ? "меньше" : "больше";
                    System.out.printf("Вы не угадали. Введенное число %s загаданного.", compare);
                    System.out.println();
                }
            }
            String winLose = win == true? "Поздравляем, Вы выиграли!" : "К сожалению, Вы проиграли.";
            System.out.printf("%s Загаданное число - %d.", winLose, numberToGuess);
            System.out.println();
            System.out.println("Игра окончена. Повторить игру еще раз? 1 – да / 0 – нет");
            int repeatAnswer = sc.nextInt();
            repeat = repeatAnswer == 1;
        }
    }

    //task 2
    public static void guessWordGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot",
                "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea",
                "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int arrItem = random.nextInt(words.length - 1);
        String wordToGuess = words[arrItem];
        System.out.println("Начнем игру! Компьютер загадал слово из данного списка: " +
                Arrays.toString(words) + ". Пожалуйста, угадайте его. Введите слово.");
        boolean win = false;
        while (!win) {
            String guess = sc.nextLine();
            if (guess.equals(wordToGuess)) {
                win = true;
                System.out.println("Поздравляем, Вы выиграли! Загаданное слово - \"" + wordToGuess + "\"");
            } else {
                String prompt = revealLetters(guess, wordToGuess);
                System.out.println(prompt.equals("###############") ?
                        "Вы не угадали. Попробуйте ещё раз. Введите слово:" :
                        "Не совсем, но Вы угадали некоторые буквы: " + prompt + ". Попробуйте ещё раз. Введите слово:");
            }
        }
        sc.close();
    }

    //method that reveals the correct letters and returns the prompt
    public static String revealLetters(String guess, String wordToGuess) {
        char[] promptArr = new char[15];
        //Пользуюсь массивом char, потому что оказалось нельзя присвоить элементу строки значение.
        // Если на самом деле можно, буду рада увидеть, как. У меня не получилось. :(
        Arrays.fill(promptArr, '#');
        int minLen = Math.min(guess.length(), wordToGuess.length());
        //я специально проигнорировала подсказку, потому что мы об этом не говорили пока (а может, и не будем). Но понимаю, что так будет короче и красивее :)
        for (int i = 0; i < minLen; i++) {
            promptArr[i] = guess.charAt(i) == wordToGuess.charAt(i) ? guess.charAt(i) : '#';
        }
        return String.valueOf(promptArr);
    }
}