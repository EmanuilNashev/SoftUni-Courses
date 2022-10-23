package ConnectorProperties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import static ConnectorProperties.Properties.*;

public class Connector {

    private static Connection connection;

    private Connector(){

    }

    public static Connection createConnection() throws SQLException {

        if (connection != null){
            return connection;
        }
        Properties properties = new Properties();

        properties.setProperty(USER_LABEL, USER_KEY);
        properties.setProperty(PASSWORD_LABEL, PASSWORD_KEY);


        connection = DriverManager.getConnection(JDBC_CONNECTION_URL, properties);
        return connection;
    }
}
