package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());
        double percent2 = percent / 100;
        int volumeAq = length * width * height;
        double volumeLiters = volumeAq * 0.001;
        System.out.println(volumeLiters * (1-percent2));
    }
}
