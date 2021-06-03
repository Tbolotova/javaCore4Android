package lesson07HW;

public class Cat {
    private String name;
    private int appetite;
    private boolean isFull;
    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    public void eat(Plate p) {
        isFull = p.decreaseFood(appetite);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAppetite(int appetite) {
        this.appetite = appetite;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean isFull() {
        return isFull;
    }

    public String getName() {
        return name;
    }
}
