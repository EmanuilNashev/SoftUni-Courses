package ForLoop.MoreExercises;

import java.util.Scanner;

public class BackToThePast {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double inheritedMoney = Double.parseDouble(scanner.nextLine());
        int lifeToYear = Integer.parseInt(scanner.nextLine());
        int yearsOfIvan = 17;


        for (int i = 1800; i <= lifeToYear; i++) {
            yearsOfIvan++;
            if (i % 2 == 0) {
                inheritedMoney -= 12000;
            } else {
                inheritedMoney -= 12000 + 50 * yearsOfIvan;
            }

        }
        if (inheritedMoney < 0){
            System.out.printf("He will need %.2f dollars to survive.", Math.abs(inheritedMoney));
        }else{
            System.out.printf("Yes! He will live a carefree life and will have %.2f dollars left.", inheritedMoney);
        }
    }
}
