package lesson04HW;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int SIZE = 5;
    private static final int DOTS_TO_WIN = 4;
    private static final char DOT_EMPTY = '-';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static final char[][] map = new char[SIZE][SIZE];
    private static final Scanner sc = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if(isWin(DOT_X)) {
                System.out.println("Вы выиграли! Ура!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if(isWin(DOT_O)) {
                System.out.println("Выиграл искуственный интеллект, увы!");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра окончена");
    }

    private static void initMap() {
        for (int i = 0; i < SIZE; i++) {
            Arrays.fill(map[i], DOT_EMPTY);
        }
    }

    private static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.println("Введите координату по горизонтали:");
            x = sc.nextInt() - 1;
            System.out.println("Введите координату по вертикали:");
            y = sc.nextInt() - 1;
        } while (isCellInvalid(x, y));
        map[y][x] = DOT_X;
    }

    private static boolean isCellInvalid(int x, int y) {
        return (x >= SIZE || y >= SIZE)
                || (x < 0 || y < 0)
                || map[y][x] != DOT_EMPTY;
    }

    private static boolean isWin(char symb) {
        if (checkHorizontal(symb)) {
            return true;
        } else if (checkVertical(symb)) {
            return true;
        } else return checkDiagonals(symb);
    }

    //check for horizontal winning lines.
    private static boolean checkHorizontal(char symb) {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - DOTS_TO_WIN + 1; j++) {
                if (map[i][j] == symb) {
                    for (int k = 1; k < DOTS_TO_WIN; k++) {
                        if (map[i][j + k] != symb) {
                            break;
                        } else if (k == DOTS_TO_WIN - 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkVertical(char symb) {
        for (int i = 0; i < SIZE - DOTS_TO_WIN + 1; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    for (int k = 1; k < DOTS_TO_WIN; k++) {
                        if (map[i + k][j] != symb) {
                            break;
                        } else if (k == DOTS_TO_WIN - 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean checkDiagonals(char symb) {
        //from left up to right down
        for (int i = 0; i < SIZE - DOTS_TO_WIN + 1; i++) {
            for (int j = 0; j < SIZE - DOTS_TO_WIN + 1; j++) {
                if (map[i][j] == symb) {
                    for (int k = 1; k < DOTS_TO_WIN; k++) {
                        if (map[i + k][j + k] != symb) {
                            break;
                        } else if (k == DOTS_TO_WIN - 1) {
                            return true;
                        }
                    }
                }
            }
        }
        //from left down to right up
        for (int i = SIZE - 1; i >= DOTS_TO_WIN - 1; i--) {
            for (int j = 0; j < SIZE - DOTS_TO_WIN + 1; j++) {
                if (map[i][j] == symb) {
                    for (int k = 1; k < DOTS_TO_WIN; k++) {
                        if (map[i - k][j + k] != symb) {
                            break;
                        } else if (k == DOTS_TO_WIN - 1) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    private static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = random.nextInt(SIZE);
            y = random.nextInt(SIZE);
        } while (isCellInvalid(x, y));
        System.out.printf("Компьютер сделал ход в точку %d %d\n", x + 1, y + 1);
        map[y][x] = DOT_O;
    }

}
