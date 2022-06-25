package DefiningClasses.Exercises.Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> persons = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] personData = line.split("\\s+");

            String name = personData[0];
            String command = personData[1];
            Person person = new Person(name);
            switch (command) {
                case "company":
                    setCompany(personData, name, person, persons);
                    break;
                case "pokemon":
                    addPokemon(personData, name, person, persons);
                    break;
                case "parents":
                    addParents(personData, name, person, persons);
                    break;
                case "children":
                    addChildren(personData, name, person, persons);
                    break;
                case "car":
                    setCar(personData, name, person, persons);
                    break;
            }
            line = scanner.nextLine();
        }

        String nameToPrint = scanner.nextLine();
        System.out.println(persons.get(nameToPrint));
    }

    private static void addChildren(String[] personData, String name, Person person, Map<String, Person> persons) {
        String childName = personData[2];
        String childBirthday = personData[3];

        Child child = new Child(childName, childBirthday);
        person.addChild(child);

        if (!persons.containsKey(name)) {
            persons.put(name, person);
        } else {
            persons.get(name).addChild(child);
        }
    }

    private static void addParents(String[] personData, String name, Person person, Map<String, Person> persons) {
        String parentName = personData[2];
        String parentBirthday = personData[3];

        Parent parent = new Parent(parentName, parentBirthday);
        person.addParent(parent);

        if (!persons.containsKey(name)) {
            persons.put(name, person);
        } else {
            persons.get(name).addParent(parent);
        }
    }

    private static void addPokemon(String[] personData, String name, Person person, Map<String, Person> persons) {
        String pokemonName = personData[2];
        String pokemonType = personData[3];

        Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
        person.addPokemon(pokemon);

        if (!persons.containsKey(name)) {
            persons.put(name, person);
        } else {
            persons.get(name).addPokemon(pokemon);
        }

    }

    private static void setCar(String[] personData, String name, Person person, Map<String, Person> persons) {
        String carModel = personData[2];
        int carSpeed = Integer.parseInt(personData[3]);

        Car car = new Car(carModel, carSpeed);
        person.setCar(car);

        if (!persons.containsKey(name)) {
            persons.put(name, person);
        } else {
            persons.get(name).setCar(car);
        }


    }


    private static void setCompany(String[] personData, String name, Person person, Map<String, Person> persons) {
        String companyName = personData[2];
        String department = personData[3];
        double salary = Double.parseDouble(personData[4]);


        Company company = new Company(companyName, department, salary);
        person.setCompany(company);

        if (!persons.containsKey(name)) {
            persons.put(name, person);
        } else {
            persons.get(name).setCompany(company);
        }
    }
}
