package ObjectsAndClasses.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSalesman {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Engine> engines = new ArrayList<>();

        //readEngines
        int numberOfEngines = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfEngines; i++) {
            String[] engineParameters = scanner.nextLine().split("\\s+");
            String engineModel = engineParameters[0];
            int enginePower = Integer.parseInt(engineParameters[1]);

            Engine engine = new Engine(engineModel, enginePower);

            //getOptimalParameters
            if (engineParameters.length == 3) {
                if (engineParameters[2].charAt(0) >= 48 && engineParameters[2].charAt(0) <= 57) {
                    String engineDisplacement = engineParameters[2];
                    engine.setDisplacement(engineDisplacement);
                    engine.setEfficiency("n/a");
                } else {
                    engine.setDisplacement("n/a");
                    engine.setEfficiency(engineParameters[2]);
                }
            } else if (engineParameters.length < 3) {
                engine.setDisplacement("n/a");
                engine.setEfficiency("n/a");
            } else if (engineParameters.length == 4) {
                engine.setDisplacement(engineParameters[2]);
                engine.setEfficiency(engineParameters[3]);
            }

            engines.add(engine);
        }


        List<Car> cars = new ArrayList<>();

        //readCars
        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] carParameters = scanner.nextLine().split("\\s+");
            String carModel = carParameters[0];
            String engineModel = carParameters[1];
            Engine engine = getEngine(engineModel, engines);

            Car car = new Car(carModel, engine);

            getOptimalParametersOfCar(car, carParameters);

            cars.add(car);
        }

        printCars(cars);


    }

    private static void printCars(List<Car> cars) {
        cars.forEach(System.out::println);
    }

    private static void getOptimalParametersOfCar(Car car, String[] carParameters) {
        if (carParameters.length == 2) {
            car.setWeight("n/a");
            car.setColor("n/a");
        } else if (carParameters.length == 3) {
            if (carParameters[2].charAt(0) >= 48 && carParameters[2].charAt(0) <= 57) {
                car.setWeight(carParameters[2]);
                car.setColor("n/a");
            } else {
                car.setWeight("n/a");
                car.setColor(carParameters[2]);
            }
        } else if (carParameters.length == 4) {
            car.setWeight(carParameters[2]);
            car.setColor(carParameters[3]);
        }
    }

    private static Engine getEngine(String engineModel, List<Engine> engines) {
        for (Engine engine : engines) {
            if (engine.getModel().equals(engineModel)) {
                return engine;
            }
        }
        return null;
    }


    static class Car {
        String model;
        Engine engine;

        //optimal
        String weight;

        //optimal
        String color;

        public Car(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public void setColor(String color) {
            this.color = color;
        }


        //TODO change toString parameters
        @Override
        public String toString() {
            return model + ":" + System.lineSeparator() +
                    "  " + engine.getModel() + ": " + System.lineSeparator() +
                    "    " + "Power: " + engine.getPower() + System.lineSeparator() +
                    "    " + "Displacement: " + engine.getDisplacement() + System.lineSeparator() +
                    "    " + "Efficiency: " + engine.getEfficiency() + System.lineSeparator() +
                    "  " + "Weight: " + weight + System.lineSeparator() +
                    "  " + "Color: " + color;
        }
    }

    static class Engine {
        String model;
        int power;

        //optimal
        String displacement;

        //optimal
        String efficiency;

        public Engine(String model, int power) {
            this.model = model;
            this.power = power;
        }

        public String getModel() {
            return model;
        }

        public int getPower() {
            return power;
        }

        public String getDisplacement() {
            return displacement;
        }

        public String getEfficiency() {
            return efficiency;
        }

        public void setDisplacement(String displacement) {
            this.displacement = displacement;
        }

        public void setEfficiency(String efficiency) {
            this.efficiency = efficiency;
        }
    }
}
