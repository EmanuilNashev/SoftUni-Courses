package IteratorsAndComparators.Exercises.Frogy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lake = scanner.nextLine();
        String end = scanner.nextLine();

        Lake lake1 = new Lake(lake);

        int in = 0;
        for (Integer integer : lake1) {
            System.out.print(integer);
            if (in < lake1.elements.size() - 1) {
                System.out.print(", ");
            }
            in++;
        }
    }
}
