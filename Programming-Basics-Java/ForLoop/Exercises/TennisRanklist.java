package ForLoop.Exercises;

import java.util.Scanner;

public class TennisRanklist {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countTournaments = Integer.parseInt(scanner.nextLine());
        int startingPoints = Integer.parseInt(scanner.nextLine());

        double averagePoints = 0;
        double countWins = 0;

        for (int i = 1; i <= countTournaments; i++) {
            String stageOfTournament = scanner.nextLine();

            if (stageOfTournament.equals("W")) {
                countWins ++;
                averagePoints += 2000;
            } else if (stageOfTournament.equals("F")){
                averagePoints += 1200;
            }else if (stageOfTournament.equals("SF")){
                averagePoints += 720;
            }


        }
        double finalPoints = startingPoints +averagePoints;
        averagePoints = Math.floor(averagePoints / countTournaments);
        double percentWinTournaments = (countWins / countTournaments) * 100;

        System.out.printf("Final points: %.0f%n", finalPoints);
        System.out.printf("Average points: %.0f%n", averagePoints);
        System.out.printf("%.2f%%", percentWinTournaments);

    }
}
