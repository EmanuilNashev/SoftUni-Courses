package TextProcessing.Exercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] filePath = scanner.nextLine().split("\\\\");
        String[] file = filePath[filePath.length-1].split("\\.");

        System.out.println("File name: " + file[0]);
        System.out.println("File extension: " + file[1]);



    }
}
