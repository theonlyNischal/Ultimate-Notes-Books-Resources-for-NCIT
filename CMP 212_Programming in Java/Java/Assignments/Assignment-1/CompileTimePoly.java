class Polymorphism {
    // passing the single argument
    static int sum(int a) {
        return 4 + a;
    }

    // passing multiple argument(overloading)_
    static int sum(int a, int b) {
        return a + b;
    }
}

public class CompileTimePoly {
    public static void main(String[] args) {
        // calling the sum method by passing a single argument
        System.out.println("Single element :- " + 4 + "\nSum will be :- " + Polymorphism.sum(4));
        // calling the sum method by passing two argument
        System.out.println(
                "Two passed elements are :- " + 10 + "," + 14 + "\nsum wil be :- " + Polymorphism.sum(10, 14));
    }

}
