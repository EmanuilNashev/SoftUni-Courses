package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class WaterOverflow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        short n = Short.parseShort(scanner.nextLine());
        short sumLitres = 0;

        for (int i = 0; i < n; i++) {
            short litres = Short.parseShort(scanner.nextLine());
            sumLitres+=litres;
            if (sumLitres > 255){
                System.out.println("Insufficient capacity!");
                sumLitres-=litres;
            }
        }
        System.out.println(sumLitres);

    }
}
