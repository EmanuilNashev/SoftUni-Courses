package ForLoop.MoreExercises;

import java.util.Scanner;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());

        int untreatedPatients = 0;
        int treatedPatients = 0;
        int countDoctors = 7;
        int countDays = 0;

        for (int i = 1; i <= days; i++) {
            int patients = Integer.parseInt(scanner.nextLine());
            countDays++;
            if (countDays == 3) {
                if (untreatedPatients > treatedPatients){
                    countDoctors++;

                }
            }

            if (patients > countDoctors) {
                untreatedPatients += patients - countDoctors;
                treatedPatients += countDoctors;
            } else {
                treatedPatients += patients;
            }
            if (countDays == 3) {
                countDays = 0;
            }

        }
        System.out.printf("Treated patients: %d.%n", treatedPatients);
        System.out.printf("Untreated patients: %d.", untreatedPatients);
    }
}
