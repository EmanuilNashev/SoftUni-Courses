package Generics.Lab.ListUtilities;

import java.util.List;

public class ListUtils {

    @SuppressWarnings("unchecked")
    public static <T extends Comparable> T getMin(List<T>list){
        if (list.isEmpty()){
            throw new  IllegalArgumentException("List is empty");
        }
        return list.stream().min(Comparable::compareTo).get();
    }

    public static <T extends Comparable> T getMax (List<T> list){
        if (list.isEmpty()){
            throw new  IllegalArgumentException("List is empty");
        }

        return list.stream().max(Comparable::compareTo).get();
    }
}
