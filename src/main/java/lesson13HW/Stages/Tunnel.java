package lesson13HW.Stages;

import lesson13HW.Car;
import lesson13HW.MainClass;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private static int concurrencyLimit = MainClass.CARS_COUNT/2;
    private static Semaphore smp = new Semaphore(concurrencyLimit);
    public Tunnel() {
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smp.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smp.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
