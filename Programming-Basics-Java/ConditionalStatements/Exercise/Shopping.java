package ConditionalStatements.Exercises;

import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double budget = Double.parseDouble(scanner.nextLine());
        int videoCards = Integer.parseInt(scanner.nextLine());
        int processors = Integer.parseInt(scanner.nextLine());
        int ramMemory = Integer.parseInt(scanner.nextLine());
        double sumVideoCards = videoCards * 250;
        double sumProcessors = processors * (sumVideoCards * 0.35);
        double sumRamMemory = ramMemory * (sumVideoCards * 0.1);
        double allSum = sumVideoCards + sumProcessors + sumRamMemory;
        if(videoCards > processors){
             allSum = allSum - (allSum * 0.15);
        }
        double count = Math.abs(budget - allSum);
        if( budget >= allSum){
            System.out.printf("You have %.2f leva left!", count);
        }
        else {
            System.out.printf("Not enough money! You need %.2f leva more!", count);
        }
    }
}
