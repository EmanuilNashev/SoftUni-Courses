package OOP.WorkingWithAbstraction.Exercises.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Reader.readArray(scanner);

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] galaxy = new int[rows][cols];

        fillTheGalaxy(rows, cols, galaxy);

        long starsCollected = 0;

        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {

            int[] jediPositions = Reader.readArray(command);
            int[] evilPositions = Reader.readArray(scanner);

            int evilRow = evilPositions[0];
            int evilCol = evilPositions[1];

            while (evilRow >= 0 && evilCol >= 0) {

                destroyStars(galaxy, evilRow, evilCol);

                evilRow--;
                evilCol--;

            }

            int jediRow = jediPositions[0];
            int jediCol = jediPositions[1];

            while (isEvilInBounds(galaxy, jediCol, jediRow >= 0, 1)) {
                starsCollected = jediCollectStars(galaxy, starsCollected, jediRow, jediCol);

                jediCol++;
                jediRow--;
            }

            command = scanner.nextLine();
        }

        System.out.println(starsCollected);


    }

    private static long jediCollectStars(int[][] galaxy, long starsCollected, int jediRow, int jediCol) {
        if (isJediInBounds(galaxy, jediRow, jediCol)) {
            starsCollected += galaxy[jediRow][jediCol];
        }
        return starsCollected;
    }

    private static boolean isJediInBounds(int[][] galaxy, int jediRow, int jediCol) {
        return jediRow < galaxy.length && jediCol >= 0 && jediCol < galaxy[0].length;
    }

    private static void destroyStars(int[][] galaxy, int evilRow, int evilCol) {
        if (isEvilInBounds(galaxy, evilCol, evilRow < galaxy.length, 0)) {
            galaxy[evilRow][evilCol] = 0;
        }
    }

    private static boolean isEvilInBounds(int[][] galaxy, int evilCol, boolean b, int i) {
        return b && evilCol < galaxy[i].length;
    }

    private static void fillTheGalaxy(int rows, int cols, int[][] galaxy) {
        int value = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                galaxy[row][col] = value++;
            }
        }
    }
}
