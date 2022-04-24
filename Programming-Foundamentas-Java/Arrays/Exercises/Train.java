package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countWagons = Integer.parseInt(scanner.nextLine());

        int[] wagons = new int[countWagons];
        int index = 0;

        int sum = 0;

        for (int wagon: wagons){
            wagons[index] = Integer.parseInt(scanner.nextLine());
            sum += wagons[index];
            index++;
        }
        int index2 = 0;
        for (int wagon: wagons){
            System.out.print(wagons[index2] + " ");
            index2++;
        }
//        Arrays.stream(wagons).forEach(wagon -> System.out.print(wagon + " "));
        System.out.println();
        System.out.println(sum);
    }

}
