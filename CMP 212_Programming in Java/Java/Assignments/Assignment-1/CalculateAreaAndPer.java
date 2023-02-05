class Rectangle {
    int length, breadth;

    public Rectangle(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public void area() {
        System.out.println("Area Of the Rectangle is:- " + length * breadth);
    }

    public void perimeter() {
        System.out.println("Perimeter Of the Rectangle is:- " + 2 * (length + breadth));
    }
}

class Square extends Rectangle {
    public Square(int length) {
        super(length, length);
    }

    public void area() {
        System.out.println("Area Of the Square is:- " + length * length);
    }

    public void perimeter() {
        System.out.println("Perimeter Of the Square is:- " + 4 * length);
    }
}

public class CalculateAreaAndPer {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(3, 5);
        Square s = new Square(4);
        r.area();
        r.perimeter();
        s.area();
        s.perimeter();
    }
}
