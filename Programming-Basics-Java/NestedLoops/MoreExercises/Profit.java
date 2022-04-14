package NestedLoops.MoreExercises;

import java.util.Scanner;

public class Profit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOneLevas = Integer.parseInt(scanner.nextLine());
        int countTwoLevas = Integer.parseInt(scanner.nextLine());
        int countFiveLevas = Integer.parseInt(scanner.nextLine());
        int sum = Integer.parseInt(scanner.nextLine());


        for (int one = 0; one <= countOneLevas; one++) {
            for (int two = 0; two <= countTwoLevas; two++) {
                for (int five = 0; five <= countFiveLevas; five++) {
                    if (one + two * 2 + five * 5 == sum) {
                        System.out.printf("%d * 1 lv. + %d * 2 lv. + %d * 5 lv. = %d lv.%n", one,two,five,sum);
                    }
                }
            }
        }
    }
}
