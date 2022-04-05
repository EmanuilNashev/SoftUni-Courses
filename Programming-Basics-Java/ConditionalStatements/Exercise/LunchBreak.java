package ConditionalStatements.Exercises;

import java.util.Scanner;

public class LunchBreak {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int durationEp = Integer.parseInt(scanner.nextLine());
        int durationRest = Integer.parseInt(scanner.nextLine());
        double timeForLunch = durationRest * 0.125;
        double timeForRest = durationRest * 0.25;
        double leftTime = durationRest - timeForLunch - timeForRest;
        double A = Math.ceil(Math.abs(leftTime - durationEp));

        if (leftTime >= durationEp) {
            System.out.printf("You have enough time to watch %s and left with %.0f minutes free time.", name, A);
        } else {
            System.out.printf("You don't have enough time to watch %s, you need %.0f more minutes.", name, A);
        }
    }
}
