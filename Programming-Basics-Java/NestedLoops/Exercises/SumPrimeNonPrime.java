package NestedLoops.Exercises;

import java.util.Scanner;

public class SumPrimeNonPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int countDevider = 0;
        int sumPrime = 0;
        int sumNonPrime = 0;


        while (!input.equals("stop")) {
            int num = Integer.parseInt(input);
            if (num < 0){
                System.out.println("Number is negative.");
                input = scanner.nextLine();
                continue;
            }

                for (int i = 1; i <= num; i++) {
                    if (num % i == 0) {
                        countDevider++;

                    }


                }
            if (countDevider > 2) {
                sumNonPrime += num;
            } else {
                sumPrime += num;
            }
            countDevider = 0;


            input = scanner.nextLine();
        }
        System.out.printf("Sum of all prime numbers is: %d%n", sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d", sumNonPrime);
    }
}
