import java.io.*;
class WriteMany
{
  public static void main(String args[])throws IOException
  {
    FileOutputStream fout=new FileOutputStream("writemany.txt");
    DataOutputStream dout=new DataOutputStream(fout);
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    int id;
    String name;
    double salary;
    
    for(int i=1;i<=3;i++)
    {
      System.out.println("Enter id:");
      id=Integer.parseInt(br.readLine());
      System.out.println("Enter name:");
      name=br.readLine();
      System.out.println("Enter salary:");
      salary=Double.parseDouble(br.readLine());
      dout.writeInt(id);
      dout.writeUTF(name);
      dout.writeDouble(salary);
     }
    dout.close();
    fout.close();
    
    boolean EOF=false;
    FileInputStream fin=new FileInputStream("writemany.txt");
    DataInputStream din=new DataInputStream(fin);
    while(!EOF)
    {
      try{
      id=din.readInt();
      name=din.readUTF();
      salary=din.readDouble();
      System.out.println(id+"\t"+name+"\t"+salary);
      }
      catch(EOFException e)
      {EOF=true;}
    }
    din.close();
    fin.close();
    
  }
}