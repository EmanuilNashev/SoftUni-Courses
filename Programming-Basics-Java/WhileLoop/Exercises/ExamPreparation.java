package WhileLoop.Exercises;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countBadGrades = Integer.parseInt(scanner.nextLine());
        String nameOfTasks = scanner.nextLine();
        int countTasks = 0;
        int counterBadGrades = 0;
        boolean isBad = false;
        double totalGrades = 0;
        String lastProblem = "";

        while (!nameOfTasks.equals("Enough")){
            int grade = Integer.parseInt(scanner.nextLine());

            countTasks ++;
            totalGrades += grade;
            lastProblem = nameOfTasks;
            if (grade <= 4){
                counterBadGrades ++;
            }
            if (counterBadGrades >= countBadGrades){
                isBad = true;
                break;
            }



            nameOfTasks = scanner.nextLine();

        }

            double averageGrade = totalGrades / countTasks;
            if (isBad){
                System.out.printf("You need a break, %d poor grades.", counterBadGrades);
            }else{
                System.out.printf("Average score: %.2f%n", averageGrade);
                System.out.printf("Number of problems: %d%n", countTasks);
                System.out.printf("Last problem: %s", lastProblem);
            }

    }
}
