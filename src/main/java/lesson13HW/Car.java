package lesson13HW;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static int rank;
    private static Lock lock = new ReentrantLock();
    private static CyclicBarrier cb = new CyclicBarrier(MainClass.CARS_COUNT);
    private static CountDownLatch countDownLatchFinish = MainClass.countDownLatchFinish;
    private static CountDownLatch countDownLatchReady = MainClass.countDownLatchReady;
    private Race race;
    private int speed;
    private String name;

    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            countDownLatchReady.countDown();
            cb.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }

        //check winner
        try {
            lock.lock();
            rank++;
            if (rank == 1) {
                System.out.println(this.name + " выиграл гонку!");
            } else {
                System.out.println(this.name + " закончил гонку и занял место: " + rank);
            }
        } finally {
            lock.unlock();
        }

        countDownLatchFinish.countDown();

    }
}