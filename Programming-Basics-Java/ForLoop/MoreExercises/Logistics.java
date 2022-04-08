package ForLoop.MoreExercises;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countCargo = Integer.parseInt(scanner.nextLine());

        double minibus = 0;
        double truck = 0;
        double train = 0;
        int totalCargo = 0;

        for (int i = 1; i <= countCargo; i++) {
            int toneCargo = Integer.parseInt(scanner.nextLine());

            totalCargo += toneCargo;

            if (toneCargo <= 3){
                minibus += toneCargo;
            }else if (toneCargo <= 11){
                truck += toneCargo;
            }else {
                train += toneCargo;
            }
        }
        double priceForTone = (minibus * 200 + truck * 175 + train * 120) / totalCargo;
        double percentMinibus = minibus / totalCargo * 100;
        double percentTruck = truck / totalCargo * 100;
        double percentTrain = train / totalCargo * 100;

        System.out.printf("%.2f%n%.2f%%%n%.2f%%%n%.2f%%", priceForTone, percentMinibus, percentTruck, percentTrain);
    }
}
