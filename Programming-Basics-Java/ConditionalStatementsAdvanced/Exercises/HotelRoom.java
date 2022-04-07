package CanditionalStatementsAdvanced.Exercises;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int countOvernights = Integer.parseInt(scanner.nextLine());

        double studio = 0;
        double apartment = 0;

        switch (month) {
            case "May":
            case "October":
                studio = 50;
                apartment = 65;
                if (countOvernights > 7 && countOvernights <= 14){
                    studio = studio * 0.95;
                }else if (countOvernights > 14){
                    studio = studio * 0.70;
                    apartment = apartment * 0.90;
                }
                break;
            case "June":
            case "September":
                studio = 75.20;
                apartment = 68.70;
                if (countOvernights > 14){
                    studio = studio * 0.80;
                    apartment = apartment * 0.90;
                }
                break;
            case "July":
            case "August":
                studio = 76;
                apartment = 77;
                if (countOvernights > 14){
                    apartment = apartment * 0.90;
                }
                break;
        }
        apartment = apartment * countOvernights;
        studio  = studio * countOvernights;

        System.out.printf("Apartment: %.2f lv.%n", apartment);
        System.out.printf("Studio: %.2f lv.", studio);
    }
}
