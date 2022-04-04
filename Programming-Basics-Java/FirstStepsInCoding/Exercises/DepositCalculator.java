package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class DepositCalculator {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double depositedAmount = Double.parseDouble(scanner.nextLine());
        int termOfDeposit = Integer.parseInt(scanner.nextLine());
        double annualInterestRate = Double.parseDouble(scanner.nextLine());
        double annualInterestRate1 = annualInterestRate / 100;
        double interest = depositedAmount * annualInterestRate1;
        double interestForOneMonth = interest / 12;
        double sum = depositedAmount + termOfDeposit * interestForOneMonth;
        System.out.println(sum);
    }
}
