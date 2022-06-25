package DefiningClasses.Exercises.FamilyTre;

public class Person {
    private String name;
    private String birthday;

    public Person(String... args) {
        if (args.length > 0) {
            if (Character.isDigit(args[0].charAt(0))) {
                this.birthday = args[0];
            } else {
                this.name = args[0];
            }
            if (args.length == 2) {
                if (Character.isDigit(args[1].charAt(0))) {
                    this.birthday = args[1];
                } else {
                    this.name = args[0];
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return this.name + " " + this.birthday;
    }
}
