package library.model;

public abstract class Reader {
    protected String readerId;
    protected String fullName;
    protected int currentBorrowCount;

    public Reader(String readerId, String fullName) {
        this.readerId = readerId;
        this.fullName = fullName;
        this.currentBorrowCount = 0;
    }
    public void decreaseBorrowCount() {
        if(currentBorrowCount > 0){
            currentBorrowCount--;
        }
    }
    public abstract String getInfo();
    public abstract double calculateLateFee(int daysLate);
    public abstract int getMaxBorrowLimit();

    public final BorrowResult processBorrow(Book book) {
        if (!checkBorrowQuota()) {
            return new BorrowResult(false, "Đã đạt giới hạn mượn: " + getMaxBorrowLimit() + "cuốn");
        }
        if (!checkSpecialCondition(book)) {
            return new BorrowResult(false, getSpecialConditionMessage());
        }
        if (!book.decreaseStock()) {
            return new BorrowResult(false, "Hết sách trong kho: " + book.getTitle());
        }
        currentBorrowCount++;
        onBorrowSuccess(book);
        return new BorrowResult(true, "Mượn thành công: " + book.getTitle());
    }

    private boolean checkBorrowQuota() {
        return currentBorrowCount < getMaxBorrowLimit();
    }

    protected abstract boolean checkSpecialCondition(Book book);
    protected abstract String  getSpecialConditionMessage();

    protected void onBorrowSuccess(Book book) {
        System.out.println(fullName + " Mượn: " + book.getTitle());
    }

    public String getFullName() { return fullName; }
    public String getReaderId() { return readerId; }
}
