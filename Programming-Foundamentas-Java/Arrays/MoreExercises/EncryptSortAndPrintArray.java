package Arrays.MoreExercises;

import java.util.Scanner;

public class EncryptSortAndPrintArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfStrings = Integer.parseInt(scanner.nextLine());

        int[] sums = new int[numberOfStrings];


        for (int i = 0; i < numberOfStrings; i++) {
            String[] array = scanner.nextLine().split("");


            int totalSum = 0;
            int sumVowels = 0;
            int sumConsonant = 0;

            for (int j = 0; j < array.length; j++) {
                char symbol = array[j].charAt(0);
                if (symbol == 97 || symbol == 65 || symbol == 69 || symbol == 73 || symbol == 79 || symbol == 85 || symbol == 101 || symbol == 105 || symbol == 111 || symbol == 117 ) {
                    sumVowels += symbol * array.length;
                } else {
                    sumConsonant += symbol / array.length;
                }
            }
            totalSum += sumConsonant + sumVowels;
            sums[i] = totalSum;

        }



        for (int i = 0; i < sums.length; i++) {


            int minSumNum = Integer.MAX_VALUE;

            for (int j = 0; j < sums.length; j++) {

                if ( sums[j] == 0) {

                    continue;
                }


                if (sums[j] < minSumNum) {
                    minSumNum = sums[j];


                }
            }

            for (int j = 0; j < sums.length; j++) {
                if (sums[j] == minSumNum){
                    sums[j] = 0;


                }


            }




            System.out.println(minSumNum);


        }

    }
}
