package com.lms;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LibraryService libraryService = new LibraryService();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("LIBRARY MANAGEMENT SYSTEM");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Delete Book");
            System.out.println("4. Update Book");
            System.out.println("5. issued book");
            System.out.println("6. return book");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            switch (choice) {
                case 1:
                    libraryService.viewBooks();
                    break;
                case 2:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter book author: ");
                    String author = scanner.nextLine();
                    libraryService.addBook(title, author);
                    break;
                case 3:
                    System.out.print("Enter book ID to delete: ");
                    int idToDelete = scanner.nextInt();
                    libraryService.deleteBook(idToDelete);
                    break;
                case 4:
                    System.out.print("Enter book ID to update: ");
                    int idToUpdate = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter new book title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Enter new book author: ");
                    String newAuthor = scanner.nextLine();
                    libraryService.updateBook(idToUpdate, newTitle, newAuthor);
                    break;
                case 5:
                    System.out.print("Enter Book ID to issue: ");
                    int issueId = scanner.nextInt();
                    libraryService.issueBook(issueId);
                    break;
                case 6:
                    System.out.print("Enter Book ID to return: ");
                    int returnId = scanner.nextInt();
                    libraryService.returnBook(returnId);
                    break;
                case 7:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
