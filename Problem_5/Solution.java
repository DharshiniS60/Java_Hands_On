import java.util.*;

class Book {
    private int id;
    private String title;
    private String author;
    private double price;

    public Book(int id, String title, String author, double price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[4];

        for (int i = 0; i < 4; i++) {
            int id = sc.nextInt();
            sc.nextLine();
            String title = sc.nextLine();
            String author = sc.nextLine();
            double price = sc.nextDouble();
            sc.nextLine();
            books[i] = new Book(id, title, author, price);
        }

        Book[] sortedBooks = sortBooksByPrice(books);

        for (Book book : sortedBooks) {
            System.out.println(book.getId() + " " + book.getTitle() + " " + book.getAuthor() + " " + book.getPrice());
        }
    }

    public static Book[] sortBooksByPrice(Book[] books) {
        Arrays.sort(books, Comparator.comparingDouble(Book::getPrice));
        return books;
    }
