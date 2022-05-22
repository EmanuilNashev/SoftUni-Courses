package TextProcessing.MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ExtractPersonInformation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> persons = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String personDate = scanner.nextLine();

            String name = personDate.substring(personDate.indexOf("@") + 1, personDate.indexOf("|"));
            String age = personDate.substring(personDate.indexOf("#")+1, personDate.indexOf("*"));

            System.out.printf("%s is %s years old.%n", name,age);


        }
    }
}
