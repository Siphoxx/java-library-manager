import java.util.ArrayList;
import java.util.Scanner;

// 1. THE BLUEPRINT
class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
}

// 2. THE MANAGER
class Library {
    ArrayList<Book> books = new ArrayList<>();

    public void addBook(String title, String author) {
        Book newBook = new Book(title, author);
        books.add(newBook);
        System.out.println("Successfully added: " + title);
    }

    public void displayBooks() {
        System.out.println("\n--- Library Catalogue ---");
        if (books.isEmpty()) {
            System.out.println("The Library is empty");
            return;
        }

        for (Book book : books) {
            String status = book.isAvailable ? "Available" : "Borrowed";
            System.out.println("Title: " + book.title + " | Author: " + book.author + " | Status: " + status);
        }
    }

    // MOVED HERE: Inside the Library class!
    public void borrowBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (book.isAvailable) {
                    book.isAvailable = false;
                    System.out.println("You have successfully borrowed: " + title);
                } else {
                    System.out.println("Sorry, " + title + " is already borrowed.");
                }
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }

    // MOVED HERE: Inside the Library class!
    public void returnBook(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                if (!book.isAvailable) {
                    book.isAvailable = true;
                    System.out.println("You have successfully returned: " + title);
                } else {
                    System.out.println("That book is already in the library.");
                }
                return;
            }
        }
        System.out.println("Book not found: " + title);
    }
}

// 3. THE MAIN METHOD
public class Main {
    public static void main(String[] args) {

        Library myLibrary = new Library();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Java Library!");

        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add a Book");
            System.out.println("2. View All Books");
            System.out.println("3. Borrow a Book"); // NEW
            System.out.println("4. Return a Book"); // NEW
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Clear the buffer

            if (choice == 1) {
                System.out.print("Enter book title: ");
                String title = scanner.nextLine();
                System.out.print("Enter book author: ");
                String author = scanner.nextLine();
                myLibrary.addBook(title, author);

            } else if (choice == 2) {
                myLibrary.displayBooks();

            } else if (choice == 3) { // NEW
                System.out.print("Enter the title of the book you want to borrow: ");
                String title = scanner.nextLine();
                myLibrary.borrowBook(title);

            } else if (choice == 4) { // NEW
                System.out.print("Enter the title of the book you want to return: ");
                String title = scanner.nextLine();
                myLibrary.returnBook(title);

            } else if (choice == 5) { // UPDATED TO 5
                System.out.println("Goodbye!");
                running = false;
            } else {
                System.out.println("Invalid option. Try again.");
            }
        }

        scanner.close();
    }
}