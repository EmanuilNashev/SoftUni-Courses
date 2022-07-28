package OOP.Inheritance.Exercises.animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        setName(name);
        setAge(age);
        setGender(gender);
    }

    private void setGender(String gender) {
        if (gender == null || gender.trim().isEmpty()) {
            throwException();
        }

        this.gender = gender;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throwException();
        }
        this.name = name;
    }

    private void throwException() {
        throw new IllegalArgumentException("Invalid input!");

    }

    private void setAge(int age) {
        if (age < 0) {
            throwException();
        }
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String produceSound() {
        String typeOfAnimal = this.getClass().getSimpleName();

        String sound = "";
        switch (typeOfAnimal) {
            case "Dog":
                sound = "Woof!";
                break;
            case "Cat":
                sound = "Meow meow";
                break;
            case "Kitten":
                sound = "Meow";
                break;
            case "Tomcat":
                sound = "MEOW";
                break;
            case "Frog":
                sound = "Ribbit";
                break;
        }
        return sound;
    }

    @Override
    public String toString() {
        return String.format("%s%n%s %d %s%n%s", this.getClass().getSimpleName(), name, age, gender, produceSound());
    }
}
