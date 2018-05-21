import java.net.*;
import java.io.*;

public class ChatClient
{
  public static void main(String args[])throws Exception
  {
    Socket client=new Socket("nd",10007);
    BufferedReader input=new BufferedReader(new InputStreamReader(client.getInputStream()));
    PrintWriter output=new PrintWriter(client.getOutputStream());
    
    BufferedReader userInput=new BufferedReader(new InputStreamReader(System.in));
    String line;
    String line1;
    while((line=userInput.readLine())!=null)
    {
      output.println(line);
      output.flush();
      line1=input.readLine();
      System.out.println("Server: "+line1);
      
      if(line.equals("bye"))
        break;
    }
    client.close();
    input.close();
    userInput.close();
    output.close();
  }
}
      
