package Arrays.Exercises;

import java.util.Scanner;

public class MagicSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");
        int num = Integer.parseInt(scanner.nextLine());

        int[] numbers = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }

        String equalsPairsLikeString = "";
        int countPairs = 0;

        for (int i = 0; i < numbers.length ; i++) {
            for (int j = i; j < numbers.length; j++) {

                if (i != j) {
                    if (numbers[i] + numbers[j] == num) {
                        System.out.print(numbers[i] + " " + numbers[j]);
                        System.out.println();
                    }

                }

            }
        }

    }
}
