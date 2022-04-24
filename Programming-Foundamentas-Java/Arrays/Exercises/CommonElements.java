package Arrays.Exercises;

import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] firstStrings = scanner.nextLine().split(" ");
        String[] secondStrings = scanner.nextLine().split(" ");

        int index1 = 0;
        int index2 = 0;

        String commonElements = "";

        for (String secondString : secondStrings){
            for (String firstString : firstStrings){
                if (secondString.equals(firstString)){
                    commonElements += secondString + " ";

                }
            }
        }
        System.out.println(commonElements);
    }
}
