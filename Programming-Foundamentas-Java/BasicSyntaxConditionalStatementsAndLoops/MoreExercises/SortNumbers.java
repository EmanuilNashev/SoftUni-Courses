package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());
        int num3 = Integer.parseInt(scanner.nextLine());

        if (num > num2 && num > num3) {
            System.out.println(num);
            System.out.println(Math.max(num2,num3));
            System.out.println(Math.min(num2,num3));
        } else if (num2 > num3 && num2 > num) {
            System.out.println(num2);
            System.out.println(Math.max(num,num3));
            System.out.println(Math.min(num,num3));
        } else {
            System.out.println(num3);
            System.out.println(Math.max(num,num2));
            System.out.println(Math.min(num,num2));
        }
    }
}
