/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Task2;
import Task2.Contact;
import java.util.ArrayList;
import java.util.Scanner;

public class ContactManager {
    private static ArrayList<Contact> contacts = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=== Contact Management System ===");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Thank you for using Contact Manager.");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();

        Contact c = new Contact(name, phone, email);
        contacts.add(c);
        System.out.println("Contact added successfully!");
    }

    private static void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        System.out.println("\n--- Contact List ---");
        for (Contact c : contacts) {
            c.display();
        }
    }

    private static void updateContact() {
        System.out.print("Enter name to update: ");
        String name = sc.nextLine();

        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                System.out.print("Enter new phone: ");
                String phone = sc.nextLine();
                System.out.print("Enter new email: ");
                String email = sc.nextLine();

                c.setPhone(phone);
                c.setEmail(email);
                System.out.println("Contact updated.");
                return;
            }
        }

        System.out.println("Contact not found.");
    }

    private static void deleteContact() {
        System.out.print("Enter name to delete: ");
        String name = sc.nextLine();

        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted.");
                return;
            }
        }

        System.out.println("Contact not found.");
    }
}
