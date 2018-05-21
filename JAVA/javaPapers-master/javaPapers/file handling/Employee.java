import java.io.*;
class Employee implements Serializable
{
  private int id;
  private String name;
  
  public void setId(int id)
  {
    this.id=id;
  }
  public void setName(String name)
  {
    this.name=name;
  }
  
  public int getId()
  {
    return id;
  }
  public String getName()
  {
    return name;
  }
}


class ReadWriteObjects
{
  public static void main(String args[])throws IOException, ClassNotFoundException
  {
    
    Employee e1=new Employee();
   
    e1.setId(3);
    e1.setName("Hari");
    
    
    ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("emp.txt"));
    oos.writeObject(e1);
    
    oos.close();
    
    ObjectInputStream oin=new ObjectInputStream(new FileInputStream("emp.txt"));
    
    Employee em=(Employee)oin.readObject();
    System.out.println("ID: "+em.getId());
    System.out.println("Name: "+em.getName());
    oin.close();
  }
}
    
  