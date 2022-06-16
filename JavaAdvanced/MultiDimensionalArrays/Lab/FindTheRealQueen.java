package MultidimensionalArrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[][] matrix = readMatrix(scanner);
        int rows = 8;
        int cols = 8;
        String queen = "q";

        int[] rowAndCol = new int[2];
        int[] validQueen = new int[2];

        boolean isVerticalAttack;
        boolean isDiagonalsCheck;
        int queensCountInHorizontal = 0;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col].equals("q")) {
                    queensCountInHorizontal++;
                    rowAndCol[0] = row;
                    rowAndCol[1] = col;
                }

                if (queensCountInHorizontal >= 2) {
                    queensCountInHorizontal = 0;
                    rowAndCol = new int[2];
                    break;
                }
            }
            //horizontal check
            if (queensCountInHorizontal == 1) {
                queensCountInHorizontal = 0;
                isVerticalAttack = verticalCheck(matrix, rowAndCol, queen);

                // vertical check
                if (isVerticalAttack) {

                    //diagonals check
                    isDiagonalsCheck = diagonalsCheck(matrix, rowAndCol, queen);
                    if (isDiagonalsCheck){
                        validQueen[0] = rowAndCol[0];
                        validQueen[1] = rowAndCol[1];
                        break;
                    }
                }
            }


        }


        printValidQueen(validQueen);
    }


    private static boolean diagonalsCheck(String[][] matrix, int[] rowAndCol, String queen) {
        //top to bot and left to right check
        int index = rowAndCol[1] + 1;
        for (int row = rowAndCol[0] + 1; row < 8; row++) {
            if (index > 7) {
                break;
            }
            for (int col = index; col < index + 1; col++) {
                if (matrix[row][col].equals(queen)) {
                    return false;
                }
            }
            index++;
        }

        //bot to top and right to left check
        int index2 = rowAndCol[1] - 1;
        for (int row = rowAndCol[0] - 1; row >= 0; row--) {
            if (index2 < 0) {
                break;
            }
            for (int col = index2; col > index2 - 1; col--) {
                if (matrix[row][col].equals(queen)) {
                    return false;
                }
            }
            index2--;
        }

        //bot to top and left to right check
        int index3 = rowAndCol[1] + 1;
        for (int row = rowAndCol[0] - 1; row >= 0; row--) {
            if (index3 > 7) {
                break;
            }
            for (int col = index3; col < index3 + 1; col++) {
                if (matrix[row][col].equals(queen)) {
                    return false;
                }
            }
            index3++;
        }

        //top to bot and right to left check
        int index4 = rowAndCol[1] - 1;
        for (int row = rowAndCol[0] + 1; row < 8; row++) {
            if (index4 < 0) {
                break;
            }
            for (int col = index4; col > index4 - 1; col--) {
                if (matrix[row][col].equals(queen)) {
                    return false;
                }
            }
            index4--;
        }
        return true;
    }

    private static boolean verticalCheck(String[][] matrix, int[] rowAndCol, String queen) {
        for (int row = 0; row < 8; row++) {
            for (int col = rowAndCol[1]; col < rowAndCol[1] + 1; col++) {
                if (row == rowAndCol[0]) {
                    continue;
                }
                if (matrix[row][col].equals(queen)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printValidQueen(int[] validQueen) {
        for (int i : validQueen) {
            System.out.print(i + " ");
        }
    }

    private static String[][] readMatrix(Scanner scanner) {
        String[][] matrix = new String[8][8];

        for (int row = 0; row < 8; row++) {
            String[] arr = scanner.nextLine().split("\\s+");
            matrix[row] = arr;
        }
        return matrix;
    }
}
