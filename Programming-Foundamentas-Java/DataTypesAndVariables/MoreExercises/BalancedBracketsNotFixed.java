package DataTypesAndVariables.MoreExercises;

import java.util.Scanner;

public class BalancedBracketsNotFixed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//                8
//                (
//                5 + 10
//                )
//                * 2 +
//                (
//                5
//                )
//                -12
        int n = Integer.parseInt(scanner.nextLine());

        String lastScope = "";
        boolean flag = false;
        boolean isUnbalanced = false;
        for (int i = 0; i < n; i++) {
            String string = scanner.nextLine();
            boolean areNotTwoBrackets = false;
            if (lastScope.equals(")")) {
                if (string.equals("(")) {
                    isUnbalanced = true;
                    break;
                } else {
                    lastScope = "";
                }
            }


            if (!string.equals("(")) {
                if (string.equals(")")) {
                    isUnbalanced = true;
                    break;
                } else {
                    continue;
                }
            }

            if (i == n - 1) {
                isUnbalanced = true;
                break;
            }
            string = scanner.nextLine();

            while (!string.equals(")")) {
                i++;

                areNotTwoBrackets = true;
                if (string.equals("(")) {
                    isUnbalanced = true;
                    flag = true;
                    break;
                }

                if (i == n) {
                    flag = true;
                    isUnbalanced = true;
                    break;
                }
                string = scanner.nextLine();

            }
            lastScope = ")";


            i++;
            if (!areNotTwoBrackets) {
                isUnbalanced = true;
                break;
            }

            if (flag) {
                break;
            }
        }
        if (isUnbalanced) {
            System.out.println("UNBALANCED");
        } else {
            System.out.println("BALANCED");
        }
    }
}
