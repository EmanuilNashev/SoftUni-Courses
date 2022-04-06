package ConditionalStatements.MoreExcersisesForPractice;

import java.util.Scanner;

public class FuelTankPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeFuel = scanner.nextLine();
        double quantityFuel = Double.parseDouble(scanner.nextLine());
        String discountCard = scanner.nextLine();


        double discount = 0;

        if (discountCard.equals("Yes")) {
            if (typeFuel.equals("Gasoline")) {
                discount = 2.22 - 0.18;
            } else if (typeFuel.equals("Diesel")) {
                discount = 2.33 - 0.12;
            } else if (typeFuel.equals("Gas")) {
                discount = 0.93 - 0.08;
            }
        } else {
            if (typeFuel.equals("Gasoline")) {
                discount = 2.22;
            } else if (typeFuel.equals("Diesel")) {
                discount = 2.33;
            } else if (typeFuel.equals("Gas")) {
                discount = 0.93;
            }
        }
        double priceGasoline = quantityFuel * discount;
        double priceDiesel = quantityFuel * discount;
        double priceGas = quantityFuel * discount;

        if (quantityFuel <= 25) {
            if (quantityFuel >= 20) {
                priceGasoline = priceGasoline * 0.92;
                priceDiesel = priceDiesel * 0.92;
                priceGas = priceGas * 0.92;
            }
        } else if (quantityFuel > 25) {
            priceGasoline = priceGasoline * 0.90;
            priceDiesel = priceDiesel * 0.90;
            priceGas = priceGas * 0.90;
        }
        if (typeFuel.equals("Gasoline")){
            System.out.printf("%.2f lv.", priceGasoline );
        }else if (typeFuel.equals("Diesel")){
            System.out.printf("%.2f lv.", priceDiesel);
        }else if(typeFuel.equals("Gas")){
            System.out.printf("%.2f lv.", priceGas);
        }


    }
}
