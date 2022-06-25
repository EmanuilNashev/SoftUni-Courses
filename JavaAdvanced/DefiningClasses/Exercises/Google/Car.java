package DefiningClasses.Exercises.Google;

public class Car {
    private String carModel;
    private int carSpeed;

    public Car(String model, int speed){
        this.carModel = model;
        this.carSpeed = speed;
    }

    public String getCarModel(){
        return this.carModel;
    }

    public int getCarSpeed(){
        return this.carSpeed;
    }
}
