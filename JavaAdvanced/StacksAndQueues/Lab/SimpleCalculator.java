package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        ArrayDeque<String> stack = new ArrayDeque<>();

        Collections.addAll(stack, tokens);

        //2 + 5 + 10 - 2 - 1

        while (stack.size() > 1) {
            int num1 = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int num2 = Integer.parseInt(stack.pop());

            int result = 0;
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
            }

            String resultAsString = "" + result;
            stack.push(resultAsString);
        }

        System.out.println(stack.pop());
    }
}
