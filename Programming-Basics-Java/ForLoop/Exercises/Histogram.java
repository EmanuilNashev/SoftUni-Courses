package ForLoop.Exercises;

import java.util.Scanner;

public class Histogram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        double p1 = 0;
        double p2 = 0;
        double p3 = 0;
        double p4 = 0;
        double p5 = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            if (num < 200) {
                p1++;
            } else if (num >= 200 && num <= 399) {
                p2++;
            } else if (num >= 400 && num <= 599) {
                p3++;
            } else if (num >= 600 && num <= 799) {
                p4++;
            } else if (num >= 800) {
                p5++;
            }
        }
        double p1result = p1 / n * 100;
        double p2result = p2 / n * 100;
        double p3result = p3 / n * 100;
        double p4result = p4 / n * 100;
        double p5result = p5 / n * 100;

        System.out.printf("%.2f%%%n", p1result);
        System.out.printf("%.2f%%%n", p2result);
        System.out.printf("%.2f%%%n", p3result);
        System.out.printf("%.2f%%%n", p4result);
        System.out.printf("%.2f%%%n", p5result);
    }
}
