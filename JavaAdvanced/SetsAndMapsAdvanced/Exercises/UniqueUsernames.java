package SetsAndMapsAdvanced.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Set<String> uniqueWords = new LinkedHashSet<>();

        int inputs = Integer.parseInt(scanner.nextLine());
        for (int input = 0; input < inputs; input++) {
            String word = scanner.nextLine();
            uniqueWords.add(word);
        }

        for (String uniqueWord : uniqueWords) {
            System.out.println(uniqueWord);
        }
    }
}
