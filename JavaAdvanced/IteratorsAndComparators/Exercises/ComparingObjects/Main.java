package IteratorsAndComparators.Exercises.ComparingObjects;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] personData = line.split("\\s+");

            String name = personData[0];
            int age = Integer.parseInt(personData[1]);
            String town = personData[2];

            Person person = new Person(name, age, town);
            persons.add(person);

            line = scanner.nextLine();
        }

        int n = Integer.parseInt(scanner.nextLine());

        int equalsPeople = 0;
        boolean flag = false;
        for (int i = 0; i < persons.size(); i++) {
            if (persons.size() > n) {
                if (persons.get(n).compareTo(persons.get(i)) == 0) {
                    flag = true;
                    equalsPeople++;
                }
            }
        }
        if (flag) {
            int res = persons.size() - equalsPeople;
            System.out.println("" + equalsPeople + " " + res + " " +  persons.size());
        } else {
            System.out.println("No matches");
        }
    }
}
