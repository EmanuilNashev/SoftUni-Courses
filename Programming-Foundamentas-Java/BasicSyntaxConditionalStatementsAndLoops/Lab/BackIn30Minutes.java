package BasicSyntaxConditionalStatementsAndLoops.Lab;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int hoursLikeMinutes = hours * 60;

        int totalTime = hoursLikeMinutes + minutes;

        for (int i = 0; i < 30 ; i++) {
            minutes++;
            if (minutes == 60){
                minutes = 0;
                hours++;
            }
            if (hours == 24){
                hours = 0;
            }

        }


        System.out.printf("%d:%02d", hours, minutes);
    }
}
