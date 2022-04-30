package Methods.Exercises;

import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        printSmallestNumber(num1, num2, num3);
    }

    static void printSmallestNumber(int num1, int num2, int num3) {

        int[] numbers = {num1, num2, num3};

        int minNumber = Integer.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            if (numbers[i] < minNumber) {
                minNumber = numbers[i];
            }


        }
        System.out.println(minNumber);
    }
}
