package Arrays.Exercises;


import java.util.Arrays;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] commands = line.split(" ");
            String command = commands[0];
            switch (command) {
                case "swap":
                    int e1 = numbers[Integer.parseInt(commands[1])];
                    int e2 = numbers[Integer.parseInt(commands[2])];
                    numbers[Integer.parseInt(commands[1])] = e2;
                    numbers[Integer.parseInt(commands[2])] = e1;
                    break;
                case "multiply":
                    int sum = numbers[Integer.parseInt(commands[1])] * numbers[Integer.parseInt(commands[2])];
                    numbers[Integer.parseInt(commands[1])] = sum;


                    break;
                case "decrease":
                    for (int i = 0; i < numbers.length; i++) {
                        numbers[i]--;
                    }
                    break;
            }
            line = scanner.nextLine();
        }
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i]);
            if (i < numbers.length -1){
                System.out.print(", ");
            }
        }
    }
}
