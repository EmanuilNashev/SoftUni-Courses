package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class CenturiesToMinutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int centuries = Integer.parseInt(scanner.nextLine());
        int years = centuries * 100;
        double days = years * 365.2422;

        double hours = days * 24;
        double minutes = hours * 60;

        System.out.println("" + centuries + " centuries = " + years + " years = " + String.format("%.0f",days) + " days = " + String.format("%.0f", hours) + " hours = " + String.format("%.0f",minutes) + " minutes");

    }
}
