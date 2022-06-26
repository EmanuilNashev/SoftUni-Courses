package Generics.Lab.GenericScale;

public class Scale<T extends Comparable> {
    private T left;
    private T right;

    public Scale(T left, T right) {
        this.left = left;
        this.right = right;
    }

    public T getHeavier() {
        if (left.equals(right)) {
            return null;
        } else if (left.compareTo(right) < 0) {
            return right;
        } else {
            return left;
        }
    }
}
