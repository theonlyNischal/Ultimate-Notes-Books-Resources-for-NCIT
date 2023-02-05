class Shape {
    void area() {
        System.out.println("Formulas for area:-");
    }
}

class Circle extends Shape {
    // overriding the area method of the parent class Shape
    void area() {
        System.out.println("Area of the Circle:- pi * r * r");
    }
}

class Rectangle extends Shape {
    // overriding the area method of the parent class Shape
    void area() {
        System.out.println("Area of the Rectangle:- l * b");
    }
}

class Square extends Shape {
    // overriding the area method of the parent class Shape
    void area() {
        System.out.println("Area of the Square:- r * r");
    }
}

public class RunTimePoly {
    public static void main(String[] args) {
        Shape s = new Shape();
        s.area();
        Circle c = new Circle();
        c.area();
        Rectangle r = new Rectangle();
        r.area();
        Square sq = new Square();
        sq.area();
    }

}
