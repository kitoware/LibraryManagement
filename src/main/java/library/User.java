package library;

import java.util.ArrayList;
import java.util.List;

// Single Responsibility: User only handles user-specific data and borrowed books
public class User {
    private int userId;
    private String name;
    private List<Book> borrowedBooks;

    // Constructor follows modularity: userId and name are initialized separately
    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.borrowedBooks = new ArrayList<>(); // Avoid unnecessary complexity
    }

    // Polymorphism: borrowBook works differently depending on the state of the book
    public String borrowBook(Book book) {
        if (book.borrow()) {
            borrowedBooks.add(book);
            return name + " borrowed " + book.getTitle();
        } else {
            return book.getTitle() + " is already borrowed";
        }
    }

    public String returnBook(Book book) {
        if (borrowedBooks.contains(book) && book.returnBook()) {
            borrowedBooks.remove(book);
            return name + " returned " + book.getTitle();
        } else {
            return name + " does not have " + book.getTitle() + " or it wasn't borrowed";
        }
    }
}
