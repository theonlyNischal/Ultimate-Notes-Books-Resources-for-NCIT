//Run time polymorphism

import java.lang.*;
class Parent
{
    void print ()
    {
        System.out.println("Inside parent class");
    }
}
class Child1 extends Parent{
    void print() 
    {
        System.out.println("Inside Child1 class ");
    }
}
class Child2 extends Parent{
    void print()
    {
        System.out.println("Inside child2 class");
    }
}
class MethodOverriding {
    public static void main(String []args)
    {
        Parent a;
        a = new Parent();
        a.print();
        a = new Child1();
        a.print();
        a = new Child2();
        a.print();
    }
}
