package lesson06HW.Menagerie;

import lesson06HW.Animals.Animal;

import java.util.ArrayList;

public class Menagerie {
    public ArrayList<Animal> animals = new ArrayList<>();

    public void addAnimal(Animal animal) {
            animals.add(animal);
    }

    public ArrayList<Animal> getAnimals() {
        return animals;
    }
}
