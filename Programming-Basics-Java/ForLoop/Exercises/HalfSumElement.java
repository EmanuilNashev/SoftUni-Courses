package ForLoop.Exercises;

import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int maxNum = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            sum += num;
            if (num > maxNum){
                maxNum = num;
            }

        }
        int realSum = sum - maxNum;

        int diff = Math.abs(realSum - maxNum);

        if (realSum == maxNum){
            System.out.println("Yes");
            System.out.println("Sum = " + maxNum);
        }else{
            System.out.println("No");
            System.out.printf("Diff = %d", diff);
        }
    }
}
