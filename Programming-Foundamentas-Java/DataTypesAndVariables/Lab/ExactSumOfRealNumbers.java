package DataTypesAndVariables.Lab;

import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());


        double sum = 0;
        BigDecimal bigDecimal = new BigDecimal(sum);
        for (int i = 0; i < n; i++) {
            BigDecimal num = new BigDecimal(scanner.nextLine());


            bigDecimal = bigDecimal.add(num);


        }


        System.out.println(bigDecimal);
    }
}
