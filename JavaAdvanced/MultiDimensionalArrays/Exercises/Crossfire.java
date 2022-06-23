package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = new int[rows][cols];
        fillMatrix(matrix, rows, cols);


        String input = scanner.nextLine();
        while (!input.equals("Nuke it from orbit")) {
            int[] bomb = Arrays.stream(input.split("\\s+")).mapToInt(Integer::parseInt).toArray();

            int bombRow = bomb[0];
            int bombCol = bomb[1];
            int bombRadius = bomb[2];

            //bomb rows
            for (int row = bombRow - bombRadius; row <= bombRow + bombRadius; row++) {
                boolean isValid =  row >= 0 && row < matrix.length && bombCol >= 0 && bombCol < matrix[row].length;
                if (isValid) {
                    matrix[row][bombCol] = 0;
                }
            }

            //bomb cols
            for (int col = bombCol - bombRadius; col <= bombCol + bombRadius; col++) {
                boolean isValid = bombRow >= 0 && bombRow < matrix.length  && col >= 0 && col < matrix[bombRow].length;

                if (isValid) {
                    matrix[bombRow][col] = 0;
                }
            }

            //delete matrix elements
            deleteElInMatrix(matrix);

            matrix = reworkMatrix(matrix);


            input = scanner.nextLine();
        }

        printMatrix(matrix);
    }

    private static int[][] reworkMatrix(int[][] matrix) {
        int countDeadRows = 0;
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row].length == 0) {
                countDeadRows++;

            }
        }

        if (countDeadRows > 0) {

            int rowIndex = 0;
            int[][] newMatrix = new int[matrix.length - countDeadRows][];
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row].length == 0) {
                    continue;
                }

                int[] arr = new int[matrix[row].length];
                for (int col = 0; col < matrix[row].length; col++) {
                    arr[col] = matrix[row][col];
                }
                newMatrix[rowIndex++] = arr;
            }

            return Arrays.copyOf(newMatrix, newMatrix.length);
        }

        return matrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static void deleteElInMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            int[] newArr = new int[matrix[row].length];
            int zeroCountCount = 0;
            for (int col = 0; col < matrix[row].length; col++) {
                if (matrix[row][col] == 0) {
                    zeroCountCount++;
                    continue;
                }

                newArr[col] = matrix[row][col];
            }

            matrix[row] = new int[matrix[row].length - zeroCountCount];


            int index = 0;
            for (int i = 0; i < newArr.length; i++) {
                if (newArr[i] != 0) {
                    matrix[row][index++] = newArr[i];
                }
            }


            if (zeroCountCount == 0) {
                //create new matrix

            }


        }
    }

    private static void fillMatrix(int[][] matrix, int rows, int cols) {
        int increasingValue = 1;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = increasingValue++;
            }
        }
    }
}
