package CanditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class SchoolCamp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        String typeOfGroup = scanner.nextLine();
        int countStudents = Integer.parseInt(scanner.nextLine());
        int countDayNight = Integer.parseInt(scanner.nextLine());

        double priceDayNight = 0;
        String sport = "";

        switch (typeOfGroup) {
            case "boys":
            case "girls":
                switch (season) {
                    case "Winter":
                        priceDayNight = 9.60;
                        sport = "Gymnastics";
                        break;
                    case "Spring":
                        priceDayNight = 7.20;
                        sport = "Athletics";
                        break;
                    case "Summer":
                        priceDayNight = 15;
                        sport = "Volleyball";
                        break;
                }
                break;
            case "mixed":
                switch (season) {
                    case "Winter":
                        priceDayNight = 10;
                        sport = "Ski";
                        break;
                    case "Spring":
                        priceDayNight = 9.50;
                        sport = "Cycling";
                        break;
                    case "Summer":
                        priceDayNight = 20;
                        sport = "Swimming";
                        break;
                }
                break;
        }
        double fullPrice = countStudents * priceDayNight * countDayNight;

        if (countStudents >= 50) {
            fullPrice = fullPrice * 0.50;
        } else if (countStudents >= 20) {
            fullPrice = fullPrice * 0.85;
        } else if (countStudents >= 10) {
            fullPrice = fullPrice * 0.95;
        }
        switch (typeOfGroup) {
            case "boys":
                switch (season) {
                    case "Winter":
                        sport = "Judo";
                        break;
                    case "Spring":
                        sport = "Tennis";
                        break;
                    case "Summer":
                        sport = "Football";
                        break;
                }
        }
        System.out.printf("%s %.2f lv.", sport, fullPrice);

    }
}
