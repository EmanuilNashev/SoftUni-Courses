package NestedLoops.MoreExercises;

import java.util.Scanner;

public class SafePasswordsGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int maxGeneratedPasswords = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        boolean isReachedYMax = false;
        boolean isReachedXMax = false;
        boolean isMaxComb = false;
        boolean flag = false;
        for (int A = 34; A < 55; A++) {
            for (int B = 63; B < 96; B++) {
                for (int x = 1; x <= a; x++) {
                    for (int y = 1; y <= b; y++) {
                        counter++;
                        if (counter > maxGeneratedPasswords) {
                            flag = true;
                            break;
                        }

                        A++;
                        B++;

                        System.out.print("" + (char) A + (char) B + x + y + (char) B + (char) A + "|");
                        if (A == 55) {
                            A = 34;
                        }
                        if (B == 96){
                            B = 63;
                        }
                        if (y == b) {
                            isReachedYMax = true;
                        }
                        if (isReachedYMax && isReachedXMax) {
                            isMaxComb = true;
                            break;
                        }
                    }
                    if (x == a) {
                        isReachedXMax = true;
                    }
                    if (isReachedYMax && isReachedXMax) {
                        isMaxComb = true;
                        break;
                    }
                    if (flag) {
                        break;
                    }
                }
                if (isMaxComb) {
                    break;
                }
                if (flag) {
                    break;
                }
            }
            if (isMaxComb) {
                break;
            }
            if (flag) {
                break;
            }
        }
    }
}
