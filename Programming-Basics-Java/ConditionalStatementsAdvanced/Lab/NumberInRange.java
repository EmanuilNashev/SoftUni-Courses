package CanditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());

        if ((num >= -100 && num <= -1) || (num >= 1 && num <= 100)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
