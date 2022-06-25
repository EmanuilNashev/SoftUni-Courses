package DefiningClasses.Exercises.FamilyTre;

import java.util.LinkedList;
import java.util.List;

public class FamilyTree {
    private Person head;
    private List<Person> parents;
    private List<Person> children;

    public FamilyTree() {
        parents = new LinkedList<>();
        children = new LinkedList<>();
    }

    public Person getHead() {
        return head;
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void setHead(Person head) {
        this.head = head;
    }


}
