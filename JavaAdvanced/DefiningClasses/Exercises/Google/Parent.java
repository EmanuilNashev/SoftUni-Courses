package DefiningClasses.Exercises.Google;

public class Parent {
    private String parentName;
    private String parentBirthday;

    public Parent(String name, String birthday) {
        this.parentName = name;
        this.parentBirthday = birthday;
    }

    public String getParentName(){
        return this.parentName;
    }
    public String getParentBirthday(){
        return this.parentBirthday;
    }
}
