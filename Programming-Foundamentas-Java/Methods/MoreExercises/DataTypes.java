package Methods.MoreExercises;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String dataType = scanner.nextLine();

        readAndPrint(dataType);
    }

    private static void readAndPrint(String dataType) {
        Scanner scanner = new Scanner(System.in);
        switch (dataType) {
            case "int":
                int num = Integer.parseInt(scanner.nextLine());
                int multipliedNum = num * 2;
                System.out.println(multipliedNum);
                break;
            case "real":
                double realNum = Double.parseDouble(scanner.nextLine());
                double multipliedRealNum = realNum * 1.5;

                System.out.printf("%.2f%n", multipliedRealNum);
                break;
            case "string":
                String string = scanner.nextLine();
                System.out.println("$" + string + "$");
        }
    }
}
