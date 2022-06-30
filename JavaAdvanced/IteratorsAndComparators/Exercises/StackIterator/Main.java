package IteratorsAndComparators.Exercises.StackIterator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StackIterator stackIterator = new StackIterator();
        Iterator<Integer> iterator = stackIterator.iterator();

        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] data = line.split(" ");
            String command = data[0];

            switch (command) {
                case "Push":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < data.length; i++) {
                        sb.append(data[i]);
                    }
                    stackIterator.push(sb.toString());
                    break;
                case "Pop":
                    if (stackIterator.elements.size() == 0) {
                        System.out.println("No elements");
                        break;
                    }
                    stackIterator.pop();
                    break;
            }
            line = scanner.nextLine();
        }

        for (Integer integer : stackIterator) {
            System.out.println(integer);
        }
        for (Integer integer : stackIterator) {
            System.out.println(integer);
        }

    }
}
