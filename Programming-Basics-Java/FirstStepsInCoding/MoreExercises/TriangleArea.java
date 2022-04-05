package FirstStepsInCoding.MoreExcersiseForPractise;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double S = a * h / 2;
        System.out.printf("%.2f", S);
    }
}
