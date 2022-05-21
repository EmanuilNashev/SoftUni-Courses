package Maps.MoreExercises;

import java.util.*;

public class SnowWhite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Dwarf> dwarfs = new ArrayList<>();

        String line = scanner.nextLine();

        while (!line.equals("Once upon a time")) {
            String[] data = line.split(" <:> ");
            String name = data[0];
            String hatColor = data[1];
            int physics = Integer.parseInt(data[2]);

            Dwarf dwarf = new Dwarf(name, hatColor, physics);

            if (dwarfs.isEmpty()) {
                dwarfs.add(dwarf);
                continue;
            }

            checkAndAdd(dwarf, dwarfs, name, hatColor, physics);


            line = scanner.nextLine();
        }

        dwarfs = orderByPoints(dwarfs);

//        dwarfs = orderByHats(dwarfs);


        dwarfs.forEach(e -> System.out.println("(" + e.getHatColor() + ") " + e.getName() + " <-> " + e.getPhysics()));
    }

//    private static List<Dwarf> orderByHats(List<Dwarf> dwarfs) {
//        Map<Integer, List<Dwarf>> map = new LinkedHashMap<>();
//
//        List<Dwarf> list = new ArrayList<>();
//        for (int i = 0; i < dwarfs.size(); i++) {
//            int count = 1;
//            list.add(dwarfs.get(i));
//            for (int j = 1; j < dwarfs.size(); j++) {
//                if (dwarfs.get(i).getHatColor().equals(dwarfs.get(j).getHatColor())) {
//                 list.add(dwarfs.get(j));
//                 count++;
//                 dwarfs.remove(j);
//                 j--;
//                }
//            }
//            dwarfs.remove(i);
//            i--;
//            map.put(count, list);
//        }
//        //TODO order all by hats
//return
//    }

    private static List<Dwarf> orderByPoints(List<Dwarf> dwarfs) {

        List<Dwarf> ordered = new ArrayList<>();
        for (int i = 0; i < dwarfs.size(); i++) {
            int max = Integer.MIN_VALUE;
            Dwarf dwarfClass = new Dwarf();
            int index = 0;
            for (int j = 0; j < dwarfs.size(); j++) {
                if (dwarfs.get(j).getPhysics() > max) {
                    max = dwarfs.get(j).getPhysics();
                    dwarfClass = dwarfs.get(j);
                    index = j;
                }
            }
            ordered.add(dwarfClass);
            dwarfs.remove(index);
            i--;
        }
        dwarfs = ordered;
        return dwarfs;
    }

    private static void checkAndAdd(Dwarf dwarf, List<Dwarf> dwarfs, String name, String hatColor, int physics) {
        for (int i = 0; i < dwarfs.size(); i++) {
            if (dwarfs.get(i).getName().equals(name)) {
                if (dwarfs.get(i).getHatColor().equals(hatColor)) {
                    if (dwarfs.get(i).getPhysics() < physics) {
                        dwarfs.set(i, dwarf);
                    }
                } else {
                    dwarfs.add(dwarf);
                }
                return;
            }
        }
        dwarfs.add(dwarf);
    }

    static class Dwarf {
        String name;
        String hatColor;
        int physics;

        public Dwarf() {

        }

        public Dwarf(String name, String hatColor, int physics) {
            this.name = name;
            this.hatColor = hatColor;
            this.physics = physics;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHatColor() {
            return hatColor;
        }

        public void setHatColor(String hatColor) {
            this.hatColor = hatColor;
        }

        public int getPhysics() {
            return physics;
        }

        public void setPhysics(int physics) {
            this.physics = physics;
        }
    }
}
