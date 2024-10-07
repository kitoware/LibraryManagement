package library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors; // Using streams for functional programming

// Library manages books and users (modularity, single responsibility)
public class Library {
    private List<Book> books;
    private List<User> users;

    // Constructor initializes internal state (avoiding accidental complexity)
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    // Managing complexity: addBook method abstracts book creation logic
    public String addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
        return "Book '" + title + "' by " + author + " added to the library";
    }

    // Registering users (essential complexity: user creation)
    public String registerUser(int userId, String name) {
        User user = new User(userId, name);
        users.add(user);
        return "User " + name + " registered with ID " + userId;
    }

    // Functional programming: Use of streams to find available books
    public List<String> findBooks(boolean availableOnly) {
        return books.stream()
            .filter(book -> !availableOnly || !book.isBorrowed()) // Filter books by availability
            .map(Book::getTitle)
            .collect(Collectors.toList());
    }

    // Defensive programming: Check if user and book exist before performing operations
    public String borrowBook(int userId, String bookTitle) {
        User user = findUser(userId);
        Book book = findBook(bookTitle);

        if (user == null) return "User not found";
        if (book == null) return "Book not found";

        return user.borrowBook(book);
    }

    public String returnBook(int userId, String bookTitle) {
        User user = findUser(userId);
        Book book = findBook(bookTitle);

        if (user == null) return "User not found";
        if (book == null) return "Book not found";

        return user.returnBook(book);
    }

    // Private helper method (information hiding, abstraction)
    private User findUser(int userId) {
        for (User user : users) {
            if (user.userId == userId) {
                return user;
            }
        }
        return null;
    }

    // Private helper method (information hiding, abstraction)
    private Book findBook(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }
}
