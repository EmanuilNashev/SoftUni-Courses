package TextProcessing.MoreExercises;

import java.lang.module.FindException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TreasureFinder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] keys = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String line = scanner.nextLine();
        while (!line.equals("find")) {
            StringBuilder string = new StringBuilder(line);

            int stringIndex = 0;
            for (int i = 0; i < keys.length; i++) {
                if (stringIndex == string.length()) {
                    break;
                }
                char decreasedChar = (char) (string.charAt(stringIndex) - keys[i]);
                string.deleteCharAt(stringIndex);
                string.insert(stringIndex, decreasedChar);

                stringIndex++;

                if (i == keys.length - 1){
                    i = -1;
                }
            }
            String findGold = string.toString().replaceFirst("&","@");
            String treasure = string.substring(findGold.indexOf("@") + 1, findGold.indexOf("&"));
            String coordinates = string.substring(string.indexOf("<") + 1, string.indexOf(">"));
            System.out.printf("Found %s at %s%n",treasure, coordinates  );
            line = scanner.nextLine();
        }



    }
}
