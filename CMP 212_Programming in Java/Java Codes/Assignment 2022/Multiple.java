class A {
    void display() {
        System.out.println("Welcome to class A");
    }
}

class B {
    void display() {
        System.out.println("Welcome to class B");
    }
}

public class Multiple extends A,B
{

    public static void main(String[] args) {
        Multiple m = new Multiple();
        m.display();
    }

}
