package ConditionalStatements.MoreExcersisesForPractice;

import java.util.Scanner;

public class SleepyTomCat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numHolidays = Integer.parseInt(scanner.nextLine());

        int minPlayInHolidays = numHolidays * 127;
        int minPlayInWorkingDays = (365 - numHolidays) * 63;
        int totalMinPlay = minPlayInHolidays + minPlayInWorkingDays;
        int leftMin = Math.abs(30000 - totalMinPlay);
        int hours = leftMin / 60;
        int min = leftMin % 60;

        if(30000 > totalMinPlay){
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", hours, min);
        }
        else{
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", hours, min);
        }
    }
}
