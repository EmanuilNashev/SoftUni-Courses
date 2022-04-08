package ForLoop.MoreExercises;

import java.util.Scanner;

public class Bills {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int months = Integer.parseInt(scanner.nextLine());

        double totalCurrent = 0;
        double water = months * 20;
        double internet = months * 15;
        double other = 0;

        for (int i = 1; i <= months ; i++) {
            double currentForMonth = Double.parseDouble(scanner.nextLine());

            totalCurrent += currentForMonth;
            other += (currentForMonth + 20 + 15) + ((currentForMonth + 20 + 15) * 0.20);

        }
        double average = (totalCurrent + water + internet + other) / months;

        System.out.printf("Electricity: %.2f lv%nWater: %.2f lv%nInternet: %.2f lv%nOther: %.2f lv%nAverage: %.2f lv", totalCurrent, water, internet, other, average);
    }
}
