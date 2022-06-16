package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixParameters = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = matrixParameters[0];
        int cols = matrixParameters[1];

        int[][] matrix = readMatrix(scanner, rows);

        int positionOfNumber = Integer.parseInt(scanner.nextLine());

        findPositionNumberAndPrint(rows, cols, matrix, positionOfNumber);
    }

    private static void findPositionNumberAndPrint(int rows, int cols, int[][] matrix, int positionOfNumber) {
        boolean isFoundIndex = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == positionOfNumber) {
                    isFoundIndex = true;
                    System.out.println(row + " " + col);
                }
            }
        }

        if (!isFoundIndex) {
            System.out.println("not found");
        }
    }

    private static int[][] readMatrix(Scanner scanner, int rows) {
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = numbers;
        }
        return matrix;
    }
}
