public class Main {
    public static void main(String[] args) {
        // Polymorphism in action
        Shape[] shapes = {new Circle(), new Triangle(), new Square()};

        for (Shape shape : shapes) {
            shape.draw();
            shape.erase();
            System.out.println();
        }
    }
}
