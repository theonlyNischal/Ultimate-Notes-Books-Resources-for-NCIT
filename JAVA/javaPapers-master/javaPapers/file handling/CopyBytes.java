import java.io.*;
class CopyBytes
{
  public static void main(String args[])throws IOException
  {
    FileOutputStream fout=new FileOutputStream("test1");
    FileInputStream fin=new FileInputStream("test");
    
    int c;
    while((c=fin.read())!=-1)
      fout.write((byte)c);
    System.out.println("Successfully copied");
    fin.close();
    fout.close();
  }
}
    