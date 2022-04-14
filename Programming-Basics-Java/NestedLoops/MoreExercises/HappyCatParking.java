package NestedLoops.MoreExercises;

import java.util.Scanner;

public class HappyCatParking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());

        double totalSum = 0;
        for (int day = 1; day <= days; day++) {
            double sum = 0;
            for (int hour = 1; hour <= hours; hour++) {
                if ((day % 2 == 0) && (hour % 2 != 0)) {
                    sum += 2.50;
                } else if ((day % 2 != 0) && (hour % 2 == 0)) {
                    sum += 1.25;
                } else {
                    sum += 1;
                }
            }
            System.out.printf("Day: %d - %.2f leva%n", day, sum);
            totalSum += sum;
        }
        System.out.printf("Total: %.2f leva", totalSum);
    }
}
