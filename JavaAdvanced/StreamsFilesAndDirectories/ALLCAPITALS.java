package StreamsFilesAndDirectories.Exercises;

import java.io.*;
import java.util.Scanner;

public class ALLCAPITALS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try(BufferedReader reader = new BufferedReader(new FileReader("src/Resources/input.txt"))) {
            PrintWriter writer = new PrintWriter(new FileWriter("src/Resources/output.txt"));

            String line = reader.readLine();
            while (line!=null){
                writer.println(line.toUpperCase());
                line = reader.readLine();
            }
            writer.close();
        }catch (IOException e){

        }
    }
}
