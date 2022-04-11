package WhileLoop.Exercises;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        int countPartsCake = width * length;
        int diff = 0;

        boolean isNotEnough = false;

        String input = scanner.nextLine();

        while (!input.equals("STOP")) {
            int partCake = Integer.parseInt(input);

            countPartsCake = countPartsCake - partCake;

            if (countPartsCake < 0){
                isNotEnough = true;
                break;
            }
            input = scanner.nextLine();

        }
        if (isNotEnough){
            System.out.printf("No more cake left! You need %d pieces more.", Math.abs(countPartsCake));
        }else{
            System.out.printf("%d pieces are left.", countPartsCake);
        }
    }
}
