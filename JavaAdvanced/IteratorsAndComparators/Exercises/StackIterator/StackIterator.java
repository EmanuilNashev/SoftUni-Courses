package IteratorsAndComparators.Exercises.StackIterator;

import java.util.*;

public class StackIterator implements Iterable<Integer> {
    List<Integer> elements;

    public StackIterator() {
        this.elements = new LinkedList<>();
    }

    public void push(String args) {
        int[] numbers = Arrays.stream(args.split(",")).mapToInt(Integer::parseInt).toArray();

        for (int number : numbers) {
            this.elements.add(0, number);
        }
    }

    public int pop() {
        int el = elements.get(0);
        elements.remove(0);
        return el;
    }


    @Override
    public Iterator<Integer> iterator() {
        return new customIterator();
    }

    public Iterator<Integer> iterator2() {
        return new otherIterator();
    }

    public class customIterator implements Iterator<Integer> {
        int i = 0;

        @Override
        public boolean hasNext() {
            return i < elements.size();
        }

        @Override
        public Integer next() {
            return elements.get(i++);
        }
    }

    public class otherIterator implements Iterator<Integer> {
        int i = elements.size() - 1;

        @Override
        public boolean hasNext() {
            return i > 0;
        }

        @Override
        public Integer next() {
            return elements.get(i--);
        }
    }
}
