package assignment2final;

public class Product {

    private String productCode;
    private String name;
    private double price;
    private int quantity;

    private static int counter = 1;

    private static int totalProducts = 0;
    private static double totalRevenue = 0;

    // Constructor mặc định
    public Product() {
        this("Unknown",0,0);
    }

    // Constructor 2 tham số
    public Product(String name,double price) {
        this(name,price,0);
    }

    // Constructor đầy đủ
    public Product(String name,
                   double price,
                   int quantity){

        this.productCode =
                String.format(
                        "P-%04d",
                        counter++
                );

        this.name =
                ProductValidator.isValidName(name)
                        ? name
                        : "Unknown";

        this.price =
                ProductValidator.isValidPrice(price)
                        ? price
                        : 0;

        this.quantity =
                ProductValidator.isValidQuantity(quantity)
                        ? quantity
                        : 0;

        totalProducts++;
    }

    // Getter
    public String getProductCode() {
        return productCode;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Setter
    public void setName(String name){

        if(ProductValidator.isValidName(name)){
            this.name=name;
        }
        else{
            System.out.println(
                    "Tên không hợp lệ!"
            );
        }
    }

    public void setPrice(double price){

        if(ProductValidator.isValidPrice(price)){
            this.price=price;
        }
        else{
            System.out.println(
                    "Giá không hợp lệ!"
            );
        }
    }

    public void setQuantity(int quantity){

        if(ProductValidator.isValidQuantity(quantity)){
            this.quantity=quantity;
        }
        else{
            System.out.println(
                    "Số lượng không hợp lệ!"
            );
        }
    }

    // Bán hàng
    public void sell(int amount){

        if(amount>0 && amount<=quantity){

            quantity -= amount;

            totalRevenue +=
                    amount * price;

            System.out.println(
                    "Bán "
                            + amount
                            + " "
                            + name
            );
        }
        else{
            System.out.println(
                    "Bán thất bại!"
            );
        }
    }

    // Nhập thêm hàng
    public void restock(int amount){

        if(amount>0){

            quantity += amount;

            System.out.println(
                    "Nhập thêm "
                            + amount
                            + " "
                            + name
            );
        }
        else{
            System.out.println(
                    "Số lượng nhập không hợp lệ!"
            );
        }
    }

    // Hiển thị
    public void displayInfo(){

        System.out.println(
                "Mã: "
                        + productCode
                        + " | Tên: "
                        + name
                        + " | Giá: "
                        + price
                        + " | Tồn kho: "
                        + quantity
        );
    }

    // Thống kê
    public static int getTotalProducts(){
        return totalProducts;
    }

    public static double getTotalRevenue(){
        return totalRevenue;
    }

    public static String getStoreReport(){

        return
                "===== BÁO CÁO CỬA HÀNG =====\n"+
                        "Tổng sản phẩm: "
                        + totalProducts +
                        "\nTổng doanh thu: "
                        + totalRevenue;
    }

    // Khuyến mãi 1 sản phẩm
    public void applyPromotion(
            double discountPercent){

        price -=
                price
                        * discountPercent
                        /100;

        System.out.println(
                "Giảm "
                        + discountPercent
                        + "% -> Giá mới: "
                        + price
        );
    }

    // Khuyến mãi toàn bộ
    public static void applyGlobalPromotion(
            Product[] products,
            double discountPercent){

        System.out.println(
                "Giảm toàn bộ "
                        + discountPercent
                        + "%"
        );

        for(Product p : products){

            p.applyPromotion(
                    discountPercent
            );
        }
    }
}