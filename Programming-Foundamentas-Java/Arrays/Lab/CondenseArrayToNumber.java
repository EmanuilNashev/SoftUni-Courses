package Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CondenseArrayToNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        if (numbers.length > 1){
            for (int i = 0; i < numbers.length; i++) {
                int[] sums = new int[numbers.length-1];

                for (int j = 0; j < numbers.length - 1; j++) {
                    sum = numbers[j] + numbers[j + 1];
                    sums[j] = sum;
                }
                numbers = sums;
                i = 0;
            }
            System.out.println(numbers[0]);
        }else {
            System.out.println(numbers[0]);
        }

    }
}
