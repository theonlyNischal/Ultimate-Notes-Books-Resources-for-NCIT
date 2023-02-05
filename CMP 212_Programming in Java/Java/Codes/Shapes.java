import java.lang.*;
class Rectangle{
    int length,breadth;

    public Rectangle(int l,int b){
        this.length = l;
        this.breadth = b;
    }
    void printArea()
    {
        System.out.println("Area = "+length*breadth);
    }
    void printPerimeter()
    {
        System.out.println("Perimeter = "+(2*(length+breadth)));
    }
}

class Square extends Rectangle{
    public Square(int s){
        super(s,s);
    }
}
class Shapes {
    public static void main(String []args)
    {
        Rectangle r = new Rectangle (4,5);
        Square s = new Square (4);
        r.printArea();
        r.printPerimeter();
        s.printArea();
        s.printPerimeter();
    }
}
