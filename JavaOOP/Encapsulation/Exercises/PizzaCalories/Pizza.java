package OOP.Encapsulation.Exercises.PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int countToppings) {
        setName(name);
        setToppings(countToppings);
    }

    private void setName(String name) {
        if (name.trim().isEmpty() || name.length() < 1 || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public void addToppings(Topping topping) {
        toppings.add(topping);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return name;
    }

    private void setToppings(int countToppings) {
        if (countToppings < 0 || countToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }

        this.toppings = new ArrayList<>();
    }

    public double getOverallCalories(){
        return dough.calculateCalories() + toppings.stream().mapToDouble(topping -> topping.calculateCalories()).sum();
    }
}
