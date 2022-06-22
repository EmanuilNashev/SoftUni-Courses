package SetsAndMapsAdvanced.Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] setSizes = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int firstSetSize = setSizes[0];
        int secondSetSize = setSizes[1];

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>();

        for (int element = 0; element < firstSetSize; element++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int element = 0; element < secondSetSize; element++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        for (Integer integer : firstSet) {
            if (secondSet.contains(integer)){
                System.out.print(integer + " ");
            }
        }
    }
}
