package Functions.Lab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

public class AddVAT {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] prices = Arrays.stream(scanner.nextLine().split(",\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        UnaryOperator<Double> unaryOperator = price -> price * 1.2;

        System.out.println("Prices with VAT:");
        for (double price : prices) {
            System.out.printf("%.2f%n" ,unaryOperator.apply(price));
        }
    }
}
