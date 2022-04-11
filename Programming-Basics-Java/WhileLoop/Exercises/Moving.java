package WhileLoop.Exercises;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int widthOfFreePlace = Integer.parseInt(scanner.nextLine());
        int lengthOfFreePlace = Integer.parseInt(scanner.nextLine());
        int heightOfFreePlace = Integer.parseInt(scanner.nextLine());

        int freeSpace = widthOfFreePlace * lengthOfFreePlace * heightOfFreePlace;
        int sumBoxes = 0;
        boolean isNotEnough = false;

        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            int countBoxes = Integer.parseInt(input);
            sumBoxes += countBoxes;

            if (freeSpace <= sumBoxes) {
                isNotEnough = true;
                break;
            }


            input = scanner.nextLine();
        }
        int diff = Math.abs(freeSpace - sumBoxes);

        if (isNotEnough) {
            System.out.printf("No more free space! You need %d Cubic meters more.", diff);
        } else {
            System.out.printf("%d Cubic meters left.", diff);
        }
    }
}
