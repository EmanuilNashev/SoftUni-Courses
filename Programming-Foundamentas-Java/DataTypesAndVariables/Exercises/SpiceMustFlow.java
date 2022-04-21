package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startingYield = Integer.parseInt(scanner.nextLine());

        byte countDays = 0;
        int totalYield = 0;
        int currentDayYield = startingYield;
        int totalSpice = 0;

        while (currentDayYield >= 100){
            countDays++;




            totalSpice += currentDayYield;

            totalSpice -= 26;

            currentDayYield -= 10;
        }
        if (totalSpice >= 26){
            totalSpice -= 26;

        }
        System.out.println(countDays);
        System.out.println(totalSpice);
    }
}
