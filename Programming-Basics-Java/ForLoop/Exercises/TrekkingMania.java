package ForLoop.Exercises;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countOfGroups = Integer.parseInt(scanner.nextLine());
        int totalPeople = 0;

        double musala = 0;
        double montBlanc = 0;
        double kilimanjaro = 0;
        double K2 = 0;
        double everest = 0;

        for (int i = 1; i <= countOfGroups; i++) {
            int countPeopleInGroup = Integer.parseInt(scanner.nextLine());
            totalPeople += countPeopleInGroup;

            if (countPeopleInGroup <= 5) {
                musala += countPeopleInGroup;
            } else if (countPeopleInGroup <= 12) {
                montBlanc += countPeopleInGroup;
            } else if (countPeopleInGroup <= 25){
                kilimanjaro += countPeopleInGroup;
            }else if (countPeopleInGroup <= 40){
                K2 += countPeopleInGroup;
            }else {
                everest += countPeopleInGroup;
            }


        }
        double percentMusala = musala / totalPeople * 100;
        double percentMontBlanc = montBlanc / totalPeople * 100;
        double percentKilimanjaro = kilimanjaro / totalPeople * 100;
        double percentK2 = K2 / totalPeople * 100;
        double percentEverest = everest / totalPeople * 100;

        System.out.printf("%.2f%%%n", percentMusala);
        System.out.printf("%.2f%%%n", percentMontBlanc);
        System.out.printf("%.2f%%%n", percentKilimanjaro);
        System.out.printf("%.2f%%%n", percentK2);
        System.out.printf("%.2f%%%n", percentEverest);


    }
}
