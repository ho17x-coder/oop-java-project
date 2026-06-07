package assignment2final;

public class Main {

    public static void main(String[] args) {

        System.out.println("========== BÀI 1: BOOK ==========");

        Book b1 = new Book();
        b1.displayInfo();

        Book b2 = new Book(
                "Ngày Nắng",
                "vodongho",
                2024,
                97000
        );

        b2.displayInfo();

        Book b3 = new Book(
                "Ước Mơ Của Em",
                "vodongho"
        );

        b3.displayInfo();

        b2.applyDiscount(10);
        b2.displayInfo();


        System.out.println("\n========== BÀI 2: RECTANGLE ==========");

        Rectangle r1 = new Rectangle();

        Rectangle r2 = new Rectangle(5);

        Rectangle r3 = new Rectangle(4,6);

        System.out.println(
                "R1 - Diện tích: "
                        + r1.getArea()
                        + " | Chu vi: "
                        + r1.getPerimeter()
                        + " | Hình vuông: "
                        + r1.isSquare()
        );

        System.out.println(
                "R2 - Diện tích: "
                        + r2.getArea()
                        + " | Chu vi: "
                        + r2.getPerimeter()
                        + " | Hình vuông: "
                        + r2.isSquare()
        );

        System.out.println(
                "R3 - Diện tích: "
                        + r3.getArea()
                        + " | Chu vi: "
                        + r3.getPerimeter()
                        + " | Hình vuông: "
                        + r3.isSquare()
        );

        Rectangle r4 = new Rectangle(r3);

        r4.scale(2);

        System.out.println(
                "R4 (bản sao R3 x2) - Diện tích: "
                        + r4.getArea()
        );


        System.out.println("\n========== BÀI 3: BANKACCOUNT ==========");

        BankAccount acc =
                new BankAccount(
                        "ACC123456789",
                        "aming",
                        1000000
                );

        acc.displayInfo();

        acc.deposit(500000);

        acc.withdraw(200000);

        acc.displayInfo();

        acc.deposit(-100);

        acc.withdraw(9999999);

        BankAccount acc2 =
                new BankAccount(
                        "ACC987654321",
                        "Nguyen Van A",
                        500000
                );

        acc.transfer(acc2,300000);

        acc.displayInfo();

        acc2.displayInfo();


        System.out.println("\n========== BÀI 4: EMPLOYEE ==========");

        Employee e1 =
                new Employee(
                        "aming",
                        15000000
                );

        Employee e2 =
                new Employee(
                        "Tran Van B",
                        20000000
                );

        Employee e3 =
                new Employee(
                        "Le Van C",
                        18000000
                );

        System.out.println(
                "ID e1: "
                        + e1.getId()
        );

        System.out.println(
                "ID e2: "
                        + e2.getId()
        );

        System.out.println(
                "ID e3: "
                        + e3.getId()
        );

        System.out.println(
                "Tổng nhân viên: "
                        + Employee.getEmployeeCount()
        );

        System.out.println(
                "Tổng lương: "
                        + Employee.getTotalSalary()
        );

        System.out.println(
                "Lương TB: "
                        + Employee.getAverageSalary()
        );

        e1.setSalary(20000000);

        System.out.println(
                "Tổng lương sau đổi: "
                        + Employee.getTotalSalary()
        );

        e2.raiseSalary(10);

        System.out.println(
                "Lương e2 sau tăng: "
                        + e2.getSalary()
        );

        Employee.changeCompanyName(
                "SuperTech"
        );

        System.out.println(
                "Tên công ty mới: "
                        + Employee.companyName
        );


        System.out.println("\n========== BÀI 5: PRODUCT ==========");

        Product p1 = new Product();

        Product p2 =
                new Product(
                        "Laptop",
                        25000000
                );

        Product p3 =
                new Product(
                        "Phone",
                        15000000,
                        10
                );

        Product p4 =
                new Product(
                        "Tablet",
                        8000000,
                        5
                );

        p1.displayInfo();
        p2.displayInfo();
        p3.displayInfo();
        p4.displayInfo();

        p3.sell(3);

        p4.sell(2);

        p2.restock(5);

        System.out.println(
                Product.getStoreReport()
        );

        p3.applyPromotion(10);

        Product[] products = {
                p1,p2,p3,p4
        };

        Product.applyGlobalPromotion(
                products,
                5
        );
    }
}