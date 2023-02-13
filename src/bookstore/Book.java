package bookstore;

/**
 *
 * @author Mahmoud Mohsen
 * 
 **/

public class Book {

    //Book's attributes
    private String name;
    private String author;
    private double price;

    //Default constructor
    public Book() {
    }

    
    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "name: " + name + ", author: " + author + ", price: " + price ;
    }
    

    //Getters
    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}
