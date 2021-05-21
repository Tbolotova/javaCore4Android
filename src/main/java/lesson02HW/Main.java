package lesson02HW;

import java.util.Arrays;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //task 1
        invertOneZero();
        System.out.println(); //добавила эту строчку после всех методов, чтобы улучшить читабельность вывода
        //task 2
        arrByThree();
        System.out.println();
        //task 3
        multiplyByTwo();
        System.out.println();
        //task 4
        diagonalOnes();
        System.out.println();
        //task 5
        minMax(8);
        System.out.println();
        //task 6
        checkBalance();
        System.out.println();
        //task 7
        moveArray(3);
        moveArray(12);
        moveArray(-1);
        moveArray(-12);
        moveArray(0);
    }

    //task 1
    public static void invertOneZero(){
        int[] oneZeroArr = {1, 0, 1, 1, 0, 1, 0, 0};
        for (int i = 0; i < oneZeroArr.length; i++) {
            if(oneZeroArr[i] == 1){
                oneZeroArr[i] = 0;
            } else {
                oneZeroArr[i] = 1;
            }
        }
        System.out.println(Arrays.toString(oneZeroArr));
    }

    //task 2
    public static void arrByThree(){
        int[] arrFactorThree = new int [8];
        for (int i = 0; i < arrFactorThree.length; i++) {
            arrFactorThree[i] = i * 3;
        }
        System.out.println(Arrays.toString(arrFactorThree));
    }

    //task 3
    public static void multiplyByTwo(){
        int[] arrMultiplyByTwo = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < arrMultiplyByTwo.length; i++) {
            if (arrMultiplyByTwo[i] < 6){
                arrMultiplyByTwo[i] = arrMultiplyByTwo[i] * 2;
            }
        }
        System.out.println(Arrays.toString(arrMultiplyByTwo));
    }

    //task 4
    public static void diagonalOnes(){
        int[][] arrDiagonalOnes = new int[5][5];
        for (int i = 0; i < arrDiagonalOnes.length; i++) {
            for (int j = 0; j < arrDiagonalOnes[i].length; j++) {
                if (i == j || j == arrDiagonalOnes[i].length - i - 1){
                    arrDiagonalOnes[i][j] = 1;
                }
            }
            System.out.println(Arrays.toString(arrDiagonalOnes[i]));
        }
    }

    //task 5
    public static void  minMax(int arrSize){
        int[] arrMinMax = new int[arrSize];
        Random random = new Random();
        //fill array
        for (int i = 0; i < arrMinMax.length; i++) {
            arrMinMax[i] = random.nextInt(100);
        }
        System.out.println(Arrays.toString(arrMinMax));
        //find min and max
        int min = arrMinMax[0];
        int max = arrMinMax[0];
        for (int i = 1; i < arrMinMax.length; i++) {
            if (arrMinMax[i] < min){
                min = arrMinMax[i];
            } else {
                max = arrMinMax[i];
            }
        }
        System.out.println("min = " + min);
        System.out.println("max = " + max);
    }

    //task 6
    public static void checkBalance(){
        int[] arrBalance = {2, 2, 2, 1, 2, 2, 10, 1};
        //calculate sum
        int sumAll = 0;
        for (int i = 0; i < arrBalance.length; i++) {
            sumAll += arrBalance[i];
        }
        //check balance
        int sumLeft = 0;
        int sumRight;
        boolean isBalance = false;
        for (int i = 0; i < arrBalance.length; i++) {
            sumLeft += arrBalance[i];
            sumRight = sumAll - sumLeft;
            if (sumLeft == sumRight){
                isBalance = true;
                break;
            }
        }
        System.out.println(isBalance);
    }

    //task 7 - без вспомогательных массивов :)
    public static void moveArray(int n){
        int[] arrMoveArr = {1, 2, 3, 4, 5};
        n = n % arrMoveArr.length;
        int tempIndex;
        if (n >= 0) {
            int temp = arrMoveArr[arrMoveArr.length - 1];
            int tempTemp;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < arrMoveArr.length; j++) {
                    tempTemp = arrMoveArr[j];
                    arrMoveArr[j] = temp;
                    temp = tempTemp;
                }
                temp = arrMoveArr[arrMoveArr.length - 1];
            }
        } else {
            int temp = arrMoveArr[0];
            int tempTemp;
            n = Math.abs(n);
            for (int i = 0; i < n; i++) {
                for (int j = arrMoveArr.length - 1; j >= 0; j--) {
                    tempTemp = arrMoveArr[j];
                    arrMoveArr[j] = temp;
                    temp = tempTemp;
                }
                temp = arrMoveArr[0];
            }
        }
        System.out.println(Arrays.toString(arrMoveArr));
    }
}