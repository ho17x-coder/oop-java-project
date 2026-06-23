package library.model;
import library.interfaces.Returnable;

public class BorrowSlip implements Returnable {

    private Reader reader;
    private Book book;
    private String borrowDate;
    private int daysLate;
    private String returnDate;

    public BorrowSlip(Reader reader,
                      Book book,
                      String borrowDate,
                      int daysLate) {

        this.reader = reader;
        this.book = book;
        this.borrowDate = borrowDate;
        this.daysLate = daysLate;

        this.returnDate = null;
    }

    public Reader getReader() {
        return reader;
    }

    public Book getBook() {
        return book;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public int calculateDaysLate(String currentDate) {
        return daysLate;
    }

    @Override
    public void confirmReturn(String date) {
        this.returnDate = date;

        System.out.println(
                "Return confirmed on " + date);
    }

    @Override
    public String getReturnDate() {
        return returnDate;
    }

    @Override
    public boolean isReturned() {
        return returnDate != null;
    }


    @Override
    public String toString() {
        return reader.getFullName()
                + " -> "
                + book.getTitle();
    }
}