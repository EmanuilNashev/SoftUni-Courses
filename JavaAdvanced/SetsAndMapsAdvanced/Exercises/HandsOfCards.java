package SetsAndMapsAdvanced.Exercises;

import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Set<String>> players = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String[] data = input.split(": ");
            String name = data[0];
            String[] cards = data[1].split(", ");

            HashSet<String> playerCards = new HashSet<>(Arrays.asList(cards));
            players.putIfAbsent(name, playerCards);
            players.get(name).addAll(Arrays.asList(cards));


            input = scanner.nextLine();
        }

        Map<String, Integer> playerData = new LinkedHashMap<>();
        for (Map.Entry<String, Set<String>> stringSetEntry : players.entrySet()) {
            for (String card : stringSetEntry.getValue()) {
                int cardValue = 0;
                int cardPower = 0;

                if (Character.isDigit(card.charAt(0))) {
                    cardPower = Integer.parseInt("" + card.charAt(0));
                    if (cardPower == 1) {
                        switch (card.charAt(2)) {
                            case 'C':
                                cardValue = 10;
                                break;
                            case 'D':
                                cardValue = 20;
                                break;
                            case 'H':
                                cardValue = 30;
                                break;
                            case 'S':
                                cardValue = 40;
                                break;
                        }
                    } else {
                        switch (card.charAt(1)) {
                            case 'C':
                                cardValue = cardPower;
                                break;
                            case 'D':
                                cardValue = cardPower * 2;
                                break;
                            case 'H':
                                cardValue = cardPower * 3;
                                break;
                            case 'S':
                                cardValue = cardPower * 4;
                                break;
                        }
                    }
                } else {
                    switch (card.charAt(0)) {
                        case 'J':
                            cardPower = 11;
                            break;
                        case 'Q':
                            cardPower = 12;
                            break;
                        case 'K':
                            cardPower = 13;
                            break;
                        case 'A':
                            cardPower = 14;
                            break;
                    }
                    switch (card.charAt(1)) {
                        case 'C':
                            cardValue = cardPower;
                            break;
                        case 'D':
                            cardValue = cardPower * 2;
                            break;
                        case 'H':
                            cardValue = cardPower * 3;
                            break;
                        case 'S':
                            cardValue = cardPower * 4;
                            break;
                    }
                }
                if (playerData.containsKey(stringSetEntry.getKey())) {
                    playerData.put(stringSetEntry.getKey(), playerData.get(stringSetEntry.getKey()) + cardValue);
                }else {
                    playerData.put(stringSetEntry.getKey(), cardValue);
                }
            }
        }
        playerData.forEach((k,v) -> System.out.println(k + ": " + v));
    }
}
