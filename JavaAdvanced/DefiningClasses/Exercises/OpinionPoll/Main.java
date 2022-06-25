package DefiningClasses.Exercises.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> persons = new ArrayList<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] personalInfo = scanner.nextLine().split("\\s+");

            String personName = personalInfo[0];
            int personAge = Integer.parseInt(personalInfo[1]);

            Person person = new Person(personName, personAge);

            persons.add(person);
        }
        Predicate<Person> personFilter = person -> person.getAge() > 30;
        persons
                .stream()
                .filter(personFilter)
                .sorted(Comparator.comparing(Person::getName))
                .forEach(p -> System.out.println(p.getName() + " - " + p.getAge()));


    }
}
