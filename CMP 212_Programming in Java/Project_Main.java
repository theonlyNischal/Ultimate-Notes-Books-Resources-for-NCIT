public class Project_Main {
    public static void main(String[] args) {
        // Create instances of the subclasses and call their debug() methods
        ProjectClass obj1 = new Subclass1();
        ProjectClass obj2 = new Subclass2();
        ProjectClass obj3 = new Subclass3();

        obj1.debug();
        obj2.debug();
        obj3.debug();
    }
}
