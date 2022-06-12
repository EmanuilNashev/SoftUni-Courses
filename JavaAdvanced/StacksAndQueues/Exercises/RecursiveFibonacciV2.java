package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class RecursiveFibonacciV2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Long> arrayDeque = new ArrayDeque<>();

        arrayDeque.push(1L);
        arrayDeque.push(1L);

        for (int i = 1; i < n; i++) {
            Long lastElement = arrayDeque.pop();
            Long lastTwoElement = arrayDeque.pop();
            arrayDeque.push(lastElement);
            Long newElement = lastTwoElement + lastElement;
            arrayDeque.push(newElement);
        }

        System.out.println(arrayDeque.peek());


    }
}
