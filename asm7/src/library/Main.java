package library;

import library.model.*;
import library.strategy.*;

public class Main {


    public static void main(String[] args) {

        System.out.println("============================");
        System.out.println("HE THONG QUAN LY THU VIEN");
        System.out.println("DEMO ASSIGNMENT 07");
        System.out.println("============================\n");

        // ===== 1. Create Library =====
        Library library = new Library();

        // ===== 2. Create Librarian =====
        Librarian librarian = new Librarian(
                "TT01",
                "Lam",
                "0909090909",
                "Sang",
                library);

        // ===== 3. Create Readers =====
        Reader student = new StudentReader(
                "SV01",
                "Võ Văn An",
                "CNTT");

        Reader faculty = new FacultyReader(
                "GV01",
                "Trần Văn Bình",
                "CNTT");

        Reader senior = new SeniorReader(
                "CC01",
                "Phạm Chí Cường",
                "CARD01");

        Reader guest = new GuestReader(
                "K01",
                "Trần Thị Kim Dung",
                "090273471");

        // ===== 4. Add Readers =====
        library.addReader(student);
        library.addReader(faculty);
        library.addReader(senior);
        library.addReader(guest);

        // ===== 5. Create Books =====
        Book javaBook = new Book(
                "B01",
                "Java",
                "James",
                3,
                false);

        Book oopBook = new Book(
                "B02",
                "OOP",
                "Martin",
                2,
                false);

        Book refBook = new Book(
                "B03",
                "Reference",
                "Library",
                1,
                true);

        // ===== 6. Add Books =====
        library.addBook(javaBook);
        library.addBook(oopBook);
        library.addBook(refBook);

        // ===== 7. Display Readers =====
        library.printReaders();

        // ===== 8. Display Books =====
        library.printBooks();

        System.out.println("\n=================================");
        System.out.println("KIỂM TRA TEMPLATE METHOD");
        System.out.println("=================================\n");

        librarian.processLoan(student, javaBook);

        librarian.processLoan(faculty, oopBook);

        librarian.processLoan(senior, javaBook);

        librarian.processLoan(guest, refBook);

        librarian.processLoan(student, refBook);

        System.out.println("\n=================================");
        System.out.println("KIỂM TRA ĐA HÌNH");
        System.out.println("=================================\n");

        Reader[] readers = {
                student,
                faculty,
                senior,
                guest
        };

        for (Reader r : readers) {

            System.out.println(
                    r.getInfo());

            System.out.println(
                    "Phí phạt (5 ngày): "
                            + r.calculateLateFee(5));

            System.out.println(
                    "Giới hạn mượn: "
                            + r.getMaxBorrowLimit());

            System.out.println("----------------------");
        }

        System.out.println("\n=================================");
        System.out.println("KIỂM TRA STRATEGY PATTERN");
        System.out.println("=================================\n");

        int lateDays = 7;

        double totalFee =
                library.calculateTotalFee(lateDays);

        System.out.println(
                "Phí tiêu chuẩn = "
                        + totalFee);

        library.setFeePolicy(
                new CharityFeePolicy());

        totalFee =
                library.calculateTotalFee(lateDays);

        System.out.println(
                "Giảm 50% = "
                        + totalFee);

        library.setFeePolicy(
                new WaivedFeePolicy());

        totalFee =
                library.calculateTotalFee(lateDays);

        System.out.println(
                "Miễn phí = "
                        + totalFee);

        System.out.println("KẾT THÚC DEMO");
        System.out.println("\n=================================");
        System.out.println("KIỂM TRA INTERFACE");
        System.out.println("=================================");

        LibraryManager manager =
                new LibraryManager();
        java.util.List<
                library.interfaces.Borrowable> borrowables =
                new java.util.ArrayList<>();

        borrowables.add(javaBook);
        borrowables.add(oopBook);

        manager.processAllBorrowable(
                borrowables);
        java.util.List<
                library.interfaces.Notifiable> users =
                new java.util.ArrayList<>();

        users.add(student);
        users.add(faculty);
        users.add(senior);
        users.add(guest);

        manager.notifyAll(
                users,
                "Thu vien dong cua luc 18h");
        Fine fine =
                new Fine(
                        "F01",
                        student.getReaderId());

        fine.addFine(
                fine.calculateTotalFine(5));

        System.out.println(
                "Tong tien phat: "
                        + fine.getTotalFine());

        fine.payFine();
    }

    Library library = new Library();
    // Dòng dưới sẽ lỗi compile
// vì Librarian không còn kế thừa Reader
//    Librarian libr =
//            new Librarian(
//                    "TT01",
//                    "Le Thi Đan",
//                    "09023432344",
//                    "Sang",
//                    library);

// library.addReader(libr);
}
