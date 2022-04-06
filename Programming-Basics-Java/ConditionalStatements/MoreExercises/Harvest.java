package ConditionalStatements.MoreExcersisesForPractice;

import java.util.Scanner;

public class Harvest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = Integer.parseInt(scanner.nextLine());
        double Y = Double.parseDouble(scanner.nextLine());
        int Z = Integer.parseInt(scanner.nextLine());
        int countWorkers = Integer.parseInt(scanner.nextLine());

        double totalGrapes = X * Y;
        double wine = 0.4 * totalGrapes / 2.5;


        double residueWine = (Math.abs(wine - Z));
        if (wine >= Z) {
            double litersPerMan = Math.ceil(residueWine / countWorkers);
            wine = Math.floor(wine);
            System.out.printf("Good harvest this year! Total wine: %.0f liters.%n", wine);
            System.out.printf("%.0f liters left -> %.0f liters per person.", Math.ceil(residueWine), litersPerMan);
        } else if(wine < Z) {
            System.out.printf("It will be a tough winter! More %.0f liters wine needed.", Math.floor(residueWine));

        }
    }
}
