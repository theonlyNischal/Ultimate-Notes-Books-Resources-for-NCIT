interface AAA
{
  static final String item="Computer";
  static double price=25000;
  

}
interface BBB extends AAA
{
    abstract  void show();
}
 abstract class DDD implements BBB
{
  void check(){}
}

class CCC  implements AAA ,BBB
{
   public void show()
  {
    System.out.println("Item: "+item);
    System.out.println("Price: "+price);
  }
  static public  void main(String args[])
  {
     BBB ob;
     CCC ob1=new CCC();
     ob=ob1;
    ob.show();
  }
      
}
  
  