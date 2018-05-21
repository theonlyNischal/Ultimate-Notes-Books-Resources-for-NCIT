//Creating a TCP client/server Application
import java.io.*;
import java.net.*;
class TCPServer
{
  public static void main(String args[])throws Exception
  {
    String s1,s2;
    ServerSocket ss=new ServerSocket(6789);
	//accept connection to the client
    Socket s=ss.accept();

   //create input stream with the client and read from it
    BufferedReader fromClient=new BufferedReader(new InputStreamReader					(s.getInputStream()));
    s1=fromClient.readLine();
    System.out.println("From Client: "+s1);
    
    //now type something for response from the keyboard
    BufferedReader br=new BufferedReader(new InputStreamReader			                                        (System.in));
    s2=br.readLine();
    
   //create output stream with the client and send the typed value
    DataOutputStream toClient=new DataOutputStream									(s.getOutputStream());
    toClient.writeBytes(s2+"\n");
    //close the connection to the client
    s.close();
  }
}
}

  
 /*
//to communicate until exit 
  public static void main(String args[])throws Exception
  {
    String clientSentence,serverSentence;
    
    ServerSocket welcomeSocket=new ServerSocket(6789);
    Socket connectionSocket=welcomeSocket.accept();
    BufferedReader fromClient=new BufferedReader(new InputStreamReader                                   (connectionSocket.getInputStream()));
    BufferedReader br=new BufferedReader(new InputStreamReader                                                       (System.in));
    DataOutputStream toClient=new DataOutputStream                               (connectionSocket.getOutputStream());
     while(true)
    {
 	  
    clientSentence=fromClient.readLine();
    if(clientSentence.equalsIgnoreCase("Bye"))
       break;

    System.out.println("From Client: "+clientSentence);
    System.out.print("Server: ");
    serverSentence=br.readLine();
    toClient.writeBytes(serverSentence+"\n");
    } 
    welcomeSocket.close();
    connectionSocket.close();
    fromClient.close();
    toClient.close();
  }
*/  
}

    