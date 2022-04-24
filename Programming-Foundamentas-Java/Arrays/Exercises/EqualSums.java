package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class EqualSums {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split(" ");

        int[] numbers = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            numbers[i] = Integer.parseInt(elements[i]);
        }

        //1 2 3 3

        boolean isTrue = true;

        for (int i = 0; i < numbers.length; i++) {
            int leftSum = 0;
            int rightSum = 0;
            byte index = 0;

            for (int j = 0; j < i; j++) {
                leftSum += numbers[j];
                index++;
            }

            for (int j = i + 1; j < numbers.length; j++) {
                rightSum += numbers[j];
            }

            if (leftSum == rightSum){
                System.out.println(index);
                isTrue = false;
                break;
            }

        }
        if (isTrue){
            System.out.println("no");
        }


    }
}
