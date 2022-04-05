package ConditionalStatements.Exercises;

import java.util.Scanner;

public class WorldSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double record = Double.parseDouble(scanner.nextLine());
        double distanceInMetres = Double.parseDouble(scanner.nextLine());
        double timeInSec = Double.parseDouble(scanner.nextLine());
        double time = distanceInMetres * timeInSec;
        double metresSlower = (Math.floor(distanceInMetres / 15)) * 12.5;
        double fullTime = time + metresSlower;
        double timeInMore = Math.abs(fullTime - record);
        if (record > fullTime) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", fullTime);
        } else {
            System.out.printf("No, he failed! He was %.2f seconds slower.", timeInMore);
        }

    }
}
