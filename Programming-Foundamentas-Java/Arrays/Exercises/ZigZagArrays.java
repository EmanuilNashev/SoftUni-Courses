package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] firstArr = new int[n];
        int[] secondArr = new int[n];

        int firstArrIndex = 0;
        int secondArrIndex = 0;

        for (int i = 0; i < n; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();

            if (i % 2 == 0) {
                firstArr[firstArrIndex] = num1;
                firstArrIndex++;
                secondArr[secondArrIndex] = num2;
                secondArrIndex++;

            } else {
                firstArr[firstArrIndex] = num2;
                firstArrIndex++;
                secondArr[secondArrIndex] = num1;
                secondArrIndex++;
            }
        }
        for (int first : firstArr) {
            System.out.print(first + " ");

        }
        System.out.println();
        Arrays.stream(secondArr).forEach(second -> System.out.print(second + " "));
    }
}
