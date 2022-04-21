package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class TriplesOfLatinLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 97; i < 97 + n; i++) {
            for (int k = 97; k < 97 + n; k++) {
                for (int j = 97; j < 97 + n; j++) {

                    System.out.printf("%c%c%c%n", i, k, j);
                }
            }

        }
    }
}
