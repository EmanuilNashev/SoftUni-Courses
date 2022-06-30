package IteratorsAndComparators.Exercises.Frogy;

import java.util.*;
import java.util.stream.Collectors;

public class Lake implements Iterable<Integer> {
    public List<Integer> elements;

    public Lake(String data) {
        this.elements = Arrays.stream(data.split(", ")).map(Integer::parseInt).collect(Collectors.toList());
    }

    @Override
    public Iterator<Integer> iterator() {

        return new Frog();
    }

    public class Frog implements Iterator<Integer> {
        int i = 0;
        boolean isFirst = true;

        @Override
        public boolean hasNext() {

            if (i < elements.size() && isFirst) {
                return true;
            }
            if (isFirst){
                isFirst = false;
                i = 1;
            }
            return i < elements.size();
        }

        @Override
        public Integer next() {
            int el = elements.get(i);
            i += 2;
            return el;
        }
    }
}
