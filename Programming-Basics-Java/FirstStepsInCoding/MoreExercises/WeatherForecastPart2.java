package FirstStepsInCoding.MoreExcersiseForPractise;

import java.util.Scanner;

public class WeatherForecastPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double degrees = Double.parseDouble(scanner.nextLine());

        if (degrees >= 26.00){
            if (degrees <= 35.00){
                System.out.println("Hot");
            }else {System.out.println("unknown");}
        }
        else if(degrees >= 20.1){
            if(degrees <= 25.9){
                System.out.println("Warm");
            }
        }
        else if(degrees >= 15.00){
            if(degrees <= 20.00){
                System.out.println("Mild");
            }
        }
        else if(degrees >= 12.00){
            if(degrees <=14.9){
                System.out.println("Cool");
            }
        }
        else if(degrees >= 5.00){
            if(degrees <= 11.9){
                System.out.println("Cold");
            }
        }
        else {
            System.out.println("unknown");
        }
    }
}
