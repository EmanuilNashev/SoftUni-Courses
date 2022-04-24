package Arrays.Exercises;

import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] elements = scanner.nextLine().split(" ");

        int[] numbers = new int[elements.length];

        for (int i = 0; i < elements.length; i++) {
            numbers[i] = Integer.parseInt(elements[i]);
        }

        //14 24 3 19 15 17
        int num = 0;
        String string = "";
        for (int i = 0; i < numbers.length; i++) {

            int biggestNum = numbers[i];

            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] > biggestNum) {
                    biggestNum = numbers[j];

                }
            }
            if (num != biggestNum){
                string += biggestNum + " ";

            }
            num = biggestNum;
        }
        System.out.println(string);
    }
}
