package NestedLoops.Exercises;

import java.util.Scanner;

public class NumberPyramid {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int currentNum = 1;
        boolean isGreater = false;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i ; j++) {
                if (currentNum > n){
                    isGreater = true;
                    break;
                }


                System.out.print(currentNum + " ");
                currentNum++;
            }
            System.out.println();
            if (isGreater){
                break;
            }

        }
    }
}
