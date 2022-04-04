package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class PetShop {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int numbersOfDogsFood = Integer.parseInt(scanner.nextLine());
        int numberOfCatsFood = Integer.parseInt(scanner.nextLine());
        double costsOfDogsFoot = numbersOfDogsFood * 2.50;
        int costsOfCatFoot = numberOfCatsFood * 4;
        double costOfCatsAndDogsFoot = costsOfDogsFoot + costsOfCatFoot;
        System.out.println(costOfCatsAndDogsFoot + " lv.");
    }
}
