package lesson08HW.Obstacles;

import lesson08HW.Interfaces.Runnable;

public class RaceTrack implements Runnable {
    private int length;

    public RaceTrack(int length) {
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "RaceTrack{" +
                "length=" + length +
                '}';
    }
}
