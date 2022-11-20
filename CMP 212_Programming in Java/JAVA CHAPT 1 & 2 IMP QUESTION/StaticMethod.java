public class StaticMethod {
    static void fname() {
        System.out.println("Isha");
    }

    public static void main(String[] args) {
        // fname();
        StaticMethod.fname();
        /*
         * lname(); // shows error as it can be called as like this only
         * within the class
         */

        StaticMethodTest.lname();
    }
}

class StaticMethodTest {
    static void lname() {
        System.out.print("Hitang");
    }
}