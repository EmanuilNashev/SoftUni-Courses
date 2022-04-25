package Arrays.MoreExercises;

import java.util.Arrays;
import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            if (i >1){
                numbers[i] =numbers[i - 1] + numbers[i-2];
            }else {
                numbers[i] = 1;
            }
        }
        if (numbers.length >0){
            System.out.println(numbers[numbers.length-1]);
        }else {
            System.out.println(0);
        }
    }
}
