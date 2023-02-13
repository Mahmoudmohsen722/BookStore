package bookstore;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Mahmoud Mohsen
 * 
 **/

public class BookList {

    Scanner sc = new Scanner(System.in);
    private final ArrayList<Book> bookList = new ArrayList();

    //Private constructor, to make other classes can't create objects
    //singleton class
    private BookList() {
    }
    
    //Create a private object to be accessed only by methods of the class
    private final static BookList bookListInstance = new BookList();
    
    //Method that returns the only object created
    public static BookList getInstance() {
        return bookListInstance;
    }

    
    //Method to display all books exist in my ArrayList
    public void displayAllBooks() {
        if (bookList.isEmpty()) {
            System.out.println("NO BOOKS!!");
        }
        else {
            System.out.println("Here are all books exist...");
            for (Book book : bookList) {
                System.out.println(book.toString());
            }
        }
    }

    //Method to add new books
    public void addBook() {
        
        int numberOfBooks = 0;
        
        while(numberOfBooks <= 0){
            System.out.println("Enter the number of books you want to add: ");
            numberOfBooks = sc.nextInt();
            if (numberOfBooks <= 0) {
                System.out.println("Enter a positive number");
            }
        }
        
        
        for (int i = 0; i < numberOfBooks; i++) {
            Book book = new Book();
            System.out.println("For book number " + (i + 1));
            System.out.println("Enter Name: ");
            book.setName(sc.next());
            
            Book existedBookA = getBookObject(book.getName());
            
            //Check if the book already exists, because the name should be unique
            if (existedBookA == null) {
                System.out.println("Enter Author: ");
                book.setAuthor(sc.next());
                System.out.println("Enter Price: ");
                book.setPrice(sc.nextDouble());

                bookListInstance.bookList.add(book);
                System.out.println("Book has been added successfully...");
            }
            else {
                System.out.println("This book already exists");
            }
            
        }
    }

    //Method returns the book object by its name, only available to this class
    private Book getBookObject(String name) {
        for (Book book : bookList) {
            if (book.getName().equals(name)) {
                return book;
            }
        }
        return null;
    }

    //Method to update an existed book
    public void updateBook() {
        int choice;
        boolean exit = false;
        if (bookList.isEmpty()) {
            System.out.println("NO BOOKS!!");
        }
        else {
            System.out.println("Pleace enter book's name you want to UPDATE: ");
            String bookName = sc.next();
            Book bookToUpdate = getBookObject(bookName);

            if (bookToUpdate == null) {
                System.out.println("No book found with this name!!");
            }
            else {
                while (!exit) {
                    System.out.println("----------Update Menu----------");
                    System.out.println("1- Update book name");
                    System.out.println("2- Update book author");
                    System.out.println("3- Update book price");
                    System.out.println("4- Back to main menu");
                    System.out.println("Enter update option");
                    choice = sc.nextInt();

                    switch (choice) {
                        case 1 -> {
                            System.out.println("Please enter book's new name: ");
                            String newName = sc.next();
                            
                            //Check if the book already exists, because the name should be unique
                            Book existedBookU = getBookObject(newName);
                            if (existedBookU == null) {
                                bookToUpdate.setName(newName);
                                System.out.println("Book's name has been updated successfully...");
                            }
                            else {
                                System.out.println("This book already exists");
                            }
                            
                            
                        }
                        case 2 -> {
                            System.out.println("Please enter book's new author: ");
                            bookToUpdate.setAuthor(sc.next());
                            System.out.println("Book's author has been updated successfully...");
                        }
                        case 3 -> {
                            System.out.println("Please enter book's new price: ");
                            bookToUpdate.setPrice(sc.nextDouble());
                            System.out.println("Book's price has been updated successfully...");
                        }
                        case 4 ->
                            exit = true;
                        default ->
                            System.out.println("INVALID CHOICE!!");

                    }
                }
            }
        }

    }

    //Method to delete an existed book
    public void deleteBook() {
        if (bookList.isEmpty()) {
            System.out.println("NO BOOKS!!");
        }
        else {
            System.out.println("Pleace enter book's name you want to delete: ");
            String bookName = sc.next();
            Book bookToDelete = getBookObject(bookName);

            if (bookToDelete == null) {
                System.out.println("No book found with this name!!");
            }
            else {
                bookList.remove(bookToDelete);
                System.out.println("Book has been deleted successfully...");
            }

        }
    }

    //Method to search for a book with its name
    public void searchBook() {
        if (bookList.isEmpty()) {
            System.out.println("NO BOOKS!!");
        }
        else {
            System.out.println("Pleace enter book's name you want to search: ");
            String bookName = sc.next();
            Book bookToSearch = getBookObject(bookName);

            if (bookToSearch == null) {
                System.out.println("No book found with this name!!");
            }
            else {
                System.out.println("Here is your book...");
                System.out.println(bookToSearch.toString());
                
            }

        }

    }
}
