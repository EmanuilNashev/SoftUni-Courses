import ConnectorProperties.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static Constants.Queries.*;

public class AddMinion {

    public static final String ID_COLUMN_LABEL = "id";
    public static final String EVILNESS_FACTOR_EVIL = "evil";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final Connection connection = Connector.createConnection();

        final String[] minionInfo = scanner.nextLine().split("\\s+");

        final String minionName = minionInfo[1];
        final int minionAge = Integer.parseInt(minionInfo[2]);
        final String minionTown = minionInfo[3];

        final String[] villainInfo = scanner.nextLine().split("\\s+");
        final String villainName = villainInfo[1];

        final PreparedStatement getTownId = connection.prepareStatement(GET_TOWN_ID_QUERY);
        getTownId.setString(1, minionTown);

        final ResultSet town = getTownId.executeQuery();

        if (!town.next()) {
            final PreparedStatement insertTown = connection.prepareStatement(INSERT_TOWN_QUERY);
            insertTown.setString(1, minionTown);
            insertTown.executeUpdate();

            System.out.println("Town " + minionTown + " was added to the database.");
        }

        final PreparedStatement insertMinion = connection.prepareStatement(INSERT_MINION_QUERY);
        insertMinion.setString(1, minionName);
        insertMinion.setInt(2, minionAge);

        if (town.next()){
            insertMinion.setInt(3, town.getInt(ID_COLUMN_LABEL));
        }

        final PreparedStatement getVillainNameAndId = connection.prepareStatement(GET_VILLAIN_NAME_AND_ID_QUERY);
        getVillainNameAndId.setString(1, villainName);


        final ResultSet villainNameAndIdSet = getVillainNameAndId.executeQuery();

        if (!villainNameAndIdSet.next()) {
            final PreparedStatement insertVillain = connection.prepareStatement(INSERT_VILLAIN_QUERY);
            insertVillain.setString(1, villainName);
            insertVillain.setString(2, EVILNESS_FACTOR_EVIL);
            insertVillain.executeUpdate();

            System.out.println("Villain " + villainName + " was added to the database.");
        }

        final PreparedStatement getMinionId = connection.prepareStatement(GET_MINION_ID_QUERY);
        getMinionId.setString(1, minionName);

        final ResultSet minionId = getMinionId.executeQuery();

        final PreparedStatement setMinionToVillain = connection.prepareStatement(SET_MINION_TO_VILLAIN_QUERY);

        if (minionId.next()) {
            setMinionToVillain.setInt(1, minionId.getInt(ID_COLUMN_LABEL));
            setMinionToVillain.setInt(2, villainNameAndIdSet.getInt(ID_COLUMN_LABEL));
            setMinionToVillain.executeUpdate();
        }

        System.out.println("Successfully added " + minionName + " to be minion of " + villainName + ".");

        connection.close();
    }
}
