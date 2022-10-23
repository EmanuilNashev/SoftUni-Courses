import ConnectorProperties.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import static Constants.Queries.CALL_PROCEDURE_QUERY;
import static Constants.Queries.GET_MINION_NAME_AND_AGE_WHOSE_IS_INCREASED_AGE;

public class IncreaseAgeStoredProcedure {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);

        final Connection connection = Connector.createConnection();

        final int minionId = Integer.parseInt(scanner.nextLine());

        final PreparedStatement increaseMinionYearProcedureStatement = connection.prepareCall(CALL_PROCEDURE_QUERY);
        increaseMinionYearProcedureStatement.setInt(1, minionId);
        increaseMinionYearProcedureStatement.execute();


            final PreparedStatement getMinionWithIncreasedAgeStatement = connection.prepareStatement(GET_MINION_NAME_AND_AGE_WHOSE_IS_INCREASED_AGE);
            getMinionWithIncreasedAgeStatement.setInt(1, minionId);

            final ResultSet resultSet = getMinionWithIncreasedAgeStatement.executeQuery();

            if (resultSet.next()){
                System.out.println(resultSet.getString("name") + " " +resultSet.getInt("age"));
            }

    }
}
