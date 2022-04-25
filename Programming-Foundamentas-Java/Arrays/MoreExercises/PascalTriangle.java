package Arrays.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int currentNum = 0;
        int frontInt = 0;
        int sum = 0;

        int[] sums = new int[0];

        for (int row = 1; row <= n; row++) {
            int[] numbers = new int[row];


            if (sums.length > 0){
                for (int i = 0; i < numbers.length; i++) {

                    if (i < sums.length){
                        numbers[i] = sums[i];
                    }else {
                        numbers[i] = 1;
                    }
                }
            }

            sums = new int[row];
            numbers[0] = 1;
            for (int column = 0; column < row; column++) {
                System.out.print(numbers[column] + " ");


                currentNum = numbers[column];
                if (column > 0) {
                    frontInt = numbers[column - 1];
                }
                sum = currentNum + frontInt;
                sums[column] = sum;

                frontInt=0;

            }


            System.out.println();
        }
    }
}
