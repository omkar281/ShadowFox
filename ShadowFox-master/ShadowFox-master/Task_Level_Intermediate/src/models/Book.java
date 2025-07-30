package models;

public class Book {
    private int id;
    private String title;
    private String author;
    private boolean available;

    public Book(String title, String author, boolean available) {
        this.title = title;
        this.author = author;
        this.available = available;
    }

    // Getters/Setters

    public String getTitle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getAuthor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public boolean isAvailable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
