package RegularExpressions.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();
        Pattern pattern = Pattern.compile("[>]{2}(?<name>[A-Za-z]+)[<]{2}(?<price>[\\d.]+)[!](?<quantity>[\\d]+)");
        List<String> furnitureNames = new ArrayList<>();
        double totalPrice = 0;

        while (!line.equals("Purchase")){
            Matcher matcher = pattern.matcher(line);
            if (matcher.find()){
                furnitureNames.add(matcher.group("name"));
                totalPrice+= Double.parseDouble(matcher.group("price")) * Integer.parseInt(matcher.group("quantity"));
            }




            line = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        furnitureNames.forEach(System.out::println);
        System.out.println("Total money spend: " + String.format("%.2f", totalPrice));
    }
}
