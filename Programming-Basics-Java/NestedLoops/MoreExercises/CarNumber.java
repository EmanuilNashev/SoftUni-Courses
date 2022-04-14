package NestedLoops.MoreExercises;

import java.util.Scanner;

public class CarNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int startNum = Integer.parseInt(scanner.nextLine());
        int endNum = Integer.parseInt(scanner.nextLine());

        for (int i = startNum; i <= endNum; i++) {
            for (int j = startNum; j <= endNum; j++) {
                for (int k = startNum; k <= endNum; k++) {
                    for (int l = startNum; l <= endNum; l++) {
                        if (i % 2 == 0 && l % 2 != 0 || i % 2 != 0 && l % 2 == 0){
                            if (i > l){
                                if ((j + k) % 2 == 0 ){
                                    System.out.print("" + i + j + k + l + " ");
                                }
                            }
                        }
                    }
                }
            }

        }
    }
}
