package NestedLoops.MoreExercises;

import java.util.Scanner;

public class TheSongOfTheWheels {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int M = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        String password = "";
        for (int a = 1; a <= 9; a++) {
            for (int b = 1; b <= 9; b++) {
                if (b <= a) {
                    continue;
                }
                for (int c = 1; c <= 9; c++) {
                    for (int d = 1; d <= 9; d++) {
                        if (d >= c) {
                            continue;
                        }
                        if (a * b + c * d == M) {
                            counter++;
                            System.out.print("" + a + b + c + d + " ");
                            if (counter == 4) {
                                password = "" + a + b + c + d;
                            }
                        }
                    }
                }
            }
        }
        System.out.println();
        if (counter >= 4) {
            System.out.println("Password: " + password);
        } else {
            System.out.println("No!");
        }
    }
}
