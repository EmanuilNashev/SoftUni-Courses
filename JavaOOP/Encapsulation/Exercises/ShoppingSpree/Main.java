package OOP.Encapsulation.Exercises.ShoppingSpree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] personsData = scanner.nextLine().split(";");
        String[] productsData = scanner.nextLine().split(";");

        Map<String, Person> persons = new LinkedHashMap<>();
        try {
            getPersons(personsData, persons);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        Map<String, Product> products = new LinkedHashMap<>();
        try {
            getProducts(productsData, products);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        String input = scanner.nextLine();
        while (!"END".equals(input)) {
            String[] purchase = input.split("\\s+");

            String person = purchase[0];
            String product = purchase[1];

            try {
                persons.get(person).buyProduct(products.get(product));
                System.out.println(person + " bought " + product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }

        for (var person : persons.entrySet()) {

            if (person.getValue().isEmptyBag()) {
                System.out.println(person.getKey() + " - " + "Nothing bought");
                continue;
            }

            System.out.print(person.getKey() + " - ");
            person.getValue().showProducts();
            System.out.println();
        }
    }

    private static void getPersons(String[] personsData, Map<String, Person> persons) {
        for (int i = 0; i < personsData.length; i++) {
            String name = personsData[i].split("=")[0];
            double money = Double.parseDouble(personsData[i].split("=")[1]);

            Person person = new Person(name, money);
            persons.put(name, person);
        }
    }

    private static void getProducts(String[] productsData, Map<String, Product> products) {
        for (int i = 0; i < productsData.length; i++) {
            String name = productsData[i].split("=")[0];
            double cost = Double.parseDouble(productsData[i].split("=")[1]);

            Product product = new Product(name, cost);
            products.put(name, product);
        }
    }
}
