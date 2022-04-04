package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int pens = Integer.parseInt(scanner.nextLine());
        int markers = Integer.parseInt(scanner.nextLine());
        int preparat = Integer.parseInt(scanner.nextLine());
        int percentDiscount = Integer.parseInt(scanner.nextLine());
        double prizePens = pens * 5.80;
        double prizeMarkers = markers * 7.20;
        double prizePreparat = preparat * 1.20;
        double percentDiscount2 = percentDiscount * 1.0 / 100;
        double prizeAllMaterials = prizePens + prizeMarkers + prizePreparat;
        double  prizeWithDiscount =  prizeAllMaterials - (prizeAllMaterials * percentDiscount2);
        System.out.println(prizeWithDiscount);
    }
}
