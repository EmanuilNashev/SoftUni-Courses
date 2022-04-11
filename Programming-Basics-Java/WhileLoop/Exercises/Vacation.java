package WhileLoop.Exercises;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double needMoneyForExcursion = Double.parseDouble(scanner.nextLine());
        double availableMoney = Double.parseDouble(scanner.nextLine());
        int countDays = 0;
        int countDaysSpentMoney = 0;
        double totalMoney = 0;
        boolean isEnoughMoney = false;

        while (true) {
            countDays++;

            String typeAction = scanner.nextLine();
            double saveOrSpendMoney = Double.parseDouble(scanner.nextLine());


            if (typeAction.equals("spend")) {
                countDaysSpentMoney++;
                availableMoney = availableMoney - saveOrSpendMoney;
            }
            if (typeAction.equals("save")) {
                countDaysSpentMoney = 0;
                availableMoney = availableMoney + saveOrSpendMoney;
            }
            if (availableMoney < 0){
                availableMoney = 0;
            }
            if (countDaysSpentMoney == 5) {
                isEnoughMoney = true;
                break;
            }
            if (availableMoney >= needMoneyForExcursion) {
                break;
            }


        }
        if (isEnoughMoney) {
            System.out.println("You can't save the money.");
            System.out.printf("%d", countDays);
        } else {
            System.out.printf("You saved the money for %d days.", countDays);
        }
    }
}
