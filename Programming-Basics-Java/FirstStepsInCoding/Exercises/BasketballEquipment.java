package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class BasketballEquipment {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int fee = Integer.parseInt(scanner.nextLine());
        double sneakers = fee - fee * 0.4;
        double outfit = sneakers - sneakers * 0.2;
        double ball = outfit / 4;
        double accessories = ball / 5;
        System.out.println(fee + sneakers + outfit + ball + accessories);
    }
}
