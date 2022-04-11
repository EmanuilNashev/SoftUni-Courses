package WhileLoop.Exercises;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        int totalSteps = 0;
        boolean isReached = false;

        while (!input.equals("Going home")){
            int steps = Integer.parseInt(input);

            totalSteps += steps;

            if (totalSteps >= 10000){
                isReached = true;
                break;
            }

            input = scanner.nextLine();
        }
        if (input.equals("Going home")){
            int stepsToHome = Integer.parseInt(scanner.nextLine());
            totalSteps += stepsToHome;
            if (totalSteps < 10000){
                int diff = Math.abs(totalSteps - 10000);
                System.out.printf("%d more steps to reach goal.", diff);
            }else{
                isReached = true;
            }
        }
        if (isReached){
            int diff = Math.abs(totalSteps - 10000);
            System.out.printf("Goal reached! Good job!%n%d steps over the goal!", diff);
        }
    }
}
