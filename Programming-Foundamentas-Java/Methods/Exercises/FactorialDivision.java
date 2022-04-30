package Methods.Exercises;

import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num1 = Integer.parseInt(scanner.nextLine());
        int num2 = Integer.parseInt(scanner.nextLine());



            printTheDivision(num1, num2);




    }

//            5
//            2


    static void printTheDivision(int num1, int num2) {

        double factorialOfNum1 = num1;
        double factorialOfNum2 = num2;

        if (factorialOfNum1 == 0){
            factorialOfNum1 = 1;
        }
        for (int i = num1; i > 1; i--) {
                factorialOfNum1 *= i -1;

        }

        if (factorialOfNum2 == 0){
            factorialOfNum2 = 1;
        }
        for (int i = num2; i > 1; i--) {
            factorialOfNum2 *= i -1;
        }
        double result = factorialOfNum1 / factorialOfNum2;
        System.out.printf("%.2f",result);
    }
}
