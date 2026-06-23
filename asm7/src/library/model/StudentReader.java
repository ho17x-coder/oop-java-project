package library.model;

public class StudentReader extends Reader {

    private String studentId;

    public StudentReader(String readerId,
                         String fullName,
                         String studentId) {

        super(readerId, fullName);
        this.studentId = studentId;
    }

//    @Override
//    public String getInfo() {
//        return "Student: " + fullName +
//                " | ID: " + studentId;
//    }
@Override
public String getInfo() {
    return "Student: " + fullName +
            " | ID: " + readerId;
}
    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 2000;
    }

    @Override
    public int getMaxBorrowLimit() {
        return 3;
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return !book.isReferenceOnly();
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "Sách tham khảo chỉ được đọc tại chổ";
    }
}