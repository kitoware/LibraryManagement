package library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Testing essential scenarios
public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
        library.addBook("1984", "George Orwell");
        library.addBook("The Catcher in the Rye", "J.D. Salinger");
        library.registerUser(1, "Alice");
        library.registerUser(2, "Bob");
    }

    // Equivalence testing: Book borrowing and returning works as expected
    @Test
    public void testBorrowAndReturnBook() {
        assertEquals("Alice borrowed 1984", library.borrowBook(1, "1984"));
        assertEquals("1984 is already borrowed", library.borrowBook(2, "1984"));
        assertEquals("Alice returned 1984", library.returnBook(1, "1984"));
        assertEquals("Bob borrowed 1984", library.borrowBook(2, "1984"));
    }

    // Boundary testing: Checking available books after borrowing
    @Test
    public void testFindAvailableBooks() {
        library.borrowBook(1, "1984");
        assertTrue(library.findBooks(true).contains("The Catcher in the Rye"));
        assertFalse(library.findBooks(true).contains("1984"));
    }
}
