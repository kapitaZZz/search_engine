package searchengine.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static Connection connection;

    private static String dbPassword = "skillbox";
    private static String dbLogin = "root";
    private static String dbName = "search_engine";

    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private String sql;

    public DBConnection(String sql) {
        this.sql = sql;
    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        DB_URL + dbName + "?user=" + dbLogin + "&password=" + dbPassword
                );
                connection.createStatement().execute("drop table if exist page");
                connection.createStatement().execute("CREATE TABLE page(" +
                        "id INT NOT NULL AUTO_INCREMENT, " +
                        "path TEXT NOT NULL, " +
                        "code INT NOT NULL, " +
                        "content MEDIUMTEXT NOT NULL, " +
                        "PRIMARY KEY(id), UNIQUE KEY(path(200)))");
            } catch (SQLException se) {
                se.getStackTrace();
            }
        }
        return connection;
    }

    public static Connection getReconnect() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        DB_URL + dbName + "?user=" + dbLogin + "&password=" + dbPassword);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    public static void insertQuery(String sqlQuery) {
        String sql = "INSERT INTO page(path, code, content) " +
                "VALUES" + sqlQuery + " ON DUPLICATE KEY UPDATE id = id";
        try {
            DBConnection.getReconnect().createStatement().execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
