package NestedLoops.MoreExercises;

import java.util.Scanner;

public class WeddingSeats {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char lastSector = scanner.nextLine().charAt(0);
        int countRowsInFirstSector = Integer.parseInt(scanner.nextLine());
        int countPlacesOnOddRow = Integer.parseInt(scanner.nextLine());
        int countPlacesOnEvenRow = countPlacesOnOddRow + 2;
        int maxPlaces;

        int counter = 0;
        for (int i = 65; i <= lastSector; i++) {
            char sector = (char) i;
            for (int row = 1; row <= countRowsInFirstSector; row++) {
                if (row % 2 == 0) {
                    maxPlaces = countPlacesOnEvenRow;
                } else {
                    maxPlaces = countPlacesOnOddRow;
                }
                for (int places = 97; places < 97 + maxPlaces; places++) {
                    counter++;
                    System.out.println("" + sector + row + (char) places);
                }
            }
            countRowsInFirstSector++;
        }
        System.out.println(counter);
    }
}
