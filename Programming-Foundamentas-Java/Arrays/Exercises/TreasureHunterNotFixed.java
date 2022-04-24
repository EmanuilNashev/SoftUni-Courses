package Arrays.Exercises;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TreasureHunterNotFixed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> treasureChest = Arrays.stream(scanner.nextLine().split("\\|")).collect(Collectors.toList());

        String line = scanner.nextLine();
        while (!line.equals("Yohoho!")) {
            String[] commands = line.split(" ");
            String action = commands[0];
            switch (action) {
                case "Loot":
                    for (int i = commands.length - 1; i > 0 ; i--) {
                        if (!treasureChest.contains(commands[i]))
                            treasureChest.add(0, commands[i]);
                    }
                    break;
                case "Drop":
                    if (Integer.parseInt(commands[1]) < 0 || Integer.parseInt(commands[1]) >= treasureChest.size()) {
                        line = scanner.nextLine();
                        continue;
                    }
                    String item = treasureChest.get(Integer.parseInt(commands[1]));
                    treasureChest.remove(Integer.parseInt(commands[1]));
                    treasureChest.add(item);
                    break;
                case "Steal":
                    List<String> stolenItems = new ArrayList<>();
                    int index = 0;
                    if (treasureChest.size() >= Integer.parseInt(commands[1])) {
                        for (int i = treasureChest.size() - 1; i >= 0; i--) {
                            index++;
                            stolenItems.add(0, treasureChest.get(i));
                            treasureChest.remove(i);
                            if (index == Integer.parseInt(commands[1])) {
                                break;
                            }
                        }
                    } else {
                        for (int i = treasureChest.size() - 1; i >= 0; i--) {
                            stolenItems.add(0, treasureChest.get(i));
                            treasureChest.remove(i);

                        }
                    }
                    System.out.println(String.join(", ", stolenItems));


                    break;
            }
            if (treasureChest.isEmpty()) {
                break;
            }
            line = scanner.nextLine();
        }
        if (treasureChest.isEmpty()) {
            System.out.println("Failed treasure hunt.");
        } else {
            double sum = 0;
            for (int i = 0; i < treasureChest.size(); i++) {
                sum += treasureChest.get(i).length();
            }
            sum = sum / treasureChest.size();
            System.out.printf("Average treasure gain: %.2f pirate credits.", sum);
        }

    }
}
