package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int b = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {

            System.out.println(b);
            sum += b;

            b += 2;
        }
        System.out.println("Sum: " + sum);
    }
}
