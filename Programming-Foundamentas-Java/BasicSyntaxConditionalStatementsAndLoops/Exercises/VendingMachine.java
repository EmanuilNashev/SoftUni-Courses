package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double sum = 0;

        while (!input.equals("Start")) {
            double money = Double.parseDouble(input);
            if (money != 0.10 && money != 0.20 && money != 0.50 && money != 1 && money != 2) {
                System.out.printf("Cannot accept %.2f%n", money);
                input = scanner.nextLine();
                continue;
            }

            sum += money;

            input = scanner.nextLine();
        }
        String input2 = scanner.nextLine();
        while (!input2.equals("End")) {
            String product = input2;
            switch (product) {
                case "Nuts":
                    if (sum >= 2) {
                        sum -= 2;
                        System.out.println("Purchased " + "Nuts");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (sum >= 0.70) {
                        sum -= 0.70;
                        System.out.println("Purchased " + "Water");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (sum >= 1.50) {
                        sum -= 1.50;
                        System.out.println("Purchased " + "Crisps");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (sum >= 0.80) {
                        sum -= 0.80;
                        System.out.println("Purchased " + "Soda");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (sum >= 1) {
                        sum -= 1;
                        System.out.println("Purchased " + "Coke");
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }


            input2 = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", sum);
    }
}
