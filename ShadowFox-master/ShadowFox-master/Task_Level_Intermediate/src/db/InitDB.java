package db;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;

public class InitDB {
    public static void main(String[] args) {
        try (Connection conn = DBConnection.getConnection()) {
            Statement stmt = conn.createStatement();

            // Users table
            stmt.execute("CREATE TABLE IF NOT EXISTS users (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "username TEXT UNIQUE NOT NULL," +
                    "password TEXT NOT NULL)");

            // Books table
            stmt.execute("CREATE TABLE IF NOT EXISTS books (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "title TEXT NOT NULL," +
                    "author TEXT NOT NULL," +
                    "available BOOLEAN NOT NULL DEFAULT 1)");

            System.out.println("✅ Tables created successfully.");
        } catch (SQLException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
