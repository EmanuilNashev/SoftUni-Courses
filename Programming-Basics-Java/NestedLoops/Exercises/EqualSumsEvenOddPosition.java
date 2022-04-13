package NestedLoops.Exercises;

import java.util.Scanner;

public class EqualSumsEvenOddPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());

        int oddSum = 0;
        int evenSum = 0;
        int currentDigit = 0;

        for (int i = firstNum; i <= secondNum; i++) {
            int num = i;
            for (int j = 6; j >= 1; j--) {
                currentDigit = num % 10;

                if (j % 2 == 0) {
                    evenSum += currentDigit;
                } else {
                    oddSum += currentDigit;
                }
                num = num / 10;


            }
            if (evenSum == oddSum) {
                System.out.print(i + " ");

            }
            evenSum = 0;
            oddSum = 0;

        }
    }
}
