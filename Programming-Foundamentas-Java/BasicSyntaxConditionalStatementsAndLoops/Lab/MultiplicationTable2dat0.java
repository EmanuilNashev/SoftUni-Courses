package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class MultiplicationTable2dat0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());

        for (int i = b; i <= 10; i++) {
            int sum = n * i;

            System.out.println(n + " X " + i + " = " + sum);
        }
        int sum = n * b;
        if (b > 10)
        System.out.println(n + " X " + b + " = " + sum);


    }
}
