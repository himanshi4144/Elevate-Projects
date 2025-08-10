import java.util.*;

class Book {
    int id;
    String title;
    boolean issued;

    Book(int id, String title) {
        this.id = id;
        this.title = title;
        this.issued = false;
    }

    public String toString() {
        return id + " - " + title + (issued ? " (Issued)" : " (Available)");
    }
}

class User {
    int id;
    String name;

    User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String toString() {
        return id + " - " + name;
    }
}

class Library {
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    void addBook(Book b) {
        books.add(b);
        System.out.println("Book added!");
    }

    void addUser(User u) {
        users.add(u);
        System.out.println("User added!");
    }

    void issueBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (!b.issued) {
                    b.issued = true;
                    System.out.println("Book issued!");
                } else {
                    System.out.println("Book already issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    void returnBook(int bookId) {
        for (Book b : books) {
            if (b.id == bookId) {
                if (b.issued) {
                    b.issued = false;
                    System.out.println("Book returned!");
                } else {
                    System.out.println("Book was not issued!");
                }
                return;
            }
        }
        System.out.println("Book not found!");
    }

    void viewBooks() {
        if (books.isEmpty()) System.out.println("No books!");
        else for (Book b : books) System.out.println(b);
    }

    void viewUsers() {
        if (users.isEmpty()) System.out.println("No users!");
        else for (User u : users) System.out.println(u);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n1.Add Book  2.Add User  3.View Books  4.View Users");
            System.out.println("5.Issue Book  6.Return Book  7.Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            if (ch == 1) {
                System.out.print("Enter Book ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Title: ");
                String title = sc.nextLine();
                lib.addBook(new Book(id, title));

            } else if (ch == 2) {
                System.out.print("Enter User ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                lib.addUser(new User(id, name));

            } else if (ch == 3) {
                lib.viewBooks();

            } else if (ch == 4) {
                lib.viewUsers();

            } else if (ch == 5) {
                System.out.print("Enter Book ID to issue: ");
                int id = sc.nextInt();
                lib.issueBook(id);

            } else if (ch == 6) {
                System.out.print("Enter Book ID to return: ");
                int id = sc.nextInt();
                lib.returnBook(id);

            } else if (ch == 7) {
                System.out.println("Exiting...");
                break;

            } else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}
