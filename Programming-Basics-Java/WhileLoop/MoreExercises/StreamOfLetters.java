package WhileLoop.MoreExercises;

import java.util.Scanner;

public class StreamOfLetters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String hiddenWord = "";
        int cWord = 0;
        int oWord = 0;
        int nWord = 0;
        int secretCommand = 0;

        while (!input.equals("End")) {
            char symbol = input.charAt(0);
            if (symbol != 'A' && symbol != 'a' && symbol != 'b' && symbol != 'B' && symbol != 'c' && symbol != 'C' && symbol != 'd' && symbol != 'D' &&
                    symbol != 'e' && symbol != 'E' && symbol != 'f' && symbol != 'F' && symbol != 'g' && symbol != 'G' && symbol != 'h' && symbol != 'H' && symbol != 'i' &&
                    symbol != 'I' && symbol != 'j' && symbol != 'J' && symbol != 'k' && symbol != 'K' && symbol != 'l' && symbol != 'L' && symbol != 'm' && symbol != 'M' &&
                    symbol != 'n' && symbol != 'N' && symbol != 'o' && symbol != 'O' && symbol != 'p' && symbol != 'P' && symbol != 'q' && symbol != 'Q' && symbol != 'r' &&
                    symbol != 'R' && symbol != 's' & symbol != 'S' && symbol != 't' && symbol != 'T' && symbol != 'u' && symbol != 'U' && symbol != 'v' && symbol != 'V' &&
                    symbol != 'w' && symbol != 'W' && symbol != 'x' && symbol != 'X' && symbol != 'y' && symbol != 'Y' && symbol != 'z' && symbol != 'Z') {

                input = scanner.nextLine();
                continue;
            }
            if (symbol == 'c') {
                cWord++;
                if (cWord < 2) {
                    secretCommand++;
                    if (secretCommand == 3) {
                        System.out.print(hiddenWord + " ");
                        cWord = 0;
                        oWord = 0;
                        nWord = 0;
                        hiddenWord = "";
                        secretCommand = 0;
                    }
                    input = scanner.nextLine();
                    continue;
                } else {
                    cWord = 2;
                }
            }
            if (symbol == 'o') {
                oWord++;
                if (oWord < 2) {
                    secretCommand++;
                    if (secretCommand == 3) {
                        System.out.print(hiddenWord + " ");
                        cWord = 0;
                        oWord = 0;
                        nWord = 0;
                        hiddenWord = "";
                        secretCommand = 0;
                    }
                    input = scanner.nextLine();
                    continue;
                } else {
                    oWord = 2;
                }
            }
            if (symbol == 'n') {
                nWord++;
                if (nWord < 2) {
                    secretCommand++;
                    if (secretCommand == 3) {
                        System.out.print(hiddenWord + " ");
                        cWord = 0;
                        oWord = 0;
                        nWord = 0;
                        hiddenWord = "";
                        secretCommand = 0;
                    }
                    input = scanner.nextLine();
                    continue;
                } else {
                    nWord = 2;
                }
            }
            hiddenWord += symbol;


            input = scanner.nextLine();
        }

    }
}
