//Compile time polymorphism

import java.lang.*;

class Test{
    static int multiply (int a,int b)
    {
        return a*b;
    }
    static float division (float a,float b)
    {
        return a/b;
    }
}

class MethodOverloading{
    public static void main(String []args)
    {
        System.out.println(Test.multiply(2,4));
        System.out.println(Test.division(3,2));
    }
}