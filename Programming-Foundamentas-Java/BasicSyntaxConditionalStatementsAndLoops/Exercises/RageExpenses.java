package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGameCount = Integer.parseInt(scanner.nextLine());
        double headSetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int countForHeadset = 0;
        int countForMouse = 0;
        int countForKeyboard = 0;

        double totalSum = 0;

        for (int i = 1; i <= lostGameCount; i++) {
            countForHeadset++;
            countForMouse++;
            if (countForHeadset == 2) {
                totalSum += headSetPrice;
                countForHeadset = 0;
                if (countForMouse == 3) {
                    countForKeyboard++;
                    totalSum += keyboardPrice;
                }
            }
            if (countForMouse == 3) {
                totalSum += mousePrice;
                countForMouse = 0;

            }
            if (countForKeyboard == 2) {
                totalSum += displayPrice;
                countForKeyboard = 0;
            }

        }
        System.out.printf("Rage expenses: %.2f lv.", totalSum);
    }
}
