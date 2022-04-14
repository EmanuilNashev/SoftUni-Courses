package NestedLoops.MoreExercises;

import java.util.Scanner;

public class SecretDoorSLock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hundreds = Integer.parseInt(scanner.nextLine());
        int tens = Integer.parseInt(scanner.nextLine());
        int ones = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= hundreds; i++) {
            if (i % 2 != 0) {
                continue;
            }
            for (int j = 1; j <= tens; j++) {
                int count = 0;
                for (int l = 1; l <= 9; l++) {
                    if (j % l == 0) {
                        count++;
                    }
                }
                if (count != 2) {
                    continue;
                }
                for (int k = 1; k <= ones; k++) {
                    if (k % 2 != 0) {
                        continue;

                    }
                    System.out.print(i);
                    System.out.print(" " + j);
                    System.out.println(" " + k);
                }
            }
        }
    }
}
