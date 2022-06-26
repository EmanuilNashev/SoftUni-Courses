package Generics.Lab.GenericScale;

import DefiningClasses.Exercises.CarSalesman.Car;

import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Scale<String> scale = new Scale<>("A", "A");

        System.out.println(scale.getHeavier());
    }
}
