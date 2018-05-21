import java.io.*;
class WriteBytes
{
  public static void main(String args[])throws IOException
  {
   File f1=new File("f:/test");
    f1.mkdir();
    FileOutputStream fout=new FileOutputStream("f:/test/person");
    String str="this is a way of writing bytes to the file";
    byte b[]=str.getBytes();
    fout.write(b);
    System.out.println("Data written to file");
    fout.close();
  }
}
    