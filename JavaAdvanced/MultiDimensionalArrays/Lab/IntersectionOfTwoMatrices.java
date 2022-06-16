package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        String[][] firstMatrix = readMatrix(rows, cols, scanner);
        String[][] secondMatrix = readMatrix(rows, cols, scanner);

        String[][] thirdMatrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (firstMatrix[row][col].equals(secondMatrix[row][col])) {
                    thirdMatrix[row][col] = firstMatrix[row][col];
                } else {
                    thirdMatrix[row][col] = "*";
                }
            }
        }

        for (String[] matrix : thirdMatrix) {
            for (String s : matrix) {
                System.out.print(s + " ");
            }
            System.out.println();
        }


    }

    private static String[][] readMatrix(int rows, int cols, Scanner scanner) {
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split("\\s+");

            matrix[row] = arr;
        }
        return matrix;
    }
}
