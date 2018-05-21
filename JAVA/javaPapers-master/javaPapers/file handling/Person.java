import java.io.*;
class Person implements Serializable
{
  String name;
  Person()
  {
  }
  void setName(String n)
  {
    this.name=n;
  
  }
  String  getName()
  {
    return this.name;
  }
}
class WriteObject
{
  public static void main(String args[])throws IOException,ClassNotFoundException
  {
    FileInputStream fin=new FileInputStream("wobj");
    ObjectInputStream oin=new ObjectInputStream(fin);
    boolean EOF=false;
    while(!EOF){try{
    Person p2=(Person)oin.readObject();
    System.out.println(p2.getName());
    }catch(Exception e){EOF=true;}}
 //   Person p3=(Person)oin.readObject();
   // System.out.println(p3.getName());
    
    oin.close();
    fin.close();
    
  }
}
            