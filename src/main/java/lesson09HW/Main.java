package lesson09HW;

import lesson09HW.Exceptions.MyArrayDataException;
import lesson09HW.Exceptions.MyArraySizeException;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static String[][] correctSizeCastableToInt = new String[4][4];
    public static String[][] correctSizeNotCastableToInt = new String[4][4];
    public static String[][] incorrectSize = new String[3][3];
    public static Random random = new Random();

    public static void main(String[] args) {

        //fill arrays
        fillArrWithNumberStrings(correctSizeCastableToInt);
        fillArrWithNumberStrings(correctSizeNotCastableToInt);
        correctSizeNotCastableToInt[2][3] = "someString";
        fillArrWithNumberStrings(incorrectSize);

        //creating array to use a loop for the actual calculation and exception handling
        Object[] stringArr = new Object[3];
        stringArr[0] = correctSizeCastableToInt;
        stringArr[1] = correctSizeNotCastableToInt;
        stringArr[2] = incorrectSize;


        for (Object object:stringArr) {
            try {
                System.out.println("Пытаемся просуммировать элементы массива " + (Arrays.asList(stringArr).indexOf(object) + 1));
                stringArrSum((String[][]) object);
            } catch (MyArraySizeException | MyArrayDataException e) {
                System.out.println(e);
                e.printStackTrace();
            } finally {
                System.out.println("Расчет окончен.");
            }
        }

    }

    public static void stringArrSum(String[][] arrToSum) throws MyArraySizeException, MyArrayDataException {
        //check the arr size and throw IncorrectArrSizeException if the size is incorrect
        if (arrToSum.length != 4 || arrToSum[0].length != 4) {
            throw new MyArraySizeException("Incorrect array size.");
        }

        //check data types of each array element
        for (int i = 0; i < arrToSum.length; i++) {
            for (int j = 0; j < arrToSum[i].length; j++) {
                for (int k = 0; k < arrToSum[i][j].length(); k++) {
                    if (!Character.isDigit(arrToSum[i][j].charAt(k))) {
                        throw new MyArrayDataException("Incorrect data type at position [" + i + ", " + j + "]");
                    }
                }
            }
        }

        //calculate the sum of array elements
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                int toAdd = Integer.parseInt(arrToSum[i][j]);
                sum = sum + toAdd;
            }
        }
        System.out.println("Сумма элементов массива равна " + sum);
    }

    //fill array with numbers cast to String type
    public static void fillArrWithNumberStrings (String[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int temp = random.nextInt(20);
                arr[i][j] = Integer.toString(temp);
            }
        }
    }
}
