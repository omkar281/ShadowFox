package services;

import db.DBConnection;
import models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    public void addBook(Book book) {
        try (Connection conn = DBConnection.getConnection()) {
            String query = "INSERT INTO books (title, author, available) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setBoolean(3, book.isAvailable());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection()) {
            ResultSet rs = conn.createStatement().executeQuery("SELECT * FROM books");
            while (rs.next()) {
                books.add(new Book(
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("available")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }
}
