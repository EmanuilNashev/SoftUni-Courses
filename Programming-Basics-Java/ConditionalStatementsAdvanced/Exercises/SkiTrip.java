package CanditionalStatementsAdvanced.Exercises;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOfStay = Integer.parseInt(scanner.nextLine());
        String typeOfRoom = scanner.nextLine();
        String typeOfRate = scanner.nextLine();

        double price = 0;

        switch (typeOfRoom) {
            case "room for one person":
                price = 18.00 * (daysOfStay - 1);
                break;
            case "apartment":
                price = 25.00 * (daysOfStay - 1);
                if(daysOfStay < 10){
                    price = price * 0.70;
                }else if (daysOfStay < 15){
                    price = price * 0.65;
                }else {
                    price = price * 0.50;
                }
                break;
            case "president apartment":
                price = 35.00 * (daysOfStay - 1);
                if (daysOfStay < 10){
                    price = price * 0.90;
                }else if (daysOfStay < 15){
                    price = price * 0.85;
                }else{
                    price = price * 0.80;
                }
                break;
        }
        switch (typeOfRate){
            case "positive":
                price = price + (price * 0.25);
                break;
            case  "negative":
                price = price - (price * 0.10);
                break;
        }
        System.out.printf("%.2f", price);
    }
}
