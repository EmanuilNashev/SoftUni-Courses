package CanditionalStatementsAdvanced.Exercises;

import java.util.Scanner;

public class NewHouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String flowers = scanner.nextLine();
        int countFlowers = Integer.parseInt(scanner.nextLine());
        int budget = Integer.parseInt(scanner.nextLine());

        double price = 0;

        if (flowers.equals("Roses")) {
            price = countFlowers * 5;
            if (countFlowers > 80) {
                price = price * 0.90;
            }
        } else if (flowers.equals("Dahlias")) {
            price = countFlowers * 3.80;
            if (countFlowers > 90) {
                price = price * 0.85;
            }
        } else if (flowers.equals("Tulips")) {
            price = countFlowers * 2.80;
            if (countFlowers > 80) {
                price = price * 0.85;
            }
        } else if (flowers.equals("Narcissus")) {
            price = countFlowers * 3;
            if (countFlowers < 120) {
                price = price + (price * 0.15);
            }
        } else if (flowers.equals("Gladiolus")) {
            price = countFlowers * 2.50;
            if (countFlowers < 80) {
                price = price + (price * 0.20);
            }
        }

        double residueOrNeed = Math.abs(budget - price);

        if (budget >= price) {
            System.out.printf("Hey, you have a great garden with %d %s and %.2f leva left.",
                    countFlowers, flowers, residueOrNeed);
        } else {
            System.out.printf("Not enough money, you need %.2f leva more.", residueOrNeed);
        }
    }
}
