package OOP.InterfacesAndAbstractions.Exercises.BirthdayCelebrations;

public class Pet implements Birthable {

    private String name;
    private String birthDate;


    public Pet(String name, String birthday) {
        this.name = name;
        this.birthDate = birthday;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    public String getName() {
        return name;
    }
}
