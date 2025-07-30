package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    private static final String DB_URL = "jdbc:sqlite:library.db"; // or absolute path

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            throw new RuntimeException("Cannot connect to DB: " + e.getMessage());
        }
    }
}
