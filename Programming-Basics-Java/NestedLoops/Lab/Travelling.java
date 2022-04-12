package NestedLoops.Lab;

import java.util.Scanner;

public class Travelling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("End")){
            String country = input;
            double budget = Double.parseDouble(scanner.nextLine());

            double savedSum = 0;

            while (savedSum < budget){
                double savedMoney = Double.parseDouble(scanner.nextLine());




                savedSum += savedMoney;
                if (savedSum >= budget){
                    System.out.printf("Going to %s!%n", country);
                }
            }


            input = scanner.nextLine();
        }
    }
}
