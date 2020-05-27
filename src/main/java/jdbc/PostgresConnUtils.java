package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresConnUtils {

    //connect to postgres
    public static Connection getPostgresConnection() throws SQLException {
        String hostName = "localhost";
        String bdName = "warehouse";
        String userName = "postgres";
        String password = "1111";

        return getPostgresConnection(hostName, bdName, userName, password);
    }

    public static Connection getPostgresConnection(String hostName, String bmName,
            String userName, String password) throws SQLException{
        String connectionURL = "jdbc:postgresql://" + hostName + "/" + bmName;

        Connection conn = DriverManager.getConnection(connectionURL, userName, password);
        return conn;
    }
}
