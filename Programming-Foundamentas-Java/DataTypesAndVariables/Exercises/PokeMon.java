package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());
        int M = Integer.parseInt(scanner.nextLine());
        int Y = Integer.parseInt(scanner.nextLine());
        int sum = N;
        int targetCount = 0;

        while (true) {
            sum = sum - M;
            targetCount++;
            if (sum == (N * 0.50) && Y != 0) {
                sum = sum / Y;
            }
            if (sum < M){
                break;
            }

        }
        System.out.println(sum);
        System.out.println(targetCount);
    }
}
