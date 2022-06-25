package DefiningClasses.Exercises.CarSalesman;

public class Car {
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = -1;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight) {
        this(model, engine);
        this.weight = weight;

    }

    public Car(String model, Engine engine, String color) {
        this(model, engine);
        this.color = color;
    }

    public Car(String model, Engine engine, int weight, String color) {
        this(model, engine, weight);
        this.color = color;
    }

    public String getModel(){
        return this.model;
    }
    public Engine getEngine(){
        return this.engine;
    }
    public int getWeight(){
        return this.weight;
    }
    public String getColor(){
        return this.color;
    }
}
