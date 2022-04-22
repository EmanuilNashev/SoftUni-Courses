package DataTypesAndVariables.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class FromLeftToTheRightNotFixed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String numbersSeparatedBySpace = scanner.nextLine();

            String leftNumberAsString = "";
            String rightNumberAsString = "";
            for (int j = 0; j < numbersSeparatedBySpace.length(); j++) {
                if (numbersSeparatedBySpace.charAt(j) != 32) {

                    rightNumberAsString += "" + numbersSeparatedBySpace.charAt(j);
                } else {
                    leftNumberAsString = rightNumberAsString;
                    rightNumberAsString = "";
                }
            }

            int sumOfLeftDigits = 0;
            int sumOfRightDigits = 0;
            for (int j = 0; j < leftNumberAsString.length(); j++) {
                int digit = 0;
                if (leftNumberAsString.charAt(j) != 45) {
                    digit = Integer.parseInt("" + leftNumberAsString.charAt(j));
                } else {
                    digit = Integer.parseInt("-" + leftNumberAsString.charAt(j + 1));
                    j++;
                }
                sumOfLeftDigits += digit;
            }

            for (int j = 0; j < rightNumberAsString.length(); j++) {
                int digit = 0;
                if (rightNumberAsString.charAt(j) != 45) {
                    digit = Integer.parseInt("" + rightNumberAsString.charAt(j));
                } else {
                    digit = Integer.parseInt("-" + rightNumberAsString.charAt(j + 1));
                    j++;
                }
                sumOfRightDigits += digit;
            }


            if (leftNumberAsString.compareTo(rightNumberAsString) <= 0) {
                System.out.println(sumOfRightDigits);
            } else {
                System.out.println(sumOfLeftDigits);
            }
        }
    }
}
