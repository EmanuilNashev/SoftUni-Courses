package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char c1 = scanner.nextLine().charAt(0);
        char c2 = scanner.nextLine().charAt(0);
        char c3 = scanner.nextLine().charAt(0);

        String combinedChars = "" + c1 + c2 + c3;
        System.out.println(combinedChars);
    }
}
