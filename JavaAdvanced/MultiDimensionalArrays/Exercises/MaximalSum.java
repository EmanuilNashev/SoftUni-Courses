package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixSize = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = matrixSize[0];
        int cols = matrixSize[1];

        int[][] matrix = readMatrix(scanner, rows, cols);


        int maxSum = Integer.MIN_VALUE;
        int[][] squareMatrixWithMaxValue = new int[3][3];

        int sum = 0;
        for (int row = 0; row < rows - 2; row++) {
            for (int col = 0; col < cols - 2; col++) {
                sum = getSum(matrix, row, col);

                if (sum > maxSum) {
                    maxSum = sum;
                    squareMatrixWithMaxValue = getSquareMatrixWithBestValue(matrix, row, col);
                }
            }
        }
        System.out.println("Sum = " + maxSum);
        printTheMaxMatrix(squareMatrixWithMaxValue);
    }

    private static void printTheMaxMatrix(int[][] squareMatrixWithMaxValue) {
        for (int[] ints : squareMatrixWithMaxValue) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getSquareMatrixWithBestValue(int[][] matrix, int row, int col) {
        int[][] squareMatrix = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                squareMatrix[i][j] = matrix[row + i][col + j];
            }
        }

        return squareMatrix;
    }

    private static int getSum(int[][] matrix, int row, int col) {
        return matrix[row][col] + matrix[row][col + 1] + matrix[row][col + 2] + matrix[row + 1][col] + matrix[row + 1][col + 1]
                + matrix[row + 1][col + 2] + matrix[row + 2][col] + matrix[row + 2][col + 1] + matrix[row + 2][col + 2];
    }

    private static int[][] readMatrix(Scanner scanner, int rows, int cols) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }

        return matrix;
    }
}
