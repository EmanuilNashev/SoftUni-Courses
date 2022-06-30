package IteratorsAndComparators.Exercises.ListIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ListIterator implements Iterable<String> {
    private List<String> elements;
    private int currentIndex;

    public ListIterator(String... names) {
        this.elements = Arrays.stream(names).collect(Collectors.toList());
        this.currentIndex = 0;
    }

    public boolean move() {
        if (currentIndex < elements.size() - 1) {
            currentIndex++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        return currentIndex + 1 < this.elements.size();
    }

    public void print() {
        if (this.elements.size() > 0) {
            System.out.println(this.elements.get(currentIndex));
            return;
        }
        System.out.println("Invalid Operation!");
    }

    public void printAll() {

    }

    @Override
    public Iterator<String> iterator() {

        return new Iterator<String>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < elements.size();
            }

            @Override
            public String next() {
                return elements.get(i++);
            }
        };
    }
}
