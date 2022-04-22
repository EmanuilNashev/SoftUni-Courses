package DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int n = Integer.parseInt(scanner.nextLine());
        String message = "";
        for (int i = 0; i < n; i++) {
            char c = scanner.nextLine().charAt(0);
            int num = c + key;
            char newChar = (char) num;
            message+= "" + newChar;
        }
        System.out.println(message);
    }
}
