package Arrays.Lab;

import java.util.Arrays;
import java.util.Scanner;

public class EqualArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] firstArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] secondArr = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int sum = 0;
        int index = 0;
        boolean areEqualsArr = true;
        if (firstArr.length == secondArr.length){
            for (int i = 0; i < firstArr.length ; i++) {
                if (firstArr[i]==secondArr[i]){
                    sum+=firstArr[i];
                }else {
                    index = i;
                    areEqualsArr = false;
                    break;
                }
            }
            if (areEqualsArr){
                System.out.printf("Arrays are identical. Sum: %d", sum);
            }else {
                System.out.printf("Arrays are not identical. Found difference at %d index.",index);
            }
        }
    }
}
