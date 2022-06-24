package Functions.Exercises;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int number = Integer.parseInt(scanner.nextLine());

        Predicate<Integer> removeIfDivisible = e -> e % number == 0;
        numbers.removeIf(removeIfDivisible);

        Consumer<List<Integer>> printer = e -> e.forEach(el -> System.out.print(el + " "));
        Collections.reverse(numbers);
        printer.accept(numbers);
    }
}
