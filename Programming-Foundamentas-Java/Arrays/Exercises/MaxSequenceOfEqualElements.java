package Arrays.Exercises;

import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] array = scanner.nextLine().split(" ");

        int[] numbers = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            numbers[i] = Integer.parseInt(array[i]);
        }

        int previousSequence = 0;
        int sequenceNumbers = 1;
        int maxSequence = 0;
        int maxSequenceNum = 0;

        //1 1 1 2 3 1 3 3

        for (int i = 1; i < numbers.length ; i++) {

            if (numbers[i] == numbers[i - 1]){
                sequenceNumbers++;

                if (i != numbers.length - 1){

                    continue;
                }


            }
//            previousSequence = sequenceNumbers;

            if (maxSequence < sequenceNumbers){

                maxSequence = sequenceNumbers;
                maxSequenceNum = numbers[i - 1];
            }
            sequenceNumbers = 1;

        }
        for (int i = 0; i < maxSequence; i++) {
            System.out.print(maxSequenceNum + " ");
        }
    }
}
