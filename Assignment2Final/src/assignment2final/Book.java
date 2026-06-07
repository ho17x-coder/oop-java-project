package assignment2final;

public class Book {

    String title;
    String author;
    int year;
    double price;

    // Constructor mặc định
    public Book() {
        this.title = "Java Programming";
        this.author = "aming";
        this.year = 2026;
        this.price = 100000;
    }

    // Constructor đầy đủ
    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    // Constructor thiếu year + price
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.year = 2026;
        this.price = 100000;
    }

    public void displayInfo() {
        System.out.println(
                "Sách: " + title +
                        " | Tác giả: " + author +
                        " | Năm: " + year +
                        " | Giá: " + price
        );
    }

    public void applyDiscount(double percent) {
        price -= price * percent / 100;

        System.out.println(
                "Giảm " + percent +
                        "% -> Giá mới: " + price
        );
    }
}