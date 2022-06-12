package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String brackets = scanner.nextLine();
        ArrayDeque<Character> openBrackets = new ArrayDeque<>();

        boolean isBalanced = true;
        boolean flag = false;
        for (int i = 0; i < brackets.length(); i++) {
            char bracket = brackets.charAt(i);

            switch (bracket) {
                case '(':
                case '[':
                case '{':
                    openBrackets.push(bracket);
                    break;
                default:
                    if (openBrackets.isEmpty()) {
                        isBalanced = false;
                        flag = true;
                        break;
                    }
                    char lastBracket = openBrackets.pop();

                    switch (bracket) {
                        case ')':
                            if (lastBracket != '(') {
                                isBalanced = false;
                                flag = true;
                            }
                            break;
                        case '}':
                            if (lastBracket != '{') {
                                isBalanced = false;
                                flag = true;
                            }
                            break;
                        case ']':
                            if (lastBracket != '[') {
                                isBalanced = false;
                                flag = true;
                            }
                            break;
                        default:
                            isBalanced = false;
                            flag = true;
                            break;
                    }
                    break;
            }
            if (flag) {
                break;
            }
        }

        if (isBalanced) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
