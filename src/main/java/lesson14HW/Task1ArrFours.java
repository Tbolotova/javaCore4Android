package lesson14HW;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Task1ArrFours {
    public static void main(String[] args) {
        int[] initialArr = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        System.out.println(extractAfterLastFour(initialArr));
    }

    public static ArrayList<Integer> extractAfterLastFour(int[] initialSimpleArr) {
        ArrayList<Integer> initialArr = convertToArrList(initialSimpleArr);
        return extractAfterLastFour(initialArr);
    }

    public static ArrayList<Integer> convertToArrList (int[] initialArr) {
        return (ArrayList<Integer>) IntStream.of(initialArr).boxed().collect(Collectors.toList());
    }

    public static ArrayList<Integer> extractAfterLastFour(ArrayList<Integer> initialArr) throws RuntimeException {
        ArrayList<Integer> returnArr = new ArrayList<>();
        boolean addToArr = false;

        for (Integer i:initialArr) {
            if (i == 4) {
                addToArr = true;
                returnArr.clear();
            } else if (addToArr) {
                returnArr.add(i);
            }
        }

        if (returnArr.size() != 0) {
            return returnArr;
        } else {
            throw new RuntimeException("No fours in the Array");
        }

    }
}
