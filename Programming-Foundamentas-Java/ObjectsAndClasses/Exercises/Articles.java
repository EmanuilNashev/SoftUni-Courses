package ObjectsAndClasses.Exercises;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Articles {

    static class Article {
        private String title;
        private String content;
        private String author;

        public Article(String title, String content, String author) {
            this.title = title;
            this.content = content;
            this.author = author;
        }

        void editContent(String title) {
            this.content = title;
        }

        void changeAuthor(String author) {
            this.author = author;
        }

        void rename(String title) {
            this.title = title;
        }

        void printArticle(String title, String content, String author) {
            System.out.printf("%s - %s: %s", title, content, author);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] parameters = scanner.nextLine().split(", ");
        Article article = new Article(parameters[0], parameters[1], parameters[2]);
        int n = Integer.parseInt(scanner.nextLine());


        for (int i = 0; i < n; i++) {
            String[] commands = scanner.nextLine().split(": ");

            switch (commands[0]) {
                case "Edit":
                    article.editContent(commands[1]);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(commands[1]);
                    break;
                case "Rename":
                    article.rename(commands[1]);
                    break;
            }
        }
        article.printArticle(article.title, article.content, article.author);


    }

}
