package WhileLoop.MoreExercises;

import java.util.Scanner;

public class Dishwasher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bottles = Integer.parseInt(scanner.nextLine());

        int quantityDetergent = bottles * 750;
        String input = scanner.nextLine();
        int countLoadingDishes = 0;
        int countLoadingDishes1 = 0;
        int countPots = 0;
        int countDishes3 = 0;
        int diff = 0;

        boolean isNotEnough = false;

        while (!input.equals("End")) {
            int countDishes = Integer.parseInt(input);
            countLoadingDishes1++;

            if (countLoadingDishes1 == 3) {
                countLoadingDishes += countDishes * 15;
                countLoadingDishes1 = 0;
                countPots += countDishes;
                diff = Math.abs(quantityDetergent - (countDishes * 15));
                if (quantityDetergent < countDishes * 15) {
                    quantityDetergent = Math.abs(quantityDetergent);
                    isNotEnough = true;
                    break;
                }
                quantityDetergent = quantityDetergent - (countDishes * 15);
            } else {
                countLoadingDishes += countDishes * 5;
                countDishes3 += countDishes;
                diff = Math.abs(quantityDetergent - (countDishes * 5));
                if (quantityDetergent < countDishes * 5) {
                    quantityDetergent = Math.abs(quantityDetergent);
                    isNotEnough = true;
                    break;
                }
                quantityDetergent = quantityDetergent - (countDishes * 5);
            }


            input = scanner.nextLine();
        }
        if (!isNotEnough) {
            System.out.println("Detergent was enough!");
            System.out.printf("%d dishes and %d pots were washed.%n", countDishes3, countPots);
            System.out.printf("Leftover detergent %d ml.", diff);
        } else {
            System.out.printf("Not enough detergent, %d ml. more necessary!", diff);
        }
    }
}
