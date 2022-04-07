package CanditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class MultiplyBy2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        for (int i = min; i <= max - 1; i++) {
             double num = Double.parseDouble(scanner.nextLine()) ;

            if (num < 0) {
                System.out.println("Negative number!");
                break;
            }else{
                double resultNum = num * 2;
                System.out.printf("Result: %.2f%n", resultNum);
            }
        }

    }

}
