package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int num3 = num;
        int sum = 0;
        while (true){
            int num2 = num3 % 10;
            sum += num2;
            num3 = num3 / 10;

            if (num3 == 0){
                break;
            }
        }
        System.out.println(sum);

    }
}
