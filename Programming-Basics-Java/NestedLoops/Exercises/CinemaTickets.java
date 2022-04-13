package NestedLoops.Exercises;

import java.util.Scanner;

public class CinemaTickets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int countStandardTickets = 0;
        int countStudentTickets = 0;
        int countKidTickets = 0;
        boolean isSold = false;
        String projectile = scanner.nextLine();

        while (!projectile.equals("Finish")) {
            String nameOfMovie = projectile;
            int freePlaces = Integer.parseInt(scanner.nextLine());

            int countTickets = 0;

            String input = scanner.nextLine();
            while (!input.equals("End")) {

                String typeOfTicket = input;
                switch (typeOfTicket) {
                    case "standard":
                        countStandardTickets++;
                        break;
                    case "student":
                        countStudentTickets++;
                        break;
                    case "kid":
                        countKidTickets++;
                        break;
                }
                countTickets++;
                if (countTickets == freePlaces){
                    break;
                }

                input = scanner.nextLine();
            }
            double percentFull = 1.0 * countTickets / freePlaces * 100;
            System.out.printf("%s - %.2f%% full.%n", nameOfMovie, percentFull);

            projectile = scanner.nextLine();

        }
        int allTickets = countKidTickets + countStandardTickets + countStudentTickets;
        double percentStudent = 1.0 * countStudentTickets / allTickets * 100;
        double percentStandard = 1.0 * countStandardTickets / allTickets * 100;
        double percentKid = 1.0 * countKidTickets / allTickets * 100;

        System.out.printf("Total tickets: %d%n", allTickets);
        System.out.printf("%.2f%% student tickets.%n", percentStudent);
        System.out.printf("%.2f%% standard tickets.%n", percentStandard);
        System.out.printf("%.2f%% kids tickets.", percentKid);

    }
}
