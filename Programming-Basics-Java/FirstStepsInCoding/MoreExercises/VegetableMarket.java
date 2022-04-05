package FirstStepsInCoding.MoreExcersiseForPractise;

import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double prizeForKilogramVegetables = Double.parseDouble(scanner.nextLine());
        double prizeForKilogramFruits = Double.parseDouble(scanner.nextLine());
        int kilogramsOfVegetables = Integer.parseInt(scanner.nextLine());
        int kilogramsOfFruits = Integer.parseInt(scanner.nextLine());
        double prizeOfVegetables = prizeForKilogramVegetables * kilogramsOfVegetables;
        double prizeOfFruits = prizeForKilogramFruits * kilogramsOfFruits;
        double fullPrize= prizeOfVegetables + prizeOfFruits;
        double fullPrizeInEuro = fullPrize / 1.94;
        System.out.printf("%.2f", fullPrizeInEuro);
    }
}
