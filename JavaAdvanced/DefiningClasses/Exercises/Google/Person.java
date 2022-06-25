package DefiningClasses.Exercises.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private List<Pokemon> pokemon;
    private List<Parent> parents;
    private List<Child> children;
    private Car car;

    public Person(String name) {
        this.name = name;
        this.pokemon = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemon.add(pokemon);
    }

    public void addParent(Parent parent) {
        this.parents.add(parent);
    }

    public void addChild(Child child) {
        this.children.add(child);
    }

    public Company getCompany() {
        return this.company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<Pokemon> getPokemon() {
        return this.pokemon;
    }

    public List<Parent> getParent() {
        return this.parents;
    }

    public List<Child> getChild() {
        return this.children;
    }

    public Car getCar() {
        return this.car;
    }

    @Override
    public String toString() {
        StringBuilder company = new StringBuilder(System.lineSeparator());

        if (this.company != null) {
            company.append(this.company.getCompanyName()).append(" ")
                    .append(this.company.getDepartment()).append(" ").append(String.format("%.2f", this.company.getSalary()))
                    .append(System.lineSeparator());
        }

        String carModel = System.lineSeparator();
        String carSpeed = "";
        if (this.car != null) {
            carModel += this.car.getCarModel();
            carSpeed = " " + this.car.getCarSpeed() + System.lineSeparator();

        }
        StringBuilder pokemon = new StringBuilder(System.lineSeparator());
        if (this.pokemon.size() > 0) {
            for (Pokemon pokemon1 : this.pokemon) {
                pokemon.append(pokemon1.getPokemonName())
                        .append(" ")
                        .append(pokemon1.getPokemonType())
                        .append(System.lineSeparator());
            }
        }

        StringBuilder parents = new StringBuilder(System.lineSeparator());
        if (this.parents.size() > 0) {
            for (Parent parent : this.parents) {
                parents.append(parent.getParentName())
                        .append(" ")
                        .append(parent.getParentBirthday())
                        .append(System.lineSeparator());
            }
        }

        StringBuilder children = new StringBuilder(System.lineSeparator());
        if (this.children.size() > 0) {
            for (Child child : this.children) {
                children.append(child.getChildName())
                        .append(" ")
                        .append(child.getChildBirthday())
                        .append(System.lineSeparator());
            }
        }

        children.replace(children.length() - 1, children.length(), "");
        return this.name + System.lineSeparator()
                + "Company:" + company
                + "Car:" + carModel + carSpeed
                + "Pokemon:" + pokemon
                + "Parents:" + parents
                + "Children:" + children;
    }
}
