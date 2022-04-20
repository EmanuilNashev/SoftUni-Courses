package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char c1 = scanner.nextLine().charAt(0);
        char c2 = scanner.nextLine().charAt(0);
        char c3 = scanner.nextLine().charAt(0);

        System.out.println("" + c3 + " " + c2 + " " + c1);
    }
}
