package Functions.Lab;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Predicate<Integer> isEven = n -> n % 2 == 0;

        List<Integer> unsortedArr = new ArrayList<>();
        for (int i = 0; i <numbers.length ; i++) {
            if(isEven.test(numbers[i])) {
                unsortedArr.add(numbers[i]);
            }
        }


        for (int i = 0; i < unsortedArr.size(); i++) {

            System.out.print(unsortedArr.get(i));
            if (i <unsortedArr.size() - 1){
                System.out.print(", ");
            }
        }

        List<Integer> sorted = new ArrayList<>();
      Arrays.stream(unsortedArr.toArray()).sorted().forEach(e -> sorted.add((Integer) e));

      System.out.println();
        for (int i = 0; i < sorted.size(); i++) {

            System.out.print(sorted.get(i));
            if (i <sorted.size() - 1){
                System.out.print(", ");
            }
        }

    }
}
