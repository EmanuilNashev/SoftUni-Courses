package DataTypesAndVariables.Exercises;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        double biggestVolume = 0;
        String biggestVolumeModel = "";


            for (int j = 0; j < n; j++) {
                String model = scanner.nextLine();
                double radius = Double.parseDouble(scanner.nextLine());
                int height = Integer.parseInt(scanner.nextLine());

                double volume = Math.PI * Math.pow(radius, 2) * height;

                if (volume > biggestVolume){
                    biggestVolume = volume;
                    biggestVolumeModel = model;
                }



            }


        System.out.println(biggestVolumeModel);
    }
}
