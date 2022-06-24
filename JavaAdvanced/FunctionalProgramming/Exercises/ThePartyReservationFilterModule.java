package Functions.Exercises;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> invitations = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Map<String, List<String>> filters = new HashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Print")) {
            String[] filterModule = input.split(";");
            String filterName = filterModule[1] + ";" + filterModule[2];

            Predicate<String> filter = getPredicate(filterName.split(";"));

            String command = filterModule[0];
            switch (command) {
                case "Add filter":
                    filters.putIfAbsent(filterName, new ArrayList<>());
                    for (int i = 0; i < invitations.size(); i++) {
                        filters.get(filterName).add(invitations.get(i));
                    }

                    for (int i = 0; i < invitations.size(); i++) {
                        if (filter.test(invitations.get(i))) {
                            invitations.remove(i);
                            i--;
                        }
                    }
                    break;
                case "Remove filter":
                    for (Map.Entry<String, List<String>> stringListEntry : filters.entrySet()) {
                        if (stringListEntry.getKey().equals(filterName)) {
                            continue;
                        }
                        filter = getPredicate(stringListEntry.getKey().split(";"));

                        filters.get(filterName).removeIf(filter);
                    }

                    invitations = filters.get(filterName);
                    filters.remove(filterName);
                    break;
            }


            input = scanner.nextLine();
        }
        Consumer<String> printer = guy -> System.out.print(guy + " ");
        invitations.forEach(printer);
    }

    private static Predicate<String> getPredicate(String[] filterName) {
        Predicate<String> filter = null;

        String filterType = filterName[0];
        String filterParameter = filterName[1];

        switch (filterType) {
            case "Starts with":
                filter = guy -> guy.startsWith(filterParameter);
                break;
            case "Ends with":
                filter = guy -> guy.endsWith(filterParameter);
                break;
            case "Length":
                int filterLength = Integer.parseInt(filterParameter);
                filter = guy -> guy.length() == filterLength;
                break;
            case "Contains":
                filter = guy -> guy.contains(filterParameter);
                break;
        }
        return filter;
    }
}
