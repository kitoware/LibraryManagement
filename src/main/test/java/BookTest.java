package library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BookTest {

    private Book book;

    // This method runs before each test case to set up a new Book object
    @BeforeEach
    public void setUp() {
        book = new Book("1984", "George Orwell");
    }

    // Test case to ensure a book is not borrowed when created
    @Test
    public void testNewBookIsNotBorrowed() {
        // assertFalse verifies that the initial state of the book is not borrowed
        assertFalse(book.isBorrowed(), "Newly created book should not be borrowed");
    }

    // Test case for borrowing a book
    @Test
    public void testBorrowBook() {
        // Attempt to borrow the book
        boolean borrowed = book.borrow();

        // Assert the book was successfully borrowed
        assertTrue(borrowed, "Book should be borrowable");
        assertTrue(book.isBorrowed(), "Book should be marked as borrowed after borrowing");
    }

    // Test case for attempting to borrow an already borrowed book
    @Test
    public void testCannotBorrowAlreadyBorrowedBook() {
        // First, borrow the book successfully
        book.borrow();

        // Attempt to borrow the book again (should fail)
        boolean borrowedAgain = book.borrow();

        // Assert that the second borrow attempt failed
        assertFalse(borrowedAgain, "Cannot borrow a book that is already borrowed");
    }

    // Test case for returning a borrowed book
    @Test
    public void testReturnBook() {
        // Borrow the book
        book.borrow();

        // Return the book
        boolean returned = book.returnBook();

        // Assert the book was successfully returned
        assertTrue(returned, "Book should be returnable after being borrowed");
        assertFalse(book.isBorrowed(), "Book should no longer be marked as borrowed after returning");
    }

    // Test case for returning a book that has not been borrowed
    @Test
    public void testCannotReturnBookNotBorrowed() {
        // Attempt to return a book that was never borrowed
        boolean returned = book.returnBook();

        // Assert that returning a non-borrowed book fails
        assertFalse(returned, "Should not be able to return a book that was never borrowed");
    }
}
