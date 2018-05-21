import java.io.*;
import java.net.*;
class TCPClient1
{
	public static void main(String args[])throws Exception
	{
		String clientSentence,modifiedSentence;
		
		InetAddress IPAddress=InetAddress.getByName("localhost");
		Socket connectionSocket=new Socket(IPAddress,6789);
		

BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
clientSentence=br.readLine();		
DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream());
outToClient.writeBytes(clientSentence);
	
		
BufferedReader inFromServer=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));



modifiedSentence=inFromServer.readLine();
System.out.println("From Server: "+modifiedSentence);



connectionSocket.close();
}


}
