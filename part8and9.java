import java.util.HashMap;

// Book class to represent a book
class Book {
    private String ISBN;
    private String title;
    private boolean available;

    public Book(String ISBN, String title) {
        this.ISBN = ISBN;
        this.title = title;
        this.available = true;
    }

    public String getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

// User class to represent a user of the library
class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}

// Library class to manage books and users
class Library {
    private HashMap<String, Book> books;
    private HashMap<String, User> users;

    public Library() {
        books = new HashMap<>();
        users = new HashMap<>();
    }

    // Method to add a book to the library
    public void addBook(String ISBN, String title) {
        Book book = new Book(ISBN, title);
        books.put(ISBN, book);
    }

    // Method to delete a book from the library
    public void deleteBook(String ISBN) {
        books.remove(ISBN);
    }

    // Method to checkout a book
    public void checkoutBook(String ISBN, String username) {
        Book book = books.get(ISBN);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            System.out.println("Book with ISBN " + ISBN + " checked out by user " + username);
        } else {
            System.out.println("Book not available for checkout");
        }
    }

    // Method for user authentication
    public boolean authenticate(String username, String password) {
        User user = users.get(username);
        return user != null && user.getPassword().equals(password);
    }
}
