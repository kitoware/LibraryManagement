package library;

// Single Responsibility: Book class is only responsible for book data and operations
public class Book {
    private String title;
    private String author;
    private boolean isBorrowed;

    // Constructor: initializing essential attributes (essential complexity)
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isBorrowed = false; // Accidental complexity avoided by clear design
    }

    // Abstraction: hide internal borrowing logic behind a public method
    public boolean borrow() {
        if (!isBorrowed) { // Defensive programming to ensure book isn't already borrowed
            isBorrowed = true;
            return true;
        }
        return false;
    }

    public boolean returnBook() {
        if (isBorrowed) { // Handle state transitions carefully (internal complexity management)
            isBorrowed = false;
            return true;
        }
        return false;
    }

    // Encapsulation: providing getters to access private data
    public String getTitle() {
        return title;
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }
}
