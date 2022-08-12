package OOP.InterfacesAndAbstractions.Exercises.CollectionHierarchy;

public class MyListImpl extends Collection implements AddRemovable, Addable, MyList {

    @Override
    public String remove() {
        String item = getItems().get(0);

        getItems().remove(0);
        return item;
    }

    @Override
    public int add(String item) {
        addItem(item, 0);
        return 0;
    }

    @Override
    public int getUsed() {
        return this.size;
    }
}
