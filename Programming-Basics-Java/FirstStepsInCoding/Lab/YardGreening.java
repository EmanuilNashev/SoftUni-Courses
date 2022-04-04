package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class YardGreening {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double squareMeters = Double.parseDouble(scanner.nextLine());
        double commonResult = squareMeters * 7.61;
        double discount = commonResult * 0.18;
        double resultDiscount = commonResult - discount;
        String describeFinalPrize = "The final prize is: ";
        String describeDiscount = "The discount is: ";
        String currency = " lv." ;
        System.out.println(describeFinalPrize + resultDiscount + currency);
        System.out.println(describeDiscount + discount + currency);
    }
}
