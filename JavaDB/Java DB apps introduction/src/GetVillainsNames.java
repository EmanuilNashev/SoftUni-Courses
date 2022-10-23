import ConnectorProperties.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetVillainsNames {

    public static final String NAME_COLUMN_LABEL = "name";
    public static final String COUNT_COLUMN_LABEL = "count";

    public static final String GET_VILLAINS_NAME_AND_MINIONS_COUNT = "SELECT v.`name`, COUNT(distinct mv.`minion_id`) AS \"count\"  " +
            "FROM `villains` AS v " +
            "JOIN `minions_villains` AS mv ON v.`id` = mv.`villain_id` " +
            "GROUP BY mv.`villain_id` " +
            "HAVING `count` > 15 " +
            "ORDER BY `count` DESC;";

    public static void main(String[] args) throws SQLException {

        final Connection connection = Connector.createConnection();

        final PreparedStatement query = connection.prepareStatement(GET_VILLAINS_NAME_AND_MINIONS_COUNT);

        final ResultSet resultSet = query.executeQuery();

        while (resultSet.next()) {
            String villainName = resultSet.getString(NAME_COLUMN_LABEL);
            String minionsCount = resultSet.getString(COUNT_COLUMN_LABEL);

            System.out.println(villainName + " " + minionsCount);
        }

        connection.close();
    }
}
