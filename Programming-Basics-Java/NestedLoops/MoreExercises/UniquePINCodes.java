package NestedLoops.MoreExercises;

import java.util.Scanner;

public class UniquePINCodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());

        int countDevider = 0;


        for (int i = 1; i <= firstNum; i++) {
            for (int j = 1; j <= secondNum; j++) {
                for (int k = 1; k <= thirdNum; k++) {
                    for (int l = 1; l <= j; l++) {
                        if (j % l == 0) {
                            countDevider++;
                        }

                    }
                    if (i % 2 == 0 && countDevider == 2 && k % 2 == 0) {
                        System.out.println("" + i + " " + j + " " + k);
                    }
                    countDevider = 0;
                }

            }

        }
    }

}
