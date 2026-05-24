public class Lecturer extends Reader {
    public Lecturer(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public int getMaxBorrow() {
        return 5;
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: Lecturer | Max borrow: " + getMaxBorrow();
    }
}
