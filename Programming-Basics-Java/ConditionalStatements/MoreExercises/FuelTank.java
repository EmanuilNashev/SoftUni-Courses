package ConditionalStatements.MoreExcersisesForPractice;

import java.util.Scanner;

public class FuelTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String typeFuel = scanner.nextLine();
        double litresFuel = Double.parseDouble(scanner.nextLine());

        if (litresFuel >= 25){
            switch (typeFuel){
                case "Diesel" :
                    System.out.println("You have enough diesel.");
                    break;
                case "Gasoline" :
                    System.out.println("You have enough gasoline.");
                    break;
                case "Gas" :
                    System.out.println("You have enough gas.");
                    break ;
                default: System.out.println("Invalid fuel!");
                break;
            }
        }else if (litresFuel < 25){
            switch (typeFuel){
                case "Diesel" :
                    System.out.println("Fill your tank with diesel!");
                    break;
                case "Gasoline" :
                    System.out.println("Fill your tank with gasoline!");
                    break;
                case "Gas" :
                    System.out.println("Fill your tank with gas!");
                    break;
                default: System.out.println("Invalid fuel!");
                break;
            }
        }
    }
}
