import java.util.*;


// BOOK CLASS TO STORE INFO. ABOUT BOOKS

import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;
    private boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}

// Member class
class Member {
    private String name;

    public Member(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Library class
class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void borrowBook(String title, Member member) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && book.isAvailable()) {
                book.setAvailable(false);
                System.out.println(member.getName() + " borrowed " + title);
                return;
            }
        }
        System.out.println("Book is not available.");
    }

    public void returnBook(String title, Member member) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title) && !book.isAvailable()) {
                book.setAvailable(true);
                System.out.println(member.getName() + " returned " + title);
                return;
            }
        }
        System.out.println("Book was not borrowed.");
    }

    public void displayBooks() {
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.isAvailable()) {
                System.out.println(book.getTitle() + " by " + book.getAuthor());
            }
        }
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Sample data
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));

        library.addMember(new Member("Alice"));
        library.addMember(new Member("Bob"));

        library.addBook(new Book("Mansarowar", "Munshi Premchand"));
        library.addBook(new Book("Madhushala", "Dr. Harivansh Rai Bachchan"));
        library.addBook(new Book("Harry Potter", "JK Rowlling"));

        library.addMember(new Member("Mr.T"));
        library.addMember(new Member("Alex"));

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    System.out.print("Enter book title to borrow: ");
                    String borrowTitle = scanner.nextLine();
                    System.out.print("Enter member name: ");
                    String memberNameBorrow = scanner.nextLine();
                    library.borrowBook(borrowTitle, new Member(memberNameBorrow));
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = scanner.nextLine();
                    System.out.print("Enter member name: ");
                    String memberNameReturn = scanner.nextLine();
                    library.returnBook(returnTitle, new Member(memberNameReturn));
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
