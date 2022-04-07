package CanditionalStatementsAdvanced.Exercises;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeFilm = scanner.nextLine();
        int r = Integer.parseInt(scanner.nextLine());
        int c = Integer.parseInt(scanner.nextLine());

        int totalPlaces = r * c;
        double priceFilm = 0;

        if (typeFilm.equals("Premiere")) {
            priceFilm = 12.00;
        }else if (typeFilm.equals("Normal")){
            priceFilm = 7.50;
        }else if (typeFilm.equals("Discount")){
            priceFilm = 5.00;
        }
        double totalPrice = totalPlaces * priceFilm;
        System.out.printf("%.2f leva", totalPrice);
    }
}
