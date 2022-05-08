package ObjectsAndClasses.Lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] words = scanner.nextLine().split("\\s+");

        Random random = new Random();

        List<String> completeWords = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            String currentWord = words[random.nextInt(words.length)];

            if (completeWords.contains(currentWord)) {
                i--;
                continue;
            }

            System.out.println(currentWord);

            completeWords.add(currentWord);
        }


    }
}
