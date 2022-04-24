package Arrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        int timeOfRotations = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < timeOfRotations; i++) {

            String firstArray = array[0];

            for (int j = 0; j < array.length; ++j) {
                if (j != array.length - 1){
                    array[j] = array[j + 1];
                    continue;
                }



                array[array.length - 1] = firstArray;
            }
        }
        Arrays.stream(array).forEach(e -> System.out.print(e + " "));
    }
}
