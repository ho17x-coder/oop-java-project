import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Book> books = new ArrayList<>();
    private final List<Reader> readers = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void addReader(Reader reader) {
        readers.add(reader);
    }

    public void printBooks() {
        System.out.println("Danh sach sach:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void printReaders() {
        System.out.println("Danh sach doc gia:");
        for (Reader reader : readers) {
            System.out.println(reader);
        }
    }
}
