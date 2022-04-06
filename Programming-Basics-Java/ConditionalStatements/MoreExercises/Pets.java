package ConditionalStatements.MoreExcersisesForPractice;

import java.util.Scanner;

public class Pets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countDays = Integer.parseInt(scanner.nextLine());
        int totalFood = Integer.parseInt(scanner.nextLine());
        double foodForDogInKG = Double.parseDouble(scanner.nextLine());
        double foodForCatInKG = Double.parseDouble(scanner.nextLine());
        double foodForTurtleGrams = Double.parseDouble(scanner.nextLine());
        double foodForTurtleKG = foodForTurtleGrams / 1000;

        double dogNeedsFood = countDays * foodForDogInKG;
        double catNeedsFood = countDays * foodForCatInKG;
        double turtleNeedsFood = countDays * foodForTurtleKG;

        double totalAnimalFood = dogNeedsFood + catNeedsFood + turtleNeedsFood;

        if(totalAnimalFood <= totalFood){
            double residue = Math.floor(totalFood - totalAnimalFood);
            System.out.printf("%.0f kilos of food left.", residue);
        }else{
            double residue = Math.ceil(totalAnimalFood - totalFood);
            System.out.printf("%.0f more kilos of food are needed.", residue);
        }
    }
}
