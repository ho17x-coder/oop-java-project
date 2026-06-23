package library.model;
import library.interfaces.Borrowable;
public class Book implements Borrowable {
    private String id;
    private String title;
    private String author;
    private int stock;
    private boolean referenceOnly;
    private String currentBorrowerId;
    private String borrowDate;

    public Book(String id, String title, String author, int stock, boolean referenceOnly) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.stock = stock;
        this.referenceOnly = referenceOnly;

        this.currentBorrowerId = null;
        this.borrowDate = null;
    }
    @Override
    public void borrowBy(String readerId, String date) {

        if (!isAvailable()) {
            System.out.println(title + " is not available.");
            return;
        }

        currentBorrowerId = readerId;
        borrowDate = date;

        System.out.println(
                title + " borrowed by " + readerId);
    }

    @Override
    public void returnBook(String date) {

        currentBorrowerId = null;
        borrowDate = null;

        System.out.println(
                title + " returned on " + date);
    }

    @Override
    public boolean isAvailable() {
        return stock > 0;
    }

    @Override
    public String getBorrowerId() {
        return currentBorrowerId;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getStock() { return stock; }
    public boolean isReferenceOnly() { return referenceOnly; }

    public boolean decreaseStock() {
        if (stock <= 0) return false;
        stock--; return true;
    }

    public void increaseStock() { stock++; }

//    @Override
//    public String toString()
//    { return String.format("[Book] %s - %s | %s | Stock:%d | Ref:%b", id, title, author, stock, referenceOnly); }
@Override
public String toString() {

    String type =
            referenceOnly
                    ? "Reference"
                    : "Normal";

    return String.format(
            "%s | %-10s | %-9s | Stock:%d",
            id,
            title,
            type,
            stock);
}
}

