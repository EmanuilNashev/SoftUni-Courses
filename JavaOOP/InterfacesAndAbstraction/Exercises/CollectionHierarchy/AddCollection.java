package OOP.InterfacesAndAbstractions.Exercises.CollectionHierarchy;

public class AddCollection extends Collection implements Addable {


    @Override
    public int add(String item) {
        addItem(item, getItems().size());
        return getItems().size() - 1;
    }
}
