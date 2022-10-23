import ConnectorProperties.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static Constants.Queries.*;

public class RemoveVillain {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = Connector.createConnection();

        final int villainId = Integer.parseInt(scanner.nextLine());

        final PreparedStatement getMinionsCountStatement = connection.prepareStatement(GET_MINIONS_COUNT_QUERY);
        getMinionsCountStatement.setInt(1, villainId);

        final ResultSet minionsCount = getMinionsCountStatement.executeQuery();

        final PreparedStatement getVillainId = connection.prepareStatement(GET_VILLAIN_WITH_ID_QUERY);
        getVillainId.setInt(1, villainId);

        final ResultSet villain = getVillainId.executeQuery();

        if (!villain.next()) {
            System.out.println("No such villain was found");
            connection.close();
            return;
        }

        removeVillainsProcess(connection, villainId);

        System.out.println(villain.getString("name") + " was deleted");

        if (minionsCount.next()) {
            System.out.println(minionsCount.getInt("count") + " minions released");
        }

        connection.close();
    }

    private static void removeVillainsProcess(Connection connection, int villainId) throws SQLException {
        final PreparedStatement dropForeignKeyStatement = connection.prepareStatement(DROP_FOREIGN_KEY_QUERY);
        dropForeignKeyStatement.executeUpdate();

        final PreparedStatement deleteFromVillainsStatement = connection.prepareStatement(DELETE_FROM_VILLAINS_QUERY);
        deleteFromVillainsStatement.setInt(1, villainId);
        deleteFromVillainsStatement.executeUpdate();

        final PreparedStatement deleteFromMinionsVillainsStatement = connection.prepareStatement(DELETE_FROM_MINIONS_VILLAINS_QUERY);
        deleteFromMinionsVillainsStatement.setInt(1, villainId);
        deleteFromMinionsVillainsStatement.executeUpdate();

        final PreparedStatement addConstrainsStatement = connection.prepareStatement(ADD_CONSTRAINTS_QUERY);
        addConstrainsStatement.executeUpdate();
    }
}
