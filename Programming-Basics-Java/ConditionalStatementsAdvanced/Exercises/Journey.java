package CanditionalStatementsAdvanced.Exercises;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();

        String destination = "";
        double price = 0;
        String rest = "";

        if (budget <= 100){
            destination = "Bulgaria";
            if (season.equals("summer")){
                rest = "Camp";
                price = budget * 0.30;
            }else if (season.equals("winter")){
                rest = "Hotel";
                price = budget * 0.70;
            }
        }else if (budget <= 1000){
            destination = "Balkans";
            if (season.equals("summer")){
                rest = "Camp";
                price = budget * 0.40;
            }else if (season.equals("winter")){
                rest = "Hotel";
                price = budget * 0.80;
            }
        }else if (budget > 1000){
            rest = "Hotel";
            destination = "Europe";
            price = budget * 0.90;
        }
        System.out.printf("Somewhere in %s%n", destination);
        System.out.printf("%s - %.2f", rest, price);
    }
}
