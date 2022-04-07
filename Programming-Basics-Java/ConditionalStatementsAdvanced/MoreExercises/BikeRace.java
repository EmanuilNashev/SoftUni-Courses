package CanditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class BikeRace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int juniors = Integer.parseInt(scanner.nextLine());
        int seniors = Integer.parseInt(scanner.nextLine());
        String  typeRoute = scanner.nextLine();

        double feeJuniors = 0;
        double feeSeniors = 0;
        switch (typeRoute){
            case "trail":
                feeJuniors = 5.50;
                feeSeniors = 7;
                break;
            case "cross-country":
                feeJuniors = 8;
                feeSeniors = 9.50;
                break;
            case "downhill":
                feeJuniors = 12.25;
                feeSeniors = 13.75;
                break;
            case "road":
                feeJuniors = 20;
                feeSeniors = 21.50;
        }
        if (typeRoute.equals("cross-country")){
            if ((juniors + seniors) >=50){
                feeJuniors = feeJuniors * 0.75;
                feeSeniors = feeSeniors * 0.75;
            }
        }
        double price = ((juniors * feeJuniors) + (seniors * feeSeniors)) * 0.95;
        System.out.printf("%.2f", price);
    }
}
