package IteratorsAndComparators.Exercises.ListIterator;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ListIterator listIterator = new ListIterator();
        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] commands = line.split("\\s+");
            String command = commands[0];

            switch (command) {
                case "Create":
                    if (commands.length != 1) {
                        listIterator = new ListIterator(Arrays.copyOfRange(commands, 1, commands.length));
                    }
                    break;
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
                case "Print":
                    listIterator.print();
                    break;
                case "PrintAll":
                    for (String s : listIterator) {
                        System.out.print(s + " ");
                    }
                    System.out.println();
                    break;
            }


            line = scanner.nextLine();
        }
    }
}
