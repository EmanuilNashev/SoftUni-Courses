package Functions.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int divisibleNumber = Integer.parseInt(scanner.nextLine());
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Predicate<Integer> predicate = number -> {
            for (int i : numbers) {
                if (number % i != 0) {
                    return false;
                }
            }
            return true;
        };

        Consumer<Integer> printOutput = n -> {
            for (int i = 1; i <= n; i++) {
                if (predicate.test(i)) {
                    System.out.print(i + " ");
                }
            }
        };
        printOutput.accept(divisibleNumber);

    }
}
