package StreamsFilesAndDirectories.Exercises;

import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class WordCount {
    public static void main(String[] args) {


        try (PrintWriter writer = new PrintWriter("src/Resources/output.txt");
             Scanner scanner = new Scanner(new FileReader("src/Resources/words.txt"));
             Scanner scanner2 = new Scanner(new FileReader("src/Resources/text.txt"))) {

            Map<String, Integer> words = new LinkedHashMap<>();
            String word = scanner.nextLine();

            String[] wordss = word.split(" ");

            for (String s : wordss) {
                words.put(s, 0);
            }

            String word2 = scanner2.next();
            while (scanner2.hasNext()) {
                if (words.containsKey(word2)) {
                    int count = words.get(word2) + 1;
                    words.put(word2, count);
                }


                word2 = scanner2.next();
            }

           words.forEach((k,v) -> writer.println(k + " - " + v));




        } catch (IOException ignored) {
        }
    }
}
