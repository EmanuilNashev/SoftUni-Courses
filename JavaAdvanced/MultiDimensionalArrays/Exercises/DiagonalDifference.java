package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(matrixSize, scanner);

        int firstDiagonalSum = getFirstDiagonal(matrix);
        int secondDiagonalSum = getSecondDiagonal(matrix);

        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));
    }

    private static int getSecondDiagonal(int[][] matrix) {
        int sum = 0;

        int rows = matrix.length;
        int cols = matrix.length;

        int index = 0;
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = index; col < index + 1; col++) {
                sum+= matrix[row][col];
            }
            index++;
        }

        return sum;
    }

    private static int getFirstDiagonal(int[][] matrix) {
        int sum = 0;

        int cols = matrix.length;
        int rows = matrix.length;

        for (int row = 0; row < rows; row++) {
            for (int col = row; col < row + 1; col++) {

                sum += matrix[row][col];
            }
        }


        return sum;
    }

    private static int[][] readMatrix(int matrixSize, Scanner scanner) {
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int i = 0; i < matrixSize; i++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[i] = arr;
        }

        return matrix;
    }
}
