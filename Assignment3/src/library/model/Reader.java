package library.model;

public class Reader {
    private String id;
    private String fullName;
    private ReaderType type;

    public Reader(String id, String fullName, ReaderType type) {
        this.id = id;
        this.fullName = fullName;
        this.type = type;
    }

    public String getId() { return id; }
    public String getFullName() { return fullName; }
    public ReaderType getType() { return type; }

    public int getMaxBorrowLimit() {
        return type.getMaxBorrow();
    }

    @Override
    public String toString() {
        return "[Reader] " + id + " - " + fullName + " | " + type;
    }
}