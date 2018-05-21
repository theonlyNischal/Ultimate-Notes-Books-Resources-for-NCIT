import java.io.*;
class CopyChar
{
  public static void main(String args[])throws IOException
  {
    FileReader fr=new FileReader("hello");
    BufferedReader br=new BufferedReader(fr);
    
    FileWriter fw=new FileWriter("hellooo");
    String str;
    
    while((str=br.readLine())!=null)
      fw.write(str);
    System.out.println("Copied Successfully");
    
    br.close();
    fr.close();
    fw.close();
  }
}