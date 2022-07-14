
package OOP.WorkingWithAbstraction.Exercises.greedyTimes;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long bagCapacity = Long.parseLong(scanner.nextLine());
        String[] items = scanner.nextLine().split("\\s+");

        Map<String, LinkedHashMap<String, Long>> bag = new LinkedHashMap<>();

        long gold = 0;
        long stones = 0;
        long cash = 0;

        for (int i = 0; i < items.length; i += 2) {
            String item = items[i];

            long amount = Long.parseLong(items[i + 1]);

            String itemName = getItemName(item);

            if (isInvalidItem(bagCapacity, bag, amount, itemName)) {
                continue;
            }

            switch (itemName) {
                case "Gem":
                    if (!bag.containsKey(itemName)) {
                        if (bag.containsKey("Gold")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemName).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
                case "Cash":
                    if (!bag.containsKey(itemName)) {
                        if (bag.containsKey("Gem")) {
                            if (amount > bag.get("Gold").values().stream().mapToLong(e -> e).sum()) {
                                continue;
                            }
                        } else {
                            continue;
                        }
                    } else if (bag.get(itemName).values().stream().mapToLong(e -> e).sum() + amount > bag.get("Gem").values().stream().mapToLong(e -> e).sum()) {
                        continue;
                    }
                    break;
            }

            if (!bag.containsKey(itemName)) {
                bag.put((itemName), new LinkedHashMap<String, Long>());
            }

            if (!bag.get(itemName).containsKey(item)) {
                bag.get(itemName).put(item, 0L);
            }


            bag.get(itemName).put(item, bag.get(itemName).get(item) + amount);
            if (itemName.equals("Gold")) {
                gold += amount;
            } else if (itemName.equals("Gem")) {
                stones += amount;
            } else if (itemName.equals("Cash")) {
                cash += amount;
            }
        }

        for (var x : bag.entrySet()) {
            Long sumValues = x.getValue().values().stream().mapToLong(l -> l).sum();

            System.out.println(String.format("<%s> $%s", x.getKey(), sumValues));

            x.getValue().entrySet().stream().sorted((e1, e2) -> e2.getKey().compareTo(e1.getKey())).forEach(i -> System.out.println("##" + i.getKey() + " - " + i.getValue()));

        }
    }

    private static boolean isInvalidItem(long bagCapacity, Map<String, LinkedHashMap<String, Long>> bag, long amount, String itemName) {
        return itemName.equals("") || bagCapacity < bag.values().stream().map(Map::values).flatMap(Collection::stream).mapToLong(e -> e).sum() + amount;
    }

    private static String getItemName(String item) {
        String itemName = "";

        if (item.length() == 3) {
            itemName = "Cash";
        } else if (item.toLowerCase().endsWith("gem")) {
            itemName = "Gem";
        } else if (item.toLowerCase().equals("gold")) {
            itemName = "Gold";
        }

        return itemName;
    }
}