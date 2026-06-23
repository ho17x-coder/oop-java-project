package library.model;

public class Librarian {

    private String employeeId;
    private String fullName;
    private String phone;
    private String shift;
    private Library library;

    public Librarian(
            String employeeId,
            String fullName,
            String phone,
            String shift,
            Library library) {

        this.employeeId = employeeId;
        this.fullName = fullName;
        this.phone = phone;
        this.shift = shift;
        this.library = library;
    }

    // Xử lý cho mượn sách
    public void processLoan(
            Reader reader,
            Book book) {

        System.out.println(
                "[THỦ THƯ: " + fullName + "] Xử lý cho mượn:");

        BorrowResult result =
                reader.processBorrow(book);

        System.out.println(
                "Kết Quả: " + result.getMessage());

        if (result.isSuccess()) {

            BorrowSlip slip =
                    new BorrowSlip(
                            reader,
                            book,
                            "2024-12-01",
                            0);

            library.addBorrowSlip(slip);

            System.out.println(
                    "Đã tạo phiếu mượn.");
        }
    }

    // Xử lý trả sách
    public void processReturn(
            BorrowSlip slip) {

        int late =
                slip.calculateDaysLate(
                        "2024-12-20");

        if (late > 0) {

            double fee =
                    slip.getReader()
                            .calculateLateFee(late);

            System.out.printf(
                    "Phạt quá hạn %d ngay: %.0f VND%n",
                    late,
                    fee);
        }

        // Hoàn trả tồn kho
        slip.getBook().increaseStock();

        // Giảm số lượng sách đang mượn
        slip.getReader().decreaseBorrowCount();

        // Xóa phiếu mượn khỏi thư viện
        library.removeBorrowSlip(slip);

        System.out.println(
                "Trả sácg thành công.");
    }

    // Getter nếu cần dùng ở nơi khác
    public String getEmployeeId() {
        return employeeId;
    }

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getShift() {
        return shift;
    }
}