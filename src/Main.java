import java.util.ArrayList;

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
    // Added the word 'main'
    public static void main(String[] args) {

        // Fixed spelling: myLibrary
        Library myLibrary = new Library();

        myLibrary.addBook("Harry Potter", "J.K. Rowling");
        myLibrary.addBook("The Hobbit", "J.R.R. Tolkien");
        myLibrary.addBook("Clean Code", "Robert Martin");

        myLibrary.displayBooks();
    }
}