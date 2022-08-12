package OOP.InterfacesAndAbstractions.Exercises.CollectionHierarchy;

public class AddRemoveCollection extends Collection implements Addable, AddRemovable {
    @Override
    public String remove() {
        String item = getItems().get(getItems().size() - 1);
        getItems().remove(getItems().size() - 1);

        return item;
    }

    @Override
    public int add(String item) {
        addItem(item, 0);
        return 0;
    }
}
