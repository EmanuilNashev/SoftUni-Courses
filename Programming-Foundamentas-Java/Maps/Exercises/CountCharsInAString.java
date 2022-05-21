package Maps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        char[] chars = text.toCharArray();
        Map<Character, Integer> numberOfChars = new LinkedHashMap<>();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' '){
                continue;
            }
            numberOfChars.putIfAbsent(chars[i], 0);
            numberOfChars.put(chars[i], numberOfChars.get(chars[i]) + 1);
        }

        numberOfChars.forEach((k,v) -> System.out.println(k + " -> " + v));


//        for (Map.Entry<Character, Integer> characterIntegerEntry : numberOfChars.entrySet()) {
//            System.out.println(characterIntegerEntry);
//        }
    }
}
