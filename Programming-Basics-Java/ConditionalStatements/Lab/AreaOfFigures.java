package ConditionalStatements.Lab;

import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        double area = 0.0;
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();
        if(figure.equals("square")){
            double sideOfSquare = Double.parseDouble(scanner.nextLine());
            area = sideOfSquare * sideOfSquare;
        }
        else if(figure.equals("rectangle")){
            double sideOfRectangle = Double.parseDouble(scanner.nextLine());
            double sideOfRectangle2 = Double.parseDouble(scanner.nextLine());
            area = sideOfRectangle * sideOfRectangle2;
        }
        else if(figure.equals("circle")){
            double r = Double.parseDouble(scanner.nextLine());
            area = Math.PI * Math.pow(r,2);
        }
        else if(figure.equals("triangle")){
            double sideOfTriangle = Double.parseDouble(scanner.nextLine());
            double height = Double.parseDouble(scanner.nextLine());
            area = sideOfTriangle * height / 2;
        }
        System.out.printf("%.3f", area);
    }
}
