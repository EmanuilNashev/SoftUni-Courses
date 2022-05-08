package ObjectsAndClasses.Exercises;

import java.util.Random;
import java.util.Scanner;

public class AdvertisementMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Random random = new Random();
        String[] phrases = new String[]{"Excellent product.", "Such a great product.", "I always use that product.", "Best product of its category.",
                "Exceptional product.", "I can’t live without this product."};
        String[] events = new String[]{"Now I feel good.", "I have succeeded with this product.", "Makes miracles. I am happy of the results!",
                "I cannot believe but now I feel awesome.", "Try it yourself, I am very satisfied.", "I feel great!"};
        String[] authors = new String[]{"Diana", "Petya", "Stella", "Elena", "Katya", "Iva", "Annie", "Eva"};
        String[] cities = new String[]{"Burgas", "Sofia", "Plovdiv", "Varna", "Ruse"};


        for (int i = 0; i < n; i++) {
            Advertisement advertisement = new Advertisement(phrases[random.nextInt(phrases.length)], events[random.nextInt(events.length)],
                    authors[random.nextInt(authors.length)], cities[random.nextInt(cities.length)]);
            System.out.printf("%s %s %s - %s.%n", advertisement.getPhrase(), advertisement.getEvent(), advertisement.getAuthor(), advertisement.getCity() );
        }
    }

    static class Advertisement {
        String phrase;
        String event;
        String Author;
        String city;

        public Advertisement(String phrase, String event, String authors, String city) {
            this.phrase = phrase;
            this.event = event;
            Author = authors;
            this.city = city;
        }

        public String getCity() {
            return city;
        }

        public String getPhrase() {
            return phrase;
        }

        public String getEvent() {
            return event;
        }

        public String getAuthor() {
            return Author;
        }
    }

}
