package IteratorsAndComparators.Exercises.StrategyPattern;

import java.util.Comparator;

public class LengthComparator implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        int result = Integer.compare(o1.name.length(), o2.name.length());
        if (result == 0) {
            char c1 = Character.toLowerCase(o1.name.charAt(0));
            char c2 = Character.toLowerCase(o2.name.charAt(0));
            return Integer.compare(c1, c2);
        }

        return result;
    }
}
