package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SumLines {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try(BufferedReader bufferedReader = Files.newBufferedReader(Paths.get("src/Resources/input.txt"))) {
            String line = bufferedReader.readLine();

            while (line != null){
                long sum = 0;
                char[] chars = line.toCharArray();

                for (char aChar : chars) {
                    sum+=aChar;
                }
                System.out.println(sum);
                line = bufferedReader.readLine();
            }
        }catch (IOException ignored){
        }
    }
}
