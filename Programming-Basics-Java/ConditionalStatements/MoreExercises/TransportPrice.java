package ConditionalStatements.MoreExcersisesForPractice;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String nightOrDay = scanner.nextLine();
        double lowerPrice = 0;
        if (n < 20) {
            if (nightOrDay.equals("day")) {
                lowerPrice = 0.70 + n * 0.79;
            } else if (nightOrDay.equals("night")) {
                lowerPrice = 0.70 + n * 0.90;
            }
        } else if (n < 100) {
            if (nightOrDay.equals("day") || nightOrDay.equals("night")) {
                lowerPrice = n * 0.09;
            }
        } else  {
            if(nightOrDay.equals("day") || nightOrDay.equals("night"))
            lowerPrice = n * 0.06;
        }
        System.out.printf("%.2f", lowerPrice);
    }
}