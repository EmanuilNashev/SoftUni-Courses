package DefiningClasses.Exercises.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engines = new HashMap<>();

        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfEngines; i++) {
            String[] engineData = scanner.nextLine().split("\\s+");

            Engine engine = getEngine(engineData);
            engines.put(engineData[0], engine);
        }

        List<Car> cars = new ArrayList<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] carData = scanner.nextLine().split("\\s+");

            Car car = getCar(carData, engines);
            cars.add(car);
        }
        printCars(cars);
    }

    private static void printCars(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine().getModel() + ":");
            System.out.println("Power: " + car.getEngine().getPower());
            if (car.getEngine().getDisplacement() != -1){
                System.out.println("Displacement: " + car.getEngine().getDisplacement());
            }else {
                System.out.println("Displacement: n/a");
            }
            System.out.println("Efficiency: " + car.getEngine().getEfficiency());
            if (car.getWeight() != -1){
                System.out.println("Weight: " + car.getWeight());
            }else {
                System.out.println("Weight: n/a");
            }
            System.out.println("Color: " + car.getColor());
        }
    }

    private static Car getCar(String[] carData, Map<String, Engine> engines) {
        String model = carData[0];
        String engineModel = carData[1];
        Engine engine = engines.get(engineModel);

        Car car = null;
        String color;
        int weight;
        switch (carData.length) {
            case 2:
                car = new Car(model, engine);
                break;
            case 3:
                if (Character.isDigit(carData[2].charAt(0))) {
                    weight = Integer.parseInt(carData[2]);
                    car = new Car(model, engine, weight);
                } else {
                    color = carData[2];
                    car = new Car(model, engine, color);
                }
                break;
            case 4:
                weight = Integer.parseInt(carData[2]);
                color = carData[3];
                car = new Car(model, engine, weight, color);
                break;
        }
        return car;
    }

    private static Engine getEngine(String[] engineData) {
        String model = engineData[0];
        int power = Integer.parseInt(engineData[1]);
        Engine engine = null;

        String efficiency;
        int displacement;
        switch (engineData.length) {
            case 2:
                engine = new Engine(model, power);
                break;
            case 3:
                if (Character.isDigit(engineData[2].charAt(0))) {
                    displacement = Integer.parseInt(engineData[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    efficiency = engineData[2];
                    engine = new Engine(model, power, efficiency);
                }
                break;
            case 4:
                displacement = Integer.parseInt(engineData[2]);
                efficiency = engineData[3];
                engine = new Engine(model, power, displacement, efficiency);
                break;
        }
        return engine;
    }
}
