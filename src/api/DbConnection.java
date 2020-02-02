
package api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {
        public static final String USERNAME = "6wMQaW2auF";
    public static final String PASSWORD = "XaYDgbYUUn";
    public static final String CONN = "jdbc:mysql://remotemysql.com:3306/6wMQaW2auF";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(CONN,USERNAME,PASSWORD);
    }
}