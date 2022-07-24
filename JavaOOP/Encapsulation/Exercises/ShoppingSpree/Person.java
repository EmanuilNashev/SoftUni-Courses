package OOP.Encapsulation.Exercises.ShoppingSpree;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        products = new ArrayList<>();
        setName(name);
        setMoney(money);
    }

    private void setName(String name) {
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name;
    }

    private void setMoney(double money) {
        if (money < 0) {
            throw new IllegalArgumentException("Money cannot be negative");
        }
        this.money = money;
    }

    public void buyProduct(Product product) {
        if (this.money < product.getCost()) {
            throw new IllegalArgumentException(String.format("%s can't afford %s", name, product.getName()));
        }

        products.add(product);
        setMoney(money - product.getCost());
    }

    public String getName() {
        return this.name;
    }

    public boolean isEmptyBag() {
        return products.isEmpty();
    }

    public void showProducts() {
        for (int i = 0; i < products.size(); i++) {
            System.out.print(products.get(i).getName());

            if (i < products.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
