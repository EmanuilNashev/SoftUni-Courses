package NestedLoops.MoreExercises;

import java.util.Scanner;

public class LettersCombinations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLatter = scanner.nextLine();
        String lastLatter = scanner.nextLine();
        String invalidCombination = scanner.nextLine();

        String latinAlphabet = "abcdefghijklmnopqrstuvwxyz";

        int numOfFirstLatter = 0;
        int numOfLastLatter = 0;

        switch (firstLatter) {
            case "a":
                numOfFirstLatter = 1;
                break;
            case "b":
                numOfFirstLatter = 2;
                break;
            case "c":
                numOfFirstLatter = 3;
                break;
            case "d":
                numOfFirstLatter = 4;
                break;
            case "e":
                numOfFirstLatter = 5;
                break;
            case "f":
                numOfFirstLatter = 6;
                break;
            case "g":
                numOfFirstLatter = 7;
                break;
            case "h":
                numOfFirstLatter = 8;
                break;
            case "i":
                numOfFirstLatter = 9;
                break;
            case "j":
                numOfFirstLatter = 10;
                break;
            case "k":
                numOfFirstLatter = 11;
                break;
            case "l":
                numOfFirstLatter = 12;
                break;
            case "m":
                numOfFirstLatter = 13;
                break;
            case "n":
                numOfFirstLatter = 14;
                break;
            case "o":
                numOfFirstLatter = 15;
                break;
            case "p":
                numOfFirstLatter = 16;
                break;
            case "q":
                numOfFirstLatter = 17;
                break;
            case "r":
                numOfFirstLatter = 18;
                break;
            case "s":
                numOfFirstLatter = 19;
                break;
            case "t":
                numOfFirstLatter = 20;
                break;
            case "u":
                numOfFirstLatter = 21;
                break;
            case "v":
                numOfFirstLatter = 22;
                break;
            case "w":
                numOfFirstLatter = 23;
                break;
            case "x":
                numOfFirstLatter = 24;
                break;
            case "y":
                numOfFirstLatter = 25;
                break;
            case "z":
                numOfFirstLatter = 26;
                break;
        }

        switch (lastLatter) {
            case "a":
                numOfLastLatter = 1;
                break;
            case "b":
                numOfLastLatter = 2;
                break;
            case "c":
                numOfLastLatter = 3;
                break;
            case "d":
                numOfLastLatter = 4;
                break;
            case "e":
                numOfLastLatter = 5;
                break;
            case "f":
                numOfLastLatter = 6;
                break;
            case "g":
                numOfLastLatter = 7;
                break;
            case "h":
                numOfLastLatter = 8;
                break;
            case "i":
                numOfLastLatter = 9;
                break;
            case "j":
                numOfLastLatter = 10;
                break;
            case "k":
                numOfLastLatter = 11;
                break;
            case "l":
                numOfLastLatter = 12;
                break;
            case "m":
                numOfLastLatter = 13;
                break;
            case "n":
                numOfLastLatter = 14;
                break;
            case "o":
                numOfLastLatter = 15;
                break;
            case "p":
                numOfLastLatter = 16;
                break;
            case "q":
                numOfLastLatter = 17;
                break;
            case "r":
                numOfLastLatter = 18;
                break;
            case "s":
                numOfLastLatter = 19;
                break;
            case "t":
                numOfLastLatter = 20;
                break;
            case "u":
                numOfLastLatter = 21;
                break;
            case "v":
                numOfLastLatter = 22;
                break;
            case "w":
                numOfLastLatter = 23;
                break;
            case "x":
                numOfLastLatter = 24;
                break;
            case "y":
                numOfLastLatter = 25;
                break;
            case "z":
                numOfLastLatter = 26;
                break;
        }
        int validComb = 0;

        for (int i = numOfFirstLatter; i <= numOfLastLatter; i++) {
            for (int j = numOfFirstLatter; j <= numOfLastLatter; j++) {
                for (int k = numOfFirstLatter; k <= numOfLastLatter; k++) {
                    char firstLatterInComb = latinAlphabet.charAt(i - 1);
                    char secondLatterInComb = latinAlphabet.charAt(j - 1);
                    char thirdLatterInComb = latinAlphabet.charAt(k - 1);

                    if (firstLatterInComb == invalidCombination.charAt(0) ||
                            secondLatterInComb == invalidCombination.charAt(0) ||
                            thirdLatterInComb == invalidCombination.charAt(0)) {
                        continue;

                    }
                    validComb++;

                    System.out.print("" + firstLatterInComb + secondLatterInComb + thirdLatterInComb + " ");


                }
            }
        }
        System.out.print(validComb);


    }
}
