package library;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;  // Modularity: Book class handles book-related logic
    private List<User> users;  // Modularity: User class manages user data

    public Library() {
        this.books = new ArrayList<>();  // Software Construction: Modularity, ArrayList for managing collections
        this.users = new ArrayList<>();
    }

    // Software Construction: Method encapsulates logic for adding a book
    public String addBook(String title, String author) {
        Book book = new Book(title, author);  // Modularity: Book creation logic encapsulated in Book class
        books.add(book);
        return "Book '" + title + "' by " + author + " added to the library";  // Code Quality: Readable Code
    }

    // Software Construction: Method encapsulates logic for registering a user
    public String registerUser(int userId, String name) {
        User user = new User(userId, name);  // Modularity: User creation logic encapsulated in User class
        users.add(user);
        return "User " + name + " registered with ID " + userId;  // Code Quality: Readable Code
    }

    // Functional Programming: Using Java Streams and lambda for finding books
    public List<String> findBooks(boolean availableOnly) {
        // Streams: Using filter to process available books, Collectors.toList() to collect results
        return books.stream()
                .filter(book -> !availableOnly || !book.isBorrowed())  // Filter based on availability
                .map(Book::getTitle)  // Mapping Book objects to their titles
                .collect(Collectors.toList());  // Collecting results into a list
    }

    // Software Design: Modularity, this method delegates to user and book logic
    public String borrowBook(int userId, String bookTitle) {
        User user = findUser(userId);  // Abstraction and Information Hiding: findUser method encapsulates user search
        Book book = findBook(bookTitle);  // Abstraction and Information Hiding: findBook method encapsulates book search

        if (user == null) return "User not found";  // Defensive Programming: Null checks to avoid invalid states
        if (book == null) return "Book not found";

        return user.borrowBook(book);  // Polymorphism: borrowBook behaves differently based on book state
    }

    // Software Design: Modularity, this method delegates to user and book logic
    public String returnBook(int userId, String bookTitle) {
        User user = findUser(userId);  // Abstraction and Information Hiding: Encapsulated user search logic
        Book book = findBook(bookTitle);  // Abstraction and Information Hiding: Encapsulated book search logic

        if (user == null) return "User not found";  // Defensive Programming: Ensuring no invalid states
        if (book == null) return "Book not found";

        return user.returnBook(book);  // Polymorphism: returnBook behaves differently based on book state
    }

    // Software Design: Using Java Streams and lambda to simplify user search
    private User findUser(int userId) {
        // Streams: Using filter and findFirst to get the first matching user
        return users.stream()
                .filter(user -> user.getUserId() == userId)  // Filtering users by userId
                .findFirst()  // Getting the first match
                .orElse(null);  // Return null if no match is found
    }

    // Software Design: Using Java Streams and lambda to simplify book search
    private Book findBook(String bookTitle) {
        // Streams: Using filter and findFirst to get the first matching book
        return books.stream()
                .filter(book -> book.getTitle().equals(bookTitle))  // Filtering books by title
                .findFirst()  // Getting the first match
                .orElse(null);  // Return null if no match is found
    }
}
