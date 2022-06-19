package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String,String> users = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("stop")){
            String name = input;
            String email = scanner.nextLine();

            String com = email.substring(email.length() - 3);
            String cc = email.substring(email.length() - 2);
            if (com.equals("com")){
                input = scanner.nextLine();
                continue;
            }else if (cc.equals("us") || cc.equals("uk")){
                input = scanner.nextLine();
                continue;
            }

            users.put(name, email);
            input = scanner.nextLine();
        }

        for (Map.Entry<String, String> stringStringEntry : users.entrySet()) {
            System.out.println(stringStringEntry.getKey() + " -> " + stringStringEntry.getValue());
        }
    }
}
