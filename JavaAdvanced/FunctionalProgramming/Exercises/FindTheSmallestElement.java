package Functions.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        Function<List<Integer>, Integer> findSmallestOne = list -> {
            int minNumber = list.stream().min(Integer::compareTo).get();
            return list.lastIndexOf(minNumber);
        };
        System.out.println(findSmallestOne.apply(numbers));
    }
}
