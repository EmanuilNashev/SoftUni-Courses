package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int matrixSize = Integer.parseInt(scanner.nextLine());

        int[][] matrix = readMatrix(matrixSize, scanner);

        int[][] matrixDiagonals = getMatrixDiagonals(matrix, matrixSize);

        printDiagonals(matrixDiagonals);
    }

    private static void printDiagonals(int[][] matrixDiagonals) {
        for (int[] matrixDiagonal : matrixDiagonals) {
            for (int i : matrixDiagonal) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getMatrixDiagonals(int[][] matrix, int matrixSize) {
        int[][] matrixDiagonals = new int[2][matrixSize];

        int[] diagonalNumbers = new int[matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            for (int col = row; col < row + 1; col++) {
                diagonalNumbers[row] = matrix[row][col];
            }
        }
        matrixDiagonals[0] = diagonalNumbers;
        diagonalNumbers = new int[matrixSize];

        int index = 0;
        for (int row = matrixSize - 1; row >= 0; row--) {
            for (int col = index; col < index + 1; col++) {
                diagonalNumbers[col] = matrix[row][col];
            }
            index++;
        }
        matrixDiagonals[1] = diagonalNumbers;

        return matrixDiagonals;
    }

    private static int[][] readMatrix(int matrixSize, Scanner scanner) {
        int[][] matrix = new int[matrixSize][matrixSize];

        for (int row = 0; row < matrixSize; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }
        return matrix;
    }
}
