package FirstStepsInCoding.MoreExcersiseForPractise;

import java.util.Scanner;

public class TrainingLab {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        double wM = Double.parseDouble(scanner.nextLine());
        double hM = Double.parseDouble(scanner.nextLine());
        double hCM = hM * 100;
        double wWithoutCorridor = hCM - 100;
        double desksPerOrder = Math.floor(wWithoutCorridor / 70);
        double wCM = wM * 100;
        double orders = Math.floor(wCM / 120);
        double places = desksPerOrder * orders - 3;
        System.out.println(places);
    }
}
