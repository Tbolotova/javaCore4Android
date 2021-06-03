package Lesson06HW.Animals.Dogs;

import Lesson06HW.Animals.Animal;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
        this.maxRunDistance = 500;
        this.maxJumpHeight = 0.5f;
        this.maxSwimDistance = 10;
    }

}
