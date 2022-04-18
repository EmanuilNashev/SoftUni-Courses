package BasicSyntaxConditionalStatementsAndLoops.Exercise;

import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double money = Double.parseDouble(scanner.nextLine());
        int countStudents = Integer.parseInt(scanner.nextLine());
        double priceOfLightSabers = Double.parseDouble(scanner.nextLine());
        double priceOfRobes = Double.parseDouble(scanner.nextLine());
        double priceOfBelts = Double.parseDouble(scanner.nextLine());

        double totalPriceOfSabers = priceOfLightSabers * Math.ceil(countStudents * 1.10);
        double totalPriceOfRobes = priceOfRobes * countStudents;

        int freeBelts = 0;
        int count = 0;
        for (int i = 1; i <= countStudents; i++) {
            count++;
            if (count == 6){
                freeBelts++;
                count = 0;
            }
        }
        double totalPriceOfBelts = priceOfBelts * (countStudents - freeBelts);
        double totalPrice = totalPriceOfSabers + totalPriceOfRobes + totalPriceOfBelts;
        double diff = Math.abs(money - totalPrice);
        if (money >= totalPrice){
            System.out.printf("The money is enough - it would cost %.2flv.", totalPrice);
        }else{
            System.out.printf("George Lucas will need %.2flv more.", diff);
        }

    }
}
