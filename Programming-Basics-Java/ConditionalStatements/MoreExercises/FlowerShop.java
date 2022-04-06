package ConditionalStatements.MoreExcersisesForPractice;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countMagnolias = Integer.parseInt(scanner.nextLine());
        int countHyacinths = Integer.parseInt(scanner.nextLine());
        int countRoses = Integer.parseInt(scanner.nextLine());
        int countCactus = Integer.parseInt(scanner.nextLine());
        double priceOfGift = Double.parseDouble(scanner.nextLine());

        double totalSum = countMagnolias * 3.25 + countHyacinths * 4 + countRoses * 3.50 + countCactus * 8;
        double profit = totalSum * 0.95;

        double leftOrNeedMoney = Math.abs(priceOfGift - profit);

        if (profit >= priceOfGift){
            System.out.printf("She is left with %.0f leva.", Math.floor(leftOrNeedMoney));
        }
        else{
            System.out.printf("She will have to borrow %.0f leva.", Math.ceil(leftOrNeedMoney));
        }
    }
}
