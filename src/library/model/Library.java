package library.model;

import library.strategy.*;

import java.util.ArrayList;
import java.util.List;

public class Library {

    private List<Book> books;
    private List<Reader> readers;
    private List<BorrowSlip> slips;

    private LateFeePolicy feePolicy;

    public Library() {

        books = new ArrayList<>();
        readers = new ArrayList<>();
        slips = new ArrayList<>();

        feePolicy = new StandardFeePolicy();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void addBorrowSlip(BorrowSlip slip) {
        slips.add(slip);
    }

    public void removeBorrowSlip(BorrowSlip slip) {
        slips.remove(slip);
    }

    public List<Book> getBooks() {
        return books;
    }

    public List<Reader> getReaders() {
        return readers;
    }

    public List<BorrowSlip> getSlips() {
        return slips;
    }

    public void setFeePolicy(LateFeePolicy policy) {

        feePolicy = policy;

        System.out.println(
                "Cập nhật chính sách: "
                        + policy.getPolicyName());
    }

    public double calculateTotalFee(int daysLate) {

        double total = 0;

        for (Reader r : readers) {

            double base =
                    r.calculateLateFee(daysLate);

            double adjusted =
                    feePolicy.applyPolicy(base);

            total += adjusted;
        }

        return total;
    }

    public void printBooks() {

        System.out.println("\n=== DANH SÁCH SÁCH ===");

        for (Book b : books) {
            System.out.println(b);
        }
    }

    public void printReaders() {

        System.out.println("\n=== DANH SÁCH ĐỌC GIẢ ===");

        for (Reader r : readers) {
            System.out.println(r.getInfo());
        }
    }
}