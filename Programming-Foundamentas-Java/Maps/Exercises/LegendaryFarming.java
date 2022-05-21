package Maps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

//        Shadowmourne - requires 250 Shards
//        Valanyr - requires 250 Fragments
//        Dragonwrath - requires 250 Motes


        String legendaryItem = "";
        int shards = 0;
        int fragments = 0;
        int motes = 0;
        int remainingQuantity = 0;

        Map<String, Integer> junkItems = new LinkedHashMap<>();

        boolean isEnoughQuantity = false;

        while (shards < 250 && fragments < 250 && motes < 250) {
            String[] items = scanner.nextLine().split("\\s+");

            for (int i = 1; i < items.length; i += 2) {
                items[i] = items[i].toLowerCase();
                int quantity = Integer.parseInt(items[i - 1]);
                switch (items[i]) {
                    case "shards":
                        shards += quantity;
                        if (shards >= 250) {
                            legendaryItem = "Shadowmourne";
                            isEnoughQuantity = true;
                        }
                        break;
                    case "fragments":
                        fragments += quantity;
                        if (fragments >= 250) {
                            legendaryItem = "Valanyr";
                            isEnoughQuantity = true;
                        }
                        break;
                    case "motes":
                        motes += quantity;
                        if (motes >= 250) {
                            legendaryItem = "Dragonwrath";
                            isEnoughQuantity = true;
                        }
                        break;
                    default:
                        junkItems.putIfAbsent(items[i], 0);
                        junkItems.put(items[i], junkItems.get(items[i]) + quantity);
                        break;
                }
                if (isEnoughQuantity){
                    break;
                }
            }

        }

        switch (legendaryItem) {
            case "Shadowmourne":
                shards = shards - 250;
                break;
            case "Valanyr":
                fragments = fragments - 250;
                break;
            case "Dragonwrath":
                motes = motes - 250;
                break;
        }

        printOutput(legendaryItem, shards, fragments, motes, junkItems);

    }

    private static void printOutput(String legendaryItem, int numberOfShards, int numberOfFragments, int numberOfMotes, Map<String, Integer> junkItems) {
        System.out.printf("%s obtained!%n", legendaryItem);
        System.out.printf("shards: %d%n", numberOfShards);
        System.out.printf("fragments: %d%n", numberOfFragments);
        System.out.printf("motes: %d%n", numberOfMotes);

        junkItems.forEach((k, v) -> System.out.println(k + ": " + v));
    }
}
