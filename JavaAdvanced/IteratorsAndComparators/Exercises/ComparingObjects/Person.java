package IteratorsAndComparators.Exercises.ComparingObjects;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    @Override
    public int compareTo(Person o) {
        int result = name.compareTo(o.name);
        if (result == 0) {
            result = Integer.compare(age, o.age);
        }
        if (result == 0) {
            result = town.compareTo(o.town);
        }
        return result;
    }
}
