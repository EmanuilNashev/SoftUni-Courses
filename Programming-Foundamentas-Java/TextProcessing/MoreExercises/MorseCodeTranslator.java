package TextProcessing.MoreExercises;

import java.awt.*;
import java.util.Arrays;
import java.util.Scanner;

public class MorseCodeTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String morseCode = scanner.nextLine();
        String[] morseWords = morseCode.split("\\s+");
        StringBuilder morseToEnglish = new StringBuilder();
        for (String morseWord : morseWords) {
            switch (morseWord) {
                case "|":
                    morseToEnglish.append(" ");
                    break;
                case ".-":
                    morseToEnglish.append("A");
                    break;
                case "-...":
                    morseToEnglish.append("B");
                    break;
                case "-.-.":
                    morseToEnglish.append("C");
                    break;
                case "-..":
                    morseToEnglish.append("D");
                    break;
                case ".":
                    morseToEnglish.append("E");
                    break;
                case "..-.":
                    morseToEnglish.append("F");
                    break;
                case "--.":
                    morseToEnglish.append("G");
                    break;
                case "....":
                    morseToEnglish.append("H");
                    break;
                case "..":
                    morseToEnglish.append("I");
                    break;
                case ".---":
                    morseToEnglish.append("J");
                    break;
                case "-.-":
                    morseToEnglish.append("K");
                    break;
                case ".-..":
                    morseToEnglish.append("L");
                    break;
                case "--":
                    morseToEnglish.append("M");
                    break;
                case "-.":
                    morseToEnglish.append("N");
                    break;
                case "---":
                    morseToEnglish.append("O");
                    break;
                case ".--.":
                    morseToEnglish.append("P");
                    break;
                case "--.-":
                    morseToEnglish.append("Q");
                    break;
                case ".-.":
                    morseToEnglish.append("R");
                    break;
                case "...":
                    morseToEnglish.append("S");
                    break;
                case "-":
                    morseToEnglish.append("T");
                    break;
                case "..-":
                    morseToEnglish.append("U");
                    break;
                case "...-":
                    morseToEnglish.append("V");
                    break;
                case ".--":
                    morseToEnglish.append("W");
                    break;
                case "-..-":
                    morseToEnglish.append("X");
                    break;
                case "-.--":
                    morseToEnglish.append("Y");
                    break;
                case "--..":
                    morseToEnglish.append("Z");
                    break;

            }
        }

        System.out.println(morseToEnglish);

    }
}
