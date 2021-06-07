package lesson08HW.Obstacles;

import lesson08HW.Interfaces.Jumpable;

public class Wall implements Jumpable {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Wall{" +
                "height=" + height +
                '}';
    }
}
