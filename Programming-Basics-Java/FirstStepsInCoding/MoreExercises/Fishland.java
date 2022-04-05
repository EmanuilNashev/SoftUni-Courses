package FirstStepsInCoding.MoreExcersiseForPractise;

import java.util.Scanner;

public class Fishland {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double priceOfMackerel = Double.parseDouble(scanner.nextLine());
        double priceOfToy = Double.parseDouble(scanner.nextLine());
        double kilogramsBonito = Double.parseDouble(scanner.nextLine());
        double kilogramsHorseMackerel = Double.parseDouble(scanner.nextLine());
        int kilogramsMussels = Integer.parseInt(scanner.nextLine());
        double priceOfBonito = priceOfMackerel + priceOfMackerel * 0.60;
        double sumBonito = kilogramsBonito * priceOfBonito;
        double priceOfHorseMackerel = priceOfToy + priceOfToy * 0.80;
        double sumHorseMackerel = kilogramsHorseMackerel * priceOfHorseMackerel;
        double priceOfMussels = kilogramsMussels * 7.50;
        double allSum = sumBonito + sumHorseMackerel + priceOfMussels;
        System.out.printf("%.2f", allSum);
    }
}
