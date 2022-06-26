package Generics.Lab.Jar;

import java.util.ArrayDeque;

public class Jar<T> {
    private ArrayDeque<T> data;
    int size;

    public Jar() {
        data = new ArrayDeque<>();
        size = 0;
    }

    public void add(T element) {
        data.push(element);
    }


    public T remove() {
        return data.pop();
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
