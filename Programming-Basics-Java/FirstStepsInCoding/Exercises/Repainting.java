package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class Repainting {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int nylon = Integer.parseInt(scanner.nextLine());
        int paint = Integer.parseInt(scanner.nextLine());
        int thinner = Integer.parseInt(scanner.nextLine());
        int hours = Integer.parseInt(scanner.nextLine());
        double nylonIncrease =  (nylon + 2) * 1.50;
        double paintIncrease = (paint + paint * 0.1) * 14.50;
        double thinnerIncrease = thinner * 5.00;
        double bags = 0.40;
        double sumForMaterials = (nylonIncrease + paintIncrease + thinnerIncrease + bags);
        double sumHours =  (sumForMaterials * 0.3) * hours;
        System.out.println(sumForMaterials + sumHours);

    }
}
