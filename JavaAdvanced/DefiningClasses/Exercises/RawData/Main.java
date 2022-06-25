package DefiningClasses.Exercises.RawData;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");

            Car car = getCar(carInfo);
            cars.add(car);
        }

        String command = scanner.nextLine();
        switch (command) {
            case "fragile":
                printCarTypeFragile(cars);
                break;
            case "flamable":
                printCarTypeFlamable(cars);
                break;
        }
    }

    private static void printCarTypeFlamable(List<Car> cars) {
        for (Car car : cars) {
            if (car.getCargoType().equals("flamable") && car.isEnginePowerMoreThan250()) {
                System.out.println(car);
            }
        }
    }

    private static void printCarTypeFragile(List<Car> cars) {
        for (Car car : cars) {
            if (car.getCargoType().equals("fragile") && car.isTirePressureBellowOne()) {
                System.out.println(car);
            }
        }
    }

    private static Car getCar(String[] carInfo) {
        String model = carInfo[0];

        int engineSpeed = Integer.parseInt(carInfo[1]);
        int enginePower = Integer.parseInt(carInfo[2]);
        Engine engine = new Engine(engineSpeed, enginePower);

        int cargoWeight = Integer.parseInt(carInfo[3]);
        String cargoType = carInfo[4];
        Cargo cargo = new Cargo(cargoWeight, cargoType);

        double tire1Pressure = Double.parseDouble(carInfo[5]);
        int tire1Age = Integer.parseInt(carInfo[6]);
        Tire tire1 = new Tire(tire1Pressure, tire1Age);

        double tire2Pressure = Double.parseDouble(carInfo[7]);
        int tire2Age = Integer.parseInt(carInfo[8]);
        Tire tire2 = new Tire(tire2Pressure, tire2Age);

        double tire3Pressure = Double.parseDouble(carInfo[9]);
        int tire3Age = Integer.parseInt(carInfo[10]);
        Tire tire3 = new Tire(tire3Pressure, tire3Age);

        double tire4Pressure = Double.parseDouble(carInfo[11]);
        int tire4Age = Integer.parseInt(carInfo[12]);
        Tire tire4 = new Tire(tire4Pressure, tire4Age);

        return new Car(model, engine, cargo, tire1, tire2, tire3, tire4);
    }
}
