package lesson12HW;

import lesson12HW.Threads.myThread;

import java.util.Arrays;

public class Main {
    static final int size = 10000000;
    static final int half = size / 2;
    static float[] arr = new float[size];

    public static void main(String[] args) {
        arrayManipulationsOneThread();
        arrayManipulationsTwoThreads();
    }

    //one thread
    public static void arrayManipulationsOneThread() {
        //fill array with 1s
        for (int i = 0; i < size; i++) {
            arr[i] = 1.0f;
        }

        long startTime = System.currentTimeMillis();

        // replace with the calculated value
        for (int i = 0; i < size; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        long endTime = System.currentTimeMillis();

        System.out.println("Operations finished, it took " + (endTime - startTime) + "ms");
        System.out.println(arr[0] + " " + arr[100]);
    }

    // two threads
    public static void arrayManipulationsTwoThreads() {
        //fill array with 1s
        for (int i = 0; i < size; i++) {
            arr[i] = 1.0f;
        }

        long startTime = System.currentTimeMillis();

        //split array in two
        float[] arrFirstHalf = new float[half];
        float[] arrSecondHalf = new float[half];

        System.arraycopy(arr, 0, arrFirstHalf, 0, half);
        System.arraycopy(arr, half, arrSecondHalf, 0, half);

        // replace with the calculated value
        myThread threadFirst = new myThread(arrFirstHalf);
        myThread threadSecond = new myThread(arrSecondHalf);

        threadFirst.start();
        threadSecond.start();

        //ensure execution is finished before the arr is put back together
        try {
            threadFirst.join();
            threadSecond.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        arrFirstHalf = threadFirst.getArr();
        arrSecondHalf = threadSecond.getArr();

        // put the arr back together
        System.arraycopy(arrFirstHalf, 0, arr, 0, half);
        System.arraycopy(arrSecondHalf, 0, arr, half, half);

        long endTime = System.currentTimeMillis();

        System.out.println("Operations finished, it took " + (endTime - startTime) + "ms");
    }
}
