import java.util.ArrayList;
import java.util.Scanner;

// 1. THE BLUEPRINT
class Book {
    String title;
    String author;
    boolean isAvailable;

    // The constructor is now INSIDE the class
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
} // End of Book class

// 2. THE MANAGER
class Library {
    ArrayList<Book> books = new ArrayList<>();

    // Fixed spelling: addBook
    public void addBook(String title, String author) {
        Book newBook = new Book(title, author); // Added 'new' keyword
        books.add(newBook);
        System.out.println("Successfully added: " + title);
    }

    // Fixed spelling: displayBooks
    public void displayBooks() {
        System.out.println("\n--- Library Catalogue ---");
        if (books.isEmpty()) {
            System.out.println("The Library is empty");
            return;
        }

        // The for loop is now INSIDE the method
        for (Book book : books) {
            String status = book.isAvailable ? "Available" : "Borrowed";
            System.out.println("Title: " + book.title + " | Author: " + book.author + " | Status: " + status);
        }
    }
} // End of Library class

// 3. THE MAIN METHOD
public class Main {
    public static void main(String[] args) {

        Library myLibrary = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Java Library!");

        // A loop to keep the program running until the user exits
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt(); // Reads the number the user types
            scanner.nextLine(); // Clears the "Enter" key from the buffer (a Java quirk!)

            if (choice == 1) {
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();

                System.out.print("Enter book author: ");
                String author = scanner.nextLine();

                myLibrary.addBook(title, author);

            } else if (choice == 2) {
                myLibrary.displayBooks();

            } else if (choice == 3) {
                System.out.println("Goodbye!");
                running = false; // This breaks the while loop
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close(); // Always close the scanner when done
    }
}