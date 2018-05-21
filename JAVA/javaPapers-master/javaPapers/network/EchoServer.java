import java.net.*;
import java.io.*;

public class EchoServer
{
 public static void main(String args[])throws IOException
  {
    ServerSocket serverSock=null;
    try{
      serverSock=new ServerSocket(10007);
    }
    catch(IOException e)
    {
      System.out.println("Can't listen on 10007"); 
      System.exit(0);
    }
    Socket s=null;
    System.out.println("Listening for connection...");
    try
    {
     s=serverSock.accept();
    }
    catch(IOException e)
    {
 System.out.println("Accept failed");
 System.exit(0);
    }
    System.out.println("Connection Successful.");
    System.out.println("Listening for input...");
    PrintStream output=new PrintStream(s.getOutputStream());
    BufferedReader input=new BufferedReader(new InputStreamReader(s.getInputStream()));
    String inputLine;
    while((inputLine=input.readLine())!=null)
    { 
 System.out.println("From Client: "+inputLine);
        output.println(inputLine);
        if(inputLine.equals("Bye"))
          break;
    }
    output.close();
    input.close();
    s.close();
    serverSock.close();
  }
}

