package ForLoop.Lab;

import java.util.Scanner;

public class LeftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int resultLeft = 0;
        int resultRight = 0;

        for (int i = 0; i < n; i++) {
            int leftNumbers = Integer.parseInt(scanner.nextLine());
            resultLeft += leftNumbers;

        }
        for (int i = 0; i < n; i++) {
            int rightNumbers = Integer.parseInt(scanner.nextLine());
            resultRight += rightNumbers;

        }
        int diff = Math.abs(resultLeft - resultRight);

        if (resultLeft == resultRight) {
            System.out.printf("Yes, sum = %d", resultLeft);
        } else {
            System.out.printf("No, diff = %d", diff);
        }
    }
}
