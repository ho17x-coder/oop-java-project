package library.model;

public class Librarian {

    private Library library;

    public Librarian(Library library) {
        this.library = library;
    }

    public String borrow(String readerId, String bookId, int days) {

        Reader r = library.findReader(readerId);
        Book b = library.findBook(bookId);

        if (r == null) return "Không tìm thấy độc giả";
        if (b == null) return "Không tìm thấy sách";

        BorrowSlip slip = library.borrowBook(r, b, days);

        if (slip == null)
            return "Không thể mượn sách (hết sách hoặc vượt giới hạn)";

        return "Mượn thành công - Slip: " + slip.getId();
    }

    public String returnBook(String slipId) {

        for (BorrowSlip s : library.getBorrowSlips()) {
            if (s.getId().equalsIgnoreCase(slipId)) {

                long fine = library.returnBook(s);

                if (fine < 0) return "Phiếu không hợp lệ";

                return "Trả sách thành công - Phạt: " + fine + " VND";
            }
        }

        return "Không tìm thấy phiếu mượn";
    }
}