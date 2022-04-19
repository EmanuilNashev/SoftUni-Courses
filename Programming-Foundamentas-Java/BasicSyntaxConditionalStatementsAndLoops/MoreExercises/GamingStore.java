package BasicSyntaxConditionalStatementsAndLoops.MoreExercises;

import java.util.Scanner;

public class GamingStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = Double.parseDouble(scanner.nextLine());

        String line = scanner.nextLine();

        double totalSpent = 0;
        while (!line.equals("Game Time")) {
            switch (line) {
                case "OutFall 4":
                case "RoverWatch Origins Edition":
                    if (balance >= 39.99) {
                        System.out.println("Bought " + line);
                        totalSpent+=39.99;
                        balance -= 39.99;
                    }else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "CS: OG":
                    if (balance>=15.99){
                        totalSpent+=15.99;
                        System.out.println("Bought "+line);
                        balance-=15.99;
                    }else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Zplinter Zell":
                    if (balance>= 19.99){
                        totalSpent+=19.99;
                        System.out.println("Bought " + line);
                        balance-=19.99;
                    }else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "Honored 2":
                    if (balance>=59.99){
                        totalSpent+=59.99;
                        System.out.println("Bought " + line);
                        balance-=59.99;
                    }else {
                        System.out.println("Too Expensive");
                    }
                    break;
                case "RoverWatch":
                    if (balance>=29.99){
                        totalSpent+=29.99;
                        System.out.println("Bought " + line);
                        balance-=29.99;
                    }else {
                        System.out.println("Too Expensive");
                    }
                    break;
                default:
                    System.out.println("Not Found");
                    break;
            }


            if (balance <= 0) {
                System.out.println("Out of money!");
                break;
            }


            line = scanner.nextLine();
        }
        System.out.printf("Total spent: $%.2f. ", totalSpent);
        System.out.printf("Remaining: $%.2f", balance);

    }
}
