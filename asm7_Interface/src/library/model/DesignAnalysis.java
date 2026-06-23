package library.model;
public class DesignAnalysis {

    /*
     * ===== COMPOSITION (HAS-A) =====
     *
     * Library HAS-A Reader:
     * Library quản lý danh sách Reader.
     * Reader không phải là một loại Library nên không dùng kế thừa.
     *
     * Library HAS-A Book:
     * Library chứa nhiều Book.
     * Book không phải là Library.
     *
     * Library HAS-A BorrowSlip:
     * Library lưu các phiếu mượn.
     *
     * Library HAS-A LateFeePolicy:
     * Library sử dụng chiến lược tính phí.
     * Có thể thay đổi policy linh hoạt mà không sửa Library.
     *
     * Librarian HAS-A Library:
     * Thủ thư làm việc với thư viện.
     * Thủ thư không phải là thư viện.
     *
     * BorrowSlip HAS-A Reader:
     * Phiếu mượn thuộc về một độc giả.
     *
     * BorrowSlip HAS-A Book:
     * Phiếu mượn gắn với một cuốn sách.
     */
}
/*
 * ===== INHERITANCE (IS-A) =====
 *
 * StudentReader IS-A Reader:
 * Sinh viên là một loại độc giả.
 *
 * FacultyReader IS-A Reader:
 * Giảng viên là một loại độc giả.
 *
 * GuestReader IS-A Reader:
 * Khách là một loại độc giả.
 *
 * SeniorReader IS-A Reader:
 * Người cao tuổi là một loại độc giả.
 */
/*
 * ===== PHAN TICH THIET KE SAI =====
 *
 * (a)
 * Librarian không phải IS-A Reader.
 * Thủ thư không thực hiện nghiệp vụ mượn sách,
 * không có giới hạn mượn sách và không bị tính phí phạt.
 *
 * (b)
 * library.addReader(new Librarian(...))
 * vẫn compile được do Librarian kế thừa Reader.
 * Tuy nhiên đây là lỗi nghiệp vụ.
 *
 * library.calculateTotalFee(...)
 * sẽ tính phí cho Librarian.
 * Điều này không hợp lý.
 *
 * (c)
 * Thiết kế vi phạm:
 *
 * - Liskov Substitution Principle (LSP)
 * - Sai quan hệ IS-A
 * - Favor Composition Over Inheritance
 */