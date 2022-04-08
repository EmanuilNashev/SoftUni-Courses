package ForLoop.MoreExercises;

import java.util.Scanner;

public class OddOrEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double oddSum = 0;
        double oddMaxNumber = Integer.MIN_VALUE;
        double oddMinNumber = Integer.MAX_VALUE;

        double evenSum = 0;
        double evenMaxNumber = Integer.MIN_VALUE;
        double evenMinNumber = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            double num = Double.parseDouble(scanner.nextLine());

            if (i % 2 == 0) {
                evenSum += num;
                if (evenMaxNumber < num) {
                    evenMaxNumber = num;
                }
                if (evenMinNumber > num) {
                    evenMinNumber = num;
                }
            } else {
                oddSum += num;
                if (oddMaxNumber < num) {
                    oddMaxNumber = num;
                }
                if (oddMinNumber > num) {
                    oddMinNumber = num;
                }
            }


        }
        System.out.printf("OddSum=%.2f,%n", oddSum);
        if (oddMinNumber == Integer.MAX_VALUE) {
            System.out.printf("OddMin=No,%n");
        } else {
            System.out.printf("OddMin=%.2f,%n", oddMinNumber);
        }
        if (oddMaxNumber == Integer.MIN_VALUE){
            System.out.printf("OddMax=No,%n");
        }else{
            System.out.printf("OddMax=%.2f,%n",oddMaxNumber);
        }
        System.out.printf("EvenSum=%.2f,%n", evenSum);
        if (evenMinNumber == Integer.MAX_VALUE){
            System.out.printf("EvenMin=No,%n");
        }else{
            System.out.printf("EvenMin=%.2f,%n", evenMinNumber);
        }
        if (evenMaxNumber == Integer.MIN_VALUE){
            System.out.printf("EvenMax=No%n");
        }else{
            System.out.printf("EvenMax=%.2f%n", evenMaxNumber);
        }
    }
}
