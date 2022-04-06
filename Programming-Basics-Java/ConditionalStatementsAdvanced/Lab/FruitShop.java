package CanditionalStatementsAdvanced.Lab;

import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String dayOfWeek = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());

        double price = 0;

        switch (dayOfWeek) {
            case "Monday":
            case "Tuesday":
            case "Wednesday":
            case "Thursday":
            case "Friday":
                switch (fruit) {
                    case "banana":
                        price = quantity * 2.50;
                        System.out.printf("%.2f", price);
                        break;
                    case "apple":
                        price = quantity * 1.20;
                        System.out.printf("%.2f", price);
                        break;
                    case "orange":
                        price = quantity * 0.85;
                        System.out.printf("%.2f", price);
                        break;
                    case "grapefruit":
                        price = quantity * 1.45;
                        System.out.printf("%.2f", price);
                        break;
                    case "kiwi":
                        price = quantity * 2.70;
                        System.out.printf("%.2f", price);
                        break;
                    case "pineapple":
                        price = quantity * 5.50;
                        System.out.printf("%.2f", price);
                        break;
                    case "grapes":
                        price = quantity * 3.85;
                        System.out.printf("%.2f", price);
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
                break;
            case "Saturday":
            case "Sunday":
                switch (fruit) {
                    case "banana":
                        price = quantity * 2.70;
                        System.out.printf("%.2f", price);
                        break;
                    case "apple":
                        price = quantity * 1.25;
                        System.out.printf("%.2f", price);
                        break;
                    case "orange":
                        price = quantity * 0.90;
                        System.out.printf("%.2f", price);
                        break;
                    case "grapefruit":
                        price = quantity * 1.60;
                        System.out.printf("%.2f", price);
                        break;
                    case "kiwi":
                        price = quantity * 3.00;
                        System.out.printf("%.2f", price);
                        break;
                    case "pineapple":
                        price = quantity * 5.60;
                        System.out.printf("%.2f", price);
                        break;
                    case "grapes":
                        price = quantity * 4.20;
                        System.out.printf("%.2f", price);
                        break;
                    default:
                        System.out.println("error");
                        break;
                }
        }
        if(!(dayOfWeek.equals("Monday")) && !(dayOfWeek.equals("Tuesday")) && !(dayOfWeek.equals("Wednesday")) && !(dayOfWeek.equals("Thursday"))
        && !(dayOfWeek.equals("Friday")) && !(dayOfWeek.equals("Saturday")) && !(dayOfWeek.equals("Sunday"))){
            System.out.println("error");
        }
    }
}
