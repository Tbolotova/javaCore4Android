package Lesson06HW.Animals;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
        this.maxRunDistance = 200;
        this.maxJumpHeight = 2f;
    }

    @Override
    public void swim(int swimDistance) {
        System.out.println("Коты не умеют плавать.");
    }

}
