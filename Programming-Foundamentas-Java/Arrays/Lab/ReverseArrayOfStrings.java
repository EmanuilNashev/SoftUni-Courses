package Arrays.Lab;

import java.util.Scanner;

public class ReverseArrayOfStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split(" ");

        String[] reversed = new String[strings.length];

        int index = 0;
        for (int i = strings.length-1; i >= 0 ; i--) {
            reversed[i] = strings[index];
            index++;
        }
        System.out.println(String.join(" ", reversed));
    }
}
