package OOP.WorkingWithAbstraction.Exercises.CardRank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        System.out.println("Card Ranks:");

        for (CardRank value : CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value.name());
        }
    }
}
