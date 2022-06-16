package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumSumOf2x2SubMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = readMatrix(rows, cols, scanner);

        int[][] resultMatrix = getMatrix(rows, cols, matrix);
        int maxSum = getMaxSum(rows, cols, matrix);

        String output = getOutput(resultMatrix, maxSum);
        System.out.println(output);
    }

    private static String getOutput(int[][] resultMatrix, int maxSum) {
        StringBuilder output = new StringBuilder();
        for (int[] ints : resultMatrix) {
            for (int anInt : ints) {
                output.append(anInt);
                output.append(" ");
            }
            output.append(System.lineSeparator());
        }
        output.append(maxSum);
        return output.toString();
    }

    private static int[][] getMatrix(int rows, int cols, int[][] matrix) {
        int[][] resultMatrix = new int[2][2];

        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                sum += matrix[row - 1][col - 1] + matrix[row - 1][col] + matrix[row][col - 1] + matrix[row][col];

                if (sum > maxSum) {
                    maxSum = sum;
                    resultMatrix[0][0] = matrix[row - 1][col - 1];
                    resultMatrix[0][1] = matrix[row - 1][col];
                    resultMatrix[1][0] = matrix[row][col - 1];
                    resultMatrix[1][1] = matrix[row][col];
                }
                sum = 0;
            }
        }
        return resultMatrix;
    }

    private static int getMaxSum(int rows, int cols, int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                sum += matrix[row - 1][col - 1] + matrix[row - 1][col] + matrix[row][col - 1] + matrix[row][col];

                if (sum > maxSum) {
                    maxSum = sum;
                }
                sum = 0;
            }
        }
        return maxSum;
    }

    private static int[][] readMatrix(int rows, int cols, Scanner scanner) {
        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split(",\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }
        return matrix;
    }
}
