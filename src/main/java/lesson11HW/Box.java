package lesson11HW;

import lesson11HW.Fruits.Fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruitInBox = new ArrayList<>();

    //добавить фрукт в коробку
    public void addFruit(T fruit) {
        this.fruitInBox.add(fruit);
    }

    //посчитать вес
    public float getWeight() {
        float weight = 0;

        if (fruitInBox == null) {
            return 0;
        }

        for (T fruit:fruitInBox) {
            weight += fruit.getWeight();
        }

        return weight;
    }

    //сравнить вес
    public boolean compare(Box<? extends Fruit> another) {
        return this.getWeight() == another.getWeight();
    }

    //переложить
    public void transfer (Box<T> another) {
        another.setFruitInBox(this.fruitInBox);
        this.fruitInBox = null;
    }

    //добавить несколько фруктов сразу
    public void setFruitInBox(ArrayList<T> fruitInBox) {
        this.fruitInBox.addAll(fruitInBox);
    }
}
