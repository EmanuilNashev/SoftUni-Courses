package DefiningClasses.Exercises.Google;

public class Child {
    private String childName;
    private String childBirthday;

    public Child(String childName, String childBirthday) {
        this.childName = childName;
        this.childBirthday = childBirthday;
    }

    public String getChildName(){
        return this.childName;
    }
    public String getChildBirthday(){
        return this.childBirthday;
    }
}
