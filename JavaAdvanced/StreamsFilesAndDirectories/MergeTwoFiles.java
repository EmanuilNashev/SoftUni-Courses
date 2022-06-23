package StreamsFilesAndDirectories.Exercises;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MergeTwoFiles {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try(BufferedReader reader = new BufferedReader(new FileReader("src/Resources/inputOne.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("src/Resources/inputTwo.txt"));
            PrintWriter writer = new PrintWriter("src/Resources/output.txt")) {

             List<String> list =Files.readAllLines(Path.of("src/Resources/inputOne.txt"));

            List<String> list2 = Files.readAllLines(Path.of("src/Resources/inputTwo.txt"));

            List<String> list3 = new ArrayList<>(list);
            list3.addAll(list2);

           list3.forEach(writer::println);

        }catch (IOException ignored){

        }
    }
}
