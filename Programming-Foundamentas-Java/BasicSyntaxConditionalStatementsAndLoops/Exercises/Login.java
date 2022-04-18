package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();
        int longOfName = name.length();
        String password = "";
        char symbol = 0;
        while ((longOfName - 1) >= 0) {
            symbol = name.charAt(longOfName - 1);
            password += symbol;


            longOfName--;
        }
        boolean isCorrectPass = false;
        int tries = 0;
        while (tries < 4) {
            String input = scanner.nextLine();
            if (input.equals(password)) {
                isCorrectPass = true;
                break;
            } else if(tries != 3) {
                System.out.println("Incorrect password. Try again.");
            }
            tries++;


        }
        if (isCorrectPass) {
            System.out.printf("User %s logged in.", name);
        } else {
            System.out.printf("User %s blocked!", name);
        }

    }
}
