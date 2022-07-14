package OOP.WorkingWithAbstraction.Exercises.CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String cardRank = scanner.nextLine();
        String cardSuit = scanner.nextLine();

        Rank rank = Enum.valueOf(Rank.class, cardRank);
        Suit suit = Enum.valueOf(Suit.class, cardSuit);

        Card card = new Card(rank, suit);

        System.out.println(card);


    }
}
