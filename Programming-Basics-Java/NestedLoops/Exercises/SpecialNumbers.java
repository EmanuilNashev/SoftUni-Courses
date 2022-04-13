package NestedLoops.Exercises;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int currentNum = 0;
        for (int i = 1111; i <= 9999; i++) {
            int num = i;
            int countDevider = 0;
            for (int j = 1; j <= 4; j++) {

                currentNum = num % 10;
                if (currentNum != 0){
                    if (n % currentNum == 0) {
                        countDevider++;
                    }
                }
                num = num / 10;

            }
            if (countDevider == 4){
                System.out.printf("%d ", i);
            }
        }
    }
}
