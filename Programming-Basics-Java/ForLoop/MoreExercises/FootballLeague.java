package ForLoop.MoreExercises;

import java.util.Scanner;

public class FootballLeague {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int capacityOfStadium = Integer.parseInt(scanner.nextLine());
        int countAllFans = Integer.parseInt(scanner.nextLine());
        double countFansInSectorA = 0;
        double countFansInSectorB = 0;
        double countFansInSectorV = 0;
        double countFansInSectorG = 0;

        for (int i = 1; i <= countAllFans; i++) {
            String sector = scanner.nextLine();

            if (sector.equals("A")) {
                countFansInSectorA++;
            } else if (sector.equals("B")) {
                countFansInSectorB++;
            } else if (sector.equals("V")) {
                countFansInSectorV++;
            } else if (sector.equals("G")) {
                countFansInSectorG++;
            }

        }
        countFansInSectorA = countFansInSectorA / countAllFans * 100;
        countFansInSectorB = countFansInSectorB / countAllFans * 100;
        countFansInSectorV = countFansInSectorV / countAllFans * 100;
        countFansInSectorG = countFansInSectorG / countAllFans * 100;
        double percentCountAllFans = countAllFans * 1.0 / capacityOfStadium * 100;

        System.out.printf("%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%%n%.2f%%", countFansInSectorA, countFansInSectorB, countFansInSectorV, countFansInSectorG, percentCountAllFans);
    }
}
