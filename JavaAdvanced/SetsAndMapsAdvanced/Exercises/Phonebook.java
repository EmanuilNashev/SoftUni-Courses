package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contacts = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("search")) {
            String[] data = input.split("-");
            String name = data[0];
            String phoneNumber = data[1];

            contacts.put(name, phoneNumber);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("stop")){
            String name = input;
            if (contacts.containsKey(name)){
                System.out.println(name+" -> " + contacts.get(name));
            }else {
                System.out.printf("Contact %s does not exist.%n", name);
            }


            input = scanner.nextLine();
        }
    }
}
