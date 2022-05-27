package RegularExpressions.Exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Race {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> names = Arrays.stream(scanner.nextLine().split(", ")).collect(Collectors.toList());

        Pattern pattern = Pattern.compile("(?<latters>[A-Za-z])|(?<digits>\\d)|[^A-Za-z\\d]");

        List<String> racers = new ArrayList<>();
        List<Integer> distances = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("end of race")) {
            String racer = line;
            Matcher matcher = pattern.matcher(racer);
            StringBuilder extractRacer = new StringBuilder();
            int distance = 0;


            while (matcher.find()) {
                extractRacer.append(matcher.group("latters"));

                distance += Integer.parseInt(matcher.group("digits"));


                if (extractRacer.toString().contains("null")) {
                    extractRacer.delete(extractRacer.toString().indexOf("null"), extractRacer.toString().indexOf("null") + 4);
                }
            }


            racers.add(extractRacer.toString());


            line = scanner.nextLine();
        }
        System.out.println();
    }
}
