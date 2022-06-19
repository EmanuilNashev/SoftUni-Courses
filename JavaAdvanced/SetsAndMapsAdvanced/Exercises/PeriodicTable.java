package SetsAndMapsAdvanced.Exercises;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeSet<String> linkedHashSet = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int element = 0; element < n; element++) {
            String[] chemicalCompounds = scanner.nextLine().split("\\s+");

            linkedHashSet.addAll(Arrays.asList(chemicalCompounds));
        }
        for (String s : linkedHashSet) {
            System.out.print(s + " ");
        }
    }
}
