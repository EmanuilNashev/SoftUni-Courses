package TextProcessing.Exercise;

import java.util.Locale;
import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");


        for (String username : usernames) {

            StringBuilder chars = new StringBuilder();

            if (username.length() >= 3 && username.length() <= 16) {
                for (int i = 0; i < username.length(); i++) {
                    if ((username.toLowerCase().charAt(i) >= 97 && username.toLowerCase().charAt(i) <= 122) || username.charAt(i) == 45 || username.charAt(i) == 95
                            || (username.charAt(i) >= 48 && username.charAt(i) <= 57)) {
                        chars.append(username.charAt(i));
                    }
                }
                if (chars.toString().equals(username)) {
                    System.out.println(username);
                }

            }


        }
    }
}
