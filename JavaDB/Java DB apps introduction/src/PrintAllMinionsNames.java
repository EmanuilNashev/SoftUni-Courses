import ConnectorProperties.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static Constants.Queries.SELECT_NEXT_FROM_BEGINNING;
import static Constants.Queries.SELECT_NEXT_FROM_END;

public class PrintAllMinionsNames {
    public static void main(String[] args) throws SQLException {

        Connection connection = Connector.createConnection();

        final PreparedStatement selectNextFromBeginning = connection.prepareStatement(SELECT_NEXT_FROM_BEGINNING);

        final PreparedStatement selectNextFromEnd = connection.prepareStatement(SELECT_NEXT_FROM_END);

        final ResultSet minionsCountSet = connection
                .prepareStatement("SELECT COUNT(`id`) AS 'count' FROM `minions`;")
                .executeQuery();


        final int minionsCount = minionsCountSet.next() ? minionsCountSet.getInt("count") : 0;

        List<String> minionsOutput = new ArrayList<>();

        int index = 0;

        for (int i = 0; i < minionsCount; i++) {

            if (i % 2 == 0) {
                selectNextFromBeginning.setInt(1, index);
                final ResultSet nameFromBeginning = selectNextFromBeginning.executeQuery();

                final String minionName = nameFromBeginning.next() ? nameFromBeginning.getString("name") : null;

                minionsOutput.add(minionName);
            } else {
                selectNextFromEnd.setInt(1, index++);
                final ResultSet nameFromEnd = selectNextFromEnd.executeQuery();

                final String minionName = nameFromEnd.next() ? nameFromEnd.getString("name") : null;

                minionsOutput.add(minionName);
            }

        }

        System.out.println(String.join(System.lineSeparator(), minionsOutput));
        connection.close();
    }
}
