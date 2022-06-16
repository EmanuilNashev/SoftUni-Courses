package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //readInput
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(rows, scanner);
        int[] wrongValuePosition = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = wrongValuePosition[0];
        int col = wrongValuePosition[1];
        int wrongValue = matrix[row][col];

        findAndReplaceValuesThenPrintModifiedMatrix(matrix, wrongValue);

    }


//            0 1 2
//        0 - 1 2 4
//        1 - 4 6 7
//        2 - 8 9 4


    private static void findAndReplaceValuesThenPrintModifiedMatrix(int[][] matrix, int wrongValue) {
        Map<int[], Integer> indexesAndValues = new HashMap<>();

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int element = matrix[row][col];
                int sum = 0;

                if (element == wrongValue) {
                    if (row - 1 > -1) {
                        if (matrix[row - 1][col] != wrongValue) {
                            sum += matrix[row - 1][col];
                        }
                    }
                    if (col - 1 > -1) {
                        if (matrix[row][col - 1] != wrongValue) {
                            sum += matrix[row][col - 1];
                        }
                    }
                    if (row + 1 < matrix.length) {
                        if (matrix[row + 1][col] != wrongValue) {
                            sum += matrix[row + 1][col];
                        }
                    }
                    if (col + 1 < matrix[row].length) {
                        if (matrix[row][col + 1] != wrongValue) {
                            sum += matrix[row][col + 1];
                        }
                    }

                    int[] indexes = {row, col};
                    indexesAndValues.put(indexes, sum);
//                    matrix[row][col] = sum;
                }
            }
        }

        for (Map.Entry<int[], Integer> integerEntry : indexesAndValues.entrySet()) {
            matrix[integerEntry.getKey()[0]][integerEntry.getKey()[1]] = integerEntry.getValue();
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] modifiedMatrix) {
        for (int[] ints : modifiedMatrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] readMatrix(int rows, Scanner scanner) {
        int[][] matrix = new int[rows][];

        for (int row = 0; row < rows; row++) {
            int[] arr = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            matrix[row] = arr;
        }
        return matrix;
    }
}
