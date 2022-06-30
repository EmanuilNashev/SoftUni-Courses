package IteratorsAndComparators.Exercises.StrategyPattern;

import com.sun.source.tree.Tree;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<Person> personsSortedByNames = new TreeSet<>(new LengthComparator());
        TreeSet<Person> personsSortedByAge = new TreeSet<>(new AgeComparator());

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] personData = scanner.nextLine().split("\\s+");

            String name = personData[0];
            int age = Integer.parseInt(personData[1]);

            Person person = new Person(name, age);
            personsSortedByNames.add(person);
            personsSortedByAge.add(person);
        }

        personsSortedByNames.forEach(System.out::println);
        personsSortedByAge.forEach(System.out::println);
    }
}
