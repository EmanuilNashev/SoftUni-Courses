package ForLoop.Exercises;

import java.util.Scanner;

public class Oscars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameActor = scanner.nextLine();
        double pointsOfAcademy = Double.parseDouble(scanner.nextLine());
        int countRefers = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= countRefers; i++) {
            if (pointsOfAcademy < 1250.5) {
                String nameOfRefer = scanner.nextLine();
                double pointsFromRefer = Double.parseDouble(scanner.nextLine());

                pointsOfAcademy += (nameOfRefer.length()  * pointsFromRefer) / 2;
            }
        }
        double diff = Math.abs(1250.5 - pointsOfAcademy);

        if (pointsOfAcademy < 1250.5){
            System.out.printf("Sorry, %s you need %.1f more!", nameActor, diff);
        }else if (pointsOfAcademy >= 1250.5){
            System.out.printf("Congratulations, %s got a nominee for leading role with %.1f!", nameActor, pointsOfAcademy);
        }
    }
}
