package NestedLoops.MoreExercises;

import java.util.Scanner;

public class ChallengeTheWedding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int man = Integer.parseInt(scanner.nextLine());
        int women = Integer.parseInt(scanner.nextLine());
        int freeTables = Integer.parseInt(scanner.nextLine());

        int counter = 0;
        boolean flag = false;
        for (int j = 1; j <= man; j++) {
            for (int i = 1; i <= women; i++) {
                counter++;
                System.out.print("(" + j + " <-> " + i + ") ");
                if (counter >= freeTables) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
    }
}
