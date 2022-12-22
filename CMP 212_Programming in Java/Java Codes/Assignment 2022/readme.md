# Java Assignment: Chapter 1 & 2

# Question

![CHEESE!](AssignQuestion.png)

# Question no.1:- Discuss the features of Java.

Answer:-

**Java features or advantages:-**

**1. Architectural-neutral and platform independent**

   Java programs can be easily moved from one computer system to another, anywhere and anytime.
      
   Changes and upgrades in any Operating Systems(OS), processors, and system resources will not force any changes in java programs

   Java gives a software based platform that runs on the top of the other hardware platforms which has basically two components
                        i. RunTime Environment
                        ii. API(Application Programming Interface)

     - Java code can be run on any platform or multiple devices like windows, linux, mac etc.

     - Java code is first compiled into the byte code using javac as javac filename.java.

     - Compiled byte code is converted into the equivalent machine code using JVM as java filename.

     - Each and every Java source file is compiled into a bytecode file, which is executed by the JVM.

![CHEESE!](architecture-neutral.jpeg)

      Hence, the java is platform independent.

**2. Robust**

   Java is Robust because:-
      - There are exception handling and type checking mechanisims in java.
      - To make the memory free forgotten to make it free while deallocating the memory, there is a automatic garbage collector in java which runs on JVM.

      - Java has eleminated the concepts of pointers.

**3. multithreaded and interactive**

   Multithreading refers to a process of executing two or more threads simultaneously in java where a thread in java is an individual, light-weight process requiring fewer resources to create and share the process resources.

      - Multithreading saves time as we can perform multiple operations together.

      - It doesn't block the users to perform multiple operations at the same time due to it's indpendency.

      - It doesn't affect the other threads if an exception occurs in a single thread.

**4. Distributed**

   Java is distribute language because

      - It is possible to share both data and programs.
      - Java applications can open and access remote objects in their local system that helps multiple programmers at mutliple remote locations to work on a single project.

      - RMI (Java Remote Method Invocation) and EJB (Enterprise Java Bean) are the manageably designed Java APIs.

**5. Object-oriented**

   Java is Object oriented programming language as:-

      - Everything in java is an object.

      - All program code and data reside within objects and classes.

      - Java comes with sets of classes, packages that we can use in our programs using the concept of inheritance.

**6. Simple and familiar**

   Java is simple and familiar as

      - Java has extracted many complicated functions like pointers, preprocessor header files, goto statement, operator overloading, multiple inheritance etc.

      - Java is a simplified version of c++.

**7. High Performance**

   Java has an impressive performance due to

      - The use of intermediate byte code.

      - The use of JIT (Just In Time) compiler in which the compiler compiles the code on demand basis i.e the compiler compiler compiles only that code which is
        being called which saves time and makes it more efficient.

**8. Ease of Development**
   J2SE(Java 2 Standard Edition) 5.0 supports features like Generics, Enhanced for loop, Autoboxing or Unboxing, Typesafe Enums, etc which reduce the work of a 
   
   programmer by shifting the resposibility of creating the reusable code to the compiler.

# Question no.2:- Explain how Java is platform Independent

Answer:-

   Java is platform Independent due to the following reasons:

      - Java programs can be easily moved from one computer system to another, anywhere and anytime.

      - Changes and upgrades in any Operating Systems(OS), processors, and system resources will not force any changes in java programs

      - Java gives a software based platform that runs on the top of the other hardware platforms which has basically two components : 

                           i. RunTime Environment

                           ii. API(Application Programming Interface)

      - Java code can be run on any platform or multiple devices like windows, linux, mac etc.

      - Java code is first compiled into the byte code using javac as javac filename.java.

      - Compiled byte code is converted into the equivalent machine code using JVM as java filename.

      - Each and every Java source file is compiled into a bytecode file, which is executed by the JVM.

      - Hence, the java is platform independent.

# Question no.3:- Why is multiple inheritance not supported in Java ? Provide a simple code example to support your answer.

Answer:-

   The diamond problem in java is the main reason why java doesn't support multiple inheritances in classes.

   Multiple inheritance shows problem when there exist methods with same signature int the both super/parent classes. Due to such problem, java doesn't support 
   
   multiple inheritance directly. The same concept can be achieved in java using the Interface method.

   Example code :- "[Multiple.java]"

**OUTPUT//**

      ERROR

      Code explanation:- In above program, m object of Multiple class is making a call to superclass/parent method display(). This leads to the ambiguity as the compiler doesn't know which superclass method to execute which is called to be the diamond problem that leads java not support the multiple inheritance.

# Question no.4:- Define Polymorphism. How should we implement polymorphism in java ?

Answer:-
   Polymorphism is the same object having different behavior or it's one of the main feature of the Object Oriented Programming that has many forms.

   There are two different methods of implementing Polymorphism in Java:-

   **1.CompileTime Polymorphism or MethodOverloading :-**

      This type of polymorphism is also called the static polymorphism that can be implemented using method overloading.

   **Example program of CompileTime Polymorphism:-**"[CompileTimePoly.java]"

   **OUTPUT//**

         Single element :- 4

         Sum will be :- 8

         Two passed elements are :- 10,14

         sum wil be :- 24

         - In this above example program, the Polymorphism class has two same methods sum() but the arguments passed are different. Here two methods having the same name are distinguished and compile time polymorphism is achieved. For the first time, when we call the sum() method, we pass single value to the method, so the first method is evoked. For the second time, we pass two values to the method that evoked the second method.

         Hence, this helps to implement the CompileTimePolymorphism.

   **2. RunTime Polymorphism or MethodOverriding :-**
      RunTime Polymorphism is also called the Dynamic method dispatch that can be implements using method overriding.

   **Example Program of RunTime polymorphism :-** "[RunTimePoly.java]"

   **OUTPUT//**

         Formulas for area:-

         Area of the Circle:- pi _ r _ r

         Area of the Rectangle:- l \_ b

         Area of the Square:- r \_ r

         --- > In this above example program, the Shape class is super class and Circle, Rectangle and Square are it's derived classes where the area() method is overriden from the super/parent class Shape.

# Question no.5:- Create a class Employee with id, name, post and salary. Create a parameterized Constructor to initialize the instance variables. Override the toString() method to display the details.

   Answer:- "[TestEmployee.java]"

# Question no.6:- Mention the scope of all modifiers and also illustrate the concept of access modifiers with suitable examples.

Answer:-

   Modifiers are the keywords in object oriented languages that set the accessibility of classes, methods and other members.

   # Access-modifier in java

      access modifier in java has the following characteristics:-

      1. Access modifiers in java defines the scope or the accessiblity of any MCCF(method, constructor, class or field)
      2. We can change the accessing level of any MCCF by adding the access modifier in it.
      3. In java, there are 4 different types of access modifier which are ppppd(private, public, protected and default).

      4. Working field of these modifier is shown in table below.

      ![CHEESE!](access-modifier.webp)

# Question no. 7:- Differentiate between abstract class and Inteface

Answer:-

# Difference between Abstract class and Interface

   1.  Abstract class doesn't support multiple inheritance whereas
       Interface support multiple inheritance.
   2.  Abstract class can have final, non-final, static and non-static variables whereas
       Interface can have only static and final variables.

   3.  Abstract class can have private, protected, public and default members whereas
       All members are public by default.
   4.  It can have both abstract and non-abstract method whereas Interface can have only abstract method.
   5.  Interface doesn't allow to declare a constructor whereas abstract class can declare a constructor.
   6.  Abstract class can provide implementation of interface whereas Interface can't provide implementation of abstract class.
   7.  Abstract class can extend from another class or from multiple interfaces whereas Interfaces can only extend from another interfaces.

# Question no. 8:- Explain with examples: static block, static variables and static method. Why is the main method in Java always public and static ?

Answer:-

**1. Static block :-** Static block is the block that requires static keyword in java which gets executed at the time of loading .class file into the Java Virtual Memory(JVM).

   - static block executes automatically when the class is loaded in the memory.
   - No need to use any specific keyword.
   - static block only gets the static variables.
   - static block executes before the instance block.
   - syntax:-
   static{
   //code =====> static block

   =====> Example program:- "[StaticBlock.java]"

**OUTPUT//**

   Welcome Pradip

**2. class variable or static variable:-** Static variable is used when we have to use the common value for all the program. Here we use the static keyword for that i.e not unique for each object. Static variable belong to class not an individual object.

   - static variable lies outside the body of the function.
   - static keyword is used.
   - static variables are the variable of the class.
   - Single copy/memory is generated.
   - static variables are called using the class name in which the static variables remain the member.

--- > Example program:- "[StaticVar.java]"

**OUTPUT//**

Pradip Dhungana

**3. static methods:-**

   - static method only belongs to class, not object.
   - static method can be called directly by class name as ClassName.methodName();
   - static method can only access the static data but not the non-static(instance) data.
   - static method can not refer to "this" or "super" keyword.
   - static method can call only other static methods.

   - Example program:- "[StaticMethod.java]

**OUTPUT//**

   Pradip

   Dhungana

**The main method in Java always public and static ?**
   because of the following reasons

   1. static
      a. So that JVM(Java Virtual Machine ) can invoke the class without instantiate it.
      b. This method saves the unnecessary wastage of memory.
   2. public
      a. Makes globally available.
      b. JVM(Java Virtual Machine) can invoke it from outside the class.
      c. Accessible from everywhere in program

# Question no. 9:- Design a class Computer having brand, price and storage as it's attributes. Storage can be either HDD or SDD and has a memory space. Also implement a method to display the details.

   Answer:- "[ComputerTest.java]"
# Question no. 10:- Create a class called Rectangle with two data member 'length' and 'breadth' and two methods to print the area and perimeter respecitively. A constructor having parameters for length and breadth is used to initialize the length and breadth of the rectangle. Let class Square inherit the Rectangle class with its constructor having a parameter for it's side. Print the area and perimeter of the rectangle and a squre.

   Answer:- "[CalculateAreaAndPer.java]"

# Question no. 11:- Strings in java are immutable. Justify this statement.

   Answer:- 
   
      Strings in java are immutable that means once you assign a value to the string variable and if you try to change it, it will not replace the old object but it will create the new object for us.
         - If we want to use **new** because it allows us to create a separate object that references a separate value.

         - It is not needed to do when working with Strings because the original String will not be modified because Strings are immutable.

         - Example program :-
                  class Immutable{
                  public static void main(String [] args){
                  String str1 = "Pradip";
                  String str2 = str1;
                  str2 = "Dhungana";
                  }
                  }

         Example program:- Immutable.java

**OUTPUT**

   false

**ExplanationOfExampleProgram**
   As shown in above example program, str2 is pointing to the same value as str1. When we assigned the value Dhungana in str2, it is supposed that the value in the str1 will also be changed which is not true. What exactly will happen is str2 will reference will reference to the new value and the original value of str1 will not be affected. Even if we don't use the new keyword, we still have the value of str1 protected. Hence the Strings are immutable.
