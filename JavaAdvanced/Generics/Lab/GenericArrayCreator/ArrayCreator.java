package Generics.Lab.GenericArrayCreator;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayCreator {

    @SuppressWarnings("unchecked")
    public static <T> T[] create(int length, T defaultValue) {
        T[] elements = (T[]) Array.newInstance(defaultValue.getClass(), length);
        Arrays.fill(elements, defaultValue);

        return elements;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> clazz, int length, T item) {
        T[] items = (T[]) Array.newInstance(clazz, length);
        Arrays.fill(items, item);
        return items;
    }
}
