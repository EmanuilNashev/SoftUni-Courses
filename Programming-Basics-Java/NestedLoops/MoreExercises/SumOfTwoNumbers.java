package NestedLoops.MoreExercises;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNumber = Integer.parseInt(scanner.nextLine());

        int comb = 0;
        boolean flag = false;
        for (int i = start; i <= end; i++) {
            for (int j = start; j <=end; j++) {
                comb++;
                if (i + j ==magicNumber){
                    System.out.printf("Combination N:%d (%d + %d = %d)", comb, i,j,magicNumber);
                    flag = true;
                    break;
                }
            }
            if (flag){
                break;
            }
        }
        if (!flag){
            System.out.printf("%d combinations - neither equals %d",comb, magicNumber);
        }
    }
}
