package CanditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class Flowers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countChrysanthemum = Integer.parseInt(scanner.nextLine());
        int countRoses = Integer.parseInt(scanner.nextLine());
        int countTulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();

        double priceChrysanthemum = 0;
        double priceRoses = 0;
        double priceTulips = 0;

        switch (season){
            case "Spring":
            case "Summer":
                priceChrysanthemum = 2.00;
                priceRoses = 4.10;
                priceTulips = 2.50;
                break;
            case "Autumn":
            case "Winter":
                priceChrysanthemum = 3.75;
                priceRoses = 4.50;
                priceTulips = 4.15;
                break;
        }
        if (holiday.equals("Y")){
            priceChrysanthemum = priceChrysanthemum +(priceChrysanthemum * 0.15);
            priceRoses = priceRoses + (priceRoses * 0.15);
            priceTulips = priceTulips + (priceTulips * 0.15);
        }
        double fullPrice = (countChrysanthemum * priceChrysanthemum) + (countRoses * priceRoses) + (countTulips * priceTulips);
        if (season.equals("Spring")){
            if (countTulips > 7){
                fullPrice = fullPrice * 0.95;
            }
        }
        if (season.equals("Winter")){
            if (countRoses >= 10){
                fullPrice = fullPrice * 0.90;
            }
        }
        if ((countChrysanthemum + countRoses + countTulips) > 20){
            fullPrice = fullPrice * 0.80;
        }
        fullPrice = fullPrice + 2;

        System.out.printf("%.2f", fullPrice);

    }
}
