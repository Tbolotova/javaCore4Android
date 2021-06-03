package lesson07HW;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (food - n < 0) {
            return false;
        } else {
            food -= n;
            return true;
        }
    }

    public void addFood(int amountToAdd) {
        food += amountToAdd;
    }

    public void info() {
        System.out.println("plate: " + food);
    }

    public int getFood() {
        return food;
    }

}