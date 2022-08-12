package OOP.InterfacesAndAbstractions.Exercises.CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {

    protected static final int MAXSIZE = 100;

    protected int size;
    private List<String> items;

    Collection() {
        this.items = new ArrayList<>();
        size = -1;
    }

    protected List<String> getItems() {
        return items;
    }

    public int getSize() {
        return size;
    }

    public void increaseSize() {
        this.size++;
    }

    protected void addItem(String item, int index){
        if (MAXSIZE > size) {
            getItems().add(index,item);
            increaseSize();
        }
    }
}
