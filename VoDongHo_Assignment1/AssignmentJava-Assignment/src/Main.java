//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Rectangle rec1 = new Rectangle();
        rec1.width = 20;
        rec1.height = 20;
        rec1.PrintArea();
        rec1.PrintPerimeter();
        rec1.PrintisSquare();

        System.out.println("************************************************************");

        double percent = 10;

        // Sách 1
        book book = new book();
        book.available = 1000;
        book.title = "Java Programming Basics";
        book.author = "aming";
        book.price = 20000;
        book.inStock = true;
        book.bookType = "Education";
        book.pages = 1300;

        book.PrintInfo();
        book.applyDisCount(percent);

        System.out.println("---------------------------");
        book.PrintInfo();
        book.getBookType(book.title, book.pages, book.bookType);

        System.out.println("=========================");

        // Sách 2
        book book1 = new book();
        book1.title = "The Secret Love";
        book1.author = "aming";
        book1.price = 50000;
        book1.inStock = true;
        book1.bookType = "Romantic";
        book1.pages = 2700;

        book1.PrintInfo();

        System.out.println("---------------------------");

        book1.applyDisCount(percent);
        book1.PrintInfo();
        book1.getBookType(book1.title, book1.pages, book1.bookType);

        System.out.println("=========================");

        // Sách 3
        book book2 = new book();
        book2.title = "Journey Into Adventure";
        book2.author = "aming";
        book2.price = 70000;
        book2.inStock = false;
        book2.bookType = "Adventure";
        book2.pages = 1200;

        book2.PrintInfo();

        System.out.println("---------------------------");

        book2.applyDisCount(percent);
        book2.PrintInfo();
        book2.getBookType(book2.title, book2.pages, book2.bookType);

        System.out.println("************************************************************");

        System.out.println("Asm3:Circle");

        Circle[] circles = new Circle[5];

        circles[0] = new Circle(2.5);
        circles[1] = new Circle(24.8);
        circles[2] = new Circle(5.2);
        circles[3] = new Circle(8.4);
        circles[4] = new Circle(12.6);

        double totalArea = 0;

        System.out.println("Circle information:");

        for(int i=0;i<circles.length;i++)
        {
            double a = circles[i].area();
            double b = circles[i].circumference();

            totalArea += a;

            System.out.println(
                    "Hình "+(i+1)+
                            ": Bán kính = "+circles[i].radius+
                            " | Diện tích = "+a+
                            " | Chu vi = "+b
            );
        }

        System.out.println("--------------------------------------------------");

        System.out.printf(
                "Tổng diện tích của tất cả các hình tròn là: %.2f",
                totalArea
        );
    }
}