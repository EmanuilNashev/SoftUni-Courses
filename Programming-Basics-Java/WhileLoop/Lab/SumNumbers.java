package WhileLoop.Lab;

import java.util.Scanner;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int sum = 0;


        while (sum < num){
            int sumNumber = Integer.parseInt(scanner.nextLine());

            sum += sumNumber;
        }
        System.out.println(sum);
    }
}
