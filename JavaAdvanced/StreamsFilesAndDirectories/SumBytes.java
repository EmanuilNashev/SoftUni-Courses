package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class SumBytes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try(BufferedReader reader = new BufferedReader(new FileReader("src/Resources/input.txt"))){
            String line = reader.readLine();
            long sum = 0;
            while (line != null){
                char[] chars = line.toCharArray();

                for (char aChar : chars) {
                    sum += aChar;
                }
                line = reader.readLine();
            }
            System.out.println(sum);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
