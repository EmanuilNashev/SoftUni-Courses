package OOP.Inheritance.Exercises.animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("Beast!")) {
            String typeOfAnimal = input;
            String[] animalData = scanner.nextLine().split("\\s+");

            String name = animalData[0];
            int age = Integer.parseInt(animalData[1]);
            String gender = animalData[2];

            try {
                switch (typeOfAnimal) {
                    case "Dog":
                        Animal dog = new Dog(name, age, gender);
                        animals.add(dog);
                        break;
                    case "Cat":
                        Animal cat = new Cat(name, age, gender);
                        cat.produceSound();
                        animals.add(cat);
                        break;
                    case "Kitten":
                        Animal kitten = new Kitten(name, age);
                        animals.add(kitten);
                        break;
                    case "Tomcat":
                        Animal tomcat = new Tomcat(name, age);
                        animals.add(tomcat);
                        break;
                    case "Frog":
                        Animal frog = new Frog(name, age, gender);
                        animals.add(frog);
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }

        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
}
