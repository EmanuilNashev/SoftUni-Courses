package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class ProjectsCreation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int numberOfObjects = Integer.parseInt(scanner.nextLine());
        int hours = numberOfObjects * 3;
        System.out.println("The architect " + name + " will need " + hours + " hours to complete " + numberOfObjects
        + " project/s.");
    }
}
