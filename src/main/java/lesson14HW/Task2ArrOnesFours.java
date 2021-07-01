package lesson14HW;

public class Task2ArrOnesFours {
    public static void main(String[] args) {
        int[] intArr = {3, 1, 1, 4};
        System.out.println(checkArrOneFour(intArr));
    }

    public static boolean checkArrOneFour(int[] intArr){
        boolean isOne = false, isFour = false;
        for (int i: intArr) {
            if (i == 1) {
                isOne = true;
            } else if (i == 4) {
                isFour = true;
            } else {
                return false;
            }
        }
        return isOne && isFour;
    }
}
