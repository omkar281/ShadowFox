package Task3;

import models.Book;
import models.User;
import services.BookService;
import services.UserService;

import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static UserService userService = new UserService();
    static BookService bookService = new BookService();

    public static void main(String[] args) {
        System.out.println("=== Library Management System ===");
        System.out.print("1. Register\n2. Login\nChoose option: ");
        int choice = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter username: ");
        String user = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();

        boolean loggedIn = false;
        if (choice == 1) {
            if (userService.register(new User(user, pass)))
                System.out.println("Registration successful.");
            else
                System.out.println("User already exists.");
        } else if (choice == 2) {
            if (userService.login(user, pass)) {
                loggedIn = true;
                System.out.println("Login successful.");
            } else {
                System.out.println("Invalid credentials.");
            }
        }

        while (loggedIn) {
            System.out.println("\n1. Add Book\n2. View Books\n3. Exit");
            int opt = sc.nextInt();
            sc.nextLine();

            if (opt == 1) {
                System.out.print("Book title: ");
                String title = sc.nextLine();
                System.out.print("Author: ");
                String author = sc.nextLine();
                bookService.addBook(new Book(title, author, true));
            } else if (opt == 2) {
                for (Book b : bookService.getAllBooks()) {
                    System.out.println(b.getTitle() + " by " + b.getAuthor());
                }
            } else {
                break;
            }
        }
    }
}
