import java.io.*;
import java.net.*;
class TCPClient
{
  public static void main(String args[])throws Exception
  {
    String s1,s2;
    Socket s=new Socket("nd",6789); //server name or IP and Port number
   
   //type something from keyboard to send to the server
    BufferedReader br=new BufferedReader(new InputStreamReader                                                 (System.in));
    s1=br.readLine();
    
	//create output stream and send the typed data
    DataOutputStream toServer=new DataOutputStream(s.getOutputStream());
    toServer.writeBytes(s1+"\n");
    
	//create input stream with the server and read the data from it
    BufferedReader fromServer=new BufferedReader(new InputStreamReader(s.getInputStream()));
    s2=fromServer.readLine();
    
    System.out.println("From Server: "+s2);
    //close connection to the server
	s.close();
  }
}  
  
/*to communicate until exit
   public static void main(String args[])throws Exception
  {
    String clientSentence,modifiedSentence;
    Socket clientSocket=new Socket("nd",6789);
   
    BufferedReader br=new BufferedReader(new InputStreamReader                                            (System.in));
    DataOutputStream toServer=new DataOutputStream                               (clientSocket.getOutputStream());
    BufferedReader fromServer=new BufferedReader(new InputStreamReader				(clientSocket.getInputStream()));
    
    while(true)
    {
	System.out.print("Client: ");
        clientSentence=br.readLine();
    	toServer.writeBytes(clientSentence+"\n");
    
    	modifiedSentence=fromServer.readLine();
    	if(modifiedSentence.equalsIgnoreCase("Bye"))
		break;
    
         System.out.println("From Server: "+modifiedSentence);
    
     }
     clientSocket.close();
     fromServer.close();
     toServer.close();
   }
}*/

    