package Functions.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        Consumer<String> printer = System.out::println;
        Predicate<String> predicate = name -> name.length() <= num;
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .filter(predicate).collect(Collectors.toList());


        names.forEach(printer);
    }
}
