package ConditionalStatements.Exercises;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double priceOfExcursion = Double.parseDouble(scanner.nextLine());
        int puzzle = Integer.parseInt(scanner.nextLine());
        int doll = Integer.parseInt(scanner.nextLine());
        int bears = Integer.parseInt(scanner.nextLine());
        int minions = Integer.parseInt(scanner.nextLine());
        int cars = Integer.parseInt(scanner.nextLine());
        double priceOfPuzzle = puzzle * 2.60;
        double priceOfDoll = doll * 3;
        double priceOfBears = bears * 4.10;
        double priceOfMinions = minions * 8.20;
        double priceOfCars = cars * 2;
        double fullPriceOfToys = priceOfPuzzle + priceOfDoll + priceOfBears + priceOfMinions + priceOfCars;

        if((puzzle + doll + bears + minions + cars >= 50)){
            fullPriceOfToys = fullPriceOfToys * 0.75;
        }
        fullPriceOfToys = fullPriceOfToys - fullPriceOfToys * 0.10;

        if(fullPriceOfToys >= priceOfExcursion){
            double leftMoney = fullPriceOfToys - priceOfExcursion;
            System.out.printf("Yes! %.2f lv left.", leftMoney);
        }
        else {
            double needMoney = Math.abs(fullPriceOfToys - priceOfExcursion);
            System.out.printf("Not enough money! %.2f lv needed.", needMoney);
        }
    }
}
