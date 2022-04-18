package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numAsString = scanner.nextLine();
        int length = numAsString.length();
        int num = Integer.parseInt(numAsString);
        int workingNum = Integer.parseInt(numAsString);

        int sumFactorial = 0;
        while (length > 0) {

            int lastNum = 0;
            lastNum = num % 10;
            if (lastNum == 0){
                sumFactorial++;
                num = num / 10;
                length--;
                continue;
            }
            int product = lastNum;
            while (true) {
                if (lastNum - 1 > 0)
                product = product * (lastNum - 1);

                lastNum = lastNum - 1;
                if (lastNum <= 1) {
                    break;
                }

            }
            sumFactorial += product;


            num = num / 10;


            length--;
        }
        if (sumFactorial == workingNum) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}
