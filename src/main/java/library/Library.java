package library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<User> users;

    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public String addBook(String title, String author) {
        Book book = new Book(title, author);
        books.add(book);
        return "Book '" + title + "' by " + author + " added to the library";
    }

    public String registerUser(int userId, String name) {
        User user = new User(userId, name);
        users.add(user);
        return "User " + name + " registered with ID " + userId;
    }

    public List<String> findBooks(boolean availableOnly) {
        List<String> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (!availableOnly || !book.isBorrowed()) {
                availableBooks.add(book.getTitle());
            }
        }
        return availableBooks;
    }

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

    private User findUser(int userId) {
        for (User user : users) {
            if (user.getUserId() == userId) {  // Use the getter method
                return user;
            }
        }
        return null;
    }

    private Book findBook(String bookTitle) {
        for (Book book : books) {
            if (book.getTitle().equals(bookTitle)) {
                return book;
            }
        }
        return null;
    }
}
