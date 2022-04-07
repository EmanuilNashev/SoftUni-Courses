package CanditionalStatementsAdvanced.Exercises;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int budget = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        int countFishers = Integer.parseInt(scanner.nextLine());

        double priceOfBoat = 0;

        if (season.equals("Spring")) {
            if (countFishers <= 6) {
                priceOfBoat = 3000 * 0.90;
            } else if (countFishers <= 11) {
                priceOfBoat = 3000 * 0.85;
            } else if (countFishers > 12) {
                priceOfBoat = 3000 * 0.75;
            }
        } else if (season.equals("Summer") || season.equals("Autumn")) {
            if (countFishers <= 6) {
                priceOfBoat = 4200 * 0.90;
            } else if (countFishers <= 11) {
                priceOfBoat = 4200 * 0.85;
            } else if (countFishers > 12) {
                priceOfBoat = 4200 * 0.75;
            }
        } else if (season.equals("Winter")) {
            if (countFishers <= 6) {
                priceOfBoat = 2600 * 0.90;
            } else if (countFishers <= 11) {
                priceOfBoat = 2600 * 0.85;
            } else if (countFishers > 12) {
                priceOfBoat = 2600 * 0.75;
            }
        }
        if (countFishers % 2 == 0 && !season.equals("Autumn")) {
            priceOfBoat = priceOfBoat * 0.95;
        }
        double enough = Math.abs(budget - priceOfBoat);
        boolean isEnough = budget >= priceOfBoat;

        if (isEnough) {
            System.out.printf("Yes! You have %.2f leva left.", enough);
        } else {
            System.out.printf("Not enough money! You need %.2f leva.", enough);
        }
    }
}
