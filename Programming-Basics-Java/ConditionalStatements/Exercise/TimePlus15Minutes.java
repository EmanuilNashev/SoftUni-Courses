package ConditionalStatements.Exercises;

import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour = Integer.parseInt(scanner.nextLine());
        int minute = Integer.parseInt(scanner.nextLine());
        int hourInMin = hour * 60;
        int HourAndMin = hourInMin + minute + 15;
        int A = HourAndMin / 60;
        int B = HourAndMin % 60;
        if(A > 23){
            A = 0;
        }
        System.out.printf("%d:%02d", A, B);
    }
}
