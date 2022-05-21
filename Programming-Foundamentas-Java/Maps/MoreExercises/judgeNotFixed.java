package Maps.MoreExercises;

import java.util.*;

public class judgeNotFixed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Contest> contests = new LinkedHashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("no more time")) {
            String[] data = line.split(" -> ");
            String username = data[0];
            String contestName = data[1];
            int points = Integer.parseInt(data[2]);

            Map<String, Integer> userParameters = new LinkedHashMap<>();
            userParameters.put(username, points);
            Contest contest = new Contest(contestName, userParameters);

            if (!contests.containsKey(contestName)) {
                contests.put(contestName, contest);
            } else {
                if (contests.get(contestName).getUsers().containsKey(username)) {
                    getHigherScoreAndAdd(points, username, contests, contestName);
                } else {
                    contests.get(contestName).getUsers().put(username, points);
                }
            }


            line = scanner.nextLine();
        }

        for (Map.Entry<String, Contest> stringContestEntry : contests.entrySet()) {
            int num = 1;
            System.out.println(stringContestEntry.getKey() + ": " + stringContestEntry.getValue().participants() + " participants");
            stringContestEntry.getValue().orderUsersAscendingByPoints();
            stringContestEntry.getValue().sortUsersByNames();
            for (Map.Entry<String, Integer> stringIntegerEntry : stringContestEntry.getValue().getUsers().entrySet()) {
                System.out.println(num + ". " + stringIntegerEntry.getKey() + " <::> " + stringIntegerEntry.getValue());
                num++;
            }
        }
        System.out.println("Individual standings:");

        Map<String, Integer> users = new TreeMap<>();

        getUsersWithTotalPointsAndPrint(users, contests);

    }

    private static void getUsersWithTotalPointsAndPrint(Map<String, Integer> users, Map<String, Contest> contests) {
        for (Map.Entry<String, Contest> stringContestEntry : contests.entrySet()) {
            for (Map.Entry<String, Integer> stringIntegerEntry : stringContestEntry.getValue().getUsers().entrySet()) {
                if (users.containsKey(stringIntegerEntry.getKey())) {
                    users.put(stringIntegerEntry.getKey(), users.get(stringIntegerEntry.getKey()) + stringIntegerEntry.getValue());
                    break;
                } else {
                    users.put(stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
                }
            }
        }
        Map<String, Integer> orderedUsers = new LinkedHashMap<>();
        orderInDescendingByPoints(users, orderedUsers);





        int num = 1;
        for (Map.Entry<String, Integer> stringIntegerEntry : orderedUsers.entrySet()) {
            System.out.println(num + ". " + stringIntegerEntry.getKey() + " -> " + stringIntegerEntry.getValue());
            num++;
        }
    }

    private static void orderInDescendingByPoints(Map<String, Integer> users, Map<String, Integer> orderedUsers) {

        for (int i = 0; i < users.size(); i++) {
            int maxValue = Integer.MIN_VALUE;
            String user = "";
            for (Map.Entry<String, Integer> integerEntry : users.entrySet()) {
                if (integerEntry.getValue() > maxValue) {
                    maxValue = integerEntry.getValue();
                    user = integerEntry.getKey();
                }
            }
            orderedUsers.put(user, maxValue);
            users.remove(user);
            i--;
        }
    }

    private static void getHigherScoreAndAdd(int points, String username, Map<String, Contest> contests, String contestName) {
        contests.get(contestName).getUsers().put(username, Math.max(contests.get(contestName).getUsers().get(username), points));
    }

    static class Contest {
        String contestName;
        Map<String, Integer> users;

        public Contest(String contestName, Map<String, Integer> users) {
            this.contestName = contestName;
            this.users = users;
        }

        public String getContestName() {
            return contestName;
        }

        public void setContestName(String contestName) {
            this.contestName = contestName;
        }

        public Map<String, Integer> getUsers() {
            return users;
        }

        public void setUsers(Map<String, Integer> users) {
            this.users = users;
        }

        public void orderUsersAscendingByPoints() {
            Map<String, Integer> orderedUsers = new LinkedHashMap<>();
            for (int i = 0; i < this.users.size(); i++) {
                int maxValue = Integer.MIN_VALUE;
                String userName = "";
                for (Map.Entry<String, Integer> integerEntry : this.users.entrySet()) {
                    if (integerEntry.getValue() > maxValue) {
                        maxValue = integerEntry.getValue();
                        userName = integerEntry.getKey();
                    }
                }
                orderedUsers.put(userName, maxValue);
                this.users.remove(userName);
                i--;
            }
            this.users = orderedUsers;
        }

        public void sortUsersByNames() {
            Map<String, Integer> sorted = new TreeMap<>();
            sorted = this.users;
            this.users = new TreeMap<>();
            this.users = sorted;
        }

        public int participants() {
            return users.size();
        }
    }

    static class User {
        String userName;
        int totalPoints;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public int getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(int totalPoints) {
            this.totalPoints = totalPoints;
        }

        public User(String userName, int points) {
            this.userName = userName;
            this.totalPoints = points;
        }
    }
}
