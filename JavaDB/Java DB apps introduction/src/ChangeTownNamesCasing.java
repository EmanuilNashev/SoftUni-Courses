import ConnectorProperties.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Constants.Queries.*;

public class ChangeTownNamesCasing {

    public static final String COUNT_COLUMN_LABEL = "count";

    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        Connection connection = Connector.createConnection();

        final String targetCountry = scanner.nextLine();

        final PreparedStatement changeTownsNames = connection.prepareStatement(CHANGE_NAMES_OF_TOWNS_WITH_GIVEN_COUNTRY_TO_UPPER_QUERY);
        changeTownsNames.setString(1, targetCountry);
        changeTownsNames.executeUpdate();

        final PreparedStatement getCountOfChangedTownsNames = connection.prepareStatement(GET_COUNT_OF_CHANGED_TOWNS_QUERY);
        getCountOfChangedTownsNames.setString(1, targetCountry);

        final ResultSet countOfChangedTownsNames = getCountOfChangedTownsNames.executeQuery();

        final PreparedStatement getNamesOfTowns = connection.prepareStatement(GET_NAMES_OF_TOWNS_QUERY);
        getNamesOfTowns.setString(1, targetCountry);

        final ResultSet namesOfTownsSet = getNamesOfTowns.executeQuery();

        if (countOfChangedTownsNames.next() && countOfChangedTownsNames.getInt(COUNT_COLUMN_LABEL) > 0) {
            System.out.print(countOfChangedTownsNames.getInt(COUNT_COLUMN_LABEL) + " town names were affected.\n" + "[");


            List<String> townsNames = new ArrayList<>();
            while (namesOfTownsSet.next()) {
                townsNames.add(namesOfTownsSet.getString("name"));

            }

            System.out.print(String.join(", ", townsNames));
            System.out.println("]");
        }else {
            System.out.println("No town names were affected.");
        }

        connection.close();
    }
}
