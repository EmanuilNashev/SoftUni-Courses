package WhileLoop.Exercises;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double remainder = Double.parseDouble(scanner.nextLine());
        double pennies = remainder * 100;
        int coins = 0;

        while (true) {
            if (pennies >= 200) {
                pennies = pennies - 200;
                coins++;
            } else if (pennies >= 100) {
                pennies = pennies - 100;
                coins++;
            } else if (pennies >= 50) {
                pennies = pennies - 50;
                coins++;
            } else if (pennies >= 20) {
                pennies = pennies - 20;
                coins++;
            } else if (pennies >= 10) {
                pennies = pennies - 10;
                coins++;
            } else if (pennies >= 5) {
                pennies = pennies - 5;
                coins++;
            } else if (pennies >= 2) {
                pennies = pennies - 2;
                coins++;
            } else if (pennies >= 1) {
                pennies = pennies - 1;
                coins++;
            } else {
                break;
            }


        }
        System.out.println(coins);
    }
}
