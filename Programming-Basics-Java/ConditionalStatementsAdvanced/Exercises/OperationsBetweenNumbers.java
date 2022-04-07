package CanditionalStatementsAdvanced.Exercises;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N1 = Integer.parseInt(scanner.nextLine());
        int N2 = Integer.parseInt(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);

        String evenOrOdd = "";
        double result = 0;

        if (operator == '+') {
            result = N1 + N2;
            if (result % 2 == 0) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }
        } else if (operator == '-') {
            result = N1 - N2;
            if (result % 2 == 0) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }
        } else if (operator == '*') {
            result = N1 * N2;
            if (result % 2 == 0) {
                evenOrOdd = "even";
            } else {
                evenOrOdd = "odd";
            }
        } else if (operator == '/') {
            result = 1.0 * N1 / N2;
        } else if (operator == '%') {
            result = 1.0 * N1 % N2;
        }
        boolean isTrue = true;
        if (N2 == 0){
            isTrue = false;
        }
        if (operator == '+' || operator == '-' || operator == '*') {
            System.out.printf("%d %c %d = %.0f - %s", N1, operator, N2, result, evenOrOdd);
        } else if (operator == '/') {
            if (!isTrue){
                System.out.printf("Cannot divide %d by zero", N2);
            }else{
                System.out.printf("%d %c %d = %.2f", N1, operator, N2, result);
            }
        } else if (operator == '%') {
            if (!isTrue){
                System.out.printf("Cannot divide %d by zero", N2);
            }else {
                System.out.printf("%d %c %d = %.0f", N1, operator, N2, result);
            }
        }
    }
}
