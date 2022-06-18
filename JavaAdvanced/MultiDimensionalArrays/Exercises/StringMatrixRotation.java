package MultidimensionalArrays.Exercises;

import java.util.*;

public class StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        int maxWordLength = Integer.MIN_VALUE;
        List<String> words = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String word = input;

            if (word.length() > maxWordLength) {
                maxWordLength = word.length();
            }
            words.add(word);

            input = scanner.nextLine();
        }
        int rows = words.size();
        int cols = maxWordLength;

        char[][] matrix = new char[rows][cols];

        //fillTheMatrix
        for (int row = 0; row < rows; row++) {
            String currentWord = words.get(row);
            for (int col = 0; col < cols; col++) {
                if (col < currentWord.length()) {
                    char currentChar = currentWord.charAt(col);
                    matrix[row][col] = currentChar;
                } else {
                    matrix[row][col] = ' ';
                }
            }
        }

        int angle = Integer.parseInt(command.split("[()]")[1]);
        int angleOfRotation = angle % 360;

        //rotateMatrix
        switch (angleOfRotation) {
            case 0:
                printMatrix(matrix);
                break;
            case 90:
                printMatrixRotatedOn90(matrix,rows,cols);
                break;
            case 180:
                printMatrixRotatedOn180(matrix,rows,cols);
                break;
            case 270:
                printMatrixRotatedOn270(matrix,rows,cols);
                break;
        }
        System.out.println("");
    }

    private static void printMatrixRotatedOn270(char[][] matrix, int rows, int cols) {
        for (int col = cols - 1; col >= 0; col--) {
            for (int row = 0; row < rows; row++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrixRotatedOn180(char[][] matrix, int rows, int cols) {
        for (int row = rows - 1; row >= 0; row--) {
            for (int col = cols - 1; col >= 0; col--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrixRotatedOn90(char[][] matrix, int rows, int cols) {
        for (int col = 0; col < cols; col++) {
            for (int row = rows - 1; row >=0; row--) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void printMatrix(char[][] matrix) {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }
}
