public class Student extends Reader {
    public Student(String id, String name, String email) {
        super(id, name, email);
    }

    @Override
    public int getMaxBorrow() {
        return 3;
    }

    @Override
    public String toString() {
        return super.toString() + " | Type: Student | Max borrow: " + getMaxBorrow();
    }
}
