package CanditionalStatementsAdvanced.MoreExercises;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int countPeopleInGroup = Integer.parseInt(scanner.nextLine());

        double priceTicket = 0;
        double budgetWithTransport = 0;

        if (countPeopleInGroup >= 1 && countPeopleInGroup <= 4) {
            budgetWithTransport = budget * 0.25;
        } else if (countPeopleInGroup >= 5 && countPeopleInGroup <= 9) {
            budgetWithTransport = budget * 0.40;
        } else if (countPeopleInGroup >= 10 && countPeopleInGroup <= 24) {
            budgetWithTransport = budget * 0.50;
        } else if (countPeopleInGroup >= 25 && countPeopleInGroup <= 49) {
            budgetWithTransport = budget * 0.60;
        } else {
            budgetWithTransport = budget * 0.75;
        }

        if (category.equals("VIP")) {
            priceTicket = 499.99 * countPeopleInGroup;
        } else if (category.equals("Normal")){
            priceTicket = 249.99 * countPeopleInGroup;
        }

        double diff = Math.abs(budgetWithTransport - priceTicket);

        if (budgetWithTransport >= priceTicket){
            System.out.printf("Yes! You have %.2f leva left.", diff);
        }else {
            System.out.printf("Not enough money! You need %.2f leva.", diff);
        }

    }
}
