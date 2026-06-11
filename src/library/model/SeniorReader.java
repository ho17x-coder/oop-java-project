package library.model;

public class SeniorReader extends Reader {

    private String cardNumber;

    public SeniorReader(String readerId,
                        String fullName,
                        String cardNumber) {

        super(readerId, fullName);
        this.cardNumber = cardNumber;
    }

    @Override
    public String getInfo() {
        return "Senior: " + fullName +
                " | Card: " + cardNumber;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return 0;
    }

    @Override
    public int getMaxBorrowLimit() {
        return 5;
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return true;
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "";
    }

    @Override
    protected void onBorrowSuccess(Book book) {

        super.onBorrowSuccess(book);

        System.out.println(
                " -> Đã ghi nhận: Người cao tuổi - miễn phí phạt");
    }
}