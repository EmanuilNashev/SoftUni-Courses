package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();
        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        ArrayDeque<String> expressions = new ArrayDeque<>();

        int closingBracketIndex = 0;
        for (int i = 0; i < brackets.length(); i++) {
            if (brackets.charAt(i) == '(') {
                indexes.push(i);
            } else if (brackets.charAt(i) == ')') {
                    expressions.offer(brackets.substring(indexes.pop(), i + 1));
            }

        }
        printExpressions(expressions);
    }

    private static void printExpressions(ArrayDeque<String> expressions) {
        int size = expressions.size();
        for (int i = 0; i < size; i++) {
            System.out.println(expressions.poll());
        }
    }
}
