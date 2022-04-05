package FirstStepsInCoding.MoreExcersiseForPractise;

import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x = Double.parseDouble(scanner.nextLine());
        double y = Double.parseDouble(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());
        double sideWall = x * y;
        double window = 1.5 * 1.5;
        double twoSideWalls = 2 * sideWall - 2 * window;
        double backWall = x * x;
        double entrance = 1.2 * 2;
        double frontWallAndBackWall = 2 * backWall - entrance;
        double allArea = twoSideWalls + frontWallAndBackWall;
        double greenPain = allArea / 3.4;
        double twoRectanglesOnRoof = 2 * (x * y);
        double twoTriangle = 2 * (x * h / 2);
        double allArea2 = twoRectanglesOnRoof + twoTriangle;
        double redPain = allArea2 / 4.3;
        System.out.printf("%.2f%n%.2f", greenPain, redPain);

    }
}
