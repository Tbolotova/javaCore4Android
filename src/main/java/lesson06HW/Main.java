package lesson06HW;

import lesson06HW.Animals.Animal;
import lesson06HW.Animals.Cat;
import lesson06HW.Animals.Dogs.BigDog;
import lesson06HW.Animals.Dogs.Dog;
import lesson06HW.Animals.Dogs.SmallDog;
import lesson06HW.Menagerie.Menagerie;

public class Main {
    public static void main(String[] args) {
        Menagerie menagerie = new Menagerie();
        Cat cat = new Cat("Барсик");
        Dog dog = new Dog("Рекс");
        BigDog bigDog = new BigDog("Шарик");
        SmallDog smallDog = new SmallDog("Тузик");

        menagerie.addAnimal(cat);
        menagerie.addAnimal(dog);
        menagerie.addAnimal(smallDog);
        menagerie.addAnimal(bigDog);

        for (Animal animal : menagerie.getAnimals()) {
            animal.run(500);
            animal.jump(2);
            animal.swim(8);
        }
    }
}
