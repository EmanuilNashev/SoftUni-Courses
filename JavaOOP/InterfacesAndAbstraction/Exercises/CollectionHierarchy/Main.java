package OOP.InterfacesAndAbstractions.Exercises.CollectionHierarchy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] strings = scanner.nextLine().split("\\s+");
        int removeOperations = Integer.parseInt(scanner.nextLine());

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myListIMP = new MyListImpl();

        StringBuilder addCollectionSB = new StringBuilder();
        StringBuilder addRemoveCollectionSB = new StringBuilder();
        StringBuilder myListSB = new StringBuilder();

        for (String string : strings) {

            addCollectionSB.append(addCollection.add(string)).append(" ");
            addRemoveCollectionSB.append(addRemoveCollection.add(string)).append(" ");
            myListSB.append(myListIMP.add(string)).append(" ");


        }

        System.out.println(addCollectionSB);
        System.out.println(addRemoveCollectionSB);
        System.out.println(myListSB);

        addRemoveCollectionSB = new StringBuilder();
        myListSB = new StringBuilder();

        for (int i = 0; i < removeOperations; i++) {
            addRemoveCollectionSB.append(addRemoveCollection.remove()).append(" ");
            myListSB.append(myListIMP.remove()).append(" ");
        }

        System.out.println(addRemoveCollectionSB);
        System.out.println(myListSB);
    }
}
