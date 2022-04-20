package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= n; i++) {
            int specialSum = 0;
            int sum = i;
            String length = "" + i;
            for (int j = 0; j < length.length(); j++) {
                int lastDigit = sum % 10;
                specialSum += lastDigit;
                sum = sum / 10;
            }
            if (specialSum == 5 || specialSum == 7 || specialSum == 11) {
                System.out.println(i + " -> " + "True");
            } else {
                System.out.println(i + " -> " + "False");
            }


        }
    }
}
