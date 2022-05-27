package RegularExpressions.Lab;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String regex = "\\b(?<date>\\d{2})(?<seperator>[-.\\/])(?<mounth>[A-Z][a-z]{2})\\2(?<year>\\d{4})\\b";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()){
            System.out.println("Day: " + matcher.group("date") + ", Month: " + matcher.group("mounth") + ", "+ "Year: " + matcher.group("year"));
        }
    }
}
