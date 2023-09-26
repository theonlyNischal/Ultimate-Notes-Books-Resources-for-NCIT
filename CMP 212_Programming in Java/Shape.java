/*
This is the Question 10 of the Assignemnet which is anout Abstract Classes and Methods
the Object code is Main.java
 */
    // Base class Shape
   public abstract class Shape {
        abstract void draw();
        abstract void erase();
    }

    // Subclass Circle
    class Circle extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a circle");
        }

        @Override
        void erase() {
            System.out.println("Erasing a circle");
        }
    }

    // Subclass Triangle
    class Triangle extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a triangle");
        }

        @Override
        void erase() {
            System.out.println("Erasing a triangle");
        }
    }

    // Subclass Square
    class Square extends Shape {
        @Override
        void draw() {
            System.out.println("Drawing a square");
        }

        @Override
        void erase() {
            System.out.println("Erasing a square");
        }
    }


