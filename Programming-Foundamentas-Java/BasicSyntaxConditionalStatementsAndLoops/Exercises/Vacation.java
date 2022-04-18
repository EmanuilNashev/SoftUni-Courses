package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPeople = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String typeOfDay = scanner.nextLine();

        double price = 0;

        switch (typeOfGroup) {
            case "Students":
                switch (typeOfDay) {
                    case "Friday":
                        price = 8.45;
                        break;
                    case "Saturday":
                        price = 9.80;
                        break;
                    case "Sunday":
                        price = 10.46;
                        break;
                }
                break;
            case "Business":
                switch (typeOfDay) {
                    case "Friday":
                        price = 10.90;
                        break;
                    case "Saturday":
                        price = 15.60;
                        break;
                    case "Sunday":
                        price = 16;
                        break;
                }
                break;
            case "Regular":
                switch (typeOfDay) {
                    case "Friday":
                        price = 15;
                        break;
                    case "Saturday":
                        price = 20;
                        break;
                    case "Sunday":
                        price = 22.50;
                        break;
                }
                break;

        }
        double totalPrice = countPeople * price;

        switch (typeOfGroup){
            case "Students":
                if (countPeople >= 30){
                    totalPrice = totalPrice * 0.85;
                }
                break;
            case "Business":
                if (countPeople >= 100){
                    totalPrice = (countPeople - 10) * price;
                }
                break;
            case "Regular":
                if (countPeople >= 10 && countPeople<= 20){
                    totalPrice = totalPrice * 0.95;
                }
                break;
        }
        System.out.printf("Total price: %.2f", totalPrice);

    }
}
