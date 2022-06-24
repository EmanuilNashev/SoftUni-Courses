package Functions.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Predicate<String> predicate = s -> Character.isUpperCase(s.charAt(0));

        List<String> upperCaseWords = new ArrayList<>();

        for (String word : words) {
            if (predicate.test(word)){
                upperCaseWords.add(word);
            }
        }

        System.out.println(upperCaseWords.size());
        upperCaseWords.forEach(System.out::println);
    }
}
