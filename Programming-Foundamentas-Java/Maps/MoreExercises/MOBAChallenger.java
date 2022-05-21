package Maps.MoreExercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Player> playerPool = new LinkedHashMap<>();

        String line = scanner.nextLine();
        String playerName = "";
        String position = "";
        String attacker = "";
        String defender = "";
        int skill = 0;
        while (!line.equals("Season end")) {
            String[] action = line.split("( -> )|( vs )");
            if (action.length == 3) {
                playerName = action[0];
                position = action[1];
                skill = Integer.parseInt(action[2]);

                Map<String, Integer> positionAndSkill = new LinkedHashMap<>();
                positionAndSkill.put(position, skill);

                Player player = new Player();
                player.setName(playerName);
                player.setPositionsAndSkill(positionAndSkill);

                if (!playerPool.containsKey(playerName)) {
                    playerPool.put(playerName, player);
                } else {
                    if (!playerPool.get(playerName).getPositionsAndSkill().containsKey(position)) {
                        playerPool.get(playerName).getPositionsAndSkill().put(position, skill);
                    } else {
                        if (playerPool.get(playerName).getPositionsAndSkill().get(position) < skill) {
                            playerPool.get(playerName).getPositionsAndSkill().put(position, skill);
                        }
                    }
                }

            } else {
                attacker = action[0];
                defender = action[1];
                if (playerPool.containsKey(attacker) && playerPool.containsKey(defender)) {
                    comparePlayerPositions(playerPool, attacker, defender);
                }
            }

            line = scanner.nextLine();
        }


        playerPool = orderPlayersByTotalPoints(playerPool);


        for (Map.Entry<String, Player> stringPlayerEntry : playerPool.entrySet()) {
            System.out.println(stringPlayerEntry.getKey() + ": " + stringPlayerEntry.getValue().getTotalPoints() + " skill");
            for (Map.Entry<String, Integer> stringIntegerEntry : stringPlayerEntry.getValue().orderedPositions().entrySet()) {
                System.out.println(" - " + stringIntegerEntry.getKey() + " <::> " + stringIntegerEntry.getValue());
            }
        }
    }

    private static Map<String, Player> orderPlayersByTotalPoints(Map<String, Player> playerPool) {
        Map<String,Player> ordered = new LinkedHashMap<>();
        for (int i = 0; i < playerPool.size(); i++) {
            int max = Integer.MIN_VALUE;
            String playerName = "";
            Player player = new Player();
            for (Map.Entry<String, Player> stringPlayerEntry : playerPool.entrySet()) {
                if (stringPlayerEntry.getValue().getTotalPoints() > max ){
                    max = stringPlayerEntry.getValue().getTotalPoints();
                    playerName = stringPlayerEntry.getKey();
                    player = stringPlayerEntry.getValue();
                }
            }
            ordered.put(playerName, player);
            playerPool.remove(playerName);
            i--;
        }

        return ordered;
    }

    private static void comparePlayerPositions(Map<String, Player> playerPool, String attacker, String defender) {

        boolean isCommonPos = false;
        int attTotalSkills = 0;
        int defTotalSkills = 0;
        for (Map.Entry<String, Integer> attackerPositions : playerPool.get(attacker).getPositionsAndSkill().entrySet()) {
            String attPos = attackerPositions.getKey();
            int attSkills = attackerPositions.getValue();
            for (Map.Entry<String, Integer> defenderPositions : playerPool.get(defender).getPositionsAndSkill().entrySet()) {
                String defPos = defenderPositions.getKey();
                int defSkills = defenderPositions.getValue();
                if (attPos.equals(defPos)) {
                    isCommonPos = true;
                    attTotalSkills += attSkills;
                    defTotalSkills += defSkills;
                    break;
                }
            }
        }
        if (isCommonPos) {
            if (attTotalSkills > defTotalSkills) {
                playerPool.remove(defender);
            } else if (defTotalSkills > attTotalSkills) {
                playerPool.remove(attacker);
            }
        }
    }

    static class Player {
        String name;
        Map<String, Integer> positionsAndSkill;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Map<String, Integer> getPositionsAndSkill() {
            return positionsAndSkill;
        }

        public void setPositionsAndSkill(Map<String, Integer> positionsAndSkill) {
            this.positionsAndSkill = positionsAndSkill;
        }

        public int getTotalPoints() {
            int totalPoints = 0;
            for (Map.Entry<String, Integer> stringIntegerEntry : positionsAndSkill.entrySet()) {
                totalPoints += stringIntegerEntry.getValue();
            }
            return totalPoints;
        }

        public Map<String, Integer> orderedPositions() {
            Map<String, Integer> ordered = new LinkedHashMap<>();

            for (int i = 0; i < positionsAndSkill.size(); i++) {
                int max = Integer.MIN_VALUE;
                String pos = "";
                for (Map.Entry<String, Integer> integerEntry : positionsAndSkill.entrySet()) {
                    if (integerEntry.getValue() > max) {
                        max = integerEntry.getValue();
                        pos = integerEntry.getKey();
                    }
                }
                ordered.put(pos, max);
                positionsAndSkill.remove(pos);
                i--;
            }
            return ordered;
        }
    }
}
