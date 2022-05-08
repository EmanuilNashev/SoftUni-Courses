package ObjectsAndClasses.MoreExercises;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawData {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int numberOfCars = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfCars; i++) {
            String[] carInfo = scanner.nextLine().split("\\s+");
            String model = carInfo[0];
            int engineSpeed = Integer.parseInt(carInfo[1]);
            int enginePower = Integer.parseInt(carInfo[2]);
            int cargoWeight = Integer.parseInt(carInfo[3]);
            String cargoType = carInfo[4];
            Tire tire1 = new Tire(Double.parseDouble(carInfo[5]), Integer.parseInt(carInfo[6]));
            Tire tire2 = new Tire(Double.parseDouble(carInfo[7]), Integer.parseInt(carInfo[8]));
            Tire tire3 = new Tire(Double.parseDouble(carInfo[9]), Integer.parseInt(carInfo[10]));
            Tire tire4 = new Tire(Double.parseDouble(carInfo[11]), Integer.parseInt(carInfo[12]));

            Engine engine = new Engine(engineSpeed, enginePower);
            Cargo cargo = new Cargo(cargoWeight, cargoType);
            Tire[] tires = new Tire[]{tire1, tire2, tire3, tire4};

            Car car = new Car(model, engine, cargo, tires);

            cars.add(car);
        }

        String command = scanner.nextLine();
        switch (command) {
            case "fragile":
                findFragileAndPrint(cars);
                break;
            case "flamable":
                findFlamableAndPrint(cars);
                break;
        }

    }

    private static void findFragileAndPrint(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getCargo().getType().equals("fragile")){
                for (int j = 0; j < cars.get(i).getTire().length; j++) {
                    double pressure = cars.get(i).getTire()[j].getPressure();
                    if (pressure < 1){
                        System.out.println(cars.get(i).getModel());
                        break;
                    }
                }
            }
        }

    }

    private static void findFlamableAndPrint(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).getCargo().getType().equals("flamable")){
                if (cars.get(i).getEngine().getPower() > 250){
                    System.out.println(cars.get(i).getModel());
                }
            }
        }



    }

    static class Car {
        String model;
        Engine engine;
        Cargo cargo;
        Tire[] tire;

        public Car(String model, Engine engine, Cargo cargo, Tire[] tire) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tire = tire;
        }

        public String getModel() {
            return model;
        }

        public Engine getEngine() {
            return engine;
        }

        public Cargo getCargo() {
            return cargo;
        }

        public Tire[] getTire() {
            return tire;
        }


    }

    static class Engine {
        int speed;
        int power;

        public Engine(int speed, int power) {
            this.speed = speed;
            this.power = power;
        }

        public int getPower(){
            return power;
        }
    }

    static class Cargo {
        int weight;
        String type;

        public Cargo(int weight, String type) {
            this.weight = weight;
            this.type = type;
        }

        public String getType(){
            return type;
        }
    }

    static class Tire {
        double pressure;
        int age;

        public Tire(double pressure, int age) {
            this.pressure = pressure;
            this.age = age;
        }

        public double getPressure(){
            return pressure;
        }
    }

}
