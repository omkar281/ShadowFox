package services;

import db.DBConnection;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserService {

    public boolean register(User user) {
        try (Connection conn = DBConnection.getConnection()) {
            // Check if user already exists
            String checkSql = "SELECT * FROM users WHERE username = ?";
            PreparedStatement checkStmt = conn.prepareStatement(checkSql);
            checkStmt.setString(1, user.getUsername());
            ResultSet rs = checkStmt.executeQuery();

            if (rs.next()) {
                return false; // user exists
            }

            // Register new user
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.executeUpdate();
            return true;

        } catch (Exception e) {
            System.out.println("❌ Error in register(): " + e.getMessage());
            return false;
        }
    }

    public boolean login(String username, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (Exception e) {
            System.out.println("❌ Error in login(): " + e.getMessage());
            return false;
        }
    }
}
