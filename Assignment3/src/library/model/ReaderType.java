package library.model;

public enum ReaderType {
    STUDENT(3),
    LECTURER(5);

    private final int maxBorrow;

    ReaderType(int maxBorrow) {
        this.maxBorrow = maxBorrow;
    }

    public int getMaxBorrow() {
        return maxBorrow;
    }
}