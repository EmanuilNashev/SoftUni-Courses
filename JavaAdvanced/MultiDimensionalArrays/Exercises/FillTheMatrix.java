package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] data = scanner.nextLine().split(",\\s+");

        int matrixSize = Integer.parseInt(data[0]);
        String method = data[1];

        int[][] matrix = new int[matrixSize][matrixSize];

        switch (method) {
            case "A":
                matrix = fillMatrixInMethodA(matrixSize);
                break;
            case "B":
                matrix = fillMatrixInMethodB(matrixSize);
                break;
        }

        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }


    private static int[][] fillMatrixInMethodB(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        int value = 1;
        for (int rows = 0; rows < matrixSize; rows++) {
            for (int col = 0; col < matrixSize; col++) {
                matrix[col][rows] = value;

                value++;

                if (col == matrixSize - 1 && rows + 1 < matrixSize) {
                    rows++;
                    for (int c = col; c >= 0; c--) {
                        matrix[c][rows] = value;

                        value++;
                    }
                }
            }
        }


        return matrix;
    }


    private static int[][] fillMatrixInMethodA(int matrixSize) {
        int[][] matrix = new int[matrixSize][matrixSize];

        int value = 1;
        for (int row = 0; row < matrixSize; row++) {
            for (int col = 0; col < matrixSize; col++) {
                matrix[col][row] = value;


                value++;
            }
        }
        return matrix;
    }
}
