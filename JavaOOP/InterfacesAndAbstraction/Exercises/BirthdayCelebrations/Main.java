package OOP.InterfacesAndAbstractions.Exercises.BirthdayCelebrations;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Citizen> citizens = new ArrayList<>();
        List<Pet> pets = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("End")) {

            String[] data = line.split("\\s+");
            //TODO collect info

            switch (data[0]) {
                case "Citizen":
                    Citizen citizen = new Citizen(data[1], Integer.parseInt(data[2]), data[3], data[4]);
                    citizens.add(citizen);
                    break;
                case "Robot":

                    break;
                case "Pet":
                    Pet pet = new Pet(data[1], data[2]);
                    pets.add(pet);
                    break;
            }


            line = scanner.nextLine();
        }

        int specifiedYear = Integer.parseInt(scanner.nextLine());
        //TODO print all birthdays

        List<String> birthDates = new ArrayList<>();

        addBirthDates(citizens, specifiedYear, birthDates);

        addBirthDatesForPets(pets, specifiedYear, birthDates);

        for (String birthDate : birthDates) {
            System.out.println(birthDate);
        }
    }

    private static void addBirthDatesForPets(List<Pet> objects, int specifiedYear, List<String> birthDates) {
        for (Pet citizen : objects) {
            int birdYear = Integer.parseInt(citizen.getBirthDate().split("/")[2]);

            if (birdYear == specifiedYear) {
                birthDates.add(citizen.getBirthDate());
            }
        }
    }

    private static void addBirthDates(List<Citizen> objects, int specifiedYear, List<String> birthDates) {

        for (Citizen citizen : objects) {
            int birdYear = Integer.parseInt(citizen.getBirthDate().split("/")[2]);

            if (birdYear == specifiedYear) {
                birthDates.add(citizen.getBirthDate());
            }
        }
    }
}
