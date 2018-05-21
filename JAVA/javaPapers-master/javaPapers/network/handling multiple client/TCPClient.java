import java.io.*;
import java.net.*;
class TCPClient
{
 /* public static void main(String args[])throws Exception
  {
    String sentence,modifiedSentence;
    Socket clientSocket=new Socket("nd",6789);
   
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    sentence=br.readLine();
    
    DataOutputStream toServer=new DataOutputStream(clientSocket.getOutputStream());
    toServer.writeBytes(sentence+"\n");
    
    BufferedReader fromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    modifiedSentence=fromServer.readLine();
    
    System.out.println("From Server: "+modifiedSentence);
    clientSocket.close();
  }
  
  */
//to communicate until exit
   public static void main(String args[])throws Exception
  {
    String clientSentence,serverSentence;
    Socket clientSocket=new Socket("nd",6789);
   
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    
DataOutputStream toServer=new DataOutputStream          (clientSocket.getOutputStream());

BufferedReader fromServer=new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    
    while(true)
    {
	System.out.print("Client: ");
        clientSentence=br.readLine();
    	toServer.writeBytes(clientSentence+"\n");
    
    	serverSentence=fromServer.readLine();
    	if(serverSentence.equalsIgnoreCase("Bye"))
		break;
    
   System.out.println("From Server: "+serverSentence);
   
     }
     clientSocket.close();
     fromServer.close();
     toServer.close();
   }
}

    