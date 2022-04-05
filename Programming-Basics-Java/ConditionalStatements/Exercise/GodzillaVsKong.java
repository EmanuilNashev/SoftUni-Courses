package ConditionalStatements.Exercises;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double moneyForFilm = Double.parseDouble(scanner.nextLine());
        int players = Integer.parseInt(scanner.nextLine());
        double priceForClothing = Double.parseDouble(scanner.nextLine());
        double design = moneyForFilm * 0.1;
        double fullPriceCloth = priceForClothing * players;
        if(players >= 150){
            fullPriceCloth = fullPriceCloth - fullPriceCloth * 0.1;
        }
        if(design + fullPriceCloth > moneyForFilm){
            System.out.println("Not enough money!");
            double count = Math.abs(moneyForFilm - (design + fullPriceCloth));
            System.out.printf("Wingard needs %.2f leva more.", count);
        }else {
            double count = moneyForFilm - (design + fullPriceCloth);
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", count);
        }
    }
}
