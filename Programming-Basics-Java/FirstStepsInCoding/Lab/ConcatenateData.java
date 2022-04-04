package FirstStepsInCoding.Lab;

import java.util.Scanner;

public class ConcatenateData {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String FirstName = scanner.nextLine();
        String LastName = scanner.nextLine();
        int age =Integer.parseInt(scanner.nextLine());
        String city = scanner.nextLine();
        System.out.println("You are " + FirstName + " " + LastName + ", a " + age + "-years old person from " + city + ".");

    }
}
