package ObjectsAndClasses.MoreExercises;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TeamWorkProjectsNotFixedFully {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Team> teams = new ArrayList<>();
        List<String> teamNames = new ArrayList<>();
        List<String> joinedUsers = new ArrayList<>();

        //create teams
        int countOfTeams = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countOfTeams; i++) {
            String[] names = scanner.nextLine().split("-");
            String creator = names[0];
            String teamName = names[1];

            Team team = new Team(creator, teamName);

            checkAndAddTeam(team, teams, teamNames, teamName, creator, joinedUsers);
        }

        //join in teams

            List<Team>teamsToDisband = new ArrayList<>();
            String line = scanner.nextLine();
            while (!line.equals("end of assignment")) {
                String[] names = line.split("->");
                String user = names[0];
                String teamName = names[1];

                checkAndAddUser(user, teamName, teams, teamNames, joinedUsers);

                line = scanner.nextLine();
            }
            orderAndPrintTeams(teams, teamsToDisband);

    }

    private static void orderAndPrintTeams(List<Team> teams, List<Team> teamsToDisband) {
        List<Team> sortedTeams = new ArrayList<>();
        List<Team>sortedTeamsByNames = new ArrayList<>();
        for (int i = 0; i < teams.size(); i++) {
            int max = 0;
            int index = 0;
            for (int j = 0; j < teams.size(); j++) {
                if (teams.get(j).getCountOfUsers() != 0){
                    if (teams.get(j).getCountOfUsers() > max) {
                        max = teams.get(j).getCountOfUsers();
                        index = j;
                    }
                }else{
                    teamsToDisband.add(teams.get(j));
                    teams.remove(teams.get(j));
                    i--;
                }
            }

            //sorting teams by count
            if (teams.size()!=0){
                if (teams.get(index).getCountOfUsers()!=0){
                    sortedTeams.add(teams.get(index));
                    teams.remove(index);
                    i--;
                }
            }
        }
        //sorting by names
        sortByName(sortedTeams, sortedTeamsByNames);
        for (int i = 0; i < sortedTeamsByNames.size(); i++) {
            System.out.println(sortedTeamsByNames.get(i).getTeamName());
            System.out.println("- " + sortedTeamsByNames.get(i).getCreator());
            sortedTeamsByNames.get(i).getSortedUsers().forEach(e -> System.out.println("-- " + e));

        }

        List<String> teamNames = new ArrayList<>();
        System.out.println("Teams to disband:");
        sortTeamNames(teamsToDisband,teamNames);
        teamNames.forEach(System.out::println);
    }

    private static void sortByName(List<Team> sortedTeams,List<Team>sortedTeamsByNames) {
        for (int i = 0; i < sortedTeams.size(); i++) {
            Team minStudent = sortedTeams.get(i);
            int index = 0;
            for (int j = 0; j < sortedTeams.size(); j++) {
                if (sortedTeams.get(j).getTeamName().compareTo(minStudent.getTeamName()) < 0) {
                    minStudent = sortedTeams.get(j);
                    index = j;
                }
            }
            sortedTeamsByNames.add(minStudent);
            sortedTeams.remove(index);
            i--;
        }
    }

    private static void sortTeamNames(List<Team> teamsToDisband, List<String> teamNames) {
        for (int i = 0; i < teamsToDisband.size(); i++) {
            teamNames.add(teamsToDisband.get(i).getTeamName());
        }
        Collections.sort(teamNames);


    }

    private static void checkAndAddUser(String user, String teamName, List<Team> teams, List<String> teamNames, List<String> joinedUsers) {
        if (!teamNames.contains(teamName)) {
            System.out.println("Team " + teamName + " does not exist!");
            return;
        }

        if (joinedUsers.contains(user)) {
            System.out.println("Member " + user + " cannot join team " + teamName + "!");
            return;
        }

        for (int i = 0; i < teams.size(); i++) {
            if (teams.get(i).getTeamName().equals(teamName)) {
                teams.get(i).getUsers().add(user);
                joinedUsers.add(user);
                return;
            }
        }
    }

    private static void checkAndAddTeam(Team team, List<Team> teams, List<String> teamNames, String teamName, String creator, List<String> joinedUsers) {
        if (teamNames.contains(teamName)) {
            System.out.println("Team " + teamName + " was already created!");
            return;
        }
        for (int i = 0; i < teams.size(); i++) {
            String creatorName = teams.get(i).getCreator();
            if (creatorName.equals(creator)) {
                System.out.println(creator + " cannot create another team!");
                return;
            }
        }
        teamNames.add(teamName);
        teams.add(team);
        joinedUsers.add(creator);
        System.out.println("Team " + teamName + " has been created by " + creator + "!");
    }

    static class Team {
        String creator;
        String teamName;
        List<String> users = new ArrayList<>();


        public Team(String creator, String teamName) {
            this.creator = creator;
            this.teamName = teamName;
        }

        public String getCreator() {
            return creator;
        }

        public String getTeamName() {
            return teamName;
        }

        public List<String> getUsers() {
            return users;
        }

        public int getCountOfUsers() {
            int count = 0;
            for (int i = 0; i < users.size(); i++) {
                count++;
            }
            return count;
        }

        public List<String> getSortedUsers(){
            Collections.sort(users);
            return users;
        }
    }
}
