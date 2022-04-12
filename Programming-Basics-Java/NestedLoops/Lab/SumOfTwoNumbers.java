package NestedLoops.Lab;

import java.util.Scanner;

public class SumOfTwoNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());
        int countComb = 0;
        boolean flag = false;

        for (int i = startNum; i <= endNum; i++) {
            for (int j = startNum; j <= endNum; j++) {
                countComb++;
                if (i + j == magicNum) {
                    System.out.printf("Combination N:%d (%d + %d = %d)%n", countComb, i, j, magicNum);
                    flag = true;
                    break;
                }

            }
            if (flag) {
                break;
            }

        }
        if (!flag){
            System.out.printf("%d combinations - neither equals %d", countComb, magicNum);
        }
    }
}
