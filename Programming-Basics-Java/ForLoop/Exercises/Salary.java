package ForLoop.Exercises;

import java.util.Scanner;

public class Salary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countBrowsers = Integer.parseInt(scanner.nextLine());
        int salary = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countBrowsers; i++) {
            if (salary > 0) {
                String nameOfBrowsers = scanner.nextLine();

                if (nameOfBrowsers.equals("Facebook")) {
                    salary -= 150;
                } else if (nameOfBrowsers.equals("Instagram")) {
                    salary -= 100;
                } else if (nameOfBrowsers.equals("Reddit")) {
                    salary -= 50;
                }
            }
        }
        if (salary <= 0) {
            System.out.printf("You have lost your salary.");
        } else {
            System.out.println(salary);
        }
    }
}
