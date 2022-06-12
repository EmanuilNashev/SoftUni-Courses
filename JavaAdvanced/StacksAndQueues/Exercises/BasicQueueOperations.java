package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] operations = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsToAdd = operations[0];
        int elementsToRemove = operations[1];
        int elementToCheck = operations[2];

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        addElementInQueue(queue, elementsToAdd, scanner);
        removeElementsInQueue(queue,elementsToRemove);
        checkElementInQueueAndPrint(queue,elementToCheck);
    }

    private static void checkElementInQueueAndPrint(ArrayDeque<Integer> queue, int elementToCheck) {
        boolean isEmpty = false;
        boolean isTrue = false;
        if (queue.isEmpty()){
            isEmpty = true;
        }

        int minElement = Integer.MAX_VALUE;
        for (Integer integer : queue) {
            if (integer == elementToCheck){
                isTrue = true;
            }

            if (integer < minElement){
                minElement = integer;
            }
        }
        if (isEmpty){
            System.out.println("0");
        }else if (isTrue){
            System.out.println("true");
        }else {
            System.out.println(minElement);
        }

    }

    private static void removeElementsInQueue(ArrayDeque<Integer> queue, int elementsToRemove) {
        for (int i = 0; i < elementsToRemove; i++) {
            queue.poll();
        }
    }

    private static void addElementInQueue(ArrayDeque<Integer> queue, int elementsToAdd, Scanner scanner) {
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < elementsToAdd; i++) {
            queue.offer(numbers[i]);
        }



    }
}
