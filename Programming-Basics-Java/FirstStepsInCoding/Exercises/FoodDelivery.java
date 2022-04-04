package FirstStepsInCoding.Exercises;

import java.util.Scanner;

public class FoodDelivery {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int chicken = Integer.parseInt(scanner.nextLine());
        int fish = Integer.parseInt(scanner.nextLine());
        int vegan = Integer.parseInt(scanner.nextLine());
        double chickenPrize = chicken * 10.35;
        double fishPrize = fish * 12.40;
        double veganPrize = vegan * 8.15;
        double sumForFood = chickenPrize + fishPrize + veganPrize;
        double dessert = sumForFood * 0.2;
        System.out.println(sumForFood + dessert + 2.50);
    }
}
