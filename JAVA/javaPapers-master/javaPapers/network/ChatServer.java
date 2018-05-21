//serving multiple clients
import java.net.*;
import java.io.*;

public class ChatServer
{
  public static void main(String args[])throws Exception
  {
       ServerSocket server=new ServerSocket(10007);
    while(true)
    {
      Socket sock=server.accept();
      Runnable r=new ThreadedEchoHandler(sock);
      Thread t=new Thread(r);
      t.start();
    }
    
  }
}
class ThreadedEchoHandler implements Runnable
{
  Socket incoming;
  
  ThreadedEchoHandler(Socket s)
  {
    incoming=s;
  }
  public void run()
  {
    try{
      BufferedReader input=new BufferedReader(new InputStreamReader(incoming.getInputStream()));
      PrintWriter output=new PrintWriter(incoming.getOutputStream());
      
      
      String line;
     
      while((line=input.readLine())!=null)
      {
        System.out.println("From client: "+line);
        if(line.equals("bye"))
          break;
        output.println("Enter bye to exit");
        output.flush();
      }
      incoming.close();
    }
    catch(IOException e)
      {
        System.out.println(e);
      }
        
    }
  }
           
              
      
                                              

    