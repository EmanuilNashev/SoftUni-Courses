package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> files = new ArrayDeque<>();

        String input = scanner.nextLine();
        while (!input.equals("print")){
            String file = input;

            if (!file.equals("cancel")){
                files.offer(file);
            }else {
                if (files.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    String removedFile = files.poll();
                    System.out.println("Canceled " + removedFile);
                }
            }
            input = scanner.nextLine();
        }

        for (String file : files) {
            System.out.println(file);
        }
    }
}
