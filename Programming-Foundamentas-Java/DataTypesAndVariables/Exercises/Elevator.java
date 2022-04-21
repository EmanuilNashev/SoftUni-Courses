package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class Elevator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int people = Integer.parseInt(scanner.nextLine());
        int capacity = Integer.parseInt(scanner.nextLine());

        int sum = people;
        int countCourses = 0;
        while (true) {
            if (sum <= 0) {
                break;
            }
            sum = sum - capacity;
            countCourses++;

        }
        System.out.print(countCourses);
    }
}
