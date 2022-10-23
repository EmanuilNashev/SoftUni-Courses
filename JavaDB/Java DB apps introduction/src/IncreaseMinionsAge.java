import ConnectorProperties.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

import static Constants.Queries.*;

public class IncreaseMinionsAge {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = Connector.createConnection();

        final int[] minionsIDs = Arrays.stream(scanner.nextLine()
                .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int minionID : minionsIDs) {
            final PreparedStatement increaseMinionAgeStatement = connection.prepareStatement(INCREASE_MINION_AGE_QUERY);
            increaseMinionAgeStatement.setInt(1, minionID);
            increaseMinionAgeStatement.executeUpdate();

            final PreparedStatement makeMinionNameToLowerCase = connection.prepareStatement(MAKE_MINION_NAME_TO_LOWER_CASE_QUERY);
            makeMinionNameToLowerCase.setInt(1, minionID);
            makeMinionNameToLowerCase.executeUpdate();
        }

        final PreparedStatement getAllMinionsStatement = connection.prepareStatement(GET_ALL_MINIONS_QUERY);

        final ResultSet minionsSet = getAllMinionsStatement.executeQuery();

        while (minionsSet.next()){
            System.out.println(minionsSet.getInt("id") + " " + minionsSet.getString("name") + " " + minionsSet.getInt("age"));
        }

        connection.close();
    }
}
