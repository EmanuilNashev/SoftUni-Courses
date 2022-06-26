package Generics.Lab.GenericArrayCreator;

public class Main {
    public static void main(String[] args) {

        String[] integers = ArrayCreator.create(5, "Pesho");

        for (String str : integers) {
            System.out.print(str + " ");
        }

        Integer[] integer = ArrayCreator.create(Integer.class, 5, 50);
        for (Integer integer1 : integer) {
            System.out.print(integer1 + " ");
        }
    }
}
