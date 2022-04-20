package DataTypesAndVariables.Lab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int specialSum = 0;
        int currentNum = 0;
        boolean isSpecialNum = false;
        for (int ch = 1; ch <= n; ch++) {
            currentNum = ch;
            while (ch > 0) {
                specialSum += ch % 10;
                ch = ch / 10;
            }
            isSpecialNum = (specialSum == 5) || (specialSum == 7) || (specialSum == 11);
            if (isSpecialNum){
                System.out.println(currentNum + " -> " + "True");
            }else {
                System.out.println(currentNum + " -> " + "False");
            }

            specialSum = 0;
            ch = currentNum;
        }

    }
}
