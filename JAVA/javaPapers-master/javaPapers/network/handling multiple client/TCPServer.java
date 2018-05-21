import java.io.*;
import java.net.*;
class TCPServer
{
 /* public static void main(String args[])throws Exception
  {
    String clientSentence,modifiedSentence;
    ServerSocket welcomeSocket=new ServerSocket(6789);
    Socket connectionSocket=welcomeSocket.accept();
   
    BufferedReader fromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
    clientSentence=fromClient.readLine();
    System.out.println("From Client: "+clientSentence);
    
   
    
   BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    modifiedSentence=br.readLine();
    
    DataOutputStream toClient=new DataOutputStream(connectionSocket.getOutputStream());
    toClient.writeBytes(modifiedSentence+"\n");
    
    connectionSocket.close();
  }
  
  */
//to communicate until exit 
  public static void main(String args[])throws Exception
  {
    String clientSentence,serverSentence;
    
    ServerSocket welcomeSocket=new ServerSocket(6789);
    Socket connectionSocket=welcomeSocket.accept();

 BufferedReader fromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
    
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

DataOutputStream toClient=new DataOutputStream               (connectionSocket.getOutputStream());
     
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
  
}

    