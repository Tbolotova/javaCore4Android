package lesson08HW.Participants;

import lesson08HW.Interfaces.Participatable;

public class Robot implements Participatable {
    private int runLimit;
    private double jumpLimit;

    public Robot(int runLimit, double jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public boolean run (int runLimit, int distance) {
        if (distance > runLimit) {
            System.out.printf("Этот робот не может пробежать %d.\n", distance);
            return false;
        } else if (distance < 0) {
            System.err.println("Некорректная дистанция.");
            return false;
        } else {
            System.out.printf("Робот пробежал %d.\n", distance);
            return true;
        }
    }

    @Override
    public boolean jump (double jumpLimit, double height) {
        if (height > jumpLimit) {
            System.out.printf("Этот робот не может перепрыгнуть %.2f.\n", height);
            return false;
        } else if (height < 0) {
            System.err.println("Некорректная высота.");
            return false;
        } else {
            System.out.printf("Робот перепрыгнул %.2f.\n", height);
            return true;
        }
    }

    public int getRunLimit() {
        return runLimit;
    }

    public double getJumpLimit() {
        return jumpLimit;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "runLimit=" + runLimit +
                ", jumpLimit=" + jumpLimit +
                '}';
    }
}
