package ConditionalStatements.Exercises;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int racer = Integer.parseInt(scanner.nextLine());
        int racer2 = Integer.parseInt(scanner.nextLine());
        int racer3 = Integer.parseInt(scanner.nextLine());

        int sumRacers = racer + racer2 + racer3;
        int min = sumRacers / 60;
        int sec = sumRacers % 60;

        System.out.printf("%d:%02d", min, sec);
    }
}
