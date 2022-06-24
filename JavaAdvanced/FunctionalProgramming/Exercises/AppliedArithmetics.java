package Functions.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AppliedArithmetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String command = line;

            Consumer<List<Integer>> consumer;
            switch (command) {
                case "add":
                    consumer = addOne();
                    consumer.accept(numbers);
                    break;
                case "multiply":
                    List<Integer> addedNumber = new ArrayList<>();
                    Function<Integer,Integer> function = integer -> integer * 2;

                    numbers.forEach(e ->{
                        addedNumber.add(function.apply(e));
                    });
                    numbers = addedNumber;
//                    consumer = multiply();
//                    consumer.accept(numbers);
                    break;
                case "subtract":
                   consumer = subtractOne();
                   consumer.accept(numbers);
                    break;
                case "print":
                    consumer = print();
                    consumer.accept(numbers);
                    break;

            }


            line = scanner.nextLine();
        }
    }

    private static Consumer<List<Integer>> subtractOne() {
        return integers -> {
            for (int i = 0; i < integers.size(); i++) {
                integers.set(i, integers.get(i) - 1);
            }
        };
    }

    private static Consumer<List<Integer>> print() {
        return integers -> {
            integers.forEach(e -> System.out.print(e + " "));
            System.out.println();
        };
    }

    private static Consumer<List<Integer>> multiply() {
        return integers -> {
            for (int i = 0; i < integers.size(); i++) {
                integers.set(i, integers.get(i) * 2);
            }
        };
    }

    private static Consumer<List<Integer>> addOne() {
        return integers -> {
            for (int i = 0; i < integers.size(); i++) {
                integers.set(i, integers.get(i) + 1);
            }
        };
    }
}
