package Maps.MoreExercises;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> contests = new LinkedHashMap<>();
        List<User> users = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("end of contests")) {
            String[] contestData = input.split(":");
            String contest = contestData[0];
            String password = contestData[1];
            contests.put(contest, password);

            input = scanner.nextLine();
        }

        String input2 = scanner.nextLine();
        while (!input2.equals("end of submissions")) {
            String[] userData = input2.split("=>");
            String contest = userData[0];
            String password = userData[1];
            String username = userData[2];
            int points = Integer.parseInt(userData[3]);

            checkAndSaveUser(contest, password, username, points, users, contests);


            input2 = scanner.nextLine();
        }

        User userWithMostPoints = getUserWithMostPoints(users);
        System.out.printf("Best candidate is %s with total %d points.%n", userWithMostPoints.getUserName(), userWithMostPoints.getAllPoints());
        System.out.println("Ranking:");
        List<User> orderedUsers = getOrderedUsers(users);
        for (User orderedUser : orderedUsers) {
            System.out.println(orderedUser.getUserName());
            for (String[] orderedContest : orderedUser.getOrderedContests()) {
                System.out.println("#  " + orderedContest[0] + " -> " + orderedContest[1]);
            }
        }
    }

    private static List<User> getOrderedUsers(List<User> users) {
        List<String>userNames = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {
            userNames.add(users.get(i).getUserName());
        }
        Collections.sort(userNames);
        List<User>orderedUsers = new ArrayList<>();
        for (int i = 0; i < userNames.size(); i++) {
            for (int j = 0; j < users.size(); j++) {
                if (users.get(j).getUserName().equals(userNames.get(i))){
                    orderedUsers.add(users.get(j));
                }
            }
        }
        return orderedUsers;

    }

    private static User getUserWithMostPoints(List<User> users) {
        int maxPoints = 0;
        User userWithMaxPoints = new User();

        for (User user : users) {
            if (user.getAllPoints() > maxPoints){
                maxPoints = user.getAllPoints();
                userWithMaxPoints = user;
            }
        }
        return userWithMaxPoints;

    }

    private static void checkAndSaveUser(String contest, String password, String userName, int points, List<User> users, Map<String, String> contests) {
        if (!contests.containsKey(contest)) {
            return;
        }
        if (!contests.get(contest).equals(password)) {
            return;
        }

        boolean isContainsUser = getContainsUser(users, userName);

        if (!isContainsUser) {
            User user = new User();
            user.setUserName(userName);
            String[] userContestData = new String[]{contest, "" + points};
            user.getContests().add(userContestData);
            users.add(user);
        } else {
            boolean flag = false;
            boolean isHaveContest = false;

            for (User user : users) {
                if (user.getUserName().equals(userName)) {
                    for (String[] userContest : user.getContests()) {
                        if (userContest[0].equals(contest)) {
                            isHaveContest = true;
                            if (Integer.parseInt(userContest[1]) < points) {
                                userContest[1] = "" + points;
                            }
                            flag = true;
                            break;
                        }
                    }
                    if (!isHaveContest) {
                        String[] newContest = new String[]{contest, "" + points};
                        user.getContests().add(newContest);
                        break;
                    }
                }
                if (flag) {
                    break;
                }
            }
        }
    }

    private static boolean getContainsUser(List<User> users, String userName) {
        for (User user : users) {
            if (user.getUserName().equals(userName)) {
                return true;
            }
        }
        return false;
    }

    static class User {
        String userName;
        List<String[]> contests = new ArrayList<>();


        public String getUserName() {
            return userName;
        }

        public List<String[]> getContests() {
            return contests;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public void setContests(List<String[]> contests) {
            this.contests = contests;
        }

        public int getAllPoints(){
            int sum = 0;
            for (String[] contest : contests) {
                sum+= Integer.parseInt(contest[1]);
            }
            return sum;
        }

        public List<String[]> getOrderedContests(){
            List<String[]> orderedContests = new ArrayList<>();
            for (int i = 0; i < contests.size(); i++) {
                int maxPoints = 0;
                int index = 0;
                for (int j = 0; j < contests.size(); j++) {
                    if (Integer.parseInt(contests.get(j)[1]) > maxPoints){
                        maxPoints = Integer.parseInt(contests.get(j)[1]);
                        index = j;
                    }
                }
                orderedContests.add(contests.get(index));
                contests.remove(index);
                i--;
            }
            return orderedContests;
        }
    }
}
