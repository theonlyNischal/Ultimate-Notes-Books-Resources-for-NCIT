import java.io.*;
class WriteChar
{
  public static void main(String args[])throws IOException
  {
    FileWriter fr=new FileWriter("hello");
    String str="This is file handling using character stream";
    fr.write(str);
    System.out.println("Data written to file");
    fr.close();
  }
}
      