package SetsAndMapsAdvanced.Exercises;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        Map<Character, Integer> chars = new TreeMap<>();

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (chars.containsKey(symbol)){
                continue;
            }
            int counter = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(j) == symbol){
                    counter++;
                }
            }
            chars.put(symbol, counter);
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : chars.entrySet()) {
            System.out.println(characterIntegerEntry.getKey() + ": " + characterIntegerEntry.getValue() + " time/s");
        }
    }
}
