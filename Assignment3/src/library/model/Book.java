package library.model;

public class Book {
    private String id;
    private String title;
    private String author;
    private int year;
    private int quantity;

    public Book(String id, String title, String author, int year, int quantity) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
    public int getQuantity() { return quantity; }

    public boolean isAvailable() {
        return quantity > 0;
    }

    public boolean borrowOne() {
        if (quantity > 0) {
            quantity--;
            return true;
        }
        return false;
    }

    public void returnOne() {
        quantity++;
    }

    public boolean matches(String keyword) {
        String k = keyword.toLowerCase();
        return title.toLowerCase().contains(k)
                || author.toLowerCase().contains(k);
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "[Book] " + id + " - " + title + " | " + author + " | " + year + " | Qty: " + quantity;
    }
}