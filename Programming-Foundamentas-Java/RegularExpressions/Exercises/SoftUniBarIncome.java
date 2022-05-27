package RegularExpressions.Exercise;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SoftUniBarIncome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String regex = "[^%.$|]*[%](?<customer>[A-Z][a-z]+)%[^%.$|]*[<](?<product>[\\w]+)[>][^%.$|]*[|][^%.$|\\d]*" +
                "(?<count>[\\d]+[^%.$|\\d]*)[|][^%.$|\\d]*(?<price>[\\d]+([.][\\d])*)[$][^%.$|]*";
        String line = scanner.nextLine();
        double totalPrice = 0;
        while (!line.equals("end of shift")){
            String order = line;
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(order);

            if (matcher.find()){
                String customer = matcher.group("customer");
                String product = matcher.group("product");
                int count = Integer.parseInt(matcher.group("count"));
                double priceForOneProduct = Double.parseDouble(matcher.group("price"));
                double allPrice = count * priceForOneProduct;
                totalPrice+=allPrice;

                System.out.printf("%s: %s - %.2f%n", customer,product,allPrice);
            }



            line= scanner.nextLine();
        }
        System.out.println("Total income: " + String.format("%.2f", totalPrice));
    }
}
