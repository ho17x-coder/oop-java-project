public class Rectangle {
    double width;
    double height;

    public double area()
    {
        return width * height;
    }
    public double perimeter()
    {
        return (width+height)*2;
    }

    public boolean isSquare()
    {
        if(width==height) return true;
        return false;
    }

    public void PrintArea()
    {
        System.out.println("The area is: "+ area());
    }
    public void PrintPerimeter()
    {
        System.out.println("The perimeter is: "+ perimeter());
    }

    public void PrintisSquare()
    {
        if(isSquare()==true)
        {
            System.out.println("This is a square ");
        } else
        {
            System.out.println("This is not a square");
        }
    }
}


