/*
This is the Question No 10 Part two - Example code for Abstract classes and methods
the object code is Animal_Main.java
 */
// Abstract class Animal
public abstract class Animal {
    // Abstract method without implementation
    abstract void makeSound();

    // Concrete method with implementation
    void sleep() {
        System.out.println("Zzzz...");
    }
}

// Subclass Dog inheriting from Animal
class Dog extends Animal {
    @Override
    void makeSound() {
        System.out.println("Woof Woof!");
    }
}

// Subclass Cat inheriting from Animal
class Cat extends Animal {
    @Override
    void makeSound() {
        System.out.println("Meow Meow!");
    }
}

