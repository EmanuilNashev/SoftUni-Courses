package Functions.Lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] numbers = scanner.nextLine().split(",\\s+");

        Function<String,Integer> parse = Integer::parseInt;
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int num = parse.apply(numbers[i]);

            sum+=num;
        }

        System.out.println("Count = " + numbers.length);
        System.out.println("Sum = " + sum);


    }
}
