abstract class Animal
{
  abstract void makeSound();
 
}
class Cat extends Animal
{
  public void makeSound(){
    System.out.println("Mew");
  }
}
class Dog extends Animal
{
  public void makeSound()
  {
      System.out.println("Mew");
  }
}
class Check1
{
  public static void main(String args[]){
    Animal ob=(Animal)new Cat();
    ob.makeSound();
    
  }
}
  
  