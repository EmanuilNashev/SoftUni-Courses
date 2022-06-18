package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int rows = dimensions[0];
        int cols = dimensions[1];

        String[][] matrix = getMatrix(scanner, rows, cols);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] data = input.split("\\s+");

            if (data.length != 5){
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }
            String command = data[0];
            int r1 = Integer.parseInt(data[1]);
            int c1 = Integer.parseInt(data[2]);
            int r2 = Integer.parseInt(data[3]);
            int c2 = Integer.parseInt(data[4]);
            boolean isValidData = command.equals("swap") && (r1 >= 0 && r1 < rows)
                    && (r2 >= 0 && r2 < rows) && (c1 >= 0 && c1 < cols) && (c2 >= 0 && c2 < cols);

            if (!isValidData) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            }

            swapElementsOfMatrixAndPrint(matrix, r1, c1, r2, c2);



            input = scanner.nextLine();
        }
    }

    private static void swapElementsOfMatrixAndPrint(String[][] matrix, int r1, int c1, int r2, int c2) {
        String oldElement = matrix[r1][c1];
        matrix[r1][c1] = matrix[r2][c2];
        matrix[r2][c2] = oldElement;

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    private static String[][] getMatrix(Scanner scanner, int rows, int cols) {
        String[][] matrix = new String[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] arr = scanner.nextLine().split("\\s+");

            matrix[row] = arr;
        }
        return matrix;
    }
}
