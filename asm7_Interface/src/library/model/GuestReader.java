package library.model;

public class GuestReader extends Reader {

    private String phone;

    public GuestReader(String readerId,
                       String fullName,
                       String phone) {

        super(readerId, fullName);
        this.phone = phone;
    }

    @Override
    public String getInfo() {
        return "Guest: " + fullName +
                " | Phone: " + phone;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 3000;
    }

    @Override
    public int getMaxBorrowLimit() {
        return 2;
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return !book.isReferenceOnly();
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "khách vãng lai không được mượn sách tham khảo";
    }
}