package DefiningClasses.Exercises.RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire tire1;
    private Tire tire2;
    private Tire tire3;
    private Tire tire4;


    public Car(String model, Engine engine, Cargo cargo, Tire tire1, Tire tire2, Tire tire3, Tire tire4) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tire1 = tire1;
        this.tire2 = tire2;
        this.tire3 = tire3;
        this.tire4 = tire4;
    }

    public boolean isTirePressureBellowOne() {
        return this.tire1.getPressure() < 1 || this.tire2.getPressure() < 1
                || this.tire3.getPressure() < 1 || this.tire4.getPressure() < 1;
    }

    public boolean isEnginePowerMoreThan250() {
        return this.engine.getPower() > 250;
    }

    public String getCargoType() {
        return this.cargo.getType();
    }

    @Override
    public String toString() {
        return this.model;
    }
}
