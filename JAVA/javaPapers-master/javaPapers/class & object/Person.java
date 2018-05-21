class Person
{
  private String name,address;
  private double salary;
  
  Person(String name, String address, double salary)
  {
    this.name=name;
    this.address=address;
    this.salary=salary;
  }
  Person(Person p)
  {
    name=p.name;
    address=p.address;
    salary=p.salary;
  }
  void showInfo()
  {
    System.out.println("Name: "+name);
    System.out.println("Address: "+address);
    System.out.println("Salary: "+salary);
  }
}
class PersonDemo
{
  public static void main(String args[])
  {
    Person p1=new Person("Ram","Ktm",3000);
    //p1.setInfo("Ram","Ktm",3000);
    p1.showInfo();
    
    Person p2=new Person(p1);
   // p2.setInfo("Shyam","Bkt",5000);
    p2.showInfo();
  }
}
      