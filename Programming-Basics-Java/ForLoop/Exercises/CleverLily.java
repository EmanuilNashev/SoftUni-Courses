package ForLoop.Exercises;

import java.util.Scanner;

public class CleverLily {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int ageOfLili = Integer.parseInt(scanner.nextLine());
        double priceOfWashingMachine = Double.parseDouble(scanner.nextLine());
        int priceOfToy = Integer.parseInt(scanner.nextLine());

        double moneyForAllYears = 0;
        double toys = 0;
        double brother = 0;
        double moneyOfBirthDay = 0;

        for (int i = 1; i <= ageOfLili; i++) {

            if (i % 2 == 0) {
                brother += 1;
                moneyOfBirthDay += 10;
                moneyForAllYears = moneyForAllYears + moneyOfBirthDay;
            } else {
                toys += 1;
            }

        }
        moneyForAllYears = moneyForAllYears - brother;
        double moneyFromToys = toys * priceOfToy;
        double totalMoney = moneyForAllYears + moneyFromToys;

        double diff = Math.abs(totalMoney - priceOfWashingMachine);

        if (totalMoney >= priceOfWashingMachine){
            System.out.printf("Yes! %.2f", diff);
        }else{
            System.out.printf("No! %.2f", diff);
        }
    }
}
