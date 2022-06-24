package Functions.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] namesArray = scanner.nextLine().split("\\s+");

        Consumer<String> printName = System.out::println;
        Consumer<String[]> printNames = names -> Arrays.stream(names).forEach(printName);

        printNames.accept(namesArray);

    }
}
