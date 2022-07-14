package OOP.WorkingWithAbstraction.Exercises.jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Reader {
    public static int[] readArray(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static int[] readArray(String command) {
        return Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
