package bookstore;

import java.util.Scanner;

/**
 *
 * @author Mahmoud Mohsen
 * 
 **/


public class BookStore_main {

    //Calling the only object of BookList class
    static BookList bookList = BookList.getInstance();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        while (!exit) {
            //Display the main menu
            System.out.println("----------Main Menu----------");
            System.out.println("1- Display all books");
            System.out.println("2- Add books");
            System.out.println("3- Update book");
            System.out.println("4- Delete book");
            System.out.println("5- Search");
            System.out.println("6- Exit");

            System.out.println("Choose what you want to do: ");
            int choice = sc.nextInt();

            
            switch (choice) {
                case 1 -> //Display all books 
                    bookList.displayAllBooks();

                case 2 -> //Add books
                    bookList.addBook();
                    
                case 3 -> //Update book
                    bookList.updateBook();
                    
                case 4 -> //Delete book
                    bookList.deleteBook();
                
                case 5 -> //Search
                    bookList.searchBook();
                
                case 6 -> //exit
                    exit = true;

                default ->
                    System.out.println("invalid choice!!");

            }
        }
    }
}
