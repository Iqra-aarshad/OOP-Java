import java.util.ArrayList;

class Book {
    String title;
    String author;
    String isbn;
    boolean isAvailable;
    String lendingHistory;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        this.lendingHistory = "";
    }
    public void checkOut(String borrower) {
        if (isAvailable) {
            isAvailable = false;
            lendingHistory += "Borrowed by: " + borrower + "\n";
            System.out.println("Book checked out by " + borrower);
        } else {
            System.out.println("This book is unavailable.");
        }
    }

    public void returnBook(String borrower) {
        if (!isAvailable) {
            isAvailable = true;
            lendingHistory += "Returned by: " + borrower + "";
            System.out.println("Book returned by " + borrower);
        } else {
            System.out.println("This book wasn't checked out.");
        }
    }

    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN: " + isbn);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Checked out"));
        System.out.println("Lending History:\n" + lendingHistory);
    }
}

class Library {
    ArrayList<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added: " + book.title);
    }

    public Book searchBookByTitle(String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("Book not found.");
        return null;
    }

    public Book searchBookByIsbn(String isbn) {
        for (Book book : books) {
            if (book.isbn.equals(isbn)) {
                return book;
            }
        }
        System.out.println("Book not found.");
        return null;
    }

    public void checkOutBook(String isbn, String borrower) {
        Book book = searchBookByIsbn(isbn);
        if (book != null) {
            book.checkOut(borrower);
        }
    }

    public void returnBook(String isbn, String borrower) {
        Book book = searchBookByIsbn(isbn);
        if (book != null) {
            book.returnBook(borrower);
        }
    }

    public void displayAllBooks() {
        for (Book book : books) {
            book.displayBookDetails();
            System.out.println("-");
        }
    }
}

public class LibraryManagement{
    public static void main(String[] args) {
        Library library = new Library();


        Book book1 = new Book("The comfort Book", "Matt Haig", "123450");
        Book book2 = new Book("Rich and Grow Big", "Oliver Napoleon Hill", "09871");
        library.addBook(book1);
        library.addBook(book2);

        library.checkOutBook("123450", "Hande");
        library.returnBook("123450", "Afra");

        library.displayAllBooks();
    }
}
