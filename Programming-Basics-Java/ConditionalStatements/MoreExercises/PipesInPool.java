package ConditionalStatements.MoreExcersisesForPractice;

import com.sun.tools.javac.Main;

import java.util.Scanner;

public class PipesInPool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = Integer.parseInt(scanner.nextLine());
        int P1 = Integer.parseInt(scanner.nextLine());
        int P2 = Integer.parseInt(scanner.nextLine());
        double H = Double.parseDouble(scanner.nextLine());
        double firstPipe = P1 * H;
        double secondPipe = P2 * H;
        double total = firstPipe + secondPipe;
        double percentFull = (total / V) * 100;
        double percentFullP1 = (firstPipe / total) * 100;
        double percentFullP2 = (secondPipe / total) * 100;
        if(total < V){
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.",percentFull,
                    percentFullP1, percentFullP2);
        }
        else  {
            double overload = total - V;
            System.out.printf("For %.2f hours the pool overflows with %.2f liters.", H, overload);
        }
    }
}
