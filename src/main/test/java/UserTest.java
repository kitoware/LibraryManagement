package library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UserTest {

    private User user;  // Modularity: User class manages user data
    private Book book1; // Modularity: Book class manages book-related logic
    private Book book2;

    // Software Construction: JUnit lifecycle method to set up fresh test data before each test case
    @BeforeEach
    public void setUp() {
        user = new User(1, "Alice");  // Software Construction: Creating new User instance for each test
        book1 = new Book("1984", "George Orwell");  // Modularity: Book instances encapsulate book-related data
        book2 = new Book("To Kill a Mockingbird", "Harper Lee");
    }

    // Testing Concepts: Unit test case for successfully borrowing a book
    @Test
    public void testBorrowBook() {
        String result = user.borrowBook(book1);  // Defensive Programming: Ensures valid borrow operation
        
        // Assertions: Verifying correctness of borrow operation
        assertEquals("Alice borrowed 1984", result);  // Testing Concepts: assertEquals used to verify correct output
        assertTrue(book1.isBorrowed(), "Book should be marked as borrowed");  // Testing Concepts: assertTrue to validate book state
    }

    // Testing Concepts: Unit test case for borrowing multiple books
    @Test
    public void testBorrowMultipleBooks() {
        String result1 = user.borrowBook(book1);  // Testing Concepts: Borrowing multiple books
        String result2 = user.borrowBook(book2);
        
        // Assertions: Verifying correctness for both borrow operations
        assertEquals("Alice borrowed 1984", result1);  // Assertions: Verifying individual borrow actions
        assertEquals("Alice borrowed To Kill a Mockingbird", result2);
        assertTrue(book1.isBorrowed(), "Book 1 should be marked as borrowed");
        assertTrue(book2.isBorrowed(), "Book 2 should be marked as borrowed");
    }

    // Testing Concepts: Unit test case for preventing borrowing an already borrowed book
    @Test
    public void testCannotBorrowAlreadyBorrowedBook() {
        book1.borrow();  // Defensive Programming: Simulating an already borrowed book
        String result = user.borrowBook(book1);
        
        // Assertions: Verifying that borrowing a borrowed book is not allowed
        assertEquals("1984 is already borrowed", result);  // Defensive Programming: Ensuring invalid state is handled
    }

    // Testing Concepts: Unit test case for successfully returning a borrowed book
    @Test
    public void testReturnBorrowedBook() {
        user.borrowBook(book1);  // Testing Concepts: Simulating a book being borrowed
        String result = user.returnBook(book1);  // Defensive Programming: Simulating returning the borrowed book
        
        // Assertions: Verifying the book was successfully returned
        assertEquals("Alice returned 1984", result);  // Assertions: Verifying correct return message
        assertFalse(book1.isBorrowed(), "Book should not be marked as borrowed after return");  // Assertions: Verifying the book is no longer borrowed
    }

    // Testing Concepts: Unit test case for handling returning a book that was never borrowed
    @Test
    public void testCannotReturnNotBorrowedBook() {
        String result = user.returnBook(book1);  // Defensive Programming: Ensuring returning an unborrowed book fails
        
        // Assertions: Verifying invalid return operation is handled
        assertEquals("Alice does not have 1984 or it wasn't borrowed", result);  // Defensive Programming: Ensuring invalid state is avoided
        assertFalse(book1.isBorrowed(), "Book should not be marked as borrowed");  // Assertions: Ensuring book remains unborrowed
    }

    // Testing Concepts: Unit test case for returning only books that were actually borrowed by the user
    @Test
    public void testReturnOnlyBorrowedBooks() {
        user.borrowBook(book1);  // Testing Concepts: Borrowing two books
        user.borrowBook(book2);

        // Simulating returning only one of the borrowed books
        String returnResult1 = user.returnBook(book1);

        // Assertions: Verifying the correct book was returned and the other is still borrowed
        assertEquals("Alice returned 1984", returnResult1);  // Assertions: Ensuring the correct return message
        assertFalse(book1.isBorrowed(), "Book 1 should be marked as returned");  // Assertions: Verifying book return status
        assertTrue(book2.isBorrowed(), "Book 2 should still be borrowed");  // Assertions: Ensuring other book remains borrowed
    }
}
