package ForLoop.MoreExercises;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int move = Integer.parseInt(scanner.nextLine());
        double result = 0;
        double countNum0to9 = 0;
        double countNum10to19 = 0;
        double countNum20to29 = 0;
        double countNum30to39 = 0;
        double countNum40to50 = 0;
        double invalidNumbers = 0;


        for (int i = 1; i <= move; i++) {
            int numOfMove = Integer.parseInt(scanner.nextLine());

            if (numOfMove >= 0 && numOfMove <= 9) {
                result += numOfMove * 0.20;
                countNum0to9++;
            } else if (numOfMove >= 10 && numOfMove <= 19) {
                result += numOfMove * 0.30;
                countNum10to19++;
            } else if (numOfMove >= 20 && numOfMove <= 29) {
                result += numOfMove * 0.40;
                countNum20to29++;
            } else if (numOfMove >= 30 && numOfMove <= 39) {
                result += 50;
                countNum30to39++;
            } else if (numOfMove >= 40 && numOfMove <= 50) {
                result += 100;
                countNum40to50++;
            } else {
                result = result / 2;
                invalidNumbers++;
            }


        }
        countNum0to9 = countNum0to9 / move * 100;
        countNum10to19 = countNum10to19 / move * 100;
        countNum20to29 = countNum20to29 / move * 100;
        countNum30to39 = countNum30to39 / move * 100;
        countNum40to50 = countNum40to50 / move * 100;
        invalidNumbers = invalidNumbers / move * 100;

        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", countNum0to9);
        System.out.printf("From 10 to 19: %.2f%%%n", countNum10to19);
        System.out.printf("From 20 to 29: %.2f%%%n", countNum20to29);
        System.out.printf("From 30 to 39: %.2f%%%n", countNum30to39);
        System.out.printf("From 40 to 50: %.2f%%%n", countNum40to50);
        System.out.printf("Invalid numbers: %.2f%%", invalidNumbers);

    }
}
