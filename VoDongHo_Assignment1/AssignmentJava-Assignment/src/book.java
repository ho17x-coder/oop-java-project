public class book {
    String title;
    String author;
    double price;
    boolean inStock = false;
    int pages;
    String bookType;
    int available;

    public void PrintInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("InStock: " + inStock);
        System.out.println("Book type: " + bookType);
        System.out.println("Pages: " + pages );
        System.out.println("available: " + available );

    }
    public int availableBook(int bought)
    {
        return available - bought;
    }
    public String getBookType(String title, int pages, String bookType)
    {
        return "this "+ title + " has "+pages+ " with the type for "+ bookType;
    }
    public void applyDisCount(double percent)
    {
        price = price - (price * percent/100);
    }

    public double getPrice()
    {
        return price;
    }

    public double caculateDiscount(double percent)
    {
        return price - ( price * percent/100);
    }
}
