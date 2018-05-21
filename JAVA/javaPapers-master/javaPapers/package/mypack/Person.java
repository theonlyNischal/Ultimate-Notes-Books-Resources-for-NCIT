package mypack;
public class Person
{
  String name,address;
  double balance;
  
  public void setInfo(String n,String a, double b)
  {
    name=n;
    address=a;
    balance=b;
  }
  public void showInfo()
  {
    System.out.println("Name: "+name);
    System.out.println("Address: "+address);
    System.out.println("Balance: "+balance);
  }
}
  