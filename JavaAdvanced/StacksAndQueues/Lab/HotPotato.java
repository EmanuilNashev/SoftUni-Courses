package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[]names = scanner.nextLine().split("\\s+");
        int potato = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = fillQueue(names);

        while (queue.size() > 1){
            int number = 0;
            for (String name : queue) {



            }
        }
    }

    private static ArrayDeque<String> fillQueue(String[] names) {
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < names.length; i++) {
            queue.offer(names[i]);
        }
        return queue;
    }
}
