package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayDeque;

public class LineNumbers {
    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new FileReader("src/Resources/inputLineNumbers.txt"));
             PrintWriter writer = new PrintWriter("src/Resources/output.txt")) {

            ArrayDeque<String> rows = new ArrayDeque<>();
            String line = reader.readLine();
            int row = 1;
            while (line != null) {
                rows.offer(row + ". " + line);
                row++;

                line = reader.readLine();
            }
            for (String s : rows) {
                writer.println(s);
            }

        } catch (IOException ignored) {

        }
    }
}
