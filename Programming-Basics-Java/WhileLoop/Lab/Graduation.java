package WhileLoop.Lab;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int countBadGrades = 0;
        int count = 1;
        double sumGrade = 0;
        double grade = 0;

        while (count <= 12) {
            grade = Double.parseDouble(scanner.nextLine());
            sumGrade += grade;

            if (grade < 4) {

                System.out.printf("%s has been excluded at %d grade", name, count  );
                break;
            }


            count++;
        }
        double totalGrade = sumGrade / 12;
        if (grade >= 4){
            System.out.printf("%s graduated. Average grade: %.2f", name, totalGrade);
        }
    }
}

