package NestedLoops.MoreExercises;

import java.util.Scanner;

public class PrimePairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startValueOfFirstPair = Integer.parseInt(scanner.nextLine());
        int startValueOfSecondPair = Integer.parseInt(scanner.nextLine());
        int endValueOfFirstPair = Integer.parseInt(scanner.nextLine());
        int endValueOfSecondPair = Integer.parseInt(scanner.nextLine());

        for (int firstPair = startValueOfFirstPair; firstPair <= startValueOfFirstPair + endValueOfFirstPair; firstPair++) {
            for (int secondPair = startValueOfSecondPair; secondPair <= startValueOfSecondPair + endValueOfSecondPair; secondPair++) {
                boolean isSimpleNumberFirstPair = false;
                int firstPairCounter = 0;
                for (int i = 1; i <= firstPair; i++) {
                    if (firstPair % i == 0) {
                        firstPairCounter++;
                    }
                }
                if (firstPairCounter == 2) {
                    isSimpleNumberFirstPair = true;
                }
                boolean isSimpleNumberSecondPair = false;
                int secondPairCounter = 0;
                for (int i = 1; i <= secondPair; i++) {
                    if (secondPair % i == 0) {
                        secondPairCounter++;
                    }
                }
                if (secondPairCounter == 2) {
                    isSimpleNumberSecondPair = true;
                }
                boolean isSimpleNumbersTwoPairs = isSimpleNumberFirstPair && isSimpleNumberSecondPair;
                if (isSimpleNumbersTwoPairs) {
                    System.out.println("" + firstPair + secondPair);
                }
            }
        }
    }
}
