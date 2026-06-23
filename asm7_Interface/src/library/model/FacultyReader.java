package library.model;

public class FacultyReader extends Reader {

    private String department;

    public FacultyReader(String readerId,
                         String fullName,
                         String department) {

        super(readerId, fullName);
        this.department = department;
    }

    @Override
    public String getInfo() {
        return "Faculty: " + fullName +
                " | Department: " + department;
    }

    @Override
    public double calculateLateFee(int daysLate) {
        return daysLate * 1000;
    }

    @Override
    public int getMaxBorrowLimit() {
        return 10;
    }

    @Override
    protected boolean checkSpecialCondition(Book book) {
        return true;
    }

    @Override
    protected String getSpecialConditionMessage() {
        return "";
    }
}