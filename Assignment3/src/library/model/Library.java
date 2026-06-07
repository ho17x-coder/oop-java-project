package library.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Reader> readers = new ArrayList<>();
    private ArrayList<BorrowSlip> slips = new ArrayList<>();
    private int counter = 1;

    public void addBook(Book b) {
        books.add(b);
    }

    public void addReader(Reader r) {
        readers.add(r);
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Reader> getReaders() {
        return readers;
    }

    public ArrayList<BorrowSlip> getBorrowSlips() {
        return slips;
    }

    public void showBooks() {
        for (Book b : books) System.out.println(b);
    }

    public void showReaders() {
        for (Reader r : readers) System.out.println(r);
    }

    public Book findBook(String id) {
        for (Book b : books)
            if (b.getId().equalsIgnoreCase(id)) return b;
        return null;
    }

    public Reader findReader(String id) {
        for (Reader r : readers)
            if (r.getId().equalsIgnoreCase(id)) return r;
        return null;
    }

    public int countBorrowed(String readerId) {
        int count = 0;
        for (BorrowSlip s : slips) {
            if (!s.isReturned() &&
                    s.getReader().getId().equalsIgnoreCase(readerId)) {
                count++;
            }
        }
        return count;
    }

    public BorrowSlip borrowBook(Reader r, Book b, int days) {

        if (!b.isAvailable()) return null;
        if (countBorrowed(r.getId()) >= r.getMaxBorrowLimit()) return null;

        b.borrowOne();

        BorrowSlip slip = new BorrowSlip(
                "S" + (counter++),
                r,
                b,
                LocalDate.now(),
                LocalDate.now().plusDays(days)
        );

        slips.add(slip);
        return slip;
    }

    public long returnBook(BorrowSlip slip) {
        if (slip == null || slip.isReturned()) return -1;

        LocalDate now = LocalDate.now();
        slip.setReturnDate(now);
        slip.getBook().returnOne();

        return slip.calculateFine(now);
    }

    public ArrayList<Book> searchBooks(String key) {
        ArrayList<Book> res = new ArrayList<>();
        for (Book b : books)
            if (b.matches(key)) res.add(b);
        return res;
    }

    public ArrayList<BorrowSlip> getOverdue(LocalDate now) {
        ArrayList<BorrowSlip> res = new ArrayList<>();
        for (BorrowSlip s : slips)
            if (s.isOverdue(now)) res.add(s);
        return res;
    }
    public ArrayList<BorrowSlip> getBorrowedBooks() {
        ArrayList<BorrowSlip> res = new ArrayList<>();

        for (BorrowSlip s : slips) {
            if (!s.isReturned()) {
                res.add(s);
            }
        }

        return res;
    }
}