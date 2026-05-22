package assignment2final;

public class Rectangle {

    double width;
    double height;

    // Constructor mặc định
    public Rectangle() {
        this.width = 1;
        this.height = 1;
    }

    // Hình vuông
    public Rectangle(double side) {
        this.width = side;
        this.height = side;
    }

    // Hình chữ nhật
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Constructor sao chép
    public Rectangle(Rectangle other) {
        this.width = other.width;
        this.height = other.height;
    }

    // Tính diện tích
    public double getArea() {
        return width * height;
    }

    // Tính chu vi
    public double getPerimeter() {
        return 2 * (width + height);
    }

    // Kiểm tra hình vuông
    public boolean isSquare() {
        return width == height;
    }

    // Phóng to theo hệ số
    public void scale(double factor) {
        width *= factor;
        height *= factor;
    }
}