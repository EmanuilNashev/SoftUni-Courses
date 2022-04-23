package Arrays.Lab;

import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfDay = Integer.parseInt(scanner.nextLine());

        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        if (numberOfDay > 0 && numberOfDay < 8){
            System.out.println(weekDays[numberOfDay - 1]);
        }else{
            System.out.println("Invalid day!");
        }
    }
}
