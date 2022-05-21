package Maps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resources = new LinkedHashMap<>();
        int countIterations = 0;

        String line = scanner.nextLine();
        String resource = "";
        while (!line.equals("stop")) {
            countIterations++;
            if (countIterations % 2 != 0) {
                resources.putIfAbsent(line, 0);
                resource = line;
            }else{
                resources.put(resource, resources.get(resource) + Integer.parseInt(line));
                resource = "";
            }


            line = scanner.nextLine();
        }

        resources.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}
