package NestedLoops.Exercises;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPeople = Integer.parseInt(scanner.nextLine());

        String input = scanner.nextLine();
        double sumFinalGrade = 0;
        int countFinalGrade = 0;

        while (!input.equals("Finish")) {
            String nameOfPresentation = input;

            double sumGrade = 0;

            for (int i = 1; i <= countPeople; i++) {
                double grade = Double.parseDouble(scanner.nextLine());
                sumGrade += grade;

            }
            double averageGrade = sumGrade / countPeople;
            sumFinalGrade += averageGrade;
            countFinalGrade++;
            System.out.printf("%s - %.2f.%n", nameOfPresentation, averageGrade);

                    input = scanner.nextLine();
        }
        double finalGrade = sumFinalGrade / countFinalGrade;
        System.out.printf("Student's final assessment is %.2f.", finalGrade);
    }
}
