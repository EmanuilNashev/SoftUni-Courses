package Maps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SoftUniExamResults {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> participants = new LinkedHashMap<>();
        Map<String, Integer> languages = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("exam finished")) {
            String[] submissions = line.split("-");

            if (!submissions[1].equals("banned")) {
                participants.putIfAbsent(submissions[0], submissions[2]);
                languages.putIfAbsent(submissions[1], 0);
                languages.put(submissions[1], languages.get(submissions[1]) + 1);
            }else {
                participants.remove(submissions[0]);
            }







            line = scanner.nextLine();
        }
        printAllResult(participants, languages);
    }

    private static void printAllResult(Map<String, String> participants, Map<String, Integer> languages) {
        System.out.println("Results:");
        participants.forEach((key, value) -> System.out.printf("%s | %s%n", key, value));
        System.out.println("Submissions:");
        languages.forEach((key, value) -> System.out.printf("%s - %d%n", key, value));

    }
}
