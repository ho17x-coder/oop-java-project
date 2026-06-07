package library;

import library.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Library library = new Library();

        // ✅ FIX: phải truyền library vào
        Librarian librarian = new Librarian(library);

        // ================= DỮ LIỆU MẪU =================
        library.addBook(new Book("B01", "Java Cơ Bản", "James", 2020, 3));
        library.addBook(new Book("B02", "OOP Java", "David", 2021, 4));
        library.addBook(new Book("B03", "Data Structure", "Nguyen A", 2019, 5));
        library.addBook(new Book("B04", "Algorithms", "Le B", 2018, 2));
        library.addBook(new Book("B05", "Database", "Tran C", 2022, 6));
        library.addBook(new Book("B06", "SQL Server", "Microsoft", 2020, 4));
        library.addBook(new Book("B07", "Python Basics", "Guido", 2021, 5));
        library.addBook(new Book("B08", "Spring Boot", "Pivotal", 2023, 3));
        library.addBook(new Book("B09", "Software Design", "Martin", 2017, 2));

        library.addReader(new Reader("R01", "Nguyễn Văn An", ReaderType.STUDENT));
        library.addReader(new Reader("R02", "Trần Thị Bích", ReaderType.LECTURER));

        while (true) {

            System.out.println("\n========== LIBRARY SYSTEM ==========");
            System.out.println("1. Xem sách");
            System.out.println("2. Xem độc giả");
            System.out.println("3. Mượn sách");
            System.out.println("4. Trả sách");
            System.out.println("5. Tìm sách");
            System.out.println("6. Sách quá hạn");
            System.out.println("7. Danh sách sách đang mượn");
            System.out.println("8. Thoát");

            System.out.print("Chọn: ");

            String c = sc.nextLine();

            switch (c) {

                case "1":
                    library.showBooks();
                    break;

                case "2":
                    library.showReaders();
                    break;

                case "3": {
                    System.out.print("Nhập ID độc giả: ");
                    String rid = sc.nextLine();

                    System.out.print("Nhập ID sách: ");
                    String bid = sc.nextLine();

                    System.out.print("Số ngày mượn: ");
                    int days = Integer.parseInt(sc.nextLine());

                    String result = librarian.borrow(rid, bid, days);
                    System.out.println(result);
                    break;
                }

                case "4": {
                    System.out.print("Nhập mã phiếu: ");
                    String sid = sc.nextLine();

                    String result = librarian.returnBook(sid);
                    System.out.println(result);
                    break;
                }

                case "5": {
                    System.out.print("Từ khóa: ");
                    String key = sc.nextLine();

                    ArrayList<Book> res = library.searchBooks(key);

                    if (res.isEmpty()) {
                        System.out.println("Không tìm thấy sách");
                    } else {
                        for (Book b : res) b.display();
                    }
                    break;
                }

                case "6": {
                    ArrayList<BorrowSlip> list = library.getOverdue(LocalDate.now());

                    if (list.isEmpty()) {
                        System.out.println("Không có quá hạn");
                    } else {
                        for (BorrowSlip s : list) s.display();
                    }
                    break;
                }

                case "7": {
                    System.out.println("\n--- DANH SÁCH SÁCH ĐANG MƯỢN ---");

                    ArrayList<BorrowSlip> list = library.getBorrowedBooks();

                    if (list.isEmpty()) {
                        System.out.println("Hiện không có sách nào đang được mượn");
                    } else {
                        for (BorrowSlip s : list) {
                            System.out.println(
                                    "Slip: " + s.getId()
                                            + " | Reader: " + s.getReader().getFullName()
                                            + " | Book: " + s.getBook().getTitle()
                                            + " | Due: " + s.getDueDate()
                            );
                        }
                    }
                    break;
                }

                default:
                    System.out.println("Sai lựa chọn!");
            }
        }
    }
}