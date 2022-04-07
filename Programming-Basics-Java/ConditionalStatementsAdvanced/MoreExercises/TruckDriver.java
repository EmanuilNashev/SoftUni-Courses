package CanditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class TruckDriver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String season = scanner.nextLine();
        double kilometersOnMonth = Double.parseDouble(scanner.nextLine());

        double lvOnKm = 0;

        if (kilometersOnMonth <= 5000) {
            switch (season) {
                case "Spring":
                case "Autumn":
                    lvOnKm = 0.75;
                    break;
                case "Summer":
                    lvOnKm = 0.90;
                    break;
                case "Winter":
                    lvOnKm = 1.05;
                    break;
            }
        } else if (kilometersOnMonth <= 10000) {
            switch (season) {
                case "Spring":
                case "Autumn":
                    lvOnKm = 0.95;
                    break;
                case "Summer":
                    lvOnKm = 1.10;
                    break;
                case "Winter":
                    lvOnKm = 1.25;
                    break;
            }
        } else if (kilometersOnMonth <= 20000){
            lvOnKm = 1.45;
        }
        double salary = (kilometersOnMonth * lvOnKm) * 0.90;
        salary = salary * 4;

        System.out.printf("%.2f", salary);
    }
}
