package ForLoop.MoreExercises;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countStudents = Integer.parseInt(scanner.nextLine());
        double studentsGrade2 = 0;
        double studentsGrade3 = 0;
        double studentsGrade4 = 0;
        double studentsGradeMoreThan5 = 0;
        double averageGrade = 0;

        for (int i = 1; i <= countStudents; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            averageGrade += grade;

            if (grade >= 2 && grade <= 2.99) {
                studentsGrade2++;
            } else if (grade >= 3 && grade <= 3.99) {
                studentsGrade3++;
            } else if (grade >= 4 && grade <= 4.99) {
                studentsGrade4++;
            } else if (grade >= 5) {
                studentsGradeMoreThan5++;
            }


        }
        studentsGrade2 = studentsGrade2 / countStudents * 100;
        studentsGrade3 = studentsGrade3 / countStudents * 100;
        studentsGrade4 = studentsGrade4 / countStudents * 100;
        studentsGradeMoreThan5 = studentsGradeMoreThan5 / countStudents * 100;
        averageGrade = averageGrade / countStudents;

        System.out.printf("Top students: %.2f%%%nBetween 4.00 and 4.99: %.2f%%%nBetween 3.00 and 3.99: %.2f%%%nFail: %.2f%%%nAverage: %.2f",
                studentsGradeMoreThan5, studentsGrade4, studentsGrade3, studentsGrade2, averageGrade);


    }
}
