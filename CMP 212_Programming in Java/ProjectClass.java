/*
This is the 3rd Part of the Question 10 in the Assignment Regarding Abstract classes and methods
the object code is Project_Main.java
 */
// Abstract base class providing a common interface
public abstract class ProjectClass {
    // Common method that all subclasses should implement
    abstract void debug();

    // Other common methods can be included here if needed
}

// Subclass 1 inheriting from the abstract base class
class Subclass1 extends ProjectClass {
    @Override
    void debug() {
        System.out.println("Debugging Subclass1...");
        // Implement debug-specific functionality here
    }
}

// Subclass 2 inheriting from the abstract base class
class Subclass2 extends ProjectClass {
    @Override
    void debug() {
        System.out.println("Debugging Subclass2...");
        // Implement debug-specific functionality here
    }
}

// Subclass 3 inheriting from the abstract base class
class Subclass3 extends ProjectClass {
    @Override
    void debug() {
        System.out.println("Debugging Subclass3...");
        // Implement debug-specific functionality here
    }
}

