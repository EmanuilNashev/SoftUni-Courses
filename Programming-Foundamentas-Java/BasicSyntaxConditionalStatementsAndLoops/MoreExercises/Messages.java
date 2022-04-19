package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());

            switch (num) {
                case 2:
                    stringBuilder.append("a");
                    break;
                case 22:
                    stringBuilder.append("b");
                    break;
                case 222:
                    stringBuilder.append("c");
                    break;
                case 3:
                    stringBuilder.append("d");
                    break;
                case 33:
                    stringBuilder.append("e");
                    break;
                case 333:
                    stringBuilder.append("f");
                    break;
                case 4:
                    stringBuilder.append("g");
                    break;
                case 44:
                    stringBuilder.append("h");
                    break;
                case 444:
                    stringBuilder.append("i");
                    break;
                case 5:
                    stringBuilder.append("j");
                    break;
                case 55:
                    stringBuilder.append("k");
                    break;
                case 555:
                    stringBuilder.append("l");
                    break;
                case 6:
                    stringBuilder.append("m");
                    break;
                case 66:
                    stringBuilder.append("n");
                    break;
                case 666:
                    stringBuilder.append("o");
                    break;
                case 7:
                    stringBuilder.append("p");
                    break;
                case 77:
                    stringBuilder.append("q");
                    break;
                case 777:
                    stringBuilder.append("r");
                    break;
                case 7777:
                    stringBuilder.append("s");
                    break;
                case 8:
                    stringBuilder.append("t");
                    break;
                case 88:
                    stringBuilder.append("u");
                    break;
                case 888:
                    stringBuilder.append("v");
                    break;
                case 9:
                    stringBuilder.append("w");
                    break;
                case 99:
                    stringBuilder.append("x");
                    break;
                case 999:
                    stringBuilder.append("y");
                    break;
                case 9999:
                    stringBuilder.append("z");
                    break;
                case 0:
                    stringBuilder.append(" ");
                    break;
            }
        }
        System.out.println(stringBuilder);
    }
}
