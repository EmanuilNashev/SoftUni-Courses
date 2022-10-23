import ConnectorProperties.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionsNames {

    public static final String GET_MINIONS_NAME_AND_AGE_WITH_GIVEN_VILLAIN_ID = "SELECT m.`name`, m.`age` " +
            "FROM `minions` AS m  " +
            "JOIN `minions_villains` AS mv ON m.`id` = mv.`minion_id` " +
            "JOIN `villains` AS v ON v.`id` = mv.`villain_id` " +
            "WHERE v.`id` = ?;";
    public static final String GET_VILLAIN_NAME = "SELECT `name` FROM `villains` WHERE `id` = ?;";

    public static final String NAME_COLUMN_LABEL = "name";
    public static final String MINION_AGE_COLUMN_LABEL = "age";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final Connection connection = Connector.createConnection();

        final int villainId = Integer.parseInt(scanner.nextLine());
        final PreparedStatement getMinionsInfoForVillainId = connection.prepareStatement(GET_MINIONS_NAME_AND_AGE_WITH_GIVEN_VILLAIN_ID);
        getMinionsInfoForVillainId.setInt(1, villainId);

        final PreparedStatement getVillainName = connection.prepareStatement(GET_VILLAIN_NAME);
        getVillainName.setInt(1, villainId);

        final ResultSet minionSet = getMinionsInfoForVillainId.executeQuery();
        final ResultSet villainSet = getVillainName.executeQuery();

        if (villainSet.next()){

            System.out.println("Villain: " + villainSet.getString(NAME_COLUMN_LABEL));

            int index = 1;
            while (minionSet.next()){
                System.out.println(index++ + ". " + minionSet.getString(NAME_COLUMN_LABEL) + " " + minionSet.getInt(MINION_AGE_COLUMN_LABEL));
            }
        }else {
            System.out.println("No villain with ID " + villainId + " exists in the database.");
        }

        connection.close();
    }
}
