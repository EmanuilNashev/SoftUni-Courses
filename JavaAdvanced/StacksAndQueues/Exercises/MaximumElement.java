package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int[] commands = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int operation = commands[0];

            switch (operation) {
                case 1:
                    int elementToPush = commands[1];
                    pushElementToStack(stack, elementToPush);
                    break;
                case 2:
                    popElementInStack(stack);
                    break;
                case 3:
                    findMaxElementInStackAndPrint(stack);
                    break;

            }
        }
    }

    private static void findMaxElementInStackAndPrint(ArrayDeque<Integer> stack) {
        int maxElement = Integer.MIN_VALUE;

        for (Integer integer : stack) {
            if (integer > maxElement){
                maxElement = integer;
            }
        }

        System.out.println(maxElement);
    }

    private static void popElementInStack(ArrayDeque<Integer> stack) {
        if (!stack.isEmpty()){
            stack.pop();
        }
    }

    private static void pushElementToStack(ArrayDeque<Integer> stack, int elementToPush) {
        stack.push(elementToPush);
    }
}
