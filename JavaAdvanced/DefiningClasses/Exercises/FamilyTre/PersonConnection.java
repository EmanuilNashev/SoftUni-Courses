package DefiningClasses.Exercises.FamilyTre;

public class PersonConnection {
    private String parentInfo;
    private String childInfo;

    public PersonConnection(String parentInfo, String childInfo) {
        this.parentInfo = parentInfo;
        this.childInfo = childInfo;
    }

    public String getParentInfo() {
        return parentInfo;
    }

    public String getChildInfo() {
        return childInfo;
    }
}
