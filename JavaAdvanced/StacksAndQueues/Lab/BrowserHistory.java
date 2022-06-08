package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String currentURL = "blank";
        ArrayDeque<String> history = new ArrayDeque<>();
        String input = scanner.nextLine();
        while (!input.equals("Home")) {

            if (input.equals("back")) {
                if (!history.isEmpty()) {
                    currentURL = history.pop();
                    System.out.println(currentURL);
                }else {
                    System.out.println("no previous URLs");
                }
            } else {
                if (!currentURL.equals("blank")){
                    history.push(currentURL);
                }
                currentURL = input;
                System.out.println(currentURL);
            }


            input = scanner.nextLine();
        }
    }
}
