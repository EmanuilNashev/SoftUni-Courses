package DefiningClasses.Exercises.FamilyTre;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Searched person
        String input = scanner.nextLine();
        Person head = new Person(input);

//        Map<String, String> personConnection = new LinkedHashMap<>();
        List<PersonConnection> personConnections = new LinkedList<>();

        List<Person> persons = new ArrayList<>();

        String line = scanner.nextLine();
        while (!line.equals("End")) {
            String[] predecessors = line.split(" - ");
            switch (predecessors.length) {
                case 2:
                    String parentInfo = predecessors[0];
                    String childInfo = predecessors[1];

                    //TODO fix with the map
                    personConnections.add(new PersonConnection(parentInfo, childInfo));
//                    personConnection.put(parentInfo, childInfo);

                    break;
                case 1:
                    String[] personData = predecessors[0].split("\\s+");
                    String name = personData[0] + " " + personData[1];
                    String birthday = personData[2];

                    Person person = new Person(name, birthday);
                    persons.add(person);
                    if (head.getName() != null) {
                        if (name.equals(head.getName())) {
                            head.setBirthday(birthday);
                        }
                    }

                    if (head.getBirthday() != null) {
                        if (birthday.equals(head.getBirthday())) {
                            head.setName(name);
                        }
                    }

                    break;
            }
            line = scanner.nextLine();
        }

        Map<Person, Person> fullPersons = new LinkedHashMap<>();

        for (var connection : personConnections) {
            Person parent = null;
            Person child = null;

            for (Person person : persons) {
                if (parent == null) {
                    parent = getPerson(connection.getParentInfo(), person);
                    fullPersons.put(parent, new Person());
                }
                if (child == null) {
                    child = getPerson(connection.getChildInfo(), person);
                    fullPersons.put(parent, child);
                }
            }
            fullPersons.put(parent, child);
        }
        FamilyTree familyTree = new FamilyTree();
        familyTree.setHead(head);

        for (var connection : fullPersons.entrySet()) {
            if (connection.getKey() != null && connection.getValue() != null) {
                if (connection.getKey().getName().equals(head.getName())) {
                    familyTree.getChildren().add(connection.getValue());
                } else if (connection.getValue().getName().equals(head.getName())) {
                    familyTree.getParents().add(connection.getKey());
                }
            }


        }


        //TODO print output
        System.out.println(head);
        System.out.println("Parents:");
        for (Person parent : familyTree.getParents()) {
            System.out.println(parent);
        }
        System.out.println("Children:");
        for (Person child : familyTree.getChildren()) {
            System.out.println(child);
        }


    }


    private static Person getPerson(String connection, Person person) {

        if (isName(connection)) {
            if (person.getName().equals(connection)) {
                return new Person(person.getName(), person.getBirthday());
            }
        } else {
            if (person.getBirthday().equals(connection)) {
                return new Person(person.getName(), person.getBirthday());
            }
        }

        return null;
    }

    private static boolean isName(String parentInput) {
        if (!Character.isDigit(parentInput.charAt(0))) {
            return true;
        }
        return false;
    }
}
