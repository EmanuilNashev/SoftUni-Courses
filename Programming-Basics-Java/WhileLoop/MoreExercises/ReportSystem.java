package WhileLoop.MoreExercises;

import java.util.Scanner;

public class ReportSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int neededSumFromSales = Integer.parseInt(scanner.nextLine());

        int cardOrCash = 0;
        //cardOrCash = 1 => Cash
        //cardOrCash = 2 => card
        int totalSum = 0;
        double averageCS = 0;
        double averageCC = 0;
        int countCS = 0;
        int countCC = 0;

        String input = scanner.nextLine();

        while (!input.equals("End")) {
            int priceOfSubjects = Integer.parseInt(input);
            cardOrCash++;
            if (cardOrCash == 1 && priceOfSubjects > 100) {
                System.out.println("Error in transaction!");
            } else if (cardOrCash == 1) {
                countCS++;
                averageCS += priceOfSubjects;
                totalSum += priceOfSubjects;
                System.out.println("Product sold!");
            }
            if (cardOrCash == 2 && priceOfSubjects < 10) {
                System.out.println("Error in transaction!");
            } else if (cardOrCash == 2) {
                countCC++;
                averageCC += priceOfSubjects;
                totalSum += priceOfSubjects;
                System.out.println("Product sold!");
            }

            if (cardOrCash == 2) {
                cardOrCash = 0;
            }
            if (totalSum >= neededSumFromSales) {
                break;
            }

            input = scanner.nextLine();
        }
        averageCS = averageCS/countCS;
        averageCC = averageCC/countCC;

        if (input.equals("End")){
            System.out.println("Failed to collect required money for charity.");
        }else{
            System.out.printf("Average CS: %.2f%n", averageCS);
            System.out.printf("Average CC: %.2f", averageCC);
        }
    }
}
