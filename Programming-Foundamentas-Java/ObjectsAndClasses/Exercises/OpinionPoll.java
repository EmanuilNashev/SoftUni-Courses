package ObjectsAndClasses.Exercises;

import java.util.*;

public class OpinionPoll {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        Map<String,Integer> persons = new LinkedHashMap<>();
        for (int i = 0; i < N; i++) {
            String[] personalInfo = scanner.nextLine().split("\\s+");
            String personName = personalInfo[0];
            int personAge = Integer.parseInt(personalInfo[1]);

            Person person = new Person(personName, personAge);
            persons.put(person.getName(), person.getAge());
        }

        for (Map.Entry<String, Integer> stringIntegerEntry : persons.entrySet()) {
            if (stringIntegerEntry.getValue() > 30){
                System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue());
            }
        }
    }

    static class Person {
        String name;
        int age;

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName(){
            return name;
        }
        public int getAge(){
            return age;
        }
    }
}
