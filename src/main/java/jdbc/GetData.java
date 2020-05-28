package jdbc;

import java.sql.*;

public class GetData {

    public static void main(String[] args) throws SQLException {
        //get connection
        Connection connection = ConnectionUtils.getMyConnection();

        //create statment
        Statement statement = connection.createStatement();

        String sql = "SELECT * FROM warehouse";

        // Execute SQL statement returns a ResultSet object
        ResultSet resultSet = statement.executeQuery(sql);

        // Fetch on the ResultSet
        // Move the cursor to the next record
        while (resultSet.next()) {
            int id_product = resultSet.getInt(1);
            Timestamp date_receipt = resultSet.getTimestamp(2);
            int count_product = resultSet.getInt(3);
            String description = resultSet.getString(4);
            System.out.println("------------------");
            System.out.println("id: " + id_product);
            System.out.println("date: " + date_receipt);
            System.out.println("count: " + count_product);
            System.out.println("description: " + description);
        }

        connection.close();
    }
}
