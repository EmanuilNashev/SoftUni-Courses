package TextProcessing.MoreExercises;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HTML {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String titleOfArticle = scanner.nextLine();
        String contentOfArticle = scanner.nextLine();

        List<String> comments = new LinkedList<>();
        String line = scanner.nextLine();
        while (!line.equals("end of comments")){
            String comment = line;
            comments.add(comment);



            line = scanner.nextLine();
        }
        System.out.println("<h1>");
        System.out.println("    " + titleOfArticle);
        System.out.println("</h1>");
        System.out.println("<article>");
        System.out.println("    " + contentOfArticle);
        System.out.println("</article>");
        comments.forEach(e->System.out.println("<div>"+ System.lineSeparator() + "    " + e + System.lineSeparator() +"</div>"));

    }
}
