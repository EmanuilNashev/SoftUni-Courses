package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] matrixParameters = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

        int rows = matrixParameters[0];
        int cols = matrixParameters[1];

        int[][] matrix = readMatrix(rows, cols, scanner);

        int sumOfMatrixElements = getSum(matrix);

        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sumOfMatrixElements);
    }

    private static int getSum(int[][] matrix) {
        int sum = 0;

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        return sum;
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(",\\s+")).mapToInt(Integer::parseInt).toArray();

            matrix[row] = arr;
        }
        return matrix;
    }
}
