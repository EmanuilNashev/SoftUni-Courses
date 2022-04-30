package Methods.Exercises;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] texts = input.split("");
            int[] numbers = new int[input.length()];

            doIntArray(numbers, texts.length, texts);


            int[] reversNumbers = new int[numbers.length];
            int index = 0;
            for (int i = numbers.length; i > 0; i--) {
                reversNumbers[index] = numbers[i - 1];
                index++;

            }

            String reverse = "";
            String numbersS = "";

            for (int i = 0; i < numbers.length ; i++) {
                reverse += reversNumbers[i];
                numbersS += numbers[i];


            }

            int reverseNumber = Integer.parseInt(reverse);
            int number = Integer.parseInt(numbersS);

            if(areEquals(reverseNumber, number)){
                System.out.println("true");
            }else{
                System.out.println("false");
            }



            input = scanner.nextLine();
        }


    }


    static void doIntArray(int[] numbers, int length, String[] texts) {

        for (int i = 0; i < length; i++) {
            numbers[i] = Integer.parseInt(texts[i]);

        }


    }

    static boolean areEquals (int reverseNumber, int number){
        if (reverseNumber == number){
            return true;
        }
        return false;
    }

}

