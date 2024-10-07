package library;

import java.util.Scanner;

public class Main {

    private static Library library = new Library();  // Create a library instance
    private static Scanner scanner = new Scanner(System.in);  // Scanner for user input

    public static void main(String[] args) {
        System.out.println("Welcome to the Library Management System!");
        initializeLibrary();  // Initialize with some users and books

        boolean exit = false;

        while (!exit) {
            printMenu();
            int choice = getChoice();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    registerUser();
                    break;
                case 3:
                    borrowBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    listAvailableBooks();
                    break;
                case 6:
                    exit = true;
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Print menu options
    private static void printMenu() {
        System.out.println("\nSelect an option:");
        System.out.println("1. Add a book to the library");
        System.out.println("2. Register a new user");
        System.out.println("3. Borrow a book");
        System.out.println("4. Return a book");
        System.out.println("5. List available books");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    // Get user choice from the console
    private static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;  // Return -1 if invalid input is given
        }
    }

    // Initialize the library with some books and users
    private static void initializeLibrary() {
        System.out.println("Initializing library with some sample data...");

        // Adding some books
        library.addBook("1984", "George Orwell");
        library.addBook("To Kill a Mockingbird", "Harper Lee");
        library.addBook("The Great Gatsby", "F. Scott Fitzgerald");

        // Registering some users
        library.registerUser(1, "Alice");
        library.registerUser(2, "Bob");

        System.out.println("Initialization complete!");
    }

    // Method to add a book to the library
    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        System.out.print("Enter book author: ");
        String author = scanner.nextLine();
        String result = library.addBook(title, author);
        System.out.println(result);
    }

    // Method to register a new user
    private static void registerUser() {
        System.out.print("Enter user ID: ");
        int userId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter user name: ");
        String name = scanner.nextLine();
        String result = library.registerUser(userId, name);
        System.out.println(result);
    }

    // Method for borrowing a book
    private static void borrowBook() {
        System.out.print("Enter user ID: ");
        int userId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        String result = library.borrowBook(userId, title);
        System.out.println(result);
    }

    // Method for returning a book
    private static void returnBook() {
        System.out.print("Enter user ID: ");
        int userId = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        String result = library.returnBook(userId, title);
        System.out.println(result);
    }

    // Method to list all available (non-borrowed) books
    private static void listAvailableBooks() {
        System.out.println("Available books:");
        for (String book : library.findBooks(true)) {
            System.out.println(book);
        }
    }
}
