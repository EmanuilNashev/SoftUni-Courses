package ForLoop.MoreExercises;

import java.util.Scanner;

public class EqualPairs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPairs = Integer.parseInt(scanner.nextLine());
        int sumNumbers = 0;
        int countEquals = 1;
        int diff = 0;

        for (int i = 1; i <=countPairs ; i++) {
            int firstNum = Integer.parseInt(scanner.nextLine());
            int secondNum = Integer.parseInt(scanner.nextLine());
            if (firstNum + secondNum == sumNumbers){
                countEquals ++;
            }else{
                diff = Math.abs((secondNum + firstNum) - sumNumbers);
            }

            sumNumbers = firstNum + secondNum;




        }
        if (countEquals  == countPairs){
            System.out.printf("Yes, value=%d",sumNumbers);
        }else{
            System.out.printf("No, maxdiff=%d", diff);
        }
    }
}
