package Functions.Exercises;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .boxed()
                .toArray(Integer[]::new);


//        Function<Integer[], Integer> findSmallestNumber = integers -> Arrays.stream(integers).min(Integer::compareTo).get();

        Function<Integer[], Integer> findSmallestNumber = integers-> {
            int minNum = Integer.MAX_VALUE;
            for (Integer integer : integers) {
                if (integer < minNum){
                    minNum = integer;
                }
            }
            return minNum;
        };

        System.out.println(findSmallestNumber.apply(numbers));
    }
}
