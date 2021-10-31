class Parent{
public void method_p()
 {
   System.out.println("Parent class ko function ");
 }
}
class Child extends Parent{
public void method_c()
 {
   System.out.println("Child class ko function ");
 }
}
class Demo{
public static void main(String [] args){
 Child obj = new Child();
obj.method_p();
obj.method_c();

}
}

