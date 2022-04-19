package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String line = scanner.nextLine();


        StringBuilder stringBuilder = new StringBuilder();
        for (int i = line.length()-1; i >= 0; i--) {
            stringBuilder.append(line.charAt(i));
        }
        System.out.println(stringBuilder);
    }
}
