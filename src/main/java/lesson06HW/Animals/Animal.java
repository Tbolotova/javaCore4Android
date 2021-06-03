package lesson06HW.Animals;

public class Animal {
    protected String name;
    protected int maxRunDistance;
    protected float maxJumpHeight;
    protected int maxSwimDistance;

    public Animal(String name) {
        this.name = name;
    }

    public void jump (int jumpHeight) {
        if (jumpHeight > this.maxJumpHeight) {
            System.out.printf("%s не может прыгнуть выше, чем %.1f м.\n", this.name, this.maxJumpHeight);
        } else if (jumpHeight < 0) {
            System.err.println("Некорректный параметр дистанции.");
        } else {
            System.out.printf("%s прыгнул на %d м.\n", this.name, jumpHeight);
        }
    }

    public void run (int runDistance) {
        if (runDistance > this.maxRunDistance) {
            System.out.printf("%s не может пробежать больше, чем %d м.\n", this.name, this.maxRunDistance);
        } else if (runDistance < 0) {
            System.err.println("Некорректный параметр дистанции.");
        }  else {
            System.out.printf("%s пробежал %d метров.\n", this.name, runDistance);
        }
    }

    public void swim(int swimDistance) {
        if (swimDistance > this.maxSwimDistance) {
            System.out.printf("%s не может проплыть больше, чем %d м.\n", this.name, this.maxSwimDistance);
        } else if (swimDistance < 0) {
            System.err.println("Некорректный параметр дистанции.");
        }  else {
            System.out.printf("%s проплыл %d метров.\n", this.name, swimDistance);
        }
    }

}
