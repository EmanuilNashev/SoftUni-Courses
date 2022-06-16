package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensionsForFirstMatrix = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rowsOfFirstMatrix = dimensionsForFirstMatrix[0];
        int colsOfFirstMatrix = dimensionsForFirstMatrix[1];

        int[][] firstMatrix = readMatrix(colsOfFirstMatrix, rowsOfFirstMatrix, scanner);


        int[] dimensionForSecondMatrix = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rowsOfSecondMatrix = dimensionForSecondMatrix[0];
        int colsOfSecondMatrix = dimensionForSecondMatrix[1];

        int[][] secondMatrix = readMatrix(colsOfSecondMatrix, rowsOfSecondMatrix, scanner);

        boolean areEqualsMatrix = getAreEqualsMatrix(firstMatrix, secondMatrix);

        String output = areEqualsMatrix ? "equal" : "not equal";

        System.out.println(output);
    }

    private static boolean getAreEqualsMatrix(int[][] firstMatrix, int[][] secondMatrix) {

        if (firstMatrix.length != secondMatrix.length) {
            return false;
        }

        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                if (firstMatrix[i].length != secondMatrix[i].length) {
                    return false;
                }
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    return false;
                }
            }
        }


        return true;
    }

    private static int[][] readMatrix(int cols, int rows, Scanner scanner) {

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine()
                            .split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = arr;

        }
        return matrix;
    }
}
