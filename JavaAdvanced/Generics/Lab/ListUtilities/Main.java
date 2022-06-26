package Generics.Lab.ListUtilities;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(5, -4, 10, -20, 11);

        System.out.println(ListUtils.getMin(list));

        System.out.println(ListUtils.getMax(list));
    }
}
