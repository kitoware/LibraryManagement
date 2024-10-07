# Library Management System

## Overview

This project is a simple **Library Management System** implemented in Java using Gradle as the build tool. The system supports the following features:
- Adding books to the library
- Registering users
- Borrowing and returning books
- Listing available books

The project also includes **JUnit 5** test cases for the `User` and `Book` classes, along with a Gradle configuration to build and run the application.

### Author Information
- **Author**: Jaysen Kang
- **Date**: 10/6/2024

## How to Run the Project

### Prerequisites
Make sure you have the following installed:
- **Java Development Kit (JDK) 8 or later**
- **Gradle** (or use the provided Gradle wrapper)
- **Git**

### Steps to Compile and Run

1. **Clone the repository**:
    ```bash
    git clone https://github.com/kitoware/LibraryManagement
    cd LibraryManagementSystem
    ```

2. **Build the project**:
    Run the following Gradle command to compile the Java code and build the project:
    ```bash
    ./gradlew build
    ```

3. **Run the project**:
    Run the following command to execute the application:
    ```bash
    ./gradlew run
    ```

4. **Generate a JAR file**:
    If you want to generate a runnable JAR file, use the following command:
    ```bash
    ./gradlew jar
    ```

    The JAR file will be created in the `build/libs/` directory. You can run it with:
    ```bash
    java -jar build/libs/LibraryManagementSystem-1.0.jar
    ```

### How to Run the Tests

To run the JUnit tests, execute the following command:
```bash
./gradlew test
```

# Midterm Exam Study Guide

## Software Engineering Concepts

### Ad hoc development
- Not used in this project. The project is modular, uses classes (`Book`, `User`, `Library`), and follows a structured development approach.
- **Location:** `src/main/java/library`.

### Software complexity (Accidental vs. Essential complexity)
- Essential complexity is managed by separating concerns through modular class design. Classes handle specific responsibilities like managing books (`Book.java`) and users (`User.java`).
- **Location:** `src/main/java/library`.

### Software Quality (Internal vs. External)
- Internal quality is reflected in clear class structures and proper error handling, while external quality is ensured by writing unit tests.
- **Location:** JUnit tests in `src/test/java/library/BookTest.java` and `UserTest.java`.

---

## Java Concepts

### Compiling vs. Interpreting
- Handled by Gradle in this project. Java `.class` files are generated by the `./gradlew build` command and can be found in `build/classes/`.
- **Location:** `build.gradle`.

### `.java`, `.class`, and `.jar` files
- Source `.java` files are located in `src/main/java/`. After running the build, `.class` files are located in `build/classes/`, and the JAR file can be generated using `./gradlew jar`.
- **Location:** `src/main/java`, `build/classes/java/main`, `build/libs`.

### Java command line arguments
- The project can be run from the command line using `java -jar`. No specific command line arguments are required for this project, but they can be added in `Main.java`.
- **Location:** `Main.java`, `build.gradle`.

### How Java works (JDK, JRE, JVM)
- The project uses the JDK to compile Java code into `.class` files, which are executed by the JVM. The JDK, JRE, and JVM handle different aspects of compilation and execution.
- **Location:** Project structure and environment setup.

---

## Software Construction

### Git version control
- Version control is handled using Git. Commands like `git add`, `git commit`, and `git push` are essential for maintaining code versions.
- **Location:** `.gitignore` ensures unnecessary files (e.g., build files, IDE settings) are not tracked.

### Gradle Build Tool
- Gradle is used for building, running tests, and creating JAR files. Dependency management is also handled by Gradle.
- **Location:** `build.gradle`.

---

## Testing Concepts

### Primary purpose of testing
- Testing ensures that input and output behavior of methods is as expected. Unit tests for `User` and `Book` classes validate these behaviors.
- **Location:** `src/test/java/library/BookTest.java`, `UserTest.java`.

### JUnit test scenarios
- Equivalence and boundary testing are used to validate various operations like borrowing and returning books.
- **Location:** `BookTest.java`, `UserTest.java`.

### Assertions
- Common JUnit assertions like `assertEquals`, `assertTrue`, and `assertFalse` are used to check test conditions.
- **Location:** `BookTest.java`, `UserTest.java`.

---

## Defensive Programming

### Throwing and handling exceptions
- Exception handling is implemented to manage invalid operations, like trying to borrow an already borrowed book.
- **Location:** `User.java`, `Library.java`.

### Defensive programming practices
- Methods ensure that invalid states are avoided, such as returning a book that hasn't been borrowed.
- **Location:** `User.java`, `Library.java`.

---

## Code Quality

### Code Smells and Refactoring Techniques
- The code is refactored to avoid long functions and complex parameter lists. Each class has a single responsibility, promoting high cohesion.
- **Location:** `Book.java`, `User.java`, `Library.java`.

### Readable Code
- The code follows naming conventions, method extractions, and other techniques to enhance readability.
- **Location:** All classes.

---

## Functional Programming

### Java Streams
- Java Streams are used in `Library.java` to filter available books.
- **Location:** `Library.java`.

---

## Software Design Concepts

### Modularity
- The project is divided into distinct classes, each with a single responsibility (e.g., `Book` manages book-related logic, `User` manages user data).
- **Location:** `Book.java`, `User.java`, `Library.java`.

### Abstraction and Information Hiding
- Classes hide internal details, exposing only necessary methods via getters and setters.
- **Location:** `User.java`, `Library.java`.

### Polymorphism
- Methods like `borrowBook` and `returnBook` in `User.java` handle different behaviors based on the book's state.
- **Location:** `User.java`.
