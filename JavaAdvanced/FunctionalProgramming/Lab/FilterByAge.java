package Functions.Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> people = new LinkedHashMap<>();
        Map<String,Integer> filtered = new LinkedHashMap<>();

        int N = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < N; i++) {
            String[] data = scanner.nextLine().split(",\\s+");

            people.put(data[0], Integer.parseInt(data[1]));
        }

        String type = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        Predicate<Integer> predicateOlder = n -> n >= age;
        Predicate<Integer> predicateYounger = n-> n<=age;
        String data = scanner.nextLine();

        switch (type) {
            case "older":
                for (Map.Entry<String, Integer> stringIntegerEntry : people.entrySet()) {
                    if (predicateOlder.test(stringIntegerEntry.getValue())){
                        filtered.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                    }
                }

                break;
            case "younger":for (Map.Entry<String, Integer> stringIntegerEntry : people.entrySet()) {
                if (predicateYounger.test(stringIntegerEntry.getValue())){
                    filtered.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                }
            }
                break;

        }
        if (data.length()> 4){
            for (Map.Entry<String, Integer> stringIntegerEntry : filtered.entrySet()) {
                System.out.println(stringIntegerEntry.getKey() + " - " + stringIntegerEntry.getValue());
            }
        }else if (data.length() == 4){
            for (Map.Entry<String, Integer> stringIntegerEntry : filtered.entrySet()) {
                System.out.println(stringIntegerEntry.getKey());
            }
        }else {
            for (Map.Entry<String, Integer> stringIntegerEntry : filtered.entrySet()) {
                System.out.println(stringIntegerEntry.getValue());
            }
        }
    }
}
