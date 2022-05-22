package TextProcessing.MoreExercises;

import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char firstChar = scanner.nextLine().charAt(0);
        char secondChar = scanner.nextLine().charAt(0);
        String randomString = scanner.nextLine();

        int sumOfChars = getAndSumChars(firstChar,secondChar,randomString);

        System.out.println(sumOfChars);
    }

    private static int getAndSumChars(char firstChar, char secondChar, String randomString) {
        int sum = 0;
        for (int i = 0; i < randomString.length(); i++) {
            char c = randomString.charAt(i);

            int start = Math.min(firstChar, secondChar);
            int end = Math.max(firstChar,secondChar);

            if (c > start && c < end){
                sum+= c;
            }


        }


        return sum;
    }
}
