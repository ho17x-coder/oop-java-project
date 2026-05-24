package library.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowSlip {
    private String id;
    private Reader reader;
    private Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public BorrowSlip(String id, Reader reader, Book book, LocalDate borrowDate, LocalDate dueDate) {
        this.id = id;
        this.reader = reader;
        this.book = book;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
    }

    public String getId() { return id; }
    public Reader getReader() { return reader; }
    public Book getBook() { return book; }
    public LocalDate getDueDate() {
        return dueDate;
    }

    public boolean isReturned() {
        return returnDate != null;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isOverdue(LocalDate now) {
        return returnDate == null && now.isAfter(dueDate);
    }

    public long calculateFine(LocalDate returnDate) {
        long daysLate = ChronoUnit.DAYS.between(dueDate, returnDate);
        return Math.max(0, daysLate) * 5000;
    }

    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "[Slip] " + id + " | " + reader.getFullName() +
                " | " + book.getTitle() +
                " | Due: " + dueDate +
                " | Returned: " + (returnDate != null);
    }
}