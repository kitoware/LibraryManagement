package library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;
    private Book book1;
    private Book book2;

    // This method runs before each test to set up a fresh User and Books
    @BeforeEach
    public void setUp() {
        user = new User(1, "Alice");
        book1 = new Book("1984", "George Orwell");
        book2 = new Book("To Kill a Mockingbird", "Harper Lee");
    }

    // Test case for successfully borrowing a book
    @Test
    public void testBorrowBook() {
        String result = user.borrowBook(book1);
        
        // Verify the borrow message is correct and book is marked as borrowed
        assertEquals("Alice borrowed 1984", result);
        assertTrue(book1.isBorrowed(), "Book should be marked as borrowed");
    }

    // Test case for borrowing multiple books
    @Test
    public void testBorrowMultipleBooks() {
        String result1 = user.borrowBook(book1);
        String result2 = user.borrowBook(book2);
        
        // Verify both books were successfully borrowed
        assertEquals("Alice borrowed 1984", result1);
        assertEquals("Alice borrowed To Kill a Mockingbird", result2);
        assertTrue(book1.isBorrowed(), "Book 1 should be marked as borrowed");
        assertTrue(book2.isBorrowed(), "Book 2 should be marked as borrowed");
    }

    // Test case for attempting to borrow a book that is already borrowed
    @Test
    public void testCannotBorrowAlreadyBorrowedBook() {
        book1.borrow();  // Simulate the book already being borrowed
        String result = user.borrowBook(book1);
        
        // Verify the second borrow attempt fails
        assertEquals("1984 is already borrowed", result);
    }

    // Test case for returning a borrowed book
    @Test
    public void testReturnBorrowedBook() {
        user.borrowBook(book1);  // First borrow the book
        String result = user.returnBook(book1);
        
        // Verify the return message is correct and the book is no longer borrowed
        assertEquals("Alice returned 1984", result);
        assertFalse(book1.isBorrowed(), "Book should not be marked as borrowed after return");
    }

    // Test case for attempting to return a book that was never borrowed
    @Test
    public void testCannotReturnNotBorrowedBook() {
        String result = user.returnBook(book1);
        
        // Verify the return attempt fails since the book was never borrowed
        assertEquals("Alice does not have 1984 or it wasn't borrowed", result);
        assertFalse(book1.isBorrowed(), "Book should not be marked as borrowed");
    }

    // Test case for returning a book that was borrowed by the same user
    @Test
    public void testReturnOnlyBorrowedBooks() {
        user.borrowBook(book1);
        user.borrowBook(book2);

        // Return only one of the books
        String returnResult1 = user.returnBook(book1);

        // Verify the first book was returned and the second book is still borrowed
        assertEquals("Alice returned 1984", returnResult1);
        assertFalse(book1.isBorrowed(), "Book 1 should be marked as returned");
        assertTrue(book2.isBorrowed(), "Book 2 should still be borrowed");
    }
}
