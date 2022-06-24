package Functions.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());


        String line = scanner.nextLine();
        while (!line.equals("Party!")) {
            String[] commandParts = line.split("\\s+");
            String command = commandParts[0];
            String secondPartOfCommand = commandParts[1];
            String thirdPartOfCommand = commandParts[2];

            Predicate<String> predicateStartsWith = getPredicateStartsWith(thirdPartOfCommand);
            Predicate<String> predicateEndsWith = getPredicateEndsWith(thirdPartOfCommand);
            Predicate<String> predicateLength = getPredicateLength(thirdPartOfCommand);

            switch (command) {
                case "Double":
                    doubleGuests(people, secondPartOfCommand, thirdPartOfCommand, predicateStartsWith, predicateEndsWith, predicateLength);
                    break;
                case "Remove":
                    removeGuests(people, secondPartOfCommand, thirdPartOfCommand, predicateStartsWith, predicateEndsWith, predicateLength);
                    break;
            }

            line = scanner.nextLine();
        }

        Consumer<List<String>> printer = getPrinter();
        printer.accept(people);
    }

    private static Consumer<List<String>> getPrinter() {
        return list -> {
            if (list.size() != 0) {
                list = list.stream().sorted().collect(Collectors.toList());
                System.out.print(String.join(", ", list));
                System.out.println(" are going to the party!");
            } else {
                System.out.println("Nobody is going to the party!");
            }
        };
    }

    private static Predicate<String> getPredicateLength(String thirdPartOfCommand) {
        return
                guy -> {
                    if (guy.length() == Integer.parseInt(thirdPartOfCommand)) {
                        return true;
                    }
                    return false;
                };
    }

    private static Predicate<String> getPredicateEndsWith(String thirdPartOfCommand) {
        return
                guy -> {
                    if (guy.endsWith(thirdPartOfCommand)) {
                        return true;
                    }
                    return false;
                };
    }

    private static Predicate<String> getPredicateStartsWith(String thirdPartOfCommand) {
        return
                guy -> {
                    if (guy.startsWith(thirdPartOfCommand)) {
                        return true;
                    }
                    return false;
                };
    }

    private static void removeGuests(List<String> people, String secondPartOfCommand, String thirdPartOfCommand, Predicate<String> predicateStartsWith, Predicate<String> predicateEndsWith, Predicate<String> predicateLength) {
        switch (secondPartOfCommand) {
            case "StartsWith":
                for (int i = 0; i < people.size(); i++) {
                    if (predicateStartsWith.test(people.get(i))) {
                        people.remove(i);
                        i--;
                    }
                }
                break;
            case "EndsWith":
                for (int i = 0; i < people.size(); i++) {
                    if (predicateEndsWith.test(people.get(i))) {
                        people.remove(i);
                        i--;
                    }
                }
                break;
            case "Length":
                for (int i = 0; i < people.size(); i++) {
                    if (predicateLength.test(people.get(i))) {
                        people.remove(i);
                        i--;
                    }
                }
                break;
        }

    }

    private static void doubleGuests(List<String> people, String secondPartOfCommand, String thirdPartOfCommand, Predicate<String> predicateStartsWith, Predicate<String> predicateEndsWith, Predicate<String> predicateLength) {

        switch (secondPartOfCommand) {
            case "StartsWith":
                for (int i = 0; i < people.size(); i++) {
                    if (predicateStartsWith.test(people.get(i))) {
                        people.add(i, people.get(i));
                        i++;
                    }
                }
                break;
            case "EndsWith":
                for (int i = 0; i < people.size(); i++) {
                    if (predicateEndsWith.test(people.get(i))) {
                        people.add(i, people.get(i));
                        i++;
                    }
                }
                break;
            case "Length":
                for (int i = 0; i < people.size(); i++) {
                    if (predicateLength.test(people.get(i))) {
                        people.add(i, people.get(i));
                        i++;
                    }
                }
                break;
        }
    }
}
