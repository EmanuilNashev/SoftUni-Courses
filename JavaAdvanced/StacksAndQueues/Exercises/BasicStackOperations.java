package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //read operations
        int[] operations = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsToPush = operations[0];
        int elementsToPop = operations[1];
        int elementToCheck = operations[2];

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        pushElementsToStack(stack, elementsToPush, scanner);
        popElementsInStack(stack, elementsToPop);
        checkElementInStackAndPrint(stack, elementToCheck);


    }

    private static void checkElementInStackAndPrint(ArrayDeque<Integer> stack, int elementToCheck) {
        if (stack.isEmpty()){
            System.out.println("0");
            return;
        }

        int minElement = Integer.MAX_VALUE;
        boolean isTrue = false;

        for (Integer integer : stack) {
            if (integer == elementToCheck) {
                isTrue = true;
                break;
            }

            if (integer < minElement) {
                minElement = integer;
            }
        }

        if (isTrue){
            System.out.println("true");
        }else {
            System.out.println(minElement);
        }
    }

    private static void popElementsInStack(ArrayDeque<Integer> stack, int elementsToPop) {
        for (int i = 0; i < elementsToPop; i++) {
            stack.pop();
        }
    }

    private static void pushElementsToStack(ArrayDeque<Integer> stack, int elementsToPush, Scanner scanner) {
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < elementsToPush; i++) {
            stack.push(numbers[i]);
        }

    }
}
